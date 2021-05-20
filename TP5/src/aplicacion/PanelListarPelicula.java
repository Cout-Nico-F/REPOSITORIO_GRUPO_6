package aplicacion;

import javax.swing.JPanel;

import clases.Pelicula;


import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;

public class PanelListarPelicula extends JPanel {

	private static final long serialVersionUID = 1L;
	//MNL Declarar JList y Model
	public  JList<Pelicula> list= new JList<Pelicula>();
	public static DefaultListModel<Pelicula> lpModel= new DefaultListModel<Pelicula>();

	public PanelListarPelicula() {
		setLayout(null);
		
		JLabel lblPelicula = new JLabel("Pelicula");
		lblPelicula.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPelicula.setBounds(57, 148, 66, 14);
		add(lblPelicula);


		list.setFont(new Font("Tahoma", Font.BOLD, 13));
		list.setBounds(133, 28, 296, 261);		
		//MNL Set Model
		list.setModel(lpModel);
		add(list);



	}



}


