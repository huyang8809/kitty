<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    
<!-- head-start -->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="margin-bottom: 0;">
	<div class="container" style="">
	
		<div class="navbar-header" style="margin-right:70px;">
		  <a class="navbar-brand" href="#">彩壳网络硬盘</a>
	    </div>
		<ul class="nav navbar-nav">
			<li tag="publicSourse"><a href="/public.html"><span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>资源广场</a></li>
			<li tag="mySourse"><a href="/source.html"><span class="glyphicon glyphicon-hdd" aria-hidden="true"></span>我的资源</a></li>
			<li tag="upload"><a href="/upload.html"><span class="glyphicon glyphicon-open" aria-hidden="true"></span>上传</a></li>
			
		</ul>
		
		
		<div>
			

	
		<ul class="nav navbar-nav navbar-right">
		<#if !Session.LoginInfo?? >
			<li tag="login"><a href="/login"><span>登 录</span><i></i></a></li>
			<li tag="register"><a href="/register"><span>注 册</span><i></i></a></li>
		
		<#else>
			<li class="dropdown">
	            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
	              ${Session.LoginInfo.username?default('1')} <b class="caret"></b>
	            </a>
	            <ul class="dropdown-menu">
	               <li><a href="#">个人中心</a></li>
	               <li class="divider"></li>
	               <li><a href="/logout">退出</a></li>
	            </ul>
	         </li>
	     </#if>
	         
		</ul>
		
		</div>
	</div>
</nav>
<div style="height:70px;"></div>
<!-- head-end -->

<script type="text/javascript">

$(function(){

	var tagName = $("#pageTag").val();//取得页面标记
	$("[tag=" +tagName+ "]").addClass("active");
});

</script>

  </body>
</html>
