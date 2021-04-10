package ejercicio2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainEjercicio2 { //act 2.3
	public static void main(String[] args) {
		ProductoCongelado Pc = new ProductoCongelado(parseFecha("2022-02-21"), 2105, -2);
		ProductoFresco Pf = new ProductoFresco(parseFecha("2021-12-17"), 1349, parseFecha("2021-09-13"), "Ecuador");
		ProductoRefrigerado Pr = new ProductoRefrigerado(parseFecha("2022-07-23"), 1978, "FE853MSA");
		
		System.out.println(Pc.toString());
		System.out.println(Pf.toString());
		System.out.println(Pr.toString());
		
	}

	public static Date parseFecha(String fecha) {
		try {
	         return new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
	     } catch (ParseException e) {
	         return null;
	     }
	}

}
