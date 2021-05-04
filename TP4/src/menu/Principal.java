package menu;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ejercicio1.FrameEjercicio1;
import ejercicio2.FrameEjercicio2;
import ejercicio3.FrameEjercicio3;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEjercicio1 = new JButton("Ejercicio 1");
		btnEjercicio1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameEjercicio1 e1 = new FrameEjercicio1();
				e1.setVisible(true);
			}
		});
		btnEjercicio1.setBounds(154, 63, 97, 25);
		contentPane.add(btnEjercicio1);
		
		JButton btnEjercicio2 = new JButton("Ejercicio 2");
		btnEjercicio2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameEjercicio2 e2 = new FrameEjercicio2();
				e2.setVisible(true);
			}
		});
		btnEjercicio2.setBounds(154, 119, 97, 25);
		contentPane.add(btnEjercicio2);
		
		JButton btnEjercicio3 = new JButton("Ejercicio 3");
		btnEjercicio3.setBounds(154, 170, 97, 25);
		btnEjercicio3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameEjercicio3 e3 = new FrameEjercicio3();
				e3.setVisible(true);
			}
		});
		contentPane.add(btnEjercicio3);
		
		JLabel lblGrupoN = new JLabel("GRUPO N\u00B0 6");
		lblGrupoN.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGrupoN.setBounds(38, 34, 135, 16);
		contentPane.add(lblGrupoN);
	}
}
