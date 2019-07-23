package com.zyq.servlet;

import com.zyq.bean.Page;
import com.zyq.bean.RootDemo;
import com.zyq.bean.UserDemo;
import com.zyq.service.RootService;
import com.zyq.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NewPsServlet", value = "/pages/NewPsServlet")
public class NewPsServlet extends HttpServlet {
    //业务层方法
    private RootService rootService = new RootService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RootDemo rootDemo = (RootDemo) request.getSession().getAttribute("RootDemo");

        //分页板块
        //接受分页的参数
        String nowPage = request.getParameter("nowPage");
        String pageSize = request.getParameter("pageSize");
        //分页的参数存储到page中
        Page page = new Page();

        //模糊查询姓名
        String nameString = request.getParameter("name");
        String sexString = request.getParameter("sex");

        //获取信息保存集合
        List<RootDemo> RootList = rootService.getRootList();
        request.getSession().setAttribute("RootList", RootList);

        //查询条件存入request中
        if (nameString != null && !"".equals(nameString)) {
            request.setAttribute("name", nameString);
        }
        if (sexString != null && !"".equals(sexString)) {
            request.setAttribute("sex", sexString);
        }
        //传入分页的参数
        request.setAttribute("page", page);
        //接受传入的参数
        String password = request.getParameter("password");
        if (password.equals(rootDemo.getR_PassWord())){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('新密码不能同当前密码相同');</script>");
            response.getWriter().write("<script>alert('网页将跳转到主页'); window.location='TableServlet' ;window.close();</script>");
            response.getWriter().flush();
        }
        //获取用户类
        rootDemo= (RootDemo) request.getSession().getAttribute("RootDemo");
        //调用业务层修改密码
        boolean isok = rootService.NewPassWord(rootDemo, password);
        if (isok == true) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('密码修改成功');</script>");
            response.getWriter().write("<script>alert('将在下次登录时生效'); window.location='TableServlet' ;window.close();</script>");
            response.getWriter().flush();

        } else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('密码修改失败');</script>");
            response.getWriter().write("<script>alert('网页将跳转到主页'); window.location='TableServlet' ;window.close();</script>");
            response.getWriter().flush();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
