<%@page import="entidad.Cuenta"%>
<%@page import="entidad.TipoDeCuenta"%>
<%@page import="com.sun.org.apache.xpath.internal.operations.Div"%>
<%@page import="entidad.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ABML Cuentas</title>
<%@ include file="HeaderAdmin.jsp"%>

<script>
    $(document).ready(function() {
        var table = $('#cuentas').DataTable( {
            language: {
                zeroRecords: "No hay resultados",
                info: "P�gina _PAGE_ de _PAGES_",
                infoEmpty: "No hay registros",
                infoFiltered: "(filtrada de _MAX_ registros totales)",
                search: "Buscar: "
            }
        } );
    } );
</script>
</head>

<body>
	<div class="row">
		<div class="col  px-4 py-2">
			<form method="post" action="ServletABMLCuentas">
				<fieldset>
					<legend>Nueva cuenta</legend>
					<div class="form-group row my-2">
						<label for="dni" class="col-sm-3 col-form-label">DNI del
							cliente</label>
						<div class="col-sm-9">
							<input type="text" class="form-control"
								placeholder="Ingrese el DNI" id="dniCli" list="listaClientes">
							<datalist id="listaClientes"> <!-- 	            aca ir�a la lista de clientes con <= 2 cuentas asignadas -->
							<%
								ArrayList<Cliente> listaCli = null;
								if (request.getAttribute("listaClientes") != null) {
									listaCli = (ArrayList<Cliente>) request.getAttribute("listaClientes");
									if (listaCli != null) {
										for (Cliente cli : listaCli) {
											String aux = cli.getNombre() + " " + cli.getApellido() + " - " + String.valueOf(cli.getDni());
							%>
							<option value="<%=cli.getDni()%>">
								<%=aux%>
							</option>
							<%
								}
									} else {
							%>
							<option>No se encontraron Cliente disponibles</option>
							<%
								}
								}
							%> </datalist>
						</div>
					</div>
					<div class="form-group row my-2">
						<label for="tipo" class="col-sm-3 col-form-label">Tipo de
							cuenta</label>
						<div class="col-sm-9">
							<select class="form-control" id="tipo">
								<%
									if (request.getAttribute("listaTiposCta") != null) {
										ArrayList<TipoDeCuenta> listaTipos = (ArrayList<TipoDeCuenta>) request.getAttribute("listaTiposCta");
										for (TipoDeCuenta tipo : listaTipos) {
								%>
								<option value="<%=tipo.getIdTipoCuenta()%>">
									<%=tipo.getDescripcion()%>
								</option>
								<%
									}
									}
								%>
							</select>
						</div>
					</div>
					<div class="form-group row my-2">
						<label for="numero" class="col-sm-3 col-form-label">N�mero
							de cuenta</label>
						<div class="col-sm-9">
							<input type="number" class="form-control" id="numero"
								placeholder="Ingrese el N�mero de cuenta">
						</div>
					</div>
					<div class="form-group row my-2">
						<label for="cbu" class="col-sm-3 col-form-label">CBU</label>
						<div class="col-sm-9">
							<input type="number" class="form-control" id="cbu"
								placeholder="Ingrese el CBU">
						</div>
					</div>
					<div class="form-group row my-2">
						<label for="saldo" class="col-sm-3 col-form-label">Saldo</label>
						<div class="col-sm-9">
							<input type="money" readonly value="$10,000.00"
								class="form-control" id="saldo">
						</div>
					</div>
					<div class="mt-3">
						<button type="submit" class="btn btn-primary">Registrar</button>
						<button type="submit" class="btn btn-secondary">Limpiar</button>
					</div>
				</fieldset>
			</form>
		</div>
		<form action="ServletABMLCuentas" method="post">
		<div class="col px-4 py-2">
			<table id="cuentas" class="table table-hover nowrap">
				<thead>
					<tr>
						<th scope="col" class="text-center">N�mero de cuenta</th>
						<th scope="col" class="text-center">Tipo de Cuenta</th>
						<th scope="col" class="text-center">CBU</th>
						<th scope="col" class="text-center">Fecha de creaci�n</th>
						<th scope="col" class="text-center">DNI</th>
						<th scope="col" class="text-center">Apellido</th>
						<th scope="col" class="text-center">Nombre</th>
						<th scope="col" class="text-center">Saldo</th>
						<th scope="col" class="text-center">Acciones</th>
					</tr>
				</thead>
				<tbody>
				
				<% 
				ArrayList<Cuenta> listaCuentas = null;
				ArrayList<Cliente> listaClientes = null;
				if(request.getAttribute("listaCuentas")!=null){
					listaCuentas = (ArrayList<Cuenta>)request.getAttribute("listaCuentas");
					listaClientes = (ArrayList<Cliente>)request.getAttribute("listaClientesDeCuentas");
					for(int i=0;i<listaCuentas.size();i++) {
					%>
						<tr>
							<td class="dt-body-center"><%=listaCuentas.get(i).getNumeroCuenta()%></td>
							<td class="dt-body-right"><%=listaCuentas.get(i).getTipoDeCuenta().getDescripcion()%> <input type="hidden" name="nroCuenta" value="<%=listaCuentas.get(i).getNumeroCuenta()%>"></input> </td>
							<td ><%=listaCuentas.get(i).getCBU()%></td>
							<td class="dt-body-center"> <%=listaCuentas.get(i).getFecha() %></td>
							<td > <%=(listaCuentas.get(i).getDNI()==0)?"Sin asignar":listaCuentas.get(i).getDNI()%></td>
							<td class="dt-body-center"><%=(listaClientes.get(i).getApellido()==null)?"Sin asignar":listaClientes.get(i).getApellido()%></td>
							<td class="dt-body-center"><%=(listaClientes.get(i).getNombre()==null)?"Sin asignar":listaClientes.get(i).getNombre()%></td>
							<td class="dt-body-right"><%=listaCuentas.get(i).getSaldo()%></td>
							<td><div class="text-center"><button type="submit" name="btnModificarCuenta" value="modificarCuenta" class="btn"><i class="bi bi-pencil-fill"></i></button><button type="submit" name="btnEliminarCuenta" value="eliminarCuenta" class="btn"><i class="bi bi-trash-fill"></i></button></div>
							</td>
						</tr>
						<%} 
				}%>
				</tbody>
			</table>
		</div>
		</form>
	</div>
</body>
</html>