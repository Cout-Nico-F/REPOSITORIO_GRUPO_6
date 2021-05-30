package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import entidad.Persona;
import negocio.IValidacionesNegocio;
import negocio.IPersonaNegocio;
import negocioImpl.ValidacionesNegocioImpl;
import presentacion.vista.PanelAgregarPersonas;
import presentacion.vista.PanelEliminarPersonas;
import presentacion.vista.PanelListarPersonas;
import presentacion.vista.PanelModificarPersonas;
import presentacion.vista.VentanaPrincipal;


public class Controlador implements ActionListener {
	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregarPersonas pnlAgregarPersonas;
	private PanelEliminarPersonas pnlEliminarPersonas;
	private PanelModificarPersonas pnlModificarPersonas;
	private PanelListarPersonas pnlListarPersonas;
	private IPersonaNegocio pNeg;
	private ArrayList<Persona> tablaPersonas;

	public Controlador(VentanaPrincipal vista, IPersonaNegocio pNeg)
	{
		//Guardo todas las instancias que recibo en el constructor
		this.ventanaPrincipal = vista;
		
		//Instancio los paneles
		this.pnlAgregarPersonas = new PanelAgregarPersonas();
		this.pnlEliminarPersonas = new PanelEliminarPersonas();
		this.pnlModificarPersonas = new PanelModificarPersonas();
		this.pnlListarPersonas = new PanelListarPersonas();

		//Eventos menu del Frame principal llamado Ventana
		this.ventanaPrincipal.getMenuAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
		this.ventanaPrincipal.getMenuEliminar().addActionListener(a->EventoClickMenu_AbrirPanel_EliminarPersona(a));
		this.ventanaPrincipal.getMenuModificar().addActionListener(a->EventoClickMenu_AbrirPanel_ModificarPersona(a));
		this.ventanaPrincipal.getMenuListar().addActionListener(a->EventoClickMenu_AbrirPanel_ListarPersona(a));

		}
	
	//EventoClickMenu abrir PanelAgregarPersonas
	public void  EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a)
	{	
		IValidacionesNegocio validaciones = new ValidacionesNegocioImpl();
		pnlAgregarPersonas.ConfigurarControladorValidaciones(validaciones);
		//estas validaciones se pueden usar en todas las otras ventanas del proyecto para validad campos
		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlAgregarPersonas);
		ventanaPrincipal.setSize(440, 300);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	//EventoClickMenu abrir PanelEliminarPersonas
	public void EventoClickMenu_AbrirPanel_EliminarPersona(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlEliminarPersonas);
		ventanaPrincipal.setSize(315, 350);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
		
		this.refrescarTabla();
	}
	
	public void EventoClickMenu_AbrirPanel_ModificarPersona(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlModificarPersonas);
		ventanaPrincipal.setSize(460, 350);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	public void EventoClickMenu_AbrirPanel_ListarPersona(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlListarPersonas);
		ventanaPrincipal.setSize(420, 350);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}		
	
	public void inicializar()
	{
		this.ventanaPrincipal.setVisible(true);
	}
	
	private void refrescarTabla()
	{
		this.tablaPersonas = (ArrayList<Persona>) pNeg.readAll();
		this.pnlAgregarPersonas.llenarTabla(this.tablaPersonas);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
