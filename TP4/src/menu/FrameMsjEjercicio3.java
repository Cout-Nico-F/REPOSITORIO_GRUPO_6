package menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;

public class FrameMsjEjercicio3 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMsjEjercicio3 frame = new FrameMsjEjercicio3();
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
	public FrameMsjEjercicio3() {
		setTitle("Mensaje");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 420, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_info_SO = new JPanel();
		panel_info_SO.setBounds(29, 34, 328, 48);
		contentPane.add(panel_info_SO);
		panel_info_SO.setLayout(null);
		
		JLabel lblInfoUsuario = new JLabel("");
		lblInfoUsuario.setBounds(10, 11, 46, 14);
		panel_info_SO.add(lblInfoUsuario);
		
		JPanel panel_aceptar = new JPanel();
		panel_aceptar.setBounds(95, 110, 209, 40);
		contentPane.add(panel_aceptar);
		
		JButton btnAceptar = new JButton("Aceptar");
		panel_aceptar.add(btnAceptar);
	}
	
}
