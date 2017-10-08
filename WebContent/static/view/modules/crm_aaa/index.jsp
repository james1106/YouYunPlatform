<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">[uib-typeahead-popup].dropdown-menu{display:block;}</style>
<style type="text/css">.uib-time input{width:50px;}</style>
<style type="text/css">[uib-tooltip-popup].tooltip.top-left > .tooltip-arrow,[uib-tooltip-popup].tooltip.top-right > .tooltip-arrow,[uib-tooltip-popup].tooltip.bottom-left > .tooltip-arrow,[uib-tooltip-popup].tooltip.bottom-right > .tooltip-arrow,[uib-tooltip-popup].tooltip.left-top > .tooltip-arrow,[uib-tooltip-popup].tooltip.left-bottom > .tooltip-arrow,[uib-tooltip-popup].tooltip.right-top > .tooltip-arrow,[uib-tooltip-popup].tooltip.right-bottom > .tooltip-arrow,[uib-tooltip-html-popup].tooltip.top-left > .tooltip-arrow,[uib-tooltip-html-popup].tooltip.top-right > .tooltip-arrow,[uib-tooltip-html-popup].tooltip.bottom-left > .tooltip-arrow,[uib-tooltip-html-popup].tooltip.bottom-right > .tooltip-arrow,[uib-tooltip-html-popup].tooltip.left-top > .tooltip-arrow,[uib-tooltip-html-popup].tooltip.left-bottom > .tooltip-arrow,[uib-tooltip-html-popup].tooltip.right-top > .tooltip-arrow,[uib-tooltip-html-popup].tooltip.right-bottom > .tooltip-arrow,[uib-tooltip-template-popup].tooltip.top-left > .tooltip-arrow,[uib-tooltip-template-popup].tooltip.top-right > .tooltip-arrow,[uib-tooltip-template-popup].tooltip.bottom-left > .tooltip-arrow,[uib-tooltip-template-popup].tooltip.bottom-right > .tooltip-arrow,[uib-tooltip-template-popup].tooltip.left-top > .tooltip-arrow,[uib-tooltip-template-popup].tooltip.left-bottom > .tooltip-arrow,[uib-tooltip-template-popup].tooltip.right-top > .tooltip-arrow,[uib-tooltip-template-popup].tooltip.right-bottom > .tooltip-arrow,[uib-popover-popup].popover.top-left > .arrow,[uib-popover-popup].popover.top-right > .arrow,[uib-popover-popup].popover.bottom-left > .arrow,[uib-popover-popup].popover.bottom-right > .arrow,[uib-popover-popup].popover.left-top > .arrow,[uib-popover-popup].popover.left-bottom > .arrow,[uib-popover-popup].popover.right-top > .arrow,[uib-popover-popup].popover.right-bottom > .arrow,[uib-popover-html-popup].popover.top-left > .arrow,[uib-popover-html-popup].popover.top-right > .arrow,[uib-popover-html-popup].popover.bottom-left > .arrow,[uib-popover-html-popup].popover.bottom-right > .arrow,[uib-popover-html-popup].popover.left-top > .arrow,[uib-popover-html-popup].popover.left-bottom > .arrow,[uib-popover-html-popup].popover.right-top > .arrow,[uib-popover-html-popup].popover.right-bottom > .arrow,[uib-popover-template-popup].popover.top-left > .arrow,[uib-popover-template-popup].popover.top-right > .arrow,[uib-popover-template-popup].popover.bottom-left > .arrow,[uib-popover-template-popup].popover.bottom-right > .arrow,[uib-popover-template-popup].popover.left-top > .arrow,[uib-popover-template-popup].popover.left-bottom > .arrow,[uib-popover-template-popup].popover.right-top > .arrow,[uib-popover-template-popup].popover.right-bottom > .arrow{top:auto;bottom:auto;left:auto;right:auto;margin:0;}[uib-popover-popup].popover,[uib-popover-html-popup].popover,[uib-popover-template-popup].popover{display:block !important;}</style><style type="text/css">.uib-datepicker-popup.dropdown-menu{display:block;float:none;margin:0;}.uib-button-bar{padding:10px 9px 2px;}</style><style type="text/css">.uib-position-measure{display:block !important;visibility:hidden !important;position:absolute !important;top:-9999px !important;left:-9999px !important;}.uib-position-scrollbar-measure{position:absolute !important;top:-9999px !important;width:50px !important;height:50px !important;overflow:scroll !important;}.uib-position-body-scrollbar-measure{overflow:scroll !important;}</style><style type="text/css">.uib-datepicker .uib-title{width:100%;}.uib-day button,.uib-month button,.uib-year button{min-width:100%;}.uib-left,.uib-right{width:100%}</style><style type="text/css">.ng-animate.item:not(.left):not(.right){-webkit-transition:0s ease-in-out left;transition:0s ease-in-out left}</style><style type="text/css">@charset "UTF-8";[ng\:cloak],[ng-cloak],[data-ng-cloak],[x-ng-cloak],.ng-cloak,.x-ng-cloak,.ng-hide:not(.ng-hide-animate){display:none !important;}ng\:form{display:block;}.ng-animate-shim{visibility:hidden;}.ng-anchor{position:absolute;}</style>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>优云运维应用平台系统</title>
	<meta name="keywords" content="">
	<meta name="description" content="">
	<link rel="shortcut icon" href="">
	<link href="${ctx}/static/resource/sys/css/bootstrap.min.css" rel="stylesheet">
	<link href="${ctx}/static/resource/sys/css/common.css" rel="stylesheet">
	
	<script>var require = { urlArgs: 'v=20170915' };</script>
	<script type="text/javascript" src="${ctx}/static/resource/sys/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/resource/sys/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/resource/sys/js/util.js"></script>
	<script type="text/javascript" src="${ctx}/static/resource/sys/js/common.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/resource/sys/js/require.js"></script>
