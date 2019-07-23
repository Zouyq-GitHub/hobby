package com.zyq.servlet;

import com.zyq.bean.RootDemo;
import com.zyq.bean.UserDemo;
import com.zyq.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * 更改密码的Se
 */
@WebServlet(name = "PsWdServlet",value = "/pages/Ps")
public class PsWdServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*//接受用户类
        RootDemo rootDemo= (RootDemo) request.getServletContext().getAttribute("RootDemo");

        System.out.println();
        System.out.println();
        System.out.println(rootDemo);*/
        //跳转jsp
        request.getRequestDispatcher("Ps.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
