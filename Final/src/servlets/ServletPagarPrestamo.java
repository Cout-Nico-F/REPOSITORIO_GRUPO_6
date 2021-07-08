package servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Cliente;
import entidad.Cuenta;
import entidad.Cuota;
import entidad.Prestamo;
import negocio.ClienteNegocio;
import negocio.IPrestamoNegocio;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.PrestamoNegocioImpl;

/**
 * Servlet implementation class ServletPagarPrestamo
 */
@WebServlet("/ServletPagarPrestamo")
public class ServletPagarPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Prestamo> listaPrestamos;
	private ClienteNegocio cliNeg = new ClienteNegocioImpl();
	private IPrestamoNegocio preNeg = new PrestamoNegocioImpl();

	public ServletPagarPrestamo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (cliNeg.validarUsuarioCliente(request)) {
			cargarPrestamos(request);
			cargarSaldos(request);
			
		} else {
			response.sendRedirect("Login.jsp");
			return;
		}

		RequestDispatcher rd = request.getRequestDispatcher("/PagarPrestamos.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (cliNeg.validarUsuarioCliente(request)) {
			cargarPrestamos(request);
			cargarSaldos(request);
			
		} else {
			response.sendRedirect("Login.jsp");
			return;
		}

		RequestDispatcher rd = request.getRequestDispatcher("/PagarPrestamos.jsp");
		rd.forward(request, response);

	}

	//////////////// -------------------------//////////////////////

	private void cargarSaldos(HttpServletRequest request) {		
		request.setAttribute("listaSaldos", preNeg.cargarSaldos(listaPrestamos));
	}

	void cargarPrestamos(HttpServletRequest request) {
		String nombreUsuario = String.valueOf(request.getSession().getAttribute("nombreUsuarioLogeado"));
		Cliente cli = cliNeg.traerClientePorNombreUsuario(nombreUsuario);
		listaPrestamos = cliNeg.listarPrestamosPorCliente(cli.getDni());
		ArrayList<Prestamo> listaPrestAux = new ArrayList<Prestamo>();
		Prestamo prestamo = new Prestamo();
		for(Prestamo p : listaPrestamos) {
		ArrayList<Cuota> listaCuotas = p.getListaCuotas();
		int numeroCuotasMostradas=3;
		if(listaCuotas.size()<3) {
			numeroCuotasMostradas=listaCuotas.size();
		}
		listaCuotas = new ArrayList<Cuota>(listaCuotas.subList(0, numeroCuotasMostradas));
		prestamo = new Prestamo(p.getIdPrestamo(),p.getCliente(),p.getCuenta(),p.getFechaSQL(),p.getImporteSolicitado(),p.getImporteAPagar(),p.getMontoMensual(),p.getCuotas(), p.getEstado(),listaCuotas);
		prestamo.setListaCuotas(listaCuotas);
		listaPrestAux.add(prestamo);
		}
		request.setAttribute("listaPrestamos", listaPrestAux);
	}
}