</head>
<body>
	<div class="loader" style="display:none">
		<div class="la-ball-clip-rotate">
			<div></div>
		</div>
	</div>
<div data-skin="default" class="skin-default ">
<div class="head">
	<nav class="navbar navbar-default" role="navigation">
		<div class="container ">
			<div class="navbar-header">
				<a class="navbar-brand" href="">
					<img src="${ctx}/static/resource/sys/images/icon-19.jpg" class="pull-left" width="110px" height="35px">
					<span class="version hidden"></span>
				</a>
			</div>
						<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-left">
															<li class="active"><a href="">首页</a></li>
										<li><a href="">基础数据</a></li>
										<li><a href="">客户资料资料</a></li>
                                        <li><a href="">客户管理</a></li>
                                        <li><a href="">客户关系</a></li>
										<li><a href="">系统管理</a></li>
										<li><a href="${ctx}/index">平台首页</a></li>
										
									</ul>
                                    <!--
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"><i class="wi wi-user color-gray"></i>weadmin <span class="caret"></span></a>
						<ul class="dropdown-menu color-gray" role="menu">
							<li>
								<a href="" target="_blank"><i class="wi wi-account color-gray"></i> 我的账号</a>
							</li>
														<li class="divider"></li>
														<li><a href="" target="_blank"><i class="wi wi-update color-gray"></i> 自动更新</a></li>
														<li><a href="" target="_blank"><i class="wi wi-cache color-gray"></i> 更新缓存</a></li>
							<li class="divider"></li>
														<li>
								<a href=""><i class="fa fa-sign-out color-gray"></i> 退出系统</a>
							</li>
						</ul>
					</li>
				</ul>-->
			</div>
					</div>
	</nav>
</div>
 
<div class="main">
<div class="container">
            
            <h3>登录者：<font color="blue">${compnay}</font> --- ${apperUserName} [${apperRealName}]</h3>
            <h1> <font color="blue" ></font></h1>
	       <br>
           <center>
            <font color="red" size="10"> 客户关系管理系统</font><br>
          
					<img src="${ctx}/static/resource/sys/images/123.jpg" class="" width="80%" >
					
				</center>>
				
	</div>
</div>

			</div>
		</div>
	</div>


	<div class="container-fluid footer text-center" role="footer">	
		<div class="friend-link">
							<br>
					</div>
		<div class="copyright"><a href=""></a>    <a href="http://www.miibeian.gov.cn/"></a></div>
	</div>
			


</body></html>