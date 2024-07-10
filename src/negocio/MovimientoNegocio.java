package negocio;

import java.sql.Date;
import java.util.ArrayList;

import entidad.Movimiento;


public interface MovimientoNegocio {

	public ArrayList <Movimiento> listarMovimientos();
	public Movimiento listarUnMovimiento(int dniCliente);
	public boolean realizarTransferencia(Movimiento transferencia);
	public ArrayList<Movimiento>listarTransferenciasDeUnCliente(int dniCliente);
	public float[] obtenerCashflow(int dniCliente);
	public boolean inyectarDinero(float saldo, int idCuenta);
	public float montosPorFecha(Date fecha1, Date fecha2);
	public int rastrearTransferencias(Date fecha1, Date fecha2, float monto);
	ArrayList<Movimiento> listarMovimientosPorCliente(int dni);
}
