package negocio;

import java.util.ArrayList;

import entidad.Movimiento;


public interface MovimientoNegocio {

	public ArrayList <Movimiento> listarMovimiento();
	public Movimiento listarMovimiento(int idMovimiento);
	public boolean insertarMovimiento(Movimiento movimiento);

}
