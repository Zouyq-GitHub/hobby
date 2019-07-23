<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/5/21
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Table</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<fieldset class="layui-elem-field layui-field-title"
          style="margin-top: 20px;">
    <legend>管理员信息展示</legend>
</fieldset>
<div class="layui-form">
    <table class="layui-table">
        <colgroup>
            <col width="150">
            <col width="150">
            <col width="150">
            <col width="150">
        </colgroup>
        <thead>
        <tr>
            <th>管理员编号</th>
            <th>管理员账号</th>
            <th>管理员姓名</th>
            <th>管理员权限</th>
        </tr>
        </thead>
        <!-- java循环 -->
        <c:forEach items="${Rootlist}" var="r">
            <tbody>
            <tr>
                <td>${r.id}</td>
                <td>${r.r_loginName}</td>
                <td>${r.r_Name}</td>
                <td>
                    <c:choose>
                        <c:when test="${r.r_roleid==1}">超级管理员</c:when>
                        <c:when test="${r.r_roleid==2}">管理员</c:when>
                    </c:choose>
                </td>
            </tr>
            </tbody>
        </c:forEach>
    </table>
</div>
</body>
</html>
