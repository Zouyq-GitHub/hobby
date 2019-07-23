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
    String exportToExcel = request.getParameter("exportToExcel");
    if (exportToExcel != null && exportToExcel.toString().equalsIgnoreCase("YES")) {
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "inline; filename="
                + "excel.xls");
    }
%>

<fieldset class="layui-elem-field layui-field-title"
          style="margin-top: 20px;">
    <legend>学员信息展示</legend>
</fieldset>
<%--dajiahao--%>
<%--<c:out value="${sessionScope.userQuery.userSex}"/>--%>
<form class="layui-form layui-form-pane" action="/pages/NewTableServlet" name="myform" method="get">
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-inline">
            <c:if test="${sessionScope.userQuery.studyName == '' }"><input
                    type="text" name="name"
                    lay-verify="required"
                    placeholder="请输入姓名"
                    class="layui-input"
            > </c:if>
           <%-- <c:if test="${sessionScope.userQuery.studyName == null }"><input type="text" name="name"
                                                                             lay-verify="required"
                                                                             placeholder="请输入姓名"
                                                                             class="layui-input"
            > </c:if>--%>
            <c:if test="${sessionScope.userQuery.studyName != '' }"><input type="text" name="name"
                                                                            lay-verify="required"
                                                                            class="layui-input"
                                                                            value="${sessionScope.userQuery.studyName}"> </c:if>
        </div>
    </div>

    <c:if test="${sessionScope.userQuery.userSex == null }">
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <select name='sex' lay-filter="aihao">
                    <option value="-10" selected="selected">不选择性别</option>
                    <option value="1">男</option>
                    <option value="2">女</option>
                    <option value="3">保密</option>
                </select>
            </div>
        </div>
    </c:if>

    <c:if test="${sessionScope.userQuery.userSex == '-10' }">
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <select name='sex' lay-filter="aihao">
                    <option value="-10" selected="selected">不选择性别</option>
                    <option value="1">男</option>
                    <option value="2">女</option>
                    <option value="3">保密</option>
                </select>
            </div>
        </div>
    </c:if>

    <c:if test="${sessionScope.userQuery.userSex == '1'}">
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <select name='sex' lay-filter="aihao">
                    <option value="-10">不选择性别</option>
                    <option value="1" selected="selected">男</option>
                    <option value="2">女</option>
                    <option value="3">保密</option>
                </select>
            </div>
        </div>
    </c:if>
    <c:if test="${sessionScope.userQuery.userSex == '2' }">
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <select name='sex' lay-filter="aihao">
                    <option value="-10">不选择性别</option>
                    <option value="1">男</option>
                    <option value="2" selected="selected">女</option>
                    <option value="3">保密</option>
                </select>
            </div>
        </div>
    </c:if>

    <c:if test="${sessionScope.userQuery.userSex == '3' }">
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <select name='sex' lay-filter="aihao">
                    <option value="-10">不选择性别</option>
                    <option value="1">男</option>
                    <option value="2">女</option>
                    <option value="3" selected="selected">保密</option>
                </select>
            </div>
        </div>
    </c:if>

    <c:if test="${sessionScope.userQuery.className==null}">
        <div class="layui-form-item">
            <label class="layui-form-label">班级类型</label>
            <div class="layui-input-block">
                <select name='className' lay-filter="aihao">
                    <option value="" selected="selected">不选择班级</option>
                    <option value="Java">Java</option>
                    <option value="C">C</option>
                    <option value="Web">Web</option>
                    <option value="Web">测试</option>
                    <option value="Web">C++</option>
                    <option value="Web">IOS</option>
                    <option value="Web">JSP</option>
                </select>
            </div>
        </div>
    </c:if>

    <c:if test="${sessionScope.userQuery.className==''}">
        <div class="layui-form-item">
            <label class="layui-form-label">班级类型</label>
            <div class="layui-input-block">
                <select name='className' lay-filter="aihao">
                    <option value="" selected="selected">不选择班级</option>
                    <option value="Java">Java</option>
                    <option value="C">C</option>
                    <option value="Web">Web</option>
                    <option value="Web">测试</option>
                    <option value="Web">C++</option>
                    <option value="Web">IOS</option>
                    <option value="Web">JSP</option>
                </select>
            </div>
        </div>
    </c:if>

    <c:if test="${sessionScope.userQuery.className=='Java'}">
        <div class="layui-form-item">
            <label class="layui-form-label">班级类型</label>
            <div class="layui-input-block">
                <select name='className' lay-filter="aihao">
                    <option value="">不选择班级</option>
                    <option value="Java" selected="selected">Java</option>
                    <option value="C">C</option>
                    <option value="Web">Web</option>
                    <option value="测试">测试</option>
                    <option value="C++">C++</option>
                    <option value="IOS">IOS</option>
                    <option value="JSP">JSP</option>
                </select>
            </div>
        </div>
    </c:if>
    <c:if test="${sessionScope.userQuery.className=='C'}">
        <div class="layui-form-item">
            <label class="layui-form-label">班级类型</label>
            <div class="layui-input-block">
                <select name='className' lay-filter="aihao">
                    <option value="">不选择班级</option>
                    <option value="Java">Java</option>
                    <option value="C" selected="selected">C</option>
                    <option value="Web">Web</option>
                    <option value="测试">测试</option>
                    <option value="C++">C++</option>
                    <option value="IOS">IOS</option>
                    <option value="JSP">JSP</option>
                </select>
            </div>
        </div>
    </c:if>
    <c:if test="${sessionScope.userQuery.className=='Web'}">
        <div class="layui-form-item">
            <label class="layui-form-label">班级类型</label>
            <div class="layui-input-block">
                <select name='className' lay-filter="aihao">
                    <option value="">不选择班级</option>
                    <option value="Java">Java</option>
                    <option value="C">C++</option>
                    <option value="Web" selected="selected">Web</option>
                    <option value="测试">测试</option>
                    <option value="C++">C++</option>
                    <option value="IOS">IOS</option>
                    <option value="JSP">JSP</option>
                </select>
            </div>
        </div>
    </c:if>

    <div class="layui-form-item">
        <label class="layui-form-label">班级编号</label>
        <div class="layui-input-inline">
            <c:choose>
                <c:when test="${sessionScope.userQuery.classNumb==''}">
                    <input type="text" name="classNumb" lay-verify="required" placeholder="请输入班级编号" class="layui-input">
                </c:when>
                <c:when test="${sessionScope.userQuery.classNumb==null}">
                    <input type="text" name="classNumb" lay-verify="required" placeholder="请输入班级编号" class="layui-input">
                </c:when>
                <c:when test="${sessionScope.userQuery.classNumb!=null}">
                    <input type="text" name="classNumb" lay-verify="required" value="${sessionScope.userQuery.classNumb}" class="layui-input">
                </c:when>
            </c:choose>
        </div>
    </div>

    <div class="layui-form-item">
        <button class="layui-btn layui-btn-sm layui-btn-primary" type="submit">提交</button>
        <button class="layui-btn layui-btn-sm layui-btn-primary" type="reset"
                onclick="location.href='/pages/TableServlet'">清空
        </button>
    </div>
