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

@WebServlet(name = "ClassFormAddServlet", value = "/pages/ClassFormAddServlet")
public class ClassFormAddServlet extends HttpServlet {
    private ClassService classService = new ClassService();
    private ClassName className = new ClassName();
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

        //模糊查询姓名、性别、班级名称、班级编号接受
        String nameString = request.getParameter("name");
        String sexString = request.getParameter("sex");
        String classNames = request.getParameter("className");
        String classNumb = request.getParameter("classNumb");

        List<ClassDemo> classDemoList = classService.getByidClassForm(nameString, sexString, classNames, classNumb, page);
        //查询班级类型遍历的集合
        //存入集合
        request.getSession().setAttribute("classDemoList", classDemoList);

        //获取信息保存集合
        List<ClassName> ClassFromList = classService.getClassList(ClassName, ClassStatus, page);
        //传入集合
        request.getSession().setAttribute("ClassFromList", ClassFromList);
        //传入count数据
        int count = classService.getClassCount(ClassName, ClassStatus);

        //传入分页的参数
        request.getSession().setAttribute("page", page);
        //   request.getServletContext().setAttribute("page", page);
        //请求转发
        request.getRequestDispatcher("ClassFormAdd.jsp").forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
