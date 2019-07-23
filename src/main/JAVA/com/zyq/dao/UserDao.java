package com.zyq.dao;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.zyq.bean.Menu;
import com.zyq.bean.Page;
import com.zyq.bean.UserDemo;
import com.zyq.mapper.UserDemoMapper;
import com.zyq.util.JdbcUtil;
import com.zyq.util.MybatisUtis;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;

import javax.xml.stream.events.StartDocument;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据访问层
 */
public class UserDao extends JdbcUtil {

    /**
     * 学生信息查询功能
     *
     * @return 返回学生信息的集合
     */
    public List<UserDemo> queryStudent() {
        SqlSession session = MybatisUtis.getSqlSession();
        UserDemoMapper userDemoMapper = session.getMapper(UserDemoMapper.class);
        /*执行方法*/
        List<UserDemo> userDemoList = userDemoMapper.queryStudent();
        /*返回集合*/
        return userDemoList;
    }


    //Mybatis添加功能
    public boolean save(UserDemo userDemo) {
        SqlSession session = MybatisUtis.getSqlSession();
        //执行方法
        UserDemoMapper userDemoMapper = session.getMapper(UserDemoMapper.class);
        int insert = userDemoMapper.save(userDemo);
        //提交
        session.commit();
        //关闭
        session.close();
        if (insert > 0) {
            return true;
        }
        return false;
    }

    //Mybatis修改功能
    public boolean update(UserDemo userDemo) {
        SqlSession session = MybatisUtis.getSqlSession();
        //执行方法
        UserDemoMapper userDemoMapper = session.getMapper(UserDemoMapper.class);
        int insert = userDemoMapper.update(userDemo);
        //提交
        session.commit();
        //关闭
        session.close();
        if (insert > 0) {
            return true;
        }
        return false;
    }

    //Mybatis 删除功能
    public boolean Delete(int id) {
        SqlSession session = MybatisUtis.getSqlSession();
        //执行方法
        UserDemoMapper userDemoMapper = session.getMapper(UserDemoMapper.class);
        int insert = userDemoMapper.delete(id);
        //提交
        session.close();
        if (insert > 0) {
            return true;
        }
        return false;
    }


    //添加功能
    public boolean addUser(UserDemo user) {
        //1准备sql
        String sql = "insert into UserDemo value(0,?,?,?,?,?,?) ";
        //准备sql对应参数
        Object[] params = {user.getU_name(),
                user.getU_class(), user.getU_classnumb(), user.getU_sex(), user.getU_status(), user.getU_roleid()};
        //执行sql语句
        boolean isok = this.executeUpdate(sql, params);
        //关资源
        this.closeRes();
        return isok;
    }

