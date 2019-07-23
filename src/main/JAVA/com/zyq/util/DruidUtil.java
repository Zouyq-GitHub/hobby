package com.zyq.util;
/**
 * 连接池配置工具类
 */

import com.alibaba.druid.pool.DruidDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class DruidUtil {

	private static DruidDataSource dataSource;
	
	static {  //单例模式：让某一个对象在项目中只创建一次
		dataSource=new DruidDataSource();
		//
		Properties properties=new Properties();
		//
		InputStream inputStream= DruidUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
		//
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("加载配置文件错误");
		}
		//将配置文件中的信息  添加到连接池中
		dataSource.setDriverClassName(properties.getProperty("driver"));
		dataSource.setUsername(properties.getProperty("username"));
		dataSource.setPassword(properties.getProperty("password"));
		dataSource.setUrl(properties.getProperty("url"));

	}

	/**
	 * @return
	 *   从连接池获取链接的方法
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}


}
