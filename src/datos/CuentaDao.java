package datos;

import java.sql.Date;
import java.util.ArrayList;

import com.sun.javafx.collections.MappingChange.Map;

import entidad.Cuenta;
import excepciones.ClienteExcedeCantCuentas;
import excepciones.CuentaErrorOperacion;
import excepciones.ParametroInvalido;


public interface CuentaDao {
	public ArrayList<Cuenta> obtenerCuentasCliente(int DNICliente);
	public ArrayList<Cuenta> listaCuentas();
	public boolean agregarCuentaCliente(int DNICliente, int IDTipoCuenta);
	public boolean editarCuenta(Cuenta cuenta);
	public boolean bajaLogicaCuenta(int NumeroCuenta) throws CuentaErrorOperacion;
	public boolean altaLogicaCuenta(int NumeroCuenta);
	Cuenta obtenerUnaCuenta(int IDCuenta);
	public ArrayList<Cuenta> listarCuentasTransferencia();
	public boolean ValidarCbuYNumeroDeCuenta(int NumeroCuenta, String Cbu);
	public ArrayList<Cuenta> listarCuentasPorTipo(double saldoMin, double saldoMax);
	public ArrayList<Cuenta> listaCuentasResumen(Date fecha1, Date fecha2, int tipo);
	
}

		
