
/**
 * Created by Administrator on 2016/8/31.
 */
function cmd_check1() {
	var command = $("#command").val();
	$.ajax({
		url : "database/execute",
		type : "GET",
		async : true,
		cache : false,
		data : {
			"command" : command,
		},
		success : function(data) {
			$("#result").val(data);
			res = true;
		},
		error : function() {
			alert("失败");
			res = false;
		}
	});
	return res;
}

// 注意
// 1. contentType: "application/x-www-form-urlencoded"
// 想要后台使用struts来接受数据，或者使用对象.属性的方法获取，需要配置这个form，默认是“json”
// 2. pageNo 第几页，需要使用“Math.ceil(params.offset/params.limit) +
// 1”来计算，params.pageNumber一直获取的是第一页

function loadData(dbname, tbname) {
	//alert(tbname);
	//alert(dbname);
	
	// 表格id
	$('#query_results' + dbname + tbname).bootstrapTable({
		url : 'database/getTableData', // 请求后台的URL（*）
		method : 'get', // 请求方式（*）
		contentType : "application/x-www-form-urlencoded",// 需要设置为这个参数，后台才能通过对象获取值,这里要注意
		dataType : "json",// 期待返回数据类型
		toolbar : '#toolbar', // 工具按钮用哪个容器
		toolbarAlign : "left",// 工具栏对齐方式
		striped : true, // 是否显示行间隔色
		cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination : true, // 是否显示分页（*）
		// sortable: false, //是否启用排序
		sidePagination : "client", // 分页方式：client客户端分页，server服务端分页（*）
		pageNumber : 1, // 初始化加载第一页，默认第一页
		pageSize : 5, // 每页的记录行数（*）
		pageList : [ 5, 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
		sortOrder : "asc", // 排序方式
		search : false,// 搜索功能
		buttonsAlign : "left",// 按钮对齐方式
		// showColumns: true,//列选择按钮
		strictSearch : true,
		clickToSelect : true, // 是否启用点击选中行
		// height: 460, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		uniqueId : "id", // 每一行的唯一标识，一般为主键列
		cardView : false, // 是否显示详细视图
		detailView : false, // 是否显示父子表
		queryParamsType : 'limit',
		queryParams : queryParams,
		responseHandler:function (res) {
			
		//	$('#query_results' + dbname + tbname).bootstrapTable('load', res);
            return res;
        },
	});

	// 默认加载时携带参数
	function queryParams(params) {
		var params = { // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			pageNo : Math.ceil(params.offset / params.limit) + 1, // 页码
			pageSize : params.limit, // 页面大小
			//"status" : $("#status").val(),
			"dbname":dbname,
			"tbname":tbname
		};
		return params;
	}

}

// 点击“查询”按钮
$("#query").bind("click", function() {
	// 两种方式：
	// 1.直接刷新 $('#query_results').bootstrapTable("refresh", {});
	// 2. 先销毁数据，再次查询，如下
	$("#query_results").bootstrapTable('destroy');
	loadPageData();
});

