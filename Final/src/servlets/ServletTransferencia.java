package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
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

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}
	
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("btnTransferir") != null) {
			try {
				
				//validar que los input no esten vacíos.
				if(validarCampoNoVacio(request.getParameter("inputCbuOrigen")) == false ) {
					//Alert diciendo: Falta ingresar el numero de Cbu de origen.
					request.getSession().setAttribute("mensajeOrigen","Ingrese el CBU de la cuenta de origen");
					request.setAttribute("tipoMensajeOrigen","danger");
					
					RequestDispatcher rd = request.getRequestDispatcher("/Transferencias.jsp");
					rd.forward(request,response);
					return;
				}
				
				if(validarCampoNoVacio(request.getParameter("inputCbuDestino")) == false ) {
					//Alert diciendo: Falta ingresar el numero de Cbu de destino.
					request.getSession().setAttribute("mensajeDestino","Ingrese el CBU de la cuenta de destino");
					request.setAttribute("tipoMensajeDestino","danger");
					RequestDispatcher rd = request.getRequestDispatcher("/Transferencias.jsp");
					rd.forward(request,response);
					return;
				}
				
				ITransferirDao idao = new TransferirDaoImpl();
				if (idao.ComprobarExistencia(request.getParameter("inputCbuOrigen")) == false ) {
					
					//Alert diciendo: No existe la cuenta de origen ingresada.
					return;
				}
				
				if (idao.ComprobarExistencia(request.getParameter("inputCbuDestino")) == false ) {
					
					//Alert diciendo: No existe la cuenta destino ingresada.
					request.getSession().setAttribute("mensajeDestinoIncorrecto","No existe el CBU de la cuenta de destino ingresada");
					request.setAttribute("tipoMensajeDestinoIncorrecto","danger");
					return;
				}
				
				if (idao.ComprobarSaldo(request.getParameter("inputCbuOrigen"), Integer.valueOf( request.getParameter("cantidadIngresada"))) == false) {
					//Alert diciendo: Saldo Insuficiente!
					request.getSession().setAttribute("mensajeSaldo","Saldo insuficiente en la cuenta destino");
					request.setAttribute("tipoMensajeSaldo","danger");
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
	
	public boolean validarCampoNoVacio(String campo) {
		if (campo == null) {
			return false;
		}
		if (campo.isEmpty()) {
			return false;
		}
		return true;
	}

}
