package Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet(name="inputNewDB", urlPatterns={"/inputNewDB"})

public class inputNewDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected String url = "jdbc:mysql://localhost:3306/base";
	protected String username = "root";
	protected String password = "mysqlpassword";
    
	protected void newInputProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=ISO-8859-1");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(url,username,password);
			HttpSession session = request.getSession();
			
			String user = session.getAttribute("usuario").toString();;
			Float h = Float.valueOf(request.getParameter("h1"));
			Float w = Float.valueOf(request.getParameter("w1"));
			Float i;
			String d;
			
			if (h < 1 || h > 2.5) {
				response.sendRedirect("inputError.jsp");;
			} else 
			if (w <= 0) {
				response.sendRedirect("inputError.jsp");;
			} else {
				Models.users idc = new Models.users(user);
				idc.setI(h,w);
				i = idc.getI();
				idc.setD();
				d = idc.getD();
			
				PreparedStatement prep = connect.prepareStatement("INSERT INTO userinfo (username, estatura, peso, imc, fecha) VALUES (?,?,?,?,?);");
				prep.setString(1, user);
				prep.setFloat(2, h);
				prep.setFloat(3, w);
				prep.setFloat(4, i);
				prep.setString(5, d);
				prep.executeUpdate();
			
				request.getRequestDispatcher("/loggedIn.jsp").forward(request,response);
			}
			
			
			
		} catch(Exception e){
			System.out.println(e);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		newInputProcess(request, response);
	}

}
