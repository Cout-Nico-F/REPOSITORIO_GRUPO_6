<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>Pagar un préstamo</title>
    <%@ include file="HeaderCliente.jsp" %>  
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
            	  {
            		    "fecha": "2016-05-28",
            		    "importeAPagar": "$7500000",
            		    "importePedido": "$7000000",
            		    "plazo": 190,
            		    "montoPorMes": "$39473",
            		    "cuotas": "61/190"
            		  },
            		  {
            		    "fecha": "2018-04-29",
            		    "importeAPagar": "$2650000",
            		    "importePedido": "$2500000",
            		    "plazo": 120,
            		    "montoPorMes": "$22083",
            		    "cuotas": "38/120"
            		  },
            		  {
            		    "fecha": "2019-03-06",
            		    "importeAPagar": "$525000",
            		    "importePedido": "$500000",
            		    "plazo": 75,
            		    "montoPorMes": "$7000",
            		    "cuotas": "36/75"
            		  }
            		],
            columns: [
                {
                    data: 'fecha'
                },
                {
                    data: 'importeAPagar'
                },
                {
                    data: 'importePedido'
                },
                {
                	data: 'plazo'
                },
                {
                	data: 'montoPorMes'
                },
                {
                	data: 'cuotas'
                },
                {
                	data: null,
               	 	render: function ( data, type, row ) {
                        return '<select class="form-control">' +
                        '<option>1</option>' +
                        '<option>2</option>' +
                        '<option>3</option>' +
                      	'</select>'
                    }
                },
                {
                	data: null,
               	 	render: function ( data, type, row ) {
                        return '<div class="text-center"><button class="btn"><i class="bi bi-cash-coin"></i></button></div>'
                    }
                }
            ]
        } );
    } );
    </script>
  </head>
  <body>
      <div class="container pt-5">
        <table id="clientes" class="table table-hover nowrap">
          <thead>
            <tr>
              <th scope="col" class="text-center">Fecha</th>
              <th scope="col" class="text-center">Importe a pagar</th>
              <th scope="col" class="text-center">Importe pedido</th>
              <th scope="col" class="text-center">Plazo de pago (meses)</th>
              <th scope="col" class="text-center">Monto por mes</th>
              <th scope="col" class="text-center">Número de cuota</th>
              <th scope="col" class="text-center">Cuenta a debitar</th>
              <th scope="col" class="text-center">Pagar</th>
            </tr>
          </thead>
        </table>
      </div>
  </body>
</html>