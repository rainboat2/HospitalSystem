function fillTable(table, data){
    console.log(data);
    for (let element of data){
        const row = table.insertRow();
        row.onclick =Function("selectPatient(this);");
        const array = [element.medicalNo, element.regId, element.name, element.age];
        for (let i = 0; i < array.length; i++){
            const cell = row.insertCell();
            const text = document.createTextNode(array[i]);
            cell.appendChild(text);
        }
    }
}

function addRowForDiagnose() {
    const table = document.getElementById("diagnose-table");
    if (table.incrementId === undefined)
        table.incrementId = 1;
    const id = table.incrementId;

    console.log();
    const row = table.insertRow();
    row.setAttribute("id", id + "-row");

    // checkbox, ICD编码, 疾病名称, 发病时间
    const cell = row.insertCell();
    cell.appendChild(generateCheckbox(id, "diagnose-table"));
    row.insertCell().setAttribute("id", id + "-icd");
    row.insertCell().setAttribute("id", id + "-name");
    row.insertCell();

    row.childNodes[2].setAttribute("contentEditable", "true");
    row.childNodes[3].setAttribute("contentEditable", "true");
    setAutoComplete(id);

    table.incrementId = id + 1;
}

function setAutoComplete(id) {
    $("#" + id + "-name").autocomplete({
        source: function (request, response) {
            $.ajax({
                type: "get",
                url: $.pagePath + "/getDiseaseInfo",
                data: {"term" : request.term},
                success: function (result) {
                    response($.map(result, function (item) {
                        return {
                            value : item.name,
                            label : item.name,
                            icd : item.icd
                        }
                    }));
                }
            })
        },
        select: function (event, ui) {
            const td = $("#" + id + "-icd")[0];
            if (td.firstChild === null)
                td.appendChild(document.createTextNode(""));
            td.firstChild.nodeValue = ui.item.icd;
        }
    })
}


function deleteRow(table) {
    const rows = table.rows;
    for (let i = rows.length-1; i >= 1; i--){
        const cell = rows[i].cells[0];
        const input = cell.firstChild.firstChild;
        if (input.checked)
            table.deleteRow(i);
    }
}

function selectPatient(tr){
    const tds = tr.childNodes;
    const medicalNo = tds[0].firstChild.nodeValue;
    const regId = tds[1].firstChild.nodeValue;
    const name = tds[2].firstChild.nodeValue;
    const age = tds[3].firstChild.nodeValue;
    const patientInfo = document.getElementById("patient-info");
    patientInfo.firstChild.nodeValue = "病历号: " + medicalNo + " 姓名: " + regId + "姓名: " + name + " 年龄: " + age;

    const inputRegId = document.getElementById("form-regId");
    inputRegId.setAttribute("value", regId);
}

function getPatient() {
    $.ajax({
        url: $.pagePath + "/getPatientForDoctor",
        type: "get",
        dataType: "json",
        success: function(rs){
            console.log(rs);
            fillTable(document.getElementById("wait-for-diagnose"), rs.waitForDiagnose);
            fillTable(document.getElementById("diagnosed"), rs.diagnosed);
        }
    });
}

function hold() {
    const regId = document.getElementById("form-regId").value;
    window.localStorage.setItem(regId, $("#medical-record").serialize());
}

function submit() {
    var medicalRecord = $.serializeJson($('#medical-record').serializeArray());
    if (! checkMedicalRecord(medicalRecord))
        return false;
    medicalRecord.committed = true;
    medicalRecord.diagnoses = "";
    medicalRecord.type = $("#type")[0].value;
    medicalRecord.checkType = medicalRecord.type;
    medicalRecord.checkAdv = "无";
    console.log(medicalRecord);
    $.ajax({
        type: "post",
        dataType: "json",
        url: $.pagePath + "/see",
        data: JSON.stringify(medicalRecord),
        contentType : 'application/json',
        success: function (rs) {
            console.log(rs);
            if (rs.success === true){
                window.alert("提交成功");
            } else
                window.alert("提交失败");
        },
        error: function () {
            window.alert("异常");
        }
    })
}

function checkMedicalRecord(form) {
    console.log(form);
    const err = document.getElementById("err-message");

    if (err.firstChild === null)
        err.appendChild(document.createTextNode(""));

    if (form.regId === undefined || form.regId === ""){
         err.firstChild.nodeValue = "未选择病人";
         return false;
    }

    if (form.allergy === "" || form.checkAdvice === "" || form.chiefComplaint ==="" ||
        form.healthCheckup === "" || form.note === "" || form.presentIll === "" ||
        form.treatmentPresIll === ""){
        err.firstChild.nodeValue = "输入的内容不能为空";
        return false;
    }
    return true;
}

