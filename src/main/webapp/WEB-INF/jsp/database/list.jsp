<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container" style="width:1100px">
<table class="table table-hover table-font">
    
    <thead>
      <tr>
        <th class="col-lg-1 col-md-1 text-center"><span class="glyphicon glyphicon-hdd"></span>数据库名</th>
        <th class="col-lg-4 col-md-4 text-center"><span class="glyphicon glyphicon-tag"></span>描述</th>
        <th class="col-lg-2 col-md-2 text-center"><span class="glyphicon glyphicon-time"></span>创建时间</th>
        <th class="col-lg-1 col-md-1 text-center"><span class="glyphicon glyphicon-folder-close"></span>大小</th>
        <th class="col-lg-1 col-md-1 text-center"><span class="glyphicon glyphicon-user"></span>创建者</th>
        <th class="col-lg-1 col-md-1 text-center"><span class="glyphicon glyphicon-wrench"></span>操作</th>
        </tr>
    </thead>
    <tbody>
     <c:forEach items="${dbList}" var="db">
    <tr>
    <td class="text-center"><a onclick = "showTables('${db.getDatabaseName() }')">${db.getDatabaseName() }</a></td>
    <td style="word-break:break-all;">utjgkarigjklethgjahjgkarigjklethgjahjgkarigjklethgjahjgkarigjklethgjahkjjagjkdjg</td>
    <td class="text-center">2017-01-21 00:00:00</td>
    <td class="text-center">${db.getSize() }</td>
    <td class="text-center">hy</td>
    <td class="text-center"><button>删除</button></td>
    </tr>
    </c:forEach>
  
    
     </tbody>
     </table>
      
</div>
<script src="${pageContext.request.contextPath}/assets/scripts/database.js"></script>
<script>

function showTables(dbname) {
	//alert(dbname);
	$.ajax({
		url : "database/listdbdetail",
		type : "GET",
		async : true,
		cache : false,
		data : {
			"dbname" : dbname,
		},
		success : function(data) {
			 $('#main-content').html(data);
		}
		
	});
}
</script>