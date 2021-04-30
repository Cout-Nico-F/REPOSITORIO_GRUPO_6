package menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Color;
import javax.swing.JButton;

public class FrameEjercicio2 extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textbox_nota1;
	private JTextField textbox_nota2;
	private JTextField textbox_nota3;
	private JTextField tfPromedio;
	private JTextField tfCondicion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameEjercicio2 frame = new FrameEjercicio2();
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
	public FrameEjercicio2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 460);
		setTitle("Promedio");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNotasDelEstudiante = new JLabel("Notas del estudiante");
		lblNotasDelEstudiante.setBounds(54, 21, 133, 14);
		lblNotasDelEstudiante.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNotasDelEstudiante.setBackground(Color.LIGHT_GRAY);
		contentPane.add(lblNotasDelEstudiante);
		
		JPanel panel = new JPanel();
		panel.setBounds(39, 29, 315, 209);
		panel.setBorder(new LineBorder(SystemColor.activeCaption, 2, true));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNota1 = new JLabel("Nota 1:");
		lblNota1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNota1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNota1.setBounds(10, 37, 71, 26);
		panel.add(lblNota1);
		
		JLabel lblNota2 = new JLabel("Nota 2:");
		lblNota2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNota2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNota2.setBounds(10, 74, 71, 26);
		panel.add(lblNota2);
		
		JLabel lblNota3 = new JLabel("Nota 3:");
		lblNota3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNota3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNota3.setBounds(10, 111, 71, 26);
		panel.add(lblNota3);
		
		
		textbox_nota1 = new JTextField();
		textbox_nota1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ComprobarNotaIngresada(e);				
			}
		});
		textbox_nota1.setBounds(91, 37, 161, 23);
		panel.add(textbox_nota1);
		textbox_nota1.setColumns(10);
		
		textbox_nota2 = new JTextField();
		textbox_nota2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ComprobarNotaIngresada(e);				
			}
		});
		textbox_nota2.setColumns(10);
		textbox_nota2.setBounds(91, 77, 161, 23);
		panel.add(textbox_nota2);
		
		textbox_nota3 = new JTextField();
		textbox_nota3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ComprobarNotaIngresada(e);				
			}
		});
		
		textbox_nota3.setColumns(10);
		textbox_nota3.setBounds(91, 114, 161, 23);
		panel.add(textbox_nota3);
		
		JLabel lblTps = new JLabel("TPS");
		lblTps.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTps.setHorizontalAlignment(SwingConstants.CENTER);
		lblTps.setBounds(10, 148, 71, 26);
		panel.add(lblTps);
		
		String comboBox_TPS_Opciones [] = {"Aprobado","Desaprobado"};
		JComboBox comboBox_TPS = new JComboBox(comboBox_TPS_Opciones);
		comboBox_TPS.setMaximumRowCount(2);
		
		comboBox_TPS.setBounds(91, 148, 161, 23);
		panel.add(comboBox_TPS);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(399, 103, 146, 54);
		contentPane.add(btnCalcular);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(399, 168, 146, 54);
		contentPane.add(btnNuevo);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(399, 233, 146, 54);
		contentPane.add(btnSalir);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(39, 286, 315, 113);
		panel2.setBorder(new LineBorder(SystemColor.activeCaption));
		contentPane.add(panel2);
		panel2.setLayout(null);
		
		JLabel lblPromedio = new JLabel("Promedio:");
		lblPromedio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPromedio.setBounds(32, 24, 62, 14);
		panel2.add(lblPromedio);
		
		JLabel lblCondicion = new JLabel("Condicion: ");
		lblCondicion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCondicion.setBounds(32, 63, 62, 14);
		panel2.add(lblCondicion);
		
		tfPromedio = new JTextField();
		tfPromedio.setColumns(10);
		tfPromedio.setBounds(104, 21, 161, 23);
		panel2.add(tfPromedio);
		
		tfCondicion = new JTextField();
		tfCondicion.setColumns(10);
		tfCondicion.setBounds(104, 60, 161, 23);
		panel2.add(tfCondicion);
		
		JLabel lblNotasDelEstudiante_1 = new JLabel("Notas del estudiante");
		lblNotasDelEstudiante_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNotasDelEstudiante_1.setBounds(54, 266, 133, 23);
		contentPane.add(lblNotasDelEstudiante_1);
	}
	
	private boolean ComprobarNotaIngresada(FocusEvent e) throws NumberFormatException{
		JTextField tb = (JTextField) e.getComponent();
		String input = tb.getText();
		try {
			float x = Float.valueOf(input).floatValue();
		} catch (NumberFormatException e2) {
			e2.printStackTrace();
			return false;
		}
		return true;
	}
}
