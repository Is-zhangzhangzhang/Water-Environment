<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>

    <meta charset="utf-8" />
    <title>Land BigData</title>
    <meta http-equiv="Access-Control-Allow-Origin" content="*"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />
    <meta name="MobileOptimized" content="320">

    <!-- BEGIN GLOBAL MANDATORY STYLES -->
    <link href="${pageContext.request.contextPath}/assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/assets/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/assets/plugins/bootstrap/css/bootstrap-table.min.css">
    <!-- END GLOBAL MANDATORY STYLES -->

    <!-- BEGIN THEME STYLES -->
    <link href="${pageContext.request.contextPath}/assets/css/style-metronic.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/assets/css/style-responsive.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/assets/css/plugins.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/assets/css/pages/tasks.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/assets/css/themes/default.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/assets/css/custom.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/assets/css/pages/table-list.css" rel="stylesheet" type="text/css" />
   
    <!-- END THEME STYLES -->

    <link href="${pageContext.request.contextPath}/app/img/cloud.png" rel="shortcut icon"/>
</head>
<!-- END HEAD -->

<!-- BEGIN BODY -->
<body class="page-header-fixed">
<!-- BEGIN HEADER -->
<div class="header navbar navbar-inverse navbar-fixed-top">
    <!-- BEGIN TOP NAVIGATION BAR -->
    <div class="header-inner">
        <!-- BEGIN LOGO -->
        <a class="navbar-brand" href="main">
            <!--<img src="${pageContext.request.contextPath}/assets/img/logo.png" alt="logo" class="img-responsive" />-->
            <p>基于大数据的工程建设水环境影响评价系统</p>
        </a>
<!-- 
        <a href="main">
            <li role="presentation" class="dropdown nav navbar-nav navbar-box" style="margin-right: 0px;">
                <p class="text-center navbar-box-p">首页</p>
            </li>
        </a>
        <a href="ranking" id="rankbar">
            <li role="presentation" class="dropdown nav navbar-nav navbar-box" style="margin-right: 0px;">
                <p class="text-center navbar-box-p">排行榜</p>
            </li>
        </a>
 -->
        <!--
        <a id="discussbar">
            <li role="presentation" class="dropdown nav navbar-nav navbar-box" style="margin-right: 0px;">
                <p class="text-center navbar-box-p">讨论区</p>
            </li>
        </a>
        -->
        <!-- END LOGO -->
        <!-- BEGIN RESPONSIVE MENU TOGGLER -->
        <a href="javascript:;" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <img src="${pageContext.request.contextPath}/assets/img/menu-toggler.png" alt="" />
        </a>
        <!-- END RESPONSIVE MENU TOGGLER -->
        <!-- BEGIN TOP NAVIGATION MENU -->
        <ul class="nav navbar-nav pull-right">
            <li class="dropdown user">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                    <img alt="" src="${pageContext.request.contextPath}/assets/img/avatar1_small.jpg"/>
                    <span class="username"> ${user.userRealname} </span>
                    <i class="fa fa-angle-down"></i>
                </a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="javascript:;" id="trigger_fullscreen">
                            <i class="fa fa-move"></i> 全屏
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <i class="fa fa-lock"></i> 锁屏
                        </a>
                    </li>
                    <li>
                        <a href="logout">
                            <i class="fa fa-key"></i> 退出
                        </a>
                    </li>
                </ul>
            </li>
            <!-- END USER LOGIN DROPDOWN -->
        </ul>
        <!-- END TOP NAVIGATION MENU -->
    </div>
    <!-- END TOP NAVIGATION BAR -->
</div>
<!-- END HEADER -->
<div class="clearfix"></div>
<!-- BEGIN CONTAINER -->
<div class="page-container">
    <!-- BEGIN SIDEBAR -->
    <div class="page-sidebar-wrapper">
        <div class="page-sidebar navbar-collapse collapse">
            <!-- BEGIN SIDEBAR MENU -->
            <ul class="page-sidebar-menu" id="page-sidebar-menu">
                <li class="sidebar-toggler-wrapper">
                    <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                    <div class="sidebar-toggler hidden-phone"></div>
                    <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                </li>

                <li class="start active">
                    <a href="dashboard" id="btn-dashboard">
                        <i class="fa fa-home active"></i><span class="title"> 首页 </span>

                        <span class="selected"> </span>
                    </a>

                </li>

