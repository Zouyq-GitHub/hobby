package com.zyq.servlet;

import com.zyq.bean.UserDemo;
import com.zyq.dao.ClassDao;
import com.zyq.dao.UserDao;
import com.zyq.service.UserService;
import com.zyq.util.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 添加测试对象
 */

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
    UserService userService = new UserService();
    UserDao userDao = new UserDao();
    JdbcUtil jdbcUtil=new JdbcUtil();
    ClassDao classDao =new ClassDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      /*  //封装对象
        UserDemo userDemo=new UserDemo();
        userDemo.setU_sex(1);
        userDemo.setU_name("2");
        userDemo.setId(3);
        userDemo.setU_address("4");
        userDemo.setU_loginName("5");
        userDemo.setU_password("6");
        userDemo.setU_status("7");
        userDemo.setU_age("8");

        List<UserDemo> userDemoList=userService.getUserDemoList();
        for (UserDemo userDemo1 : userDemoList){
            System.out.println(userDemo1);
        }*//*
        //业务层实现功能  用户类接收
        UserDemo userDemo = userService.login("zyq", "123");
        //1准备sql
        String sql = "insert into UserDemo value(0,?,?,?,?,?,?,'Start') ";
        int i=0;
        //准备sql对应参数
        Object[] params = {userDemo.getU_name(),
                userDemo.getU_class(), userDemo.getU_classnumb()+1, userDemo.getU_sex()};
        //执行sql语句
        while (i<50){
            jdbcUtil.executeUpdate(sql, params);
            i++;
        }
        //关资源
        jdbcUtil.closeRes();*/

      //  classDao.addRootSSSSSSSSSSSSSSSSS();
       /* File file = new File("C:\\TEST\\SSSSSSSSSSSSSSSSSSSSSSSS\\Test.xlsx");
        String[][] result = getData(file,1);
*/

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
