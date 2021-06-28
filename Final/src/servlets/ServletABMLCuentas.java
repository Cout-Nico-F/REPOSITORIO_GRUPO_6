package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Cliente;
import entidad.VariablesGlobales;
import negocio.ClienteNegocio;
import negocio.IAdminNegocio;
import negocioImpl.AdminNegocioImpl;
import negocioImpl.ClienteNegocioImpl;


@WebServlet("/ServletABMLCuentas")
public class ServletABMLCuentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletABMLCuentas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("firstLoad")!=null) 
		{
			if(request.getParameter("firstLoad").equals("1")) 
			{
				IAdminNegocio admNeg = new AdminNegocioImpl();
				ArrayList<String> listaTiposCta = admNeg.listarTiposCuenta();
				request.setAttribute("listaTiposCta", listaTiposCta);
				request.setAttribute("firstLoad", null);
			
			
				ClienteNegocio cliNeg = new ClienteNegocioImpl();
				ArrayList<Cliente> listaClientes = cliNeg.traerClientes(VariablesGlobales.cantMaxCuentasPorCliente);
				request.setAttribute("listaClientes", listaClientes);
			}
		
			
			
		RequestDispatcher rd = request.getRequestDispatcher("/ABMLCuentas.jsp");   
		rd.forward(request, response);
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
