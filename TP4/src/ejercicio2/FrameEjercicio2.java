package ejercicio2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;

public class FrameEjercicio2 extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textbox_nota1;
	private JTextField textbox_nota2;
	private JTextField textbox_nota3;
	private JTextField tfPromedio;
	private JTextField tfCondicion;
	JComboBox<String> comboBox_TPS;
	/**
	 * Create the frame.
	 */
	public FrameEjercicio2() {
		setBounds(100, 100, 584, 460);
		setTitle("Promedio");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(39, 29, 315, 209);
		panel.setBorder(new TitledBorder(null, "Notas del estudiante", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		
		//nota1
		textbox_nota1 = new JTextField();
		textbox_nota1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char num = e.getKeyChar();
				CheckOnlyNumbers(num,e); //Calls the method every time a key is pressed
			}
		});
		textbox_nota1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			 ComprobarNotaIngresada(e);
			}
		});
		textbox_nota1.setBounds(91, 37, 161, 23);
		panel.add(textbox_nota1);
		textbox_nota1.setColumns(10);
		
		//nota2
		textbox_nota2 = new JTextField();
		textbox_nota2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char num = e.getKeyChar();
				CheckOnlyNumbers(num,e); //Calls the method every time a key is pressed
			}
		});
		textbox_nota2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ComprobarNotaIngresada(e);	
			}
		});
		textbox_nota2.setColumns(10);
		textbox_nota2.setBounds(91, 77, 161, 23);
		panel.add(textbox_nota2);
		
		//nota3
		textbox_nota3 = new JTextField();
		textbox_nota3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char num = e.getKeyChar();
				CheckOnlyNumbers(num,e); //Calls the method every time a key is pressed
			}
		});
		textbox_nota3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ComprobarNotaIngresada(e);				
			}
		});
		
		textbox_nota3.setColumns(10);
		textbox_nota3.setBounds(91, 114, 161, 23);
		panel.add(textbox_nota3);
		
		
		//TPS
		JLabel lblTps = new JLabel("TPS");
		lblTps.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTps.setHorizontalAlignment(SwingConstants.CENTER);
		lblTps.setBounds(10, 148, 71, 26);
		panel.add(lblTps);
		
		String comboBox_TPS_Opciones [] = {"Aprobado","Desaprobado"};
		comboBox_TPS = new JComboBox(comboBox_TPS_Opciones);
		comboBox_TPS.setSelectedIndex(-1);
		comboBox_TPS.setMaximumRowCount(2);
		
		
		comboBox_TPS.setBounds(91, 148, 161, 23);
		panel.add(comboBox_TPS);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(39, 275, 315, 113);
		panel2.setBorder(new TitledBorder(null, "Notas del estudiante", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		tfPromedio.setEditable(false);//I make the field non-editable so they don't write in it
		panel2.add(tfPromedio);
		
		tfCondicion = new JTextField();
		tfCondicion.setColumns(10);
		tfCondicion.setBounds(104, 60, 161, 23);
		tfCondicion.setEditable(false);
		panel2.add(tfCondicion);
		
		JPanel panelDeBotones = new JPanel();
		panelDeBotones.setBounds(385, 140, 173, 137);
		contentPane.add(panelDeBotones);
		panelDeBotones.setLayout(new GridLayout(3, 0, 0, 15));
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelDeBotones.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelDeBotones.add(btnNuevo);
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimpiarTxt(textbox_nota1,textbox_nota2,textbox_nota3,tfPromedio,tfCondicion);
				comboBox_TPS.setSelectedIndex(-1);
			}
		});
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelDeBotones.add(btnCalcular);
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ComprobarCampos()) {
					Calcular();
				}else JOptionPane.showMessageDialog(rootPane, "Todas las notas deben estar ingresadas para calcular");
			}
		});
	}

	private void CheckOnlyNumbers(char num,KeyEvent e) {
		if(Character.isLetter(num)) { //if variable num is not a number
				getToolkit().beep(); //Get a sound -> si esta comentado se bugea el sonido de error
				e.consume(); //Funciona para no llamar a mas eventos como el KeyListener -> si esta comentado no borra la tecla erronea ingresada
			JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
		}
	}
	
	private void LimpiarTxt(JTextField nota1,JTextField nota2,JTextField nota3,JTextField prom,JTextField con) {
		nota1.setText(null);
		nota2.setText(null);
		nota3.setText(null);
		prom.setText(null);
		con.setText(null);
	}
	
	private void LimpiarTxt(JTextField textField) {
		textField.setText(null);
	}
	
	private void ComprobarNotaIngresada(FocusEvent e) {
		
		//podriamos tener un metodo aca para que se puedan ingresar comas o puntos.( que busque comas y las cambie por puntos en el string y no pinche el convert )
		//o un label que indique que los numeros decimales se marquen con punto
		
		JTextField tb = (JTextField) e.getComponent();
		String input = tb.getText();
		float number = -1;
		if (input.length() > 0) {
			try {
				 number = Float.valueOf(input).floatValue();
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(rootPane, "La nota ingresada no es valida.\n Utilice punto(.) para ingresar decimales, la coma no esta permitida");
				System.out.println("Nota incorrecta ingresada");
				LimpiarTxt(tb);
				return;
			}
			if (number < 1 || number > 10) {
				JOptionPane.showMessageDialog(rootPane, "La nota ingresada esta fuera del rango permitido.\n Debe ser mayor o igual a 1 y menor o igual que 10");
				System.out.println("Nota fuera de rango ingresada");
				LimpiarTxt(tb);
			}
		}
	}
	
	private boolean ComprobarCampos() {
		//este metodo comprueba que halla algo ingresado en los 4 campos, caso contrario avisa.
		boolean field1 = false, field2 = false, field3= false ,field4 = false;
		
		if(textbox_nota1.getText().length() >0) {
			field1=true;
		}
		if(textbox_nota2.getText().length() >0) {
			field2=true;
		}
		if(textbox_nota3.getText().length() >0) {
			field3=true;
		}
		if(comboBox_TPS.getSelectedIndex() > -1) {
			field4=true;
		}
		
		if (field1 && field2 && field3 && field4) {
			return true;
		}else {
			return false;
		}
		
	}
	
	private void Calcular() {
		// este metodo decide la condicion del alumno en base al enunciado
		
		//Calcular promedio y mostrarlo
		tfPromedio.setText (((Float.parseFloat(textbox_nota1.getText()) + Float.parseFloat(textbox_nota2.getText()) + Float.parseFloat(textbox_nota3.getText()) )/3)+"");
		
		//Calculo condicion
		if(comboBox_TPS.getSelectedItem().equals("Aprobado")) {
			
			if(Float.parseFloat(textbox_nota1.getText()) < 6 || Float.parseFloat(textbox_nota2.getText()) < 6 || 
				Float.parseFloat(textbox_nota3.getText()) < 6) {
				tfCondicion.setText("Libre");
			}
			else if(Float.parseFloat(textbox_nota1.getText()) >= 8 && Float.parseFloat(textbox_nota2.getText()) >= 8 && 
				Float.parseFloat(textbox_nota3.getText()) >= 8) {
				tfCondicion.setText("Promocionado");
			}
			else{
				tfCondicion.setText("Regular");
			}
		}
		else {
			tfCondicion.setText("Libre");
		}
		
	}
}
