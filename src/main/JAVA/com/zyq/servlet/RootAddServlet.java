package com.zyq.servlet;

import com.zyq.bean.RootDemo;
import com.zyq.service.RootService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 管理员添加Se
 */
@WebServlet(name = "RootAddServlet", value = "/pages/RootAddServlet")
public class RootAddServlet extends HttpServlet {
    //业务层
    private RootService rootService = new RootService();
    //对象
    private RootDemo rootDemo = new RootDemo();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受表单传入的信息
        String LoginName = request.getParameter("LoginName");
        String PassWord = request.getParameter("PassWord");
        String Name = request.getParameter("Name");
        // String r_roleid = request.getParameter("address");
        //将参数封装到对象
        rootDemo.setR_loginName(LoginName);
        rootDemo.setR_PassWord(PassWord);
        rootDemo.setR_Name(Name);
        //调用业务层的方法
        boolean isok = rootService.regRoot(rootDemo);
        if (isok ==true){
            //添加成功
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('添加管理员成功');</script>");
            response.getWriter().write("<script>alert('网页将跳转到主页'); window.location='TableServlet' ;window.close();</script>");
            response.getWriter().flush();
        }else {
            //添加失败
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('添加管理员失败');</script>");
            response.getWriter().write("<script>alert('网页将跳转到主页'); window.location='TableServlet' ;window.close();</script>");
            response.getWriter().flush();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
