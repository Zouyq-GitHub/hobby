package com.zyq.service;

import com.zyq.bean.RootDemo;
import com.zyq.dao.RootDao;

import java.util.List;

/**
 * RootDemo的业务层
 */
public class RootService {
    //导入dao
    private RootDao rootDao = new RootDao();
    private RootDemo rootDemo = new RootDemo();


    //注册功能
    //注册功能  调用Dao添加方法将数据添加到数据库
    public boolean regRoot(RootDemo rootDemo) {
        boolean isok = rootDao.addRoot(rootDemo);
        return isok;
    }

    //查询功能 查询所有管理员
    public List<RootDemo> getRootList(){

        return rootDao.getRootList(rootDemo);
    }

    //删除功能
    public boolean deleteRootById(String  id){
        if (null != id && !"".equals(id)) {
            return rootDao.deleteRootById(Integer.parseInt(id));
        }
        return false;
    }
    //登录功能
    public RootDemo login(String loginName, String password) {
       rootDemo =  rootDao.getRootByLoginNameAndPassword(loginName, password);
        return rootDemo;
    }

    public boolean NewPassWord(RootDemo rootDemo, String password) {
        boolean isok = rootDao.NewPassWord(rootDemo, password);
        return isok;
    }
}
