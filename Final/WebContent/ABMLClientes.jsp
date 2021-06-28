<%@page import = "entidad.Cliente" %>
<%@page import = "java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>ABML Clientes</title>
    <%@ include file="HeaderAdmin.jsp" %>  
    <script>
    $(document).ready(function() {
        var table = $('#clientes').DataTable( {
            language: {
                zeroRecords: "No hay resultados",
                info: "Página _PAGE_ de _PAGES_",
                infoEmpty: "No hay registros",
                infoFiltered: "(filtrada de _MAX_ registros totales)",
                search: "Buscar: "
            },
            lengthChange: false,
            data: [
            	 <% ArrayList<Cliente> listaCli = null;
             	if(request.getAttribute("listaClientes") != null) { 
             		listaCli = (ArrayList<Cliente>) request.getAttribute("listaClientes"); //La advertencia puede ser porque Cliente va con minuscula
            	  for(Cliente cli : listaCli) { %>
            		  {
            		    "dni": "1231231", //Pense que no se cargaba la lista pero tampoco me deja agregarlo a mano
            		    "nombre y apellido": <%= cli.getApellido() + "," +  cli.getNombre() %>,
            		    "direccion": <%= cli.getDireccion() %>,
            		    "correo electronico": <%= cli.getCorreoElectronico() %>,
            		  },
            		],
            		<% } %>
            	<% } %>
            columns: [
                {
                    data: 'dni'
                },
                {
                    data: 'nombre y apellido'
                },
                {
                    data: 'direccion'
                },
                {
                	data: 'correo electronico'
                },
                {
                	data: null,
               	 	render: function ( data, type, row ) {
                        return '<div class="text-center"v><button class="btn"><i class="bi bi-info-lg"></i></button><button class="btn"><i class="bi bi-pencil-fill"></i></button><button class="btn"><i class="bi bi-trash-fill"></i></button></div>'
                    }
                }
            ]
        } );
     );
    }
    </script>
  </head>
  <body>
    <div class="row">
    <% if(request.getAttribute("mensajeModal") != null) { %>
    		<%=request.getAttribute("mensajeModal") %>
    <% } %>
      <div class="col  px-4 py-2">
        <form method="post" action="servletClientes">
          <fieldset>
            <legend>Nuevo cliente</legend>
            <div class="form-group row my-2">
              <label for="nombre" class="col-sm-3 col-form-label">Nombre</label>
              <div class="col-sm-9">      
                <input type="text" class="form-control" id="nombre" placeholder="Ingrese el nombre" name="txtNombre">
              </div>
            </div>
             <div class="form-group row my-2">
              <label for="apellido" class="col-sm-3 col-form-label">Apellido</label>
              <div class="col-sm-9">      
                <input type="text" class="form-control" id="apellido" placeholder="Ingrese el apellido" name="txtApellido">
              </div>
            </div>
             <div class="form-group row my-2">
              <label for="dni" class="col-sm-3 col-form-label">DNI</label>
              <div class="col-sm-9">      
                <input type="number" class="form-control" id="dni" placeholder="Ingrese el DNI" name="txtDni">
              </div>
            </div>
             <div class="form-group row my-2">
              <label for="cuil" class="col-sm-3 col-form-label">CUIL</label>
              <div class="col-sm-9">      
                <input type="number" class="form-control" id="cuil" placeholder="Ingrese el CUIL" name="txtCuil">
              </div>
            </div>
            <div class="form-group row my-2">
              <label for="fecha" class="col-sm-3 col-form-label">Fecha de nacimiento</label>
              <div class="col-sm-9">      
                <input type="date" class="form-control" id="fecha" value="2000-01-01" name="txtNacimiento">
              </div>
            </div>
            <div class="form-group row my-2">
              <label for="sexo" class="col-sm-3 col-form-label">Sexo</label>
                <div class="col-sm-9">      
                <select class="form-control" id="sexo" name="SLSexo">
                <option>Femenino</option>
                <option>Masculino</option>
              </select>
              </div>
            </div>
             <div class="form-group row my-2">
              <label for="nacionalidad" class="col-sm-3 col-form-label">Nacionalidad</label>
                <div class="col-sm-9">      
                <select class="form-control" id="nacionalidad" name="SLNacionalidad">
                <option>Argentina</option>
                <option>Otra</option>
              </select>
              </div>
            </div>
             <div class="form-group row my-2">
              <label for="provincia" class="col-sm-3 col-form-label">Provincia</label>
                <div class="col-sm-9">      
                <select class="form-control" id="provincia" name="SLProvincia">
                <option>Buenos Aires</option>
 				<option>Capital Federal</option>
                <option>Otra</option>
              </select>
              </div>
            </div>
            <div class="form-group row my-2">
              <label for="localidad" class="col-sm-3 col-form-label">Localidad</label>
                <div class="col-sm-9">      
                <select class="form-control" id="localidad" name="SLLocalidad">
                <option>Tigre</option>
 				<option>Don Torcuato</option>
                <option>Otra</option>
              </select>
              </div>
            </div>
             <div class="form-group row my-2">
              <label for="direccion" class="col-sm-3 col-form-label">Direccion</label>
              <div class="col-sm-9">      
                <input type="text" class="form-control" id="direccion" placeholder="Ingrese su Direccion" name="txtDireccion">
              </div>
              </div>
             <div class="form-group row my-2">
              <label for="telefono" class="col-sm-3 col-form-label">Teléfono</label>
              <div class="col-sm-9">      
                <input type="number" class="form-control" id="telefono" placeholder="Ingrese el teléfono" name="txtTelefono">
              </div>
            </div>
            <div class="form-group row my-2">
              <label for="correo" class="col-sm-3 col-form-label">Correo electrónico</label>
              <div class="col-sm-9">      
                <input type="email" class="form-control" id=correo placeholder="Ingrese el correo electrónico" name="txtCorreoElectronico">
              </div>
            </div>
            <div class="form-group row my-2 d-flex content-center"> 
              <label class="col-sm-3 col-form-label">Tipo Usuario</label>
              <div class="">
              	<label for="admin" class="col-sm-3 col-form-label">Admin</label>      
                <input type="radio" class="form-control" id="admin" name="RTipoUsuario" value="1">
              	<label for="cliente" class="col-sm-3 col-form-label">Cliente</label>
              	<input type="radio" class="form-control" id="cliente" name="RTipoUsuario" value="2">
              </div>
            </div>
            <div class="form-group row my-2">
              <label for="usuario" class="col-sm-3 col-form-label">Usuario</label>
              <div class="col-sm-9">      
                <input type="text" class="form-control" id="usuario" placeholder="Ingrese el usuario" name="txtUsuario">
              </div>
            </div>
            <div class="form-group row my-2">
              <label for="contrasena" class="col-sm-3 col-form-label">Contraseña</label>
              <div class="col-sm-9">      
                <input type="password" class="form-control" id="contrasena" placeholder="Ingrese la contraseña" name="txtContrasenia">
              </div>
            </div>
            <div class="mt-3 py-4">
            <input type="submit" class="btn btn-primary" value="Registrar" name="btnRegistrar">
            <input type="submit" class="btn btn-primary" value="Ver Modal" onclick="mostrarModal()">
            <button type="submit" class="btn btn-secondary">Limpiar</button>
            </div>
          </fieldset>
        </form>
      </div>
      <div class="col px-4 py-2">
        <table id="clientes" class="table table-hover nowrap">
          <thead>
            <tr>
              <th scope="col" class="text-center">Usuario</th>
              <th scope="col" class="text-center">Nombre</th>
              <th scope="col" class="text-center">Apellido</th>
              <th scope="col" class="text-center">DNI</th>
              <th scope="col" class="text-center">Acciones</th>
            </tr>
          </thead>
        </table>
      </div>
    </div>
  </body>
</html>