package negocio;

import java.util.ArrayList;

import entidad.Cuenta;

public interface CuentaNegocio {

	public ArrayList <Cuenta> listarCuentasCliente(int DNICliente);
	public ArrayList <Cuenta> listarCuentasGral();
	public boolean agregarCuentaCliente(int DNICliente);
	public boolean editarCuenta(Cuenta cuenta);
}
	
	
