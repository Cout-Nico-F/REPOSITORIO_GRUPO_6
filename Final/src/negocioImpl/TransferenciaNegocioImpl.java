package negocioImpl;

import java.sql.SQLException;

import dao.ITransferirDao;
import daoImpl.TransferirDaoImpl;
import negocio.ITransferenciaNegocio;

public class TransferenciaNegocioImpl implements ITransferenciaNegocio {

	ITransferirDao idao = new TransferirDaoImpl();
	
	@Override
	public boolean ComprobarSaldo(String cbu, float cantidad) {
		boolean r = false;
		try {
			r = idao.ComprobarSaldo(cbu, cantidad);
		}catch (SQLException e){
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public boolean ComprobarExistencia(String cbu) {
		boolean r = false;
		try {
			 r = idao.ComprobarExistencia(cbu);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	

}
