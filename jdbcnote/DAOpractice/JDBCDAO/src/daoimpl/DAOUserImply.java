package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import daouser.DAOUser;
import jdbcutils.JDBCclose;
/**
 * 定义的DAO实现类
 *
 */
public class DAOUserImply implements DAOUser {

	@Override
	public List<User> testQuery() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<User>  list = new ArrayList<>();
		try {
			conn = JDBCclose.getConn();
			st = conn.createStatement();
			String sql = "SELECT * FROM t_user";
			rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				int age = rs.getInt("age");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				User u = new User(id, username, password, age, address, phone);
				list.add(u);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCclose.release(conn, rs, st);
		}
		return null;
	}

	@Override
	public User testLogin(String username, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCclose.getConn();
			String sql = "SELECT * FROM t_user "
					+ "WHERE username = ? AND PASSWORD = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("id");
				int age = rs.getInt("age");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				User u = new User(id, username, password, age, address, phone);
				return u;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCclose.release(conn, rs, ps);
		}

		return null;
	}

	@Override
	public int doInsert(String name, String password,int age,String address,String phone) {
		Connection conn = null;
		PreparedStatement ps = null ;
		try {
			 conn = JDBCclose.getConn();
		    String sql = "insert into t_user values(null,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setInt(3, age);
			ps.setString(4, address);
			ps.setString(5, phone);
			int result = ps.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCclose.release(conn, ps);
		}
		return 0;
	}

	@Override
	public int doDelete(String name) {
		Connection conn = null;
		PreparedStatement ps = null ;
		try {
			 conn = JDBCclose.getConn();
		    String sql = "delete from t_user where username = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			int result = ps.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCclose.release(conn, ps);
		}
		return 0;
	}

	@Override
	public int doUpdate(int id, String name) {
		Connection conn = null;
		PreparedStatement ps = null ;
		try {
			 conn = JDBCclose.getConn();
		    String sql = "update t_user set username = ? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, id);
			int result = ps.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCclose.release(conn, ps);
		}
		return 0;
		
	}

}
