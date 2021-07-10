<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "entidad.Cliente" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos Personales</title>
<%@ include file="HeaderCliente.jsp" %> 
</head>
<body>
	<br><br><br>
      <div class="col px-2 py-4">
          <fieldset>
          <!--  Fijarme si alguno es opcional o null en la base de datos y no mostrarlo en caso de que sea null -->
          <!--  Los type tendrian que ser todos de tipo text pero no afecta aca asi que lo dejo asi -->
          <% if(request.getAttribute("DatosCliente") != null) { 
          	Cliente cli = (Cliente)request.getAttribute("DatosCliente"); %>
            <legend class="d-flex justify-content-center">Datos Personales</legend>
            <div class="d-flex justify-content-center">
              <div class="col-sm-3"> 
                <label for="nombre" class="col-sm-3 col-form-label">Nombre</label>
                <input type="text" class="form-control" id="nombre" placeholder="nombre" value="<%=cli.getNombre() %>"> <!--  Dejo el placeholder nose porque -->
              </div>
               <div class="col-sm-3">  
                <label for="apellido" class="col-sm-3 col-form-label">Apellido</label>
                <input type="text" class="form-control" id="apellido" placeholder="Apellido" value="<%=cli.getApellido() %>">
              </div>
            </div>
             <div class="d-flex justify-content-center">
             	<div class="col-sm-3">
              	<label for="dni" class="col-sm-3 col-form-label">DNI</label>
                <input type="number" class="form-control" id="dni" placeholder="DNI" value="<%=cli.getDni() %>">
                </div>
              <div class="col-sm-3">   
               <label for="cuil" class="col-sm-3 col-form-label">CUIL</label>
                <input type="number" class="form-control" id="cuil" placeholder="CUIL" value="<%=cli.getCuil() %>">
              </div>
            </div>
             <div class="d-flex justify-content-center">
              <div class="col-sm-3">  
                <label for="fecha" class="col-form-label">Fecha de nacimiento</label>   
                <input type="text" class="form-control" id="fecha" placeholder="Nacimiento" value="<%=cli.getFechaNacimiento() %>">
              </div>
               <div class="col-sm-3">  
                <label for="sexo" class="col-sm-4 col-form-label">Sexo</label>
                <input type="text" class="form-control" id="sexo" placeholder="Sexo" value="<%=cli.getSexo() %>">
              </div>
             </div>
             <div class="d-flex justify-content-center">
              <div class="col-sm-3"> 
                <label for="nacionalidad" class="col-sm-3 col-form-label">Nacionalidad</label>
                <input type="text" class="form-control" id="nacionalidad" placeholder="Nacionalidad" value="<%=cli.getNacionalidad().getNombre() %>">     	
              </div>
                <div class="col-sm-3">   
                <label for="provincia" class="col-sm-3 col-form-label">Provincia</label>   
                <input type="text" class="form-control" id="provincia" placeholder="Provincia" value="<%=cli.getLocalidad().getProvincia().getNombre() %>">
              </div>
            </div>
            <div class="d-flex justify-content-center">
                <div class="col-sm-3">    
                <label for="localidad" class="col-sm-3 col-form-label">Localidad</label>  
               	<input type="text" class="form-control" id="localidad" placeholder="Localidad" value="<%=cli.getLocalidad().getNombre() %>">
              </div>
              <div class="col-sm-3">
               <label for="telefono" class="col-sm-3 col-form-label">Teléfono</label>      
                <input type="number" class="form-control" id="telefono" placeholder="Teléfono" value="<%=cli.getTelefonoFijo() %>">
              </div>
            </div>
            <div class="d-flex justify-content-center">
              <div class="col-sm-6">      
                <label for="correo" class="col-sm-3 col-form-label">E-mail</label>	
                <input type="email" class="form-control" id=correo placeholder="Correo electrónico" value="<%=cli.getCorreoElectronico() %>">
              </div>
              </div>
             <div class="d-flex justify-content-center">
              <div class="col-sm-3">   
               <label for="usuario" class="col-sm-3 col-form-label">Usuario</label>   
                <input type="text" class="form-control" id="usuario" placeholder="Usuario" value="<%=cli.getUsuario().getNombreUsuario() %>">
              </div>
              <div class="col-sm-3">      
               <label for="contrasena" class="col-sm-3 col-form-label">Contraseña</label>
                <input type="text" class="form-control" id="contrasena" placeholder="Contraseña" value="<%=cli.getUsuario().getContrasenia() %>">
              </div>
            </div>
            <% }  else { %>
            	<div class="col-sm-3">      
              		 <label for="contrasena" class="col-sm-3 col-form-label">Contraseña</label>
                <input type="text" class="form-control" id="contrasena" placeholder="Contraseña">
              </div>
            <% } %>
          </fieldset>
      </div>
</body>
</html>