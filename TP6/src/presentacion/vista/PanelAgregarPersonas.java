package presentacion.vista;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelAgregarPersonas extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;	
	private JButton btnAceptar;
	
	private JTable tablaPersonas;
	private String[] nombreColumnas = {"Nombre","Apellido","Dni"};
	private DefaultTableModel modelPersonas;
	
	 public PanelAgregarPersonas() {
		super();
		initialize();
	}
	
	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}
	
	private void initialize() 
	{
		this.setBounds(100, 100, 439, 222);
		this.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(15, 37, 403, 159);
		this.add(panel_1);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(30, 16, 170, 14);
		panel_1.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(30, 47, 113, 14);
		panel_1.add(lblApellido);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent k) {
				ComprobarSoloLetras(k);
			}
		});
		txtNombre.setColumns(10);
		txtNombre.setBounds(204, 13, 164, 20);
		panel_1.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent k) {
				ComprobarSoloLetras(k);
			}
		});
		txtApellido.setColumns(10);
		txtApellido.setBounds(204, 44, 164, 20);
		panel_1.add(txtApellido);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(30, 119, 89, 23);
		panel_1.add(btnAceptar);
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(204, 75, 164, 20);
		panel_1.add(txtDNI);
		
		JLabel lblDni = new JLabel("DNI");
		txtDNI.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent k) {
				ComprobarSoloNumeros(k);
			}
		});
		lblDni.setBounds(30, 78, 170, 14);
		panel_1.add(lblDni);
	}
	
	protected void ComprobarSoloNumeros(KeyEvent k) {
		if(Character.isDigit(k.getKeyChar()) == false) { //Si no es un digito:
			getToolkit().beep(); //Get a sound -> si esta comentado se bugea el sonido de error
			k.consume(); //Funciona para no llamar a mas eventos como el KeyListener -> si esta comentado no borra la tecla erronea ingresada
		JOptionPane.showMessageDialog(getRootPane(), "Ingresar solo numeros");
		}
		
	}

	protected void ComprobarSoloLetras(KeyEvent k) {
		if(Character.isLetter(k.getKeyChar()) == false) { //Si no es una letra:
			getToolkit().beep(); //Get a sound -> si esta comentado se bugea el sonido de error
			k.consume(); //Funciona para no llamar a mas eventos como el KeyListener -> si esta comentado no borra la tecla erronea ingresada
		JOptionPane.showMessageDialog(getRootPane(), "Ingresar solo letras");
		}
	}

	public void show()
	{
		this.setVisible(true);
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
	public DefaultTableModel getModelPersonas() 
	{
		return modelPersonas;
	}
	
	public JTable getTablaPersonas()
	{
		return tablaPersonas;
	}

	public String[] getNombreColumnas() 
	{
		return nombreColumnas;
	}
	
	public void llenarTabla(List<Persona> personasEnTabla) {
		this.getModelPersonas().setRowCount(0); //Para vaciar la tabla
		this.getModelPersonas().setColumnCount(0);
		this.getModelPersonas().setColumnIdentifiers(this.getNombreColumnas());

		for (Persona p : personasEnTabla)
		{
			String nombre = p.getNombre();
			String ape = p.getApellido();
			int dni = p.getDni();
			Object[] fila = {nombre,ape,dni};
			this.getModelPersonas().addRow(fila);
		}
		
	}
	
	
}
