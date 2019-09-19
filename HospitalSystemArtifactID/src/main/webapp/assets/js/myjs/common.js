
$.quit = function (path) {
    console.log(path);
    $.ajax({
        url: path + "/quit",
        success : function () {
            window.location.href = path + "/login";
        }
    })
};

$.serializeJson = function(array){
    var serializeObj={};
    $(array).each(function(){
        if(serializeObj[this.name]){
            if($.isArray(serializeObj[this.name])){
                serializeObj[this.name].push(this.value);
            }else{
                serializeObj[this.name]=[serializeObj[this.name],this.value];
            }
        }else{
            serializeObj[this.name]=this.value;
        }
    });
    return serializeObj;
};

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

function clearTable(table) {
    const rows = table.rows;
    for (let i = rows.length-1; i >=1; i--)
        table.deleteRow(i);
}

// 将table转化为Array对象
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
        // 跳过表头
        if (i !== 0) rs[i-1] = row;
        i++;
    });
    console.log(rs);
    return rs;
}