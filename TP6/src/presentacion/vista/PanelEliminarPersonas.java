package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelEliminarPersonas extends JPanel {
	
	JButton btnEliminar;
	
	public PanelEliminarPersonas() {
		setLayout(null);
		
		JList list = new JList();
		list.setBounds(50, 36, 200, 182);
		add(list);
		
		JLabel lblEliminarUsuarios = new JLabel("Eliminar usuarios");
		lblEliminarUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarUsuarios.setBounds(50, 11, 200, 14);
		add(lblEliminarUsuarios);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(50, 230, 200, 23);
		add(btnEliminar);

	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
}
