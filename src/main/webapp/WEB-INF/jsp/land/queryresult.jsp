<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${queryresults}" var="queryresults">
    <div>
        <a href="${fileurl}+${queryresults.resultTitle}" class="mine-result-title">${queryresults.resultTitle}</a>
        <p class="mine-result-content">${queryresults.resultContent}</p>
    </div>
</c:forEach>




