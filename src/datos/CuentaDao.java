package datos;

import java.util.ArrayList;

import entidad.Cuenta;


public interface CuentaDao {
	public ArrayList<Cuenta> obtenerCuentasCliente(int DNICliente);
	public ArrayList<Cuenta> obtenerCuentasGral();
	public boolean agregarCuentaCliente(int DNICliente);
	public boolean editarCuenta(Cuenta cuenta);
	public boolean bajaLogicaCuenta(int IDCuenta);
	public boolean altaLogicaCuenta(int IDCuenta);
}
		
