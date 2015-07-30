<%--
  Created by jaseeka
  Date: 2015/7/29
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/resource-admin.jsp" %>
    <script type="text/javascript" src="/js/admin/recruit_cn.js"></script>
</head>
<body class="easyui-layout">
<!-- Search panel start -->
<div class="ui-search-panel" region="north" style="height: 80px;" title="搜索框"
     data-options="striped: false,collapsible:false,iconCls:'icon-search',border:false">
    <form id="searchForm">
        <p class="ui-fields">
            <label class="ui-label">招聘标题:</label>
            <input name="title" id="Stitle" class="easyui-box ui-text" style="width:100px;">&nbsp;&nbsp;&nbsp;
        </p>
        <a id="btn-search" class="easyui-linkbutton" iconCls="icon-search" onclick="searchList()">搜索</a>
    </form>
</div>
<!--  Search panel end -->
<!-- DataList  -->
<div region="center" border="false">
    <table id="data-list"></table>
</div>
<!-- DataList end -->
<!-- Edit Form -->
<div id="edit-win" class="easyui-window" title="招聘信息修改" data-options="closed:true,iconCls:'icon-edit',modal:false,fit:true,zIndex:-100">
    <%-- 图片上传form--%>
    <div id="imageform" style="display:none;">
        <form id="myform" action="/open/uploadFile" method="post" enctype="multipart/form-data">
            <input type="file" id="file"onchange="dictFile(this)" name="file" style="width: 65px;">
            <input class="easyui-textbox" type="text" style="width:200px; display:none;" name="imgid" id="imgid" />
        </form>
    </div>
    <div class="ui-edit">
        <div class="fitem">
            <div class="div-line">
                <form id="editForm" class="ui-form" method="post" action="">
                    <input class="hidden" name="id" id="id">
                    <input class="hidden" name="type" id="type">
                    <%--中文--%>
                    <input class="hidden" name="type" id="type" value="0">
                    <label>缩略图:</label>
                    <img src="" alt="缩略图" name="img" id="imgimg" style="width:150px;height:150px;padding-left:15px;" onclick="imgClick('img')">
                    <input type="text" style="width:200px; display:none;" name="img" id="img" />
                    </br></br>
                    <label>标题:</label>
                    <input class="easyui-textbox" type="text" style="width: 200px"  name="title" id="title" />
                    </br></br>
                    <label>发布时间:</label>
                    <input type="text" style="width: 200px"  name="time" id="time" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                    </br></br>
                    <label>详细内容:</label>
                    </br></br>
                    <script id="container" name="content" type="text/plain" style="height:500px;"></script>
                    <script type="text/javascript">
                        var ue = UE.getEditor('container');
                    </script>
                    </br>
                    <!-- 保存按钮 -->
                    <div style="padding: 5px;text-align: right;">
                        <a href="#" class="l-btn" id="save-btn" onclick="save()" >
                          <span class="l-btn-left">
                                  <span class="l-btn-text">保存</span>
                          </span>
                        </a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- Edit Form -->
</body>
</html>
