<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/img/logo-fav.png">
    <title>HIS</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/lib/perfect-scrollbar/css/perfect-scrollbar.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/lib/material-design-icons/css/material-design-iconic-font.min.css"/><!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css" type="text/css"/>
</head>
<body class="be-splash-screen">
<div class="be-wrapper be-login">
    <div class="be-content">
        <div class="main-content container-fluid">
            <div class="splash-container">
                <div class="panel panel-default panel-border-color panel-border-color-primary">
                    <div class="panel-heading"><img src="${pageContext.request.contextPath}/assets/img/logo-xx.png" alt="logo" width="102" height="27" class="logo-img">
                        <span class="splash-description">请输入用户登陆信息</span>
                    </div>
                    <div class="panel-body">
                        <form id = "loginForm" name = "loginForm" onsubmit="return false" action="${pageContext.request.contextPath}/userLogin" method="Post">
                            <div class="form-group">
                                <input id="userId" name = "userId" type="text" placeholder="用户id" class="form-control">
                            </div>
                            <div class="form-group">
                                <input id="password" name = "password" type="password" placeholder="密码" class="form-control">
                            </div>
                            <div class="form-group">
                                <select id = "userType" name = "userType" class="form-control">
                                    <option value="0">管理员</option>
                                    <option value="1">收费员</option>
                                    <option value="2">门诊医生</option>
                                    <option value="3">医技医生</option>
                                    <option value="4">药房发药员</option>
                                </select>
                            </div>
                            <p id = "err" style="color:Red;"></p>
                            <div class="form-group row login-tools">
                                <div class="col-xs-6 login-remember">
                                    <div class="be-checkbox">
                                        <input type="checkbox" id="remember">
                                        <label for="remember">记住我</label>
                                    </div>
                                </div>
                                <div class="col-xs-6 login-forgot-password"><a href="#">忘记密码？</a></div>
                            </div>
                            <div class="form-group login-submit">
                                <button data-dismiss="modal" type="submit" onclick="login()" class="btn btn-primary btn-xl">登陆</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/assets/lib/jquery/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/lib/perfect-scrollbar/js/perfect-scrollbar.jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/main.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/lib/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>

<script type="text/javascript">
    $(document).ready(function(){
        //initialize the javascript
        App.init();
    });

    function validateForm() {
        const id = document.forms["loginForm"]["userId"].value;
        const password = document.forms["loginForm"]["password"].value;
        const reg = /^[1-9]\d*$/;
        if (id === null || !reg.test(id)){
            document.getElementById("err").innerText = "用户id必需为非零开头数字";
            return false;
        }
        if (password === null || password === ""){
            document.getElementById("err").innerText = "用户密码不能为空";
            return false;
        }
        return true;
    }

    // 异步请求数据
    function login() {
        if (!validateForm())
            return;
        const formData = $('#loginForm').serialize();
        console.log(formData);
        $.ajax({
            type: 'POST',
            dataType: 'json', //预期服务器返回的数据类型
            url: "${pageContext.request.contextPath}/userLogin" ,
            data:  formData,
            success: function (result) {
                console.log(result);
                if (result.success === 'true') {
                    alert("SUCCESS");
                }else{
                    document.getElementById("err").innerText = "用户名或密码错误";
                }
            },
            error : function() {
                alert("异常！");
            }
        });
    }

</script>
</body>
</html>
