package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Download")
public class Download extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String name = request.getParameter("filename");
	   String path = getServletContext().getRealPath("/download/"+name);
	   InputStream in = new FileInputStream(path);
	   OutputStream out = response.getOutputStream();
	   int len = 0;
	   byte[] buff = new byte[1024];
	   while((len = in.read(buff)) != -1) {
		   out.write(buff, 0, len);
	   }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
