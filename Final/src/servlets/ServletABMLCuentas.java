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
import entidad.Cuenta;
import entidad.TipoDeCuenta;
import entidad.VariablesGlobales;
import negocio.ClienteNegocio;
import negocio.IAdminNegocio;
import negocioImpl.AdminNegocioImpl;
import negocioImpl.ClienteNegocioImpl;


@WebServlet("/ServletABMLCuentas")
public class ServletABMLCuentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IAdminNegocio admNeg = new AdminNegocioImpl();
    private ClienteNegocio cliNeg = new ClienteNegocioImpl(); 
	
    public ServletABMLCuentas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("firstLoad")!=null) 
		{
			if(request.getParameter("firstLoad").equals("1")) 
			{
				ArrayList<TipoDeCuenta> listaTiposCta = admNeg.listarTiposCuenta();
				request.setAttribute("listaTiposCta", listaTiposCta);
				request.setAttribute("firstLoad", null);
			
				ArrayList<Cliente> listaClientes = cliNeg.traerClientes(VariablesGlobales.cantMaxCuentasPorCliente);
				request.setAttribute("listaClientes", listaClientes);
			}	
		}
		
		//Listamos las cuentas con los clientes.
		//Guardamos todas las cuentas
		ArrayList<Cuenta> listaCuentas = admNeg.listarCuentas();
		request.setAttribute("listaCuentas", listaCuentas);
		
		
		//Guardamos los clientes
		ArrayList<Cliente> listaClientesDeCuentas = new ArrayList<Cliente>();
		for (Cuenta cuenta : listaCuentas) {
			listaClientesDeCuentas.add(admNeg.buscarCliente(cuenta.getDNI()));
		}
		request.setAttribute("listaClientesDeCuentas", listaClientesDeCuentas);
		
		RequestDispatcher rd = request.getRequestDispatcher("/ABMLCuentas.jsp");   
		rd.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
