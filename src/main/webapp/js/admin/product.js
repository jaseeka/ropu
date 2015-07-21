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
        url : "",
        columns : [[
            {field : "id", checkbox : true},
            {field : "name", title : "名称", width : 100, sortable : true}
        ]],
        toolbar : [
            {

            }

        ]
    });
});
