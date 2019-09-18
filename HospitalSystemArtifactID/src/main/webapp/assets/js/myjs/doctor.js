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

    // checkbox, ICD����, ��������, ����ʱ��
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

// <div class="be-checkbox be-checkbox-sm">
//     <input id="check1" type="checkbox">
//     <label for="check1"></label>
// </div>
function generateCheckbox(id, tableId){
    const div = document.createElement("div");
    div.classList.add("be-checkbox", "be-checkbox-sm");

    const input = document.createElement("input");
    input.setAttribute("id", id + "-check-" + tableId);
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
    patientInfo.firstChild.nodeValue = "������: " + medicalNo + " ����: " + regId + "����: " + name + " ����: " + age;

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
    medicalRecord.checkAdv = "��";
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
                window.alert("�ύ�ɹ�");
                getPatient();
            } else
                window.alert("�ύʧ��");
        },
        error: function () {
            window.alert("�쳣");
        }
    })
}

function checkMedicalRecord(form) {
    console.log(form);
    const err = document.getElementById("err-message");

    if (err.firstChild === null)
        err.appendChild(document.createTextNode(""));

    if (form.regId === undefined || form.regId === ""){
         err.firstChild.nodeValue = "δѡ����";
         return false;
    }

    if (form.allergy === "" || form.checkAdvice === "" || form.chiefComplaint ==="" ||
        form.healthCheckup === "" || form.note === "" || form.presentIll === "" ||
        form.treatmentPresIll === ""){
        err.firstChild.nodeValue = "��������ݲ���Ϊ��";
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

    // ��ձ��
    clearTable($("#diagnose-table")[0]);
}

function clearTable(table) {
    const rows = table.rows;
    console.log(rows.length);
    for (let i = rows.length-1; i >=1; i--)
        table.deleteRow(i);
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
    // ʹ��һ�����󱣴�ÿ�����������е�id���Լ���Ӧ�Ĵ�����ϸ����Ϣ
    row.onclick = Function("changePrescription(this);");
    row.setAttribute("id", table.incrementId + "-prescription-row");
    prescriptions[row.getAttribute("id")] = [];

    row.insertCell().appendChild(generateCheckbox(table.incrementId, "prescription"));
    row.insertCell();
    row.insertCell().appendChild(document.createTextNode("�ݴ�"));
    row.childNodes[1].setAttribute("contentEditable", "true");

    table.incrementId = table.incrementId + 1;
    return row;
}

function addPrescriptionDetail(){
    if (cur === null){
        $("#medical-error-message").text("δѡ�д���");
        return ;
    }
    const table = $("#prescription-detail")[0];
    if (table.incrementId === undefined)
        table.incrementId = 1;
    const id = table.incrementId;
    const row = table.insertRow();
    const postfix = id + "-prescription-detail-";
    // checkbox ҩƷid ҩƷ���� ��� ���� �÷� ���� Ƶ�� ����
    row.insertCell().appendChild(generateCheckbox(id, "prescription-detail"));
    row.insertCell().setAttribute("id", postfix + "id");
    row.insertCell().setAttribute("id", postfix + "name");
    row.insertCell().setAttribute("id", postfix + "format");
    row.insertCell().setAttribute("id", postfix + "price");
    row.insertCell();  // �÷�
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

// ��tableת��ΪArray����
function tableToArray(table) {
    let i = 0, j = 0;
    const rs = [];
    table.find("tr").each(function(){
        const row = [];
        j = 0;
        $(this).find("td").each(function(){
            row[j] = $(this).text();
            j++;
        });
        // ������ͷ
        if (i !== 0) rs[i-1] = row;
        i++;
    });
    console.log(rs);
    return rs;
}

prescriptions = {};
cur = null;  // ��ǰ��ѡ�еĴ���

function changePrescription(tr){
    $("#medical-error-message").text("");
    const id = tr.getAttribute("id");
    const prescriptionDetail = $("#prescription-detail");
    if (cur !== null){
        // ���浱ǰ�Ĵ�����ϸ
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
    const table = $("#prescription");
    const rows = table.rows;
    for (let i = rows.length-1; i >= 1; i--){
        const cell = rows[i].cells[0];
        const input = cell.firstChild.firstChild;
        if (!input.checked)
            continue;
        table.deleteRow(i);
        const id = rows[i].getAttribute("id");
        
    }
}