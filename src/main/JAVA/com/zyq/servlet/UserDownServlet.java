package com.zyq.servlet;

import com.zyq.bean.Page;
import com.zyq.bean.UserDemo;
import com.zyq.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 选择花瓣的学员Se
 */
@WebServlet(name = "UserDownServlet",value = "/pages/UserDownServlet")
public class UserDownServlet extends HttpServlet {
    //业务层
    private UserService userService = new UserService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受分页的参数
        String nowPage = request.getParameter("nowPage");
        String pageSize = request.getParameter("pageSize");
        String className = request.getParameter("className");
        String classNumb = request.getParameter("classNumb");

        //分页的参数存储到page中
        Page page = new Page();

        //模糊查询姓名
        String nameString = request.getParameter("name");
        String sexString = request.getParameter("sex");

        //获取信息保存集合
        List<UserDemo> userList = userService.getUserList(nameString, sexString, className, classNumb);
        request.setAttribute("userList", userList);
        //传入count数据
        int count = userService.getUserCount(nameString, sexString, className, className);

        //查询条件存入request中
        if (nameString != null && !"".equals(nameString)) {
            request.setAttribute("name", nameString);
        }
        if (sexString != null && !"".equals(sexString)) {
            request.setAttribute("sex", sexString);
        }
        request.getSession().setAttribute("page", page);
        request.getServletContext().setAttribute("page", page);
        //跳
        request.getRequestDispatcher("UserDown.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
