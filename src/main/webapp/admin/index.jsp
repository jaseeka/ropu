<%--
  Created by jaseeka
  Date: 2015/7/21
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title>冬日中医-后台管理系统</title>
  <%@include file="/common/resource-admin.jsp" %>
  <script type="text/javascript" src="/js/admin/main.js"></script>
</head>
<body class="easyui-layout">
<div class="ui-header" data-options="region:'north',split:true,border:false,resizable:false" style="height:40px;overflow: hidden;">
  <h1>冬日暖阳后台管理系统</h1>
  <div  class="ui-login">
    <div class="ui-login-info">
      欢迎 <span class="orange">${user.nickname}</span> 登录系统
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <a class="modify-pwd-btn"  href="javascript:void(0);">修改密码</a> |
      <a class="logout-btn" href="/adminLogin.shtml">退出</a>
    </div>
  </div>
</div>
<!-- 树形菜单 -->
<div data-options="region:'west',split:true,title:'导航'" style="width:200px;">
  <div id="tree-box" class="easyui-accordion" data-options="fit:true,border:false">
    <div title="第一级">
      <a class="menu-item" href="#">目录1</a>
      <a class="menu-item" href="#">目录2</a>
      <a class="menu-item" href="#">目录3</a>
    </div>
    <div title="第二级">
      <a class="menu-item" href="#">目录1</a>
      <a class="menu-item" href="#">目录2</a>
      <a class="menu-item" href="#">目录3</a>
    </div>
  </div>
</div>
<div data-options="region:'south',split:true,border:false" style="height: 30px;overflow:hidden;">
  <div class="panel-header" style="border: none;text-align: center;" >CopyRight &copy; 2015  版权所有 &nbsp;&nbsp;官方网址:www.idongri.com  &nbsp;&nbsp;闽ICP备15005108号</div>
</div>
<!-- 中间内容页面 -->
<div data-options="region:'center'" >
  <div class="easyui-tabs" id="tab-box" data-options="fit:true,border:false">
    <div title="欢迎" style="padding:20px;overflow:hidden;">

      <div style="margin-top:20px;">
        <h1>冬日暖阳后台管理系统</h1>
      </div>

    </div>
  </div>
</div>
<!--  modify password start -->
<div id="modify-pwd-win"  class="easyui-dialog" buttons="#editPwdbtn" title="修改用户密码" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:350px;height:200px;">
  <form id="pwdForm" action="modifyPwd" class="ui-form" method="post">
    <input class="hidden" name="id">
    <input class="hidden" name="email">
    <div class="ui-edit">
      <div class="fitem">
        <label>旧密码:</label>
        <input id="oldPwd" name="oldPwd" type="password" class="easyui-validatebox"  data-options="required:true"/>
      </div>
      <div class="fitem">
        <label>新密码:</label>
        <input id="newPwd" name="newPwd" type="password" class="easyui-validatebox" data-options="required:true" />
      </div>
      <div class="fitem">
        <label>重复密码:</label>
        <input id="rpwd" name="rpwd" type="password" class="easyui-validatebox"   required="required" validType="equals['#newPwd']" />
      </div>
    </div>
  </form>
  <div id="editPwdbtn" class="dialog-button" >
    <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-pwd-submit">提交</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-pwd-close">关闭</a>
  </div>
</div>
<!-- modify password end  -->
</body>
</html>
