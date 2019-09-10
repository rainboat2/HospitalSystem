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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/style_me.css"/>
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
                <div class="page-title">门诊医生</div>
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
                            <li class="parent"><a href="#"><i class="icon mdi mdi-face"></i><span>门诊医生</span></a>
                                <ul class="sub-menu">
                                    <li class="active"><a href="#">门诊病历</a>
                                    </li>
                                    <li><a href="#">医技模板管理</a>
                                    </li>
                                    <li><a href="#">西药处方模板</a>
                                    </li>
                                    <li><a href="#">中药处方模板</a>
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
            <div class="col-sm-4">
                <div class="panel panel-flat">
                    <div class="panel-body">
                        <h4>未诊患者</h4>
                        <div class="patient-table">
                            <table class="table table-striped table-borderless table-hover">
                                <thead>
                                <tr>
                                    <th style="width:30%;">病历号</th>
                                    <th style="width:30%;">挂号id</th>
                                    <th>姓名</th>
                                    <th>年龄</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>test</td>
                                    <td>test</td>
                                    <td>test</td>
                                    <td>test</td>
                                </tr>
                                <tr>
                                    <td>test</td>
                                    <td>test</td>
                                    <td>test</td>
                                    <td>test</td>
                                </tr>
                                <tr>
                                    <td>test</td>
                                    <td>test</td>
                                    <td>test</td>
                                    <td>test</td>
                                </tr>
                                </tbody>
                            </table>

                        </div>
                        <h4>已诊患者</h4>
                        <div class="patient-table">
                            <table class="table table-striped table-borderless table-hover">
                                <thead>
                                <tr>
                                    <th style="width:30%;">病历号</th>
                                    <th style="width:30%;">挂号id</th>
                                    <th>姓名</th>
                                    <th>年龄</th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-8">
                <div class="panel panel-default">
                    <div class="col-sm-12 line">
                        <p class="pull-left">患者信息</p>
                        <input type="button" onclick="return false;" value="诊毕" class="pull-right word-button"/>
                    </div>
                    <div class="tab-container">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#home" data-toggle="tab">病历首页</a></li>
                            <li><a href="#check" data-toggle="tab">检查申请</a></li>
                            <li><a href="#examine" data-toggle="tab">检验申请</a></li>
                            <li><a href="#diagnosis" data-toggle="tab">门诊确诊</a></li>
                            <li><a href="#technician" data-toggle="tab">处置申请</a></li>
                            <li><a href="#medical1" data-toggle="tab">成药处方</a></li>
                            <li><a href="#medical2" data-toggle="tab">草药处方</a></li>
                            <li><a href="#fee" data-toggle="tab">费用查询</a></li>
                        </ul>
                        <div class="tab-content">
                            <div id="home" class="tab-pane active cont">
                                <table class="col-md-12 button-panel">
                                    <tr>
                                        <td><input type="button" onclick="return false;" value="暂存" class="word-button"/></td>
                                        <td><input type="button" onclick="return false;" value="提交" class="word-button"/></td>
                                        <td><input type="button" onclick="return false;" value="清空所有" class="word-button"/></td>
                                        <td><input type="button" onclick="return false;" value="刷新" class="word-button"/></td>
                                    </tr>
                                </table>
                                <br>
                                <h4>病史内容</h4>
                                <form class="form-horizontal" id="medical-content">
                                    <div class="form-group">
                                        <label for=chiefComplaint class="col-sm-2 control-label">主诉</label>
                                        <div class="col-sm-10">
                                            <input id = "chiefComplaint" type="text"
                                                   placeholder="主诉" class="form-control input-sm">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="presentIll" class="col-sm-2 control-label">现病史</label>
                                        <div class="col-sm-10">
                                            <input id="presentIll" type="text"
                                                   placeholder="现病史" class="form-control input-sm">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="treatmentPresIll" class="col-sm-2 control-label">现病治疗情况</label>
                                        <div class="col-sm-10">
                                            <input id="treatmentPresIll" type="text"
                                                   placeholder="现病治疗情况" class="form-control input-sm">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="previousIll" class="col-sm-2 control-label">既往史</label>
                                        <div class="col-sm-10">
                                            <input id="previousIll" type="text"
                                                   placeholder="既往史" class="form-control input-sm">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="allergy" class="col-sm-2 control-label">过敏史</label>
                                        <div class="col-sm-10">
                                            <input id="allergy" type="text"
                                                   placeholder="过敏史" class="form-control input-sm">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">体格检查</label>
                                        <div class="col-sm-10">
                                            <input id="allergy" type="text"
                                                   placeholder="体格检查" class="form-control input-sm">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="checkAdvice" class="col-sm-2 control-label">检查建议</label>
                                        <div class="col-sm-10">
                                            <input id="checkAdvice" type="text"
                                                   placeholder="检查建议" class="form-control input-sm">
                                        </div>
                                    </div>
                                    <input type="hidden" id="medicalNo">
                                </form>
                            </div>
                            <div id="check" class="tab-pane cont">
                                temp
                            </div>
                            <div id="examine" class="tab-pane">
                                temp
                            </div>
                            <div id="diagnosis" class="tab-pane">
                                temp
                            </div>
                            <div id="technician" class="tab-pane">
                                temp
                            </div>
                            <div id="medical1" class="tab-pane">
                                temp
                            </div>
                            <div id="medical2" class="tab-pane">
                                temp
                            </div>
                            <div id="fee" class="tab-pane">
                                temp
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
<script src="${pageContext.request.contextPath}/assets/lib/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>

<script>
    $(document).ready(function(){
        App.init();
    });
</script>
</html>
