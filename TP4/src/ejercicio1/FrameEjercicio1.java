package ejercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sun.security.util.Length;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrameEjercicio1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtFechaNac;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameEjercicio1 frame = new FrameEjercicio1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameEjercicio1() {
		setTitle("Contactos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDatosIngresados = new JLabel("Los datos ingresados fueron:");
		lblDatosIngresados.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosIngresados.setBounds(29, 224, 286, 16);
		contentPane.add(lblDatosIngresados);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<JTextField> listaErrores = validarCampos();
				if(listaErrores.isEmpty()) {
					lblDatosIngresados.setText("Los datos ingresados fueron: " + txtNombre.getText()+ " " + txtApellido.getText()+ " " + txtTelefono.getText()+ " " + txtFechaNac.getText());
					limpiarCampos();
				} else {
					String mensaje = new String();
					Iterator<JTextField> i = listaErrores.listIterator();
					while(i.hasNext()) {
						mensaje += i.next().getName() + ", ";
					}
					JOptionPane.showMessageDialog(null, "Ingrese los campos: " + mensaje);
					lblDatosIngresados.setText("Los datos ingresados fueron: ");
				}
			}
		});
		btnMostrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMostrar.setBounds(291, 171, 97, 25);
		contentPane.add(btnMostrar);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 29, 378, 131);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(4, 2, 0, 10));
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblNombre);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtNombre = new JTextField();
		panel.add(txtNombre);
		txtNombre.setName("Nombre");
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellido.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblApellido);
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtApellido = new JTextField();
		panel.add(txtApellido);
		txtApellido.setName("Apellido");
		txtApellido.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblTelefono);
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				validaIngresoNumeros(e);
			}
		});
		panel.add(txtTelefono);
		txtTelefono.setName("Telefono");
		txtTelefono.setColumns(10);
		
		JLabel lblFechaNac = new JLabel("Fecha Nac");
		lblFechaNac.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaNac.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblFechaNac);
		lblFechaNac.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtFechaNac = new JTextField();
		txtFechaNac.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				validaIngresoNumeros(e);
			}
		});
		panel.add(txtFechaNac);
		txtFechaNac.setName("Fecha de nacimineto");
		txtFechaNac.setColumns(10);
	}
	
	
	private List<JTextField> validarCampos() {
		List<JTextField> listRetorno = new LinkedList<JTextField>();
		if(txtNombre.getText().length() == 0) {
			txtNombre.setBackground(Color.RED);
			listRetorno.add(txtNombre);
		}
		if(txtApellido.getText().length()== 0) {
			txtApellido.setBackground(Color.RED);
			listRetorno.add(txtApellido);
		}
		if(txtTelefono.getText().length() == 0) {
			txtTelefono.setBackground(Color.RED);
			listRetorno.add(txtTelefono);
		}
		if(txtFechaNac.getText().length() == 0) {
			txtFechaNac.setBackground(Color.RED);
			listRetorno.add(txtFechaNac);
		}
		return listRetorno;
	}
	
	public void limpiarCampos() {
		txtApellido.setBackground(Color.WHITE);
		txtApellido.setText("");
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setText("");
		txtFechaNac.setBackground(Color.WHITE);
		txtFechaNac.setText("");
		txtTelefono.setBackground(Color.WHITE);
		txtTelefono.setText("");
	}
	
	public void validaIngresoNumeros(KeyEvent e) {
		char c = e.getKeyChar();
		if (Character.isLetter(c)) {
			getToolkit().beep();
			e.consume();
			JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
		}
	}
}
