package cn.mldn.dbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;
  
public class TestCRUD { 

	@Test
   public void testQuery() {
	   
	  Connection conn = null ;
	  Statement st = null;
	  ResultSet eq = null ;
	   try { 
		    conn = JDBCclose.getConn();
		    st = conn.createStatement();
		    String sql = "SELECT * FROM s_tu";
		    eq = st.executeQuery(sql);
		while(eq.next()) {
		    int id = eq.getInt("id");
		    String name = eq.getString("name");
		    int age = eq.getInt("age");
		    System.out.println("id = "+id+" name"+name+" age = "+age);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		JDBCclose.release(conn, eq, st);
	}
   }
	@Test
	public void testInsert() {
		Connection conn = null ;
		Statement st = null ;
		
		try {
			conn = JDBCclose.getConn();
			st = conn.createStatement();
			String sql = "INSERT INTO s_tu(name,age) VALUES ('xiaoli',34)";
			int result = st.executeUpdate(sql);
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCclose.release(conn, st);
		}
		
	}
	@Test
	public void testDelete() {
		Connection conn = null ;
		Statement st = null ;
		try {
			conn = JDBCclose.getConn();
			st = conn.createStatement();
			String sql = "DELETE FROM s_tu WHERE age = 19";
			int result = st.executeUpdate(sql);
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCclose.release(conn, st);
		}	
	}
	@Test
	public void testUpdate() {
		Connection conn = null ;
		Statement st = null ;
		try {
			conn = JDBCclose.getConn();
			st = conn.createStatement();
			String sql = "Update s_tu SET age = 29 WHERE name = 'jinjin'";
			int result = st.executeUpdate(sql);
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCclose.release(conn, st);
		}	
	}
}
