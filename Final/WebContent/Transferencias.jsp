<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transferencia de dinero</title>
<link href="recursos/style-prestamos.css" rel="stylesheet" type="text/css">
<%@ include file="HeaderCliente.jsp" %>
<script>
function submitForm() {
	$("form").submit()
}
function mensaje() {
	const origen = $('input[name="inputCbuOrigen"]').val();
	const destino = $('input[name="inputCbuDestino"]').val();
	const saldo = $('input[name="inputSaldo"]').val();
	var mensaje;
	if (origen && destino && saldo) {
		mensaje = "Ud. va a transferir " + saldo + " a la cuenta " + destino;
		$("#btnDismiss").html("Cancelar")
		$("#btnSubmit").show()
	} 
	$(".modal-body").html(mensaje)
}
</script>
</head>
<body>
<div class="modal fade" id="modal" tabindex="-1" aria-hidden="true">
	  <input type="hidden" name="dniActual" >
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-body"></div>
	      <div class="modal-footer">
	        <button id="btnDismiss" type="button" class="btn btn-secondary" data-bs-dismiss="modal"></button>
	        <button id="btnSubmit" type="button" class="btn btn-primary" onclick="submitForm()">Confirmar</button>
	      </div>
	    </div>
	  </div>
	</div>
        
        <form method="Post" action="ServletTransferencia">
        
        <div class="wrapper">
        	<div class="title"> Transferencia Bancaria </div>
        	
        	
        	<!-- Alert -->
         <div class="d-flex justify-content-center">
 		
 		<% if(request.getAttribute("tipoMensajeSaldo") != null && session.getAttribute("mensajeSaldo") != null){ %>	<!-- Son 2 strings podria hacer isEmpty() -->
 		<div class="alert alert-<%=request.getAttribute("tipoMensajeSaldo")%> alert-dismissible fade show" role="alert">
  			<strong><%=session.getAttribute("mensajeSaldo") %></strong>
		</div>
		<% session.removeAttribute("mensajeSaldo");} %> <!-- En teoria a partir de aca deja de existir -->
		 <!-- Remuevo la session pero falta actualizar la pagina -->
		 <!-- Agregarle un temporizador o algo para que la alerta desaparezca -->
 		</div>
 		 <!-- Alert -->
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
 		 <!-- Alert -->
         <div class="d-flex justify-content-center">
 		
 		<% if(request.getAttribute("tipoMensajeDestinoIncorrecto") != null && session.getAttribute("mensajeDestinoIncorrecto") != null){ %>	<!-- Son 2 strings podria hacer isEmpty() -->
 		<div class="alert alert-<%=request.getAttribute("tipoMensajeDestinoIncorrecto")%> alert-dismissible fade show" role="alert">
  			<strong><%=session.getAttribute("mensajeDestinoIncorrecto") %></strong>
		</div>
		<% session.removeAttribute("mensajeDestinoIncorrecto");} %> <!-- En teoria a partir de aca deja de existir -->
		 <!-- Remuevo la session pero falta actualizar la pagina -->
		 <!-- Agregarle un temporizador o algo para que la alerta desaparezca -->
 		</div>
 		 <!-- Alert -->
 		  <!-- Alert -->
         <div class="d-flex justify-content-center">
 		
 		<% if(request.getAttribute("tipoMensajeOrigenIncorrecto") != null && session.getAttribute("mensajeOrigenIncorrecto") != null){ %>	<!-- Son 2 strings podria hacer isEmpty() -->
 		<div class="alert alert-<%=request.getAttribute("tipoMensajeOrigenIncorrecto")%> alert-dismissible fade show" role="alert">
  			<strong><%=session.getAttribute("mensajeOrigenIncorrecto") %></strong>
		</div>
		<% session.removeAttribute("mensajeOrigenIncorrecto");} %> <!-- En teoria a partir de aca deja de existir -->
		 <!-- Remuevo la session pero falta actualizar la pagina -->
		 <!-- Agregarle un temporizador o algo para que la alerta desaparezca -->
 		</div>
 		 <!-- Alert -->
 		  <!-- Alert -->
         <div class="d-flex justify-content-center">
 		
 		<% if(request.getAttribute("tipoMensajeSaldoVacio") != null && session.getAttribute("mensajeSaldoVacio") != null){ %>	<!-- Son 2 strings podria hacer isEmpty() -->
 		<div class="alert alert-<%=request.getAttribute("tipoMensajeSaldoVacio")%> alert-dismissible fade show" role="alert">
  			<strong><%=session.getAttribute("mensajeSaldoVacio") %></strong>
		</div>
		<% session.removeAttribute("mensajeSaldoVacio");} %> <!-- En teoria a partir de aca deja de existir -->
		 <!-- Remuevo la session pero falta actualizar la pagina -->
		 <!-- Agregarle un temporizador o algo para que la alerta desaparezca -->
 		</div>
 		 <!-- Alert -->
 		 <!-- Alert -->
         <div class="d-flex justify-content-center">
 		
 		<% if(request.getAttribute("tipoMensajeTransferencia") != null && session.getAttribute("mensajeTransferencia") != null){ %>	<!-- Son 2 strings podria hacer isEmpty() -->
 		<div class="alert alert-<%=request.getAttribute("tipoMensajeTransferencia")%> alert-dismissible fade show" role="alert">
  			<strong><%=session.getAttribute("mensajeTransferencia") %></strong>
		</div>
		<% session.removeAttribute("mensajeTransferencia");} %> <!-- En teoria a partir de aca deja de existir -->
		 <!-- Remuevo la session pero falta actualizar la pagina -->
		 <!-- Agregarle un temporizador o algo para que la alerta desaparezca -->
 		</div>
 		 <!-- Alert -->
 		  <!-- Alert -->
         <div class="d-flex justify-content-center">
 		
 		<% if(request.getAttribute("tipoMensajeOrigenIncorrecto2") != null && session.getAttribute("mensajeOrigenIncorrecto2") != null){ %>	<!-- Son 2 strings podria hacer isEmpty() -->
 		<div class="alert alert-<%=request.getAttribute("tipoMensajeOrigenIncorrecto2")%> alert-dismissible fade show" role="alert">
  			<strong><%=session.getAttribute("mensajeOrigenIncorrecto2") %></strong>
		</div>
		<% session.removeAttribute("mensajeOrigenIncorrecto2");} %> <!-- En teoria a partir de aca deja de existir -->
		 <!-- Remuevo la session pero falta actualizar la pagina -->
		 <!-- Agregarle un temporizador o algo para que la alerta desaparezca -->
 		</div>
 		 <!-- Alert -->
 		  <!-- Alert -->
         <div class="d-flex justify-content-center">
 		
 		<% if(request.getAttribute("tipoMensajeOrigenIncorrecto3") != null && session.getAttribute("mensajeOrigenIncorrecto3") != null){ %>	<!-- Son 2 strings podria hacer isEmpty() -->
 		<div class="alert alert-<%=request.getAttribute("tipoMensajeOrigenIncorrecto3")%> alert-dismissible fade show" role="alert">
  			<strong><%=session.getAttribute("mensajeOrigenIncorrecto3") %></strong>
		</div>
		<% session.removeAttribute("mensajeOrigenIncorrecto3");} %> <!-- En teoria a partir de aca deja de existir -->
		 <!-- Remuevo la session pero falta actualizar la pagina -->
		 <!-- Agregarle un temporizador o algo para que la alerta desaparezca -->
 		</div>
 		 <!-- Alert -->
        	
        <div class="form">
        		 
              <div class="inputfield">
              <label>CBU Cuenta Origen:</label>
              <input type="number" class="form-control" name="inputCbuOrigen" min="1" pattern="^[0-9]+">
           </div> 
         <div class="inputfield">
              <label>CBU Cuenta Destino:</label>
              <input type="number" class="form-control" name="inputCbuDestino" min="1" pattern="^[0-9]+">
           </div>    
          <div class="inputfield">
              <label style="width: 243px; height: 26px">Cantidad en Pesos:</label>
              <input type="number" class="form-control" name="inputSaldo" min="1" pattern="^[0-9]+">
           </div>
          <br><br>
         <!--   <input type="button" value="Transferir" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modal" onclick="mensaje()">
 		  Lo comento porque no entra al post y no ejecuta la logica del servlet-->  <input name="btnTransferir" type="submit" value="Transferir" class="btn btn-primary">
    </div>	
    </div>
    </form>
</body>
</html>