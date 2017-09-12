$(document).ready(function(){
    var so=new swfobject.embedSWF("game/TiaoTiaoQiu.swf","flashcontent","800","600","10","",{},{allowFullScreen:true,wmode:"transparent"},{id:"flash",name:"flash"});

    //flash加载完毕开始初始化参数
    function startToPlay(){
        //训练测验
        swfobject.getObjectById("flash").setData(null,"");//js调用flash中的方法

    }
    //开始监控脑电数据
    function startGame(){

    }
    //游戏结束
    function getReault(result,data){
        alert(result+"---"+data);
    }

    function stop(){
        swfobject.getObjectById("flash").stopPlay();
    }

    function recover(){
        swfobject.getObjectById("flash").recoverPlay();
    }
});
