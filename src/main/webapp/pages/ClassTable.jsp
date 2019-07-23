<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/5/22
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.zyq.bean.*" %>
<%@ page import="java.sql.SQLOutput" %>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>--%>
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

<%
    String ClASSName = (String) request.getSession().getAttribute("ClASSName");
    String ClassStatus = (String) request.getSession().getAttribute("ClassStatus");%>

<fieldset class="layui-elem-field layui-field-title"
          style="margin-top: 20px;">
    <legend>班级查询</legend>
</fieldset>


<form class="layui-form layui-form-pane" action="/pages/NewClassTableServlet" name="myform" method="get">
    <div class="layui-form-item">
        <label class="layui-form-label">班级名称查询</label>
        <div class="layui-input-inline">
            <c:if test="${ClASSName == null}"><input type="text" name="ClASSName" lay-verify="required"
                                                     placeholder="请输入班级名称" value="${ClASSName}"
                                                     class="layui-input"> </c:if>
            <%-- <c:if test="${ClASSName == ''}"><input type="text" name="ClASSName" lay-verify="required"
                                                      placeholder="请输入班级名称"
                                                      class="layui-input"> </c:if>--%>
            <c:if test="${ClASSName != null}"><input type="text" name="ClASSName" lay-verify="required"
                                                     class="layui-input"
                                                     value="${ClASSName}"> </c:if>
        </div>
    </div>
    <%--班级查询--%>
    <c:if test="${ClassStatus=='-10'}">
        <div class="layui-form-item">
            <label class="layui-form-label">班级状态</label>
            <div class="layui-input-block">
                <select name='ClassStatus' lay-filter="aihao">
                    <option value="-10" selected="selected">无状态</option>
                    <option value="1">学习中</option>
                    <option value="2">已毕业</option>
                </select>
            </div>
        </div>
    </c:if>

    <c:if test="${ClassStatus=='1'}">
        <div class="layui-form-item">
            <label class="layui-form-label">班级状态</label>
            <div class="layui-input-block">
                <select name='ClassStatus' lay-filter="aihao">
                    <option value="-10">无状态</option>
                    <option value="1" selected="selected">学习中</option>
                    <option value="2">已毕业</option>
                </select>
            </div>
        </div>
    </c:if>

    <c:if test="${ClassStatus=='2'}">
        <div class="layui-form-item">
            <label class="layui-form-label">班级状态</label>
            <div class="layui-input-block">
                <select name='ClassStatus' lay-filter="aihao">
                    <option value="-10">无状态</option>
                    <option value="1">学习中</option>
                    <option value="2" selected="selected">已毕业</option>
                </select>
            </div>
        </div>
    </c:if>
   <%--  ssssssssssss


  <%--  <div class="layui-form-item">
        <label class="layui-form-label" for="doc-select-1-1">班级选择</label>
        <div class="layui-input-inline">
            <select name="classType" id="doc-select-1-1" >
                <c:forEach items="${classDemoList}" var="c">
                    <option value="${c.id}">${c.c_Form}</option>
                </c:forEach>
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="quiz2" id="doc-select-1-2">
                <option value="">班级名称选择</option>
            </select>
        </div>
    </div>
    </br>--%>
    <%-- sssssssssssssss--%>

    <div class="layui-form-item">
        <button class="layui-btn layui-btn-sm layui-btn-primary" type="submit">提交搜索条件</button>
        <button class="layui-btn layui-btn-sm layui-btn-primary" type="button"
                onclick='location.href=("/pages/ClassTableServlet")'>清空数据条件
        </button>
    </div>
</form>

<%--Hello Word--%>
<div class="layui-form">
    <table class="layui-table">
        <colgroup>
            <col width="150">
            <col width="150">
            <col width="150">
        </colgroup>
        <thead>
        <tr>
            <th>编号</th>
            <th>班级名称</th>
            <th>班级状态</th>
        </tr>
        </thead>
        <!-- java循环 -->
        <c:forEach items="${ClassList}" var="s">
            <tbody>
            <tr>
                <td>${s.id}</td>
                <td>${s.c_Name}</td>
                <td>
                    <c:choose>
                        <c:when test="${s.c_Status==1}">学习中</c:when>
                        <c:when test="${s.c_Status==2}">已毕业</c:when>
                    </c:choose>
                </td>
            </tr>
            </tbody>
        </c:forEach>
    </table>
</div>
<%--dajiahao--%>

<% //Page p = (Page) request.getAttribute("page");
    Page p = (Page) request.getSession().getAttribute("page");%>

<%--分页页面拼接--%>
<%-- <a href="#" onclick="targetPage(1)">首页</a>--%>
<button class="layui-btn layui-btn-sm layui-btn-primary" href="#" onclick="targetPage(1)">首页</button>
<c:if test="<%=p.getNowPage()<=1%>">
    <button class="layui-btn layui-btn-sm layui-btn-primary"><i class="layui-icon"></i></button>
</c:if>
<c:if test="<%=p.getNowPage()>1%>">
    <%--  <a href="#" onclick="targetPage(<%=p.getNowPage()-1%>)">上一页</a>--%>
    <button class="layui-btn layui-btn-sm layui-btn-primary" href="NewClassTableServlet"
            onclick="targetPage(<%=p.getNowPage()-1%>)"><i
            class="layui-icon"></i></button>
</c:if>
<c:if test="<%=p.getNowPage()>p.getTotalPage()%>">
    <button class="layui-btn layui-btn-sm layui-btn-primary"><i class="layui-icon"></i></button>
</c:if>
<c:if test="<%=p.getNowPage()<=p.getTotalPage()%>">
    <%--  <a href="#" onclick="targetPage(<%=p.getNowPage()+1%>)">下一页</a>--%>
    <button class="layui-btn layui-btn-sm layui-btn-primary" href="NewClassTableServlet"
            onclick="targetPage(<%=p.getNowPage()+1%>)"><i
            class="layui-icon"></i>
    </button>
</c:if>
<%--    <a href="#" onclick="targetPage(<%=p.getTotalPage()%>)">尾页</a>--%>
<button class="layui-btn layui-btn-sm layui-btn-primary" href="#"
        onclick="targetPage(<%=p.getTotalPage()%>)">
    尾页
</button>
<button class="layui-btn layui-btn-sm layui-btn-primary">总条数<%=p.getCount() %>
</button>
<button class="layui-btn layui-btn-sm layui-btn-primary">总页数<%=p.getTotalPage() %>
</button>

<script src="/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script type="text/javascript">
    function targetPage(nowPage) {
        var CLASSName = document.myform.ClASSName.value;
        var ClassStatus = document.myform.ClassStatus.value;
        location.href = "/pages/NewClassTableServlet?nowPage=" + nowPage + "&ClASSName" + CLASSName + "&ClassStatus" + ClassStatus;
    }

</script>
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">

    $(document).ready(function(){
        $('#doc-select-1-1').change(function(){
            var clazz=$("#doc-select-1-2");
            alert("s1s2s3s4")
            $.ajax({
                url:"/pages/ClassAmendTableServlet",//后台查询所有班级
                data:{"classType": $(this).val()},//携带的参数
                type: "post",
                success: function(msg){
                    //根据后台返回前台的msg给提示信息加HTML
                    if (msg==false){
                        layui.msg("请求失败,请稍后重试");
                    } else{
                        clazz.empty();
                        var json=JSON.parse(msg);
                        for (var i=0;i<json.length;i++){
                            var opt=document.createElement("option");
                            opt.value=json[i].clazzid;
                            opt.innerHTML=json[i].status;
                            clazz.append(opt);
                        }
                    }
                }
            });
        })
    })

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