$(document).ready(function(){
    $(".put-btn").on("click", function(e){
        $(".help-info").hide();
       if($(this).find("span").hasClass("padz")){
           $(".m-title").html("佩戴指南");
         $(".pdzn-view").show();
       }else if($(this).find("span").hasClass("czsc")){
           $(".m-title").html("操作手册");
           $(".czsc-view").show();
           var swiper = new Swiper('.swiper-container1', {
               scrollbar: '.swiper-scrollbar1',
               direction: 'vertical',
               slidesPerView: 'auto',
               mousewheelControl: true,
               freeMode: true
           });
       }else if($(this).find("span").hasClass("gyxt")){
           $(".m-title").html("关于系统");
           $(".gyxt-view").show();
           var swiper2 = new Swiper('.swiper-container2', {
               scrollbar: '.swiper-scrollbar2',
               direction: 'vertical',
               slidesPerView: 'auto',
               mousewheelControl: true,
               freeMode: true
           });
       }

    });

    $(".close-btn").bind("click",function(){
        $(this).parent().hide();
        $(".help-info").show();
        $(".m-title").html("系统帮助");
    })


});