<li class="">
                    <a href="javascript:;">
                        <i class="glyphicon glyphicon-cloud" style="vertical-align: middle"></i><span class="title"> 大数据管理 </span>
                        <span class="arrow "> </span>
                    </a>
                    <ul class="sub-menu" >
                     <li>
                            <a href="database/hdfs" id="dfs_health">
                                分布式文件系统
                            </a>
                        </li>
                        <li>
                        <!--7.1修改  -->
                            <a href="database/list" id="databaseshow">
                               数据库操作      
                            </a>
                        </li>
                        <!--7.1修改  -->
                    </ul>
                </li>



                <li class="">
                    <a href="javascript:;">
                        <i class="glyphicon glyphicon-cloud" style="vertical-align: middle"></i><span class="title"> 大数据算法库 </span>
                        <span class="arrow "> </span>
                    </a>
                    <ul class="sub-menu" id="algorithmlib">
                        <li>
                            <a href="algorithm/list?id=1">
                                聚类算法
                            </a>
                        </li>
                        <li>
                            <a href="algorithm/list?id=2">
                                分类算法
                            </a>
                        </li>
                        <li>
                            <a href="algorithm/list?id=3">
                                降维算法
                            </a>
                        </li>
                        <li>
                            <a href="algorithm/list?id=4">
                                主题模型
                            </a>
                        </li>
                        <li>
                            <a href="algorithm/list?id=5">
                                协同过滤
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="">
                    <a href="javascript:;">
                        <i class="glyphicon glyphicon-cloud" style="vertical-align: middle"></i><span class="title"> 评价模型管理 </span>
                        <span class="arrow"> </span>
                    </a>
                    <ul class="sub-menu">
                    </ul>
                </li>
                
                <li class="">
                    <a href="javascript:;">
                        <i class="glyphicon glyphicon-cloud" style="vertical-align: middle"></i><span class="title"> 水环境影响评价 </span>
                        <span class="arrow"> </span>
                    </a>
                    <ul class="sub-menu">
                    </ul>
                </li>
                
                <li class="">
                    <a href="javascript:;">
                        <i class="glyphicon glyphicon-cloud" style="vertical-align: middle"></i><span class="title"> 平台管理 </span>
                        <span class="arrow "> </span>
                    </a>
                    <ul class="sub-menu">
                        <li>
                            <a href="cluster/info" id="clusterinfo">
                                集群信息
                            </a>
                        </li>
                        <li>
                            <a href="node/list" id="nodelist">
                                实例管理
                            </a>
                        </li>
                        <li>
                            <a href="http://192.168.10.151:8088/cluster" id="cluster_app">
                                集群应用管理
                            </a>
                        </li>
                       <!-- 628修改 -->
   						<c:choose>
   							<c:when test="${sessionScope.authority== 'admin'}"> 
       					<li>
                            <a href="user/list" id="userlist">
                                用户管理
                            </a>
                        </li> 
   							</c:when>
   							<c:otherwise>
    					<li>
                            <a href="javascript:;">
                                用户管理
                            </a>
                        </li>
   
   							</c:otherwise>
						</c:choose>
