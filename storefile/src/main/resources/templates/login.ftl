<!DOCTYPE html>
<html>
<head>
   <title>用户登录</title>
   <link href="/assets/util/bootstrap3.3.0/css/bootstrap.min.css" rel="stylesheet">
   <script src="/assets/util/jquery1.10.1/jquery-1.10.1.min.js"></script>
   <script src="/assets/util/bootstrap3.3.0/js/bootstrap.min.js"></script>
</head>
<body style="background-color:#f2f2f2;">


<!-- head-start -->
<#include "head.ftl" >
<input type="hidden" id="pageTag" value="login" >
<!-- head-end -->

<div class="container" style="width:1000px;padding-top:70px;">
<div class="panel panel-default" >
  <div class="panel-body" style="margin:10px;">
    
	<div class="row" style="">
		 <div class="col-md-6" style="height:350px;">
         
		 <img src="/assets/images/7954.jpg" class="" style="width:100%;height:100%;">
		 
      </div>
      <div class="col-md-6" style="height:350px;">
	  
	  <div class="panel panel-default">
	  <div class="panel-heading">
		<h3 class="panel-title text-center">用户登录</h3>
	  </div>
	  <div class="panel-body" style="height:300px;margin-top:10px;">
		
		
		<form action="/login" method="post" class="bs-example bs-example-form" role="form">
			  <div class="input-group input-group-lg">
				 <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
				 <input name="username" type="text" class="form-control" placeholder="请输入用户名">
			  </div><br>
			  
			  <div class="input-group input-group-lg">
				 <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
				 <input name="password" type="password" class="form-control" placeholder="请输入密码">
			  </div><br>
			  
			  <div class="input-group input-group-lg" style="margin-bottom:5px;">
				 <span class="input-group-addon"><span class="glyphicon glyphicon-eye-close"></span></span>
				 <input type="text" class="form-control" placeholder="验证码">
				 <span class="input-group-addon" style="width:35%;padding:0">
					<img src="/res/images/code.jpg" style="width:100%;height:100%" ></img>
				 </span>
				 <span class="input-group-addon" style="cursor:pointer">
					<span class="glyphicon glyphicon-repeat"></span>
				 </span>
			  </div><br>
			  
			  <button type="submit" class="btn btn-danger btn-lg btn-block">
				  登录
			  </button>
		  
	   </form>
		
	  </div>
	</div>
         
		 
		 
      </div>
	</div>
	
  </div>
</div>
	
</div>

</body>
</html>		
