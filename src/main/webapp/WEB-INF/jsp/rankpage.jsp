<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container" style="margin-top: 20px">
    <div class="col-mg-5 col-lg-5 rankingbox" style="margin-left: 10px">
        <table class="table table-hover">
            <div class="text-center rankingtitle">
                <span class="text-center rankingtitletext"><img src="${pageContext.request.contextPath}/assets/img/rank/medal_48.png"/>月排行榜</span>
            </div>
            <thead>
                <tr class="rankingtext">
                    <td>排行</td>
                    <td class="rankcol_2" style="text-align: center">用户</td>
                    <td class="rankcol_3">提交数</td>
                </tr>
            </thead>
            <tbody>
            <c:set var="index" value="0" />
            <c:forEach items="${month}" var="month">
                <c:set var="index" value="${index+1}"/>
                <tr class="rankingtext">
                    <td class="rankcol_1" title="${index}">${index}</td>
                    <td class="rankcol_2">
                        <img class="rankcol_2img" src="${pageContext.request.contextPath}/assets/img/rank/pic.jpg"/>
                        <span style="margin-left: 10px">${month.algorithmAuthor}</span>
                    </td>
                    <td class="rankcol_3">${month.submitNumber}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="col-mg-5 col-lg-5 col-mg-offset-1 col-lg-offset-1 rankingbox">
        <table class="table table-hover">
            <div class="text-center rankingtitle">
                <span class="text-center rankingtitletext"><img src="${pageContext.request.contextPath}/assets/img/rank/medal_48.png"/>总排行榜</span>
            </div>
            <thead>
            <tr class="rankingtext">
                <td>排行</td>
                <td class="rankcol_2" style="text-align: center">用户</td>
                <td class="rankcol_3">提交数</td>
            </tr>
            </thead>
            <tbody>
            <c:set var="index" value="0" />
            <c:forEach items="${year}" var="year">
            <c:set var="index" value="${index+1}"/>
                <tr class="rankingtext">
                    <td class="rankcol_1" title="${index}">${index}</td>
                    <td class="rankcol_2">
                        <img class="rankcol_2img" src="${pageContext.request.contextPath}/assets/img/rank/pic.jpg"/>
                        <span style="margin-left: 10px">${year.algorithmAuthor}</span>
                    </td>
                    <td class="rankcol_3">${year.submitNumber}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>