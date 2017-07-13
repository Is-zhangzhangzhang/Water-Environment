$(function() {
    App.init();

    var Index = (function() {
        var me = {};

        // 处理一级菜单点击
        me.handleMenuClick = function() {
            $('#page-sidebar-menu > li').click(function(e) {
                var menu = $('#page-sidebar-menu');
                var li = menu.find('li.active').removeClass('active');
                //$(this).setAttribute("class","active");
                // 添加选中 打开的样式
                $(this).addClass('active');
            });
        };

        // 处理子菜单点击
        me.handleSubMenuClick = function() {
            $('#page-sidebar-menu li a').click(function(e) {
                e.preventDefault();
                var url = this.href;
                if (url != null && url != 'javascript:;') {
                    $.get(url, function (data) {
                    	
                    	if(data.indexOf("用户登录") > 0){
                    		window.location.href = "login";
                    	}
                    	else{
	                        $('#main-content').html(data);
	                        if(url.indexOf("dashboard") == -1){
	                            $("#main-navbar").removeAttr("hidden");
	                        }else{
	                            $("#main-navbar").attr("hidden","hidden");
	                        }
                    	}
                    });
                }
            });
        };


        me.init = function() {
            me.handleMenuClick();
            me.handleSubMenuClick();
        };

        return me;
    })();

    Index.init();
    //dashboard模块被加载的处罚条件
    $('#btn-dashboard').trigger("click");
});

$('#cluster_app').click(function (e) {
    window.open ('http://192.168.10.151:8088/cluster','集群应用管理','height=500,width=800,top=0,left=0,toolbar=no,scrollbars=no,resizable=no,location=yes,status=no,menubar=no')
});

$('#dfs_health').click(function (e) {
	document.getElementById("index-page-title").innerHTML="分布式文件系统";
    document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="javascript:;">大数据管理</a><i class="fa fa-angle-right"></i></li><li><a href="">分布式文件系统</a></li>';
});
//628修改 以后细化
$('#nodelist').click(function(e) {
    document.getElementById("index-page-title").innerHTML="实例管理";
    document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="javascript:;">平台管理</a><i class="fa fa-angle-right"></i></li><li><a href="">实例管理</a></li>';
});
//628修改
$('#userlist').click(function(e) {
    document.getElementById("index-page-title").innerHTML="用户管理";
    document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="javascript:;">平台管理</a><i class="fa fa-angle-right"></i></li><li><a href="">用户管理</a></li>';
});
//628修改 
//7-1修改 
$('#databaseshow').click(function(e) {
    document.getElementById("index-page-title").innerHTML="大数据管理";
    document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="javascript:;">大数据管理</a><i class="fa fa-angle-right"></i></li><li><a href="">数据库操作</a></li>';
});
//7-1修改 
$('#clusterinfo').click(function(e) {
    document.getElementById("index-page-title").innerHTML="集群信息";
    document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="javascript:;">平台管理</a><i class="fa fa-angle-right"></i></li><li><a href="">集群信息</a></li>';
});

$('#algorithmlib li a').click(function(e) {
    document.getElementById("index-page-title").innerHTML="算法";
    document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="main">大数据算法库</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">算法</a></li>';
});

$('#btn-dashboard').click(function(e){
    document.getElementById("index-page-title").innerHTML="大数据计算";
    document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="main">首页</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">大数据计算</a></li>';
});
// 7.2添加
$('#userinfo').click(function(e){
    document.getElementById("index-page-title").innerHTML="信息修改";
    document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="main">个人中心</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">信息修改</a></li>';
});
$('.landmore').click(function(e){
    document.getElementById("index-page-title").innerHTML="土地大数据";
    document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="main">土地大数据</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">核心技术</a></li>';
});

/**
 * 命令执行关键方法
 */
