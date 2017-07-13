<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row" style="margin-top: 20px" id="dashboard_2">
    <p class="boardtitle" style="margin-left: 15px">大数据算法库</p>
    <c:forEach items="${classes}" var="classes">
    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <c:choose>
            <c:when test="${classes.classId%4==1}">
                <div class="dashboard-stat blue">
            </c:when>
            <c:when test="${classes.classId%4==2}">
                <div class="dashboard-stat green">
            </c:when>
            <c:when test="${classes.classId%4==3}">
                <div class="dashboard-stat purple">
            </c:when>
            <c:when test="${classes.classId%4==0}">
                <div class="dashboard-stat yellow">
            </c:when>
        </c:choose>
            <div class="visual" style="width: 100px">
                <h4>
                    <strong><a class="a-popover" tabindex="0" onmouseover="popover_show(this)"
                               onmouseout="popover_hide(this)" title="${classes.className}" data-container="body"
                               data-toggle="popover" data-trigger="focus"
                               data-content="${classes.classDescribe}">${classes.className}</a></strong>
                </h4>
            </div>
            <div class="details">
                <div class="number">${classes.classNumber}</div>
            </div>
            <a class="more" href="javascript:void(0);" onclick="viewmore(this)" value="${classes.classId}"> View more <i class="m-icon-swapright m-icon-white"></i>
            </a>
        </div>
    </div>
    </c:forEach>
     <!-- 628修改 -->
     <c:choose>
   <c:when test="${sessionScope.authority== 'admin'}"> 
    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <div class="dashboard-stat" id="addAlgClass" data-toggle="modal" data-target="#addAlgClassModal">
            <div class="text-center" style="margin-top: 20px"><img src="${pageContext.request.contextPath}/assets/img/node/add_64.png"/></div>
        </div>
    </div>  
   </c:when>
   <c:otherwise>
   </c:otherwise>
</c:choose>
     <!-- 628修改 -->
</div>

<div class="modal fade" id="addAlgClassModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">添加算法库类别</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="algClassName">类别名称</label>
                    <input class="form-control" type="text" id="algClassName" placeholder="类别名称"/>
                </div>
                <div class="form-group">
                    <label for="algClassDescribe">类别描述</label>
                    <textarea class="form-control" id="algClassDescribe" placeholder="类别描述" style="height: 200px"></textarea>
                </div>
                <div class="alert alert-danger alert-dismissible" role="alert" id="addClassFailed" hidden>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <strong>Error!</strong> 您填写的内容可能为空,请填写后重新提交.
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="addAlgClassSubmit">提交</button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    function viewmore(e){
        //var url="algorithm/list?id="+ e.getAttribute("value");
        $.ajax({
            type:"GET",
            url:"class/details?id="+ e.getAttribute("value"),
            async:true,
            success:function(data){
                $('#main-navbar').removeAttr("hidden");
                document.getElementById("index-page-title").innerHTML="算法";
                document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="main">算法库</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">算法</a></li>';
                $.get("algorithm/list?id="+data, function(rs) {
                    $('#main-content').html(rs);
                });
            },
            error:function(){
                window.location.href= "404";
            }
        });
    }

    function landmore(e){
        $('#main-navbar').removeAttr("hidden");
        document.getElementById("index-page-title").innerHTML="土地大数据";
        document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="main">土地大数据</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">核心技术</a></li>';
        if($(e).attr("value")==1){
            $.get("land/text/mine", function(rs) {
                $('#main-content').html(rs);
            });
        }else if($(e).attr("value")==2){
            $.get("land/data/imputation", function(rs) {
                $('#main-content').html(rs);
            });
        }else if($(e).attr("value")==3){
            $.get("land/data/transfer", function(rs) {
                $('#main-content').html(rs);
            });
        }
    }

    function popover_show(e){
        $(e).popover('toggle');
    }

    function popover_hide(e){
        $(e).popover('toggle');
    }

    $('#addAlgClassSubmit').click(function () {
        if ($('#algClassName').attr("value").trim() == "" || $('#algClassDescribe').attr("value").trim() == "") {
            $('#addClassFailed').removeAttr('hidden');
        } else {
            $.post("class/add", {
                className: $('#algClassName').attr("value"),
                classDescribe: $('#algClassDescribe').attr("value")
            }, function (data) {
                if (data.trim() == 'success') {
                    window.location.reload();
                } else {
                    $('#addClassFailed').removeAttr('hidden');
                }

            });
        }
    })
</script>