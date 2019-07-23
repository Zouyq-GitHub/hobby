package com.zyq.dao;

import com.zyq.bean.ClassDemo;
import com.zyq.bean.ClassName;
import com.zyq.bean.Page;
import com.zyq.util.JdbcUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 班级Dao层
 */
public class ClassDao extends JdbcUtil {
    private ClassDemo classDemo = new ClassDemo();
    private ClassName className = new ClassName();

    //开班功能
    public boolean addRoot(ClassName className) {
        //1准备sql
        String sql = "insert into ClassName value(0,?,?) ";
        //准备sql对应参数
        Object[] params = {className.getC_Name(),
                "1"};
        //执行sql语句
        boolean isok = this.executeUpdate(sql, params);
        //关资源
        this.closeRes();
        return isok;
    }

    //循环开班功能
    public void addRootSSSSSSSSSSSSSSSSS() {
        //1准备sql
        String sql = "insert into ClassName value(0,?,?) ";
        for (int i = 0; i < 50; i++) {
            Object[] params = {className.getC_Name() + i, "1"};
            boolean isok = this.executeUpdate(sql, params);
        }
        //关资源
        this.closeRes();
    }


    public List<ClassName> getClassList(ClassName className, Page page) {
        //拼接动态sql
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select * from ClassName where 1=1 ");
        //判断是否为空
        if (className != null) {
            //姓名模糊查询 判断是否输入了姓名
            if (className.getC_Name() != null && !"".equals(className.getC_Name())) {
                stringBuffer.append(" and c_Name like '%" + className.getC_Name() + "%'");
            }
            //状态查询
            if (className.getC_Status() > 0 && className.getC_Status() < 3) {
                stringBuffer.append(" and c_Status = " + className.getC_Status());
            }
        }
        //分页语句
        //(当前页数-1)*每页显示的条数
        stringBuffer.append(" limit "/* + page.getStart() + "," + page.getPageSize()*/);
        ResultSet resultSet = this.executeQuery(stringBuffer.toString());

        List<ClassName> list = new ArrayList();
 //       stringBuffer = new StringBuffer();
        stringBuffer.delete(0,stringBuffer.length());
        try {
            while (resultSet.next()) {
                //查询结果封装为User对象
                className = new ClassName(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
                list.add(className);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            this.closeRes();
        }
        return list;
    }

    public int getClassCount(ClassName className) {
        //动态sql
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select count(id) from ClassName where 1=1");
        //姓名模糊查询
        if (className != null) {
            if (className.getC_Name() != null && !"".equals(className.getC_Name())) {
                stringBuffer.append(" and c_Name like '%" + className.getC_Name() + "%'");
            }
        }
        //状态查询
        if (className.getC_Status() > 0 && className.getC_Status() < 3) {
            stringBuffer.append(" and c_Status = " + className.getC_Status());
        }
        //执行
        ResultSet resultSet = this.executeQuery(stringBuffer.toString());
        stringBuffer.delete(0,stringBuffer.length());
        try {
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            this.closeRes();
        }
        return 2;
    }

    //根据ID查询对应的班级
    public ClassName getClassById(int id) {
        String sql = "select * from ClassName where id = ?";
        Object[] params = {id};
        ResultSet resultSet = this.executeQuery(sql, params);
        try {
            if (resultSet.next()) {
                //查询结果封装使用User对象接收
                className = new ClassName(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
                return className;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            //关闭资源
        } finally {
            this.closeRes();
        }
        return className;
    }

    //班级修改
    public boolean updateClassById(ClassName className) {
        String sql = "update ClassName set c_Name=?, c_Status=? where id = ?";
        Object[] params = {className.getC_Name(), className.getC_Status(), className.getId()};
        boolean isok = this.executeUpdate(sql, params);
        this.closeRes();
        return isok;
    }

    public List<ClassName> getStatusClassList(ClassName className, Page page) {
        //拼接动态sql
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select * from ClassName  where c_Status=2 ");
        //分页语句
        //(当前页数-1)*每页显示的条数
        stringBuffer.append(" limit " /*+ page.getStart() + "," + page.getPageSize()*/);
        ResultSet resultSet = this.executeQuery(stringBuffer.toString());
        List<ClassName> list = new ArrayList();
        try {
            while (resultSet.next()) {
                //查询结果封装为User对象
                className = new ClassName(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
                list.add(className);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            this.closeRes();
        }
        return list;
    }


    // 添加新的班级类型
    public Boolean ClassFormAdd(String classForm) {
        //1准备sql
        String sql = "insert into ClassDemo value(0,?) ";
        //准备sql对应参数
        Object[] params = {classForm};
        //执行sql语句
        boolean isok = this.executeUpdate(sql, params);
        //关资源
        this.closeRes();
        return isok;
    }

    //根据ID删除班级类型
    public boolean deleteClassById(int id) {
        String sql = "delete from ClassDemo where id = ?";
        Object[] params = {id};
        boolean isok = this.executeUpdate(sql, params);
        //关闭资源
        this.closeRes();
        return isok;
    }

    //根据ID查询班级类型
    public List<ClassDemo> getByidClassForm(ClassDemo classDemo, Page page) {
        //拼接动态sql
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select * from ClassDemo where 1=1 ");
        //分页语句
        //(当前页数-1)*每页显示的条数
        stringBuffer.append(" limit " /*+ page.getStart() + "," + page.getPageSize()*/);
        ResultSet resultSet = this.executeQuery(stringBuffer.toString());
        List<ClassDemo> list = new ArrayList();
        try {
            while (resultSet.next()) {
                //查询结果封装为User对象
                ClassDemo classDemo1 = new ClassDemo(resultSet.getInt(1),resultSet.getString(2));
                list.add(classDemo1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            this.closeRes();
        }
        return list;
    }
}
