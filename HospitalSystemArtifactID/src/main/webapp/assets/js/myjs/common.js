
$.quit = function (path) {
    console.log(path);
    $.ajax({
        url: path + "/quit",
        success : function () {
            window.location.href = path + "/login";
        }
    })
}