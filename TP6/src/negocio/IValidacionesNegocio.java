package negocio;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;

public interface IValidacionesNegocio {
	void ComprobarSoloLetras(KeyEvent k, JPanel panel);
	void ComprobarSoloNumeros(KeyEvent k, JPanel panel);
	boolean ComprobarCampoVacio(JPanel panel, JTextField jtext);
}
