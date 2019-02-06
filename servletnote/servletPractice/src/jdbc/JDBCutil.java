package jdbc;

import java.io.IOException;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class JDBCutil {

	static String driverclass = null;
	static String url = null;
	static String name = null;
	static String password = null;
	static String path = null;

	public JDBCutil() {
	}

	static {
		Properties pro = new Properties();
		try {
			InputStream in = JDBCutil.class.getClassLoader().getResource("../../source/jdbc.properties").openStream();
			pro.load(in);
		 driverclass = pro.getProperty("driverclass");
		 url = pro.getProperty("url");
		 name = pro.getProperty("name");
		 password = pro.getProperty("password");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * ��ȡ���ݿ������
	 * 
	 * @return
	 */
	public static Connection getConn() {

		try {		
			// ע������
			Class.forName(driverclass);
			// ��ȡ���ݿ�����
			Connection connection = DriverManager.getConnection(url, name, password);
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
