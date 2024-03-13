<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<h1>Calcular IMC</h1>
	</div>
	<div>
		<form action="inputNewDB" method="post">
		<div class="contain">
			<div>
				<label>Altura: (Superior a 1m y menor que 2.5m)</label><br>
				<input type="text" id="h1" name="h1" placeholder="Altura" required>
				<br><br>
			</div>
			<div>
				<label>Peso:</label><br>
				<input type="text" id="w1" name="w1" placeholder="Peso" required>
				<br><br>
			</div>
			<input type="submit" value="Calcular" class="bb">
		</div>
		</form>
	</div>
</body>
</html>