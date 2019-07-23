<%@page import="com.zyq.bean.*" %>
<%@ page import="java.util.List" %>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <title>文件上传</title>
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
    <legend>文件上传页面</legend>
</fieldset>

<form action="/pages/UploadServlet" method="post" enctype="multipart/form-data"  class="layui-form layui-form-pane">


    <div class="layui-form-item">
        <label class="layui-form-label">文件描述</label>
        <div class="layui-input-inline">
           <input type="text" name="desc" lay-verify="required" placeholder="输入文件描述"
                                                class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">选择文件</label>
        <div class="layui-input-inline">
            <input type="file" name="myfile" lay-verify="required"
                   class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-input-inline">
           <input type="submit"  lay-verify="required"
                  class="layui-input">
        </div>
    </div>
    <br/></a>
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

    });

</script>
</html>
