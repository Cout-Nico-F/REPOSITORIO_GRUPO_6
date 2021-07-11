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
	<style>
		@import url('https://fonts.googleapis.com/css2?family=Otomanopee+One&display=swap');
		h2 {
			font-family: 'Otomanopee One', sans-serif;
		}
	</style>

	<br><br><br>
      <div class="col px-2 py-4">
          <fieldset>
          <!--  Fijarme si alguno es opcional o null en la base de datos y no mostrarlo en caso de que sea null -->
          <!--  Los type tendrian que ser todos de tipo text pero no afecta aca asi que lo dejo asi -->
          <% if(request.getAttribute("DatosCliente") != null) { 
          	Cliente cli = (Cliente)request.getAttribute("DatosCliente"); %>
            <h2 class="d-flex justify-content-center py-3">Datos Personales</h2>
              <div class="row g-3">
              	<div class="col"> 
                <label for="nombre" class="col-sm-3 col-form-label">Nombre</label>
                <input type="text" class="form-control" id="nombre" placeholder="nombre" value="<%=cli.getNombre() %>" disabled readonly oncopy="return false;"> <!--  Dejo el placeholder nose porque -->
               	</div> 
               <div class="col">  
                <label for="apellido" class="col-sm-3 col-form-label">Apellido</label>
                <input type="text" class="form-control" id="apellido" placeholder="Apellido" value="<%=cli.getApellido() %>" disabled readonly oncopy="return false;">
              </div>
              </div>
             <div class="row g-3">
             	<div class="col">
              	<label for="dni" class="col-sm-3 col-form-label">DNI</label>
                <input type="text" class="form-control" id="dni" placeholder="DNI" value="<%=cli.getDni() %>" disabled readonly oncopy="return false;">
                </div>
              <div class="col">   
               <label for="cuil" class="col-sm-3 col-form-label">CUIL</label>
                <input type="text" class="form-control" id="cuil" placeholder="CUIL" value="<%=cli.getCuil() %>" disabled readonly oncopy="return false;">
              </div>
            </div>
             <div class="row g-3">
              <div class="col">  
                <label for="fecha" class="col-form-label">Fecha de nacimiento</label>   
                <input type="text" class="form-control" id="fecha" placeholder="Nacimiento" value="<%=cli.getFechaNacimiento() %>" disabled readonly oncopy="return false;">
              </div>
               <div class="col">  
                <label for="sexo" class="col-sm-4 col-form-label">Sexo</label>
                <input type="text" class="form-control" id="sexo" placeholder="Sexo" value="<%=cli.getSexo() %>" disabled readonly oncopy="return false;">
              </div>
             </div>
             <div class="row g-3">
              <div class="col"> 
                <label for="nacionalidad" class="col-sm-3 col-form-label">Nacionalidad</label>
                <input type="text" class="form-control" id="nacionalidad" placeholder="Nacionalidad" value="<%=cli.getNacionalidad().getNombre() %>" disabled readonly oncopy="return false;">     	
              </div>
                <div class="col">   
                <label for="provincia" class="col-sm-3 col-form-label">Provincia</label>   
                <input type="text" class="form-control" id="provincia" placeholder="Provincia" value="<%=cli.getLocalidad().getProvincia().getNombre() %>" disabled readonly oncopy="return false;">
              </div>
            </div>
            <div class="row g-3">
                <div class="col">    
                <label for="localidad" class="col-sm-3 col-form-label">Localidad</label>  
               	<input type="text" class="form-control" id="localidad" placeholder="Localidad" value="<%=cli.getLocalidad().getNombre() %>" disabled readonly oncopy="return false;">
              </div>
              <div class="col">
               <label for="telefono" class="col-sm-3 col-form-label">Teléfono</label>      
                <input type="text" class="form-control" id="telefono" placeholder="Teléfono" value="<%=cli.getTelefonoFijo() %>" disabled readonly oncopy="return false;">
              </div>
            </div>
            <div class="row g-3">
              <div class="col">      
                <label for="correo" class="col-sm-6 col-form-label">E-mail</label>	
                <input type="text" class="form-control" id=correo placeholder="Correo electrónico" value="<%=cli.getCorreoElectronico() %>" disabled readonly oncopy="return false;">
              </div>
              </div>
             <div class="row g-3">
              <div class="col">   
               <label for="usuario" class="col-sm-3 col-form-label">Usuario</label>   
                <input type="text" class="form-control" id="usuario" placeholder="Usuario" value="<%=cli.getUsuario().getNombreUsuario() %>" disabled readonly oncopy="return false;">
              </div>
              <div class="col">      
               <label for="contrasena" class="col-sm-3 col-form-label">Contraseña</label>
                <input type="text" class="form-control" id="contrasena" placeholder="Contraseña" value="<%=cli.getUsuario().getContrasenia() %>" disabled readonly oncopy="return false;">
              </div>
            </div>
            <% }  else { %>
            	<div class="d-flex justify-content-center py-4">      
              		<h1> Inicie Sesion pls :)</h1>
              </div>
            <% } %>
          </fieldset>
      </div>
</body>
</html>