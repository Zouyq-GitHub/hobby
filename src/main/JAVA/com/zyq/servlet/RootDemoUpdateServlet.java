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

/**
 * 业务层删除页面展示
 */
@WebServlet(name = "RootDemoUpdateServlet",value = "/pages/RootDemoUpdateServlet")
public class RootDemoUpdateServlet extends HttpServlet {
    //业务层方法
    private RootService rootService =new RootService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用方法执行查询
        List<RootDemo> Rootlist = rootService.getRootList();
        //查询完成添加
        request.setAttribute("Rootlist",Rootlist);
        //跳
        request.getRequestDispatcher("RootQueryUpdate.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
