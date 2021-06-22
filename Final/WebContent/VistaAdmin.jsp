<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
 <!-- Icons8 -->
 <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
 <!-- CSS -->
 <link href="style-vistaadmin.css" rel="stylesheet" type="text/css">
</head>
<body>
	 <!-- Sidebar -->
        <input type="checkbox" id="nav-toggle">
        <div class="sidebar">
            <div class="sidebar-brand">
                <h2><span class="lab la-accusoft"></span><span> Bank</span></h2> <!-- Dentro de span hay un icono -->
            </div>
            <div class="sidebar-menu">
                <ul>
                    <li>
                        <a href="" class="active"><span class="las la-igloo"></span> <!-- Cambiar los iconos -->
                            <span>Dashboard</span></a>
                    </li>
                    <li>
                        <a href=""><span class="las la-igloo"></span>
                            <span>Iniciar Sesion</span></a>
                    </li>
                </ul>
            </div>
        </div>
        <!-- -->

        <div class="main-content">
            <header>
                   <h2>
                    <label for="nav-toggle">
                        <span class="las la-bars"></span>
                        Dashboard
                    </label>
                   </h2>
                   <!-- Buscador -->
                   <!-- 
                   <div class="search-wrapper">
                        <span class="las la-search"></span>
                        <input type="search" placeholder="Buscar"/>
                   </div>
                    -->
                   <div class="user-wrapper">
                       <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRfeGINlGtetp2-gZRw4gLauZ5-2rhTpmNR4A&usqp=CAU" width="40px" height="40px" alt="user-image">
                       <div>
                           <h4>Alonso Huarcaya</h4> <!-- Aca va el nomobre del usuario que viene de la base de datos -->
                           <small>Admin</small> <!-- Aca la descripcion del tipo de usuario (admin o cliente) -->
                       </div>
                   </div>
            </header>

            <main>
                <div class="cards">
                    <div class="card-single">
                        <div>
                            <h1>54</h1> <!-- Esto podria sera un contador de clientes registrados -->
                            <span>Clientes</span>
                        </div>
                        <div>
                            <span class="las la-users"></span>
                        </div>
                    </div>
                    
                    <div class="card-single">
                        <div>
                            <h1>10</h1> <!-- Esto podria sera un contador de solicitudes de prestamos pendientes de aprobacion-->
                            <span>Solicitudes de prestamos</span>
                        </div>
                        <div>
                            <span class="las la-users"></span>
                        </div>
                    </div>

                    <div class="card-single">
                        <div>
                            <h1>2</h1> <!-- Esto podria sera un contador de clientes registrados -->
                            <span>Aprobacion clientes</span>
                        </div>
                        <div>
                            <span class="las la-users"></span>
                        </div>
                    </div>

                    <div class="card-single">
                        <div>
                            <h1>2K</h1> <!-- Esto podria sera un contador de clientes registrados -->
                            <span>Saldo</span>
                        </div>
                        <div>
                            <span class="las la-users"></span>
                        </div>
                    </div>
                </div>

                <div class="recent-grid">
                    <div class="projects">
                        <div class="card">
                            <div class="card-header">
                                <h3>Informes estadisticos</h3> <!-- Dentro de la tabla podria haber columnas que sean prestamos rechazados o aceptados
                                o tambien podriamos tener una columna dni de usuario donde traemos su dni o cbu y demas datos como prestamos solicitados, transferencias exitosas o algo asi-->
                                <button>Mas detalles<span class="las la-arrow-right">
                                </span></button>
                            </div>
                            <div class="card-body">
                               <div class="table-responsive">
                                <table width="100%">
                                    <thead>
                                        <tr>
                                            <td>DNI Usuario</td>
                                            <td>CBU Usuario</td>
                                            <td>Prestamo solicitado</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>34032738</td>
                                            <td>123132313213213</td>
                                            <td>
                                                <span class="status green"></span>
                                                Aceptado <!-- Traemos el estado del prestamo y dependiendo si es 1 por ejemplo el prestamo se encuentra pendiente de aprobacion-->
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>34032738</td>
                                            <td>123132313213213</td>
                                            <td>
                                                <span class="status green"></span>
                                                Aceptado <!-- Traemos el estado del prestamo y dependiendo si es 1 por ejemplo el prestamo se encuentra pendiente de aprobacion-->
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>34032738</td>
                                            <td>123132313213213</td>
                                            <td>
                                                <span class="status grey"></span>
                                                Pendiente <!-- Traemos el estado del prestamo y dependiendo si es 1 por ejemplo el prestamo se encuentra pendiente de aprobacion-->
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>34032738</td>
                                            <td>123132313213213</td>
                                            <td>
                                                <span class="status grey"></span>
                                                Pendiente <!-- Traemos el estado del prestamo y dependiendo si es 1 por ejemplo el prestamo se encuentra pendiente de aprobacion-->
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>34032738</td>
                                            <td>123132313213213</td>
                                            <td>
                                                <span class="status red"></span>
                                                Rechazado <!-- Traemos el estado del prestamo y dependiendo si es 1 por ejemplo el prestamo se encuentra pendiente de aprobacion-->
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>34032738</td>
                                            <td>123132313213213</td>
                                            <td>
                                                <span class="status red"></span>
                                                Rechazado <!-- Traemos el estado del prestamo y dependiendo si es 1 por ejemplo el prestamo se encuentra pendiente de aprobacion-->
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                               </div>
                            </div>
                        </div>
                    </div>
                    <div class="customers">
                        <div class="card">
                            <div class="card-header">
                                <h3>Nuevos clientes</h3> <!-- Dentro de la tabla podria haber columnas que sean prestamos rechazados o aceptados
                                o tambien podriamos tener una columna dni de usuario donde traemos su dni o cbu y demas datos como prestamos solicitados, transferencias exitosas o algo asi-->
                                <button>Mas detalles<span class="las la-arrow-right"> <!-- Si le damos click va a un jsp donde estan las cards de todos los nuevos usuarios con un boton de aceptar o rechazar -->
                                </span></button>
                            </div>
                            <!-- Esta es la seccion donde se van a mostrar los nuevos usuarios para dar de alta -->
                            <div class="card-body">
                                <div class="costumer">
                                    <div class="info">
                                        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRfeGINlGtetp2-gZRw4gLauZ5-2rhTpmNR4A&usqp=CAU" width="40px" height="40px" alt="user-image">
                                        <div>
                                            <h4>Ramon Valdes</h4> <!-- Aca iria el nombre del usuario -->
                                            <small>pruebaemail@email.com</small> <!-- Aca podria ir una breve descripcion de una linea o un telefono o el email -->
                                        </div>
                                    </div>
                                    <div class="contact">
                                        <span class="las la-user-circle"></span> <!-- Creo que directamente desde estos span podriamos dar de alta un usuario nuevo o rechazarlo -->
                                        <!-- o ir a un jsp donde traiga todos los datos completos -->
                                        <span class="las la-comment"></span>
                                        <span class="las la-phone"></span>
                                    </div>
                                </div>
                                <div class="costumer">
                                    <div class="info">
                                        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRfeGINlGtetp2-gZRw4gLauZ5-2rhTpmNR4A&usqp=CAU" width="40px" height="40px" alt="user-image">
                                        <div>
                                            <h4>Ramon Valdes</h4> <!-- Aca iria el nombre del usuario -->
                                            <small>pruebaemail@email.com</small> <!-- Aca podria ir una breve descripcion de una linea o un telefono o el email -->
                                        </div>
                                    </div>
                                    <div class="contact">
                                        <span class="las la-user-circle"></span> <!-- Creo que directamente desde estos span podriamos dar de alta un usuario nuevo o rechazarlo -->
                                        <!-- o ir a un jsp donde traiga todos los datos completos -->
                                        <span class="las la-user-circle"></span>
                                        <span class="las la-user-circle"></span>
                                    </div>
                                </div>
                                <div class="costumer">
                                    <div class="info">
                                        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRfeGINlGtetp2-gZRw4gLauZ5-2rhTpmNR4A&usqp=CAU" width="40px" height="40px" alt="user-image">
                                        <div>
                                            <h4>Ramon Valdes</h4> <!-- Aca iria el nombre del usuario -->
                                            <small>pruebaemail@email.com</small> <!-- Aca podria ir una breve descripcion de una linea o un telefono o el email -->
                                        </div>
                                    </div>
                                    <div class="contact">
                                        <span class="las la-user-circle"></span> <!-- Creo que directamente desde estos span podriamos dar de alta un usuario nuevo o rechazarlo -->
                                        <!-- o ir a un jsp donde traiga todos los datos completos -->
                                        <span class="las la-user-circle"></span>
                                        <span class="las la-user-circle"></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </main>
        </div>

</body>
</html>