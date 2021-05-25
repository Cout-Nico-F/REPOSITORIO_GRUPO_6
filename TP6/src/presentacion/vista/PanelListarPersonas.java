package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelListarPersonas extends JPanel {
	private JTable tablaPersonas;
	private DefaultTableModel modelPersonas;
	private String[] nombreColumnas = {"Nombre", "Apellido", "Telefono"};
	
	public PanelListarPersonas() {
		setLayout(null);
		modelPersonas = new DefaultTableModel(null,nombreColumnas);
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
}
