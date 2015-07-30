/**
 * Created by jaseeka
 * date 2015/7/29
 * time 11:19
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
            {field : "name", title : "名称", width : 200, sortable : true},
            {field : "time", title : "时间", width : 150, sortable : true,
                formatter:function(value,row,index){
                    return dateFormate(value,true);
                }
            }
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
        $("#id").val(data.id);
        $("#name").val(data.name);
        $("#img").val(data.img);
        $("#imgimg").attr("src", data.img);
        $("#time").val(dateFormate(data.time, false));
        var ue = UE.getEditor('container');
        ue.addListener("ready", function () {
            ue.setContent(data.content);
        });
    }else{
        $("#id").val("");
        $("#name").val("");
        $("#img").val("");
        $("#imgimg").attr("src", "");
        $("#time").val("");
        var ue = UE.getEditor('container');
        ue.addListener("ready", function () {
            ue.setContent("");
        });
    }
    $("#edit-win").window("open");
}
// 删除
function del(data){
    data = data[0];
    $.messager.confirm("确认", "确定删除该数据", function (r) {
        if (r) {
            $.post(
                "/admin/deleteProduct",
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

    if ( $("#name").val() == undefined ||  $("#name").val() == ""){
        $.messager.alert('警告','标题不能为空！.','warning');
        return;
    }else if ( $("#time").val() == undefined ||  $("#time").val() == ""){
        $.messager.alert('警告','显示时间不能为空！.','warning');
        return;
    }else if ( $("#img").val() == undefined ||  $("#img").val() == ""){
        $.messager.alert('警告','请上传缩略图！.','warning');
        return;
    }
    var ue = UE.getEditor('container');
    var content = ue.getContent();
    $.post(
        "/admin/saveProduct",
        {
            id      : $("#id").val(),
            type    : $("#type").val(),
            name    : $("#name").val(),
            time    : $("#time").val(),
            img     : $("#img").val(),
            content : content
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
function searchList(){
    $('#data-list').datagrid('reload',{
        name: $('#Sname').val()
    });
};
// 搜索结束

