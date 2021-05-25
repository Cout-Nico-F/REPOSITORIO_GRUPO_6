package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelModificarPersonas extends JPanel {

	JButton btnModificar;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	
	public PanelModificarPersonas() {
		setLayout(null);
		
		JList list = new JList();
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
		txtDNI.setColumns(10);
		txtDNI.setBounds(222, 229, 76, 22);
		add(txtDNI);

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
}
