/**
 * Created by jaseeka
 * date 2015/7/21
 * time 14:21
 */
$(function(){
    $("#data-list").datagrid({
        title : "标题",
        striped : false,
        pagination : true,
        pageSize : 15,
        pageList : [5,10,15,20],
        iconCls : "icon-save",
        fit : true,
        singleSelect : true,
        checkOnSelect : true,
        url : "productList",
        columns : [[
            {field : "id", checkbox : true},
            {field : "name", title : "名称", width : 100, sortable : true}
        ]],
        toolbar : [
            {
                id: 'btnedit', iconCls: 'icon-edit', text: '编辑', btnType: 'edit',
                handler: function () {
                    var selected = $("#data-list").datagrid('getChecked');
                    if (selected.length <= 0) {
                        $.messager.alert('警告','未选中记录.','warning');
                    }
                    else if (selected.length > 1) {
                        $.messager.alert('警告','只能选择一行记录.','warning');
                    } else {
                        edit(selected);
                    }
                }
            },
            {id: 'btneadd', iconCls: 'icon-add', text: '添加', btnType: 'edit',
                handler: function () {
                    edit();
                }
            },
            {id: 'btnedel', iconCls: 'icon-remove', text: '删除', btnType: 'remove',
                handler: function () {
                    var selected = $("#data-list").datagrid('getChecked');
                    if (selected.length <= 0) {
                        $.messager.alert('警告','未选中记录.','warning');
                    }
                    else if (selected.length > 1) {
                        $.messager.alert('警告','只能选择一行记录.','warning');
                    } else {
                        del(selected);
                    }
                }
            }
        ]
    });
});

// 编辑
function edit(data){
    if (data) {
        data = data[0];
/*        $("#id").val(data.id);
        $("#title").val(data.title);
        $("#pictureUrl").val(data.pictureUrl);
        $("#imgpictureUrl").attr("src", data.pictureUrl);
        $("#intro").val(data.intro);
        var ue = UE.getEditor('container');
        ue.setContent(data.content);*/
    }else{
       /* $("#id").val("");
        $("#title").val("");
        $("#time").val("");
        $("#pictureUrl").val("");
        $("#imgpictureUrl").attr("src", "");
        $("#intro").val("");
        var ue = UE.getEditor('container');
        ue.setContent("");*/
    }
    $("#edit-win").window("open");
}
// 删除
function del(data){
    data = data[0];
    $.messager.confirm("确认", "确定删除该数据", function (r) {
        if (r) {
            $.post(
                "/admin/deleteNews",
                {
                    id : data.id
                },
                function(data){
                    $.messager.alert('',data.msg,'');
                    $('#data-list').datagrid('reload');
                }
            );
        }else{
            return;
        }
    });
};
// 删除结束
// 保存信息
function save(){

    if ( $("#title").val() == undefined ||  $("#title").val() == ""){
        $.messager.alert('警告','标题不能为空！.','warning');
        return;
    }else if ( $("#time").val() == undefined ||  $("#time").val() == ""){
        $.messager.alert('警告','显示时间不能为空！.','warning');
        return;
    }else if ( $("#pictureUrl").val() == undefined ||  $("#pictureUrl").val() == ""){
        $.messager.alert('警告','请上传缩略图！.','warning');
        return;
    }else if ( $("#intro").val() == undefined ||  $("#intro").val() == ""){
        $.messager.alert('警告','简介不能为空！.','warning');
        return;
    }
    var ue = UE.getEditor('container');
    var content = ue.getContent();
    $.post(
        "/admin/saveNews",
        {
            id         : $("#id").val(),
            title      : $("#title").val(),
            time       : $("#time").val(),
            pictureUrl : $("#pictureUrl").val(),
            intro      : $("#intro").val(),
            content    : content
        },
        function(data){
            $.messager.alert('',data.msg,'');
            $("#edit-win").window("close");
            $('#data-list').datagrid('reload');
        }
    );
};
// 保存信息结束
// 搜索
function searchUserManual(){
    $('#data-list').datagrid('reload',{
        title: $('#Stitle').val()
    });
};
// 搜索结束

// 图片点击事件
function imgClick(id){
    $("#imgid").val(id);

    $("#file").click();
}

// 图片上传方法
function dictFile(value){

    var id = $("#imgid").val();

    $("#myform").form("submit",{
        success :function(data){
            var json = eval('('+data+')');
            if(json.code == 0){
                $("#"+id).val(json.data.url);
                $("#img"+id).attr("src",json.data.url);
            }else{
                $.messager.alert('警告',json.msg,'warning');
            }
        }
    })
};
