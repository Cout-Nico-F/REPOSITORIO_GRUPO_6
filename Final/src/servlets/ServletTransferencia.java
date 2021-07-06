package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ITransferirDao;
import daoImpl.TransferirDaoImpl;

/**
 * Servlet implementation class ServletTransferencia
 */
@WebServlet("/ServletTransferencia")
public class ServletTransferencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTransferencia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		if (request.getParameter("btnTransferir") != null) {
			try {
				
				ITransferirDao idao = new TransferirDaoImpl();
				if (idao.ComprobarExistencia(request.getParameter("cbuOrigen")) == false ) {
					
					//Alert diciendo: No existe la cuenta de origen ingresada.
					return;
				}
				
				if (idao.ComprobarExistencia(request.getParameter("cbuDestino")) == false ) {
					
					//Alert diciendo: No existe la cuenta destino ingresada.
					return;
				}
				
				if (idao.ComprobarSaldo(request.getParameter("cbuOrigen"), Integer.valueOf( request.getParameter("cantidadIngresada"))) == false) {
					//Alert diciendo: Saldo Insuficiente!
					return;
				}
				
				//Si el codigo llega a este punto es porque existen las cuentas y el origen tiene saldo suficiente para realizar la operacion.
				
				//Cartel preguntando Si estamos seguros de querer transferir. 
				
				//Transferencia.
				
				//Aviso de transferencia Correcta o fallida.
			
			} catch (SQLException e) {
				//Acá podemos redireccionar a una pantalla de error. por ejemplo: "La base de datos no responde. Esta apagada o sin acceso. "
			}
		}
		
	}

}
