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
import negocio.ClienteNegocio;
import negocioImpl.ClienteNegocioImpl;

@WebServlet("/Clientes")
public class servletClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servletClientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Se ejecuta sin llamarlo? Sí, se llama a /Clientes desde el navegador
		ClienteNegocio cNeg = new ClienteNegocioImpl();
		ArrayList<Cliente> c = cNeg.traerClientes();
		request.setAttribute("listaClientes",c);
		RequestDispatcher rd = request.getRequestDispatcher("/ABMLClientes.jsp");
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteNegocio cNeg = new ClienteNegocioImpl();
		int dni = Integer.parseInt(request.getParameter("dni"));
		if(request.getParameter("btnDetalle") != null) {
			request.setAttribute("clienteActual", cNeg.traerCliente(dni));
			request.setAttribute("vista", "detalle");
		}
		if(request.getParameter("btnModificar") != null) {
			request.setAttribute("clienteActual", cNeg.traerCliente(dni));
			request.setAttribute("vista", "modificacion");
		}
		if(request.getParameter("btnEliminar") != null) {
			cNeg.eliminarCliente(dni);
		}
		ArrayList<Cliente> c = cNeg.traerClientes();
		request.setAttribute("listaClientes", c);
		RequestDispatcher rd = request.getRequestDispatcher("/ABMLClientes.jsp");
		rd.forward(request,response);
	}

}
