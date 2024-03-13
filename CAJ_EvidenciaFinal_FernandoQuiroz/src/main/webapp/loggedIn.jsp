<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="Models.users" %>
<%@ page import="Controllers.conectorDB" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Evidencia - Fernando Quiroz</title>
</head>
<style>
	table, td, th {
		border: 1px solid black;
		border-collapse: collapse;
	}
	
	table {
		text-align:center;
		width:50vw;
		align:center;
	}
	
	td {
		width:20%;
	}
	
	.table {
		margin-left:auto;
		margin-right:auto;
	}
	
	h1 {
		text-align: center;
	}
	
	th {
		background-color: rgb(0, 64, 255);
	}
	
	.un {
		background-color: rgb(92, 133, 255);
	}
	
	.un, th {
		Color: White;
		font-weight: bold;
	}
	
	div {
		text-align:center;
		align:center;
	}
</style>
<body>
	<%
		String url = "jdbc:mysql://localhost:3306/base";
		String username = "root";
		String password = "mysqlpassword";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect = DriverManager.getConnection(url,username,password);
		
		conectorDB dbGet = new conectorDB();
		String user = session.getAttribute("usuario").toString();
		
		PreparedStatement prep = connect.prepareStatement("SELECT username, estatura, peso, imc, fecha FROM userinfo WHERE username = " + "\"" + user +"\"");
		ResultSet res = prep.executeQuery();
	%>
	<h1>Historial de datos</h1>
	
	<table class="table">
		<tr>
			<th>Usuario</th>
			<th>Estatura</th>
			<th>Peso</th>
			<th>IMC</th>
			<th>Fecha</th>
		</tr>
		<% while (res.next()){ %>
		<tr>
			<td class="un"><%=res.getString("username")%></td>
			<td><%=res.getFloat("estatura")%></td>
			<td><%=res.getFloat("peso")%></td>
			<td class="un"><%=res.getFloat("imc")%></td>
			<td><%=res.getString("fecha")%></td>
		</tr>
		
		<% } %>
	</table>
	<br><br>
	<div>
		<a href="index.jsp">Inicio</a>
	</div>
	
</body>
</html>