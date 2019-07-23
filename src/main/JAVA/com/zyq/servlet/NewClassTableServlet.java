package com.zyq.servlet;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.zyq.bean.ClassDemo;
import com.zyq.bean.ClassName;
import com.zyq.bean.Page;
import com.zyq.service.ClassService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NewClassTableServlet", value = "/pages/NewClassTableServlet")
public class NewClassTableServlet extends HttpServlet {

    //业务层
    private ClassService classService = new ClassService();
    //班级实体类
    private ClassDemo classDemo = new ClassDemo();
    //

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受分页的参数
        String nowPage = request.getParameter("nowPage");
        String pageSize = request.getParameter("pageSize");

        //分页的参数存储到page中
        Page page = new Page();

        //模糊查询 班级名称 班级状态 信息接收
        String ClassName = request.getParameter("ClASSName");
        //t


        String ClassStatus = request.getParameter("ClassStatus");

        /*if (ClassName == null || "".equals(ClassName)) {
            ClassName = (String) request.getSession().getAttribute("ClASSName");
        }*/
        if (ClassStatus == null || "".equals(ClassStatus)) {
            ClassStatus = (String) request.getSession().getAttribute("ClassStatus");
        }

        //获取信息保存集合
        List<ClassName> ClassList = classService.getClassList(ClassName, ClassStatus, page);
        //传入集合
        request.getSession().setAttribute("ClassList", ClassList);
        //传入count数据
        int count = classService.getClassCount(ClassName, ClassStatus);



        //查询条件存入request中
        if (ClassName != null && !"".equals(ClassName)) {
            request.getSession().setAttribute("ClASSName", ClassName);
        }
        if (ClassStatus != null && !"".equals(ClassStatus)) {
            request.getSession().setAttribute("ClassStatus", ClassStatus);
        }
        //传入分页的参数
        request.getSession().setAttribute("page", page);
        // request.getServletContext().setAttribute("page", page);
        //请求转发
        request.getRequestDispatcher("ClassTable.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
