package presentacion.vista;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;

public class PanelListarPersonas extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tablaPersonas;
	private DefaultTableModel modelPersonas;
	private String[] nombreColumnas = {"Nombre", "Apellido", "Dni"};
	public PanelListarPersonas() {
		setLayout(null);
		
		modelPersonas = new DefaultTableModel(null,nombreColumnas) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		       //impide que el usuario pueda editar el contenido
		       return false;
		    }
		};
		
		
		tablaPersonas = new JTable(modelPersonas);
		tablaPersonas.setBounds(10, 11, 380, 253);
		
		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(0).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(1).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(2).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(2).setResizable(false);

		
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