<!-- 628修改 -->
                    </ul>
                </li>

                <li class="">
                    <a href="javascript:;">
                        <i class="fa fa-user"></i><span class="title"> 个人中心 </span><span
                            class="arrow "> </span>
                    </a>
                    <ul class="sub-menu">
                        <li>
                            <a href="user/info" id="userinfo">
                                信息修改
                            </a>
                        </li>
                    </ul>
                </li>


            </ul>
            <!-- END SIDEBAR MENU -->
        </div>
    </div>
    <!-- END SIDEBAR -->
    <!-- BEGIN CONTENT -->
    <div class="page-content-wrapper">
        <div class="page-content">
            <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
            <div class="modal fade" id="portlet-config" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                            <h4 class="modal-title">Modal title</h4>
                        </div>
                        <div class="modal-body">
                            Widget settings form goes here
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn blue">
                                Save changes
                            </button>
                            <button type="button" class="btn default" data-dismiss="modal">
                                Close
                            </button>
                        </div>
                    </div>
                    <!-- /.modal-content -->
                </div>
                <!-- /.modal-dialog -->
            </div>
            <!-- /.modal -->
            <!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
            <!-- BEGIN STYLE CUSTOMIZER -->
            <div class="theme-panel hidden-xs hidden-sm">
                <div class="toggler"></div>
                <div class="toggler-close"></div>
                <div class="theme-options">
                    <div class="theme-option theme-colors clearfix">
                        <span> 主题颜色 </span>
                        <ul>
                            <li class="color-black current color-default" data-style="default"></li>
                            <li class="color-blue" data-style="blue"></li>
                            <li class="color-brown" data-style="brown"></li>
                            <li class="color-purple" data-style="purple"></li>
                            <li class="color-grey" data-style="grey"></li>
                            <li class="color-white color-light" data-style="light"></li>
                        </ul>
                    </div>
                    <div class="theme-option">
                        <span> 布局 </span>
                        <select class="layout-option form-control input-small">
                            <option value="fluid">顺序</option>
                            <option value="boxed">盒状</option>
                        </select>
                    </div>
                    <div class="theme-option">
                        <span> 标题 </span>
                        <select class="header-option form-control input-small">
                            <option value="fixed">固定</option>
                            <option value="default">默认</option>
                        </select>
                    </div>
                    <div class="theme-option">
                        <span> 工具栏 </span>
                        <select class="sidebar-option form-control input-small">
                            <option value="fixed">固定</option>
                            <option value="default">默认</option>
                        </select>
                    </div>
                    <div class="theme-option">
                        <span> 工具栏位置 </span>
                        <select class="sidebar-pos-option form-control input-small">
                            <option value="left">左边</option>
                            <option value="right">右边</option>
                        </select>
                    </div>
                    <div class="theme-option">
                        <span> 页脚 </span>
                        <select class="footer-option form-control input-small">
                            <option value="fixed">固定</option>
                            <option value="default">默认</option>
                        </select>
                    </div>
                </div>
            </div>
            <!-- END STYLE CUSTOMIZER -->

            <!-- BEGIN PAGE HEADER-->
            <div class="row">
                <div class="col-md-12" id="main-navbar" hidden="hidden">
                    <!-- BEGIN PAGE TITLE & BREADCRUMB-->
                    <h3 class="page-title" id="index-page-title">大数据计算</h3>
                    <ul class="page-breadcrumb breadcrumb" id="page-index" style="margin-bottom: 0px">
                        <li>
                            <i class="fa fa-home"></i>
                            <a href="javascript:;">
                                首页
                            </a>
                            <i class="fa fa-angle-right"></i>
                        </li>
                        <li>
                            <a href="#">
                                大数据计算
                            </a>
                        </li>
                    </ul>
                    <!-- END PAGE TITLE & BREADCRUMB-->
                </div>
            </div>
            <!-- END PAGE HEADER-->

            <!-- BEGIN DASHBOARD STATS -->
            <div id="main-content">

            </div>

            <!-- END PORTLET-->
        </div>
    </div>
    <!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->
<div class="footer">
    <div class="footer-inner">
        2017 &copy; Ubinec By Hua.Z .
    </div>
    <div class="footer-tools">
        <span class="go-top"><i class="fa fa-angle-up"></i></span>
    </div>
</div>
<!--[if lt IE 9]>
<script src="${pageContext.request.contextPath}/assets/plugins/respond.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/excanvas.min.js"></script>
<![endif]-->
<script src="${pageContext.request.contextPath}/assets/plugins/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/bootstrap-hover-dropdown/twitter-bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/assets/plugins/jquery-validation/dist/jquery.validate.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/select2/select2.min.js" type="text/javascript" ></script>

<script src="${pageContext.request.contextPath}/assets/plugins/bootstrap/js/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/bootstrap/js/bootstrap-table-zh-CN.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/scripts/app.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/upload/FastJson-1.0.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/app/js/index.js" type="text/javascript" ></script>

<!-- <script data-main="app/js/main" src="app/lib/requirejs/require.js"></script> -->

</body>
</html>