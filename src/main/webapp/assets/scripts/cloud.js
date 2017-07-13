/**
 * Created by Administrator on 2016/8/31.
 */
function onoff(cmd, ip) {
    var ml;
    if (cmd == 'on') {
        ml = '开启';
        if (!confirm('确定要打开Hadoop集群吗？')) {
            return false;
        }
    }
    if (cmd == 'off') {
        ml = '关闭';
        if (!confirm('确定要关闭Hadoop集群吗？')) {
            return false;
        }
    }
    var res = null;
    $.ajax(
        {
            url: "node/switch",
            type: "GET",
            async: false,
            cache: false,
            data: {
                "ip": ip,
                "cmd": cmd
            },
            success: function (result) {
                if(result=="ok")
                    alert(ml + "Hadoop成功");
                else
                    alert("Hadoop已经处于"+ml+"状态");
                res = true;
            },
            error: function () {
                alert(ml + "失败");
                res = false;
            }
        }
    );
    return res;
}
function shell(ip, tokenName) {
    var url = 'Add.aspx';                             //转向网页的地址;
    var name = 'add';                            //网页名称，可为空;
    var iWidth = 1100;                          //弹出窗口的宽度;
    var iHeight = 800;                         //弹出窗口的高度;
    //获得窗口的垂直位置
    var iTop = (window.screen.availHeight - 30 - iHeight) / 2;
    //获得窗口的水平位置
    var iLeft = (window.screen.availWidth - 10 - iWidth) / 2;
    var url = "http://"+ ip +":6080/vnc_auto.html"+ "?token=" + tokenName;
    window.open(url, "远程终端", "top=" + iTop + ",left=" + iLeft + ",width=" + iWidth + ",height=" + iHeight);
}