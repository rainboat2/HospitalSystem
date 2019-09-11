function filltable(table, data){
    for (let element of data){
        const row = table.insertRow();
        for (let key of element){
            const cell = row.insertCell();
            const text = document.createTextNode(element[key]);
            cell.appendText(text);
            row.appendChild(cell);
        }
    }
}
