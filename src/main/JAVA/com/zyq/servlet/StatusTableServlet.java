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
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StatusTableServlet", value = "/pages/StatusTableServlet")
public class StatusTableServlet extends HttpServlet {
    private ClassService classService = new ClassService();
    private ClassName className =new ClassName();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受分页的参数
        String nowPage = request.getParameter("nowPage");
        String pageSize = request.getParameter("pageSize");

        //分页的参数存储到page中
        Page page = new Page();


        //模糊查询 班级名称
        String ClassName = request.getParameter("ClASSName");
        String ClassStatus = request.getParameter("ClassStatus");

        //获取信息保存集合
        List<ClassName> ClassStatusList = classService.getStatusClassList(ClassName, ClassStatus, page);
        //传入集合
        request.getSession().setAttribute("ClassStatusList", ClassStatusList);
        //传入count数据
        int count = classService.getClassCount(ClassName, ClassStatus);

        //查询条件存入request中
        if (ClassName != null && !"".equals(ClassName)) {
            request.getSession().setAttribute("ClASSName", ClassName);
        }
        //传入分页的参数
        request.getSession().setAttribute("page", page);
        request.getServletContext().setAttribute("page", page);
        //赋值
        request.getSession().setAttribute("ClASSName", "-1");
        request.getSession().setAttribute("ClassStatus", "-10");
        //请求转发
        request.getRequestDispatcher("StatusTable.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
