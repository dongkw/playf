$(document).ready(function(){
    var num=1;
    var curr="",next="";
    $(".next").bind("click",function(){
        curr=".bz"+num;
        num++;
        if(num<=4){
            next=".bz"+num;
            $(next).show();
            $(curr).hide();
        }else if(num>4){
           $(".main-yd").hide();
        }
    });

    $(".pass").click(function(){
        $(".main-yd").hide();
    });

    //复选
    $(".form_checkbox_con").click(function(){
        if($(this).find(".check_c").hasClass("select")){
            $(".form_checkbox_con").find(".check_c").removeClass("select");
        }else{
            $(".form_checkbox_con").find(".check_c").addClass("select");
           // alert(getCheckValue("all"));
        }
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