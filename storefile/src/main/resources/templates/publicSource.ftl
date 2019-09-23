<!DOCTYPE html>
<html>
<head>
   <title>彩壳网络硬盘</title>
<link href="/assets/util/bootstrap3.3.0/css/bootstrap.min.css" rel="stylesheet">
   <script src="/assets/util/jquery1.10.1/jquery-1.10.1.min.js"></script>
   <script src="/assets/util/bootstrap3.3.0/js/bootstrap.min.js"></script>
   <script src="/assets/js/jqpaginator.min.js"></script>
<style type="text/css">
#customers
  {
  font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
  width:100%;
  border-collapse:collapse;
  }

#customers td, #customers th 
  {
  font-size:1em;
  border:1px solid #98bf21;
  padding:3px 7px 2px 7px;
  }

#customers th 
  {
  font-size:1.1em;
  text-align:left;
  padding-top:5px;
  padding-bottom:4px;
  background-color:#A7C942;
  color:#ffffff;
  }

#customers tr.alt td 
  {
  color:#000000;
  background-color:#EAF2D3;
  }
.customBootstrap .pagination>li>a{margin-right:5px;border-radius:2px;background:#fff;color:#333;border-color:#ccc;padding:6px 15px}.customBootstrap .pagination>li>a:hover,.customBootstrap .pagination>li>a:focus{color:#fff;background:#fb9400;border-color:#fb9400}.customBootstrap .pagination>.active>a,.customBootstrap .pagination>.active>a:hover,.customBootstrap .pagination>.active>a:focus{color:#fff;background:#fb9400;border-color:#fb9400}.customBootstrap .pagination .arrow2{margin:3px 8px 5px 0}.customBootstrap .pagination a:hover .arrow2{border-right-color:#fff}.customBootstrap .pagination .arrow3{margin:3px 0 5px 8px}.customBootstrap .pagination a:hover .arrow3{border-left-color:#fff}
</style>
</head>
<body>


<!-- head-start -->
<#include "head.ftl" >
<input type="hidden" id="pageTag" value="publicSourse" >
<!-- head-end -->

<div class="container" style="">

<table id="customers">
<tr>
<th>id</th>
<th>文件名称</th>
<th>文件大小（k）</th>
<th>上传时间</th>
<th>分享者</th>
<th>下载次数</th>
<th>操作</th>
</tr>

<#list data.content as fo>
<tr>
<td>${fo.id }</td>
<td>${fo.name }</td>
<td>${fo.source.size }</td>
<td>${fo.createTime }</td>
<td>${fo.user.username }</td>
<td id="ci${fo.id }">${fo.downTimes }</td>
<td>
<a href="/download/${fo.id}">下载</a>
</td>
</tr>
</#list>


</table>
  
<center class="customBootstrap">
	<ul id="demo2" class="pagination"></ul>
</center>

<div class="container" >

<script type="text/javascript">
function download(fid){
	$.post("<%=path%>/ajaxCanDownload.action",{"fid":fid},function(data){
		if(data=="1"){
			var ci = $("#ci"+fid).text();
			$("#ci"+fid).text(parseInt(ci)+1);
			window.location.href="<%=path%>/download.action?fid="+fid;
		}else{
			alert("无权下载当前文件，可能提供者已经取消了共享...");
		}
	});
}
$(function(){
	$("#demo2").jqPaginator({
            totalPages: ${data.totalPages},
            visiblePages: 6,
            currentPage: ${data.number+1},
            first: '<li class="first"><a href="javascript:void(0);">首页<\/a><\/li>',
            prev: '<li class="prev"><a href="javascript:void(0);"><i class="arrow arrow2"><\/i>上一页<\/a><\/li>',
            next: '<li class="next"><a href="javascript:void(0);">下一页<i class="arrow arrow3"><\/i><\/a><\/li>',
            last: '<li class="last"><a href="javascript:void(0);">末页<\/a><\/li>',
            page: '<li class="page"><a href="javascript:void(0);">{{page}}<\/a><\/li>',
            onPageChange: function (n,t) {
                //$("#demo2-text").html("当前第" + n + "页");
                if(t=='change'){
                	window.location.href='/public.html?page='+n;
                }
                
            }
        });

});
</script>

</body>
</html>		
