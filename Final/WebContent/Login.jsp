<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Iniciar Sesion</title>
<link href="recursos/style-login.css" rel="stylesheet" type="text/css">
<%@ include file="HeaderCliente.jsp" %>
</head>
<body>

 	<div class="col px-2 py-4">
 		<div class="d-flex justify-content-center">
 		
 		<% if(request.getAttribute("tipoMensaje") != null && session.getAttribute("mensaje") != null){ %>	<!-- Son 2 strings podria hacer isEmpty() -->
 		<div class="alert alert-<%=request.getAttribute("tipoMensaje")%> alert-dismissible fade show" role="alert">
  			<strong><%=session.getAttribute("mensaje") %></strong>
  			
		</div>
		<% session.removeAttribute("mensaje"); } %>
 		</div>
 		
        <form action="servletLogin" method="post">
          <fieldset>
            <legend class="d-flex justify-content-center">Iniciar Sesion</legend>
            <div class="d-flex justify-content-center">
              <div class="col-sm-6"> 
               	 <label for="nombre" class="col-sm-3 col-form-label">Nombre de usuario</label>
               	 <input type="text" class="form-control" id="nombre" placeholder="Nombre" name="txtNombreUsuario">
               </div>
              </div>
             <div class="d-flex justify-content-center">
               <div class="col-sm-6">  
                <label for="apellido" class="col-sm-3 col-form-label">Contrasenia</label>
                <input type="text" class="form-control" id="apellido" placeholder="Apellido" name="txtContrasenia">
              </div>
            </div>
            <div class="d-flex justify-content-center">
            	<div class="col-sm-1 py-4">
            		<input type="submit" value="Loguearse" name="btnLogin" class="btn btn-info">
            	</div>
            </div>
           </fieldset>
         </form>
       </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.esm.min.js"></script>

</body>
</html>