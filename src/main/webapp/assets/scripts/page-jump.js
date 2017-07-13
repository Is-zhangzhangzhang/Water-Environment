/**
 * Created by zhonghua on 2016/7/17.
 */
var i = 5;
var intervalid;
intervalid = setInterval("fun()", 1000);
function fun() {
    if (i == 0) {
        window.location.href = "/WaterEnvironment";
        clearInterval(intervalid);
    }
    document.getElementById("mes").innerHTML = i;
    i--;
}