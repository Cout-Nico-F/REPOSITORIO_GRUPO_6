package aplicacion;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import clases.Pelicula;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;

public class PanelAgregarPelicula extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNombre;
	private JComboBox<String> cbGenero;

	public PanelAgregarPelicula() {
		setLayout(null);
		
		JLabel lblid = new JLabel("ID");
		lblid.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblid.setBounds(71, 40, 46, 14);
		add(lblid);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBounds(71, 81, 63, 14);
		add(lblNombre);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGenero.setBounds(71, 128, 46, 14);
		add(lblGenero);
		
		tfNombre = new JTextField();
		tfNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		tfNombre.setBounds(157, 78, 118, 20);
		add(tfNombre);
		tfNombre.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAceptar.setBounds(71, 179, 89, 23);
		add(btnAceptar);
		
		cbGenero = new JComboBox<String>();
		cbGenero.addItem("Seleccione un genero");
		cbGenero.addItem("Terror");
		cbGenero.addItem("Accion");
		cbGenero.addItem("Suspenso");
		cbGenero.addItem("Romantica");
		cbGenero.setToolTipText("Seleccione un genero");
		cbGenero.setFont(new Font("Tahoma", Font.BOLD, 13));
		cbGenero.setBounds(157, 125, 118, 20);
		add(cbGenero);
		
		JLabel lblID = new JLabel("");
		lblID.setText(String.valueOf(Pelicula.getCount()));
		lblID.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblID.setBounds(159, 41, 56, 14);
		add(lblID);

	}
}
