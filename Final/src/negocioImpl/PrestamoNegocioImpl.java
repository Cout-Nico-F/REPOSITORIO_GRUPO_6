package negocioImpl;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

import entidad.Cuota;
import entidad.Prestamo;
import negocio.IPrestamoNegocio;

public class PrestamoNegocioImpl implements IPrestamoNegocio{

	@Override
	public ArrayList<BigDecimal> cargarSaldos(ArrayList<Prestamo> listaPrestamos) {
		ArrayList<BigDecimal> listaSaldos = new ArrayList<BigDecimal>();
		for (int i = 0; i < listaPrestamos.size(); i++) {
			BigDecimal aux = new BigDecimal(0);
			ArrayList<Cuota>listaCuotas = listaPrestamos.get(i).getListaCuotas();
			for (Cuota c : listaCuotas) {			
				aux = new BigDecimal(c.getImporte().floatValue()+aux.floatValue(),new MathContext(6)).setScale(2);
			}
			listaSaldos.add(aux);
		}
		return listaSaldos;
	}
	
}
