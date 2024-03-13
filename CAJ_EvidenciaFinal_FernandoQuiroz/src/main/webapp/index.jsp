<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Evidencia - Fernando Quiroz</title>
</head>
<style>
	h1 {
		text-align: center;
	}
	
	form {
		width: 20vw;
		text-align: left;
		margin-left: auto;
		margin-right: auto;
	}
	
	br {
		user-select: none;
	}
	
	.contain {
		width: 15vw;
		margin-left: auto;
		margin-right: auto;
	}
	
	input {
		box-sizing: border-box;
		-moz-box-sizing: border-box;
		width: 100%;
	}
	
	input [type=submit] {
		background-color: white;
		border: 2px solid black;
		color: black;
		cursor: pointer;
	}
	
	.bb {
		background-color: white;
		color: black;
	}
	
	.bb:hover{
		background-color: black;
		color: white;
	}
</style>
<body>
	<div>
		<h1>Login</h1>
	</div>
	<div>
		<form action="conectorDB" method="post">
			<div class="contain">
				<div>
					<label>Username:</label><br>
					<input type="text" id="username" name="username" placeholder="Usuario" required>
					<br><br>
				</div>
				<div>
					<label>Password:</label><br>
					<input type="password" id="password" name="password" placeholder="Contraseña" required>
					<br><br>
				</div>
			
				<input type="submit" value="Login" class="bb">
				<br><br>
			</div>
			
		</form>
		
		<form action="register.jsp">
			<div class="contain">
				<input type="submit" value="Register" class="bb">
			</div>
			
		</form>
	</div>
	<br><br>
</body>
</html>