/**
 * Created by jaseeka
 * date 2015/7/21
 * time 14:21
 */
$(function(){
    $.post(
        "/admin/contactById",
        {
            id : 1
        },
        function(data){
            if (data.code == 0){
                edit(data.data);
            }else{
                $.messager.alert('',data.msg,'');
            }
        }
    );
});

// 编辑
function edit(data){
    data = data.applyFlow;
    $("#id").val(data.id);
    $("#name").textbox('setValue',data.name);
    $("#img").val(data.img);
    $("#imgimg").attr("src", data.img);
    $("#time").val(dateFormate(data.time, false));
    var ue = UE.getEditor('container');
    ue.addListener("ready", function () {
        ue.setContent(data.content);
    });
    //ue.setContent(data.content);
    $("#edit-win").window("open");
}
// 删除
function del(data){
    data = data[0];
    $.messager.confirm("确认", "确定删除该数据", function (r) {
        if (r) {
            $.post(
                "/admin/deleteContact",
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
        "/admin/saveContact",
        {
            id      : $("#id").val(),
            type    : 0,
            name    : $("#name").val(),
            time    : $("#time").val(),
            img     : $("#img").val(),
            content : content
        },
        function(data){
            $.messager.alert('',data.msg,'');
            //$("#edit-win").window("close");
            //$('#data-list').datagrid('reload');
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

