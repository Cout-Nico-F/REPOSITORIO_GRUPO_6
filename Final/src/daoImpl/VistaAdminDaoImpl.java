package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.VistaAdminDao;
import entidad.Cuenta;
import entidad.Prestamo;
import entidad.TipoDeCuenta;
import entidad.VistaAdmin;

public class VistaAdminDaoImpl implements VistaAdminDao {

	private static final String contadorDeClientes = "Select * from clientes"; //Podria arreglarlo con un Count(*) pero nose como recuperar el resultado
	private static final String contadorDeSolicitudesDePrestamos = "Select * From Prestamos Where Estado = 1"; //Estado 1 por que son prestamos solicitados
	private static final String contadorDePrestamosRechazados = "Select * from Prestamos Where Estado = 2"; //Estado 2 son los prestamos rechazados
	private static final String buscarDatosVistaAdminSegunDni = "Select * from clientes c inner join prestamos p on c.dni = p.dni \r\n" + 
			"inner join cuentas cu on p.dni = cu.dni \r\n" + 
			"inner join tiposdecuenta tc on cu.idTipoCuenta = tc.idTipoCuenta Where c.dni = ?";
	
	@Override
	public int contadorClientes() { //Deberia funcionar asi
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs;
		int contador = 0;
		try {
			ps = conexion.prepareStatement(contadorDeClientes);
			rs = ps.executeQuery();
			while(rs.next()) {
				contador = contador + 1;
			}
			return contador;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return contador = 0; //Devuelve 0
		}
	}

	@Override
	public int contadorDeSolicitudesDePrestamos() {
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs;
		int contador = 0;
		try {
			ps = conexion.prepareStatement(contadorDeSolicitudesDePrestamos);
			rs = ps.executeQuery();
			while(rs.next()) {
				contador = contador + 1;
			}
			return contador;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return contador = 0; //Devuelve 0
		}
	}

	@Override
	public int contadorDePrestamosRechazados() {
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ResultSet rs;
		int contador = 0;
		try {
			ps = conexion.prepareStatement(contadorDePrestamosRechazados);
			rs = ps.executeQuery();
			while(rs.next()) {
				contador = contador + 1;
			}
			return contador;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return contador = 0; //Devuelve 0
		}
	}


	@Override
	public ArrayList<VistaAdmin> traerDatoVistaAdminSegunDni(int DniUsuario) {
		ResultSet rs;
		PreparedStatement ps;
		ArrayList<VistaAdmin> ListaVistaAdmin= new ArrayList<VistaAdmin>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try {
			ps = conexion.prepareStatement(buscarDatosVistaAdminSegunDni);
			ps.setInt(1,DniUsuario);
			rs = ps.executeQuery();
			while(rs.next()) {
				VistaAdmin va = new VistaAdmin();
				va.setNumeroCuenta(rs.getString("cu.NumeroCuenta"));
				TipoDeCuenta tc = new TipoDeCuenta();
				tc.setDescripcion(rs.getString("tc.Descripcion"));
				va.setTipoCuenta(tc);
				Prestamo p = new Prestamo();
				p.setEstado(rs.getShort("p.Estado"));
				va.setPrestamo(p);
				ListaVistaAdmin.add(va);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return ListaVistaAdmin;
		}
		return ListaVistaAdmin;
	}

}
