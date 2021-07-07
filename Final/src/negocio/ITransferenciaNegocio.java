package negocio;

public interface ITransferenciaNegocio {
	
	public boolean ComprobarExistencia(String cbu);

	public boolean ComprobarSaldo(String cbu, float cantidad);
}
