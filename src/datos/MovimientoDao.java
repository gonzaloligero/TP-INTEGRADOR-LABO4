package datos;

import java.util.ArrayList;

import entidad.Movimiento;

public interface MovimientoDao {

	public ArrayList<Movimiento> listarMovimiento();
	public Movimiento listarMovimiento(int idMovimiento);
	public boolean insertarMovimiento(Movimiento movimiento);

}
