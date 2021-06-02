package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import daoImpl.Conexion;
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
		 this.pnlEliminarPersonas.getBtnEliminar().addActionListener(s->EventoClickBoton_Eliminar_pnlEliminarPersonas(s));

		 
	private void EventoClickBoton_Modificar_pnlModificarPersonas(ActionEvent e) {

		boolean a = validaciones.ComprobarCampoVacio(pnlModificarPersonas,pnlModificarPersonas.getTxtApellido());
		boolean b;
		if(!a) return;
		b = validaciones.ComprobarCampoVacio(pnlModificarPersonas,pnlModificarPersonas.getTxtNombre());
		if(!b) return;
		
		String apellido = pnlModificarPersonas.getTxtApellido().getText();
		String nombre = pnlModificarPersonas.getTxtNombre().getText();
		String dni = pnlModificarPersonas.getTxtDNI().getText();
		Persona p = new Persona(Integer.parseInt(dni),nombre, apellido);
		
		//Agregar();
		boolean edited = pNeg.edit(p);				
		//comprobar si se pudo agregar
		if(edited == true)
		//avisar carga exitosa de persona
			JOptionPane.showMessageDialog(pnlModificarPersonas, "Persona editada Correctamente");
		else 
			JOptionPane.showMessageDialog(pnlModificarPersonas, "Hubo un error al editar el registro. No se hicieron modificaciones.");
		
		EventoClickMenu_AbrirPanel_ModificarPersona(e);
	}
	
	private void EventoClickBoton_Aceptar_pnlAgregarPersonas(ActionEvent a) {
		ComprobarAgregarPersona();
		refrescarTabla();
	}
	
	private void EventoClickBoton_Eliminar_pnlEliminarPersonas(ActionEvent a) {
		
		//EliminarPersona(pnlEliminarPersonas.getList(), pnlEliminarPersonas.getDlm());
		ConfirmacionEliminar(pnlEliminarPersonas.getList(), pnlEliminarPersonas.getDlm());
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
		this.refrescarTabla();
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlEliminarPersonas);
		ventanaPrincipal.setSize(460, 350);
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
		pnlModificarPersonas.llenarModel(tablaPersonas);
		pnlEliminarPersonas.llenarLista(tablaPersonas);
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
	
	
	public void ConfirmacionEliminar( JList<Persona> list , DefaultListModel<Persona> dlmPersonas) {
		//Capturo lo que devuelve el JOptionPane en input
		int input = JOptionPane.showConfirmDialog(null,"Seguro que desea eliminar el registro seleccionado?","Mensaje de Advertencia",
				JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		
		System.out.println(input);
		
		//Despues pregunto si la opcion que elije el usuario es Si, si es asi elimina el registro de la persona y se muestra un cartel ademas de actualizar la lista
		if(input == JOptionPane.YES_OPTION) {
			if(EliminarPersona(list, dlmPersonas)) { //Elimina el registro y actualiza
				JOptionPane.showMessageDialog(null, "Persona eliminada correctamente");
			}
			else {
				JOptionPane.showMessageDialog(null, "Hubo un problema al eliminar el registro");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "No se elimino el registro");
		}	
	}
	
	protected boolean EliminarPersona( JList<Persona> list, DefaultListModel<Persona> dlmPersonas ) {
		IPersonaNegocio pneg = new PersonaNegocioImpl();
		
		int index;
		boolean delete;
		
		
		Persona p = list.getSelectedValue();
		
		delete = pneg.delete(p);		
		
		//Comprobar si se pudo eliminar
		if(delete) {
			//En caso de que si guarda el index el indice del registro seleccionado y lo remueve del modelo
			index = list.getSelectedIndex();
			dlmPersonas.removeElementAt(index);
			return true;
		}
		return false;
	}
	
}





