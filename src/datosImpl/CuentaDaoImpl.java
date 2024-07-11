package datosImpl;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

import datos.CuentaDao;
import entidad.Cliente;
import entidad.Cuenta;
import excepciones.ClienteExcedeCantCuentas;
import excepciones.CuentaErrorOperacion;
import excepciones.ParametroInvalido;

public class CuentaDaoImpl implements CuentaDao{

	private Conexion cn;
	
	@Override
	public ArrayList<Cuenta> obtenerCuentasCliente(int DNICliente) {
		cn = new Conexion();
		cn.Open();
		ArrayList<Cuenta> lista = new ArrayList<Cuenta>();
		
		try {
			ResultSet rs= cn.query("SELECT c.IDCuenta, c.DNICliente, c.FechaCreacion, c.NumeroCuenta, c.CBU, c.Saldo, c.IDTipoCuenta FROM cuentas as c INNER JOIN clientes as cl on cl.DNI = c.DNICliente WHERE cl.DNI = " + DNICliente);
			while(rs.next()) {
				Cuenta regCuenta = new Cuenta();
				regCuenta.setIDCuenta(rs.getInt("c.IDCuenta"));
				regCuenta.setDNICliente(rs.getInt("c.DNICliente"));
				regCuenta.setFechaCreacion(rs.getDate("c.FechaCreacion"));
				regCuenta.setNumeroCuenta(rs.getInt("c.NumeroCuenta"));
				regCuenta.setCBU(rs.getString("c.CBU"));
				regCuenta.setSaldo(rs.getDouble("c.Saldo")); 
				regCuenta.setIDTipoCuenta(rs.getInt("c.IDTipoCuenta"));
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

	    String query = "UPDATE Cuentas SET Saldo=" + cuenta.getSaldo() + " WHERE IDCuenta=" + cuenta.getIDCuenta();

	    
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
	public boolean agregarCuentaCliente(int DNICliente, int IDTipoCuenta) {
	    cn = new Conexion();
	    cn.Open();

	    boolean cuentaAgregada = false;
	    Random random = new Random();

	    try {
	        
	        ResultSet rsCount = cn.query("SELECT COUNT(*) AS CantidadCuentas FROM CUENTAS WHERE DNICliente = " + DNICliente);
	        int cantidadCuentas = 0;
	        if (rsCount.next()) {
	            cantidadCuentas = rsCount.getInt("CantidadCuentas");
	        }

	        if (cantidadCuentas < 3) {
	            boolean uniqueValuesFound = false;
	            int numeroCuenta = 0;
	            String cbu = "";

	            while (!uniqueValuesFound) {
	                
	                numeroCuenta = 10000000 + random.nextInt(90000000); 
	                cbu = new BigInteger(40, random).toString();  

	                while (cbu.length() < 8) {
	                    cbu = "0" + cbu;
	                }

	                if (cbu.length() > 8) {
	                    cbu = cbu.substring(0, 8);
	                }

	                // Verificar si el número de cuenta y CBU son únicos
	                String query = "SELECT COUNT(*) AS CuentaExistente FROM CUENTAS WHERE NumeroCuenta = " + numeroCuenta + " OR CBU = '" + cbu + "'";
	                ResultSet rsCheck = cn.query(query);
	                if (rsCheck.next()) {
	                    int cuentaExistente = rsCheck.getInt("CuentaExistente");
	                    if (cuentaExistente == 0) {
	                        uniqueValuesFound = true;
	                    }
	                }
	            }

	            
	            String queryInsertCuenta = "INSERT INTO CUENTAS (DNICliente, FechaCreacion, NumeroCuenta, CBU, Saldo, IDTipoCuenta, ESTADO) " +
	                                       "VALUES (" + DNICliente + ", CURDATE(), " + numeroCuenta + ", '" + cbu + "', 10000.00, " + IDTipoCuenta + ", 1)";
	            cuentaAgregada = cn.execute(queryInsertCuenta);
	            return cuentaAgregada;

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
	public boolean bajaLogicaCuenta(int NumeroCuenta) throws CuentaErrorOperacion{
	    		
		boolean cuentaDesactivado = false;    
	    cn = new Conexion();
	    cn.Open();
	    String query = "UPDATE CUENTAS SET ESTADO = 0 WHERE NumeroCuenta = " + NumeroCuenta;
	    try {
	        cuentaDesactivado = cn.execute(query);
	        if (!cuentaDesactivado) {
	        	
	        	throw new CuentaErrorOperacion("Error al desactivar la cuenta con número: " + NumeroCuenta);
	        }
	    } catch (CuentaErrorOperacion e) {
	    	 e.printStackTrace();
	         throw e;
	    } finally {
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
	
	
	//Emma, no toca o te corto los dedos
	
	@Override
	public Cuenta obtenerUnaCuenta(int IDCuenta) {
	    cn = new Conexion();
	    cn.Open();
	    Cuenta cuenta = null;

	    try {
	        String query = "SELECT IDCuenta, DNICliente, FechaCreacion, NumeroCuenta, CBU, Saldo, IDTipoCuenta, Estado FROM CUENTAS WHERE IDCuenta = " + IDCuenta;
	        ResultSet rs= cn.query(query);
	        

	        if (rs.next()) {
	            cuenta = new Cuenta();
	            cuenta.setIDCuenta(rs.getInt("IDCuenta"));
	            cuenta.setDNICliente(rs.getInt("DNICliente"));
	            cuenta.setFechaCreacion(rs.getDate("FechaCreacion"));
	            cuenta.setNumeroCuenta(rs.getInt("NumeroCuenta"));
	            cuenta.setCBU(rs.getString("CBU"));
	            cuenta.setSaldo(rs.getDouble("Saldo"));
	            cuenta.setIDTipoCuenta(rs.getInt("IDTipoCuenta"));
	            cuenta.setEstado(rs.getBoolean("ESTADO"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        cn.close();
	    }

	    return cuenta;
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

	@Override
	public boolean ValidarCbuYNumeroDeCuenta(int NumeroCuenta, String Cbu) {
	    boolean flag = false;
	    
	    cn = new Conexion();
	    cn.Open();
	    
	    String query = "SELECT COUNT(*) AS CuentaExistente FROM CUENTAS WHERE NumeroCuenta = " + NumeroCuenta + " OR CBU = '" + Cbu + "'";
	    
	    try {
	        ResultSet rs = cn.query(query);
	        if (rs.next()) {
	            int cuentaExistente = rs.getInt("CuentaExistente");
	            if (cuentaExistente > 0) {
	                flag = true;
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        cn.close();
	    }
	    
	    return flag;
	}
	@Override
	public ArrayList<Cuenta> listarCuentasPorTipo(double saldoMin, double saldoMax) {
	    cn = new Conexion();
	    cn.Open();
	    ArrayList<Cuenta> lista = new ArrayList<>();
	    
	    try {
	        String query = "SELECT c.IDCuenta, c.DNICliente, c.FechaCreacion, c.NumeroCuenta, c.CBU, c.Saldo, c.IDTipoCuenta, c.ESTADO " +
	                       "FROM cuentas c " +
	                       "WHERE c.Saldo >= " + saldoMin + " AND c.Saldo < " + saldoMax + " AND c.ESTADO = 1";
	        ResultSet rs = cn.query(query);
	        while (rs.next()) {
	            Cuenta cuenta = new Cuenta();
	            cuenta.setIDCuenta(rs.getInt("IDCuenta"));
	            cuenta.setDNICliente(rs.getInt("DNICliente"));
	            cuenta.setFechaCreacion(rs.getDate("FechaCreacion"));
	            cuenta.setNumeroCuenta(rs.getInt("NumeroCuenta"));
	            cuenta.setCBU(rs.getString("CBU"));
	            cuenta.setSaldo(rs.getDouble("Saldo"));
	            cuenta.setIDTipoCuenta(rs.getInt("IDTipoCuenta"));
	            cuenta.setEstado(rs.getBoolean("ESTADO"));
	            lista.add(cuenta);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        cn.close();
	    }
	    return lista;
	}

	@Override
	public ArrayList<Cuenta> listaCuentasResumen(Date fecha1, Date fecha2, int tipo) {
		   
		Conexion cn = new Conexion();
		    cn.Open();
		    
		    ArrayList<Cuenta> lista = new ArrayList<>();
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    
		    String fechaInicio = sdf.format(fecha1);
		    String fechaFin = sdf.format(fecha2);
			    
		    String query = "SELECT C.DNICliente, C.FechaCreacion, C.Saldo, C.Estado, TC.IDTipoCuenta " +
                    "FROM CUENTAS C " +
                    "JOIN TIPO_CUENTAS TC ON C.IDTipoCuenta = TC.IDTipoCuenta " +
                    "WHERE C.FechaCreacion BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "' " +
                    "AND TC.IDTipoCuenta = " + tipo;

		    try {
		         ResultSet rs = cn.query(query); 
		        while (rs.next()) {
		            Cuenta cuentaResumen = new Cuenta();
		            cuentaResumen.setDNICliente(rs.getInt("DNICliente"));
		            cuentaResumen.setFechaCreacion(rs.getDate("FechaCreacion"));
		            cuentaResumen.setSaldo(rs.getDouble("Saldo"));
		            cuentaResumen.setEstado(rs.getBoolean("Estado"));
		            cuentaResumen.setIDTipoCuenta(rs.getInt("IDTipoCuenta"));
		            lista.add(cuentaResumen);
		        }
		    } catch (Exception e) {
		        System.out.println(e.getMessage());
		    } finally {
		        cn.close();
		    }
		    return lista;
	}


}



