/**
 * Created by zhonghua on 2016/7/17.
 */
$(document).ready(function() {
    $('#loginBut').click(function() {
        $.post("login",
            {
                username: $('#username').val(),
                password: sha256_digest($('#password').val())
            },
            function(data) //»Ø´«º¯Êý
            {
                if(data.trim()=='no'){
                    $('#returnRes').show();
                }
                if(data.trim()=='yes'){
                    window.location.href="main";
                }
            });
    });
});