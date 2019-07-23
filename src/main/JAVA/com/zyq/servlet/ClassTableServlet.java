package com.zyq.servlet;

import com.zyq.bean.ClassDemo;
import com.zyq.bean.ClassName;
import com.zyq.bean.Page;
import com.zyq.service.ClassService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 班级各种查询打印的表格
 */
@WebServlet(name = "ClassTableServlet", value = "/pages/ClassTableServlet")
public class ClassTableServlet extends HttpServlet {
    //业务层
    private ClassService classService = new ClassService();
    //班级实体类
    private ClassDemo classDemo = new ClassDemo();
    //
    private ClassName className = new ClassName();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //赋值
        request.getSession().removeAttribute("ClASSName");
        //接受分页的参数
        String nowPage = request.getParameter("nowPage");
        String pageSize = request.getParameter("pageSize");
        String ClassNames = request.getParameter("ClASSName");
        //模糊查询姓名、性别、班级名称、班级编号接受
        String nameString = request.getParameter("name");
        String sexString = request.getParameter("sex");
        String classNames = request.getParameter("className");
        String classNumb = request.getParameter("classNumb");



        //模糊查询 班级名称
        String ClASSName = request.getParameter("ClASSName");


        String ClassStatus = request.getParameter("ClassStatus");
        //1111111111111111

        //查询班级类型遍历的集合
        //存入集合

        //1111111111111111111

    //   获取信息保存集合

        //传入集合


        //传入count数据
        int count = classService.getClassCount(ClASSName, ClassStatus);

    //    ClASSName = null;
        ClassStatus = "-10";

        //查询条件存入request中
        request.getSession().setAttribute("ClASSName", ClASSName);
        request.getSession().setAttribute("ClassStatus", ClassStatus);


        //请求转发
        request.getRequestDispatcher("ClassTable.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
