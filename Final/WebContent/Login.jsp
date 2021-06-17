<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
		width: 360px;
		height: 450px;
		background: #000;
		color: #fff;
		top: 50%;
		left: 50%;
		position: absolute;
		transform: translate(-50%,-50%);
		box-sizing: border-box;
		padding: 70px 30px;
	}
	.login-box .avatar{
		width: 100px;
		height: 100px;
		border-radius: 50%;
		position: absolute;
		top: -50px;
		left: calc(50% - 50px);
	}
	.logo-box h1{
		margin: 0;
		padding: 0 0 20px;
		text-align: center;
		font-size: 22px;
	}
	.logo-box label{
		margin: 0;
		padding: 0;
		font-weight: bold;
		display: block;
	}
	.login-box input{
		widht: 100%;
		margin-bottom: 20px;
	}
	.login-box input[type="text"],
	.login-box input[type="password"]{
		border: none;
		border-bottom: 1px solid #fff;
		background: transparent;
		outline: none;
		width: 250px;
		height: 40px;
		color: #fff;
		font-size: 16px;
	}
	.login-box input[type="submit"]{
		border: none;
		outline: none;
		width: 150px;
		height: 40px;
		background: #b80f22;
		color: #fff;
		font-size: 18px;
		border-radius: 0px;
	}
	.login-box a{
		text-decoration: none;
		font-size: 12px;
		line-height: 20px;
		color: darkgrey;
	}
	.login-box a:hover{
		color: #fff;
	}
	
</style>

 <div class="login-box">
 	<img class="avatar" src="https://cdn.pixabay.com/photo/2018/11/13/22/01/instagram-3814081_960_720.png" alt="logo">
 	<h1>Login Here</h1>
 	<form>
 	
 		<!-- Username -->
 		<label for="username">Username</label><br>
 		<input type="text" placeholder="Enter Username"><br>
 		
 		<!-- Password -->
 		<label for="password">Password</label><br>
 		<input type="text" placeholder="Enter Password"><br>
 		 
 		<input type="submit" value="Log in"><br>
 		 
 		<a href="#">Lost your password?</a><br>
 		<a href="#">Don't have an account?</a>
 		
 	</form>
 </div>

</body>
</html>