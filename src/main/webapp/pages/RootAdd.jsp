<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/5/21
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
    <title>添加Root页面</title>
</head>
<body>
    <fieldset class="layui-elem-field layui-field-title"
          style="margin-top: 20px;">
    <legend>管理员添加页面</legend>
    </fieldset>

    <form method="post" class="layui-form" action="RootAddServlet" lay-filter="example">
        <div class="layui-form-item">
            <label class="layui-form-label">管理员姓名</label>
            <div class="layui-input-block">
                <input type="text" name="Name" lay-verify="title"
                       autocomplete="off" placeholder="请输入管理员的姓名" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">管理员账号</label>
            <div class="layui-input-block">
                <input type="text" name="LoginName" lay-verify="title"
                       autocomplete="off" placeholder="请输入管理员的账号" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">管理员密码</label>
            <div class="layui-input-block">
                <input type="password" name="PassWord" lay-verify="title"
                       autocomplete="off" placeholder="请输入管理员的密码" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <!-- 	<button class="layui-btn" lay-submit="submit" lay-filter="demo1">确认修改</button> -->
                <input type="submit" class="layui-btn" value="确认添加">
            </div>
        </div>
    </form>
</body>

</html>
