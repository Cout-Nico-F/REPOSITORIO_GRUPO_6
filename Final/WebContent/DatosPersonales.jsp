<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos Personales</title>
<%@ include file="HeaderAdmin.jsp" %> 
</head>
<body>
      <div class="col px-2 py-4">
        <form>
          <fieldset>
            <legend class="d-flex justify-content-center">Datos Personales</legend>
            <div class="d-flex justify-content-center">
              <div class="col-sm-3"> 
                <label for="nombre" class="col-sm-3 col-form-label">Nombre</label>
                <input type="text" class="form-control" id="nombre" placeholder="Nombre">
              </div>
               <div class="col-sm-3">  
                <label for="apellido" class="col-sm-3 col-form-label">Apellido</label>
                <input type="text" class="form-control" id="apellido" placeholder="Apellido">
              </div>
            </div>
             <div class="d-flex justify-content-center">
             	<div class="col-sm-3">
              	<label for="dni" class="col-sm-3 col-form-label">DNI</label>
                <input type="number" class="form-control" id="dni" placeholder="DNI">
                </div>
              <div class="col-sm-3">   
               <label for="cuil" class="col-sm-3 col-form-label">CUIL</label>
                <input type="number" class="form-control" id="cuil" placeholder="CUIL">
              </div>
            </div>
             <div class="d-flex justify-content-center">
              <div class="col-sm-3">  
                <label for="fecha" class="col-form-label">Fecha de nacimiento</label>   
                <input type="text" class="form-control" id="fecha" placeholder="Nacimiento">
              </div>
               <div class="col-sm-3">  
                <label for="sexo" class="col-sm-4 col-form-label">Sexo</label>
                <input type="text" class="form-control" id="sexo" placeholder="Sexo">
              </div>
             </div>
             <div class="d-flex justify-content-center">
              <div class="col-sm-3"> 
                <label for="nacionalidad" class="col-sm-3 col-form-label">Nacionalidad</label>
                <input type="text" class="form-control" id="nacionalidad" placeholder="Nacionalidad">     	
              </div>
                <div class="col-sm-3">   
                <label for="provincia" class="col-sm-3 col-form-label">Provincia</label>   
                <input type="text" class="form-control" id="provincia" placeholder="Provincia">
              </div>
            </div>
            <div class="d-flex justify-content-center">
                <div class="col-sm-3">    
                <label for="localidad" class="col-sm-3 col-form-label">Localidad</label>  
               	<input type="text" class="form-control" id="localidad" placeholder="Localidad">
              </div>
              <div class="col-sm-3">
               <label for="telefono" class="col-sm-3 col-form-label">Teléfono</label>      
                <input type="number" class="form-control" id="telefono" placeholder="Teléfono">
              </div>
            </div>
            <div class="d-flex justify-content-center">
              <div class="col-sm-6">      
                <label for="correo" class="col-sm-3 col-form-label">E-mail</label>	
                <input type="email" class="form-control" id=correo placeholder="Correo electrónico">
              </div>
              </div>
             <div class="d-flex justify-content-center">
              <div class="col-sm-3">   
               <label for="usuario" class="col-sm-3 col-form-label">Usuario</label>   
                <input type="text" class="form-control" id="usuario" placeholder="Usuario">
              </div>
              <div class="col-sm-3">      
               <label for="contrasena" class="col-sm-3 col-form-label">Contraseña</label>
                <input type="password" class="form-control" id="contrasena" placeholder="Contraseña">
              </div>
            </div>
          </fieldset>
        </form>
      </div>
</body>
</html>