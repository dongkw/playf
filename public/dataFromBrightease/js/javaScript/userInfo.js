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


    var flag=false;//是否是编辑状态，默认为flash
    $(".input-l").attr("disabled","disabled");

    //单选框
    $(".form_radio_con").click(function(){
        if(flag==false){
            return;
        }
        var name=$(this).find(".radio_c").attr("name");
        $(".form_radio_con .radio_c[name="+name+"]").removeClass("select");
        $(this).find(".radio_c").addClass("select");
    });

    //下来框选择
    $(".form_select_con").delegate(".select_c","click",function(){
        if(flag==false){
            return;
        }
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
        if(flag==false){
            return;
        }
        var str=$(this).html();
        $(this).parent().prev(".select_c").html($(this).html());
        $(this).parent().hide();
        if(str=="请选择"){
            $(this).parent().prev(".select_c").css('color',"#2e8ab1");
        }else{
            $(this).parent().prev(".select_c").css('color',"#fff");
        }
        //alert(getSelectValue('usertype'));
    });
    //end 下拉框选择
    //单选
    $(".form_checkbox_con").click(function(){
        if(flag==false){
            return;
        }
        if($(this).find(".check_c").hasClass("select")){
            $(this).find(".check_c").removeClass("select");
        }else{
            $(this).find(".check_c").addClass("select");
            //alert(getCheckValue("fav"));
        }
    });

    //点击编辑按钮
    $("#edit").click(function(){
        if(flag==false){
            flag=true;
            $(".mr-ys").addClass("mr-ys-active");
            $(".input-l").removeAttr("disabled");
            $(this).attr("value","保存");
        }else{
            flag=false;
            $(".mr-ys").removeClass("mr-ys-active");
            $(".input-l").attr("disabled","disabled");
            $(this).attr("value","编辑");
        }

    });
    $.fn.zTree.init($("#treeDemo"), setting, zNodes);

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

//---------------------ztree-----------------------
var setting = {
    view: {
        dblClickExpand: false,
        showIcon: false,
        selectedMulti: false//多选
    },
    data: {
        simpleData: {
            enable: true
        }
    },
    callback: {
        beforeClick: beforeClick,
        onClick: onClick
    }
};

var zNodes =[
    {id:1, pId:0, name:"列表-1"},
    {id:2, pId:0, name:"列表-2"},
    {id:3, pId:0, name:"列表-3"},
    {id:6, pId:0, name:"列表-4"},
    {id:4, pId:0, name:"列表-5", open:true},
    {id:41, pId:4, name:"列表-51"},
    {id:42, pId:4, name:"列表-52"},
    {id:43, pId:4, name:"列表-53"},
    {id:44, pId:4, name:"列表-54"},
    {id:5, pId:0, name:"列表-6", open:true},
    {id:51, pId:5, name:"列表-61"},
    {id:52, pId:5, name:"列表-62"},
    {id:53, pId:5, name:"列表-63"},
    {id:54, pId:5, name:"列表-64"}
];

function beforeClick(treeId, treeNode) {
    var check = (treeNode && !treeNode.isParent);
    if (!check) ;
    return check;
}

function onClick(e, treeId, treeNode) {
    var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
        nodes = zTree.getSelectedNodes(),
        v = "";
    nodes.sort(function compare(a,b){return a.id-b.id;});
    for (var i=0, l=nodes.length; i<l; i++) {
        v += nodes[i].name + ",";
    }
    if (v.length > 0 ) v = v.substring(0, v.length-1);
    var cityObj = $("#diagnosis");
    cityObj.attr("value", v);
    hideMenu();
}

function showMenu() {
    $("#menuContent").show();
    $("body").bind("mousedown", onBodyDown);
}
function hideMenu() {
    $("#menuContent").hide();
    $("body").unbind("mousedown", onBodyDown);
}
function onBodyDown(event) {
    if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" ||
        $(event.target).parents("#menuContent").length>0 )) {
        hideMenu();
    }
}

//end------------------ztree-----------------------