package com.zyq.dao;

import com.zyq.bean.Menu;
import com.zyq.bean.Page;
import com.zyq.bean.RootDemo;
import com.zyq.bean.UserDemo;
import com.zyq.util.JdbcUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理员的Dao层
 */
public class RootDao extends JdbcUtil {
    RootDemo rootDemo = new RootDemo();


    //添加管理员功能
    public boolean addRoot(RootDemo rootDemo) {
        //1准备sql
        String sql = "insert into RootDemo value(0,?,?,?,?) ";
        //准备sql对应参数
        Object[] params = {rootDemo.getR_loginName(), rootDemo.getR_PassWord(),
                rootDemo.getR_Name(), "2"};
        //执行sql语句
        boolean isok = this.executeUpdate(sql, params);
        //关资源
        this.closeRes();
        return isok;
    }

    //登录查询功能
    public RootDemo getRootByLoginNameAndPassword(String loginName, String password) {
        //sql查询操作
        String sql = "select  *  from RootDemo where r_loginName=? and r_PassWord=?";
        //sql对应参数
        Object[] params = {loginName, password};
        //sql语句
        ResultSet resultSet = this.executeQuery(sql, params);
        try {
            if (resultSet.next()) {
                rootDemo = new RootDemo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)
                        , resultSet.getInt(5));
                return rootDemo;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            //关闭资源
            this.closeRes();
        }
        return rootDemo;
    }

    //查询功能 查询管理员所有信息
    public List<RootDemo> getRootList(RootDemo rootDemo) {
        //sql
        String sql = "select * from RootDemo  ";
        //执行sql语句
        ResultSet resultSet = this.executeQuery(sql);
        List<RootDemo> list = new ArrayList();
        try {
            while (resultSet.next()) {
                //查询结果封装为User对象
                rootDemo = new RootDemo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5));
                list.add(rootDemo);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            this.closeRes();
        }
        return list;
    }

    //根据ID查询要删除的用户
    public boolean deleteRootById(int id) {
        String sql = "delete from RootDemo where id = ?";
        Object[] params = {id};
        boolean isok = this.executeUpdate(sql, params);
        //关闭资源
        this.closeRes();
        return isok;
    }

    public UserDemo getUserById(int id) {
        String sql = "select * from UserDemo where id = ?";
        Object[] params = {id};
        ResultSet resultSet = this.executeQuery(sql, params);
        try {
            if (resultSet.next()) {
                //查询结果封装使用User对象接收
                UserDemo user = new UserDemo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)
                        , resultSet.getInt(5), resultSet.getString(6), resultSet.getInt(7));
                return user;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            //关闭资源
        } finally {
            this.closeRes();

        }
        return null;
    }

    //根据编号去修改用户的信息
    public boolean updateUserById(UserDemo user) {
        String sql = "update UserDemo set u_name=?,u_address=?,u_age=?,u_sex=? where id = ?";
        Object[] params = {user.getU_name(), user.getU_class(), user.getU_classnumb(), user.getU_sex(), user.getId()};
        boolean isok = this.executeUpdate(sql, params);
        this.closeRes();
        return isok;
    }

    //禁用及启用功能
    public boolean updateStatus(String userId, String status) {
        String sql = "update UserDemo set u_status = ?  where id = ?";
        Object[] parms = {status, userId};
        //
        boolean isok = this.executeUpdate(sql, parms);
        //
        this.closeRes();
        //
        return isok;
    }

    //统计数据库用户表共有多少条数据
    public int getUserCount(UserDemo userDemo) {
        //动态sql
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select count(id) from UserDemo where 1=1");
        //姓名模糊查询
        if (userDemo != null) {
            if (userDemo.getU_name() != null && !"".equals(userDemo.getU_name())) {
                stringBuffer.append(" and u_name like '%" + userDemo.getU_name() + "%'");
            }
            //性别条件查询
            if (userDemo.getU_sex() > 0 && userDemo.getU_sex() < 4) {
                stringBuffer.append(" and u_sex = " + userDemo.getU_sex());
            }
            //班级名称查询 判断是否选择了班级名称
            if (userDemo.getU_class() != null && !"".equals(userDemo.getU_class())) {
                //   stringBuffer.append(" and u_class = " + userDemo.getU_class());
                stringBuffer.append(" and u_class =  '" + userDemo.getU_class() + "'");
            }
            //班级模糊查询 判断是否选择了班级编号
            if (userDemo.getU_classnumb() != null && !"".equals(userDemo.getU_classnumb())) {
                stringBuffer.append(" and u_ClassNumb like '%" + userDemo.getU_classnumb() + "%'");
                //    stringBuffer.append(" and u_ClassNumb like '%C1%'");
            }
        }
        //
        ResultSet resultSet = this.executeQuery(stringBuffer.toString());


        try {
            while (resultSet.next()) {
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

    //缓存查询全表
    public List<UserDemo> getUserDemoList() {
        String sql = "select * from UserDemo";
        ResultSet resultSet = this.executeQuery(sql);
        List<UserDemo> userDemoList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                UserDemo userDemo = new UserDemo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)
                        , resultSet.getInt(5), resultSet.getString(6), resultSet.getInt(7));
                userDemoList.add(userDemo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeRes();
        }
        return userDemoList;
    }

    //自动添加数据库用于测试操作
    public void SeAdd() {
        //   String sql = "insert into UserDemo value(0,'阿呆','zyq','123','成都','20',3,'Start') ";
        //1准备sql
        String sql = "insert into UserDemo value(0,?,?,?,?,?,?,Start) ";
        //准备sql对应参数
        Object[] params = {"阿呆", "zyq",
                "123", "成都", "20", 3};
        //执行sql语句
        boolean isok = this.executeUpdate(sql, params);
        //关资源
        this.closeRes();
    }

    //根据编号查表单
    public List<Menu> getMenuList(String releId) {
        String sql = "select m.* from post_menu pm inner join  menu m on pm.u_PostId = m.id where pm.m_FirstId=?";
        Object[] objects = {releId};
        ResultSet resultSet = this.executeQuery(sql, objects);
        List<Menu> menuList = new ArrayList();
        try {
            while (resultSet.next()) {
                Menu menu = new Menu(resultSet.getInt(1)
                        , resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
                menuList.add(menu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeRes();
        }
        return menuList;
    }

    public boolean NewPassWord(RootDemo rootDemo, String password) {
        String sql = "update RootDemo set r_password=? where id=?";
        Object[] objects = {password, rootDemo.getId()};
        //执行sql
        Boolean isok = this.executeUpdate(sql, objects);
        this.closeRes();
        return isok;
    }
}