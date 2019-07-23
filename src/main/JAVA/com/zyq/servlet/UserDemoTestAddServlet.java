package com.zyq.servlet;

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
 * 测试用户添加BatisSe
 * ${Descripton}
 *
 * @author admin
 * @date 2019-06-03 19:16
 */
@WebServlet(name = "UserDemoTestAddServlet",value = "/pages/UserDemoTestAddServlet")
public class UserDemoTestAddServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受传入的参数内容
        String name = request.getParameter("Name");
        String address = request.getParameter("address");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        //将参数封装为对象
        UserDemo userDemo = new UserDemo();
        userDemo.setId(0);
        userDemo.setU_name(name);
        userDemo.setU_class(address);
        userDemo.setU_classnumb(age);
        userDemo.setU_sex(Integer.parseInt(sex));
        userDemo.setU_status("Start");
        userDemo.setU_roleid(1);
        //呼叫业务层
        boolean isok = userService.save(userDemo);
        if (isok == true) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('添加成功');</script>");
            response.getWriter().write("<script>alert('将跳转到主页'); window.location='TableServlet' ;window.close();</script>");
            response.getWriter().flush();

        } else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('添加失败，请规范操作!');</script>");
            response.getWriter().write("<script>alert('将跳转到主页'); window.location='TableServlet' ;window.close();</script>");
            response.getWriter().flush();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
