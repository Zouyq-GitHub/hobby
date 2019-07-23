package com.zyq.servlet;

import com.zyq.service.ClassService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 接受提交来的新的班级类型添加
 */

@WebServlet(name = "ClassFormSubmitServlet", value = "/pages/ClassFormSubmitServlet")
public class ClassFormSubmitServlet extends HttpServlet {
    //业务层
    private ClassService classService = new ClassService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受提交的参数
        String ClassForm = request.getParameter("ClassForm");
        //调用业务层执行添加功能
        boolean isok =classService.ClassFormAdd(ClassForm);
        if (isok){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('添加成功');</script>");
            response.getWriter().write("<script>alert('网页回到主页'); window.location='TableServlet' ;window.close();</script>");
            response.getWriter().flush();
        }else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('添加失败,班级类型重复');</script>");
            response.getWriter().write("<script>alert('网页回到主页'); window.location='TableServlet' ;window.close();</script>");
            response.getWriter().flush();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
