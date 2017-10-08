<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>人事管理系统 ——后台登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />
<link href="${ctx}/static/resource/modules/hr_v12/css/css.css" type="text/css" rel="stylesheet" />
<!-- 导入jquery插件 -->
<script type="text/javascript" src="${ctx}/static/resource/modules/hr_v12/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="${ctx}/static/resource/modules/hr_v12/js/jquery-migrate-1.2.1.js"></script>
<script type="text/javascript" src="${ctx}/static/resource/modules/hr_v12/js/fkjava_timer.js"></script>
<script type="text/javascript">
    /** 文档加载完成后立即执行的方法 */
    // var weeks = new Array();
	
    $(function(){
    	$("#nowTime").runTimer();
    	
    	$("#exit").click(function(){
    		/** parent从主界面进行退出,避免局部刷新*/
    		parent.location = "${ctx}/logout.action";
    	})
	})
	
    
    
</script>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="320" height="80" class="topbg"><img src="${ctx}/static/resource/modules/hr_v12/images/top_logo.gif" width="320" height="80"></td>
	<td class="topbg">
	  <table width="100%" border="0" cellpadding="0" cellspacing="0">
	    <tr>
		  <td height="50" class="toplink" align="right"><img src="${ctx}/static/resource/modules/hr_v12/images/top_home.gif">&nbsp;&nbsp;<a href="javascript:void(0);">网站首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="${ctx}/static/resource/modules/hr_v12/images/top_exit.gif">&nbsp;&nbsp;<a href="javascript:void(0);" id="exit">注销退出</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr>
		  <td height="30" class="topnavbg">
		    <table width="100%" border="0" cellpadding="0" cellspacing="0">
			  <tr>
			    <td width="60"><img src="${ctx}/images/StatBarL.gif" width="60" height="30"></td>
				<td class="topnavlh" align="left"><img src="${ctx}/static/resource/modules/hr_v12/images/StatBar_admin.gif">&nbsp;&nbsp;当前用户：【${sessionScope.user_session.username}】</td>
				<td class="topnavlh" align="right"><img src="${ctx}/static/resource/modules/hr_v12/images/StatBar_time.gif">&nbsp;&nbsp;<span id="nowTime"></span>
				
  			 </td>
                <td width="3%"></td>
			  </tr>
			</table>
		  </td>
		</tr>
	  </table>
	</td>
  </tr>
</table>

