<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
    <div class="index-box">
        <p class="box-name">用户列表</p>
    </div>

    <table class="table table-hover table-responsive table-font">
        <thead>
        <tr>
            <td></td>
            <td>用户名</td>
            <td>全名</td>
            <td>Email</td>
            <td>地址</td>
            <td>城市</td>
            <td>国家</td>
            <td>权限</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="users">
            <tr class="users">
                    <c:choose>
                        <c:when test="${users.userAuthority == 0}">
                        <td><input type="checkbox" name = "user" value=${users.userName}></td>
                        </c:when>
                        <c:otherwise>
                        <td></td>
                        </c:otherwise>
                    </c:choose>
                <td>${users.userName}</td>
                <td>${users.userRealname}</td>
                <td>${users.userEmail}</td>
                <td>${users.userAddress}</td>
                <td>${users.userCity}</td>
                <td>${users.userCountry}</td>
                <c:choose>
                        <c:when test="${users.userAuthority == 0}">
                        <td>普通用户</td>
                        </c:when>
                        <c:otherwise>
                        <td>管理员</td>
                        </c:otherwise>
                    </c:choose>

            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div><input type = "button" id = "delete" value = "删除"></div>
</div>




<script src="${pageContext.request.contextPath}/assets/plugins/smartmenu/jquery.contextmenu.r2.js"
        type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/scripts/user.js"></script>
<script type="text/javascript">
    $("#delete").click( function(){
    	var deleteRow = [];
    	var i  = 0;
    		 obj = document.getElementsByName("user");
    		    for(k in obj){
    		        if(obj[k].checked){
    		            if(deleteUser(obj[k].value)){
    		            	deleteRow.push(k);
    		            	i++;
    		            }
    		            
    		        }
    		    }
    		    for(var j =--i ;j>=0;j--){
    		    	obj[deleteRow[j]].parentNode.parentNode.remove();
    		    }
    }
    		);
    $("tr").click(function () {
        if ($(this).children('td').children('input').attr('checked')) {
            $(this).children('td').children('input').attr('checked', false);
        } else {
            $(this).children('td').children('input').attr('checked', true);
        }
    });
</script>

