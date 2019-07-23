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

@WebServlet(name = "ClassSubmitServlet", value = "/pages/ClassSubmitServlet")
public class ClassSubmitServlet extends HttpServlet {
    //实例化和业务层
    private ClassDemo classDemo = new ClassDemo();
    private ClassService classService = new ClassService();
    private ClassName className = new ClassName();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID = request.getParameter("id");
        String ClassNames = request.getParameter("ClassName");
        String ClassForm = request.getParameter("ClassForm");
        String Status = request.getParameter("Status");

        //添加对象
        className.setId(Integer.parseInt(ID));
        className.setC_Name(ClassNames);
        classDemo.setC_Form(ClassForm);
        className.setC_Status(Integer.parseInt(Status));

        //业务层
        boolean isok = classService.updateClass(className);
        if (isok) {
            System.out.println("班级修改成功");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('班级修改完成');</script>");
            response.getWriter().write("<script>alert('网页将跳转到主页'); window.location='TableServlet' ;window.close();</script>");
            response.getWriter().flush();
        } else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('班级修改失败');</script>");
            response.getWriter().write("<script>alert('网页将跳转到主页'); window.location='TableServlet' ;window.close();</script>");
            response.getWriter().flush();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
