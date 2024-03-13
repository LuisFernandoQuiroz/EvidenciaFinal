package Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;

@WebServlet(name="conectorDB", urlPatterns={"/conectorDB"})

public class conectorDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected String url = "jdbc:mysql://localhost:3306/base";
	protected String username = "root";
	protected String password = "mysqlpassword";
	
	protected void databaseProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=ISO-8859-1");
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connect = DriverManager.getConnection(url,username,password);
			PreparedStatement prep;
			ResultSet res;
			
			prep = connect.prepareStatement("SELECT userinfo.username, userinfo.nombre, userinfo.edad, userinfo.sexo, userinfo.estatura, userinfo.peso, userinfo.imc, userinfo.fecha FROM userinfo INNER JOIN users ON users.username = userinfo.username WHERE users.username = ? AND users.password = ?;");
			prep.setString(1, user);
			prep.setString(2, pass);
			
			res = prep.executeQuery();
			
			if(res.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("usuario", user);
				Models.users u = new Models.users(user);
				
				request.setAttribute("CurrentUser", u);
		        request.getRequestDispatcher("/inputNew.jsp").forward(request,response);
			} else {
				response.sendRedirect("inputError.jsp");
			}
			
		} catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		databaseProcess(request, response);
	}

}
