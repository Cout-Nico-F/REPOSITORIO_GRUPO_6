package presentacion.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
				// No necesitamos validaciones
				if(EliminarPersona()) {
					//Mensaje de exito
					JOptionPane.showMessageDialog(getRootPane(), "Persona Eliminada Correctamente");
					listarPersona();
					
				}
				else {
					JOptionPane.showMessageDialog(getRootPane(), "Hubo un error al editar el registro. No se hicieron modificaciones.");
				}
			}
		});
		btnEliminar.setBounds(50, 230, 200, 23);
		add(btnEliminar);
		
		//Comienzo desarrollo eliminar 
		
	    listarPersona();
		//add(list);
		
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
		
		//La persona debe ser la seleccionada
		
		Persona p = list.getSelectedValue();
		
		boolean delete = pneg.delete(p);		
		
		//comprobar si se pudo agregar
		if(delete) {
			return true;
		}
		return false;
		
	}
}
