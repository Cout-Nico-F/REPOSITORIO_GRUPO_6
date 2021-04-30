package menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.TextField;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class FrameEjercicio2 extends JFrame {

	private JPanel contentPane;
	private JTextField textbox_nota1;
	private JTextField textbox_nota2;
	private JTextField textbox_nota3;

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
		setBounds(100, 100, 705, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNotasDelEstudiante = new JLabel("Notas del estudiante");
		lblNotasDelEstudiante.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNotasDelEstudiante.setBackground(SystemColor.menu);
		lblNotasDelEstudiante.setBounds(48, 29, 133, 14);
		contentPane.add(lblNotasDelEstudiante);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.activeCaption, 2, true));
		panel.setBounds(39, 29, 410, 209);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNota1 = new JLabel("Nota 1:");
		lblNota1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNota1.setBounds(10, 37, 71, 26);
		panel.add(lblNota1);
		
		JLabel lblNota2 = new JLabel("Nota 2:");
		lblNota2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNota2.setBounds(10, 74, 71, 26);
		panel.add(lblNota2);
		
		JLabel lblNota3 = new JLabel("Nota 3:");
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
		lblTps.setHorizontalAlignment(SwingConstants.CENTER);
		lblTps.setBounds(10, 148, 71, 26);
		panel.add(lblTps);
		
		String comboBox_TPS_Opciones [] = {"Aprobado","Desaprobado"};
		JComboBox comboBox_TPS = new JComboBox(comboBox_TPS_Opciones);
		comboBox_TPS.setMaximumRowCount(2);
		
		comboBox_TPS.setBounds(91, 148, 161, 23);
		panel.add(comboBox_TPS);
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