function clearAll() {
    $(':input','#medical-record')
        .not(':button, :submit, :reset, :hidden')
        .val('')
        .removeAttr('checked')
        .removeAttr('selected');

    // 清空表格
    clearTable($("#diagnose-table")[0]);
}



function flush(){
    const err = document.getElementById("err-message");
    err.firstChild.nodeValue = "";
}

function addPrescription() {
    const table = $("#prescription")[0];
    if (table.incrementId === undefined)
        table.incrementId = 1;

    const row = table.insertRow();
    // 使用一个对象保存每个处方所在行的id，以及对应的处方明细的信息
    row.onclick = Function("changePrescription(this);");
    row.setAttribute("id", table.incrementId + "-prescription-row");
    prescriptions[row.getAttribute("id")] = [];

    row.insertCell().appendChild(generateCheckbox(table.incrementId, "prescription"));
    row.insertCell();
    row.insertCell().appendChild(document.createTextNode("暂存"));
    row.childNodes[1].setAttribute("contentEditable", "true");

    table.incrementId = table.incrementId + 1;
    return row;
}

function addPrescriptionDetail(){
    if (cur === null){
        $("#medical-error-message").text("未选中处方");
        return ;
    }
    const table = $("#prescription-detail")[0];
    if (table.incrementId === undefined)
        table.incrementId = 1;
    const id = table.incrementId;
    const row = table.insertRow();
    const postfix = id + "-prescription-detail-";
    // checkbox 药品id 药品名称 规格 单价 用法 计量 频次 数量
    row.insertCell().appendChild(generateCheckbox(id, "prescription-detail"));
    row.insertCell().setAttribute("id", postfix + "id");
    row.insertCell().setAttribute("id", postfix + "name");
    row.insertCell().setAttribute("id", postfix + "format");
    row.insertCell().setAttribute("id", postfix + "price");
    row.insertCell();  // 用法
    row.insertCell().setAttribute("id" , postfix + "dosage");
    row.insertCell().setAttribute("id", postfix + "frequency");
    row.insertCell().setAttribute("id", postfix + "number_per");

    table.incrementId = id + 1;

    for (let td of row.cells)
        if (td.firstChild === null)
            td.appendChild(document.createTextNode(""));

    row.cells[2].setAttribute("contentEditable", "true");
    row.cells[5].setAttribute("contentEditable", "true");
    row.cells[6].setAttribute("contentEditable", "true");
    row.cells[7].setAttribute("contentEditable", "true");
    row.cells[8].setAttribute("contentEditable", "true");

    $("#" + postfix + "name").autocomplete({
        source: function (request, response) {
            $.ajax({
                type: "get",
                url: $.pagePath + "/getDrugs",
                data: {"term" : request.term},
                success: function (rs) {
                    response($.map(rs, function (item) {
                        return {
                            value : item.name,
                            label : item.name,
                            drugId : item.drug_id,
                            format : item.format,
                            price : item.price
                        }
                    }))
                },
            });
        },
        select: function (event, ui) {
            $("#" + postfix + "id")[0].firstChild.nodeValue = ui.item.drugId;
            $("#" + postfix + "format")[0].firstChild.nodeValue = ui.item.format;
            $("#" + postfix + "price")[0].firstChild.nodeValue = ui.item.price;
        }
    })
    return row;
}

prescriptions = {};
cur = null;  // 当前被选中的处方

function changePrescription(tr){
    $("#medical-error-message").text("");
    const id = tr.getAttribute("id");
    const prescriptionDetail = $("#prescription-detail");
    if (cur !== null){
        // 保存当前的处方明细
        prescriptions[cur] = tableToArray(prescriptionDetail);
        clearTable(prescriptionDetail[0]);
    }
    cur = id;
    if (prescriptions[cur] !== undefined)
        fillPrescriptionDetail(prescriptions[cur]);
}

function fillPrescriptionDetail(array) {
    for (let row of array){
        const tr = addPrescriptionDetail();
        for (let i = 0; i < row.length; i++)
            tr.cells[i].firstChild.nodeValue = row[i];
    }
}

