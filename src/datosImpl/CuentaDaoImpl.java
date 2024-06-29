package datosImpl;

import java.sql.PreparedStatement;
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
	public boolean agregarCuentaCliente(int DNICliente) {
	    cn = new Conexion();
	    cn.Open();
	    boolean cuentaAgregada = false;
	    
	    try {
	        // ACA VEMOS CUANTAS CUENTAS TIENE EL CLIENTE
	        ResultSet rsCount = cn.query("SELECT COUNT(*) AS CantidadCuentas FROM CUENTAS WHERE DNICliente = " + DNICliente);
	        int cantidadCuentas = 0;
	        if (rsCount.next()) {
	            cantidadCuentas = rsCount.getInt("CantidadCuentas");
	        }
	        
	        if (cantidadCuentas < 3) {
	            // ACA CUANDO LA CUENTA ES CREADA, SE LE DEPOSITAN LOS 10.000$$
	            String queryInsertCuenta = "INSERT INTO CUENTAS (DNICliente, FechaCreacion, NumeroCuenta, CBU, Saldo) " +
	                                       "VALUES (" + DNICliente + ", CURDATE(), 12345, 'CBU12345', 10000.00)";
	            cuentaAgregada = cn.execute(queryInsertCuenta);
	        } else {
	            System.out.println("El cliente ya tiene 3 cuentas asociadas.");
	        }
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    } finally {
	        cn.close();
	    }
	    
	    return cuentaAgregada;
	}

	

	@Override
	public boolean editarCuenta(Cuenta cuenta) {
	    
	    boolean cuentaEditada = false;

	    Conexion cn = new Conexion();
	    cn.Open();    

	    String query = "UPDATE Cuentas SET DNICliente='" + cuenta.getDNICliente() + "', FechaCreacion='" + cuenta.getFechaCreacion() + "', NumeroCuenta='" + cuenta.getNumeroCuenta() + "', CBU='" + cuenta.getCBU() + "', Saldo='" + cuenta.getSaldo() + "' WHERE IDCuenta='" + cuenta.getIDCuenta() + "'";

	    
	    try {
	        cuentaEditada = cn.execute(query);
	    } catch(Exception e) {
	        e.printStackTrace();
	    } finally {
	        cn.close();
	    }
	    return cuentaEditada;
	}

	

	
	
	@Override
	public boolean altaLogicaCuenta(int IDCuenta) {
		
		return false;
	}


	@Override
	public boolean bajaLogicaCuenta(int IDCuenta) {
		
		return false;
	}


}
