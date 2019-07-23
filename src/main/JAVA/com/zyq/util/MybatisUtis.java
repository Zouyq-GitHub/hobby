package com.zyq.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * 封装Mybatis框架配置
 *
 * @author 邹雨樵
 * @date  2019/6/3
 * @since 1.0.0
 */
public class MybatisUtis {

    private static SqlSessionFactory factory = null;
    static {
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession(){
        return factory.openSession(true);
    }
}