function deletePrescription(){
    const table = $("#prescription")[0];
    const rows = table.rows;
    for (let i = rows.length-1; i >= 1; i--){
        const cell = rows[i].cells[0];
        const input = cell.firstChild.firstChild;
        if (!input.checked)
            continue;
        const id = rows[i].getAttribute("id");
        table.deleteRow(i);

        // 删除处方对应的处方明细
        prescriptions[id] = undefined;
        // 当处方明细表显示的为被删除的处方，将表格清空，cur变为null
        if (cur === id){
            cur = null;
            clearTable($("#prescription-detail")[0]);
        }
    }
}

function hiddenPatientPanel() {
    const patient = $("#patient-panel")[0];
    const work = $("#work-panel")[0];
    const button = $("#hidden-button")[0];
    if (patient.style.display === "none"){
        // 显示患者面板
        patient.style.display = "";
        work.classList.remove("col-md-12");
        work.classList.add("col-md-8");
        button.setAttribute("value", "隐藏患者栏");
    }else{
        // 将患者面板设为隐藏
        patient.style.display = "none";
        work.classList.remove("col-md-8");
        work.classList.add("col-md-12");
        button.setAttribute("value", "显示患者栏");
    }
}

// 开立
function prescribe() {
    // 保存当前的处方
    let message;
    if (cur !== null)
        prescriptions[cur] = tableToArray($("#prescription-detail"));

    const regId = $("#form-regId")[0].value;
    // 查看是否选中病人
    if ( regId === null || regId === ""){
        $("#medical-error-message").text("未选中病人");
        return;
    }

    const table = $("#prescription")[0];
    const rows = table.rows;
    let hasSelected = false;
    for (let i = rows.length-1; i >= 1; i--){
        const cell = rows[i].cells[0];
        const input = cell.firstChild.firstChild;
        if (!input.checked)
            continue;
        hasSelected = true;
        message = message + prescribeRow(rows[i]) + "\n";
    }
    if (!hasSelected)
        message = "没有选中处方";
    if (!isNaN(message))
        $("#medical-error-message").text(message);
}

function prescribeRow(tr) {
    const name = tr.cells[1].firstChild.nodeValue;
    const state = tr.cells[2].firstChild.nodeValue;

    if (state !== "暂存")
        return "处方" + name + "开立失败, 原因：状态为" + state + "的处方不能开立";

    const id = tr.getAttribute("id");
    const detail = formatDetail(prescriptions[id]);
    const data = {
        regId : $("#form-regId")[0].value,
        presName : name,
        type : "西医诊断",
        presList : detail,
        len : prescriptions[id].length,
        presId : -1,
        success : false
    };

    console.log(data);
    $.ajax({
        type: "post",
        dataType: "json",
        contentType: 'application/json',
        url: $.pagePath + "/prescribeDrugs",
        data: JSON.stringify(data),
        success: function (rs) {
            if (rs.success){
                tr.cells[2].firstChild.nodeValue = "开立";
            } else
                window.alert("处方" + name + "开立失败");
        },
        error: function () {
            window.alert("由于未知原因，处方" + name + "开立失败");
        }
    })
}

// 处方明细格式 [0:checkbox 1:药品id 2:药品名称 3:规格 4:单价 5:计量 6:频次 7:数量 8:用法]
// 服务器需求格式:
// pres_list: row1-row2-row3
// row: drug_id,amount,dosage,frequency,number_per,usage
function formatDetail(detail){
    let presList = "";
    for (let d of detail){
        const row = d[1] + "," + d[7] + "," + d[5] + "," + d[6] + "," + d[7] + "," + d[8];
        // 避免最后结果以“-”开头
        if (presList === "")
            presList = row;
        else
            presList = presList + "-" + row;
    }
    return presList;
}

function endDiagnose() {
    const regId = $("#form-regId")[0].value;
    if (regId === null || regId === "")
        window.alert("未选中病人");
    $.ajax({
        type: "get",
        dataType: "json",
        contentType: "application/json",
        data: {regId : regId},
        url: $.pagePath + "/endDiagnose",
        success: function (rs) {
            if (rs.success){
                clearTable($("#wait-for-diagnose")[0]);
                clearTable($("#diagnosed")[0]);
                getPatient();
                $("#form-regId")[0].value = "";
                $("#patient-info").text("患者信息");
            } else
                window.alert("操作失败");
        },
        error: function () {
            window.alert("异常");
        }
    })
}