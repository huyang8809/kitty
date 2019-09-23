<!DOCTYPE html>
<html>
<head>
   <title>用户注册</title>
   <link href="/assets/util/bootstrap3.3.0/css/bootstrap.min.css" rel="stylesheet">
   <script src="/assets/util/jquery1.10.1/jquery-1.10.1.min.js"></script>
   <script src="/assets/util/bootstrap3.3.0/js/bootstrap.min.js"></script>
   
</head>
<body style="background-color:#f2f2f2;">


<!-- head-start -->
<#include "head.ftl" >
<input type="hidden" id="pageTag" value="register" >
<!-- head-end -->

<div class="container" style="width:700px;padding-top:10px;">

	<div class="panel panel-default">
	  <div class="panel-heading">
		<h3 class="panel-title text-center">用户注册</h3>
	  </div>
	  <div class="panel-body" style="margin-top:10px;margin-left:90px;margin-right:90px;">
		
		
		<form class="bs-example bs-example-form" role="form" action="/register" method="post">
			  <div id="div1" class="input-group input-group-lg">
				 <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
				 <input id="box1" type="text" name="username" class="form-control" placeholder="请输入用户名">
			  </div>
			  <br>
			  
			  <div class="input-group input-group-lg">
				 <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
				 <input type="password" name="password" class="form-control" placeholder="请输入密码">
			  </div><br>
			  
			  <div class="input-group input-group-lg">
				 <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
				 <input type="password" class="form-control" placeholder="重复输入密码">
			  </div><br>
			  
			  <div class="input-group input-group-lg">
				 <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
				 <input type="text" name="email" class="form-control" placeholder="电子邮箱">
			  </div><br>
			  
			  <div class="input-group input-group-lg" style="">
				 <span class="input-group-addon"><span class="glyphicon glyphicon-eye-close"></span></span>
				 <input type="password" class="form-control" placeholder="验证码">
				 <span class="input-group-addon" style="width:35%;padding:0">
					<img src="<%=path %>/res/code.jpg" class="img-rounded" style="width:100%;height:100%" ></img>
				 </span>
				 <span class="input-group-addon" style="cursor:pointer">
					<span class="glyphicon glyphicon-repeat"></span>
				 </span>
			  </div><br>
			  
			  <button type="submit" class="btn btn-danger btn-lg btn-block">
				  注册
			  </button>
		  
	   </form>
		
	  </div>
	</div>
	
</div>

<script type="text/javascript">
$(function(){
	$("#box1").change(function(){
		$.post('/username/check',{"username":$("#box1").val()},function(data){
			if(data.code=="2"){
				$("#div1").addClass("has-error");
				$("#div1").removeClass("has-success");
				alert('用户名已经存在，输入框已经变红');
			}
			if(data.code=="1"){
				$("#div1").removeClass("has-error");
				$("#div1").addClass("has-success");
			}
		});
	});

	$("form").submit(function(){
		if($("[name='username']").val().trim()==""){
			alert('用户名不能为空');
			return false;
		}
		//验证两次输入的密码
		var pBox = $("[type='password']");
		if(pBox.eq(0).val().trim()==""){
			alert('密码不能为空');
			return false;
		}
		if(pBox.eq(0).val()!=pBox.eq(1).val()){
			alert('两次密码不一致');
			return false;
		}
		//验证邮箱格式
		var szReg=/^(\w)+(\.\w+)*@(\w)+((\.\w{2,3}){1,3})$/; 
		if(!szReg.test($("[name='email']").val()) ){
			alert('邮箱格式不正确');
			return false;
		}
		
		return true;
	});
});
</script>

</body>
</html>	
<!-- 
彩壳网络硬盘由夏增明老师设计开发：
高级软件工程师，软件系统架构师，技术经理，
曾就职文思海辉，现任职清软国际学院特级讲师，
国家信息技术紧缺人才培养工程专家组核心成员，

北京商之讯TQ软件技术顾问，
北京华路时代技术顾问

主持设计开发了：
大庆师范学院论文申报系统，
OEE高校联合在线教育平台，
OEE平台Android手机APP，
国家核电项目管控系统。

西城区商务委OA系统总负责人

编程百科联合创始人


 -->
