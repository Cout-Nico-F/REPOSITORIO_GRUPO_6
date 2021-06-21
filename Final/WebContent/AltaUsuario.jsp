<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<style>
	body{
		margin: 0;
		padding: 0;
		background: url(https://cdn.pixabay.com/photo/2018/09/16/22/08/software-3682509_960_720.jpg) no-repeat center top;
		background-size: cover;
		font-family: sans-serif;
		height: 100vh;
	}
	.login-box{
		width: 65vh;
		height: 90vh;
		background: #000;
		color: #fff;
		top: 50%;
		left: 50%;
		position: absolute;
		transform: translate(-50%,-50%);
		box-sizing: border-box;
		padding: 50px 50px;
	}
	.login-box h1{
		text-align: center;
		text-transform: uppercase;
		padding: 2px 20px;
	}
	.login-box input{
		widht: 100%;
		margin-bottom: 30px;
	}
	.login-box input[type="text"],
	.login-box input[type="password"],
	.login-box input[type="number"],
	.login-box input[type="date"],
	.login-box input[type="email"],
	.login-box select{
		border: none;
		border-bottom: 2px solid #fff;
		background: transparent;
		outline: none;
		width: 220px;
		height: 40px;
		color: #fff;
		font-size: 16px;
	}
	.login-box select option{
		background: transparent;
		color: #000;
	}
	.login-box input[type="submit"]{
		border: none;
		outline: none;
		width: 150px;
		height: 40px;
		background: #b80f22;
		color: #fff;
		font-size: 20px;
		border-radius: 0px;
	}
	.login-box a{
		text-decoration: none;
		font-size: 16px;
		line-height: 20px;
		color: darkgrey;
	}
	.login-box a:hover{
		color: #fff;
	}
	.login-box .two-columns{
		-webkit-column-count: 2; /* Chrome, Safari, Opera */
    	-moz-column-count: 2; /* Firefox */
    	column-count: 2;
	}
	
</style>

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