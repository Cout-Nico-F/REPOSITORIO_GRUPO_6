package aplicacion;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Pelicula;

public class MenuPeliculas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static DefaultListModel<Pelicula> dlmListaPeliculas;

	public MenuPeliculas() {
		dlmListaPeliculas = new DefaultListModel<Pelicula>();
		
		setTitle("Programa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 250, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnMenu = new JMenu("Películas");
		menuBar.add(mnMenu);
		
		JMenuItem mntmAgregar = new JMenuItem("Agregar");
		mnMenu.add(mntmAgregar);
		mntmAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				PanelAgregarPelicula pap = new PanelAgregarPelicula();
				pap.setDlmListaPeliculas(dlmListaPeliculas);
				contentPane.add(pap);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mnMenu.add(mntmListar);
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				PanelListarPelicula plp = new PanelListarPelicula();
				contentPane.add(plp);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		
		setVisible(true);
	}
}