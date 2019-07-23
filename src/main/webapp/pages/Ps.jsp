<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/5/20
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.zyq.bean.*" %>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<meta charset="utf-8">
<title>Ps</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
      content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="/css/layui.css" media="all">
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<%--用户类--%>
<%RootDemo rootDemo = (RootDemo) request.getSession().getAttribute("RootDemo");%>
<fieldset class="layui-elem-field layui-field-title"
          style="margin-top: 20px;">
    <legend>密码修改</legend>
</fieldset>

<form class="layui-form layui-form-pane" action="/pages/NewPsServlet" name="myform" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">当前密码</label>
        <div class="layui-input-inline">
            <input type="text" name="name" lay-verify="required" placeholder="<%=rootDemo.getR_PassWord()%>" class="layui-input" readonly="readonly">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">新密码</label>
        <div class="layui-input-inline">
            <input type="password" name="password" lay-verify="required" placeholder="请输入新密码" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <!-- 	<button class="layui-btn" lay-submit="submit" lay-filter="demo1">确认修改</button> -->
            <input type="submit" class="layui-btn" value="提交密码">
        </div>
    </div>
</form>


</body>
<script src="/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
</html>
