<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--datetimepicker-->
<link href="${pageContext.request.contextPath}/assets/css/datetimepicker/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/assets/plugins/datetimepicker/bootstrap-datetimepicker.min.js" type="text/javascript" ></script>
<script src="${pageContext.request.contextPath}/assets/plugins/datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js" type="text/javascript" ></script>

<div>
    <div class="index-box">
        <p class="box-name">文本挖掘</p>

        <p class="box-content">针对土地文本数据来源广，覆盖面大，涉及内容较多的实际情况，利用文本挖掘的方法实现对不同部门关注的关键信息进行分级、多粒度挖掘，实现多角色的土地文本数据内容推荐服务。</p>
    </div>

    <div class="text-center" style="padding: 20px">
        <span class="mine-title">
            <img src="${pageContext.request.contextPath}/assets/img/search/search_48.png" style="margin-right: 20px"/>
            <strong>Land Text Mining</strong>
        </span>
    </div>

    <div class="input-group mine-box has-success">
        <input type="text" class="form-control" id="mtext">
            <span class="input-group-btn">
                <button class="btn btn-primary" type="button" style="margin-right: 10px" onclick="text_mine()"><span class="glyphicon glyphicon-search"></span>&nbsp;搜索一下</button>
                <button class="btn btn-primary" type="button" onclick="advanced_mine()">高级搜索</button>
            </span>
    </div>

    <div id="queryresult" class="mine-result-box">

    </div>
</div>

<div class="modal fade" id="advQueryModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">高级搜索</h4>
            </div>
            <div class="modal-body">
                <div class="form-group"><label><strong>标题:</strong></label><input class="form-control" type="text" id="querytitle"/></div>
                <div class="form-group"><label><strong>内容:</strong></label><input class="form-control" type="text" id="querycontent"/></div>
                <div class="form-group">
                    <div><label><strong>文件类型:</strong></label></div>

                    <label class="radio-inline">全部<input type="radio" value="*" name="contenttype" checked/></label>
                    <label class="radio-inline">PDF<input type="radio" value="pdf" name="contenttype"/></label>
                    <label class="radio-inline">WORD<input type="radio" value="msword" name="contenttype"/></label>
                    <label class="radio-inline">TEXT<input type="radio" value="text" name="contenttype"/></label>

                </div>
                <div class="form-group">
                    <label><strong>日期:</strong></label>

                    <div class="form-group">
                        <label class="control-label">开始时间:</label>
                        <span class="input-group date form_datetime" data-date="2016-08-12 00:00:00" data-date-format="yyyy-mm-dd hh:ii:ss">
                            <input class="form-control" id="startdate" size="16" type="text" value="2015-01-01 00:00:00" readonly>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                        </span>
                    </div>
                    <div class="form-group">
                        <label class="control-label">结束时间:</label>
                        <span class="input-group date form_datetime" data-date="2016-08-12 00:00:00" data-date-format="yyyy-mm-dd hh:ii:ss">
                            <input class="form-control" id="enddate" size="16" type="text" value="2016-08-12 00:00:00" readonly>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                        </span>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="advTextMine">搜索</button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    //datetimepicker初始化
    $('.form_datetime').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });


    /**
     *高级查询，多种条件查询
     */
    $('#advTextMine').click(function(e){
        $.post('land/text/advmine',{
            title:$('#querytitle').val(),
            content:$('#querycontent').val(),
            contentType:$('input[name="contenttype"]:checked').val(),
            startDate:$('#startdate').val(),
            endDate:$('#enddate').val()
        },function(data){
            $('#advQueryModal').modal('toggle');
            if(data.trim()==""){
                $('#queryresult').html("无符合条件内容");
            }else{
                $('#queryresult').html(data);
            }
            $('#mtext').attr("value","");
        });
    });
</script>

