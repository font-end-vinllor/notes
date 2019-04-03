package jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login01")
public class Login01 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		if(doQuery(id,password)) {		
			response.setStatus(302);
			response.setHeader("Location", "download.html");
		}
		else {
			
		
			response.setContentType("text/html;charset=UTF-8");
	        PrintWriter writer = response.getWriter();
			writer.write("Ê§°Ü");
		}
	}
  protected boolean doQuery(String id,String password) {
	  Connection conn = JDBCutil.getConn();	 
	  try { 
		 String sql = "SELECT * FROM login_user WHERE id=?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, id);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
	          if(rs.getString("password").equals(password)) {
	        	 return true ;
	          }
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	  return false ;
  }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
