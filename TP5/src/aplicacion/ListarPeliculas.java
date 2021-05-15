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

import java.awt.Font;

public class ListarPeliculas extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblPelicula;
	private JTextPane tpPeliculas;
		
	public ListarPeliculas() {
		
		setTitle("Programa");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 200, 484, 352);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPelicula = new JLabel("Peliculas");
		lblPelicula.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPelicula.setBounds(60, 117, 73, 24);
		contentPane.add(lblPelicula);
		
		tpPeliculas = new JTextPane();
		tpPeliculas.setBounds(131, 11, 307, 248);
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