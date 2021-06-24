<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro usuario</title>
<link href="style-altausuario.css" rel="stylesheet" type="text/css">
</head>
<body>

 <div class="login-box">
 	<h1>Registro usuario</h1>
 	<form action="" method="post"> <!--  Si el method esta vacio te redirige a la misma pagina -->
 		<div class="two-columns">
 		
 		<label for="dni">DNI</label><br>
 		<input type="number" placeholder="Ingrese DNI"><br>
 		<label for="cuil">CUIL</label><br>
 		<input type="text" placeholder="Ingrese CUIL"><br>
 		
 		</div>
 		
 		<div class="two-columns">
 		
 		<label for="name">Nombre</label><br>
 		<input type="number" placeholder="Ingrese nombre"><br>
 		<label for="last-name">Apellido</label><br>
 		<input type="text" placeholder="Ingrese apellido"><br>
 		
 		</div>
 		
 		<div class="two-columns">
 		
 		<label for="date-of-birth">Fecha de nacimiento</label><br>
 		<input type="date" placeholder="Ingrese fecha nac."><br>
 		<label for="direction">Direccion</label><br>
 		<input type="text" placeholder="Ingrese Direccion"><br>
 		
 		</div>
 		
 		<div class="two-columns">
 		<label for="location">Localidad</label><br>
 		<select>
 			<option>Seleccionar</option>
 			<option>Localidad 1</option>
 			<option>Localidad 2</option>
 		</select><br><br>
 		
 		<label for="province">Provincia</label><br>
 		<select>
 			<option>Seleccionar</option>
 			<option>Buenos Aires</option>
 		</select><br><br>
 		</div>
 		
 		<div class="two-columns">
 		<label for="gender">Genero</label><br>
 		<select>
 			<option>Seleccionar</option>
 			<option>Masculino</option>
 			<option>Femenino</option>
 		</select><br><br>
 		
 		<label for="nationality">Nacionalidad</label><br>
 		<select>
 			<option>Seleccionar</option>
 			<option>Argentina</option>
 			<option>Brasil</option>
 		</select><br><br>
 		
 		</div>
 		
 		<div class="two-columns">
 		
 		<label for="email">Email</label><br>
 		<input type="email" placeholder="Ingrese Email"><br>
 		<label for="phone">Numero de telefono</label><br>
 		<input type="number" placeholder="Ingrese numero de telefono"><br>
 		
 		</div>
 		 
 		<input type="submit" value="Registrarse"><br>
 		 
 		<a href="Login.jsp">Loguearse</a><br>
 		
 	</form>
 	
 </div>


</body>
</html>