package negocioImpl;

import java.sql.Date;
import java.util.ArrayList;

import datos.MovimientoDao;
import datosImpl.MovimientoDaoImpl;
import entidad.Movimiento;
import negocio.MovimientoNegocio;

public class MovimientoNegImpl implements MovimientoNegocio{

private MovimientoDao movimientoDao= new MovimientoDaoImpl();
	
	public MovimientoNegImpl(MovimientoDao movDao) {
		this.movimientoDao = movDao;
	}
	
	public MovimientoNegImpl() {}
	
	public ArrayList<Movimiento> listarMovimientos(){
		return(ArrayList<Movimiento>) movimientoDao.listarMovimientos();
		
	}

	@Override
	public Movimiento listarUnMovimiento(int idMovimiento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean realizarTransferencia(Movimiento transferencia) {
		return movimientoDao.realizarTransferencia(transferencia);
	}

	@Override
	public ArrayList<Movimiento> listarTransferenciasDeUnCliente(int dniCliente) {
		return movimientoDao.listarTransferenciasDeUnCliente(dniCliente);
	}

	@Override
	public float[] obtenerCashflow(int dniCliente) {
		return movimientoDao.obtenerCashflow(dniCliente);
	}

	@Override
	public boolean inyectarDinero(float saldo, int idCuenta) {
		return movimientoDao.inyectarDinero(saldo, idCuenta);
	}

	@Override
	public float montosPorFecha(Date fecha1, Date fecha2) {
		return movimientoDao.montosPorFecha(fecha1, fecha2);
	}

	@Override
	public int rastrearTransferencias(Date fecha1, Date fecha2, float monto) {
		return movimientoDao.rastrearTransferencias(fecha1, fecha2, monto);
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	


