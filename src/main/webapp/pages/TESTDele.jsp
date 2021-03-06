<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/5/20
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.zyq.bean.*" %>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dele</title>
</head>
<meta charset="utf-8">
<title>Dele</title>
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
    <legend>选择要删除的学员</legend>
</fieldset>

<%--dajiahao--%>
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
            <th>姓名</th>
            <th>班级名称</th>
            <th>班级编号</th>
            <th>操作</th>

        </tr>
        </thead>
        <!-- java循环 -->
        <c:forEach items="${userList}" var="s">

            <tbody>
            <tr>
                <td>${s.u_name} </td>
                <td>${s.u_class}</td>
                <td>${s.u_classnumb}</td>
                <td>
                        <%--<button class="layui-btn layui-btn-sm layui-btn-primary" href='/pages/UpdateServlet?id=${s.id}'>删除
                        </button>--%>

                    <a href='/pages/UpdateServlet?id=${s.id}'>删除</a>
                </td>
            </tr>
            </tbody>
        </c:forEach>
    </table>
        <%	Page p = (Page) request.getSession().getAttribute("page");	%>
    <%--分页页面拼接--%>
    <%-- <a href="#" onclick="targetPage(1)">首页</a>--%>
    <button class="layui-btn layui-btn-sm layui-btn-primary" href="#" onclick="targetPage(1)">首页</button>
    <c:if test="<%=p.getNowPage()<=1%>">
    <button class="layui-btn layui-btn-sm layui-btn-primary"><i class="layui-icon"></i></button>
    </c:if>
    <c:if test="<%=p.getNowPage()>1%>">
        <%--  <a href="#" onclick="targetPage(<%=p.getNowPage()-1%>)">上一页</a>--%>
    <button class="layui-btn layui-btn-sm layui-btn-primary" href="#" onclick="targetPage(<%=p.getNowPage()-1%>)"><i
            class="layui-icon"></i></button>
    </c:if>
    <c:if test="<%=p.getNowPage()>p.getTotalPage()%>">
    <button class="layui-btn layui-btn-sm layui-btn-primary"><i class="layui-icon"></i></button>
    </c:if>
    <c:if test="<%=p.getNowPage()<=p.getTotalPage()%>">
        <%--  <a href="#" onclick="targetPage(<%=p.getNowPage()+1%>)">下一页</a>--%>
    <button class="layui-btn layui-btn-sm layui-btn-primary" href="#" onclick="targetPage(<%=p.getNowPage()+1%>)"><i
            class="layui-icon"></i>
    </button>
    </c:if>
    <%--    <a href="#" onclick="targetPage(<%=p.getTotalPage()%>)">尾页</a>--%>
    <button class="layui-btn layui-btn-sm layui-btn-primary" href="#" onclick="targetPage(<%=p.getTotalPage()%>)">
        尾页
    </button>
    <button class="layui-btn layui-btn-sm layui-btn-primary">总条数<%=p.getCount() %>
    </button>
    <button class="layui-btn layui-btn-sm layui-btn-primary">总页数<%=p.getTotalPage() %>
    </button>

    <%-- <button class="layui-btn" href="#" onclick="targetPage(1)">首页</button>--%>


    <script src="/layui.js" charset="utf-8"></script>
    <!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
    <script type="text/javascript">
        function targetPage(nowPage) {
            location.href = "/pages/De?nowPage=" + nowPage;
        }
    </script>

    <script>
        layui.use(['form', 'layedit', 'laydate'], function () {
            var form = layui.form
                , layer = layui.layer
                , layedit = layui.layedit
                , laydate = layui.laydate;
        });
    </script>

</body>
</html>