</form>

<%--dajiahao--%>
<div class="layui-form">
    <table class="layui-table">
        <colgroup>
            <col width="150">
            <col width="150">
            <col width="150">
            <col width="150">
            <col width="150">
        </colgroup>
        <thead>
        <tr>
            <th>姓名</th>
            <th>班级类型</th>
            <th>班级名称</th>
            <th>性别</th>
            <th>状态</th>
        </tr>
        </thead>
        <!-- java循环 -->

        <tbody>
        <tr>
            <%
                List<UserDemo> userDemoList = (List<UserDemo>) request.getSession().getAttribute("userList");
                for (int i = 0; i < userDemoList.size(); i++) {
                    UserDemo userDemo = userDemoList.get(i);
            %>
            <td><%=userDemo.getU_name()%>
            </td>
            <td><%=userDemo.getU_class()%>
            </td>
            <td><%=userDemo.getU_classnumb()%>
            </td>
            <td>
                <% int j = userDemo.getU_sex();
                    if (j == 1) {%>
                男
                <%} else if (j == 2) {%>
                女
                <%} else {%>
                保密
                <%}%>
            </td>
            <td><%=userDemo.getU_status()%>
            </td>
        </tr>
        </tbody>
        <%}%>
    </table>
</div>

    <%Page p = (Page) request.getSession().getAttribute("page");%>

<%--分页页面拼接--%>
<%-- <a href="#" onclick="targetPage(1)">首页</a>--%>
<button class="layui-btn layui-btn-sm layui-btn-primary" href="/pages/NewTableServlet"
        onclick="targetPage(<%p.setPage(1);%>)">首页
</button>
<c:if test="<%=p.getPage()<=1%>">
<button class="layui-btn layui-btn-sm layui-btn-primary"><i class="layui-icon"></i></button>
</c:if>
<c:if test="<%=p.getPage()>1%>">
    <%--  <a href="#" onclick="targetPage(<%=p.getNowPage()-1%>)">上一页</a>--%>
<button class="layui-btn layui-btn-sm layui-btn-primary"
        onclick="targetPage(<%p.setPage(p.getPage()-1);%>)"><i
        class="layui-icon"></i></button>
</c:if>
<%--<c:if test="<%=p.getPage()==最后一页%>">
<button class="layui-btn layui-btn-sm layui-btn-primary"><i class="layui-icon"></i></button>
    <%--  下一页   --%>
<button class="layui-btn layui-btn-sm layui-btn-primary"
<%--onclick="location.href='/pages/NewTableServlet?pages=${page.page+1}'"><i--%>
        onclick="targetPage(<%=p.getPage()+1%>)"><i
        class="layui-icon"></i>
</button>
<%--    尾页      --%>
<button class="layui-btn layui-btn-sm layui-btn-primary" href="/pages/NewTableServlet"
        onclick="targetPage(<%=p.getPage()+100%>)">尾页
</button>


<%--表格导出--%>
    <%
    if (exportToExcel == null) {
%>

<button class="layui-btn layui-btn-sm layui-btn-primary" href="/pages/Table.jsp?exportToExcel=YES"
        onclick="location.href='/pages/Table.jsp?exportToExcel=YES'">表格导出
</button>
    <%
    }
%>

<%--分页+模糊--%>
<script type="text/javascript">

    function targetPage(nowPage) {
        //要查看的页数
        //获取表单中所有的数据
        var name = document.myform.name.value;
        var sex = document.myform.sex.value;
        var className = document.myform.className.value;
        var classNumb = document.myform.classNumb.value;

        location.href = "/pages/NewTableServlet?nowPage=" + nowPage + "&name=" + name + "&sex=" + sex + "&className" + className + "&classNumb" + classNumb;
    }
</script>


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
