package aplicacion;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;


public class AgregarPeliculas extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JComboBox<String> cbCategoria;
	
	
	
	public AgregarPeliculas() {
		setTitle("Programa");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(69, 40, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(69, 77, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(69, 121, 46, 14);
		contentPane.add(lblGenero);
		
		textField = new JTextField();
		textField.setBounds(161, 74, 136, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblID = new JLabel("New label");
		lblID.setBounds(160, 40, 46, 14);
		contentPane.add(lblID);
		
		cbCategoria = new JComboBox<String>();
		cbCategoria.setBounds(161, 118, 136, 20);
		contentPane.add(cbCategoria);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(66, 159, 119, 23);
		contentPane.add(btnAceptar);
		
		setVisible(true);
	}
}