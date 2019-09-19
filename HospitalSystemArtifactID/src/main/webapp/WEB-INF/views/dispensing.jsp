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
                <div class="page-title">收费员>>发药</div>
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
                                    <li><a href="${pageContext.request.contextPath}/withdrawRegistration">退号</a>
                                    </li>
                                    <li><a href="${pageContext.request.contextPath}/payDrug">收费</a>
                                    </li>
                                    <li class="active"><a href="#">发药</a>
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
                                            <td style="width:8%;text-align:center;">
                                                <label for="medicalNo">病历号</label>
                                            </td>
                                            <td style="width:24%;">
                                                <input id = "medicalNo" type="text" placeholder="病历号" autocomplete="off" class="form-control input-sm">
                                            </td>
                                            <td style="width:8%;text-align:right">
                                                <button id="getDrugs" class="btn btn-space btn-primary" onclick="getDrugs('已缴费')">
                                                    <i class="icon icon-left mdi mdi-search"></i> 搜索
                                                </button>
                                            </td>
                                            <td id="finder-err" class="error-message" style="margin: auto;text-align: center">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><b>患者信息确认</b></td>
                                        </tr>
                                        <tr>
                                            <td style="width:8%;text-align:center;">
                                                <label for="name">姓名</label>
                                            </td>
                                            <td style="width:24%;">
                                                <input id="name" type="text" readonly="readonly" class="form-control input-sm">
                                            </td>
                                            <td style="width:8%;;text-align:center;">
                                                <label for="idNumber">身份证号</label>
                                            </td>
                                            <td style="width:24%">
                                                <input id="idNumber" type="text" readonly="readonly" class="form-control input-sm">
                                            </td>
                                            <td style="width:8%;;text-align:center;">
                                                <label for="address">家庭住址</label>
                                            </td>
                                            <td style="width:24%">
                                                <input id="address" type="text" readonly="readonly" class="form-control input-sm">
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="panel-heading">
                            患者药品信息
                        </div>
                        <div class="panel-body">
                            <div class="col-md-11 fix-height-table">
                                <table id="drug-table" class="table table-hover">
                                    <tr>
                                        <td>
                                            <div class="be-checkbox be-checkbox-sm">
                                                <input id="check0" type="checkbox" onclick="selectAll(this)">
                                                <label for="check0"></label>
                                            </div>
                                        </td>
                                        <td>病历号</td>
                                        <td>姓名</td>
                                        <td>项目id</td>
                                        <td>项目名称</td>
                                        <td>单价</td>
                                        <td>数量</td>
                                        <td>状态</td>
                                    </tr>
                                </table>
                            </div>
                            <div class="col-md-2">
                                <button class="btn btn-space btn-primary" onclick="changeState('已发药')">
                                    发药
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>

<script src="${pageContext.request.contextPath}/assets/lib/jquery/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/lib/perfect-scrollbar/js/perfect-scrollbar.jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/main.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/myjs/payDrug.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/myjs/common.js" type="text/javascript" charset="GBK"></script>
<script src="${pageContext.request.contextPath}/assets/lib/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/lib/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>



<script type="text/javascript">
    $(document).ready(function(){
        App.init();
        $.pagePath = "${pageContext.request.contextPath}";
    });
</script>
</html>