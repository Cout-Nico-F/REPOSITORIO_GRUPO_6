package presentacion.vista;

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

public class PanelEliminarPersonas extends JPanel {
	
	JButton btnEliminar;
	private DefaultListModel<Persona> dlmPersonas;
	public PanelEliminarPersonas() {
		setLayout(null);
		
		JList<Persona> list = new JList<Persona>();
		list.setBounds(50, 36, 200, 182);
		
		
		JLabel lblEliminarUsuarios = new JLabel("Eliminar usuarios");
		lblEliminarUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarUsuarios.setBounds(50, 11, 200, 14);
		add(lblEliminarUsuarios);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(50, 230, 200, 23);
		add(btnEliminar);
		
		//Comienzo desarrollo eliminar 
		
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
		
		

		
		
		
		
		/*
		Persona p1 = new Persona(1, "lola", "cito");
		Persona p2 = new Persona(2, "maria", "cach");
		*/
		

		//
		add(list);
		
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
