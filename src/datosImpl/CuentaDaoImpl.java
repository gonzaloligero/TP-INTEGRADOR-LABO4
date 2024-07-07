package datosImpl;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

import datos.CuentaDao;
import entidad.Cliente;
import entidad.Cuenta;
import excepciones.ClienteExcedeCantCuentas;

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
	public ArrayList<Cuenta> listaCuentas() {
		
		cn = new Conexion();
		cn.Open();
		ArrayList<Cuenta> lista = new ArrayList<Cuenta>();
		
		try {
			ResultSet rs= cn.query("SELECT c.IDCuenta, c.DNICliente, c.FechaCreacion, c.NumeroCuenta, c.CBU, c.Saldo, c.IDTipoCuenta, c.ESTADO FROM cuentas as c INNER JOIN clientes as cl on cl.DNI = c.DNICliente");
			while(rs.next()) {
				Cuenta regCuenta = new Cuenta();
				regCuenta.setIDCuenta(rs.getInt("c.IDCuenta"));
				regCuenta.setDNICliente(rs.getInt("c.DNICliente"));
				regCuenta.setFechaCreacion(rs.getDate("c.FechaCreacion"));
				regCuenta.setNumeroCuenta(rs.getInt("c.NumeroCuenta"));
				regCuenta.setCBU(rs.getString("c.CBU"));
				regCuenta.setSaldo(rs.getDouble("c.Saldo")); 
				regCuenta.setIDTipoCuenta(rs.getInt("c.IDTipoCuenta"));
				regCuenta.setEstado(rs.getBoolean("c.ESTADO"));
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
	    
	    boolean cuentaEditada = false;

	    Conexion cn = new Conexion();
	    cn.Open();    

	    String query = "UPDATE Cuentas SET Saldo='" + cuenta.getSaldo() + "' WHERE IDCuenta='" + cuenta.getIDCuenta() + "'";

	    
	    try {	    	
	        cuentaEditada = cn.execute(query);
	    } catch(Exception e) {
	    	System.out.println(e.getMessage());
	    } finally {
	        cn.close();
	    }
	    return cuentaEditada;
	}

	@Override
	public boolean agregarCuentaCliente(int DNICliente, int IDTipoCuenta){
		    cn = new Conexion();
		    cn.Open();
		   		    
		    boolean cuentaAgregada = false;
		    Random random = new Random();
		    
		    System.out.print(DNICliente);
		    System.out.print(IDTipoCuenta);

		    try {
		        // Verificar cuantas cuentas tiene el cliente
		        ResultSet rsCount = cn.query("SELECT COUNT(*) AS CantidadCuentas FROM CUENTAS WHERE DNICliente = " + DNICliente);
		        int cantidadCuentas = 0;
		        if (rsCount.next()) {
		            cantidadCuentas = rsCount.getInt("CantidadCuentas");
		        }
		        
		        if (cantidadCuentas < 3) {
		            
		            int numeroCuenta = 10000 + random.nextInt(90000000);  
		            
		            
		            String cbu = new BigInteger(130, random).toString();  
		            
		            while (cbu.length() < 22) {
		                cbu = "0" + cbu;
		            }
		            
		            if (cbu.length() > 22) {
		                cbu = cbu.substring(0, 22);
		            }
		            
		            String queryInsertCuenta = "INSERT INTO CUENTAS (DNICliente, FechaCreacion, NumeroCuenta, CBU, Saldo, IDTipoCuenta) " +
		                                       "VALUES (" + DNICliente + ", CURDATE(), " + numeroCuenta + ", '" + cbu + "', 10000.00, " + IDTipoCuenta + ")";
		            cuentaAgregada = cn.execute(queryInsertCuenta);
		            return true;
		            
		        } else {
		            throw new ClienteExcedeCantCuentas("El cliente ya tiene 3 cuentas asociadas.");
		        }
		    } catch (Exception e) {
		        System.out.println(e.getMessage());
		    } finally {
		        cn.close();
		    }
		    
		    return false;
	}

	@Override
	public boolean bajaLogicaCuenta(int NumeroCuenta) {
		 boolean cuentaDesactivado = false;
			
			cn = new Conexion();
			cn.Open();		 
			String query = "UPDATE CUENTAS SET ESTADO = 0 WHERE NumeroCuenta = "+NumeroCuenta;
			try
			 {
				cuentaDesactivado=cn.execute(query);
			 }
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				cn.close();
			}
			return cuentaDesactivado;
	}

	@Override
	public boolean altaLogicaCuenta(int NumeroCuenta) {
		 boolean cuentaActivado = false;
			
			cn = new Conexion();
			cn.Open();		 
			String query = "UPDATE CUENTAS SET ESTADO = 1 WHERE NumeroCuenta = "+NumeroCuenta;
			try
			 {
				cuentaActivado=cn.execute(query);
			 }
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				cn.close();
			}
			return cuentaActivado;
	}

	@Override
	public ArrayList<Cuenta> listarCuentasTransferencia() {
		cn = new Conexion();
		cn.Open();
		ArrayList<Cuenta> lista = new ArrayList<Cuenta>();
		
		try {
			ResultSet rs= cn.query("SELECT IDCuenta, NumeroCuenta, CBU FROM CUENTAS");
			while(rs.next()) {
				Cuenta regCuenta = new Cuenta();
				regCuenta.setIDCuenta(rs.getInt("IDCuenta"));
				regCuenta.setNumeroCuenta(rs.getInt("NumeroCuenta"));
				regCuenta.setCBU(rs.getString("CBU"));
				lista.add(regCuenta);
			}
		}catch (Exception e){	
				System.out.println(e.getMessage());	
		}finally {
			cn.close();
		}
		
		return lista;
	}

}



