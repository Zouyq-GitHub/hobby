package com.zyq.servlet;

import com.zyq.bean.UserDemo;
import com.zyq.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserADDServlet",value = "/pages/UserADDServlet")
public class UserADDServlet extends HttpServlet {
    UserDemo userDemo = new UserDemo();
    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受要修改的用户信息
        String ID = request.getParameter("id");
        String Name = request.getParameter("name");
        String ClassName = request.getParameter("ClassName");
        String ClassNumb = request.getParameter("ClassNumb");
        String Sex = request.getParameter("sex");

        //添加对象

        userDemo.setId(Integer.parseInt(ID));
        userDemo.setU_name(Name);
        userDemo.setU_class(ClassName);
      //  userDemo.setU_classnumb(ClassNumb);
        userDemo.setU_classnumb(ClassNumb);
        userDemo.setU_sex(Integer.parseInt(Sex));

        //调用业务层方法
        boolean isok = userService.updateUser(userDemo);
        if (isok==true){
            System.out.println("修改成功");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('修改完成');</script>");
            response.getWriter().write("<script>alert('网页将跳转到主页'); window.location='TableServlet' ;window.close();</script>");
            response.getWriter().flush();
        }else {
            System.out.println("修改失败");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('修改失败');</script>");
            response.getWriter().write("<script>alert('网页将跳转到主页'); window.location='TableServlet' ;window.close();</script>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
