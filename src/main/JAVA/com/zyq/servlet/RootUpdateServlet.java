package com.zyq.servlet;

import com.zyq.bean.RootDemo;
import com.zyq.service.RootService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RootUpdateServlet",value = "/pages/RootUpdateServlet")
public class RootUpdateServlet extends HttpServlet {
    //业务层方法
    private RootService rootService = new RootService();
   // private RootDemo rootDemo =new RootDemo();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        RootDemo rootDemo= (RootDemo) request.getSession().getAttribute("RootDemo");
        if ("1".equals(id)){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('不能删除超级管理员');</script>");
            response.getWriter().write("<script>alert('网页回到主页'); window.location='TableServlet' ;window.close();</script>");
            response.getWriter().flush();
        }else {
            if (rootDemo.getR_roleid()==1){
                //获取管理员删除的ID
                //业务层删除管理员
                boolean isok = rootService.deleteRootById(id);
                if (isok==true){
                    System.out.println("删除完成");
                    response.setContentType("text/html;charset=utf-8");
                    response.getWriter().write("<script>alert('删除成功');</script>");
                    response.getWriter().write("<script>alert('网页回到主页'); window.location='TableServlet' ;window.close();</script>");
                    response.getWriter().flush();
                }else {
                    System.out.println("删除失败");
                }
            }else {
                response.getWriter().write("<script>alert('只有超级管理员才能删除管理员');</script>");
                response.getWriter().write("<script>alert('网页回到主页'); window.location='TableServlet' ;window.close();</script>");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
