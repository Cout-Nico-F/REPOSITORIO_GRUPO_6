<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="recursos/style-movimientos.css" rel="stylesheet" type="text/css">
<link href="recursos/style-select.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@4.5.2/dist/lux/bootstrap.min.css" integrity="undefined" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css"/>
<link rel="icon" href="img/icon.png"><script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="undefined" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
<script>
	$(function() {
		$('.nav-link').each(function() {
			var isActive = this.pathname === location.pathname;
			$(this).toggleClass('active', isActive);
		});
	});
</script>
<nav class="navbar sticky-top navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Banco</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor03" aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarColor03">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="Clientes">ABML Clientes</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="ServletABMLCuentas?firstLoad=1">ABML Cuentas</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="AutorizarPrestamos.jsp">Autorización de préstamos</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="VistaAdmin.jsp">Reportes</a>
        </li>
      </ul>
      <div class="ml-auto">
       <span>Usuario banco</span>
       <button type="button" class="btn btn-secondary">Cerrar sesión</button>
       </div>
    </div>
  </div>
</nav>

