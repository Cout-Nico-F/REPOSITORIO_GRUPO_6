package aplicacion;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;

public class PanelListarPelicula extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelListarPelicula() {
		setLayout(null);
		
		JLabel lblPelicula = new JLabel("Pelicula");
		lblPelicula.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPelicula.setBounds(57, 148, 66, 14);
		add(lblPelicula);
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.BOLD, 13));
		list.setBounds(133, 28, 296, 261);
		add(list);

	}

}