function cmd_check() {
    //判断命令行是否为空，若为空给出提示
    if($('#command').attr("value").trim()==""){
        $('#cmdDiv').addClass("has-error");
    }else{
        //该ajax主要是请求判断文件是否已上传，且对命令进行合法性检查
        $.ajax({
            url:"algorithm/check",
            type:"POST",
            data:{
                "command": $('#command').attr("value")
            },
            async:true,
            beforeSend: function() {
            },
            success:function(data){
                //成功请求后对返回数据进行判断
                var obj=FastJson.format(data);
                //如果判断没有文件，警告框提示
                if(obj["result"]=="nomatch"){
                    $('#nomatch').removeAttr('hidden');
                }else if(obj["result"]=="nofile"){
                    $('#nofile').removeAttr('hidden');
                }else if(obj["result"]=="bothno"){
                    $('#nofile').removeAttr('hidden');
                    $('#nomatch').removeAttr('hidden');
                } else if(obj["result"]=="bothyes"){
                    //如果判断存在文件，则打开模态框等待命令执行
                    $('#myModal').modal('toggle');
                    //该ajax请求主要是提交command进行ssh连接，并不返回log
                    $.ajax({
                        type: 'POST',
                         url: 'algorithm/execute',
                        data:{
                            "command": $('#command').attr("value")
                        },
                        dataType: "text",
                        async: true,
                        success: function(obj){
                            //设置轮询ajax.get请求,请求的方法为重载的'algorithm/execute'
                            //3000ms请求一次
                            var _send = setInterval(function(){
                                $.get('algorithm/execute', function(data) {
                                    //如果返回数据为null,则停止轮询，并将保存和下一步的按钮置为可用状态
                                    if(data=="null"){
                                        window.clearInterval(_send);
                                        $('#saveLog').removeAttr('disabled');
                                        $('#next').removeAttr('disabled');
                                    }else{
                                        //请求结果log返回到模态框中
                                        document.getElementById("modelLog").innerText+=data;
                                    }
                                });
                            },3000);
                        },
                        error: function(data){
                            //发生错误跳转500页面
                            window.location.href="500";
                        }
                    });

                }
            }
        });
    }
}

/**
 * 日志下载
 * @param e
 */




function saveLog(e){
    alert($('#saveLog').html());
    //downloadFile("log.html",document.getElementById("modelLog").innerHTML);

}

/**
 *输出日志的捕获
 * @param fileName
 * @param content
 */
function downloadFile(fileName, content){
    var aLink = document.createElement('a');
    var blob = new Blob([content]);
    var evt = document.createEvent("HTMLEvents");
    evt.initEvent("click", false, false);//initEvent 不加后两个参数在FF下会报错
    aLink.download = fileName;
    aLink.href = window.URL.createObjectURL(blob);
    aLink.dispatchEvent(evt);
}

$('#next').click(function(){

});

/**
 * 简单条件查询
 */
function text_mine(){ 
    $.post('land/text/mine',{
        qt:$('#mtext').attr('value')
    },function(data) {
        if(data.trim()==""){
            $('#queryresult').html("无符合条件内容");
        }else{
            $('#queryresult').html(data);
        }
    });
}

function advanced_mine(){
    $('#advQueryModal').modal('toggle');
}

/**
 * 缺失数据填充方法调用
 */
function imputation_execute() {
    $.post("file/check",function(data){
        if(data['result']=="existfile"){
            $('#my_modal_loading').modal('toggle');
            $.ajax({
                type:'POST',
                url:'land/data/imputation',
                async:true,
                success: function(data){
                    $('#my_modal_loading').modal('toggle');
                    if(data['exception']=='yes'){
                        $('#bad_result').removeAttr('hidden');
                        return;
                    }
                    //alert(data);
                    $('#mice_result').html(data);
                    $('#mice_result').removeAttr('hidden');
                },error: function(data){
                    $('#my_modal_loading').modal('toggle');
                    $('#bad_result').removeAttr('hidden');
                }
            });
        }else if(data['result']=="nofile"){
            $('#no_upload_file').removeAttr('hidden');
        }else if(data['result']=="badfile"){
            $('#bad_file').removeAttr('hidden');
        }
    });
}

$('#sample_download').click(function(e){
    $.get("file/download",{
        fileName:'sample.csv'
    },function(data){
    })
});

$('#rankbar').click(function (e) {
    e.preventDefault();
    var url = this.href;
    $('#main-navbar').attr("hidden","hidden");
    if (url != null && url != 'javascript:;') {
        $.get(url, function (data) {
            $('#main-content').html(data);
        });
    }
});

