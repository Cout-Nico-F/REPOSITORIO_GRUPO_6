package aplicacion;

import javax.swing.JPanel;

import clases.Pelicula;
import clases.ComparadorPeliculas;


import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;
import java.util.TreeSet;

public class PanelListarPelicula extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JList<Pelicula> listaOrdenada = new JList<Pelicula>();
	
	

	public PanelListarPelicula(DefaultListModel<Pelicula> dlmPeliculas) {
		setLayout(null);
		
		
		JLabel lblPelicula = new JLabel("Pelicula");
		lblPelicula.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPelicula.setBounds(10, 92, 66, 14);
		add(lblPelicula);
		
		ComparadorPeliculas cp = new ComparadorPeliculas();
		TreeSet<Pelicula> peliculasOrdenadas = new TreeSet<Pelicula>(cp);
		
		//por cada item dentro del model lo agrego al treeset
		for ( int i=0; i< dlmPeliculas.getSize(); i++) {
			peliculasOrdenadas.add(dlmPeliculas.getElementAt(i));
		}
		
		DefaultListModel<Pelicula> modelOrdenada = new DefaultListModel<Pelicula>();
		
		//por cada item en el treeset lo paso a la nueva lista mediante su model
		for (Pelicula pelicula : peliculasOrdenadas) {
			modelOrdenada.addElement(pelicula);
		}
		
		listaOrdenada.setFont(new Font("Tahoma", Font.BOLD, 13));
		listaOrdenada.setBounds(90, 22, 510, 170);				
		listaOrdenada.setModel(modelOrdenada);
		add(listaOrdenada);
	}

}


