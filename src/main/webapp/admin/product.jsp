<%--
  Created by jaseeka
  Date: 2015/7/21
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <%@include file="/common/resource-admin.jsp" %>
  <script type="text/javascript" src="/js/admin/product.js"></script>
</head>
<body class="easyui-layout">
<!-- Search panel start -->
<div class="ui-search-panel" region="north" style="height: 80px;" title="搜索框"
     data-options="striped: false,collapsible:false,iconCls:'icon-search',border:false">
  <form id="searchForm">
    <p class="ui-fields">
      <label class="ui-label">医生姓名:</label>
      <input name="name" id="Sdoctorname" class="easyui-box ui-text" style="width:100px;">&nbsp;&nbsp;&nbsp;
      <label class="ui-label">手机号码:</label>
      <input name="phoneNumber" id="SphoneNumber" class="easyui-box ui-text" style="width:100px;">&nbsp;&nbsp;&nbsp;
    </p>
    <a id="btn-search" class="easyui-linkbutton" iconCls="icon-search" onclick="searchDoctor()">搜索</a>
  </form>
</div>
<!--  Search panel end -->
<!-- DataList  -->
<div region="center" border="false">
  <table id="data-list"></table>
</div>
<!-- DataList end -->
<!-- Edit Form -->
<div id="edit-win" class="easyui-window" title="医生信息修改" data-options="closed:true,iconCls:'icon-edit',modal:false,fit:true,zIndex:-100">
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
          <label>图片:</label>
          <img src="" alt="头像" name="img" id="imgimg" style="width:70px;height:70px;padding-left:15px;" onclick="imgClick('img')">
          </br></br>
          <input class="easyui-textbox" type="text" style="width:200px; display:none;" name="img" id="img" />
          <label>姓名:</label>
          <input class="easyui-textbox" type="text" style="width: 200px"  name="name" id="name" />
          </br></br>
          <script id="container" name="content" type="text/plain" style="height:500px;"></script>
          <script type="text/javascript">
            var ue = UE.getEditor('container');
          </script>
          </br></br>
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
