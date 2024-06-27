package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;

import datos.CuentaDao;
import entidad.Cliente;
import entidad.Cuenta;

public class CuentaDaoImpl implements CuentaDao{

	private Conexion cn;
	
	@Override
	public ArrayList<Cuenta> obtenerCuentasCliente(int DNICliente) {
		cn = new Conexion();
		cn.Open();
		ArrayList<Cuenta> lista = new ArrayList<Cuenta>();
		
		try {
			ResultSet rs= cn.query("SELECT c.IDCuenta, c.DNICliente, c.FechaCreacion, c.NumeroCuenta, c.CBU, c.Saldo FROM cuentas as c INNER JOIN clientes as cl on cl.DNI = c.DNICliente WHERE cl.DNI = " + DNICliente);
			while(rs.next()) {
				Cuenta regCuenta = new Cuenta();
				regCuenta.setIDCuenta(rs.getInt("c.IDCuenta"));
				regCuenta.setDNICliente(rs.getInt("c.DNICliente"));
				regCuenta.setFechaCreacion(rs.getDate("c.FechaCreacion"));
				regCuenta.setNumeroCuenta(rs.getInt("c.NumeroCuenta"));
				regCuenta.setCBU(rs.getString("c.CBU"));
				regCuenta.setSaldo(rs.getDouble("c.Saldo"));  
				lista.add(regCuenta);
			}
		}catch (Exception e){	
				System.out.println(e.getMessage());	
		}finally {
			cn.close();
		}
		return lista;
		
	}

	@Override
	public ArrayList<Cuenta> obtenerCuentasGral() {
		
		cn = new Conexion();
		cn.Open();
		ArrayList<Cuenta> lista = new ArrayList<Cuenta>();
		
		try {
			ResultSet rs= cn.query("SELECT c.IDCuenta, c.DNICliente, c.FechaCreacion, c.NumeroCuenta, c.CBU, c.Saldo FROM cuentas as c INNER JOIN clientes as cl on cl.DNI = c.DNICliente");
			while(rs.next()) {
				Cuenta regCuenta = new Cuenta();
				regCuenta.setIDCuenta(rs.getInt("c.IDCuenta"));
				regCuenta.setDNICliente(rs.getInt("c.DNICliente"));
				regCuenta.setFechaCreacion(rs.getDate("c.FechaCreacion"));
				regCuenta.setNumeroCuenta(rs.getInt("c.NumeroCuenta"));
				regCuenta.setCBU(rs.getString("c.CBU"));
				regCuenta.setSaldo(rs.getDouble("c.Saldo"));  
				lista.add(regCuenta);
			}
		}catch (Exception e){	
				System.out.println(e.getMessage());	
		}finally {
			cn.close();
		}
		return lista;
	}

	@Override
	public boolean editarCuenta(Cuenta cuenta) {
		
		return false;
	}

	@Override
	public boolean bajaLogicaCuenta(int IDCuenta) {
		
		return false;
	}

	@Override
	public boolean altaLogicaCuenta(int IDCuenta) {
		
		return false;
	}

	@Override
	public boolean agregarCuentaCliente(int DNICliente) {
		
		return false;
	}



}
