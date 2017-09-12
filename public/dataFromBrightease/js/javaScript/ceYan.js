$(document).ready(function(){
    $(".form_checkbox_con").click(function(){
        if($(this).find(".check_c").hasClass("select")){
            $(this).find(".check_c").removeClass("select");
        }else{
            $(this).find(".check_c").addClass("select");
            //alert(getCheckValue("fav"));
        }
    });

    $("#checkAll").click(function(){
        if($(this).find(".check_c").hasClass("select")){
            $(".form_checkbox_con .check_c[name=fav]").addClass("select");
        }else{
            $(".form_checkbox_con .check_c[name=fav]").removeClass("select");
        }
    });

    //分页
    $(".fy-ul li").bind("click",function(){
        if($(this).find("a").hasClass("fy-sl")){
            return;
        }
        $(".fy-ul li").removeClass("active");
        $(this).addClass("active");
    });


    //---------------------------放松方法训练报告里面的下拉框-----------------------------------
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
            $(this).parent().prev(".select_c").css('color',"#eee");
        }else{
            $(this).parent().prev(".select_c").css('color',"#ffffff");
        }
        //alert(getSelectValue('usertype'));
    });
    //end 下拉框选择


    //----------------------------方案报告里面的单选框----------------------------------------
    //单选框
    $(".form_radio_con").click(function(){
        var name=$(this).find(".radio_c").attr("name");
        $(".form_radio_con .radio_c[name="+name+"]").removeClass("select");
        $(this).find(".radio_c").addClass("select");
    });
});
//获取checkbox的值
function getCheckValue(obj_name){
    var t_l=$(".form_checkbox_con .check_c[name="+obj_name+"].select"),t="";
    for(var i=0;i<t_l.length;i++){
        t+=t_l.eq(i).next(".check_v").html()+",";
    }
    return t.substr(0, t.length-1);
}

//获取下拉菜单的值
function getSelectValue(obj_name){
    var t=$(".form_select_con[name="+obj_name+"]").find(".select_c").html();
    return t;
}

//获取radio的值
function getRadioValue(obj_name){
    var t=$(".form_radio_con .radio_c[name="+obj_name+"].select").next(".radio_v").html();
    return t;
}