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

	<br><br>
	
	<div class="titleMovimientos">Historial de Movimientos</div>
	<br>
	<form action="ServletHistorialMovimientos" method="post"> 
	<div align="center">
		<label for="standard-select">Seleccione la cuenta</label>
		<div class="select"> 
			<select id="standard-select" name="slMostrar">
		 <% if(request.getAttribute("listaTiposCta") != null){
			ArrayList<TipoDeCuenta> listaCuentas = new ArrayList<TipoDeCuenta>();
			listaCuentas = (ArrayList<TipoDeCuenta>) request.getAttribute("listaTiposCta");
			 for(TipoDeCuenta tc : listaCuentas) { %>
				<option value="<%=tc.getIdTipoCuenta() %>"><%=tc.getDescripcion() %></option> <!-- El id nose si hace falta por las dudas lo pongo -->
			<% } %>
			<% } 
		 	else { %>
				<option value="1">No hay opciones</option>
			<% } %>
			</select> 
		</div>
	</div>
	</form>
	
	<br>
	<form method="post" action="ServletHistorialMovimientos"> 
	<div class="col px-4 py-2">
        <table id="clientes" class="table table-hover nowrap">
          <thead>
            <tr>
              <th scope="col" class="text-center">Fecha</th>
              <th scope="col" class="text-center">Detalle</th>
              <th scope="col" class="text-center">Tipo Movimiento</th>
              <th scope="col" class="text-center">CBU cuenta destino</th>
              <th scope="col" class="text-center">Importe</th>
            </tr>
          </thead>
            <tbody>
            <%if(request.getAttribute("listaMov") != null) { 
            	ArrayList<Movimiento> listaMov = new ArrayList<Movimiento>(); 
            	listaMov = (ArrayList<Movimiento>) request.getAttribute("listaMov"); 
            	for(Movimiento m : listaMov) { %>
            <tr>
            	<td><%=m.getFechaMovimiento() %></td>
            	<td><%=m.getDetalle() %></td>
            	<td><%=m.getTipoDeMovimiento().getDescripcion() %></td>
            	<td><%=m.getIDCuentaDestino() %></td>
            	<td><%=m.getImporte() %>
            <tr>
            <% } %>
            <% } %>
      		</tbody>
      	</table>
      </div>
      </form>
</body>

</html>