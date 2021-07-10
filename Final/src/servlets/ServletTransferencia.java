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
import negocio.ITransferenciaNegocio;
import negocioImpl.TransferenciaNegocioImpl;

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
		if (request.getParameter("btnTransferir") != null) {
			doPost(request,response);
		}
	}
	
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("btnTransferir") != null) {
			try {
				
				//validar que los input no esten vacíos.
				ComprobarCamposVacios(request);
			
				ITransferenciaNegocio ineg = new TransferenciaNegocioImpl();
				
				if (ineg.ComprobarExistencia(request.getParameter("inputCbuOrigen")) == false ) {
					
					//Alert diciendo: No existe la cuenta de origen ingresada.
					request.getSession().setAttribute("mensajeOrigenIncorrecto","No existe el CBU de la cuenta de origen ingresada");
					request.setAttribute("tipoMensajeOrigenIncorrecto","danger");
					
					return;
				}
				
				if (ineg.ComprobarCuentaPropia(request.getParameter("inputCbuOrigen"),  request.getSession().getAttribute("IdUsuario").toString() ) == false ) {
					
					request.getSession().setAttribute("mensajeOrigenIncorrecto2","No se puede transferir desde la cuenta de otros. Ingrese el cbu de una cuenta propia como origen.");
					request.setAttribute("tipoMensajeOrigenIncorrecto2","danger");
					return;
				}
				
				if(request.getParameter("inputCbuOrigen").equals(request.getParameter("inputCbuDestino"))) {
					
					request.getSession().setAttribute("mensajeDestinoIncorrecto3","Error: Se ingresaron dos cbu iguales en origen y destino.");
					request.setAttribute("tipoMensajeDestinoIncorrecto3","danger");
					return;
				}
				
				if (ineg.ComprobarExistencia(request.getParameter("inputCbuDestino")) == false ) {
					
					//Alert diciendo: No existe la cuenta destino ingresada.
					request.getSession().setAttribute("mensajeDestinoIncorrecto","No existe el CBU de la cuenta de destino ingresada");
					request.setAttribute("tipoMensajeDestinoIncorrecto","danger");
					
					return;
				}
				
				if (ineg.ComprobarSaldo( request.getParameter("inputCbuOrigen")  , Float.valueOf(request.getParameter("inputSaldo")) ) == false) {
					//Alert diciendo: Saldo Insuficiente!
					request.getSession().setAttribute("mensajeSaldo","Saldo insuficiente en la cuenta origen");
					request.setAttribute("tipoMensajeSaldo","danger");
					
					return;
				}
				
				//Si el codigo llega a este punto es porque existen las cuentas y el origen tiene saldo suficiente para realizar la operacion.
				
				//Cartel preguntando Si estamos seguros de querer transferir. 
				
				//Transferencia + Aviso de transferencia Correcta o fallida.
				if (ineg.Transferir(request.getParameter("inputCbuOrigen"), request.getParameter("inputCbuDestino"), Float.valueOf(request.getParameter("inputSaldo")) )) {
					request.getSession().setAttribute("mensajeTransferencia","Transferencia exitosa!");
					request.setAttribute("tipoMensajeTransferencia","success");					
				}
				else {
					request.getSession().setAttribute("mensajeTransferencia","No se pudo realizar la transferencia, contacte con un administrador.");
					request.setAttribute("tipoMensajeTransferencia","danger");	
				}

				
			} finally {
				RequestDispatcher rd = request.getRequestDispatcher("/Transferencias.jsp");
				rd.forward(request,response);
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
	
	public void ComprobarCamposVacios(HttpServletRequest request) {
		
		if(validarCampoNoVacio(request.getParameter("inputCbuOrigen")) == false ) {
			//Alert diciendo: Falta ingresar el numero de Cbu de origen.
			request.getSession().setAttribute("mensajeOrigen","Ingrese el CBU de la cuenta de origen");
			request.setAttribute("tipoMensajeOrigen","danger");
		
			return;
		}
		
		if(validarCampoNoVacio(request.getParameter("inputCbuDestino")) == false ) {
			//Alert diciendo: Falta ingresar el numero de Cbu de destino.
			request.getSession().setAttribute("mensajeDestino","Ingrese el CBU de la cuenta de destino");
			request.setAttribute("tipoMensajeDestino","danger");
			
			return;
		}
		
		if(validarCampoNoVacio(request.getParameter("inputSaldo")) == false ) {
			//Alert diciendo: Falta ingresar el numero de Cbu de destino.
			request.getSession().setAttribute("mensajeSaldoVacio","Ingrese la cantidad a transferir en pesos");
			request.setAttribute("tipoMensajeSaldoVacio","danger");
			
			return;
		}
		
	}

}
