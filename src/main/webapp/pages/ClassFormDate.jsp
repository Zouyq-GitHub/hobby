<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/5/22
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@page import="com.zyq.bean.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
    <title>删除页面</title>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title"
          style="margin-top: 20px;">
    <legend>删除班级类型</legend>
</fieldset>


<%--Hello Word--%>
<div class="layui-form">
    <table class="layui-table">
        <colgroup>
            <col width="150">
        </colgroup>
        <thead>
        <tr>
            <th>班级类型</th>
            <th>操作</th>
        </tr>
        </thead>
        <!-- java循环 -->
        <c:forEach items="${classDemoList}" var="s">
            <tbody>
            <tr>
                <td>${s.c_Form}</td>
                <td><a href="/pages/ClassIdDateServlet?id=${s.id}">删除</a></td>
            </tr>
            </tbody>
        </c:forEach>
    </table>
</div>
<%--dajiahao--%>

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
    });
</script>
</html>