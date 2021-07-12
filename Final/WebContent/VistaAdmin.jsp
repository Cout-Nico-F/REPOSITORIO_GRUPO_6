<%@page import="entidad.VistaAdmin"%>
<%@page import="entidad.Prestamo"%>
<%@page import="entidad.Cuenta"%>
<%@page import="entidad.TipoDeCuenta"%>
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
         	<%if(session.getAttribute("nombreUsuarioLogeado") != null) { %>
         	  <h1 class="py-3 px-2"><%=session.getAttribute("nombreUsuarioLogeado") %></h1>
         	  <% } %>
         </div>
     </div>

     <div class="recent-grid">
         <div class="projects">
             <div class="card">
                 <div class="card-header">
                     <h3>Informes estadisticos</h3> <!-- Dentro de la tabla podria haber columnas que sean prestamos rechazados o aceptados
                     o tambien podriamos tener una columna dni de usuario donde traemos su dni o cbu y demas datos como prestamos solicitados, transferencias exitosas o algo asi-->
                 </div>
                <!--  status green  status grey  status red -->
                 <div class="card-body">
                    <div class="table-responsive">
                     <table width="100%">
                         <thead>
                             <tr>
                                 <td>N° Cuenta</td>
                                 <td>Cuenta</td>
                                 <td>Prestamos del Cliente</td>
                             </tr>
                         </thead>
                         <tbody>
                         <%if(request.getAttribute("listaCuentasUsuario") != null) { 
                         ArrayList<VistaAdmin> listaVa = (ArrayList<VistaAdmin>)request.getAttribute("listaCuentasUsuario"); 
                         for(VistaAdmin va : listaVa) { %>
                         	<tr>
                         		<td><%=va.getNumeroCuenta() %></td>
                         		<td><%=va.getTipoCuenta().getDescripcion() %></td>
                         		<%if(va.getPrestamo().getEstado() == 1) {%>
                         		<td><span class="status solicitado"></span><%=va.getPrestamo().getFecha() %></td>
                         		<% } %>
                         		<%if(va.getPrestamo().getEstado() == 2) {%>
                         		<td><span class="status denegado"></span><%=va.getPrestamo().getFecha() %></td>
                         		<% } %>
                         		<%if(va.getPrestamo().getEstado() == 3) {%>
                         		<td><span class="status vigente "></span><%=va.getPrestamo().getFecha() %></td>
                         		<% } %>
                         		<%if(va.getPrestamo().getEstado() == 4) {%>
                         		<td><span class="status pagado"></span><%=va.getPrestamo().getEstado() %></td>
                         		<% } %>
                         	</tr>
                         	<% } %>
                         	<% } 
                         	else { %>
                         		<tr>
                         	  		<td><span> Sin datos que mostrar</span></td>
                         	  		<td><span> Sin datos que mostrar</span></td>
                         	  		<td><span> Sin datos que mostrar</span></td>
                         	  	</tr>
                         	<% } %>
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
                     <h3>Clientes Recientes</h3>
                 </div>
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