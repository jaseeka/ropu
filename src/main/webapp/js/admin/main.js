/**
 * Created by jaseeka on 2015/7/21.
 */
$(function(){
    init();
});

function treeSelect(){
    var _this = $(this);
    var title= _this.text();
    var url= _this.attr('href');
    addTab(title,url);
    return false;
};
function treeInit(){
    var  $items =  $('#tree-box').find(".menu-item");
    $items.bind('click',treeSelect);
};
function addTab(_title,_url){
    var boxId = '#tab-box';
    if($(boxId).tabs('exists',_title) ){
        var tab = $(boxId).tabs('getTab',_title);
        var index = $(boxId).tabs('getTabIndex',tab);
        $(boxId).tabs('select',index);
        if(tab && tab.find('iframe').length > 0){
            var _refresh_ifram = tab.find('iframe')[0];
            _refresh_ifram.contentWindow.location.href=_url;
        }
    }else{
        var _content ="<iframe scrolling='auto' frameborder='0' src='"+_url+"' style='width:100%; height:100%'></iframe>";
        $(boxId).tabs('add',{
            title:_title,
            content:_content,
            closable:true});

    }
};
function menuHover(){
    //菜单鼠标进入效果
    $('.menu-item').hover(
        function () {
            $(this).stop().animate({ paddingLeft: "25px" }, 200,function(){
                $(this).addClass("orange");
            });
        },
        function () {
            $(this).stop().animate({ paddingLeft: "15px" },function(){
                $(this).removeClass("orange");
            });
        }
    );
};
function init(){
    this.treeInit();
    this.menuHover();

    //修改密码绑定事件
    $('.modify-pwd-btn').click(function(){
        $('#modify-pwd-win').dialog('open');
    });
    $('#btn-pwd-close').click(function(){
        $('#modify-pwd-win').dialog('close');
    });
    $('#btn-pwd-submit').click(this.modifyPwd);
}