package datos;

import java.util.ArrayList;

import entidad.Cuenta;
import excepciones.ClienteExcedeCantCuentas;


public interface CuentaDao {
	public ArrayList<Cuenta> obtenerCuentasCliente(int DNICliente);
	public ArrayList<Cuenta> listaCuentas();
	public int agregarCuentaCliente(int DNICliente, int IDTipoCuenta) throws ClienteExcedeCantCuentas;
	public boolean editarCuenta(Cuenta cuenta);
}

		
