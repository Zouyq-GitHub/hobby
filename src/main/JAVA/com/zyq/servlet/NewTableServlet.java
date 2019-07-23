package com.zyq.servlet;

import com.github.pagehelper.PageHelper;
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
@WebServlet(name = "NewTableServlet", value = "/pages/NewTableServlet")
public class NewTableServlet extends HttpServlet {

    /**
     * 实例化业务层
     */
    private UserService userService = new UserService();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受对象分页实体类
        Page page = (Page) request.getSession().getAttribute("page");
        //接受对象查询实体类
        UserQuery userQuery = (UserQuery) request.getSession().getAttribute("userQuery");
        //接受分页的参数
        String nowPage = request.getParameter("nowPage");
        //测试分页的参数 new
        System.out.println("测试分页的传入参数NewTableSe: page:"+nowPage);


        //判断之后添加参数
        if (nowPage != null && !"".equals(nowPage)) {
            page.setPage(Integer.parseInt(nowPage));
        } else {
            page.setPage(1);
        }

        //获取信息保存集合1.0
        //添加到page类中
        System.out.println("玩玩当前页:" + page.getPage());
        int pages = page.getPage();
        int number = page.getNumber();
        PageHelper.startPage(pages, number);
        /*查询所用学生信息方法*/
        /*List<UserDemo> userDemoList = userService.queryStudent();*/
        //传入page对象
        request.getSession().setAttribute("page", page);
        //模糊查询
        //接受查询数据
        String studyName = request.getParameter("name");
        String sex = request.getParameter("sex");
        String className = request.getParameter("className");
        String classNumb = request.getParameter("classNumb");
        //判断参数是否为null将参数传入模糊查询的实体类
        if (studyName != null || !"".equals(studyName)) {
            userQuery.setStudyName(studyName);
        }
        if (sex != "10") {
            userQuery.setUserSex(sex);
        }
        if (className != null || !"".equals(className)) {
            userQuery.setClassName(className);
        }
        if (classNumb != null || !"".equals(classNumb)) {
            userQuery.setClassNumb(classNumb);
        }
        studyName = userQuery.getStudyName();
        //实体类传入
        request.getSession().setAttribute("userQuery", userQuery);
        //打印测试
        System.out.println("打印测试NewTableSe+63行4个参数\n:studyName:" + studyName + "\nsex:" + sex + "\nclassName:" + className + "\nclassNumb:" + classNumb);
        //执行模糊查询语句
        List<UserDemo> userList = userService.getUserList(studyName, sex, className, classNumb);
        request.getSession().setAttribute("userList", userList);
        //将接受到的查询数据传入JSP展示
        /*request.getSession().setAttribute("name", studyName);
        request.getSession().setAttribute("sex", sex);
        request.getSession().setAttribute("className", className);
        request.getSession().setAttribute("classNumb", classNumb);*/
        //请求转发表格
        request.getRequestDispatcher("Table.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