    //登录查询功能
    public UserDemo getUserByLoginNameAndPassword(String loginName, String password) {
        //sql查询操作
        String sql = "select  *   from UserDemo where u_loginName=? and u_password=?";
        //sql对应参数
        Object[] params = {loginName, password};
        //sql语句
        ResultSet resultSet = this.executeQuery(sql, params);
        try {
            while (resultSet.next()) {
                UserDemo userDemo = new UserDemo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)
                        , resultSet.getInt(5), resultSet.getString(6), resultSet.getInt(7));
                return userDemo;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            //关闭资源
            this.closeRes();
        }
        return null;
    }

    /**
     * 模糊查询 mybatis
     *
     * @param userName  学生名册
     * @param userSex   学生性别
     * @param className 班级名称
     * @param classNumb 班级编号
     * @return 返回集合
     */
    public List<UserDemo> userDemoList(String userName, String userSex, String className, String classNumb) {
        SqlSession session = MybatisUtis.getSqlSession();
        UserDemoMapper userDemoMapper = session.getMapper(UserDemoMapper.class);
        //实例化对象
        UserDemo userDemo = new UserDemo();
        //确认验证参数并确认是否为空
        if (userSex == null || userSex.equals("-10")) {
            //传入对象
            userDemo.setU_sex(-1);
        } else {
            userDemo.setU_sex(Integer.parseInt(userSex));
        }
        userDemo.setU_name(userName);
        userDemo.setU_class(className);
        userDemo.setU_classnumb(classNumb);
        /*执行方法*/
        return userDemoMapper.queryStudentS(userDemo);
    }


    //查询功能 查询用户的所有信息 登录之后的查询  包含模糊查询
    public List<UserDemo> getUserList(UserDemo u) {
        //拼接动态sql
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select * from UserDemo where 1=1 ");
        //判断是否为空
        if (u != null) {
            //姓名模糊查询 判断是否输入了姓名
            if (u.getU_name() != null && !"".equals(u.getU_name())) {
                stringBuffer.append(" and u_name like '%" + u.getU_name() + "%'");
            }
            //性别条件查询 判断查询时是否选择了性别
            if (u.getU_sex() > 0 && u.getU_sex() < 4) {
                stringBuffer.append(" and u_sex = " + u.getU_sex());
            }
            //班级名称查询 判断是否选择了班级名称
            if (u.getU_class() != null && !"".equals(u.getU_class())) {
                stringBuffer.append(" and u_class =  '" + u.getU_class() + "'");
            }
            //班级编号查询 判断是否选择了班级编号
            if (u.getU_classnumb() != null && !"".equals(u.getU_classnumb())) {
                stringBuffer.append(" and u_ClassNumb like '%" + u.getU_classnumb() + "%'");
            }
        }
        //分页语句
        //(当前页数-1)*每页显示的条数
        stringBuffer.append(" limit "/* + page.getStart() + "," + page.getPageSize()*/);
        ResultSet resultSet = this.executeQuery(stringBuffer.toString());
        List<UserDemo> list = new ArrayList();
        try {
            while (resultSet.next()) {
                //查询结果封装为User对象
                UserDemo userDemo = new UserDemo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)
                        , resultSet.getInt(5), resultSet.getString(6), resultSet.getInt(7));
                list.add(userDemo);
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
    public boolean deleteUserById(int id) {
        String sql = "delete from UserDemo where id = ?";
        Object[] params = {id};
        boolean isok = this.executeUpdate(sql, params);
        //关闭资源
        this.closeRes();
        return isok;
    }

    public UserDemo getUserById(int id) {
        UserDemo userDemo = new UserDemo();
        String sql = "select * from UserDemo where id = ?";
        Object[] params = {id};
        ResultSet resultSet = this.executeQuery(sql, params);
        try {
            if (resultSet.next()) {
                //查询结果封装使用User对象接收
                userDemo = new UserDemo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)
                        , resultSet.getInt(5), resultSet.getString(6), resultSet.getInt(7));
                return userDemo;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            //关闭资源
        } finally {
            this.closeRes();

        }
        return userDemo;
    }

    //根据编号去修改用户的信息
    public boolean updateUserById(UserDemo user) {
        String sql = "update UserDemo set u_name=?,u_class=?,u_ClassNumb=?,u_sex=? where id = ?";
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
            if (userDemo.getU_sex() > 0 && userDemo.getU_sex() < 5 || userDemo.getU_sex() == 3) {
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
        releId = "1";
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

    public boolean NewPassWord(UserDemo userDemo, String password) {
        String sql = "update UserDemo set u_password=? where id=?";
        Object[] objects = {password, userDemo.getId()};
        //执行sql
        Boolean isok = this.executeUpdate(sql, objects);
        this.closeRes();
        return isok;
    }

    //根据ID查询用户信息
    public UserDemo IDQuery(String ID) {
        UserDemo userDemo = new UserDemo();
        String sql = "select * from UserDemo where id=?";
        Object[] objects = {ID};
        //执行SQL
        ResultSet resultSet = this.executeQuery(sql, objects);
        try {
            while (resultSet.next()) {
                //添加对象到UserDemo
                userDemo = new UserDemo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)
                        , resultSet.getInt(5), resultSet.getString(6), resultSet.getInt(7));
                return userDemo;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userDemo;
    }

    //根据传入的众多编号删除用户
    public boolean UserByIdSDele(Object[] objects) {
        String sql = "delete from UserDemo where id = ?";
        for (int i = 0; i < objects.length; i++) {
            Object[] objects1 = {objects[i]};
            this.executeUpdate(sql, objects1);
        }
        return true;
    }

    public boolean DownOver(UserDemo userDemo) {
        String sql = "update UserDemo set u_class=?,u_ClassNumb=? where id = ?";
        Object[] params = {userDemo.getU_class(), userDemo.getU_classnumb(), userDemo.getId()};
        boolean isok = this.executeUpdate(sql, params);
        this.closeRes();
        return isok;
    }


}