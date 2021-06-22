<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina de inicio</title>
<!-- Icons8 -->
 <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
 <!-- CSS -->
<link href="style-home.css" rel="stylesheet" type="text/css">
</head>
<body>
        
	<div id="sidebar">
      <div class="toggle-btn">
        <span>&#9776;</span>
      </div>
      <ul>
        <li>
          <!-- Aca iria el logo de la empresa  -->
          <!-- <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8pForLrTVdXB6YPUH27eNUao8tDH3vypHmg&usqp=CAU" alt="Logo Bank" class="logo"> -->
        </li>
        <a href="Home.jsp"><li>Home</li></a>
        <a href="Prestamos.jsp"><li>Prestamos</li></a>
        <a href="Login.jsp"><li>Crear cuenta</li></a>
      </ul>
    </div>
    
    <script>
    const btnToggle = document.querySelector('.toggle-btn');

    btnToggle.addEventListener('click', function () {
      console.log('clik')
      document.getElementById('sidebar').classList.toggle('active');
      console.log(document.getElementById('sidebar'))
    });
    </script> 

</body>
</html>