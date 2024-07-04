package datos;

import java.util.ArrayList;

import entidad.Movimiento;

public interface MovimientoDao {

	public ArrayList<Movimiento> listarMovimientos();
	public Movimiento listarUnMovimiento(int dniCliente);
	public boolean insertarMovimiento(Movimiento movimiento);

}
