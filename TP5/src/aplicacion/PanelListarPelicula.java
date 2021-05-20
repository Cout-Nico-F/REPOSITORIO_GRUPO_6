package aplicacion;

import javax.swing.JPanel;

import clases.Pelicula;


import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;

public class PanelListarPelicula extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JList<Pelicula> listaPeliculas = new JList<Pelicula>();
	//private DefaultListModel<Pelicula> dlmPeliculas;
	

	public PanelListarPelicula(DefaultListModel<Pelicula> dlmPeliculas) {
		setLayout(null);
		//this.dlmPeliculas = dlmPeliculas;
		
		JLabel lblPelicula = new JLabel("Pelicula");
		lblPelicula.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPelicula.setBounds(10, 130, 66, 14);
		add(lblPelicula);
		
		


		listaPeliculas.setFont(new Font("Tahoma", Font.BOLD, 13));
		listaPeliculas.setBounds(90, 60, 286, 170);		
		//MNL Set Model
		listaPeliculas.setModel(dlmPeliculas);
		add(listaPeliculas);


	}

}


