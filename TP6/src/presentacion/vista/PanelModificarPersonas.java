package presentacion.vista;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionListener;

import entidad.Persona;
import negocio.IPersonaNegocio;
import negocio.IValidacionesNegocio;
import negocioImpl.PersonaNegocioImpl;

import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.ListIterator;

public class PanelModificarPersonas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5663498475142431779L;
	
	JButton btnModificar;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private DefaultListModel<Persona> dlmPersonas;
	private IValidacionesNegocio validaciones;
	private JList<Persona> lista;
	
	public JList<Persona> getLista() {
		return lista;
	}

	public void setLista(JList<Persona> lista) {
		this.lista = lista;
	}

	public PanelModificarPersonas() {
		setLayout(null);
		dlmPersonas = new DefaultListModel<Persona>();
		lista = new JList<>(dlmPersonas);//seteamos el modelo
		
		lista.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				//se carga el registro dentro de un objeto de tipo persona o se castea el model a tipo persona.
				//asignamos a los textfield su contenido desde el registr
				txtNombre.setText(lista.getSelectedValue().getNombre());
				txtApellido.setText( lista.getSelectedValue().getApellido() );
				txtDNI.setText( String.valueOf( lista.getSelectedValue().getDni()) );
			}
		});
		lista.setBounds(50, 36, 350, 182);
		add(lista);
		
		JLabel lblModificar = new JLabel("Seleccione la persona que desea modificar");
		lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificar.setBounds(50, 11, 350, 14);
		add(lblModificar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(308, 229, 92, 23);
		add(btnModificar);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent k) {
				validaciones.ComprobarSoloLetras(k, (JPanel) getParent());
			}
		});
		txtNombre.setBounds(50, 229, 76, 22);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent k) {
				validaciones.ComprobarSoloLetras(k, (JPanel) getParent());
			}
		});
		txtApellido.setColumns(10);
		txtApellido.setBounds(136, 229, 76, 22);
		add(txtApellido);
		
		txtDNI = new JTextField();
		txtDNI.setEditable(false);
		txtDNI.setColumns(10);
		txtDNI.setBounds(222, 229, 76, 22);
		add(txtDNI);

	}

	public void llenarModel(ArrayList<Persona> listaPersonas) {
		dlmPersonas.setSize(0); //para vaciar el model
		ListIterator<Persona> i = listaPersonas.listIterator();
		while(i.hasNext()) {
			dlmPersonas.addElement(i.next());			
		}
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}
	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtDNI() {
		return txtDNI;
	}

	public void setTxtDNI(JTextField txtDNI) {
		this.txtDNI = txtDNI;
	}

	public void setDlmPersonas(DefaultListModel<Persona> dlmPersonas) { //Metodo que usa el controlador para setear el model que viene de dao
		this.dlmPersonas = dlmPersonas;
	}
	
	public void setValidaciones(IValidacionesNegocio validaciones) {
		this.validaciones = validaciones;
	}
	
	
}
