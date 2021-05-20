package aplicacion;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import clases.Categoria;
import clases.Pelicula;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAgregarPelicula extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNombre;
	private JComboBox<Categoria> cbGenero;
	private DefaultListModel<Pelicula> dlmListaPeliculas;

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
		
		JLabel lblGenero = new JLabel("G\u00E9nero");
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGenero.setBounds(71, 128, 46, 14);
		add(lblGenero);
		
		tfNombre = new JTextField();
		tfNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		tfNombre.setBounds(157, 78, 170, 20);
		add(tfNombre);
		tfNombre.setColumns(30);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pelicula pelicula = new Pelicula();
				pelicula.setNombre(tfNombre.getText());
				pelicula.setCategoria((Categoria)cbGenero.getSelectedItem());
				dlmListaPeliculas.addElement(pelicula);


				if(cbGenero.getSelectedIndex()!=0 && tfNombre.getText()!="") {
				PanelListarPelicula.lpModel.addElement(pelicula);			
				}
				else {
					JOptionPane.showMessageDialog(null, "complete todos los datos");
				}
				//MNL Agregado de Evento Aceptar - Agregar pelicula a Model
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAceptar.setBounds(71, 179, 89, 23);
		add(btnAceptar);
		
		cbGenero = new JComboBox<Categoria>();
		Categoria aux = new Categoria("Seleccione un g\u00E9nero");
		cbGenero.addItem(aux);
		cbGenero.addItem(new Categoria("Terror"));
		cbGenero.addItem(new Categoria("Accion"));
		cbGenero.addItem(new Categoria("Suspenso"));
		cbGenero.addItem(new Categoria("Romantica"));
		cbGenero.setToolTipText(aux.toString());
		cbGenero.setFont(new Font("Tahoma", Font.BOLD, 13));
		cbGenero.setBounds(157, 125, 170, 20);
		add(cbGenero);
		
		JLabel lblID = new JLabel("");
		lblID.setText(String.valueOf(Pelicula.getCount()));
		lblID.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblID.setBounds(159, 41, 56, 14);
		add(lblID);
	}
	

	public void setDlmListaPeliculas(DefaultListModel<Pelicula> dlmListaPeliculas) {
		this.dlmListaPeliculas = dlmListaPeliculas;
	}
}
