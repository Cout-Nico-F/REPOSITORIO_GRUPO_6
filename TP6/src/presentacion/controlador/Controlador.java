package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entidad.Persona;
import negocio.IValidacionesNegocio;
import negocio.IPersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
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
	private IValidacionesNegocio validaciones;

	public Controlador(VentanaPrincipal vista, IPersonaNegocio pNeg)
	{
		validaciones = new ValidacionesNegocioImpl();
		//Guardo todas las instancias que recibo en el constructor
		this.ventanaPrincipal = vista;
		this.pNeg = pNeg;
		
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

		
		
		//Eventos PanelAgregarPersonas
		 this.pnlAgregarPersonas.getBtnAceptar().addActionListener(a->EventoClickBoton_Aceptar_pnlAgregarPersonas(a));

		
		//Eventos PanelEliminarPersonas
		// this.pnlEliminarPersonas.getBtnEliminar().addActionListener(s->EventoClickBoton_BorrarPesona_PanelEliminarPersonas(s));
		 //TODO: mover eventos de eliminar personas a esta sección/capa
		//Eventos PanelModificarPersona
		//TODO: mover eventos de modificar personas a esta sección/capa
	
	}
	
	private void EventoClickBoton_Aceptar_pnlAgregarPersonas(ActionEvent a) {
		ComprobarAgregarPersona();
		refrescarTabla();
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
	}
	
	public void EventoClickMenu_AbrirPanel_ModificarPersona(ActionEvent a)
	{	
		IValidacionesNegocio validaciones = new ValidacionesNegocioImpl();
		pnlModificarPersonas.setValidaciones(validaciones);
		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlModificarPersonas);
		ventanaPrincipal.setSize(460, 350);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	public void EventoClickMenu_AbrirPanel_ListarPersona(ActionEvent a)
	{	
		this.refrescarTabla();
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
		tablaPersonas = (ArrayList<Persona>) pNeg.readAll();
		pnlAgregarPersonas.llenarTabla(tablaPersonas);
		pnlListarPersonas.llenarTabla(tablaPersonas);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	
	private void ComprobarAgregarPersona() {
		
		IPersonaNegocio pneg = new PersonaNegocioImpl();
		boolean a = validaciones.ComprobarCampoVacio(pnlAgregarPersonas,pnlAgregarPersonas.getTxtNombre());
		boolean b,c;
		
		if( !a ) return;
		else {
			b = validaciones.ComprobarCampoVacio(pnlAgregarPersonas,pnlAgregarPersonas.getTxtApellido());
			if( !b ) return;
			else{
				c =validaciones.ComprobarCampoVacio(pnlAgregarPersonas,pnlAgregarPersonas.getTxtDNI());
			}
		}
		
		String DNI= pnlAgregarPersonas.getTxtDNI().getText();
		String Nombre= pnlAgregarPersonas.getTxtNombre().getText();
		String Apellido= pnlAgregarPersonas.getTxtApellido().getText();
		
		if( a && b && c ) {
			//Armar un registro de persona
			Persona p = new Persona(Integer.parseInt(DNI),Nombre, Apellido);
			//Agregar persona
			
			boolean result = pneg.Exists(p.getDni());
			
			if(result) {
				//Avisar persona ya existente
				JOptionPane.showMessageDialog(pnlAgregarPersonas.getRootPane(), "El Dni ingresado ya se encuentra registrado en la base de datos");
				vaciarTextFields();
			}
			else {
				//Agregar();
				boolean inserted = pneg.insert(p);
				//comprobar si se pudo agregar
				if(inserted) {
					JOptionPane.showMessageDialog(pnlAgregarPersonas.getRootPane(), "Persona agregada correctamente");
					vaciarTextFields();
				}
				//avisar carga exitosa de persona
				
				else {
					JOptionPane.showMessageDialog(pnlAgregarPersonas.getRootPane(), "Hubo un error al agregar el registro. No se hicieron modificaciones.");
					vaciarTextFields();
				}
			}
		}
	}

	private void vaciarTextFields() {
		pnlAgregarPersonas.getTxtNombre().setText("");
		pnlAgregarPersonas.getTxtApellido().setText("");
		pnlAgregarPersonas.getTxtDNI().setText("");
	}
}
