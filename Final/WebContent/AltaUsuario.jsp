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
 	<h1>User registration</h1>
 	<form action="" method="post"> <!--  Si el method esta vacio te redirige a la misma pagina -->
 		<div class="two-columns">
 		
 		<label for="dni">DNI</label><br>
 		<input type="number" placeholder="Enter DNI"><br>
 		<label for="cuil">CUIL</label><br>
 		<input type="text" placeholder="Enter CUIL"><br>
 		
 		</div>
 		
 		<div class="two-columns">
 		
 		<label for="name">First Name</label><br>
 		<input type="number" placeholder="Enter First Name"><br>
 		<label for="last-name">Last Name</label><br>
 		<input type="text" placeholder="Enter Last Name"><br>
 		
 		</div>
 		
 		<div class="two-columns">
 		
 		<label for="date-of-birth">Date of birth</label><br>
 		<input type="date" placeholder="Enter Date of birth"><br>
 		<label for="direction">Direction</label><br>
 		<input type="text" placeholder="Enter Direction"><br>
 		
 		</div>
 		
 		<div class="two-columns">
 		<label for="location">Location</label><br>
 		<select>
 			<option>Select</option>
 			<option>Localidad 1</option>
 			<option>Localidad 2</option>
 		</select><br><br>
 		
 		<label for="province">Province</label><br>
 		<select>
 			<option>Select</option>
 			<option>Buenos Aires</option>
 		</select><br><br>
 		</div>
 		
 		<div class="two-columns">
 		<label for="gender">Gender</label><br>
 		<select>
 			<option>Select</option>
 			<option>Male</option>
 			<option>Female</option>
 		</select><br><br>
 		
 		<label for="nationality">Nationality</label><br>
 		<select>
 			<option>Select</option>
 			<option>Argentina</option>
 			<option>Brasil</option>
 		</select><br><br>
 		
 		</div>
 		
 		<div class="two-columns">
 		
 		<label for="email">Email</label><br>
 		<input type="email" placeholder="Enter Email"><br>
 		<label for="phone">Number phone</label><br>
 		<input type="number" placeholder="Enter Number Phone"><br>
 		
 		</div>
 		 
 		<input type="submit" value="Register"><br>
 		 
 		<a href="Login.jsp">Log in</a><br>
 		
 	</form>
 	
 </div>


</body>
</html>