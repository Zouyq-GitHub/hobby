package com.zyq.util;

import java.sql.*;

/**
 * 
 * @author admin
 *	JDBC工具类
 */
public class JdbcUtil {
	
	//链接数据库的参数
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	//jdbc 相关类
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	//是否自动提交事务
	private static boolean autoCommit=true;
	
	//获取链接  因为在创建不同的通道时都会使用到该Connection对象 因此写成方法
	private void getConnection() {
		try {
			connection= DruidUtil.getConnection();
			connection.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("获取链接失败");
		}
	}
	
	//创建普通通道（状态通道） 也要写成方法
	public void getStatement() {
		getConnection();
		  try {
			statement=connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("创建普通通道失败");
		}
	}
	
	//创建预编译通道
	private void  getPrepareStatement(String sql) {
		getConnection();
		//不完整的sql语句
		try {
			preparedStatement=connection.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println("创建预编译通道失败");
			e.printStackTrace();
		}
	}
	
	//预状态通道 执行修改
	public boolean executeUpdate(String sql,Object[] params) {
		//调用创建预编译通道的方法
		getPrepareStatement(sql);
		//给 ？ 绑定参数
		bandle(params);
		//执行修改sql
		try {
			int num=preparedStatement.executeUpdate();
			return num>0?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//预编译通道 执行
	public ResultSet executeQuery(String sql,Object[] params) {
		getPrepareStatement(sql);
		//绑定参数
		bandle(params);
		//执行查询语句
		try {
			return resultSet=preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//绑定参数的
	private void bandle(Object[] params) {
		if(params!=null) {
			try {
				for (int i = 0; i < params.length; i++) {
					if(params[i]!= null &&!"".equals( params[i]) ) {
						preparedStatement.setObject(i+1, params[i]);
					}
				}
			} catch (SQLException e) {
				System.out.println("绑定参数失败");
				e.printStackTrace();
			}
		}
	}
	
	//执行sql语句
	// 1、修改语句  2、查询语句
	public boolean executeUpdate(String sql) {
		getStatement();
		
		try {
			//执行sql 语句
			int num = statement.executeUpdate(sql);
			if(num>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql语句执行失败");
		}
		return false;
	}
	
	//根据状态通道执行查询语句
	public ResultSet executeQuery(String sql) {
		getStatement();
		//执行sql
		try {
			return resultSet=statement.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("执行查询语句失败");
			e.printStackTrace();
		}
		return null;
	}
	
	//关闭资源
	public void closeRes() {
		try {
			if(resultSet!=null) {
				resultSet.close();
			}
			if(statement!=null) {
				statement.close();
			}
			if(preparedStatement!=null) {
				preparedStatement.close();
			}
			if(connection!=null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public JdbcUtil() {}
	
	/**
	 * @param autoCommit  
	 * 手动指定提交事务的方式  
	 * true 为自动
	 * false 为手动
	 */
	public JdbcUtil(boolean autoCommit) {
		this.autoCommit=autoCommit;
	}
	
}
