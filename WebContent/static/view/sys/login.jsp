
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">@charset "UTF-8";[ng\:cloak],[ng-cloak],[data-ng-cloak],[x-ng-cloak],.ng-cloak,.x-ng-cloak,.ng-hide:not(.ng-hide-animate){display:none !important;}ng\:form{display:block;}.ng-animate-shim{visibility:hidden;}.ng-anchor{position:absolute;}</style>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>优云运维应用平台系统</title>
	<meta name="keywords" content=" ">
	<meta name="description" content="">
	<link rel="shortcut icon" href="">
	<link href="${ctx}/static/resource/sys/css/bootstrap.min.css" rel="stylesheet">
	<link href="${ctx}/static/resource/sys/css/common.css" rel="stylesheet">
	
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
<div class="system-login" style="height: 693px; background-image: url(http://we.e-rabits.com/web/resource/images/bg-login.png);">

	<div class="head">
		<a href="" class="logo-version">
			<img src="${ctx}/static/resource/sys/images/youyunlogo.png" class="logo">
			<span class="version hidden"></span>
		</a>
				<a href="" class="pull-right"> </a>
			</div>
	<div class="login-panel">
        <div class=""><font color="red" size="4"><b>${company}</b></font></div>
		<div class="title">账号密码登录</div>
		<form action="${ctx}/doLogin" method="post" role="form" id="form1" onsubmit="return formcheck();" class="we7-form">
			<div class="input-group-vertical">
				<input name="userName" type="text" class="form-control " placeholder="请输入用户名登录">
				<input name="userPwd" type="password" class="form-control password" placeholder="请输入登录密码">
                <input name="urlSign" type="hidden" value="${urlSign}" >
							</div>
              <c:if test="${errorMsg != null}">
				
					<br>
					<div class="col-sm-10">
						<div class="alert alert-danger">${errorMsg}</div>
					</div>
				
            </c:if>
			<div class="checkbox">
				<input type="checkbox" value="true" id="rember" name="rember">
				<label for="rember">记住用户名</label>
			</div>
			<div class="login-submit text-center">
				<input type="submit" id="submit" name="submit" value="登录" class="btn btn-primary btn-block">
				<!--<div class="text-right">
											<a href="" class="color-default">立即注册</a>
									</div>-->
			</div>
		</form>
	</div>
</div>

	<div class="container-fluid footer text-center" role="footer">	
		<div class="friend-link">
                            ${company}
							<br>
ADDRESS: ${companyAddress}					</div>
		<div class="copyright"><a href="">we.e-rabits.com</a>    <a href="http://www.miibeian.gov.cn/"></a></div>
	</div>
			


<script>
function formcheck() {
	if($('#remember:checked').length == 1) {
		cookie.set('remember-username', $(':text[name="userName"]').val());
	} else {
		cookie.del('remember-username');
	}
	return true;
}
var h = document.documentElement.clientHeight;
$(".system-login").css('height',h);
$('#toggle').click(function() {
	$('#imgverify').prop('src', './index.php?c=utility&a=code&r='+Math.round(new Date().getTime()));
	return false;
});
</script>
</body></html>