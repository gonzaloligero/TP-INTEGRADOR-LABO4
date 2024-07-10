package negocioImpl;
import java.util.ArrayList;

import datos.CuentaDao;
import datosImpl.CuentaDaoImpl;
import entidad.Cuenta;
import excepciones.CuentaErrorOperacion;
import negocio.CuentaNegocio;



public class CuentaNegocioImpl implements CuentaNegocio {

	private CuentaDao cuentaDao = new CuentaDaoImpl();
	
	@Override
	public ArrayList<Cuenta> listarCuentasCliente(int DNICliente) {
		
		return(ArrayList<Cuenta>) cuentaDao.obtenerCuentasCliente(DNICliente);
	}

	@Override
	public ArrayList<Cuenta> listarCuentasGral() {
		
		return cuentaDao.listaCuentas();
	}	

	@Override
	public boolean editarCuenta(Cuenta cuenta) {
		
		 return cuentaDao.editarCuenta(cuenta);
	}

	@Override
	public boolean agregarCuentaCliente(int DNICliente, int IDTipoCuenta) {
		try {
			return cuentaDao.agregarCuentaCliente(DNICliente, IDTipoCuenta);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
		return false;
	}

	@Override
	public boolean bajaLogicaCuenta(int numeroCuenta) throws CuentaErrorOperacion {
		
		return cuentaDao.bajaLogicaCuenta(numeroCuenta);
	}

	@Override
	public boolean altaLogicaCuenta(int numeroCuenta) {
		return cuentaDao.altaLogicaCuenta(numeroCuenta);
	}

	@Override
	public ArrayList<Cuenta> listarCuentasTransferencia() {
		return cuentaDao.listarCuentasTransferencia();
	}

	@Override
	public ArrayList<Cuenta> listarCuentasPorTipo(double saldoMin, double saldoMax) {
	    return cuentaDao.listarCuentasPorTipo(saldoMin, saldoMax);
	}

	@Override
	public ArrayList<Cuenta> listaTipoCuentasResumenNeg() {
		return cuentaDao.listaTipoCuentasResumen();
	}


	
}
