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
	
	public PanelModificarPersonas() {
		
		//**este tramo de codigo es para simular que recibimos el defaultlist desde el set.
		
		dlmPersonas = new DefaultListModel<Persona>();
		Persona p1 = new Persona(1, "juan", "cito");
		Persona p2 = new Persona(2, "Andy", "cach");
		dlmPersonas.addElement(p1);
		dlmPersonas.addElement(p2);
		//**
		setLayout(null);
		
		JList<Persona> list = new JList<Persona>(dlmPersonas);//seteamos el modelo
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				//se carga el registro dentro de un objeto de tipo persona o se castea el model a tipo persona.
				//asignamos a los textfield su contenido desde el registr
				txtNombre.setText( list.getSelectedValue().getNombre() );
				txtApellido.setText( list.getSelectedValue().getApellido() );
				txtDNI.setText( String.valueOf( list.getSelectedValue().getDni()) );
			}
		});
		list.setBounds(50, 36, 350, 182);
		add(list);
		
		JLabel lblModificar = new JLabel("Seleccione la persona que desea modificar");
		lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificar.setBounds(50, 11, 350, 14);
		add(lblModificar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//al presionar el boton modificar:
				//validar que este seleccionado un registro
				//validar que los datos ingresados sean correctos ( no vacio )
				
				
				//comunicarse con negocio.
				ComunicarseConNegocio();
				
				
			}
		});
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

	protected boolean ComunicarseConNegocio() {
		IPersonaNegocio pneg = new PersonaNegocioImpl();
		boolean a = validaciones.ComprobarCampoVacio( (JPanel) getParent(), txtNombre);
		boolean b;
		if(!a) return false;
		b = validaciones.ComprobarCampoVacio( (JPanel) getParent(), txtApellido);
		if(!b) return false;
		
		Persona p = new Persona(Integer.parseInt(txtDNI.getText()),txtNombre.getText(), txtApellido.getText());
		
		//Agregar();
		boolean edited = pneg.edit(p);				
		//comprobar si se pudo agregar
		if(edited == true)
		//avisar carga exitosa de persona
			JOptionPane.showMessageDialog(getRootPane(), "Persona editada Correctamente");
		else 
			JOptionPane.showMessageDialog(getRootPane(), "Hubo un error al editar el registro. No se hicieron modificaciones.");
		return true;
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
