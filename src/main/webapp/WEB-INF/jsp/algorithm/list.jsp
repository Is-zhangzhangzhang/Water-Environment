<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href="${pageContext.request.contextPath}/assets/css/pages/fileinput.css" media="all" rel="stylesheet"
      type="text/css"/>
<link href="${pageContext.request.contextPath}/assets/css/loading.css" media="all" rel="stylesheet"
      type="text/css"/>

<div>
    <div class="alert alert-success alert-font" role="alert">
        <table>
            <tr>
                <td><strong>Algorithm</strong></td>
                <td>${cls.className}</td>
            </tr>
            <tr>
                <td style="vertical-align:top;"><strong>Description</strong></td>
                <td>${cls.classDescribe}</td>
            </tr>
        </table>
    </div>


    <table class="table table-hover table-font">
        <thead>
        <tr>
            <td class="col-lg-1 col-md-1 text-center"><span class="glyphicon glyphicon-cloud" aria-hidden="true"></span>名称</td>
            <td class="col-lg-5 col-md-5 text-center"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>描述</td>
            <td class="col-lg-2 col-md-2 text-center"><span class="glyphicon glyphicon-time" aria-hidden="true"></span>创建时间</td>
            <td class="col-lg-1 col-md-1"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>创建者</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${algorithms}" var="algorithms">
            <tr>
                <td class="text-center"><a class="more" href="javascript:void(0);" onclick="algorithmtooltip(this)" value="${algorithms.algorithmId}">${algorithms.algorithmName}</a></td>
                <td>${algorithms.algorithmDescribe}</td>
                <td class="text-center"><fmt:formatDate value="${algorithms.algorithmTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
                <td>${algorithms.algorithmAuthor}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
   
     <!-- 628修改 -->
    <c:choose>
   <c:when test="${sessionScope.authority== 'admin'}"> 
        <table class="table table-hover table-font">
        <tr>
            <div class="text-center" id="addAlg" data-toggle="modal" data-target="#addAlgModal">
                <img src="${pageContext.request.contextPath}/assets/img/node/add_32.png" style="margin-top: 8px"/>
            </div>
        </tr>
    </table>    
   </c:when>
   <c:otherwise>
   </c:otherwise>
</c:choose>
 <!-- 628修改 -->
</div>

<div class="modal fade" id="addAlgModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">添加${cls.className}</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="algName">算法名称</label>
                    <input class="form-control" type="text" id="algName" placeholder="算法名称"/>
                </div>
                <div class="form-group">
                    <label for="algDescribe">算法描述</label>
                    <textarea class="form-control" id="algDescribe" placeholder="算法描述" style="height: 100px"></textarea>
                </div>
                <div class="form-group">
                    <label for="algTip">使用说明</label>
                    <textarea class="form-control" id="algTip" placeholder="使用说明" style="height: 100px"></textarea>
                </div>
                <div class="form-group">
                    <label for="algCmd">标准命令</label>
                    <input class="form-control" id="algCmd" placeholder="标准命令"/>
                </div>

                <div class="form-group">
                    <label>可执行Jar包</label>
                    <input id="" type="file" name="file" multiple class="file" data-upload-url="file/upload"
                           data-file-upload-preview="text" data-min-file-count="1" data-show-preview="false">
                </div>

                <div class="alert alert-danger alert-dismissible" role="alert" id="no_upload_file" hidden>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <strong>Error!</strong> 未检测到上传文件.请您先上传文件，后执行填充操作.
                </div>

                <div class="alert alert-danger alert-dismissible" role="alert" id="addAlgFailed" hidden>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <strong>Error!</strong> 您填写的内容可能为空,请填写后重新提交.
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="addAlgSubmit">提交</button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    function algorithmtooltip(e){
        $.get("algorithm/tooltip?id="+ e.getAttribute("value"), function(rs) {
            document.getElementById("index-page-title").innerHTML="使用说明";
            document.getElementById("page-index").innerHTML+='<li><i class="fa fa-angle-right"></i><a href="">使用说明</a></li>';
            $('#main-content').html(rs);
        });
    }
    /**
     * 添加算法提交
     */
    $('#addAlgSubmit').click(function(){
        if($('#algName').attr("value").trim() == "" || $('#algDescribe').attr("value").trim() == "" ||
                $('#algTip').attr("value").trim() == "" || $('#algCmd').attr("value").trim() == ""){
            $('#addAlgFailed').removeAttr('hidden');
        }else{
            var alg={
                algorithmName:$('#algName').attr("value"),
                algorithmDescribe:$('#algDescribe').attr("value"),
                algorithmTip:$('#algTip').attr("value"),
                algorithmCmd:$('#algCmd').attr("value"),
                classId:${cls.classId},
                className:"${cls.className}"
            };
            $.ajax({
                type:'POST',
                url:'algorithm/add',
                data:JSON.stringify(alg),
                dataType:'json',
                contentType:'application/json; charset=utf-8',
                async:true,
                success:function(data){
                    alert(data['addStatus']);
                },
                error:function (data) {
                    $('#addAlgFailed').removeAttr('hidden');
                }
            });
        }

    });
</script>
<script src="${pageContext.request.contextPath}/assets/plugins/upload/fileinput.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/upload/fileinput_locale_zh.js"
        type="text/javascript"></script>