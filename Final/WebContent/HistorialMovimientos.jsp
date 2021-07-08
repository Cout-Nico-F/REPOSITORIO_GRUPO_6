
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import = "entidad.Cuenta" %>
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
	<form action="ServletHistorialMovimientos" method="get"> 
	<div align="center">
		<label for="standard-select">Seleccione la cuenta</label>
		<div class="select"> 
			<select id="standard-select" name="slvalue" onchange="this.form.submit()">
		 <% if(request.getAttribute("listaTiposCta") != null){
			ArrayList<Cuenta> listaCuentas = new ArrayList<Cuenta>();
			listaCuentas = (ArrayList<Cuenta>) request.getAttribute("listaTiposCta");
			 for(Cuenta c : listaCuentas) { 
			 	if(c.getNumeroCuenta().equals(request.getParameter("slvalue")))
			 	{
			 	%>
			 		<option value="<%=c.getNumeroCuenta() %>" selected><%=c.getTipoDeCuenta().getDescripcion() %> - <%=c.getNumeroCuenta() %></option>
			 	<% 
			 	} else {
			 	%>
				<option value="<%=c.getNumeroCuenta() %>"><%=c.getTipoDeCuenta().getDescripcion() %> - <%=c.getNumeroCuenta() %></option> <!-- El id nose si hace falta por las dudas lo pongo -->
			 	<%}
			 } %>
			<% } 
		 	else { %>
				<option value="1">No hay opciones</option>
			<% } %>
			</select> <span class="focus"></span>
			<input type="hidden" name="selectedValue" value="0"/>  
		</div>
	</div>
	</form>
	
	<br>
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
            	<td>Fecha: <%=new java.sql.Date(m.getFechaMovimiento().getTime()) %></td>
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
</body>

</html>