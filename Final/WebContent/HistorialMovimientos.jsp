<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import = "entidad.TipoDeCuenta" %>
<%@ page import="java.util.ArrayList"%>
<%@page import="entidad.Movimiento" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Historial de Movimientos</title>
<%@ include file="HeaderCliente.jsp"%>
</head>
<body>

	<br>
	<br>
	<form action="ServletHistorialMovimientos" method="POST"> 
	<div class="titleMovimientos">Historial de Movimientos</div>
	<br>
	<div align="center">
		<label for="standard-select">Seleccione la cuenta</label>
		<div class="select">
			<select id="standard-select" name="slMostrar">
		<% if(request.getParameter("listaTiposCta") != null){
			ArrayList<TipoDeCuenta> listaCuentas = new ArrayList<TipoDeCuenta>();
			listaCuentas = (ArrayList<TipoDeCuenta>) request.getAttribute("listaTiposCta");
			 for(TipoDeCuenta tc : listaCuentas) { %>
				<option value="<%=tc.getIdTipoCuenta()%>"><%=tc.getDescripcion()%></option> <!-- El id nose si hace falta por las dudas lo pongo -->
			<% } %>
			</select> <span class="focus"></span>
		</div>
	</div>
	<% } %>
	<br>
	</form>
	<script>
		$(document).ready(function() {
			var table = $('#movimientos').DataTable({
				language : {
					zeroRecords : "No hay resultados",
					info : "Página _PAGE_ de _PAGES_",
					infoEmpty : "No hay registros",
					infoFiltered : "(filtrada de _MAX_ registros totales)",
					search : "Buscar: "
				},
				lengthChange : false,
				data : [ {
					<% if(request.getAttribute("listaMovimientos") != null){ 
						ArrayList<Movimiento> listaMovimientos = new ArrayList<Movimiento>();
						listaMovimientos = (ArrayList<Movimiento>) request.getAttribute("listaMovimientos");
						for(Movimiento c : listaMovimientos) { %>
					"Fecha" : ,
					"Detalle" : ,
					"Tipo de Movimiento" : ,
					"CBU Cuenta destino" : ,
					"Importe" : "
					<% } %>
				<% } %>
				}, ],
				columns : [ {
					data : 'Fecha'
				}, {
					data : 'Detalle'
				}, {
					data : 'Tipo de Movimiento'
				}, {
					data : 'CBU Cuenta destino'
				}, {
					data : 'Importe'
				}, ]
			});
		});
	</script>
</head>
<body>
	<div class="container pt-5">
		<table id="movimientos" class="table table-hover nowrap">
			<thead>
				<tr>
					<th scope="col" class="text-left">Fecha</th>
					<th scope="col" class="text-left">Detalle</th>
					<th scope="col" class="text-left">Tipo de Movimiento</th>
					<th scope="col" class="text-left">CBU Cuenta destino</th>
					<th scope="col" class="text-left">Importe</th>
				</tr>
			</thead>
		</table>
	</div>
</body>

</html>