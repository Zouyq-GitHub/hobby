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

@WebServlet(name = "ClassAmendServlet", value = "/pages/ClassAmendServlet")
public class ClassAmendServlet extends HttpServlet {
    //对象实例化
    /*private ClassDemo classDemo = new ClassDemo();
    private Page page;*/
    //业务层
    //实体类
    private ClassName className = new ClassName();
    private ClassService classService =new ClassService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受分页的参数
        String nowPage = request.getParameter("nowPage");
        String pageSize = request.getParameter("pageSize");
        String ClassNames = request.getParameter("ClASSName");
        String ClassStatus = request.getParameter("ClassStatus");

        //分页的参数存储到page中
        Page page = new Page();


        //获取信息保存集合
        List<ClassName> classList = classService.getClassList(ClassNames,ClassStatus,page);
        request.getSession().setAttribute("classList", classList);
        //传入count数据
        int count=classService.getClassCount(ClassNames,ClassStatus);

        //查询条件存入request中
        if (ClassNames != null && !"".equals(ClassNames)) {
            request.getSession().setAttribute("ClASSName", ClassNames);
        }
        //传入分页的参数
        request.getSession().setAttribute("page", page);
        request.getServletContext().setAttribute("page", page);
        //跳
        request.getRequestDispatcher("ClassAmend.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
