<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="entidad.Prestamo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  
    <title>Pagar un préstamo</title>    
    <%@ include file="HeaderCliente.jsp" %>
    
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
        } );
        <% if(request.getAttribute("msjTituloModal") != null){ %>
	 		$('.toast-body').html('<span><%=request.getAttribute("msjModal") %></span><button class="btn" type="button" data-bs-dismiss="toast"><i class="bi bi-x-lg"></i></button>')
	        $('.toast-header').html('<span><%=request.getAttribute("msjTituloModal") %></span><button class="btn" type="button" data-bs-dismiss="toast"><i class="bi bi-x-lg"></i></button>')
	 		$('.toast').toast('show');
	 		<% } %>
 		$(document).on("click", ".abrir-modal", function () {
 			var accion = $(this).data("accion")
 			var mensaje = "¿Está seguro de que desea " + accion + " esta cuenta?"
 	    	$('input[name="accion"]').val(accion)
 		    $(".modal-body").html(mensaje)
 		});
    });
    
    function submitForm() {
    	if("eliminar" == $('input[name="accion"]').val()){
        	$("#formPost").submit()
    	}
    	else if("asignar" == $('input[name="accion"]').val()){
    		$("#formGet").submit()
        }
    }
    </script>  
  </head>
  
  <body>
  <br>
  
        <table id="clientes" class="table table-hover nowrap">
          <thead>
            <tr>
              <th scope="col" class="text-center">Fecha de vencimiento</th>
              <th scope="col" class="text-center">Valor de cuota</th>
              <th scope="col" class="text-center">Total prestamo</th>
              <th scope="col" class="text-center">Plazo de pago (meses)</th>
              <th scope="col" class="text-center">Total saldo préstamo</th>
              <th scope="col" class="text-center">Número de cuota</th>
              <th scope="col" class="text-center">Cuenta a debitar</th>
              <th scope="col" class="text-center">Pagar cuota</th>
              <th scope="col" class="text-center">Pago total</th>
              
            </tr>
          </thead>
          <tbody>
          <% ArrayList<Prestamo> listaPrestamos = null;
          if (request.getAttribute("listaPrestamos") != null){
        	  listaPrestamos = (ArrayList<Prestamo>)request.getAttribute("listaPrestamos");
          }
          if(listaPrestamos != null) {
        	  
          for(Prestamo p : listaPrestamos){
        	  
        	  %>
        	  <h1>Cuotas a vencer</h1>
        	  
        	  <form id="formPost" action="ServletPagarPrestamo" method="post">
        	  <td class="dt-body-center"><input type="hidden" name="nroCuenta"></td>
			  <td class="dt-body-right"><%=p.getMontoMensual()%>  </td>
			  <td ><%=p.getImporteSolicitado()%></td>
			  <td class="dt-body-center"> <%=p.getCantCuotas() %></td>
			  <td ></td>
			  <td class="dt-body-center"></td>
			  <td></td>
			  <td class="dt-body-center"><div class="form-check">
			  <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
			</div></td>
			<td class="dt-body-center"><div class="form-check">
			  <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
			</div></td>
        	  
        	  
        	  
        	  </form>
          <%} 
          }
          %>
          
          
          
          
          </tbody>
        </table>
  </body>
</html>