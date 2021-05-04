package ejercicio3;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameEjercicio3 extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField txtfCantHoras;

	public FrameEjercicio3() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		setTitle("Seleccion multiple");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 464, 45);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Elige un sistema operativo");
		lblNewLabel.setBounds(10, 11, 165, 14);
		panel.add(lblNewLabel);

		ButtonGroup buttonGroup = new ButtonGroup();

		JRadioButton rdbtnWindows = new JRadioButton("Windows");
		rdbtnWindows.setBounds(181, 7, 103, 23);
		panel.add(rdbtnWindows);
		buttonGroup.add(rdbtnWindows);

		JRadioButton rdbtnMac = new JRadioButton("Mac");
		rdbtnMac.setBounds(286, 7, 91, 23);
		panel.add(rdbtnMac);
		buttonGroup.add(rdbtnMac);

		JRadioButton rdbtnLinux = new JRadioButton("Linux");
		rdbtnLinux.setBounds(379, 7, 79, 23);
		panel.add(rdbtnLinux);
		buttonGroup.add(rdbtnLinux);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 67, 464, 93);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JCheckBox chckbxProgramacin = new JCheckBox("Programaci\u00F3n");
		chckbxProgramacin.setBounds(264, 7, 194, 23);
		panel_1.add(chckbxProgramacin);

		JCheckBox chckbxAdministracin = new JCheckBox("Administraci\u00F3n");
		chckbxAdministracin.setBounds(264, 33, 194, 23);
		panel_1.add(chckbxAdministracin);

		JCheckBox chckbxDiseoGrfico = new JCheckBox("Dise\u00F1o Gr\u00E1fico");
		chckbxDiseoGrfico.setBounds(264, 59, 194, 23);
		panel_1.add(chckbxDiseoGrfico);

		JLabel lblEligeUnaEspecialidad = new JLabel("Elige una especialidad");
		lblEligeUnaEspecialidad.setBounds(10, 37, 226, 14);
		panel_1.add(lblEligeUnaEspecialidad);

		JLabel lblCantidadDeHoras = new JLabel("Cantidad de horas en la computadora");
		lblCantidadDeHoras.setBounds(10, 171, 322, 14);
		contentPane.add(lblCantidadDeHoras);

		txtfCantHoras = new JTextField();
		txtfCantHoras.setBounds(388, 168, 86, 20);
		contentPane.add(txtfCantHoras);
		txtfCantHoras.setColumns(10);
		txtfCantHoras.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char num = e.getKeyChar();
				CheckOnlyNumbers(num, e);
			}
		});

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comprobarRadioButtons(rdbtnWindows, rdbtnMac, rdbtnLinux)) {
					if (comprobarCheckBoxes(chckbxProgramacin, chckbxAdministracin, chckbxDiseoGrfico)) {
						if (validarTextField(txtfCantHoras)) {
							FrameMsjEjercicio3 ventanaMsj = new FrameMsjEjercicio3();
							
							ventanaMsj.setVisible(true);
						}
					}
				}
			}
		});
		btnAceptar.setBounds(385, 227, 89, 23);
		contentPane.add(btnAceptar);
	}

	private void CheckOnlyNumbers(char num, KeyEvent e) {
		if (Character.isLetter(num)) {
			getToolkit().beep();
			e.consume();
			JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
		}
	}
	
	private boolean comprobarRadioButtons(JRadioButton jrb1, JRadioButton jrb2, JRadioButton jrb3) {
		boolean retorno = true;
		
		if ((!(jrb1.isSelected()) && !(jrb2.isSelected()) && !(jrb3.isSelected()))) {
			retorno = false;
		}
		
		return retorno;
	}
	
	private boolean comprobarCheckBoxes(JCheckBox jcb1, JCheckBox jcb2, JCheckBox jcb3) {
		boolean retorno = true;
		
		if ((!(jcb1.isSelected()) && !(jcb2.isSelected()) && !(jcb3.isSelected()))) {
			retorno = false;
		}
		
		return retorno;
	}
	
	private boolean validarTextField(JTextField jtf) {
		boolean retorno = false;
		
		String input = jtf.getText();
		if (input.length() > 0) {
			retorno = true;
		}		
		return retorno;
	}
	
		
}
	

