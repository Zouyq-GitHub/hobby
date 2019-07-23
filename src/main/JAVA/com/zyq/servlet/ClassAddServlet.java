package com.zyq.servlet;

import com.zyq.bean.ClassDemo;
import com.zyq.bean.ClassName;
import com.zyq.service.ClassService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ClassAddServlet", value = "/pages/ClassAddServlet")
public class ClassAddServlet extends HttpServlet {
    //业务层
    private ClassService classService = new ClassService();
    //实体类
    private ClassDemo classDemo = new ClassDemo();
    //实体类
    private ClassName className = new ClassName();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取提交的信息
        String ClassNames = request.getParameter("ClassName");
        //存入对象
        className.setC_Name(ClassNames);
        //调用业务层
        boolean isok = classService.AddClass(className);
        if (isok) {
            response.setContentType("text/html;charset=utf-8");

            response.getWriter().write("<script>alert('开班完成');</script>");
            response.getWriter().write("<script>alert('网页回到主页'); window.location='TableServlet' ;window.close();</script>");
            response.getWriter().flush();

        } else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('开班失败');</script>");
            response.getWriter().write("<script>alert('网页回到主页'); window.location='TableServlet' ;window.close();</script>");
            response.getWriter().flush();

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
