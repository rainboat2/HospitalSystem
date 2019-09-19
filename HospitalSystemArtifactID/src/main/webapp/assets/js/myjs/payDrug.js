// 根据病历号，查找所有对应的开立药品
function getDrugs(state) {
    if (!check_Medical_no())
        return;
    const data = {
        medicalNo : document.getElementById("medicalNo").value,
        state : state
    };
    $.ajax({
        type: 'get',
        dataType: 'json',
        url: $.pagePath + "/getPrescriptionDrugs",
        data: data,
        success: function (result) {
            console.log(result);
            if (result["name"] == null)
                $("#finder-err").text("找不到患者！");
            else{
                clearTable($("#drug-table")[0]);
                fillDrugTable(result);
                $("#finder-err").text("");
                $("#name")[0].value = result.name;
                $("#idNumber")[0].value = result.idNumber;
                $("#address")[0].value = result.address;
            }
        },
        error : function() {
            alert("异常！");
        }
    });
}

function check_Medical_no() {
    const medicalNo = document.getElementById("medicalNo").value;
    const num = /^[1-9]\d*$/;
    const err = $("#finder-err");
    if (medicalNo === null || !num.test(medicalNo)){
        err.text("病历号必需为数字");
        return false;
    }
    err.text("");
    return true;
}

function selectAll(input) {
    const table = $("#drug-table")[0];
    const rows = table.rows;
    for (let i = 1; i < rows.length; i++){
        const cell = rows[i].cells[0];
        const inp = cell.firstChild.firstChild;
        inp.checked = input.checked;
    }
}

function fillDrugTable(result) {
    const drugs = result.drugs;
    const table = $("#drug-table")[0];
    if (table.incrementId === undefined)
        table.incrementId = 1;
    let id = table.incrementId;
    const medicalNo = result.medicalNo;
    const name = result.name;
    for (let drug of drugs){
        const row = table.insertRow();
        row.insertCell().appendChild(generateCheckbox(id, "drug-table"));
        row.insertCell().appendChild(document.createTextNode(medicalNo));
        row.insertCell().appendChild(document.createTextNode(name));
        row.insertCell().appendChild(document.createTextNode(drug.presDetailId));
        row.insertCell().appendChild(document.createTextNode(drug.name));
        row.insertCell().appendChild(document.createTextNode(drug.price));
        row.insertCell().appendChild(document.createTextNode(drug.amount));
        row.insertCell().appendChild(document.createTextNode(drug.state));
        id = id + 1;
    }
    table.incrementId = id;
}

function pay() {
    showDialog();
    $("#receivable")[0].value = countFee();
    $("#invoiceId")[0].value = 13412421342;
}

function countFee() {
    const table = $("#drug-table")[0];
    const rows = table.rows;
    const name = $("#pat-name")[0];
    const medical = $("#dialog-medicalNo")[0];

    let fee = 0;
    console.log(rows.length);
    presDetailIds = [];
    index = 0;
    for (let i = 1; i < rows.length; i++){
        const cell = rows[i].cells[0];
        const input = cell.firstChild.firstChild;
        if (!input.checked)
            continue;

        presDetailIds[index++] = +rows[i].cells[3].firstChild.nodeValue;

        medical.value = rows[i].cells[1].firstChild.nodeValue;
        name.value = rows[i].cells[2].firstChild.nodeValue;
        const price = +rows[i].cells[5].firstChild.nodeValue;
        const amount = +rows[i].cells[6].firstChild.nodeValue;
        console.log("price" + price);
        console.log("amount" + amount);
        fee = fee + price * amount;
        console.log(fee);
    }
    return fee;
}

function showDialog(){
    const dialog = $("#dialog")[0];
    dialog.style.display = "block";
    window.onclick = function (event) {
        if (event.target === dialog)
            dialog.style.display = "none";
    }
}

function setFormTableStyle() {
    const table = $("#form-table");
    table.find("tr").each(function () {
        let i = 0;
        this.style.height = "40px";
        $(this).find("td").each(function () {
            if (i % 2 === 0)
                this.style.width = "15%";
            else
                this.style.width = "35%";
            i++;
        })
    })
}

function cancel() {
    const dialog = $("#dialog")[0];
    if (dialog === null || dialog === undefined)
        return;
    dialog.style.display = "none";
}

function collectSelected() {
    const table = $("#drug-table")[0];
    const rows = table.rows;
    let presDetailIds = [];
    let index = 0;
    for (let i = 1; i < rows.length; i++){
        const cell = rows[i].cells[0];
        const input = cell.firstChild.firstChild;
        if (!input.checked)
            continue;
        presDetailIds[index++] = +rows[i].cells[3].firstChild.nodeValue;
    }
    return presDetailIds;
}

function changeState(state) {
    const data = {
        presDetailIds: stringify(collectSelected()),
        state: state
    };
    console.log(data);
    $.ajax({
        type: "get",
        contentType: "application/json",
        dataType: "json",
        url: $.pagePath + "/payFee",
        data: data,
        success: function (rs) {
            cancel();
            window.alert("成功");
            $("#getDrugs").trigger("click");
        },
        error: function () {
            window.alert("异常");
        }
    })
}

function stringify(arr) {
    console.log(arr);
    let rs = "";
    for (let i = 0; i < arr.length; i++){
        if (i === 0)
            rs = rs + arr[i];
        else
            rs = rs + "-" + arr[i];
    }
    return rs;
}