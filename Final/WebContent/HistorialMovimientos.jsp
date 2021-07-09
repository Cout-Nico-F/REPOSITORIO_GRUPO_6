
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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

	<script>
	  $(document).ready(function() {
	        var table = $('#clientes').DataTable( {
	            language: {
	            	"decimal":        "",
	                "emptyTable":     "No hay información disponible en la tabla",
	                "info":           "Mostrando _START_ a _END_ de _TOTAL_ registros",
	                "infoEmpty":      "Mostrando 0 a 0 de 0 registro(s)",
	                "infoFiltered":   "(filtrado de _MAX_ registros totales)",
	                "infoPostFix":    "",
	                "thousands":      ".",
	                "loadingRecords": "Cargando...",
	                "processing":     "Procesando...",
	                "search":         "Buscar:",
	                "zeroRecords":    "No se encontraron resultados",
	                "paginate": {
	                    "first":      "Primera",
	                    "last":       "Última",
	                    "next":       "Siguiente",
	                    "previous":   "Anterior"
	                }
	            },
	            lengthChange: false
	        });
		});
	</script>

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
			 		<option label="<%=c.getTipoDeCuenta().getDescripcion()%> - <%=c.getNumeroCuenta()%>" value="<%=c.getNumeroCuenta() %>" selected><%=c.getTipoDeCuenta().getDescripcion() %> - <%=c.getNumeroCuenta() %></option>
			 	<% 
			 	} else {
			 	%>
				<option label="<%=c.getTipoDeCuenta().getDescripcion()%> - <%=c.getNumeroCuenta()%>"  value="<%=c.getNumeroCuenta() %>"><%=c.getTipoDeCuenta().getDescripcion() %> - <%=c.getNumeroCuenta() %></option> <!-- El id nose si hace falta por las dudas lo pongo -->
			 	<%}
			 } %>
			<% } 
		 	else { %>
				<option value="1">No hay opciones</option>
			<% } %>
			</select> <span class="focus"></span>
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
            	//El warning es por que en tiempo de ejecucion el compilador no sabe si realmente exista un objeto de tipo movimiento
            	//hasta que se cree por lo tanto si getAttribute() no devuelve un ArrayList entonces se lanzara una ClassCastException
            	try{
            		listaMov = ((ArrayList<Movimiento>) request.getAttribute("listaMov")); 
            	}
            	catch(ClassCastException e){
            		e.printStackTrace();
            	}
            	
            	for(Movimiento m : listaMov) { %>
            <tr>
            	<td class="dt-body-center"><%=m.getFechaMovimiento() %> </td>
            	<td class="dt-body-center"><%=m.getDetalle() %></td>
            	<td class="dt-body-center"><%=m.getTipoDeMovimiento().getDescripcion() %></td>
            	<td class="dt-body-center"><%=m.getIDCuentaDestino() %></td>
            	<td class="dt-body-center"><%=m.getImporte() %></td>
            <tr>
            	<% } %>
            <% } %>
      		</tbody>
      	</table>
      </div>
</body>

</html>