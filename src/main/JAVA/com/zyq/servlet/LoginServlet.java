package com.zyq.servlet;

import com.zyq.bean.Menu;
import com.zyq.bean.RootDemo;
import com.zyq.bean.UserDemo;
import com.zyq.service.RootService;
import com.zyq.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {


    private static final long serialVersionUID = 1L;
    //业务层类导入
    private UserService userService = new UserService();
    //业务层
    private RootService rootService = new RootService();
    //
    private RootDemo rootDemo = new RootDemo();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收参数
        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        //判断是否搞事情
        if (loginName == null || "".equals(loginName)) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('请规范操作!');</script>");
            response.getWriter().write("<script>alert('网页将跳回到登录页面'); window.location='Hello.jsp' ;window.close();</script>");
            response.getWriter().flush();
        }
        if (password == null || "".equals(password)) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('请规范操作!');</script>");
            response.getWriter().write("<script>alert('网页将跳回到登录页面'); window.location='Hello.jsp' ;window.close();</script>");
            response.getWriter().flush();
        }else {
            //业务层实现功能  用户类接收
            rootDemo = rootService.login(loginName, password);
            //根据返回的信息进行处理
            if (rootDemo.getId()!=0) {
                //登录成功
                //添加
                request.getSession().setAttribute("RootDemo", rootDemo);
                //请求转发
                request.getRequestDispatcher("pages/HomeServlet").forward(request, response);
            } else {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("<script>alert('登录失败');</script>");
                response.getWriter().write("<script>alert('网页将跳回到登录页面'); window.location='Hello.jsp' ;window.close();</script>");
                response.getWriter().flush();
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}