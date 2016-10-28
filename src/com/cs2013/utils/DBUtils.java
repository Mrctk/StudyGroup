package com.cs2013.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.PreparedStatement;

/**
 * 数据库相关的工具类
 *
 */
public class DBUtils {

	private static DBUtils dbUtils=null;//单列模式
	
	private static Properties prop;// 用户数据库加载配置文件
	private static String DRIVER;// 驱动
	private static String URL;// 数据库URL
	private static String USERNAME;// 数据库用户名
	private static String PASSWORD;// 数据库密码

	/**
	 * 加载db.properties中的数据库配置信息
	 */
	static {
		try {
			prop = new Properties();
			InputStream in = new FileInputStream(
					DBUtils.class.getClassLoader()
					.getResource("db.properties")
					.getPath()
					);
			prop.load(in);
			DRIVER=prop.getProperty("jdbc.driver");
			URL=prop.getProperty("jdbc.url");
			USERNAME=prop.getProperty("jdbc.username");
			PASSWORD=prop.getProperty("jdbc.password");
		} catch (IOException e) {
		}
	}
	private DBUtils(){}
	/**
	 * 单例提供创建接口
	 * @return
	 */
	public static DBUtils getInsatnce() {
		if (dbUtils==null) {
			dbUtils=new DBUtils();
		}
		return dbUtils;
	}
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public Connection getConnection(){
		try {
			Class.forName(DRIVER);
			Connection conn= DriverManager.getConnection(URL, USERNAME, PASSWORD);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 释放资源
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public void release(Connection conn,PreparedStatement ps,ResultSet rs){
		releaseConnection(conn);
		releasePreparedStatement(ps);
		releaseResultSet(rs);
	}
	/**
	 * 释放资源
	 * @param conn
	 * @param ps
	 */
	public void release(Connection conn,PreparedStatement ps){
		releaseConnection(conn);
		releasePreparedStatement(ps);
	}
	/**
	 * 释放Connection
	 */
	private void releaseConnection(Connection conn){
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				conn=null;
			}
		}
	}
	/**
	 * 释放PreparedStatement
	 * @param ps
	 */
	private void releasePreparedStatement(PreparedStatement ps){
		if (ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				ps=null;
			}
		}
	}
	/**
	 * 释放ResultSet
	 * @param rs
	 */
	private void releaseResultSet(ResultSet rs){
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				rs=null;
			}
		}
	}
	
}
