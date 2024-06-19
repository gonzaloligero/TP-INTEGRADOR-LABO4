package negocioImpl;

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
	
	public ArrayList<Movimiento> listarMovimiento(){
		return(ArrayList<Movimiento>) movimientoDao.listarMovimiento();
		
	}

	@Override
	public Movimiento listarMovimiento(int idMovimiento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertarMovimiento(Movimiento movimiento) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
