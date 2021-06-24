<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Historial de Movimientos</title>
<link href="recursos/style-movimientos.css" rel="stylesheet" type="text/css">
<%@ include file="HeaderCliente.jsp" %> 
</head>
<body>

	<br>
	<br>
	<div class="titleMovimientos">Historial de Movimientos</div>
	<br>

	<div class="dropdown">
		<button class="btn btn-secondary dropdown-toggle" type="button"
			id="dropdownMenuButton1" data-bs-toggle="dropdown"
			aria-expanded="false"> Seleccione su cuenta </button>
		<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
			<li><a class="dropdown-item" href="HistorialMovimientos.jsp">Caja de Ahorro</a></li>
			<li><a class="dropdown-item" href="HistorialMovimientos.jsp">Cuenta Corriente</a></li>
			<li><a class="dropdown-item" href="HistorialMovimientos.jsp">Caja de Ahorro 2</a></li>
		</ul>
	</div>

	<div class="table-responsive">
		<table class="table">
			<thead>
				<tr>
					<th scope="col" class="text-center">Fecha</th>
					<th scope="col" class="text-center">Detalle</th>
					<th scope="col" class="text-center">Tipo de Movimiento</th>
					<th scope="col" class="text-center">CBU Cuenta destino</th>
					<th scope="col" class="text-center">Importe</th>
				</tr>
			</thead>
			<tbody>
				<!-- acá cargaríamos c/ cliente con un foreach -->
				<tr>
					<th>24/08/2020</th>
					<th>Pago Servicio Telecentro</th>
					<th>Transferencia</th>
					<th>02900001-00000000058382</th>
					<th>1.750</th>
				</tr>

				<tr>
					<th>22/11/2020</th>
					<th>Pago Honorarios Programador</th>
					<th>Transferencia</th>
					<th>02900001-00000000058382</th>
					<th>100.000.000</th>
				</tr>


				<tr>
					<th>05/01/2021</th>
					<th>Prestamo Personal Nro:1</th>
					<th>Pago de Prestamo</th>
					<th>02900001-00000000058382</th>
					<th>1.750</th>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>