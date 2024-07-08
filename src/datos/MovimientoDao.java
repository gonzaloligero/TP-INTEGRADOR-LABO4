package datos;

import java.math.BigDecimal;
import java.util.ArrayList;

import entidad.Movimiento;

public interface MovimientoDao {

	public ArrayList<Movimiento> listarMovimientos();
	public Movimiento listarUnMovimiento(int dniCliente);
	public boolean realizarTransferencia(Movimiento transferencia);
	ArrayList<Movimiento>listarTransferenciasDeUnCliente(int dniCliente);
	public float[] obtenerCashflow(int dniCliente);
	public boolean inyectarDinero(float saldo, int idCuenta);
}
