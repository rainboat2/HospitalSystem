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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/libme/jquery-ui-1.12.1/jquery-ui.css"/>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
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
                            <table id="wait-for-diagnose" class="table table-hover">
                                <tbody>
                                <tr>
                                    <td style="width:30%;">病历号</td>
                                    <td style="width:30%;">挂号id</td>
                                    <td>姓名</td>
                                    <td>年龄</td>
                                </tr>
                                </tbody>
                            </table>

                        </div>
                        <h4>已诊患者</h4>
                        <div class="patient-table">
                            <table id="diagnosed" class="table table-hover">
                                <tbody>
                                <tr>
                                    <td style="width:30%;">病历号</td>
                                    <td style="width:30%;">挂号id</td>
                                    <td>姓名</td>
                                    <td>年龄</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-8">
                <div class="panel panel-default">
                    <div class="col-sm-12 line">
                        <p id="patient-info" class="pull-left">患者信息</p>
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
                                <p id="err-message" class="error-message"></p>
                                <table class="col-md-12 button-panel">
                                    <tr>
                                        <td><input type="button" onclick="hold();" value="暂存" class="word-button"/></td>
                                        <td><input type="button" onclick="submit();" value="提交" class="word-button"/></td>
                                        <td><input type="button" onclick="clearAll();" value="清空所有" class="word-button"/></td>
                                        <td><input type="button" onclick="flush();" value="刷新" class="word-button"/></td>
                                    </tr>
                                </table>
                                <br>
                                <h4>病史内容</h4>
                                <form id="medical-record" class="form-horizontal">
                                    <div class="form-group">
                                        <label for=chiefComplaint class="col-sm-2 control-label">主诉</label>
                                        <div class="col-sm-10">
                                            <input id = "chiefComplaint" name="chiefComplaint" type="text"
                                                   placeholder="主诉" class="form-control input-sm">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="presentIll" class="col-sm-2 control-label">现病史</label>
                                        <div class="col-sm-10">
                                            <input id="presentIll" name="presentIll" type="text"
                                                   placeholder="现病史" class="form-control input-sm">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="treatmentPresIll" class="col-sm-2 control-label">现病治疗情况</label>
                                        <div class="col-sm-10">
                                            <input id="treatmentPresIll" name="treatmentPresIll"  type="text"
                                                   placeholder="现病治疗情况" class="form-control input-sm">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="previousIll" class="col-sm-2 control-label">既往史</label>
                                        <div class="col-sm-10">
                                            <input id="previousIll" name="previousIll" type="text"
                                                   placeholder="既往史" class="form-control input-sm">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="allergy" class="col-sm-2 control-label">过敏史</label>
                                        <div class="col-sm-10">
                                            <input id="allergy" name="allergy" type="text"
                                                   placeholder="过敏史" class="form-control input-sm">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="healthCheckup" class="col-sm-2 control-label">体格检查</label>
                                        <div class="col-sm-10">
                                            <input id="healthCheckup" name="healthCheckup" type="text"
                                                   placeholder="体格检查" class="form-control input-sm">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="checkAdvice" class="col-sm-2 control-label">检查建议</label>
                                        <div class="col-sm-10">
                                            <input id="checkAdvice" name="checkAdvice" type="text"
                                                   placeholder="检查建议" class="form-control input-sm">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="note" class="col-sm-2 control-label">备注</label>
                                        <div class="col-sm-10">
                                            <input id="note" name="note" type="text"
                                                   placeholder="备注" class="form-control input-sm">
                                        </div>
                                    </div>
                                    <input type="hidden" id="form-regId" name="regId">
                                </form>
                                <h4>评估诊断</h4>
                                <div class="panel panel-default panel-table">
                                    <div class="line">
                                        <label for="type"></label>
                                        <div class="col-sm-3">
                                            <select id="type">
                                                <option value="1">中医诊断</option>
                                                <option value="2">西医诊断</option>
                                            </select>
                                        </div>
                                        <div class="pull-right">
                                            <input type="button" class="word-button" value="增加" onclick="addRow()"/>
                                            <input type="button" class="word-button" value="删除" onclick="deleteRow($('#diagnose-table')[0])"/>
                                        </div>
                                    </div>
                                    <div class="panel-body">
                                        <div class="table-responsive noSwipe">
                                            <table id="diagnose-table" class="table table-hover">
                                                <thead>
                                                <tr>
                                                    <th style="width: 10%;"></th>
                                                    <th style="width: 30%;">ICD编码</th>
                                                    <th style="width: 30%">名称</th>
                                                    <th style="width: 30%">发病时间</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
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
<script src="${pageContext.request.contextPath}/assets/libme/jquery-ui-1.12.1/external/jquery/jquery.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/libme/jquery-ui-1.12.1/jquery-ui.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/lib/perfect-scrollbar/js/perfect-scrollbar.jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/main.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/lib/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/myjs/doctor.js" type="text/javascript" charset="GBK"></script>
<script src="${pageContext.request.contextPath}/assets/js/myjs/common.js" type="text/javascript"></script>


<script>

    $(document).ready(function(){
        App.init();
        $.pagePath = "${pageContext.request.contextPath}";
        getPatient();
    });



</script>
</html>
