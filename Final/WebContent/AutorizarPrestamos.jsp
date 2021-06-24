<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Autorización de Prestamos</title>
<link href="recursos/style-AutorizacionPrestamos.css" rel="stylesheet"
	type="text/css">
<%@ include file="HeaderAdmin.jsp"%>
</head>
<body>

	<br>
	<br>
	<div class="titlePrestamos">Autorización de Prestamos</div>
	<br>
	<div class="table-responsive">
		<table class="table">
			<thead>
				<tr>
					<th scope="col" class="text-center">Usuario</th>
					<th scope="col" class="text-center">Nombre</th>
					<th scope="col" class="text-center">Apellido</th>
					<th scope="col" class="text-center">DNI</th>
					<th scope="col" class="text-center">Fecha</th>
					<th scope="col" class="text-center">Importe Solicitado</th>
					<th scope="col" class="text-center">Cuotas</th>
					<th scope="col" class="text-center">Importe mensual</th>
					<th scope="col" class="text-center">Acciones</th>
				</tr>
			</thead>
			<tbody>
<!-- 			acá iría un foreach -->
				<tr>
					<th>pedro2020</th>
					<th>Pedro</th>
					<th>Gonzalez</th>
					<th>11.111.111</th>
					<th>24/08/2020</th>
					<th>$20.000</th>
					<th>6</th>
					<th>$4.000</th>
					<th><div class="btn-group" role="group"
							aria-label="Basic mixed styles example">
							<button type="button" class="btn btn-success">Autorizar</button>
							<button type="button" class="btn btn-danger">Denegar</button>
						</div></th>
				</tr>
				
								<tr>
					<th>pedro2020</th>
					<th>Pedro</th>
					<th>Gonzalez</th>
					<th>11.111.111</th>
					<th>24/08/2020</th>
					<th>$20.000</th>
					<th>6</th>
					<th>$4.000</th>
					<th><div class="btn-group" role="group"
							aria-label="Basic mixed styles example">
							<button type="button" class="btn btn-success">Autorizar</button>
							<button type="button" class="btn btn-danger">Denegar</button>
						</div></th>
				</tr>
				
								<tr>
					<th>pedro2020</th>
					<th>Pedro</th>
					<th>Gonzalez</th>
					<th>11.111.111</th>
					<th>24/08/2020</th>
					<th>$20.000</th>
					<th>6</th>
					<th>$4.000</th>
					<th><div class="btn-group" role="group"
							aria-label="Basic mixed styles example">
							<button type="button" class="btn btn-success">Autorizar</button>
							<button type="button" class="btn btn-danger">Denegar</button>
						</div></th>
				</tr>
				
								<tr>
					<th>pedro2020</th>
					<th>Pedro</th>
					<th>Gonzalez</th>
					<th>11.111.111</th>
					<th>24/08/2020</th>
					<th>$20.000</th>
					<th>6</th>
					<th>$4.000</th>
					<th><div class="btn-group" role="group"
							aria-label="Basic mixed styles example">
							<button type="button" class="btn btn-success">Autorizar</button>
							<button type="button" class="btn btn-danger">Denegar</button>
						</div></th>
				</tr>

			</tbody>
		</table>
	</div>

</body>
</html>