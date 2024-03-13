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
		<h1>Register</h1>
	</div>
	<div>
		<form action="registerDB" method="post">
		<div class="contain">
			<div>
				<label>Usuario:</label><br>
				<input type="text" id="username" name="username" placeholder="Usuario" required>
				<br><br>
			</div>
			<div>
				<label>Contraseña:</label><br>
				<input type="password" id="password" name="password" placeholder="Contraseña" required>
				<br><br>
			</div>
			<div>
				<label>Nombre:</label><br>
				<input type="text" id="name" name="name" placeholder="Nombre" required>
				<br><br>
			</div>
			<div>
				<label>Edad: (Mayor de 15)</label><br>
				<input type="number" id="age" name="age" placeholder="Edad" required>
				<br><br>
			</div>
			<div>
				<label>Sexo: M/F</label><br>
				<input type="text" id="sex" name="sex" placeholder="M/F" required>
				<br><br>
			</div>
			<div>
				<label>Estatura: (Superior a 1m y menor que 2.5m)</label><br>
				<input type="text" id="height" name="height" placeholder="Estatura" required>
				<br><br>
			</div>
			<div>
				<label>Peso: (kg)</label><br>
				<input type="text" id="weight" name="weight" placeholder="Peso" required>
				<br><br>
			</div>
			<input type="submit" value="Register" class="bb">
			<br><br>
		</div>
		</form>
	</div>
</body>
</html>