package com.zyq.servlet;

import com.zyq.bean.RootDemo;
import com.zyq.bean.UserDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ExitServlet", value = "/Ex")
public class ExitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取在线用户列表 userList
        Object object = request.getSession().getAttribute("RootDemo");
        if (object != null) {
            //当前用户
            RootDemo rootDemo = (RootDemo) request.getSession().getAttribute("RootDemo");

            request.getSession().removeAttribute("RootDemo");
        }
        //跳转到登陆页面
        request.getRequestDispatcher("Hello.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
