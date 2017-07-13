<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="${pageContext.request.contextPath}/assets/css/pages/fileinput.css" media="all" rel="stylesheet"
      type="text/css"/>


<div>
    <div style="margin-top: 10px">
        <div class="panel panel-danger table-font">
            <!-- Default panel contents -->
            <div class="panel-heading">${algorithm.algorithmName}</div>
            <div class="panel-body">
                ${algorithm.algorithmTip}
            </div>
        </div>
    </div>


    <div class="form-group">
        <input type="file" name="file" id="fileinput" multiple class="file" data-upload-url="file/upload"
               data-preview-file-type="text">
    </div>


    <div class="input-group" id="cmdDiv">
        <input type="text" class="form-control" placeholder="Command" id="command">
          <span class="input-group-btn">
            <button class="btn btn-success" type="button" onclick="cmd_check()">执行命令</button>
          </span>
    </div>

    <div class="alert alert-danger alert-dismissible" role="alert" id="nofile" hidden>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                aria-hidden="true">&times;</span></button>
        <strong>Error!</strong> 未检测到上传文件.请您先上传文件，后执行命令.
    </div>
    <div class="alert alert-danger alert-dismissible" role="alert" id="nomatch" hidden>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                aria-hidden="true">&times;</span></button>
        <strong>Error!</strong> 您输入的命令存在问题,请按照输入规则检查后重试.
    </div>

</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header input-group">
                <h4 class="modal-title" id="myModalLabel">输出日志</h4>
                <span class="input-group-btn">
                    <button type="button" class="btn btn-primary" id="saveLog">Save</button>
                    <button type="button" class="btn btn-primary" id="next" disabled>Next</button>
                </span>
            </div>
            <script type="text/javascript">
                $('#saveLog').click(function () {
                    alert('ok');
                });
            </script>
            <div class="modal-body" style="height:auto;width: auto;background-color: #2e2e2e;">
                <div id="modelLog" style="color: #FFFFFF">

                </div>
            </div>
            <%--<div class="modal-footer">--%>

            <%--</div>--%>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/assets/plugins/upload/fileinput.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/upload/fileinput_locale_zh.js"
        type="text/javascript"></script>

