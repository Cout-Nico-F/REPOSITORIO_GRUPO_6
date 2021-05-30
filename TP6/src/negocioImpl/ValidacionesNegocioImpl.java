package negocioImpl;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import negocio.IValidacionesNegocio;



public class ValidacionesNegocioImpl implements IValidacionesNegocio{

	@Override
	public void ComprobarSoloLetras(KeyEvent k, JPanel panel) {
		if(Character.isLetter(k.getKeyChar()) == false) { //Si no es una letra:
			panel.getToolkit().beep(); //Get a sound -> si esta comentado se bugea el sonido de error
			k.consume(); //Funciona para no llamar a mas eventos como el KeyListener -> si esta comentado no borra la tecla erronea ingresada
		JOptionPane.showMessageDialog(panel.getRootPane(), "Ingresar solo letras!");
		}
	}

	@Override
	public void ComprobarSoloNumeros(KeyEvent k, JPanel panel) {
		if(Character.isDigit(k.getKeyChar()) == false)  { //Si no es una letra:
			panel.getToolkit().beep(); //Get a sound -> si esta comentado se bugea el sonido de error
			k.consume(); //Funciona para no llamar a mas eventos como el KeyListener -> si esta comentado no borra la tecla erronea ingresada
		JOptionPane.showMessageDialog(panel.getRootPane(), "Ingresar solo numeros!");
		}
	}
	
}
