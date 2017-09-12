$(document).ready(function(){
    $(".user-b").on("click", function(e){
        $(".user-list").show();
        $(this).find(".tb-ico").removeClass("tb-ico-x");

        $(document).one("click", function(){
            $(".user-list").hide();
            $(this).find(".tb-ico").addClass("tb-ico-x");
        });
        e.stopPropagation();
    });
    $(".user-list").on("click", function(e){
        e.stopPropagation();
    });
    //下拉菜单的滚动条
    if($(".select_v").length>0){
        $(".select_v").niceScroll({
            cursorcolor:"rgba(238, 238, 238, 0.31)",
            cursoropacitymax:1,
            touchbehavior:true,
            cursorwidth:"3px",
            cursorborder:"0",
            cursorborderradius:"3px"
        });
    }

    //正常div的滚动条
    if($(".scrollBar").length>0){
        $(".scrollBar").niceScroll({
            cursorcolor:"rgba(238, 238, 238, 0.31)",
            cursoropacitymax:1,
            touchbehavior:true,
            cursorwidth:"5px",
            cursorborder:"0",
            cursorborderradius:"5px"
        });
    }

});