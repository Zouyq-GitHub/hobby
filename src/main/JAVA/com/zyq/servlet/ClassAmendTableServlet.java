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
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ClassAmendTableServlet", value = "/pages/ClassAmendTableServlet")
public class ClassAmendTableServlet extends HttpServlet {
    private ClassDemo classDemo = new ClassDemo();
    private ClassService classService = new ClassService();
    //实体类
    private ClassName className = new ClassName();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受要修改信息的ID
        String id = request.getParameter("id");
        //根据ID查询出用户的信息
        className = classService.getClassById(id);

        //模糊查询姓名、性别、班级名称、班级编号接受
        String nameString = request.getParameter("name");
        String sexString = request.getParameter("sex");
        String classNames = request.getParameter("className");
        String classNumb = request.getParameter("classNumb");
        Page page = new Page();

        List<ClassDemo> classDemoList = classService.getByidClassForm(nameString, sexString, classNames, classNumb, page);
        //查询班级类型遍历的集合
        //存入集合
        request.getSession().setAttribute("classDemoList", classDemoList);
        //当前用户的信息存储到session中
        request.getSession().setAttribute("className", className);
        //跳转jsp展示数据
        request.getRequestDispatcher("ClassAmendTable.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
