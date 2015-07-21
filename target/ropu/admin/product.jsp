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
</body>
</html>
