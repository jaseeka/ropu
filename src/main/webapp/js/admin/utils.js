/**
 * Created by jaseeka
 * date 2015/7/26
 * time 16:14
 */
// 图片点击事件
function imgClick(id){
    $("#imgid").val(id);

    $("#file").click();
}

/**
 * 图片上传方法
 * @param value
 */
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

// 图片点击事件
function imgClick(id){
    $("#imgid").val(id);

    $("#file").click();
}

/**
 * 图片上传方法
 * @param value
 */
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

/**
 * 日期格式化
 * @param value
 * @param isTime 是否显示时间
 * @returns {string}
 */
function dateFormate(value, isTime){
    var date  = new Date(value);
    var YYYY = date.getFullYear();
    var MM = date.getMonth()+1;
    if (MM.toString().length == 1){
        MM = "0"+MM;
    }
    var dd = date.getDate();
    if (dd.toString().length == 1){
        dd = "0"+dd;
    }
    if (isTime){
        var hh = date.getHours();
        if (hh.toString().length == 1){
            hh = "0"+hh;
        }
        var mm = date.getMinutes();
        if (mm.toString().length == 1){
            mm = "0"+mm;
        }
        var ss = date.getSeconds();
        if (ss.toString().length == 1){
            ss = "0"+ss;
        }
        return YYYY+"/"+MM+"/"+dd+" "+hh+":"+mm+":"+ss;
    }else{
        return YYYY+"/"+MM+"/"+dd
    }
}