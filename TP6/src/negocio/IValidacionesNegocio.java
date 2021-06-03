package negocio;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public interface IValidacionesNegocio {
	void ComprobarSoloLetras(KeyEvent k);
	void ComprobarSoloNumeros(KeyEvent k);
	boolean ComprobarCampoVacio(JTextField jtext);
}
