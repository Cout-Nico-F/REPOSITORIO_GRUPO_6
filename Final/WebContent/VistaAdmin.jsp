<%@page import="entidad.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reportes</title>
 <!-- Icons8 -->
 <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
 <!-- CSS -->
 <link href="recursos/style-vistaadmin.css" rel="stylesheet" type="text/css">
 <!--  CDN Font Awesome -->
 <script src="https://kit.fontawesome.com/d749d06842.js" crossorigin="anonymous"></script>
 <!-- Agrego el admin header -->
 <%@ include file="HeaderAdmin.jsp" %>  
</head>
<body>
   <main>
     <div class="cards">
         <div class="card-single">
             <div>
             	<%if(request.getAttribute("CantidadDeClientes") != null) { //Un cliente es un usuario asi que clientes registrados y usuarios registrados son lo mismo
             	 int cantClientes = (int)request.getAttribute("CantidadDeClientes"); %>
                 <h1><%=cantClientes %></h1> <!-- Esto podria sera un contador de clientes registrados -->
                 <% } %>
                 <span>Clientes</span>
             </div>
             <div>
                 <span class="las la-users"></span>
             </div>
         </div>
         
         <div class="card-single">
             <div>
                 <%if(request.getAttribute("CantidadDeSolicitudes") != null) {
                	 int cantSolicitudes = (int) request.getAttribute("CantidadDeSolicitudes"); %>
                 <h1><%=cantSolicitudes %></h1> <!-- Esto podria sera un contador de solicitudes de prestamos pendientes de aprobacion-->
                 <% } %>
                 <span>Prestamos pendientes</span>
             </div>
             <div>
                 <span class="las la-users"></span>
             </div>
         </div>

         <div class="card-single">
             <div>
               	 <%if(request.getAttribute("CantidadDePrestamosRechazados") != null) {
                	 int cantSolicitudesRechazadas = (int) request.getAttribute("CantidadDePrestamosRechazados"); %>
                 <h1><%=cantSolicitudesRechazadas %></h1> 
                 <% } %>
                 <span>Prestamos rechazados</span>
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
                <!--  status green  status grey  status red -->
                 <div class="card-body">
                    <div class="table-responsive">
                     <table width="100%">
                         <thead>
                             <tr>
                                 <td>N° Cuenta</td>
                                 <td>Cuenta</td>
                                 <td>Prestamos</td>
                             </tr>
                         </thead>
                         <tbody>
                             <tr>
                                 <td>34032738</td>
                                 <td>123132313213213</td>
                                 <td>
                                     <span class="status green"></span>
                                     Aceptado
                                 </td>
                             </tr>
                         </tbody>
                     </table>
                    </div>
                 </div>
             </div>
         </div>
         <form method="get" action="ServletVistaAdmin"> 
         <div class="customers">
             <div class="card">
                 <div class="card-header">
                     <h3>Nuevos clientes</h3> <!-- Dentro de la tabla podria haber columnas que sean prestamos rechazados o aceptados
                     o tambien podriamos tener una columna dni de usuario donde traemos su dni o cbu y demas datos como prestamos solicitados, transferencias exitosas o algo asi-->
                 </div>
                 <!-- Esta es la seccion donde se van a mostrar los nuevos usuarios para dar de alta -->
                 <div class="card-body">
                 	<%if(request.getAttribute("listaClientes") != null) { 
                 	 ArrayList<Cliente> listaCliente = (ArrayList<Cliente>) request.getAttribute("listaClientes"); 
                 	 for(Cliente lc : listaCliente) { %>
                     
                     <div class="costumer">
                         <div class="info">
                             <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRfeGINlGtetp2-gZRw4gLauZ5-2rhTpmNR4A&usqp=CAU" width="40px" height="40px" alt="user-image">
                             <div>
                                 <h4><%=lc.getNombre() %></h4> <!-- Aca iria el nombre del usuario -->
                                 <small><%=lc.getCorreoElectronico() %></small> <!-- Aca podria ir una breve descripcion de una linea o un telefono o el email -->
                             </div>
                             <div class="container px-4"> 
                             <button type="submit" name="btnDniusuario" value="<%=lc.getDni() %>"><i class="fas fa-info-circle color-icon"></i></button>
                        	</div>
                         </div>
                     </div>
                     
                     <% } %>
                     <% }  
                     else { %>
                     	<h4> Sin clientes :(0) </h4>
                     <% } %>
                 </div>
             </div>
         </div>
         </form>
     </div>
 </main>
</body>
</html>