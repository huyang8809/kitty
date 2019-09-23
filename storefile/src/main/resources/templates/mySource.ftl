<!DOCTYPE html>
<html>
<head>
    <title>彩壳网络硬盘</title>
    <link href="/assets/util/bootstrap3.3.0/css/bootstrap.min.css" rel="stylesheet">

    <script src="/assets/util/jquery1.10.1/jquery-1.10.1.min.js"></script>
    <script src="/assets/util/bootstrap3.3.0/js/bootstrap.min.js"></script>

    <link href="/assets/util/jPlayer-2.9.2/dist/skin/blue.monday/css/jplayer.blue.monday.min.css" rel="stylesheet"
          type="text/css"/>
    <script src="/assets/util/jPlayer-2.9.2/dist/jplayer/jquery.jplayer.min.js" type="text/javascript"></script>

    <!-- bootstrap-switch -->
    <link href="/assets/util/bootstrap-switch/css/bootstrap3/bootstrap-switch.min.css" rel="stylesheet">
    <script src="/assets/util/bootstrap-switch/js/bootstrap-switch.min.js"></script>

    <!-- grumble气泡 -->
    <link href="/assets/util/grumble/css/grumble.min.css" rel="stylesheet">
    <script src="/assets/util/grumble/js/jquery.grumble.min.js"></script>

    <script src="/assets/js/jqpaginator.min.js"></script>
    <script src="/assets/js/qrcode.min.js"></script>

    <style type="text/css">
        #customers {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            width: 100%;
            border-collapse: collapse;
        }

        #customers td, #customers th {
            font-size: 1em;
            border: 1px solid #98bf21;
            padding: 3px 7px 2px 7px;
        }

        #customers th {
            font-size: 1.1em;
            text-align: left;
            padding-top: 5px;
            padding-bottom: 4px;
            background-color: #A7C942;
            color: #ffffff;
        }

        #customers tr.alt td {
            color: #000000;
            background-color: #EAF2D3;
        }
    </style>
</head>
<body>


<!-- head-start -->
<#include "head.ftl" >
<input type="hidden" id="pageTag" value="mySourse">
<!-- head-end -->

<div class="container" style="">
    <input type="button" value="显示" onclick="$('#myModal').modal('show')" style="display:none;">
    <input type="button" value="隐藏" onclick="$('#myModal').modal('hide')" style="display:none;">
    <table id="customers">
        <tr>
            <th>文件ID</th>
            <th>文件名称（双击文件名修改）</th>
            <th>文件大小（b）</th>
            <th>上传时间</th>
            <th>当前权限</th>
            <th>操作</th>
        </tr>
	<#if data?exists>
        <#list data.content as fo >
<tr id="hang66">
    <td>${fo.id}</td>
    <td fid="${fo.id }" fnBox style="width:350px;max-width: 350px;">
        <div>${fo.name }</div>
        <div class="input-group" style="display:none;">
            <input type="text" class="form-control" placeholder="请填写文件名称" value="">
            <span class="input-group-btn">
		<button class="btn btn-success fnYES" type="button">确定</button>
		<button class="btn btn-danger fnNO" type="button">取消</button>
	</span>
        </div>
    </td>
    <td>${fo.source.size }</td>
    <td>${fo.createTime }</td>
    <td>
        <input type="checkbox" class="btnSwitch" fileId="${fo.id }" ${(fo.state==1)?string('checked','') } >
    </td>
    <td style="width:130px;">
        <a href="/download/${fo.id}" class="btnDL" fid="${fo.id}">下载</a>
        <a href="javascript:ajaxDeleteFile(@{uso.id });">删除</a>

<#if fo.name?ends_with('.mp4') >
<a href="javascript:showVideoBox(${fo.id },'${fo.name }');">播放</a>
</#if>

    </td>
