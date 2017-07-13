/**
 * Created by Administrator on 2016/8/31.
 */
function deleteUser(username){
	if (!confirm('确定要删除'+username+'吗？')) {
        return false;
    }
	$.ajax(
	        {
	            url: "user/delete",
	            type: "GET",
	            async: false,
	            cache: false,
	            data: {
	                "username": username,
	            },
	            success: function (result) {
	                alert(username + "删除成功");
	                res = true;
	            },
	            error: function () {
	                alert(username + "删除失败");
	                res = false;
	            }
	        }
	    );
	    return res;	
}
