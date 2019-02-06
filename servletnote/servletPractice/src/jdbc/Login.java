package jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String id = null ;
    private String name = null ;
    private String password = null ;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 id = request.getParameter("id");
		 name = request.getParameter("name");
		 password = request.getParameter("password");
		 
		 System.out.println("id = "+id+" \nname = "+name+" \n password = "+password );
		 if(doInsert() > 0) {
			 response.setStatus(302);
			 response.setHeader("Location", "login1.html");
		 }
		 else {
			 PrintWriter writer = response.getWriter();
			 writer.println("failed");
		 }
	}
 
     protected int doInsert() {
	  Connection conn = JDBCutil.getConn();

	  try {
		 String sql = "INSERT INTO login_user values(?,?,?)";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, id);
		st.setString(2, password);
		st.setString(3, name);
		
		int result = st.executeUpdate();
		
		conn.close();
		return result ; 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return 0;
  }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
