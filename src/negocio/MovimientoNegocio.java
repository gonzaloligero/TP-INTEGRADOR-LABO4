package negocio;

import java.util.ArrayList;

import entidad.Movimiento;


public interface MovimientoNegocio {

	public ArrayList <Movimiento> listarMovimientos();
	public Movimiento listarUnMovimiento(int dniCliente);
	public boolean realizarTransferencia(Movimiento transferencia);
	public ArrayList<Movimiento>listarTransferenciasDeUnCliente(int dniCliente);

}
