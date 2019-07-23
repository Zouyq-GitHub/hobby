package com.zyq.servlet;

import com.zyq.bean.UserDemo;
import com.zyq.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserDownOverServlet",value = "/pages/UserDownOverServlet")
public class UserDownOverServlet extends HttpServlet {
    UserDemo userDemo = new UserDemo();
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受要修改的用户信息
        String ID = request.getParameter("id");
        String ClassName = request.getParameter("ClassName");
        String ClassNumb = request.getParameter("ClassNumb");
        //添加对象

        userDemo.setId(Integer.parseInt(ID));
        userDemo.setU_class(ClassName);
        userDemo.setU_classnumb(ClassNumb);

        //调用业务层方法
        boolean isok = userService.DownOver(userDemo);
        if (isok == true) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('已设置该学员滑班');</script>");
            response.getWriter().write("<script>alert('网页将跳转到主页'); window.location='TableServlet' ;window.close();</script>");
            response.getWriter().flush();
        } else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('修改失败');</script>");
            response.getWriter().write("<script>alert('网页将跳转到主页'); window.location='TableServlet' ;window.close();</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
