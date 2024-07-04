package negocioImpl;
import java.util.ArrayList;

import datos.CuentaDao;
import datosImpl.CuentaDaoImpl;
import entidad.Cuenta;
import negocio.CuentaNegocio;



public class CuentaNegocioImpl implements CuentaNegocio {

	private CuentaDao cuentaDao = new CuentaDaoImpl();
	
	@Override
	public ArrayList<Cuenta> listarCuentasCliente(int DNICliente) {
		
		return(ArrayList<Cuenta>) cuentaDao.obtenerCuentasCliente(DNICliente);
	}

	@Override
	public ArrayList<Cuenta> listarCuentasGral() {
		
		return null;
	}

	@Override
	public boolean agregarCuentaCliente(int DNICliente) {
		
		return false;
	}

	@Override
	public boolean editarCuenta(Cuenta cuenta) {
		
		return false;
	}

}