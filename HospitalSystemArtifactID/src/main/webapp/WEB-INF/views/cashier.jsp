<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/img/logo-fav.png">
    <title>HIS</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/style_me.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/lib/perfect-scrollbar/css/perfect-scrollbar.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/lib/material-design-icons/css/material-design-iconic-font.min.css"/>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/lib/datetimepicker/css/bootstrap-datetimepicker.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css" type="text/css"/>
</head>
<body>
<div class="be-wrapper be-fixed-sidebar">
    <!-- 顶部导航栏 -->
    <nav class="navbar navbar-default navbar-fixed-top be-top-header">
        <div class="container-fluid">
            <!-- 左上角log -->
            <div class="navbar-header">
                <a href="#" class="navbar-brand"></a>
            </div>

            <div class="be-right-navbar">
                <ul class="nav navbar-nav navbar-right be-user-nav">
                    <li class="dropdown">
                        <a href="#" data-toggle="dropdown" role="button" aria-expanded="false" class="dropdown-toggle">
                            <img src="${pageContext.request.contextPath}/assets/img/avatar.png" alt="Avatar">
                            <span class="user-name">${sessionScope.userId}</span>
                        </a>
                        <ul role="menu" class="dropdown-menu">
                            <li>
                                <div class="user-info">
                                    <div class="user-name">${sessionScope.userId}</div>
                                </div>
                            </li>
                            <li>
                                <a onclick="$.quit('${pageContext.request.contextPath}');return false;">
                                    <span class="icon mdi mdi-power"></span>注销
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <div class="page-title">收费员>>挂号</div>
            </div>
        </div>
    </nav>

    <!-- 左侧边导航栏 -->
    <div class="be-left-sidebar">
        <div class="left-sidebar-wrapper"><a href="#" class="left-sidebar-toggle">Dashboard</a>
            <div class="left-sidebar-spacer">
                <div class="left-sidebar-scroll">
                    <div class="left-sidebar-content">
                        <ul class="sidebar-elements">
                            <li class="divider">菜单</li>
                            <li class="parent"><a href="#"><i class="icon mdi mdi-face"></i><span>挂号收费</span></a>
                                <ul class="sub-menu">
                                    <li class="active"><a href="#">现场挂号</a>
                                    </li>
                                    <li><a href="${pageContext.request.contextPath}/withdrawRegistration">退号</a>
                                    </li>
                                    <li><a href="#">收费</a>
                                    </li>
                                    <li><a href="#">发票打印</a>
                                    </li>
                                    <li><a href="#">患者费用查询</a>
                                    </li>
                                    <li><a href="#">日结</a>
                                    </li>
                                    <li><a href="#">日结查询</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 页面主内容 -->
    <div class="be-content">
        <div class="main-content container-fluid">
            <div style="width: 49%;height: 100%;position:relative;float:left">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default panel-border-color panel-border-color-primary">
                            <div class="panel-heading panel-heading-divider">挂号信息</div>
                            <div class="panel-body">
                                <form id = "reg-form" name = "reg-form" action="#" onsubmit="return false"
                                      class="form-horizontal group-border-dashed">
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">患者姓名</label>
                                        <div class="col-sm-6">
                                            <input name = "patName" id = "patName"
                                                   type="text" placeholder="患者姓名" class="form-control input-sm">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">身份证号</label>
                                        <div class="col-sm-6">
                                            <input name = "patId" id = "patId"
                                                   type="text" placeholder="身份证号" class="form-control input-sm">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label xs-pt-20">性别</label>
                                        <div class="col-sm-6">
                                            <div class="be-radio-icon inline">
                                                <input type="radio" checked="checked" name="gender" value="female" id="gender-rad1">
                                                <label for="gender-rad1"><span class="mdi mdi-female"></span></label>
                                            </div>
                                            <div class="be-radio-icon inline">
                                                <input type="radio" name="gender" value = "male" id="gender-rad2">
                                                <label for="gender-rad2"><span class="mdi mdi-male-alt"></span></label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label"> 生日 </label>
                                        <div class="col-md-6 col-xs-7">
                                            <div data-min-view="2" data-date-format="yyyy-mm-dd" class="input-group date datetimepicker">
                                                <input name = "birthday" id = "birthday"
                                                       size="16" type="text" value="" class="form-control input-sm">
                                                <span class="input-group-addon btn btn-primary">
                                                    <i class="icon-th mdi mdi-calendar"></i>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">地址</label>
                                        <div class="col-sm-6">
                                            <input name = "address" id = "address" type="text"  class="form-control input-sm">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">是否打印</label>
                                        <div class="col-sm-6 xs-pt-5">
                                            <div class="switch-button switch-button-sm">
                                                <input name = "printed" id = "printed" type="checkbox" checked="">
                                                <span><label for="printed"></label></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="deptId" class="col-sm-3 control-label">科室名称</label>
                                        <div class="col-sm-6">
                                            <select id = "deptId" name = "deptId" class="form-control input-sm">
                                                <c:forEach items="${departmentList}" var="dept">
                                                    <option value="${dept.deptId}">${dept.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="reglCode" class="col-sm-3 control-label">挂号级别</label>
                                        <div class="col-sm-6">
                                            <select id = "reglCode" name = "reglCode" class="form-control input-sm">
                                                <c:forEach items="${registrationLevelList}" var="regl">
                                                    <option value="${regl.reglCode}">${regl.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="odId" class="col-sm-3 control-label">医生id</label>
                                        <div class="col-sm-4">
                                            <input name = "odId" id = "odId" readonly="readonly"
                                                   type="text" class="form-control input-sm">
                                        </div>
                                        <button onclick="getDoctors()" class="btn btn-space btn-primary">查找医生</button>
                                    </div>
                                    <div class="form-group">
                                        <label for="type" class="col-sm-3 control-label">结算类别</label>
                                        <div class="col-sm-6">
                                            <select  id = "type" name = "type" class="form-control input-sm">
                                                <option>自费</option>
                                                <option>医保</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-2 col-sm-10">
                                            <button type="submit" onclick="registration()" class="btn btn-space btn-primary">挂号</button>
                                            <button onclick="reset('reg-form')" class="btn btn-space btn-default">清空</button>
                                            <p id = "reg-err" class="error-message error-description"></p>
                                        </div>
                                    </div>
                                    <input type="hidden" name="cId" value="${requestScope.userId}">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div style="width: 49%;height: 100%;position: relative;float:right">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="panel panel-default panel-border-color panel-border-color-primary">
                            <div class="panel-heading panel-heading-divider">患者查找</div>
                            <div class="panel-body">
                                <form id = "patient-finder" name="patient-finder" onsubmit="return false" class="form-horizontal">
                                    <div class="form-group xs-mt-10">
                                        <label for="medicalNo" class="col-sm-2 control-label">病历号</label>
                                        <div class="col-sm-10">
                                            <input id="medicalNo" name = "medicalNo" placeholder="病历号" class="form-control input-sm">
                                        </div>
                                    </div>
                                    <div class="row xs-pt-15">
                                        <div class="col-xs-6">
                                            <p class="text-right">
                                                <button type="submit" onclick="findPatient()" class="btn btn-space btn-primary">查找并填入</button>
                                                <button onclick="reset('patient-finder')" class="btn btn-space btn-default">清空</button>
                                            </p>
                                            <p class="text-right" id = "finder-err" style="color: Red"></p>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 医生信息表格 -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="panel panel-default panel-table">
                            <div class="panel-heading">
                                医生信息
                            </div>
                            <div class="panel-body">
                                <table id="doctor-table" class="table table-striped table-hover table-fw-widget">

                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>


<script>
    function reset(formName){
        document.getElementById(formName).reset();
    }

    function registration() {
        if (!check_reg())
            return;
        var formData = serializeJson($('#reg-form').serializeArray());
        formData["gender"] = (formData["gender"] === "male");
        formData["printed"] = (formData["printed"] === "on");

        $.ajax({
            type: 'POST',
            dataType: 'json', //预期服务器返回的数据类型
            url: "${pageContext.request.contextPath}/registration",
            data: JSON.stringify(formData),
            contentType : 'application/json',
            success: function (result) {
                if (result["success"] === "false"){
                    window.alert("挂号失败");
                    return;
                }
                window.alert("患者病历号：" + result["medicalNo"] + "\n" +
                             "挂号id: " + result["regId"] + "\n" +
                             "挂号费用" + result["fee"]);
            },
            error : function() {
                alert("异常！");
            }
        });
    }

    function serializeJson(array){
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

    // 将医生信息填充到挂号信息中
    function fillReg(id) {
        const row = document.getElementById('doctor-table').rows[id];
        document.getElementById("odId").value = row.cells[0].innerHTML;
    }

    // 从服务器请求医生信息
    function getDoctors() {
        const param = {"deptId" : document.forms["reg-form"]["deptId"].value,
                      "reglCode" : document.forms["reg-form"]["reglCode"].value};
        console.log(param);
        $.ajax({
            type: 'post',
            dataType: 'json',
            url: "${pageContext.request.contextPath}/getDoctors",
            data: param,
            success: function (result) {
                console.log(result);
                fillDoctorTable(result["doctors"]);
            },
            error : function() {
                alert("异常！");
            }
        });
    }

    function fillDoctorTable(doctors) {
        var table = $("#doctor-table").DataTable();
        table.clear();

        for (var i = 0; i < doctors.length; i++){
            const doctor = doctors[i];
            table.row.add({
                "odId": doctor.odId,
                "name": doctor.name,
                "reglCode": doctor.reglCode,
                "deptName": doctor.deptName,
                "patNumber": doctor.patNumber,
                "limitation": doctor.limitation,
                "operate": "<button onclick='fillReg(" + (i + 1) +")'" +
                    "class='btn btn-rounded btn-space btn-default'>填入</button>"
                }
            )
        }
        table.draw();
    }

    // 查找患者信息
   function findPatient() {
        if (!check_Medical_no())
            return;
        const formData = $('#patient-finder').serialize();
        console.log(formData);
        $.ajax({
            type: 'get',
            dataType: 'json',
            url: "${pageContext.request.contextPath}/getPatient",
            data: formData,
            success: function (result) {
                console.log(result);
                if (result["patient"] == null)
                    document.getElementById("finder-err").innerHTML = "找不到患者！";
                else{
                    fillPatient(result["patient"]);
                    document.getElementById("finder-err").innerHTML = ""
                }

            },
            error : function() {
                alert("异常！");
            }
        });
    }

    // 检查查找病人提交的表单数据是否合法
    function check_Medical_no() {
        const medicalNo = document.forms["patient-finder"]["medicalNo"].value;
        const num = /^[1-9]\d*$/;

        if (medicalNo === null || !num.test(medicalNo)){
            document.getElementById("finder-err").innerText = "输入的病历号必需为数字";
            return false;
        }
        document.getElementById("finder-err").innerText = "";
        return true;
    }

    // 检查挂号所提交的表单是否合法
    function check_reg() {
        const patName = document.forms["reg-form"]["patName"].value;
        const patId = document.forms["reg-form"]["patId"].value;
        const birthday = document.forms["reg-form"]["birthday"].value;
        const address = document.forms["reg-form"]["address"].value;
        const odId = document.forms["reg-form"]["odId"].value;
        const deptId = document.forms["reg-form"]["deptId"].value;
        const reglCode = document.forms["reg-form"]["reglCode"].value;

        if (patName === null || patName === ""){
            document.getElementById('reg-err').innerText = "患者姓名不能为空";
            return false;
        }

        const idNo = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
        if (patId === null || patId === "" || !idNo.test(patId)){
            document.getElementById('reg-err').innerText = "患者身份证号格式错误";
            return false;
        }

        if (birthday === null || birthday === ""){
            document.getElementById('reg-err').innerText = "患者出生日期不能为空";
            return false;
        }

        if (address === null || address === ""){
            document.getElementById('reg-err').innerText = "患者住址不能为空";
            return false;
        }

        const num = /^[1-9]\d*$/;

        if (odId === null || odId === "" || !num.test(odId)){
            document.getElementById('reg-err').innerText = "医生id必需为数字";
            return false;
        }

        if (deptId === null || deptId === "" || !num.test(deptId)){
            document.getElementById("reg-err").innerText = "科室id必需为数字";
            return false;
        }

        if (reglCode === null || reglCode === ""){
            document.getElementById("reg-err").innerText = "挂号级别不能为空";
            return false;
        }
        return true;
    }

    function fillPatient(patient) {
        document.getElementById('patName').value = patient.name;
        if (patient.isMale){
            document.getElementById("gender-rad1").checked = "";
            document.getElementById("gender-rad2").checked = "checked";
        }else{
            document.getElementById("gender-rad1").checked = "checked";
            document.getElementById("gender-rad2").checked = "";
        }
        document.getElementById('patId').value = patient.idNumber;
        document.getElementById('address').value = patient.address;
        document.getElementById('birthday').value = patient.birthday;
    }
</script>

<script src="${pageContext.request.contextPath}/assets/lib/jquery/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/lib/perfect-scrollbar/js/perfect-scrollbar.jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/main.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/myjs/common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/lib/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/lib/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/lib/datatables/js/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/lib/datatables/js/dataTables.bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/lib/datatables/plugins/buttons/js/dataTables.buttons.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/lib/datatables/plugins/buttons/js/buttons.html5.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/lib/datatables/plugins/buttons/js/buttons.flash.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/lib/datatables/plugins/buttons/js/buttons.print.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/lib/datatables/plugins/buttons/js/buttons.colVis.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/lib/datatables/plugins/buttons/js/buttons.bootstrap.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/app-tables-datatables.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/lib/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/lib/jquery.nestable/jquery.nestable.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/lib/moment.js/min/moment.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/lib/datetimepicker/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/lib/daterangepicker/js/daterangepicker.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/lib/select2/js/select2.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/lib/select2/js/select2.full.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/lib/bootstrap-slider/js/bootstrap-slider.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/app-form-elements.js" type="text/javascript"></script>

<script type="text/javascript">
    $(document).ready(function(){
        //initialize the javascript
        App.init();
        App.formElements();
        init_doctor_table();
    });

    function init_doctor_table(){
        $.extend( true, $.fn.dataTable.defaults, {
            dom:
                "<'row be-datatable-header'<'col-sm-6'l><'col-sm-6'f>>" +
                "<'row be-datatable-body'<'col-sm-12'tr>>" +
                "<'row be-datatable-footer'<'col-sm-5'i><'col-sm-7'p>>"
        } );

        var dataTableConfig = {
            "bPaginate": true,  //是否分页。
            "bStateSave": true,
            "aLengthMenu": [5, 3, 1],
            "language": {
                "emptyTable": "没有可以选择的医生",
                "info": "显示 _START_ 到 _END_ 条数据 共 _TOTAL_ 条数据",
                "infoEmpty": "无数据",
                "infoFiltered": "(在 _MAX_ 条数据中查询)",
                "lengthMenu": "显示 _MENU_ 条数据",
                "search": "查询:",
                "zeroRecords": "没有找到对应的数据",
                "paginate": {
                    "previous":"上一页",
                    "next": "下一页",
                    "last": "末页",
                    "first": "首页"
                }
            },
            "columns": [
                {"data": "odId", "title": "医生id"},
                {"data": "name", "title": "医生姓名"},
                {"data": "reglCode", "title" : "挂号级别"},
                {"data": "deptName", "title": "科室名称"},
                {"data": "patNumber", "title": "看诊数量"},
                {"data": "limitation", "title": "挂号限额"},
                {"data": "operate", "title": "操作"}
            ]
        };

        $("#doctor-table").dataTable(dataTableConfig);
    }

</script>

</body>
</html>