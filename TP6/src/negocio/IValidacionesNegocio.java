package negocio;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public interface IValidacionesNegocio {
	void ComprobarSoloLetras(KeyEvent k, JPanel panel);
	void ComprobarSoloNumeros(KeyEvent k, JPanel panel);
}
