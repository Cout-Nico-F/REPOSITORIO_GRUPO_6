package negocioImpl;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.cj.util.StringUtils;

import negocio.IValidacionesNegocio;


public class ValidacionesNegocioImpl implements IValidacionesNegocio{

	@Override
	public void ComprobarSoloLetras(KeyEvent k, JPanel panel) {
		if(Character.isLetter(k.getKeyChar()) == false && k.getKeyChar() != ' ') { //Si no es una letra:
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

	@Override
	public boolean ComprobarCampoVacio(JPanel panel, JTextField jtext) {
		if (StringUtils.isEmptyOrWhitespaceOnly(jtext.getText()))
		{
			panel.getToolkit().beep(); //Get a sound -> si esta comentado se bugea el sonido de error
			JOptionPane.showMessageDialog(panel.getRootPane(), "Hay campos sin completar!");
			return false;
		}else return true;
	}
	
}
