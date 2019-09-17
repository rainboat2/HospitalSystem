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

function addRow() {
    const table = document.getElementById("diagnose-table");
    if (table.incrementId === undefined)
        table.incrementId = 1;
    const id = table.incrementId;

    console.log();
    const row = table.insertRow();
    row.setAttribute("id", id + "-row");

    // checkbox, ICD编码, 疾病名称, 发病时间
    const cell = row.insertCell();
    cell.appendChild(generateCheckbox(id));
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

// <div class="be-checkbox be-checkbox-sm">
//     <input id="check1" type="checkbox">
//     <label for="check1"></label>
// </div>
function generateCheckbox(id){
    const div = document.createElement("div");
    div.classList.add("be-checkbox", "be-checkbox-sm");

    const input = document.createElement("input");
    input.setAttribute("id", id + "-check");
    input.setAttribute("type", "checkbox");

    const label = document.createElement("label");
    label.setAttribute("for", input.getAttribute("id"));

    div.appendChild(input);
    div.appendChild(label);
    return div;
}

function deleteRow(table) {
    const rows = table.rows;
    for (let i = 1; i < rows.length; i++){
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
    const medicalRecord = $.serializeJson($('#medical-record').serializeArray());
    if (! checkMedicalRecord(medicalRecord))
        return false;
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
    const table = $("#diagnose-table")[0];
    const rows = table.rows;
    for (let i = 1; i < rows.length; i++)
        table.deleteRow(i);
}

function flush(){
    const err = document.getElementById("err-message");
    err.firstChild.nodeValue = "";
}