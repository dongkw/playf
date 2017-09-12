$(document).ready(function(){
    $("#zh").bind("click",function(){
        $(".login-zw-info").hide();
        $(".login-info").show();
    });
    $("#zw").bind("click",function(){
        $(".login-zw-info").show();
        $(".login-info").hide();
    });
    $(".login-btn").click(function(){
        $(".login-btn").removeClass("login-active");
        $(this).addClass("login-active");
    });

});

//指纹验证失败
function zwError(){
    $(".l-zw-ts").html("指纹识别失败，请用其它方式登录。");
    $(".l-zw-ts").addClass("error");
}
//指纹验证中
function ok(){
    $(".l-zw-ts").html("正在验证指纹...");
    $(".l-zw-ts").removeClass("error");
}