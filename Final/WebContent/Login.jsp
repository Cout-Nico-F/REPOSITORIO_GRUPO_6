<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Iniciar Sesion</title>
<link href="recursos/style-login.css" rel="stylesheet" type="text/css">
<%@ include file="HeaderCliente.jsp" %>
</head>
<body>

	<style>
		img{
			width: 100%;
			height: 100%;
		}
	</style>

        <form action="servletLogin" method="post">
         
          <fieldset>
           	
          <div class="d-flex bd-highlight">
          
          		<div class="p-4 flex-grow-1 bd-highlight">	
          			<img src="https://debmedia.com/blog/wp-content/uploads/2020/06/20-05-1-Oportunidades-para-mejorar-la-atenci%C3%B3n-al-cliente-en-un-banco-despu%C3%A9s-de-la-pandemia-pre.jpg" >
          		</div>
         	
         <div class="p-4 bd-highlight">
         	
 		<% if(request.getAttribute("tipoMensaje") != null && session.getAttribute("mensaje") != null){ %>	<!-- Son 2 strings podria hacer isEmpty() -->
 		<div class="alert alert-<%=request.getAttribute("tipoMensaje")%> alert-dismissible fade show" role="alert">
  			<strong><%=session.getAttribute("mensaje") %></strong>
		</div>
		<% session.removeAttribute("mensaje");} %>
		
         	 <h2 class="d-flex justify-content-center py-4">Iniciar Sesion</h2>
          	
          	
            <div class="row">
              	 <label for="nombre" class="col-sm-12 col-form-label">Nombre de usuario</label>
               	 <input type="text" class="form-control" id="nombre" placeholder="Nombre" name="txtNombreUsuario">
              </div>
              
             <div class="row"> 
                <label for="apellido" class="col-sm-3 col-form-label">Contraseña</label>
                <input type="password" class="form-control" id="apellido" placeholder="Contraseña" name="txtContrasenia">
            </div>
            
            <div class="row py-4">
            		<input type="submit" value="Loguearse" name="btnLogin" class="btn btn-info">
            </div>
            
            </div>
            </div>

           </fieldset>
         </form>
       

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.esm.min.js"></script>

</body>
</html>