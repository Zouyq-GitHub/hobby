package com.zyq.servlet;

import com.zyq.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 批量删除
 */
@WebServlet(name = "UserBatchDeServlet", value = "/pages/UserBatchDeServlet")
public class UserBatchDeServlet extends HttpServlet {
    UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受选择的编号
        Object[] objects = request.getParameterValues("ss");
        boolean isok = userService.UserByIdSDele(objects);
        if (isok) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('全部删除完成');</script>");
            response.getWriter().write("<script>alert('网页将跳转到主页'); window.location='TableServlet' ;window.close();</script>");
            response.getWriter().flush();
        } else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('全部删除失败完成');</script>");
            response.getWriter().write("<script>alert('网页将跳转到主页'); window.location='TableServlet' ;window.close();</script>");
            response.getWriter().flush();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
