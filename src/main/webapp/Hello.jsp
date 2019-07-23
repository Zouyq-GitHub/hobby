<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>txt</title>

    <link rel="stylesheet" href="css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
    <link rel="stylesheet" type="text/css" href="css/style.css">

    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/vector.js"></script>

</head>
<body>
<!-- 获取cookie中的信息  并且将cookie信息放在输入框中  -->

<%
    Cookie[] cookies = request.getCookies();
    String username = "";
    String password = "";
    if (cookies != null) {
        for (Cookie c : cookies) {
            if ("username".equals(c.getName())) {
                username = c.getValue();
            }
            if ("password".equals(c.getName())) {
                password = c.getValue();
            }
        }
    }
%>

<div id="container">
    <div id="output">
        <div class="containerT">
            <h1>用户登录</h1>
            <form method="post" action="Login" method="get" class="form" id="entry_form">
                <input type="text" placeholder="用户名" id="entry_name" name="loginName" value="">
                <input type="password" placeholder="密码" id="entry_password" name="password" value="">
                <button type="submit" id="entry_btn">登录</button><br/><br/>
            </form>
        </div>
    </div>
</div>
<script src="layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script type="text/javascript">
    $(function() {
        Victor("container", "output"); //登录背景函数
        $("#entry_name").focus();
        $(document).keydown(function(event) {
            if (event.keyCode == 13) {
                $("#entry_btn").click();
            }
        });
    });
</script>
<div style="text-align: center;"></div>
</body>
</html>