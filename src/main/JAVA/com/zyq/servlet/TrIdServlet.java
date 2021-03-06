package com.zyq.servlet;

import com.zyq.bean.UserDemo;
import com.zyq.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TrIdServlet",value = "/pages/TrId")
public class TrIdServlet extends HttpServlet {
    private UserService userService=new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受要修改信息的ID
        String id=request.getParameter("id");
        //根据查询出用户的信息
        UserDemo userDemo=userService.getUserById(id);
        //将数据存入到request中
      /*  request.setAttribute("userDemo", userDemo);*/
        request.getServletContext().setAttribute("userDemo",userDemo);

        //当前用户的信息存储到session中
        request.getSession().setAttribute("userDemo", userDemo);
        //跳转jsp展示数据
        request.getRequestDispatcher("Amend.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
