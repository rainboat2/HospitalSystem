
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
}