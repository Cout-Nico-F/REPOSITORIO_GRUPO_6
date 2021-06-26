<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>ABML Cuentas</title>
    <%@ include file="HeaderAdmin.jsp" %>  
    <script>
    $(document).ready(function() {
        var table = $('#cuentas').DataTable( {
            language: {
                zeroRecords: "No hay resultados",
                info: "Página _PAGE_ de _PAGES_",
                infoEmpty: "No hay registros",
                infoFiltered: "(filtrada de _MAX_ registros totales)",
                search: "Buscar: "
            },
            lengthChange: false,
            data: [
            	  {
            		  "nroCuenta": 5050505,
            		  "tipoCuenta": "Caja de Ahorros",
            		  "cbu": 44843806526,
            		  "fechaCreacion": "2018-01-25",
            		  "dni": 5326650,
            		  "apellido": "Levine",
            		  "nombre": "Staci",
            		  "saldo": "$3882"
            		  }
            		],
            columns: [
                {
                    data: 'nroCuenta',
                    className: 'dt-body-center'
                },
                {
                    data: 'tipoCuenta',
                    className: 'dt-body-right'
                },
                {
                    data: 'cbu'
                },
                {
                	data: 'fechaCreacion',
                    className: 'dt-body-center'
                },
                {
                	data: 'dni'
                },
                {
                	data: 'apellido',
                	className: 'dt-body-center'
                },
                {
                	data: 'nombre',
                	className: 'dt-body-center'
                }, 
                {
                	data: 'saldo',
                	className: 'dt-body-right'
                },
                {
                	data: null,
               	 	render: function ( data, type, row ) {
                        return '<div class="text-center"><button class="btn"><i class="bi bi-pencil-fill"></i></button><button class="btn"><i class="bi bi-trash-fill"></i></button></div>'
                    }
                }
            ]
        } );
    } );
    </script>
  </head>
  <body>
    <div class="row">
      <div class="col  px-4 py-2">
        <form>
          <fieldset>
            <legend>Nueva cuenta</legend>
             <div class="form-group row my-2">
              <label for="dni" class="col-sm-3 col-form-label">DNI del cliente</label>
              <div class="col-sm-9">      
                <input type="number" class="form-control" id="dni" placeholder="Ingrese el DNI">
              </div>
            </div>
            <div class="form-group row my-2">
              <label for="tipo" class="col-sm-3 col-form-label">Tipo de cuenta</label>
                <div class="col-sm-9">      
                <select class="form-control" id="tipo">
                <option>Caja de ahorro</option>
                <option>Cuenta corriente</option>
              </select>
              </div>
            </div>
             <div class="form-group row my-2">
              <label for="numero" class="col-sm-3 col-form-label">Número de cuenta</label>
              <div class="col-sm-9">      
                <input type="number" class="form-control" id="numero" placeholder="Ingrese el Número de cuenta">
              </div>
            </div>
            <div class="form-group row my-2">
              <label for="cbu" class="col-sm-3 col-form-label">CBU</label>
              <div class="col-sm-9">      
                <input type="number" class="form-control" id="cbu" placeholder="Ingrese el CBU">
              </div>
            </div>
            <div class="form-group row my-2">
              <label for="saldo" class="col-sm-3 col-form-label">Saldo</label>
              <div class="col-sm-9">      
                <input type="number" class="form-control" id="saldo" placeholder="Ingrese el Saldo">
              </div>
            </div>
            <div class="mt-3">
            <button type="submit" class="btn btn-primary">Registrar</button>
            <button type="submit" class="btn btn-secondary">Limpiar</button>
            </div>
          </fieldset>
        </form>
      </div>
      <div class="col px-4 py-2">
        <table id="cuentas" class="table table-hover nowrap">
          <thead>
            <tr>
              <th scope="col" class="text-center">Número de cuenta</th>
              <th scope="col" class="text-center">Tipo de Cuenta</th>
              <th scope="col" class="text-center">CBU</th> 
              <th scope="col" class="text-center">Fecha de creación</th>
              <th scope="col" class="text-center">DNI</th>
			  <th scope="col" class="text-center">Apellido</th>
              <th scope="col" class="text-center">Nombre</th>
              <th scope="col" class="text-center">Saldo</th>              
              <th scope="col" class="text-center">Acciones</th>
            </tr>
          </thead>
        </table>
      </div>
    </div>
  </body>
</html>