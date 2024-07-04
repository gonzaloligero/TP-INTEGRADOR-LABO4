package datos;

import java.math.BigDecimal;
import java.util.ArrayList;

import entidad.Movimiento;

public interface MovimientoDao {

	public ArrayList<Movimiento> listarMovimientos();
	public Movimiento listarUnMovimiento(int dniCliente);
	public boolean insertarMovimiento(BigDecimal importe, int IDCuenta, int IDTipoMovimiento,String Detalle);

}
