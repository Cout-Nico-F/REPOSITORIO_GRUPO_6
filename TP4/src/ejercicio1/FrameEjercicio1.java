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
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(54, 37, 56, 16);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellido.setBounds(54, 77, 56, 16);
		contentPane.add(lblApellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefono.setBounds(54, 120, 56, 16);
		contentPane.add(lblTelefono);
		
		JLabel lblFechaNac = new JLabel("Fecha Nac");
		lblFechaNac.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaNac.setBounds(54, 149, 86, 25);
		contentPane.add(lblFechaNac);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(142, 34, 173, 22);
		txtNombre.setName("Nombre");
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(142, 74, 173, 22);
		txtApellido.setName("Apellido");
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setName("Telefono");
		txtTelefono.setBounds(142, 117, 173, 22);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtFechaNac = new JTextField();
		txtFechaNac.setName("Fecha de nacimineto");
		txtFechaNac.setBounds(142, 152, 173, 22);
		contentPane.add(txtFechaNac);
		txtFechaNac.setColumns(10);
		
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
		btnMostrar.setBounds(283, 187, 97, 25);
		contentPane.add(btnMostrar);
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
}
