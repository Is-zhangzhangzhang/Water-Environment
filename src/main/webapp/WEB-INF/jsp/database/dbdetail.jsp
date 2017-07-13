<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container" style="width:1100px">
	<table class="table table-hover" >
		<thead>
			<tr>
				<th class="col-lg-3 col-md-3 text-center"><span class="glyphicon glyphicon-hdd"></span>表名</th>
				<th class="col-lg-3 col-md-3 text-center"><span class="glyphicon glyphicon-list-alt"></span>详情</th>
				<th class="col-lg-3 col-md-3 text-center"><span class="glyphicon glyphicon-wrench"></span>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${tableMap}" var="table">
			<tr>
				<td class="text-center"><a href="#">${table.key}</a></td>
				<td class="text-center"><a data-toggle="collapse" data-parent="#accordion"
					href="#collapse${table.key }" onclick = "loadData('${dbname }', '${table.key}')"> 查看表内容 </a></td>
				<td class="text-center"><button>删除</button></td>
			</tr>
			<tr>
				<td colspan="3"><div id="collapse${table.key }" class=" collapse  table-responsive" style="width:1050px" >
						 <table id="query_results${dbname }${table.key }" class="table table-hover" style="word-break:break-all;">
							<thead>
								<tr>
									<c:forEach items="${table.value}" var="column">
									<th style="word-break:break-all;" data-field="${column }">${column }</th>
									</c:forEach>
								</tr>
							</thead>
							
						</table>
					</div>
			    </td>

			</tr>

			</c:forEach>
		</tbody>
	</table>

</div>

<script src="${pageContext.request.contextPath}/assets/scripts/database.js"></script>