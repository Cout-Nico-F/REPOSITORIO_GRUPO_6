<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transferencia de dinero</title>
<link href="recursos/style-prestamos.css" rel="stylesheet" type="text/css">
<%@ include file="HeaderCliente.jsp" %>
</head>
<body>

        <br><br><br><br><br><br><br>
        <form method="Post" action="ServletTransferencia">
        
        <div class="wrapper">
        	<div class="title"> Transferencia Bancaria </div>
        <div class="form">
         <!-- Alert -->
         <div class="d-flex justify-content-center">
 		
 		<% if(request.getAttribute("tipoMensajeOrigen") != null && session.getAttribute("mensajeOrigen") != null){ %>	<!-- Son 2 strings podria hacer isEmpty() -->
 		<div class="alert alert-<%=request.getAttribute("tipoMensajeOrigen")%> alert-dismissible fade show" role="alert">
  			<strong><%=session.getAttribute("mensajeOrigen") %></strong>
		</div>
		<% session.removeAttribute("mensajeOrigen");} %> <!-- En teoria a partir de aca deja de existir -->
		 <!-- Remuevo la session pero falta actualizar la pagina -->
		 <!-- Agregarle un temporizador o algo para que la alerta desaparezca -->
 		</div>
 		 <!-- Alert -->
 		 
 		 
              <div class="inputfield">
              <label>CBU Cuenta Origen:</label>
              <input type="number" class="input" >
           </div>
           
           
          <!-- Alert -->
         <div class="d-flex justify-content-center">
 		
 		<% if(request.getAttribute("tipoMensajeDestino") != null && session.getAttribute("mensajeDestino") != null){ %>	<!-- Son 2 strings podria hacer isEmpty() -->
 		<div class="alert alert-<%=request.getAttribute("tipoMensajeDestino")%> alert-dismissible fade show" role="alert">
  			<strong><%=session.getAttribute("mensajeDestino") %></strong>
		</div>
		<% session.removeAttribute("mensajeDestino");} %> <!-- En teoria a partir de aca deja de existir -->
		 <!-- Remuevo la session pero falta actualizar la pagina -->
		 <!-- Agregarle un temporizador o algo para que la alerta desaparezca -->
 		</div>
 		 <!-- Alert -->
 		 
         <div class="inputfield">
              <label>CBU Cuenta Destino:</label>
              <input type="number" class="input" >
           </div>    
          <div class="inputfield">
              <label style="width: 243px; height: 26px">Cantidad a Transferir en Pesos:</label>
              <input type="number" class="input" >
           </div>
          <br><br>
          <input name="btnTransferir" type="submit" value="Transferir" class="btn btn-primary">
    </div>	
    </div>
    </form>
</body>
</html>