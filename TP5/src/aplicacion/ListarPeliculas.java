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
import javax.swing.JList;

public class ListarPeliculas extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblPelicula;
	private JList list;
		
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
		
		list = new JList();
		list.setBounds(126, 11, 314, 270);
		contentPane.add(list);
		
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