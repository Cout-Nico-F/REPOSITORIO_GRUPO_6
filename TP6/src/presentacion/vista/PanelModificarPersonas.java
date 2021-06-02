package presentacion.vista;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import entidad.Persona;
import negocio.IValidacionesNegocio;

public class PanelModificarPersonas extends JPanel {

	private static final long serialVersionUID = 5663498475142431779L;
	
	JButton btnModificar;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private DefaultListModel<Persona> dlmPersonas;
	private JList<Persona> list;
	private IValidacionesNegocio validaciones;
	//getters and setters suelen ubicarse arriba del constructor, separados de los otros metodos que van abajo
	public JList<Persona> getList(){
		return list;
	}
	
	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public JTextField getTxtDNI() {
		return txtDNI;
	}

	public void setValidaciones(IValidacionesNegocio validaciones) {
		this.validaciones = validaciones;
	}
	
	public JButton getBtnModificar() {
		return btnModificar;
	}
	
	public PanelModificarPersonas() {
		setLayout(null);
		
		list = new JList<Persona>();
		list.setBounds(50, 36, 350, 182);
		add(list);
		
		
		JLabel lblModificar = new JLabel("Seleccione la persona que desea modificar");
		lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificar.setBounds(50, 11, 350, 14);
		add(lblModificar);
		
		btnModificar = new JButton("Modificar");
		
		btnModificar.setBounds(308, 229, 92, 23);
		add(btnModificar);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(50, 229, 76, 22);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();

		txtApellido.setColumns(10);
		txtApellido.setBounds(136, 229, 76, 22);
		add(txtApellido);
		
		txtDNI = new JTextField();
		txtDNI.setEditable(false);
		txtDNI.setColumns(10);
		txtDNI.setBounds(222, 229, 76, 22);
		add(txtDNI);

	}
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}


	public void llenarLista(ArrayList<Persona> lista) {
		dlmPersonas = new DefaultListModel<Persona>();
		list.setModel(dlmPersonas);		
		for (Persona p : lista ) {
						
			dlmPersonas.addElement(p);			
		}
	
	this.add(list);
	}
	
}
