package cn.mldn.dbc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCclose {
	static String url = null;
	static String name = null;
	static String password = null;
	static String driverclass = null ;
	static {
		Properties  properties = new Properties();
		try {
			properties.load(new FileInputStream("jdbc.properties"));
			//InputStream in = JDBCclose.class.getClassLoader().getResourceAsStream("jdbc.properties");
			//properties.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		name = properties.getProperty("name");
		password = properties.getProperty("password");
		url = properties.getProperty("url");
		driverclass = properties.getProperty("driverclass");
	}
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConn() {
		try {
		
			Class.forName(driverclass);
			Connection conn = DriverManager.getConnection(url,name,password);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
		
		
	}
	/**
	 * 释放资源
	 * @param conn
	 * @param rs
	 * @param st
	 */
	public static void release(Connection conn,ResultSet rs, Statement st) {
		closeConnection(conn);
		closeResultset(rs);
		closeStatement(st);
	}
	public static void release(Connection conn, Statement st) {
		closeConnection(conn);
		closeStatement(st);
	}
	private  static void closeResultset(ResultSet rs) {
		if(rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				rs =  null;
			}
	}
	private static void closeStatement(Statement st) {
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				st = null;
			}
		}
	}
	private static void closeConnection(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				conn = null;
			}
		}
	}
}
