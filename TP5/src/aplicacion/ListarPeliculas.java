package aplicacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class ListarPeliculas extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
		
	public ListarPeliculas() {
		
		setTitle("Programa");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPelicula = new JLabel("Peliculas");
		lblPelicula.setBounds(75, 86, 46, 14);
		contentPane.add(lblPelicula);
		
		JTextPane tpPeliculas = new JTextPane();
		tpPeliculas.setBounds(148, 11, 218, 201);
		contentPane.add(tpPeliculas);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Películas");
		menuBar.add(mnMenu);
		
		JMenuItem mntmAgregar = new JMenuItem("Agregar");
		mntmAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarPeliculas agregarPeliculas = new AgregarPeliculas();
				agregarPeliculas.setVisible(true);
			}
		});
		mnMenu.add(mntmAgregar);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListarPeliculas listarPeliculas = new ListarPeliculas();
				listarPeliculas.setVisible(true);
			}
		});
		mnMenu.add(mntmListar);
	}
}