package com.zyq.service;


import com.alibaba.fastjson.JSONObject;
import com.zyq.bean.Menu;
import com.zyq.bean.Page;
import com.zyq.bean.UserDemo;
import com.zyq.dao.UserDao;
import com.zyq.mapper.UserDemoMapper;
import com.zyq.util.MybatisUtis;
import com.zyq.util.RedisUtil;
import org.apache.ibatis.session.SqlSession;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * 业务层 接受业务控制Dao层执行业务
 */
public class UserService {

    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    //登录功能 方法是根据用户的账号密码实现查询Dao层查询登录的方法
   /* public UserDemo login(String loginName, String password) {
        String jsonString = null;
        //
        Jedis connection = RedisUtil.getConnection();
        String userdemolist = connection.get("cacheShopList");
        List<UserDemo> userDemoList = JSONObject.parseArray(userdemolist, UserDemo.class);
        UserDemo userDemo = new UserDemo();
        if (userDemoList == null || userDemoList.size() <= 0) {
            System.out.println("从Mysql中获取数据");
            List<UserDemo> userDemoList1 = userDao.getUserByLoginNameAndPassword(loginName, password);
            jsonString = JSONObject.toJSONString(userDemoList1);
            connection.set("cacheShopList", jsonString);
            //集合遍历到对象
            for (UserDemo userDemo1 : userDemoList1) {
                //传入数据便于返回
                userDemo.setId(userDemo1.getId());
                userDemo.setU_name(userDemo1.getU_name());
                userDemo.setU_loginName(userDemo1.getU_loginName());
                userDemo.setU_password(userDemo1.getU_password());
                userDemo.setU_address(userDemo1.getU_address());
                userDemo.setU_age(userDemo1.getU_age());
                userDemo.setU_sex(userDemo1.getU_sex());
                userDemo.setU_status(userDemo1.getU_status());
                userDemo.setU_roleid(userDemo1.getU_roleid());
            }
            connection.close();
            return userDemo;
        }
        System.out.println("从Redis中获取");
        //传入数据便于返回
        for (UserDemo userDemo1 : userDemoList) {
            //传入数据便于返回
            userDemo.setId(userDemo1.getId());
            userDemo.setU_name(userDemo1.getU_name());
            userDemo.setU_loginName(userDemo1.getU_loginName());
            userDemo.setU_password(userDemo1.getU_password());
            userDemo.setU_address(userDemo1.getU_address());
            userDemo.setU_age(userDemo1.getU_age());
            userDemo.setU_sex(userDemo1.getU_sex());
            userDemo.setU_status(userDemo1.getU_status());
            userDemo.setU_roleid(userDemo1.getU_roleid());
        }
        connection.close();
        return userDemo;
    }*/


    //测试添加功能
    public boolean save(UserDemo userDemo) {
        return userDao.save(userDemo);
    }

    //登录功能
    public UserDemo login(String loginName, String password) {
        UserDemo userDemo = (UserDemo) userDao.getUserByLoginNameAndPassword(loginName, password);
        return userDemo;
    }


    //查询用户功能 登录之后进行查询方便传入信息到Home页面
    public List<UserDemo> getUserList(String userName, String userSex, String className, String classNumb) {
        return userDao.userDemoList(userName,userSex,className,classNumb);
    }

    //删除功能 根据用户点击获取ID删除对应的用户信息
    public boolean dropUserById(String id) {
        if (null != id && !"".equals(id)) {
            /*return userDao.deleteUserById(Integer.parseInt(id));*/
            return userDao.Delete(Integer.parseInt(id));
        }
        return false;
    }

    //ID查询功能？ 查总数
    public int getUserCount(String userName, String userSex, String className, String classNumb) {
        UserDemo userDemo = new UserDemo();
        if (userName != null && !"".equals(userName)) {
            userDemo.setU_name(userName);
        }
        if (userSex != null && !"".equals(userSex)) {
            int sex = Integer.parseInt(userSex);
            if (sex > -1 && sex < 4) {
                userDemo.setU_sex(sex);
            } else {
                userDemo.setU_sex(-1);
            }
        }

        if (className != null && !"".equals(className)) {
            userDemo.setU_class(className);
        }
        if (classNumb != null && !"".equals(classNumb)) {
            userDemo.setU_classnumb(classNumb);
        }
        return userDao.getUserCount(userDemo);
    }

    //缓存redis
    public List<UserDemo> getUserDemoList() {
        RedisUtil redisUtil = new RedisUtil();
        Jedis connection = redisUtil.getConnection();
        //json 字符串
        String shopList = connection.get("cacheShopList");
        System.out.println("ShopList" + shopList);
        List<UserDemo> shopList1 = JSONObject.parseArray(shopList, UserDemo.class);
        //缓存中无数据的情况
        if (shopList1 == null || shopList1.size() <= 0) {
            UserDao userDao = new UserDao();
            System.out.println("数据库中查询数据");
            //mysql数据库中获取数据到redis数据库
            List<UserDemo> userDemoList = userDao.getUserDemoList();
            System.out.println(userDemoList + "--------------------");
            String jsonString = JSONObject.toJSONString(userDemoList);
            //查询出的数据 存储到redis数据库中
            connection.set("cacheShopList", jsonString);
            System.out.println("jsonString" + jsonString);
            connection.close();
            return userDemoList;
        }
        System.out.println("从Redis中获取");
        connection.close();
        return shopList1;
    }

    //菜单信息
    public List<Menu> menu(UserDemo userDemo) {
        List<Menu> menuList = userDao.getMenuList(userDemo.getU_roleid() + "");
        return menuList;
    }

    //根据用户点击的ID查询
    public UserDemo getUserById(String id) {
        if (id != null && !"".equals(id)) {
            return userDao.getUserById(Integer.parseInt(id));
        }
        return null;
    }

    //修改功能
    public boolean updateUser(UserDemo userDemo) {
        /*return userDao.updateUserById(userDemo);*/
        return userDao.update(userDemo);
    }

    //密码修改
    public Boolean NewPassWord(UserDemo userDemo, String password) {
        boolean isok = userDao.NewPassWord(userDemo, password);
        return isok;
    }

    //添加功能
    public boolean AddUser(UserDemo userDemo) {
        //调用方法
        boolean isok = userDao.addUser(userDemo);

        return isok;
    }

    //根据ID查询
    public UserDemo IDQuery(String ID) {
        UserDemo userDemo = userDao.IDQuery(ID);

        return userDemo;

    }

    public boolean UserByIdSDele(Object[] objects) {
        return userDao.UserByIdSDele(objects);
    }

    public boolean DownOver(UserDemo userDemo) {

        return userDao.DownOver(userDemo);
    }

    /**
     * 查询所用学生信息的方法
     *
     * @return 返回集合保存学生信息
     */
    public List<UserDemo> queryStudent() {
        return userDao.queryStudent();
    }
}
