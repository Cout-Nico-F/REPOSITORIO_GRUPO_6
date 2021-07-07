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

	/* DoGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	*/
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("btnTransferir") != null) {
			try {
				
				//validar que los input no esten vacíos.
				if(validarCampoNoVacio(request.getParameter("cbuOrigen")) == false ) {
					//Alert diciendo: Falta ingresar el numero de Cbu de origen.
					return;
				}
				
				if(validarCampoNoVacio(request.getParameter("cbuDestino")) == false ) {
					//Alert diciendo: Falta ingresar el numero de Cbu de destino.
					return;
				}
				
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
	
	public boolean validarCampoNoVacio(String campo) {
		if (campo.isEmpty()) {
			return false;
		}
		return true;
	}

}
