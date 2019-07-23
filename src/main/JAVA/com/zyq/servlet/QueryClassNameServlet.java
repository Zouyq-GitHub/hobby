package com.zyq.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 二级联动查询Se
 */
@WebServlet(name = "QueryClassNameServlet",value = "/pages/QueryClassNameServlet")
public class QueryClassNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String ClassFormID =  request.getParameter("classType");
        System.out.println("二级联动QCNS："+ClassFormID);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
