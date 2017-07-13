<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="${pageContext.request.contextPath}/assets/css/pages/fileinput.css" media="all" rel="stylesheet"
      type="text/css"/>
<link href="${pageContext.request.contextPath}/assets/css/loading.css" media="all" rel="stylesheet"
      type="text/css"/>
<div>
    <div class="index-box">
        <p class="box-name">缺失数据填充</p>
        <p class="box-content">针对土地资源数据在采集和处理过程中导致的数据缺失，使用基于分布式减法聚类的不完整数据填充算法对缺失数据进行填充，从而使得数据在预处理阶段达到知识挖掘的要求。</p>
    </div>
    <div class="alert alert-danger" role="alert">
        <span class="glyphicon glyphicon-warning-sign"></span><strong>注意！您的上传数据文件需满足以下约束：</strong><br/>
        1.缺失数据填充上传文件格式只能为<code>txt</code>、<code>csv</code>、<code>xls</code>和<code>xlsx</code>，建议使用<code>csv</code>或<code>xls</code>作为上传文件格式，其他文件格式暂不支持.<br/>
        2.文件中缺失数据的表示形式需为<code>"NA"</code>，其他类型暂不支持.<br/>
        3.请确保您上传的文件中的数据为数值型，其他类型的数据填充暂不支持.<br/>
        4.请确保您数据中的某些特征或样本缺失的数据少于总样本数的5%，否则填充算法对该数据可能无效或得出偏差较大的填充结果.<br/>
        下载：
        <a href="file/download?fileName=sample.csv" target="_Blank">数据样例1</a>、
        <a href="file/download?fileName=sample2.csv" target="_Blank">数据样例2</a>
    </div>

    <div class="form-group">
        <input id="micefile" type="file" name="file" multiple class="file" data-upload-url="file/upload" data-file-upload-preview="text"
               data-min-file-count="1">
    </div>

    <div class="alert alert-danger alert-dismissible" role="alert" id="no_upload_file" hidden>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                aria-hidden="true">&times;</span></button>
        <strong>Error!</strong> 未检测到上传文件.请您先上传文件，后执行填充操作.
    </div>

    <div class="alert alert-danger alert-dismissible" role="alert" id="bad_file" hidden>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                aria-hidden="true">&times;</span></button>
        <strong>Error!</strong> 您的文件未满足约束，请检查后重新上传.
    </div>

    <div class="imputation-execute">
        <span class="alert alert-danger col-md-9 col-lg-9" role="alert">
        <span class="glyphicon glyphicon-warning-sign"><strong>执行填充之前请您再次确认您的文件是否满足约束要求.</strong></span>
            </span>
        <button class="btn btn-success execute-btn col-md-3 col-lg-3" onclick="imputation_execute()">执行填充</button>
    </div>

    <div class="alert alert-danger alert-dismissible" role="alert" id="bad_result" hidden>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                aria-hidden="true">&times;</span></button>
        <strong>Error!</strong> 您的文件在执行时发生异常，可能是您的文件数据未满足约束，请检查后重新上传执行.
    </div>

    <div id="mice_result" hidden>

    </div>
</div>

<div class="modal fade" id="my_modal_loading" tabindex="-1" role="dialog" data-backdrop="static">
    <div id="loading">
        <div id="loading-center">
            <div id="loading-center-absolute">
                <div class="object" id="object_one"></div>
                <div class="object" id="object_two" style="left:20px;"></div>
                <div class="object" id="object_three" style="left:40px;"></div>
                <div class="object" id="object_four" style="left:60px;"></div>
                <div class="object" id="object_five" style="left:80px;"></div>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/assets/plugins/upload/fileinput.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/upload/fileinput_locale_zh.js"
        type="text/javascript"></script>
