package com.zyq.servlet;

import com.zyq.bean.UserDemo;
import com.zyq.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AmendServlet", value = "/pages/AmendServlet")
public class AmendServlet extends HttpServlet {
    private UserService userService = new UserService();
    UserDemo userDemo = new UserDemo();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受表单中的信息
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        userDemo.setU_classnumb(age);
        userDemo.setU_name(name);
        userDemo.setId(Integer.parseInt(id));
        userDemo.setU_class(address);
        userDemo.setU_sex(Integer.parseInt(sex));
        //调用业务层完成功能
        boolean isok=userService.updateUser(userDemo);
        if (isok==true) {
            //跳转主页
            response.sendRedirect("TableServlet");
        }else {
            //跳转修改
            response.sendRedirect("TableServlet");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
