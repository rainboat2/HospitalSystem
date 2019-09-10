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

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/myStyle.style_me.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/lib/perfect-scrollbar/css/perfect-scrollbar.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/lib/material-design-icons/css/material-design-iconic-font.min.css"/>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/lib/jquery.vectormap/jquery-jvectormap-1.2.2.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/lib/jqvmap/jqvmap.min.css"/>
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
                            <span class="user-name">用户名</span>
                        </a>
                        <ul role="menu" class="dropdown-menu">
                            <li>
                                <div class="user-info">
                                    <div class="user-name">用户名</div>
                                </div>
                            </li>
                            <li><a href="#"><span class="icon mdi mdi-power"></span>注销</a></li>
                        </ul>
                    </li>
                </ul>
                <div class="page-title">收费员>>退号</div>
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
                                    <li><a href="${pageContext.request.contextPath}/cashier">现场挂号</a>
                                    </li>
                                    <li class="active"><a href="#">退号</a>
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
            <div class="row">
                <div class="col-sm-12">
                    <div class="panel panel-default panel-table">
                        <div class="panel-heading"></div>
                        <!-- 信息输入/查看面板-->
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-sm-12">
                                    <table class="col-sm-12">
                                        <tr>
                                            <td style="width:12%"><b>患者信息查询</b></td>
                                        </tr>
                                        <tr>
                                            <td style="width:8%;text-align:center;">病历号</td>
                                            <td style="width:24%;">
                                                <input id = "medicalNo" type="text" placeholder="病历号" autocomplete="off" class="form-control input-sm">
                                            </td>
                                            <td style="width:8%;text-align:right">
                                                <button class="btn btn-space btn-primary" onclick="findRegistration()">
                                                    <i class="icon icon-left mdi mdi-search"></i> 搜索
                                                </button>
                                            </td>
                                            <td>
                                                <p id="finder-err"></p>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><b>患者信息确认</b></td>
                                        </tr>
                                        <tr>
                                            <td style="width:8%;text-align:center;">姓名</td>
                                            <td style="width:24%;">
                                                <input type="text" readonly="readonly" class="form-control input-sm">
                                            </td>
                                            <td style="width:8%;;text-align:center;">身份证号</td>
                                            <td style="width:24%">
                                                <input type="text" readonly="readonly" class="form-control input-sm">
                                            </td>
                                            <td style="width:8%;;text-align:center;">家庭住址</td>
                                            <td style="width:24%">
                                                <input type="text" readonly="readonly" class="form-control input-sm">
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <!-- 挂号表格-->
                        <div class="panel-heading">
                            患者挂号信息
                        </div>
                        <div class="panel-body">
                            <table id="reg-table" class="table table-striped table-hover table-fw-widget">
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>

<script type="text/javascript">
    // 根据病历号，查找所有对应的挂号单
    function findRegistration() {
        if (!check_Medical_no())
            return;
        const data = {medicalNo : document.getElementById("medicalNo").value};
        $.ajax({
            type: 'get',
            dataType: 'json',
            url: "${pageContext.request.contextPath}/getRegistrationInfo",
            data: data,
            success: function (result) {
                console.log(result);
                if (result["name"] == null)
                    document.getElementById("finder-err").innerHTML = "找不到患者！";
                else{
                    fillRegTable(result);
                    document.getElementById("finder-err").innerHTML = ""
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

        if (medicalNo === null || !num.test(medicalNo)){
            document.getElementById("finder-err").firstChild.nodeValue = "输入的病历号必需为数字";
            return false;
        }
        document.getElementById("finder-err").firstChild.nodeValue = "";
        return true;
    }

    function fillRegTable(info) {
        const table = $("#reg-table").DataTable();
        table.clear();
        const regList = info.regList;
        for (var i = 0; i < regList.length; i++){
            const reg = regList[i];
            table.row.add({
                "name": info.name,
                "idNumber": info.idNumber,
                "regId": reg.regId,
                "regState": reg.regState,
                "regTime": reg.regTime,
                "deptName": reg.deptName,
                "operate" : "<button class=\"btn btn-space btn-primary\" onclick=\"withdrawRegistration("
                    + reg.regId + ")\">退号</button>"
            })
        }
        table.draw();
    }

    function withdrawRegistration(regId){
        $.ajax({
            type: 'get',
            dataType: 'json',
            url: "${pageContext.request.contextPath}/withdraw",
            data: {"regId" : regId},
            success: function (result) {
                if (result["success"] === 1)
                    findRegistration();
                else
                    window.alert("退号失败，只有状态为未就诊的挂号才能退号！")
            },
            error: function () {
                alert("异常");
            }
        })
    }

    //TODO: modifyState 修改表格中的状态

</script>

<script src="${pageContext.request.contextPath}/assets/lib/jquery/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/lib/perfect-scrollbar/js/perfect-scrollbar.jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/main.js" type="text/javascript"></script>
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
        App.init();
        init_reg_table();
    });

    function init_reg_table(){
        $.extend( true, $.fn.dataTable.defaults, {
            dom:
                "<'row be-datatable-header'<'col-sm-6'l><'col-sm-6'f>>" +
                "<'row be-datatable-body'<'col-sm-12'tr>>" +
                "<'row be-datatable-footer'<'col-sm-5'i><'col-sm-7'p>>"
        } );

        const dataTableConfig = {
            "bPaginate": true,  //是否分页。
            "bStateSave": true,
            "aLengthMenu": [5, 3, 1],
            "language": {
                "emptyTable": "无挂号信息",
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
                {"data": "name", "title": "姓名"},
                {"data": "idNumber", "title": "身份证号"},
                {"data": "regId", "title": "挂号id"},
                {"data": "regState", "title": "状态"},
                {"data": "regTime", "title": "挂号时间"},
                {"data": "deptName", "title": "科室"},
                {"data": "operate", "title": "操作"}
            ]
        };

        $("#reg-table").dataTable(dataTableConfig);
    }
</script>
</html>