<div style="margin:10px;background-color:#FFFFFF; text-align:left;">
		<table width="200" height="100%" border="0" cellpadding="0" cellspacing="0" class="left_nav_bg">
		  <tr><td class="left_nav_top"><div class="font1">用户管理</div></td></tr>
		  <tr valign="top">
		    <td class="left_nav_bgshw" height="50">
			  <p class="left_nav_link"><img src="${ctx}/static/resource/modules/hr_v12/images/left_nav_arrow.gif">&nbsp;&nbsp;<a href="" target="main">用户查询</a></img></p>
			  <p class="left_nav_link"><img src="${ctx}/static/resource/modules/hr_v12/images/left_nav_arrow.gif">&nbsp;&nbsp;<a href="" target="main">添加用户</a></img></p>
			</td>
		  </tr>
		  <tr><td height="2"></td></tr>
		  
		  <tr><td id="navbg1" class="left_nav_closed" ><div class="font1">部门管理</div></td></tr>
		  <tr valign="top" id="submenu1" style="display: none">
		    <td class="left_nav_bgshw" height="50">
			  <p class="left_nav_link"><img src="${ctx}/static/resource/modules/hr_v12/images/left_nav_arrow.gif">&nbsp;&nbsp;<a href="dept/selectDept" target="main">部门查询</a></img></p>
			  <p class="left_nav_link"><img src="${ctx}/static/resource/modules/hr_v12/images/left_nav_arrow.gif">&nbsp;&nbsp;<a href="dept/addDept?flag=1" target="main">添加部门</a></img></p>
			</td>
		  </tr>
		  <tr><td height="2"></td></tr>
		  
		  <tr><td id="navbg2" class="left_nav_closed" ><div class="font1">职位管理</div></td></tr>
		  <tr valign="top" id="submenu2" style="display: none">
		    <td class="left_nav_bgshw" height="50">
			  <p class="left_nav_link"><img src="${ctx}/static/resource/modules/hr_v12/images/left_nav_arrow.gif">&nbsp;&nbsp;<a href="job/selectJob" target="main">职位查询</a></img></p>
			  <p class="left_nav_link"><img src="${ctx}/static/resource/modules/hr_v12/images/left_nav_arrow.gif">&nbsp;&nbsp;<a href="job/addJob?flag=1" target="main">添加职位</a></img></p>
			</td>
		  </tr>
		  <tr><td height="2"></td></tr>

		  <tr><td id="navbg3" class="left_nav_closed" ><div class="font1">员工管理</div></td></tr>
		  <tr valign="top" id="submenu3" style="display: none">
		    <td class="left_nav_bgshw" height="50">
			  <p class="left_nav_link"><img src="${ctx}/static/resource/modules/hr_v12/images/left_nav_arrow.gif">&nbsp;&nbsp;<a href="${ctx }/employee/selectEmployee" target="main">员工查询</a></img></p>
			  <p class="left_nav_link"><img src="${ctx}/static/resource/modules/hr_v12/images/left_nav_arrow.gif">&nbsp;&nbsp;<a href="${ctx }/employee/addEmployee?flag=1" target="main">添加员工</a></img></p>
			</td>
		  </tr>
		  <tr><td height="2"></td></tr>
		  
		  <tr><td id="navbg4" class="left_nav_closed" ><div class="font1">公告管理</div></td></tr>
		  <tr valign="top" id="submenu4" style="display: none">
		    <td class="left_nav_bgshw tdbtmline" height="50">
			  <p class="left_nav_link"><img src="${ctx}/static/resource/modules/hr_v12/images/left_nav_arrow.gif">&nbsp;&nbsp;<a href="${ctx }/notice/selectNotice" target="main">公告查询</a></img></p>
			  <p class="left_nav_link"><img src="${ctx}/static/resource/modules/hr_v12/images/left_nav_arrow.gif">&nbsp;&nbsp;<a href="${ctx }/notice/addNotice?flag=1" target="main">添加公告</a></img></p>
			</td>
		  </tr>
		  <tr><td height="2"></td></tr>
		  
		  <tr><td id="navbg5" class="left_nav_closed" onClick="showsubmenu(5)"><div class="font1">下载中心</div></td></tr>
		  <tr valign="top" id="submenu5" style="display: none">
		    <td class="left_nav_bgshw tdbtmline" height="50">
		    	<p class="left_nav_link"><img src="${ctx}/static/resource/modules/hr_v12/images/left_nav_arrow.gif">&nbsp;&nbsp;<a href="${ctx }/document/selectDocument" target="main">文档查询</a></img></p>
			  	<p class="left_nav_link"><img src="${ctx}/static/resource/modules/hr_v12/images/images/left_nav_arrow.gif">&nbsp;&nbsp;<a href="${ctx }/document/addDocument?flag=1" target="main">上传文档</a></img></p>
			</td>
		  </tr>
		  <tr><td height="2"></td></tr>
		 
		  <tr valign="top"><td height="100%" align="center"><div class="copycct"><br /><strong>技术支持：</strong><br><strong></strong><br></div></td></tr>
		  <tr><td height="10"><img src="${ctx}/static/resource/modules/hr_v12/images/left_nav_bottom.gif" height="10"></img></td></tr>
		  <tr><td height="10" bgcolor="#e5f0ff">&nbsp;</td></tr>
		</table>
	</div>
    




</body>
</html>