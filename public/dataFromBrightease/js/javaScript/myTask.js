$(document).ready(function(){

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

    //分页
    $(".fy-ul li").bind("click",function(){
        if($(this).find("a").hasClass("fy-sl")){
            return;
        }
        $(".fy-ul li").removeClass("active");
        $(this).addClass("active");
    });

    //任务名称+联想
    var availableTags = [
        "ActionScript",
        "AppleScript",
        "Asp",
        "BASIC",
        "C",
        "C++",
        "Clojure",
        "COBOL",
        "ColdFusion",
        "Erlang",
        "Fortran",
        "Groovy",
        "Haskell",
        "Java",
        "JavaScript",
        "Lisp",
        "Perl",
        "PHP",
        "Python",
        "Ruby",
        "Scala",
        "Scheme"
    ];
    $( "#tags" ).autocomplete({
        source: availableTags
    });

    //点击详情
    $("#back-my,.xl-info").bind("click",function(){
        $(".mt-info").show();
        $(".xm-info").hide();
    });
    // 点击返回
    $(".xl-name,.xl-info").bind("click",function(){
        $(".mt-info").hide();
        $(".xm-info").show();
    });

});


//获取下拉菜单的值
function getSelectValue(obj_name){
    var t=$(".form_select_con[name="+obj_name+"]").find(".select_c").html();
    return t;
}
