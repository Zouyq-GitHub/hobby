package com.zyq.servlet;

import com.zyq.service.ClassService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ClassIdDateServlet",value = "/pages/ClassIdDateServlet")
public class ClassIdDateServlet extends HttpServlet {
    //业务层方法
    private ClassService classService = new ClassService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户删除的ID
        String id = request.getParameter("id");
        //业务层删除用户
        boolean isok = classService.dropClassById(id);
        if (isok) {
            //删除成功了
            //up删除进入成功
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('删除成功');</script>");
            response.getWriter().write("<script>alert('网页将跳转到主页'); window.location='TableServlet' ;window.close();</script>");
            response.getWriter().flush();
            //  response.sendRedirect("TableServlet");
            //     response.sendRedirect("http://www.baidu.com");
        } else {
            //登录失败  重定向
            response.sendRedirect("TableServlet");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
