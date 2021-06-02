package presentacion.vista;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import entidad.Persona;


public class PanelEliminarPersonas extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JButton btnEliminar;
	private DefaultListModel<Persona> dlmPersonas;
	private JList<Persona> list;
	
	public DefaultListModel<Persona> getDlm() {
		return dlmPersonas;
	}

	public void setDlm(DefaultListModel<Persona> dlmPersonas) {
		this.dlmPersonas = dlmPersonas;
	}
	
	public JList<Persona> getList() {
		return list;
	}


	public void setList(JList<Persona> list) {
		this.list = list;
	}


	public PanelEliminarPersonas() {
		setLayout(null);
		
		list = new JList<Persona>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(50, 36, 341, 181);
	
		JLabel lblEliminarUsuarios = new JLabel("Eliminar usuarios");
		lblEliminarUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarUsuarios.setBounds(126, 9, 200, 14);
		add(lblEliminarUsuarios);
		
		btnEliminar = new JButton("Eliminar");
		
		btnEliminar.setBounds(126, 230, 200, 23);
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
	
	
	
public void llenarLista(ArrayList<Persona> lista){
		dlmPersonas = new DefaultListModel<Persona>();
		list.setModel(dlmPersonas);		
		for (Persona p : lista ) {
			
			
			dlmPersonas.addElement(p);
			
		}
	
	this.add(list);
	
	}
	

	


	

}
