<%@page import="entidad.Prestamo"%>
<%@page import = "java.util.ArrayList" %>
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
<script>
    $(document).ready(function() {
        var table = $('#prestamos').DataTable( {
        	processing: true,
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
            lengthChange: false,
            columnDefs: [
                {
                    targets: [4, 5, 6],
                    className: 'dt-body-right'
                }
              ]
        } );
        <% if(request.getAttribute("mensaje") != null){ %>
	 		$('.toast-body').html('<span><%=request.getAttribute("mensaje") %></span><button class="btn" type="button" data-bs-dismiss="toast"><i class="bi bi-x-lg"></i></button>')
	        $('.toast').toast('show');
	 		<% } %>
 		$(document).on("click", ".abrir-modal", function () {
 			var accion = $(this).data("accion")
 			var mensaje = "¿Está seguro de que desea " + accion + " este préstamo?"
 	    	$('input[name="accion"]').val(accion)
 		    $(".modal-body").html(mensaje)
 		});
    });
    
    function submitForm() {
        $("#form").submit()
    }
    </script>
</head>
<body>
 <div class="toast" style="left: 50%; position: fixed; transform: translate(-50%, 0px); z-index: 9999;" data-bs-autohide="false">
      <div class="toast-body"></div>
  </div>
	<div class="modal fade" id="modal" tabindex="-1" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-body"></div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
	        <button type="button" class="btn btn-primary" onclick="submitForm()">Guardar cambios</button>
	      </div>
	    </div>
	  </div>
	</div>
<div style="min-height: inherit;">
		<br>
		<br>
	<div class="titlePrestamos">Autorización de Prestamos</div>
	<br>
	 <table id="prestamos" class="table table-hover nowrap">
          <thead>
            <tr>
					<th scope="col" class="text-center">Nombre</th>
					<th scope="col" class="text-center">Apellido</th>
					<th scope="col" class="text-center">DNI</th>
					<th scope="col" class="text-center">Fecha de Solicitud</th>
					<th scope="col" class="text-center">Importe Solicitado</th>
					<th scope="col" class="text-center">Cuotas</th>
					<th scope="col" class="text-center">Importe mensual</th>
					<th scope="col" class="text-center">Acciones</th>
            </tr>
          </thead>
            <tbody>
     <%  
     ArrayList<Prestamo> prestamos = (ArrayList<Prestamo>) request.getAttribute("prestamos");
     if(prestamos != null && !prestamos.isEmpty())
		for(Prestamo p : prestamos) 
		{
	%>
	<tr>
      <form id="form" action="AutorizacionPrestamos" method="post">
      <input type="hidden" name="accion">
		 <input type="hidden" name="idPrestamo" value="<%=p.getIdPrestamo()%>">
		 <input type="hidden" name="fecha" value="<%=p.getFecha()%>">
		 <input type="hidden" name="cuotas" value="<%=p.getCuotas()%>">
		 <input type="hidden" name="montoMensual" value="<%=p.getMontoMensual()%>">
	     <td class="text-center"><%=p.getFecha()%></td>
	     <td><%=p.getImporteSolicitado()%></td>
	     <td><%=p.getCuotas()%></td>
	     <td><%=p.getMontoMensual()%></td>
	     <td class="text-center">
	     <button type="button" class="btn btn-success abrir-modal" data-bs-toggle="modal" data-bs-target="#modal" data-accion="autorizar">Autorizar</button>
		<button type="button" class="btn btn-danger abrir-modal" data-bs-toggle="modal" data-bs-target="#modal" data-accion="denegar">Denegar</button>
		</td>     
      </form>
	</tr>
	<%  } %>
  </tbody>
        </table>  
        </div>
</body>
</html>