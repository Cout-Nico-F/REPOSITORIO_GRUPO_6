package presentacion.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import daoImpl.Conexion;
import entidad.Persona;
import negocio.IPersonaNegocio;
import negocioImpl.PersonaNegocioImpl;

public class PanelEliminarPersonas extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JButton btnEliminar;
	private DefaultListModel<Persona> dlmPersonas;
	private JList<Persona> list;
	
	public PanelEliminarPersonas() {
		setLayout(null);
		
		list = new JList<Persona>();
		
		list.setBounds(50, 36, 200, 182);
	
		JLabel lblEliminarUsuarios = new JLabel("Eliminar usuarios");
		lblEliminarUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarUsuarios.setBounds(50, 11, 200, 14);
		add(lblEliminarUsuarios);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmacionEliminar();
			}
		});
		btnEliminar.setBounds(50, 230, 200, 23);
		add(btnEliminar);
		
	    listarPersona();
	}
	
	//Mostrar Lista DB
	public void listarPersona(){
		
		dlmPersonas = new DefaultListModel<Persona>();
		list.setModel(dlmPersonas);		
		String query= "SELECT * from personas";	
		try {
			Conexion cn = new Conexion();
			Connection sql= cn.getSQLConexion();
			Statement st = sql.createStatement();
			ResultSet rs=st.executeQuery(query);			
			while(rs.next())
			{
				Persona p =new Persona();
				p.setDni(rs.getInt("Dni"));
				p.setApellido(rs.getString("Apellido"));
				p.setNombre(rs.getString("Nombre"));			
				dlmPersonas.addElement(p);
			}			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		this.add(list);	
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
	protected boolean EliminarPersona() {
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
		}
		return false;
	}
	public void ConfirmacionEliminar() {
		//Capturo lo que devuelve el JOptionPane en input
		int input = JOptionPane.showConfirmDialog(getRootPane(),"Seguro que desea eliminar el registro seleccionado?","Mensaje de Advertencia",
				JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		
		System.out.println(input);
		
		//Despues pregunto si la opcion que elije el usuario es Si, si es asi elimina el registro de la persona y se muestra un cartel ademas de actualizar la lista
		if(input == JOptionPane.YES_OPTION) {
			if(EliminarPersona()) { //Elimina el registro y actualiza
				JOptionPane.showMessageDialog(getRootPane(), "Persona eliminada correctamente");
			}
			else {
				JOptionPane.showMessageDialog(getRootPane(), "Hubo un problema al eliminar el registro");
			}
		}
		else {
			JOptionPane.showMessageDialog(getRootPane(), "No se elimino el registro");
		}	
	}
}
