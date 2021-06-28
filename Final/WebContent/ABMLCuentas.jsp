<%@page import="entidad.TiposDeCuenta"%>
<%@page import="com.sun.org.apache.xpath.internal.operations.Div"%>
<%@page import="entidad.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
  <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>ABML Cuentas</title>
    <%@ include file="HeaderAdmin.jsp" %>  
    <form method="post" action="ServletABMLCuentas">
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
            data: <% 
            ArrayList<Cuenta> listaCuentas = null;
            ArrayList<Cliente> listaClientesDeCuentas = null;
            if(request.getAttribute("listaCuentas")!=null){
            	listaCuentas = (ArrayList<Cuenta>)request.getAttribute("listaCuentas");
            	listaClientesDeCuentas = (ArrayList<Cliente>)request.getAttribute("listaClientesDeCuentas");
				if(listaCuentas != null){
					for(int i=0; i<listaCuentas.size();i++){
            		%>[
            	  	  {
            		  "nroCuenta": "
            		  <%=listaCuentas.get(i).getNumeroCuenta()%>
            	  	  ",
            		  "tipoCuenta": "
            		  <% if(request.getAttribute("listaTiposCta")!=null){
                  		ArrayList<TiposDeCuenta> listaTipos = (ArrayList<TiposDeCuenta>)request.getAttribute("listaTiposCta");
            		  	int index = listaTipos.indexOf(x->x.getIdTipoCuenta()==listaCuentas.get(i).getIdTipodeCuenta());
            		  	listaTipos.get(index).getDescripcion(); %>
            		  ",
            		  "cbu": <%=listaCuentas.get(i).getCBU()%>,
            		  "fechaCreacion": "2018-01-25",
            		  "dni": <%=listaCuentas.get(i).getDNI()%>,
            		  "apellido": "<%=listaClientesDeCuentas.get(i).getApellido() %>",
            		  "nombre": "<%=listaClientesDeCuentas.get(i).getNombre() %>",
            		  "saldo": "<%=listaCuentas.get(i).getSaldo()%>"
            		  }
            		],
            		<%}%>
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
    </form>
  </head>
  <body>
    <div class="row">
      <div class="col  px-4 py-2">
        <form method="post" action="ServletABMLCuentas">
          <fieldset>
            <legend>Nueva cuenta</legend>
             <div class="form-group row my-2">
              <label for="dni" class="col-sm-3 col-form-label">DNI del cliente</label>
              <div class="col-sm-9">      
                <input type="text" class="form-control" placeholder="Ingrese el DNI" id="dniCli" list="listaClientes">
                <datalist id="listaClientes">
<!-- 	            aca iría la lista de clientes con <= 2 cuentas asignadas -->
					<%
					ArrayList<Cliente> listaCli = null;
					if(request.getAttribute("listaClientes")!=null){
						listaCli = (ArrayList<Cliente>)request.getAttribute("listaClientes");
						if(listaCli != null){
							for(Cliente cli : listaCli){
								String aux = cli.getNombre() +" "+ cli.getApellido() + " - " + String.valueOf(cli.getDni());
								%> <option> <%=aux %> </option> <%
							}
						}else{
							%> <option> No se encontraron Cliente disponibles </option>
							<%
						}
					}
					%>
	            </datalist>
              </div>
            </div>
            <div class="form-group row my-2">
              <label for="tipo" class="col-sm-3 col-form-label">Tipo de cuenta</label>
                <div class="col-sm-9">      
                <select class="form-control" id="tipo">
                <%if(request.getAttribute("listaTiposCta")!=null){
                	ArrayList<TiposDeCuenta> listaTipos = (ArrayList<TiposDeCuenta>)request.getAttribute("listaTiposCta");
            		for(TiposDeCuenta tipo : listaTipos){
            			%> <option> <%=tipo.getDescripcion() %> </option> <%
            		}
                }
                %>
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
                <input type="money" readonly value="$10,000.00" class="form-control" id="saldo">
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