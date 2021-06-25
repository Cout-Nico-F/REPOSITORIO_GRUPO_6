<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Iniciar Sesion</title>
<link href="recursos/style-login.css" rel="stylesheet" type="text/css">
<%@ include file="HeaderCliente.jsp" %>
</head>
<body>

 <div class="login-box">
 	<img class="avatar" src="https://cdn.pixabay.com/photo/2018/11/13/22/01/instagram-3814081_960_720.png" alt="logo">
 	<h1>Login</h1>
 	<form action="" method="post">
 	
 		<!-- Username -->
 		<label for="username">Nombre de usuario</label><br>
 		<input type="text" name="txtNombreUsuario" placeholder="Ingrese nombre de usuario"><br>
 		
 		<!-- Password -->
 		<label for="password">Contraseña</label><br>
 		<input type="text" name="txtContrasenia" placeholder="Ingrese Contraseña"><br>
 		 
 		<input type="submit" value="Loguearse" name="btnLogin"><br>
 		 
 		<a href="#">Olvido su contraseña?</a><br>
 		<a href="AltaUsuario.jsp">No tiene una cuenta?</a>
 	</form>
 </div>
 
 <%
    //int filas = 0;
 	//if(request.getAtrribute("cantFilas") != null){
 		//filas = request.getAtrribute("cantFilas");

 	//}
 	
 	
 %>

</body>
</html>