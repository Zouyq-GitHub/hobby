<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/5/22
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.zyq.bean.*" %>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>修改页面</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
    <title>获取修改的用户的页面</title>
</head>
<body>

<fieldset class="layui-elem-field layui-field-title"
          style="margin-top: 50px;">
    <legend>班级信息修改</legend>
</fieldset>

<%--<%UserDemo userDemo = (UserDemo) request.getServletContext().getAttribute("userDemo");%>--%>
<%ClassDemo classDemo = (ClassDemo) request.getSession().getAttribute("classDemo");%>
<%ClassName className = (ClassName) request.getSession().getAttribute("className");%>

<form method="post" class="layui-form" action="ClassSubmitServlet" lay-filter="example">

    <div class="layui-form-item">
        <label class="layui-form-label">班级名称</label>
        <div class="layui-input-block">
            <input type="text" name="ClassName" lay-verify="title"
                   autocomplete="off" value="<%=className.getC_Name()%>" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">班级类型</label>
        <div class="layui-input-block">
            <select name='ClassForm' lay-filter="aihao">
                <c:forEach var="s" items="${classDemoList}">
                    <option value="${s.c_Form}" selected="selected">${s.c_Form}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">状态修改</label>
        <div class="layui-input-block">
            <select name='Status' lay-filter="aihao">
                <option value=1 selected="selected">学习中</option>
                <option value=2>已毕业</option>
            </select>
        </div>
    </div>


    <input type="hidden" name="id" value="<%=className.getId()%>"><br>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <!-- 	<button class="layui-btn" lay-submit="submit" lay-filter="demo1">确认修改</button> -->
            <input type="submit" class="layui-btn" value="确认修改">
        </div>
    </div>
</form>
</body>
<script src="/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;


        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //自定义验证规则
        form.verify({
            title: function (value) {
                if (value.length < 1) {
                    return '标题至少得写个字符啊';
                }
            }

            , content: function (value) {
                layedit.sync(editIndex);
            }
        });

        //监听提交
        form.on('submit(demo1)', function (data) {
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            })
            return false;
        });

        //表单初始赋值
        form.val('example'
            , {
                "username": "" // "name": "value"
                , "name": "<%=className.getC_Name()%>"
                , "address": ""
                , "age": ""
            })
    });
</script>
</html>

