package com.zyq.servlet;

import com.zyq.bean.RootDemo;
import com.zyq.service.RootService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RootQueryServlet", value = "/pages/RootQueryServlet")
public class RootQueryServlet extends HttpServlet {
    //查询方法
    private RootService rootService = new RootService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用方法执行查询
        List<RootDemo> Rootlist = rootService.getRootList();
        System.out.println("接下来是管理员查询功能的遍历测试");
        //遍历测试
        for (RootDemo rootDemo : Rootlist) {
            System.out.println(rootDemo);
        }
        //查询完成返回
        request.setAttribute("Rootlist",Rootlist);
        //跳
        request.getRequestDispatcher("RootQuery.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
