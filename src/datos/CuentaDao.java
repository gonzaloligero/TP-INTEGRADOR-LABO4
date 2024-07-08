package datos;

import java.util.ArrayList;

import entidad.Cuenta;
import excepciones.ClienteExcedeCantCuentas;
import excepciones.CuentaErrorOperacion;


public interface CuentaDao {
	public ArrayList<Cuenta> obtenerCuentasCliente(int DNICliente);
	public ArrayList<Cuenta> listaCuentas();
	public boolean agregarCuentaCliente(int DNICliente, int IDTipoCuenta);
	public boolean editarCuenta(Cuenta cuenta);
	public boolean bajaLogicaCuenta(int NumeroCuenta) throws CuentaErrorOperacion;
	public boolean altaLogicaCuenta(int NumeroCuenta);
}

		
