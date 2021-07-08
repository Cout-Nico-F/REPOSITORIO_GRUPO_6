package servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Prestamo;
import negocio.IAdminNegocio;
import negocioImpl.AdminNegocioImpl;

@WebServlet("/AutorizacionPrestamos")
public class ServletAutorizacionPrestamos extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IAdminNegocio admNeg = new AdminNegocioImpl();
	
	public ServletAutorizacionPrestamos() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/AutorizacionPrestamos.jsp");
		request.setAttribute("prestamos", admNeg.listarPrestamosParaAutorizar());
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/AutorizacionPrestamos.jsp");
		Prestamo p = new Prestamo();
		String mensaje;
		p.setIdPrestamo(Integer.valueOf(request.getParameter("idPrestamo")));
		p.setCuotas(Short.valueOf(request.getParameter("cuotas")));
		p.setMontoMensual(new BigDecimal((String)request.getParameter("montoMensual")));
		p.setFechaJAVA(getDate(request.getParameter("fecha")));
		if("autorizar".equals(request.getParameter("accion"))) {
			p.setEstado((short)3);
			mensaje = "El préstamo ha sido autorizado"; 
		} else {
			p.setEstado((short)2);
			mensaje = "El préstamo ha sido denegado";
		}
		if(admNeg.actualizarPrestamo(p) < 1) {
			mensaje = "Hubo un error al intentar realizar la acción";
		}
		request.setAttribute("mensaje", mensaje);
		request.setAttribute("prestamos", admNeg.listarPrestamosParaAutorizar());
		rd.forward(request, response);
	}
	
	private Date getDate(String dateString) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
