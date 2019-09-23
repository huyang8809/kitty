<!DOCTYPE html>
<html>
<head>
   <title>彩壳网络硬盘</title>
   <link href="/assets/util/bootstrap3.3.0/css/bootstrap.min.css" rel="stylesheet">
   <script src="/assets/util/jquery1.10.1/jquery-1.10.1.min.js"></script>
   <script src="/assets/util/bootstrap3.3.0/js/bootstrap.min.js"></script>
   <script src="/assets/js/spark-md5.js" type="text/javascript"></script>
</head>
<body>


<!-- head-start -->
<#include "head.ftl" >
<input type="hidden" id="pageTag" value="upload" >
<!-- head-end -->

<div class="container" style="width:700px;padding-top:20px;">

	<div class="panel panel-default">
	  <div class="panel-heading">
		<h3 class="panel-title text-center">上传</h3>
	  </div>
	  <div class="panel-body" style="margin-top:10px;margin-left:90px;margin-right:90px;">
		
		
		<form class="bs-example bs-example-form" role="form" id="f1" action="/home/upload" enctype="multipart/form-data" method="post" >
		
			<!-- <table class="table table-bordered" id="tb1">
			   <caption>环境检测</caption>
			   
			   <tbody>
				  <tr>
					 <td>支持秒传</td>
					 <td align="center" id="e1"></td>
				  </tr>
				  <tr>
					 <td>Sachin</td>
					 <td>Mumbai</td>
				  </tr>
			   </tbody>
			</table> -->

			<table class="table table-bordered" id="tb2">
			   <caption>选择文件</caption>
			   
			   <tbody>
				  <tr>
					 <td style="overflow:hidden;">
					 <input type="file" id="file" name="mfile"  >
					 </td>
				  </tr>
			   </tbody>
			</table>
			
			<table class="table table-bordered" id="tb3">
			   <caption>读取文件MD5指纹</caption>
			   
			   <tbody>
				  <tr>
					 <td><div id="box">未检测</div></td>
				  </tr>
				  <tr>
				  <td>
					<div class="progress">
						<div id="jindu" class="progress-bar" role="progressbar" style="width: 0%;">
							0%
						</div>
					</div>
				  </td>
				  </tr>
			   </tbody>
			</table>
			
			
			<div>
                
                
				
            </div>
			  
			  
			  <button id="btn3" type="button" class="btn btn-danger btn-lg btn-block" >
				  上传文件
			  </button>
		  
	   </form>
		
	  </div>
	</div>




        <script type="text/javascript">
		
			var md5 = "";//用于记录文件的md5指纹码
			var md5OnReady = false;//md5是否准备就绪
			
			if(typeof new FileReader().readAsBinaryString === 'undefined'){
				$("#e1").html('<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>');
				$("#tb1").hide();
				$("#tb3").hide();
				alert("抱歉，您的浏览器不支持秒传功能！");
            }
			if(typeof new FileReader().readAsBinaryString === 'function'){
                //alert("恭喜，您的浏览器支持秒传功能！");
				$("#e1").html('<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>');
            }
			//val是number类型
			function setProgress(val){
				$('#jindu').css("width",parseInt(val)+"%").html(val.toFixed(1)+"%");
			}
		
        
            document.getElementById("file").addEventListener("change", function() {
				var overSize = 0;
                var fileReader = new FileReader(), box = document.getElementById('box');
                blobSlice = File.prototype.mozSlice || File.prototype.webkitSlice || File.prototype.slice, file = document.getElementById("file").files[0], chunkSize = 1048576,
                // read in chunks of 2MB
                chunks = Math.ceil(file.size / chunkSize), currentChunk = 0, spark = new SparkMD5();
				box.innerHTML = '正在读取MD5文件指纹...';
				md5OnReady = false;
                fileReader.onload = function(e) {
                    console.log("read chunk nr", currentChunk + 1, "of", chunks);
                    spark.appendBinary(e.target.result);
                    // append binary string
                    currentChunk++;

                    if (currentChunk < chunks) {
                        loadNext();
                    } else {
                        console.log("finished loading");
                        md5 = spark.end();
                        box.innerHTML = 'MD5 hash:' + md5;
						setProgress(100);
						md5OnReady = true;//md5准备就绪
                        console.info("computed hash", spark.end());
						//alert("读取完成");
                        // compute hash
                    }
                };

                function loadNext() {
                    var start = currentChunk * chunkSize, end = start + chunkSize >= file.size ? file.size : start + chunkSize;
					overSize = start;
					try {
					 fileReader.readAsBinaryString(blobSlice.call(file, start, end));
					 box.innerText = '正在读取MD5文件指纹：'+parseFloat(overSize*100/file.size).toFixed(2)+"%";
					 setProgress(overSize*100/file.size);
					} catch (e) {
					 alert("读取MD5指纹失败！");
					}
                    
                }

                loadNext();

            });
            
            
            $("#btn3").click(function(){
         
            	if(!md5OnReady){
            		if(window.confirm("MD5尚未准备就绪，现在上传将不会支持秒传功能，确定上传吗？")){
            			$("form").submit();
            		}else{
            			return;
            		}
            	}
            	//先尝试秒传，如果失败，普通上传
            	//data是服务器返回的结果：1成功，2未登录，0业务逻辑层失败
            	var fileName = $("#file").val();
            	alert(fileName);
            	$.post('/home/ajax/upload/miao',
            	{"md5":md5,"filename":fileName},function(data){
            		if(data.code==0){
            			window.location.href="/login";
            		}
            		if(data.code==1){
            			$("form").submit();
            		}
            		if(data.code==2){
            			alert("秒传成功");
            			window.location.href=window.location.href;
            		}
            	});
            });
        </script>

</div>


</body>
</html>		
