<%@page import="entidad.*"%>
<%@page import = "java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Solicitud de prestamo</title>
<link href="recursos/style-prestamos.css" rel="stylesheet" type="text/css">
<%@ include file="HeaderCliente.jsp" %>
<script>
$(document).ready(function() {
	var n = 12
	var s = ""
	var timer;             //timer para calcular cuando el usuario deja de escribir
	var intervalo = 1000;  //tiempo en milisegundos 
	
	$("select[name='cuotas']").change(calcularMontos)

	//empezar el timer
	$("input[name='solicitado']").keyup(function () {
	  clearTimeout(timer);
	  timer = setTimeout(calcularMontos, intervalo);
	})

	//limpiar el timer
	$("input[name='solicitado']").keydown(function () {
	  clearTimeout(timer);
	})
	
	//las cuotas pueden ser desde 12 hasta 96 con una nueva opción c/ 6 meses
	while (n >= 12 && n <= 96) {
		if (n % 6 == 0) {
			s += "<option value='" + n + "'>" + n + "</option>"
		}
		n++
	}
	$("select[name='cuotas']").html(s)
	
	 <% if(request.getAttribute("mensaje") != null){ %>
		$('.toast-body').html('<span><%=request.getAttribute("mensaje") %></span><button class="btn" type="button" data-bs-dismiss="toast"><i class="bi bi-x-lg"></i></button>')
     	$('.toast').toast('show');
	<% } %>
})
function calcularMontos() {
	const formatter = new Intl.NumberFormat('es-AR', {
		  style: 'currency',
		  currency: 'ARS'
		});
	const solicitado = $("input[name='solicitado']").val()
	const cuotas = $("select[name='cuotas']").val()
	$("input[name='totalMostrar']").val("")
	$("input[name='mensualMostrar']").val("")
	$("button").prop('disabled', true)
    if (solicitado && cuotas) {
    	//el monto total es igual al importe solicitado más la cantidad de cuotas por ciento: ej. si pido 100 en 12 cuotas, el total es 100 + 12% = 112)
    	const total = (solicitado * parseFloat("1." + cuotas)).toFixed(2)
    	const mensual = (total / cuotas).toFixed(2)
    	$("input[name='total']").val(total)
    	$("input[name='mensual']").val(mensual)
    	$("input[name='totalMostrar']").val(formatter.format(total))
    	$("input[name='mensualMostrar']").val(formatter.format(mensual))
    	$("button").prop('disabled', false)
    }
}
function submitForm() {
    $("form").submit()
}
</script>
</head>
<body>
<div class="toast" style="left: 50%; position: fixed; transform: translate(-50%, 0px); z-index: 9999;" data-bs-autohide="false">
      <div class="toast-body"></div>
  </div>
<div class="modal fade" id="modal" tabindex="-1" aria-hidden="true">
	  <input type="hidden" name="dniActual" >
	  <div class="modal-dialog h-75">
	    <div class="modal-content h-100">
	      <div class="modal-header">Términos y condiciones</div>
	      <div class="modal-body"><embed class="w-100 h-100" src="recursos/terminos.html"></div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No acepto</button>
	        <button type="button" class="btn btn-primary" onclick="submitForm()">Acepto</button>
	      </div>
	    </div>
	  </div>
	</div>
		<br><br><br>
        <div class="wrapper">
        <div class="title">
          Solicitud de préstamo
        </div>
		<form method="post" action="SolicitudPrestamo">
        <div class="form">
           <div class="inputfield">
            <label>Cuenta</label>
            <div class="custom_select">
              <select name="cuenta">
               <%  
     ArrayList<Cuenta> cuentas = (ArrayList<Cuenta>) request.getAttribute("cuentas");
     if(cuentas != null && !cuentas.isEmpty())
		for(Cuenta c : cuentas) 
		{
	%>
                <option value="<%=c.getNumeroCuenta()%>"><%=c.getTipoDeCuenta().getDescripcion()%> - <%=c.getNumeroCuenta()%></option>
                <%  } %>
              </select>
            </div>
         </div>   
          <div class="inputfield">
              <label>Monto solicitado</label>
              <input type="number" class="input" name="solicitado" required>
           </div> 
         <div class="inputfield">
            <label>Cuotas</label>
            <div class="custom_select">
              <select name="cuotas"></select>
            </div>
         </div> 
          <div class="inputfield">
              <label>Monto total a pagar</label>
              <input type="hidden" name="total">
              <input class="input" name="totalMostrar" readonly>
           </div> 
         <div class="inputfield">
            <label>Monto mensual a pagar</label>
            <input type="hidden" name="mensual">
            <input class="input" name="mensualMostrar" readonly>
         </div>
          <div class="inputfield">
	     <button type="button" class="btn" data-bs-toggle="modal" data-bs-target="#modal" disabled>Solicitar</button>
          </div>
        </div>
    </form>
    </div>	
</body>
</html>