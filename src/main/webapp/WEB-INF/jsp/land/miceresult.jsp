<%--
  Created by IntelliJ IDEA.
  User: zhonghua
  Date: 2016/9/6
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="index-box">
    <pre>填充后数据前10行:<a href="file/download?fileName=result.csv" target="_Blank" style="margin-left: 10px">结果文件</a>
    <br/>${miceResult}</pre>
</div>

<div class="index-box">
  <pre>数据缺失情况统计:<br/>${mdPattern}</pre>
</div>

<div class="index-box">
  <pre>填充前数据前10行:<br/>${dataHead}</pre>
</div>



