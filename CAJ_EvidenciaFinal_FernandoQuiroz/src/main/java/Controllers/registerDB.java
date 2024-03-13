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
import java.sql.ResultSet;


@WebServlet(name="registerDB", urlPatterns={"/registerDB"})

public class registerDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected String url = "jdbc:mysql://localhost:3306/base";
	protected String username = "root";
	protected String password = "mysqlpassword";
	
	protected void registerProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html; charset=ISO-8859-1");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(url,username,password);
			
			String v1 = request.getParameter("username");
			String v2 = request.getParameter("password");
			String v3 = request.getParameter("name");
			int v4 = Integer.parseInt(request.getParameter("age"));
			String v5 = request.getParameter("sex");
			Float v6 = Float.valueOf(request.getParameter("height"));
			Float v7 = Float.valueOf(request.getParameter("weight"));
			Float v8;
			String v9;
			
			if (v4 < 15) {
				response.sendRedirect("inputError.jsp");;
			} else
			if (v6 < 1 || v6 > 2.5) {
				response.sendRedirect("inputError.jsp");;
			} else
			if (v7 <= 0) {
				response.sendRedirect("inputError.jsp");;
			} else{
				Models.users idc = new Models.users(v1);
				idc.setI(v6,v7);
				v8 = idc.getI();
				idc.setD();
				v9 = idc.getD();
				
				
				PreparedStatement prep = connect.prepareStatement("INSERT INTO users (username, password) VALUES (?,?);");
				prep.setString(1, v1);
				prep.setString(2, v2);
				prep.executeUpdate();
			
				prep = connect.prepareStatement("INSERT INTO userinfo (username, nombre, edad, sexo, estatura, peso, imc, fecha) VALUES (?,?,?,?,?,?,?,?);");
				prep.setString(1, v1);
				prep.setString(2, v3);
				prep.setInt(3, v4);
				prep.setString(4, v5);
				prep.setFloat(5, v6);
				prep.setFloat(6, v7);
				prep.setFloat(7, v8);
				prep.setString(8, v9);
				prep.executeUpdate();
			
				request.getRequestDispatcher("/index.jsp").forward(request,response);
			}
			
			
			
		} catch(Exception e){
			System.out.println(e);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		registerProcess(request, response);
	}

}
