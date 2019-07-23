package com.zyq.servlet;
/**
 * 主页面servlet
 */

import com.zyq.bean.Menu;
import com.zyq.bean.Page;
import com.zyq.bean.RootDemo;
import com.zyq.bean.UserDemo;
import com.zyq.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/pages/HomeServlet")
public class HomeServlet extends HttpServlet {
    UserService userService = new UserService();
    UserDemo userDemo = new UserDemo();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //清空session
        HttpSession httpSession = request.getSession();
        RootDemo rootDemo = (RootDemo) httpSession.getAttribute("RootDemo");
        if (rootDemo == null) {
            //跳转到登陆页面
            request.getRequestDispatcher("Hello.jsp").forward(request, response);
            return;
        }
        //接受分页的参数
        String nowPage = request.getParameter("nowPage");
        String pageSize = request.getParameter("pageSize");
        //    UserDemo userDemo= (UserDemo) request.getSession().getAttribute("userDemo");
        //UserDemo数据查询
        userDemo = userService.IDQuery("2");
        //当前用户的信息存储到session中
        request.getSession().setAttribute("userDemo", userDemo);
        //    userDemo = (UserDemo) request.getServletContext().getAttribute("userDemo");
        Page page = new Page();

        //模糊查询
        String nameString = request.getParameter("name");
        String sexString = request.getParameter("sex");
        String className = request.getParameter("className");
        String classNumb = request.getParameter("classNumb");
        //

        //查询数据库中对应的菜单信息
        List<Menu> menuList = userService.menu(userDemo);
        //传入request
        request.setAttribute("menuList", menuList);

        //将查询条件存储到request中
        if (nameString != null && !"".equals(nameString)) {
            request.setAttribute("name", nameString);
        }
        if (sexString != null && !"".equals(sexString)) {
            request.setAttribute("sex", sexString);
        }
        //请求转发
        request.getRequestDispatcher("Home.jsp").forward(request, response);
    }
}
