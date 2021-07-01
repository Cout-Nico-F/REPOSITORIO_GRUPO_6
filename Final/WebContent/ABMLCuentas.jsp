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
                info: "Página _PAGE_ de _PAGES_",
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
							<input type="text" class="form-control required"
								placeholder="Ingrese el DNI" id="dniCli" name="dniCli" list="listaClientes" onKeyPress="if(this.value.length>8) return false;"
								 maxlength="9">
							<datalist id="listaClientes"> <!-- 	            aca iría la lista de clientes con <= 2 cuentas asignadas -->
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
							<select class="form-control" id="tipo" name="DropdownTipoCuenta">
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
						<label for="numero" class="col-sm-3 col-form-label">Número
							de cuenta</label>
						<div class="col-sm-9">
							<input type="number" class="form-control required" id="numero" name="inputNroCuenta"
								placeholder="Ingrese el Número de cuenta" required onKeyPress="if(this.value.length>8) return false;"
								 maxlength="9">
						</div>
					</div>
					<div class="form-group row my-2">
						<label for="cbu" class="col-sm-3 col-form-label">CBU</label>
						<div class="col-sm-9">
							<input type="number" class="form-control required" name="inputCBU" id="cbu"
								placeholder="Ingrese el CBU" required onKeyPress="if(this.value.length>21) return false;"
								 maxlength="9">
						</div>
					</div>
					<div class="form-group row my-2">
						<label for="saldo" class="col-sm-3 col-form-label">Saldo</label>
						<div class="col-sm-9">
							<input type="number" readonly name="inputSaldo" value="0.00"
								class="form-control required" id="saldo" required>
						</div>
					</div>
					<div class="mt-3">
						<button type="submit" name="btnRegistrar" class="btn btn-primary">Registrar</button>
						<button type="submit" class="btn btn-secondary">Limpiar</button>
					</div>
					
<%-- 					<% if(request.getParameter("msjModal") != null){ --%>
	
<%-- 				%> --%>
				
<!-- 				<div class="modal" tabindex="-1"> -->
<!-- 				  <div class="modal-dialog"> -->
<!-- 				    <div class="modal-content"> -->
<!-- 				      <div class="modal-header"> -->
<%-- 				        <h5 class="modal-title"> <%=request.getAttribute("msjTituloModal") %> </h5> --%>
<!-- 				        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button> -->
<!-- 				      </div> -->
<!-- 				      <div class="modal-body"> -->
<%-- 				        <p><%=request.getAttribute("msjModal") %></p> --%>
<!-- 				      </div> -->
<!-- 				      <div class="modal-footer"> -->
<!-- 				        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button> -->
<!-- 				      </div> -->
<!-- 				    </div> -->
<!-- 				  </div> -->
<!-- 				</div> -->
<%-- 			<%} %> --%>
					
				</fieldset>
			</form>
			
			
		</div>
		<form action="ServletABMLCuentas" method="post">
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
						<form action="ServletABMLCuentas" method="post">
							<td class="dt-body-center"><%=listaCuentas.get(i).getNumeroCuenta()%> <input type="hidden" name="nroCuenta" value="<%=listaCuentas.get(i).getNumeroCuenta()%>"></input></td>
							<td class="dt-body-right"><%=listaCuentas.get(i).getTipoDeCuenta().getDescripcion()%>  </td>
							<td ><%=listaCuentas.get(i).getCBU()%></td>
							<td class="dt-body-center"> <%=listaCuentas.get(i).getFechaSQL() %></td>
							<td > <%=(listaCuentas.get(i).getDNI()==0)?"Sin asignar":listaCuentas.get(i).getDNI()%></td>
							<td class="dt-body-center"><%=(listaClientes.get(i).getApellido()==null)?"Sin asignar":listaClientes.get(i).getApellido()%></td>
							<td class="dt-body-center"><%=(listaClientes.get(i).getNombre()==null)?"Sin asignar":listaClientes.get(i).getNombre()%></td>
							<td class="dt-body-right"><%=listaCuentas.get(i).getSaldo()%></td>
							<%if(listaCuentas.get(i).getDNI()!=0){
								%>
								<td><div class="text-center"><button type="submit" name="btnEliminarCuenta" value="eliminarCuenta" class="btn"><i class="bi bi-trash-fill"></i></button></div>
								</td>
								<%
							} else{
								%>
								<td><div class="text-center"><button type="submit" name="btnModificarCuenta" value="modificarCuenta" class="btn"><i class="bi bi-pencil-fill"></i></button>
								<button type="submit" name="btnEliminarCuenta" value="eliminarCuenta" class="btn"><i class="bi bi-trash-fill"></i></button></div>
								</td>
								<%
							}
							%>
						</form>
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