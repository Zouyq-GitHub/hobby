<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/5/15
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@page import="com.zyq.bean.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta charset="utf-8">
    <%--css--%>
    <link rel="stylesheet" href="/css/layui.css" media="all">
</head>
<%
    UserDemo u = (UserDemo) request.getSession().getAttribute("userDemo");
    RootDemo rootDemo = (RootDemo) request.getSession().getAttribute("RootDemo");
%>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">学员管理</div>
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a class="" target="topFrame"
                                          href="/pages/Upload.jsp">文件上传</a></li>
            <li class="layui-nav-item"><a class="" target="topFrame"
                                          href="/pages/TableServlet">文件下载</a></li>
            <li class="layui-nav-item"><a href="/pages/TableServlet" target="topFrame">返回主页</a></li>
            <li class="layui-nav-item"><a href="javascript:;">其它系统</a>
            </li>
        </ul>
        <!-- 当前用户 -->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item"><a href="javascript:;"> <img
                    src="we.png" class="layui-nav-img"> <%=rootDemo.getR_Name()%>
            </a>

            </li>
            <li class="layui-nav-item"><a href="Ex">退出登录</a></li>
        </ul>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <c:forEach var="menu" items="${menuList}">
                    <%-- 整个的二级菜单列表 --%>
                    <li class="layui-nav-item ">
                            <%-- 判断是否是一级菜单项 --%>
                        <c:if test="${ menu.m_firstid == 0 }">
                            <a class="" href="${menu.m_url}" target="topFrame">${menu.m_name}</a>
                        </c:if>
                        <dl class="layui-nav-child">
                                <%--&lt;%&ndash;  遍历二级菜单并输出 &ndash;%&gt;--%>
                            <c:forEach var="menu2" items="${menuList}">
                                <c:if test="${menu2.m_firstid == menu.id}">
                                    <dd><a href="${menu2.m_url}" target="topFrame">${menu2.m_name}</a></dd>
                                </c:if>
                            </c:forEach>
                        </dl>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <!-- 内容主体区域 -->

        <iframe src="/pages/TableServlet" width="1900px" height="1000px" name="topFrame"
                scrolling="No" noresize="noresize" frameborder="0" id="topFrame">
        </iframe>

    </div>

</div>
<!-- js位置 -->
<script src="/layui.js" charset="utf-8"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>