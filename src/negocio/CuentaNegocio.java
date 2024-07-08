package negocio;

import java.util.ArrayList;

import entidad.Cuenta;
import excepciones.CuentaErrorOperacion;

public interface CuentaNegocio {

	public ArrayList <Cuenta> listarCuentasCliente(int DNICliente);
	public ArrayList <Cuenta> listarCuentasGral();
	public boolean agregarCuentaCliente(int DNICliente, int IDTipoCuenta);
	public boolean editarCuenta(Cuenta cuenta);
	public boolean bajaLogicaCuenta(int numeroCuenta) throws CuentaErrorOperacion;
	public boolean altaLogicaCuenta(int numeroCuenta);
}
	
	
