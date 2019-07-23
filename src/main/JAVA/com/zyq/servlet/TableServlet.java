package com.zyq.servlet;

import com.github.pagehelper.PageHelper;
import com.sun.org.apache.regexp.internal.RE;
import com.zyq.bean.Page;
import com.zyq.bean.UserDemo;
import com.zyq.bean.UserQuery;
import com.zyq.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 邹雨樵
 * @date 2019/6/14
 * @since 1.0.0
 */
@WebServlet("/pages/TableServlet")
public class TableServlet extends HttpServlet {
    /**
     * 业务层实例化
     */
    private UserService userService = new UserService();
    /**
     * 实例化分页对象
     */
    private Page page = new Page();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* 获取信息保存集合1.0*/
        /*分页插件代码*/
        page.setPage(1);
        page.setNumber(6);
        /*传入分页对象*/
        request.getSession().setAttribute("page",page);
        /*传入分页条件*/
        int pages = page.getPage();
        int number = page.getNumber();
        PageHelper.startPage(pages, number);
        /*查询所用学生信息方法*/
        List<UserDemo> userDemoList = userService.queryStudent();
        request.getSession().setAttribute("userList", userDemoList);
        //赋值
        request.getSession().setAttribute("sex", null);
        request.getSession().setAttribute("name", null);
        request.getSession().setAttribute("classNumb", null);
        request.getSession().setAttribute("className", null);
        //查询条件实体类
        UserQuery userQuery = new UserQuery();
        userQuery.setClassName("");
        userQuery.setUserSex(null);
        userQuery.setClassNumb(null);
        userQuery.setStudyName(null);
        //传入
        request.getSession().setAttribute("userQuery", userQuery);

        //请求转发表格
        request.getRequestDispatcher("Table.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
