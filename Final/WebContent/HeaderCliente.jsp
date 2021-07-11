<%@page import="com.sun.corba.se.spi.orbutil.fsm.Input"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="recursos/style-movimientos.css" rel="stylesheet" type="text/css">
<link href="recursos/style-select.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css"/>
<link rel="icon" href="img/icon.png">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@4.5.2/dist/lux/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
<script>
	$(function() {
		$('.nav-link').each(function() {
			var isActive = this.pathname === location.pathname;
			$(this).toggleClass('active', isActive);
		});
	});
</script>

<style>
	.img-user{
		width: 22px;
		height: 22px;
		border-radius: 12px;
	}
</style>

<nav class="navbar fixed-top navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Banco</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor03" aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarColor03">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="ServletHistorialMovimientos">Historial Movimientos</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="Transferencias">Transferir dinero</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="SolicitudPrestamo">Solicitar un préstamo</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="ServletPagarPrestamo">Pagar un préstamo</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="ServletDatosPersonales">Datos personales</a>
        </li>
      </ul>
      <div class="ml-auto">
      <form method="post" action="servletLogin">
     	<% if( request.getSession().getAttribute("nombreUsuarioLogeado") != null){ %>
     		<% if(session.getAttribute("tipoUsuarioLogeado") == "true"){ %> <!-- Hago el casteo asi porque es un objeto -->
     			<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSriFFJXaLLV3g1bFT8PrDRFbD50XjQ7lm_0g&usqp=CAU" class="img-user">
     		<% } else { %>
     			<img src="https://cdn3.iconfinder.com/data/icons/wpzoom-developer-icon-set/500/104-512.png" class="img-user">		
     		<% } %>
       <span><%= request.getSession().getAttribute("nombreUsuarioLogeado") %></span>
       <input type="submit" name="btnCerrarSesion" value= "Cerrar Sesión" class="btn btn-secondary">
      <% }
     else{%>
     <input type="submit" value="Iniciar Sesión" class= "btn btn-secondary" name= "btnIniciarSesion">     
     <%}%> 
     </form>     
       <!--  TODO: Eliminar aca los atributos nombreusuariologeado y tipousuariologeado ?  -->
       </div>
    </div>
  </div>
</nav>