</tr>
        </#list>
    </#if>

    </table>

    <center class="customBootstrap">
        <ul id="demo2" class="pagination"></ul>

    </center>
    <style>
        .customBootstrap .pagination > li > a {
            margin-right: 5px;
            border-radius: 2px;
            background: #fff;
            color: #333;
            border-color: #ccc;
            padding: 6px 15px
        }

        .customBootstrap .pagination > li > a:hover, .customBootstrap .pagination > li > a:focus {
            color: #fff;
            background: #fb9400;
            border-color: #fb9400
        }

        .customBootstrap .pagination > .active > a, .customBootstrap .pagination > .active > a:hover, .customBootstrap .pagination > .active > a:focus {
            color: #fff;
            background: #fb9400;
            border-color: #fb9400
        }

        .customBootstrap .pagination .arrow2 {
            margin: 3px 8px 5px 0
        }

        .customBootstrap .pagination a:hover .arrow2 {
            border-right-color: #fff
        }

        .customBootstrap .pagination .arrow3 {
            margin: 3px 0 5px 8px
        }

        .customBootstrap .pagination a:hover .arrow3 {
            border-left-color: #fff
        }
    </style>
    <div class="container">


        <!-- 模态框（Modal-Start） -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
             aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close"
                                data-dismiss="modal" aria-hidden="true">
                            &times;
                        </button>
                        <h4 class="modal-title" id="myModalLabel">
                            修改文件属性
                        </h4>
                    </div>
                    <div class="modal-body">
                        <div class="input-group">
                            <span class="input-group-addon">文件名称</span>
                            <input id="txt0" type="hidden" value="0">
                            <input id="txt1" type="text" class="form-control" placeholder="请输入文件名">
                        </div>
                        <br><br>
                        文件权限:
                        <input id="bt1" type="radio" value="1" name="state">公开
                        <input id="bt2" type="radio" value="0" name="state">私有
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default"
                                data-dismiss="modal">关闭
                        </button>
                        <button type="button" class="btn btn-primary" onclick="xiugai();">
                            提交更改
                        </button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>
        <!-- 模态框（Modal-End） -->

        <!-- 模态框-Video（Modal-Start） -->
        <div class="modal fade" id="videoModal" tabindex="-1" role="dialog"
             aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog" style="width:510px">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close"
                                data-dismiss="modal" aria-hidden="true">
                            &times;
                        </button>
                        <h4 class="modal-title" id="myModalLabel">
                            视频播放
                        </h4>
                    </div>
                    <div class="modal-body">

                        <div id="jp_container_1" class="jp-video jp-video-270p" role="application"
                             aria-label="media player">
                            <div class="jp-type-single">
                                <div id="jquery_jplayer_1" class="jp-jplayer"></div>
                                <div class="jp-gui">
                                    <div class="jp-video-play">
                                        <button class="jp-video-play-icon" role="button" tabindex="0">play</button>
                                    </div>
                                    <div class="jp-interface">
                                        <div class="jp-progress">
                                            <div class="jp-seek-bar">
                                                <div class="jp-play-bar"></div>
                                            </div>
                                        </div>
                                        <div class="jp-current-time" role="timer" aria-label="time">&nbsp;</div>
                                        <div class="jp-duration" role="timer" aria-label="duration">&nbsp;</div>
                                        <div class="jp-controls-holder">
                                            <div class="jp-controls">
                                                <button class="jp-play" role="button" tabindex="0">play</button>
                                                <button class="jp-stop" role="button" tabindex="0">stop</button>
                                            </div>
                                            <div class="jp-volume-controls">
                                                <button class="jp-mute" role="button" tabindex="0">mute</button>
                                                <button class="jp-volume-max" role="button" tabindex="0">max volume
                                                </button>
                                                <div class="jp-volume-bar">
                                                    <div class="jp-volume-bar-value"></div>
                                                </div>
                                            </div>
                                            <div class="jp-toggles">
                                                <button class="jp-repeat" role="button" tabindex="0">repeat</button>
                                                <button class="jp-full-screen" role="button" tabindex="0">full screen
                                                </button>
                                            </div>
                                        </div>
                                        <div class="jp-details">
                                            <div class="jp-title" aria-label="title">&nbsp;</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="jp-no-solution">
                                    <span>Update Required</span>
                                    To play the media you will need to either update your browser to a recent version or
                                    update your <a href="http://get.adobe.com/flashplayer/" target="_blank">Flash
                                    plugin</a>.
                                </div>
                            </div>
                        </div>


                    </div>
                    <div class="modal-footer">
                        <!--  <button type="button" class="btn btn-default"
                            data-dismiss="modal">关闭
                         </button> -->
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>
        <!-- 模态框-Video（Modal-End） -->

        <script type="text/javascript">
            var videoTitle = '';
            var videoUrl = '';

            function showVideoBox(fid, fname) {
                $("#videoModal").modal('show');
                videoTitle = fname;
                videoUrl = "/download/" + fid;
                $("#jquery_jplayer_1").jPlayer("setMedia", {
                    title: videoTitle,
                    m4v: videoUrl,
                    poster: "http://www.jplayer.org/video/poster/Big_Buck_Bunny_Trailer_480x270.png"
                });
                $("#jquery_jplayer_1").jPlayer("play");
            }


            function ajaxDeleteFile(fid) {
                if (window.confirm("确定要删除这个文件吗？")) {
                    $.post('<%=path%>/ajaxDeleteFile.action', {"fid": fid}, function (data) {
                        if (data == "1") {
                            $("#hang" + fid).remove();
                        }
                        if (data == "0") {
                            alert("删除失败，请联系管理员！");
                        }
                        if (data == "2") {
                            window.location.href = "<%=path%>/login.jsp";
                        }
                    });
                }
            }


            $(function () {
                $("#jquery_jplayer_1").jPlayer({
                    ready: function () {
                        $(this).jPlayer("setMedia", {
                            title: videoTitle,
                            m4v: videoUrl,
                            poster: "http://www.jplayer.org/video/poster/Big_Buck_Bunny_Trailer_480x270.png"
                        });
                        $("#jquery_jplayer_1").jPlayer("play");
                    },
                    swfPath: "/util/jPlayer-2.9.2/dist/jplayer",
                    supplied: "m4v",
                    size: {
                        width: "478px",
                        //height: "240px",
                        cssClass: "jp-video-270p"
                    },
                    useStateClassSkin: true,
                    autoBlur: false,
                    smoothPlayBar: true,
                    keyEnabled: true,
                    remainingDuration: true,
                    toggleDuration: true
                });


                $("#videoModal").on('hidden.bs.modal', function () {
                    $("#jquery_jplayer_1").jPlayer("stop");
                });

                $(".btnSwitch").bootstrapSwitch({
                    onText: "公开",
                    offText: "私有"
                });

                $(".btnSwitch").on('switchChange.bootstrapSwitch', function (event, state) {
                    var el = this;
                    var fileId = $(el).attr("fileId");
                    var stVal = state ? 1 : 0;
                    if (el.busy) {
                        return;
                    }
                    el.busy = true;
                    $.post('/home/ajaxUpdateFileState', {fid: fileId, st: stVal}, function (data) {
                        if (data.code == 1) {
                            //$(el).bootstrapSwitch("toggleState");
                        }
                        if (data.code == 0) {
                            window.location.href = "/login";
                        }
                        el.busy = false;
                    });
                });

                $("[fnBox]").dblclick(function () {
                    var tr = $(this);
                    var tx = tr.find("input");
                    var ht = tr.find("div:eq(0)").html();

                    tr.find("div:eq(0)").hide();
                    tr.find("div:eq(1)").show();

                    tx.val("").focus().val(ht);

                });
                $("[fnBox] .fnNO").click(function () {
                    var tr = $(this).parent().parent().parent();
                    tr.find("div:eq(0)").show();
                    tr.find("div:eq(1)").hide();
                });
                $("[fnBox] .fnYES").click(function () {
                    var tr = $(this).parent().parent().parent();
                    var fileId = tr.attr("fid");
                    var fnVal = tr.find("input").val();
                    $.post('/home/ajaxUpdateFileName', {fid: fileId, fn: fnVal}, function (data) {
                        if (data.code == 0) {
                            window.location.href = "/login";
                        }
                        if (data.code == 1) {
                            tr.find("div:eq(0)").html(fnVal);
                            tr.find("div:eq(0)").show();
                            tr.find("div:eq(1)").hide();
                        }
                    });

                });
                $("[fnBox] input").keydown(function (e) {
                    var tr = $(this).parent().parent();
                    if (e.keyCode == 13) {
                        tr.find(".fnYES").click();
                    }
                });

                $("[fnBox] div:eq(0)").grumble(
                        {
                            text: '双击文件名可修改!',
                            angle: 156,
                            distance: 0,
                            showAfter: 800,
                            hideAfter: 2500,
                            hasHideButton: false
                        }
                );

                $(".btnDL").popover({
                    trigger: 'hover',
                    html: true,
                    placement: 'left',
                    title: "扫描二维码可以下载到移动端",
                    content: function () {
                        var fid = $(this).attr("href");
                        ;
                        var img = 'assets/images/Mr.Xia.jpg';

                        var div = $('<div></div>');

                        var qrcode = new QRCode(div[0], {
                            width: 200,
                            height: 200
                        });

                        qrcode.makeCode('http://192.168.26.210:8080/download/' + $(this).attr('fid'));

                        return div;
                    }
                });

            });

            $(function () {
                $("#demo2").jqPaginator({
                    totalPages: ${data.totalPages},
                    visiblePages: 10,
                    currentPage: ${data.number+1},
                    first: '<li class="first"><a href="javascript:void(0);">首页<\/a><\/li>',
                    prev: '<li class="prev"><a href="javascript:void(0);"><i class="arrow arrow2"><\/i>上一页<\/a><\/li>',
                    next: '<li class="next"><a href="javascript:void(0);">下一页<i class="arrow arrow3"><\/i><\/a><\/li>',
                    last: '<li class="last"><a href="javascript:void(0);">末页<\/a><\/li>',
                    page: '<li class="page"><a href="javascript:void(0);">{{page}}<\/a><\/li>',
                    onPageChange: function (n, t) {
                        //$("#demo2-text").html("当前第" + n + "页");
                        if (t == 'change') {
                            window.location.href = '/source.html?page=' + n;
                        }

                    }
                });

            });


        </script>

</body>
</html>		
