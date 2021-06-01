package presentacion.vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;
import negocio.IPersonaNegocio;
import negocioImpl.PersonaNegocioImpl;

public class PanelListarPersonas extends JPanel {
	
	private JTable tablaPersonas;
	private DefaultTableModel modelPersonas;
	private String[] nombreColumnas = {"Nombre", "Apellido", "Dni"};
	private PersonaNegocioImpl pni;
	
	public PanelListarPersonas() {
		setLayout(null);
		
		modelPersonas = new DefaultTableModel(null,nombreColumnas);
		//modelPersonas.
		
		
		tablaPersonas = new JTable(modelPersonas);
		tablaPersonas.setBounds(10, 11, 380, 253);
		
		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(0).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(1).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(2).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(2).setResizable(false);
		
		//cargar la lista desde base de datos (comunicarse con negocio)
		//ComunicarseConNegocio();
		List<Persona> listaPersonas = new ArrayList<Persona>();
		PersonaNegocioImpl pni = new PersonaNegocioImpl();
		listaPersonas = pni.obtenerTodas();
		llenarTabla(listaPersonas);
		
		
		JScrollPane spPersonas = new JScrollPane();
		
		spPersonas.setBounds(15, 11, 380, 250);
		add(spPersonas);
		
		spPersonas.setViewportView(tablaPersonas);

	}

	public void llenarTabla(List<Persona> personasEnTabla) {
		modelPersonas.setRowCount(0); //Para vaciar la tabla
		modelPersonas.setColumnCount(0);
		modelPersonas.setColumnIdentifiers(nombreColumnas);

		for (Persona p : personasEnTabla)
		{
			String nombre = p.getNombre();
			String apellido = p.getApellido();
			int dni = p.getDni(); 
			Object[] fila = {nombre, apellido, dni};
			modelPersonas.addRow(fila);
		}
	}
	
}

