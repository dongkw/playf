$(document).ready(function(){

    $("#next1").bind("click",function(){
       $(".user").hide();
       $(".set-psw").show();
       $(".register-title").html("设置密码");
    });

    $("#back2").bind("click",function(){
        $(".register-title").html("帐户信息");
        $(".user").show();
        $(".set-psw").hide();
    });

    $("#next2").bind("click",function(){
        $(".set-psw").hide();
        $(".zw-yz").show();

        $(".register-title").html("设置密码");
    });

    $("#pass-zw").bind("click",function(){
        $(".zw-yz").hide();
        $(".zc-succeed").show();
        $(".register-title").html("完成注册");
    });

    //单选框
    $(".form_radio_con").click(function(){
        var name=$(this).find(".radio_c").attr("name");
        $(".form_radio_con .radio_c[name="+name+"]").removeClass("select");
        $(this).find(".radio_c").addClass("select");
    });

    //下来框选择
    $(".form_select_con").delegate(".select_c","click",function(){
        var $list=$(this).next("ul");
        if($list.css("display")==="none")
        {
            $(".form_select_con ul").hide();
            $list.show();
        }else{
            $list.hide();
        }
    });
    $(".form_select_con").delegate("li","click",function () {
        var str=$(this).html();
        $(this).parent().prev(".select_c").html($(this).html());
        $(this).parent().hide();
        if(str=="请选择"){
            $(this).parent().prev(".select_c").css('color',"#fff");
        }else{
            $(this).parent().prev(".select_c").css('color',"#fff");
        }
        //alert(getSelectValue('usertype'));
    });
    //end 下拉框选择
    //单选
    $(".form_checkbox_con").click(function(){
        if($(this).find(".check_c").hasClass("select")){
            $(this).find(".check_c").removeClass("select");
        }else{
            $(this).find(".check_c").addClass("select");
            //alert(getCheckValue("fav"));
        }
    });
});
//获取radio的值
function getRadioValue(obj_name){
    var t=$(".form_radio_con .radio_c[name="+obj_name+"].select").next(".radio_v").html();
    return t;
}

//获取下拉菜单的值
function getSelectValue(obj_name){
    var t=$(".form_select_con[name="+obj_name+"]").find(".select_c").html();
    return t;
}
//获取checkbox的值
function getCheckValue(obj_name){
    var t_l=$(".form_checkbox_con .check_c[name="+obj_name+"].select"),t="";
    for(var i=0;i<t_l.length;i++){
        t+=t_l.eq(i).next(".check_v").html()+",";
    }
    return t.substr(0, t.length-1);
}
