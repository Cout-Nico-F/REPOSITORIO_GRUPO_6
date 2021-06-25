<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Historial de Movimientos</title>
<%@ include file="HeaderCliente.jsp"%>
</head>
<body>

	<br>
	<br>
	<div class="titleMovimientos">Historial de Movimientos</div>
	<br>

	<div align="center">
		<label for="standard-select">Seleccione la cuenta</label>
		<div class="select">
			<select id="standard-select">
				<option value="Option 1">Caja de Ahorro</option>
				<option value="Option 2">Cuenta Corriente</option>
				<option value="Option 3">Caja de Ahorro 2</option>
			</select> <span class="focus"></span>
		</div>
	</div>
	<br>


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
					"Fecha" : "2016-05-28",
					"Detalle" : "Transferencia Abogado",
					"Tipo de Movimiento" : "Transferencia",
					"CBU Cuenta destino" : 5250000456,
					"Importe" : "$39473"
				}, {
					"Fecha" : "2015-03-18",
					"Detalle" : "Apertura de cuenta",
					"Tipo de Movimiento" : "Alta cuenta",
					"CBU Cuenta destino" : 5250445891020456,
					"Importe" : "$10000"
				}, {
					"Fecha" : "2021-05-28",
					"Detalle" : "Pago Universidad",
					"Tipo de Movimiento" : "Transferencia",
					"CBU Cuenta destino" : 52500004554686,
					"Importe" : "$10850"
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