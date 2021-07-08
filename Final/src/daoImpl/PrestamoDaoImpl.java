package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.CuotaDao;
import dao.PrestamoDao;
import entidad.Cliente;
import entidad.Cuenta;
import entidad.Cuota;
import entidad.Prestamo;
import entidad.TipoDeCuenta;

public class PrestamoDaoImpl implements PrestamoDao {
	private static final String traerPrestamosParaAutorizar = "select * from prestamos pr inner join clientes cl on pr.Dni = cl.Dni inner join cuentas cu on pr.NumeroCuenta = cu.NumeroCuenta inner join tiposdecuenta tc on tc.IdTipoCuenta = cu.IdTipoCuenta where pr.Estado = 1 and cl.Eliminado = 0 and cu.Eliminado = 0;";
	private static final String actualizarPrestamo = "update prestamos set estado = ? where IdPrestamos = ?";
	private static String listarPrestamosPorCliente = "select * from prestamos where dni = ? and estado=3";
	private static String listarCuotasPorPrestamo= "select * from cuotas where IdPrestamos = ? and isnull(fechapago) order by fechavencimiento asc";
	/*
	Estados de los Prestamos:
	1-Solicitado 
	2-Denegado 
	3-Vigente 
	4-Pagado
	*/
	
	private ArrayList<Cuota> listarCuotas(int idPrestamo){
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs;
		ArrayList<Cuota> listaCuotas = new ArrayList<Cuota>();
		
		try {
			ps=conexion.prepareStatement(listarCuotasPorPrestamo);
			ps.setInt(1, idPrestamo);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				Cuota aux = new Cuota();
				aux.setNumeroDeCuota(rs.getShort("NumeroCuota"));
				aux.setImporte(rs.getBigDecimal("Importe"));
				aux.setFechaDeVencimiento(rs.getDate("FechaVencimiento"));
				if(rs.getDate("FechaPago")!=null)
					aux.setFechaDePago(rs.getDate("FechaPago"));
				listaCuotas.add(aux);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Cuota>();
		}
		return listaCuotas;
	}
	
	@Override
	public ArrayList<Prestamo> traerPrestamosParaAutorizar(){
		PreparedStatement statement;
		ArrayList<Prestamo> listaPrestamos = new ArrayList<Prestamo>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs = null;
		try {
			statement = conexion.prepareStatement(traerPrestamosParaAutorizar);
			rs = statement.executeQuery();
			while(rs.next()) {
				Prestamo p = new Prestamo();
				p.setIdPrestamo(rs.getInt("pr.IdPrestamos"));
				p.setFecha(rs.getDate("pr.Fecha"));
				p.setImporteSolicitado(rs.getDouble("pr.ImporteSolicitado"));
				p.setImporteAPagar(rs.getDouble("pr.ImporteAPagar"));
				p.setMontoMensual(rs.getDouble("pr.MontoMensual"));
				p.setCuotas(rs.getInt("pr.Cuotas"));
				p.setEstado(rs.getInt("pr.Estado"));
				Cliente cl = new Cliente();
				cl.setDni(rs.getInt("cl.Dni"));
				cl.setCuil(rs.getString("cl.Cuil"));
				cl.setNombre(rs.getString("cl.Nombre"));
				cl.setApellido(rs.getString("cl.Apellido"));
				cl.setSexo(rs.getString("cl.Sexo"));
				cl.setFechaNacimiento(rs.getDate("cl.FechaNacimiento"));
				cl.setDireccion(rs.getString("cl.Direccion"));
				cl.setCorreoElectronico(rs.getString("cl.CorreoElectronico"));
				cl.setTelefonoFijo(rs.getString("cl.TelefonoFijo"));
				cl.setCelular(rs.getString("cl.Celular"));
				p.setCliente(cl);
				Cuenta cu = new Cuenta();
				cu.setNumeroCuenta(((Long)rs.getLong("cu.NumeroCuenta")).toString());
				cu.setDNI(rs.getInt("cu.Dni"));
				cu.setSaldo(rs.getBigDecimal("cu.Saldo"));
				cu.setCBU(rs.getString("cu.Cbu"));
				cu.setFecha(rs.getDate("cu.FechaCreacion"));
				TipoDeCuenta tc = new TipoDeCuenta();
				tc.setIdTipoCuenta(rs.getShort("tc.IdTipoCuenta"));
				tc.setDescripcion(rs.getString("tc.Descripcion"));
				cu.setTipoDeCuenta(tc);
				p.setCuenta(cu);
				listaPrestamos.add(p);
			}
			return listaPrestamos; 
		}
		catch(SQLException e) {
			e.printStackTrace();
			return listaPrestamos; 
		}
	}
	
	/*
	Estados de los Prestamos:
	1-Solicitado 
	2-Denegado 
	3-Vigente 
	4-Pagado
	*/
	
	@Override
	public ArrayList<Prestamo> listarPrestamosPorCliente(int dni) {
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs;
		ArrayList<Prestamo> listaPrestamos = new ArrayList<Prestamo>();
		
		try {
			ps=conexion.prepareStatement(listarPrestamosPorCliente);
			ps.setInt(1, dni);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				Prestamo aux = new Prestamo();
				aux.setCuotas(rs.getShort("cuotas"));
				aux.setCliente(new Cliente(rs.getInt("dni")));
				aux.setFecha(rs.getDate("fecha"));
				aux.setIdPrestamo(rs.getInt("idPrestamos"));
				aux.setImporteSolicitado(rs.getDouble("importeSolicitado"));
				aux.setMontoMensual(rs.getDouble("montoMensual"));
				aux.setListaCuotas(listarCuotas(aux.getIdPrestamo()));
				listaPrestamos.add(aux);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Prestamo>();
		}
		
		return listaPrestamos;
	}
	
	private ArrayList<Cuota> listarCuotas(int idPrestamo){
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs;
		ArrayList<Cuota> listaCuotas = new ArrayList<Cuota>();
		
		try {
			ps=conexion.prepareStatement(listarCuotasPorPrestamo);
			ps.setInt(1, idPrestamo);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				Cuota aux = new Cuota();
				aux.setNumeroCuota(rs.getShort("NumeroCuota"));
				aux.setImporte(rs.getDouble("Importe"));
				aux.setFechaVencimiento(rs.getDate("FechaVencimiento"));
				aux.setFechaPago(rs.getDate("FechaPago"));
				listaCuotas.add(aux);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Cuota>();
		}
		
		return listaCuotas;
		
	}
}
