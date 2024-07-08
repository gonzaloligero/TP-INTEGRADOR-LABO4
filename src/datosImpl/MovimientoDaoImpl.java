package datosImpl;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import datos.MovimientoDao;
import entidad.Cliente;
import entidad.Movimiento;



public class MovimientoDaoImpl implements MovimientoDao {

    private Conexion cn;

    public ArrayList<Movimiento> listarMovimientos() {

        cn = new Conexion();
        cn.Open();
        ArrayList<Movimiento> lista = new ArrayList<Movimiento>();

        try {
            ResultSet rs = cn.query("SELECT M.IDMovimiento, M.Fecha, M.Detalle, M.Importe, M.IDCuentaEmisor, M.IDCuentaReceptos ,TM.Nombre FROM MOVIMIENTOS as M INNER JOIN TIPO_MOVIMIENTOS as TM ON M.IDTipoMovimiento = TM.IDTipoMovimiento;");
            while (rs.next()) {
                Movimiento regMovimiento = new Movimiento();
                regMovimiento.setIdMovimiento(rs.getInt("IDMovimiento"));
                regMovimiento.setFecha(rs.getDate("Fecha"));
                regMovimiento.setDetalle(rs.getString("Detalle"));
                regMovimiento.setImporte(rs.getBigDecimal("Importe"));
                regMovimiento.setIdCuentaEmisor(rs.getInt("IDCuentaEmisor"));
                regMovimiento.setIdCuentaReceptor(rs.getInt("IDCuentaReceptor"));
                regMovimiento.setTipoMovimiento("Nombre");
                
                lista.add(regMovimiento);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            cn.close();
        }
        return lista;
    }


	@Override
	public Movimiento listarUnMovimiento(int dniCliente) {
		
		cn = new Conexion();
        cn.Open();
        ArrayList<Movimiento> lista = new ArrayList<Movimiento>();

		
        try {
        	ResultSet rs = cn.query("SELECT C.Nombre, C.Apellido, C.DNI, M.IDMovimiento, M.Fecha, M.Importe, M.IDCuentaEmisor, M.IDCuentaReceptor, TM.Nombre FROM MOVIMIENTOS AS M INNER JOIN TIPO_MOVIMIENTOS AS TM ON TM.IDTipoMovimiento = M.IDTipoMovimiento INNER JOIN CUENTAS AS C ON C.IDCuenta = M.IDCuentaEmisor WHERE C.DNI = " + dniCliente);

        	Movimiento regMovimiento = new Movimiento();
        	
        	String nombre = rs.getString("Nombre");
            String apellido = rs.getString("Apellido");
            int dni = rs.getInt("DNI");
            String detalle = nombre + " " + apellido + " (DNI: " + dni + ")"; 
            regMovimiento.setDetalle(detalle);
            
            
            int idMovimiento = rs.getInt("IDMovimiento");
            regMovimiento.setIdMovimiento(idMovimiento);  
        	
            int idCuentaEmisor = rs.getInt("IDCuentaEmisor");
        	regMovimiento.setIdCuentaEmisor(idCuentaEmisor);
   
            int idCuentaReceptor = rs.getInt("IDCuentaReceptor");
        	regMovimiento.setIdCuentaReceptor(idCuentaReceptor);
        	
        	regMovimiento.setDetalle("C.DNI");
        	
            Date fecha = rs.getDate("Fecha"); 
        	regMovimiento.setFecha(fecha);
        	
            BigDecimal importe = rs.getBigDecimal("Importe"); 
        	regMovimiento.setImporte(importe);
        	
        	regMovimiento.setTipoMovimiento("TM.Nombre");
        	
        	lista.add(regMovimiento);
        	
        }catch(Exception e) {
        	System.out.println(e.getMessage());
        } finally {
            cn.close();
        }
		
		return null;
	}


	@Override
	public boolean realizarTransferencia(Movimiento transferencia) {
		
		boolean movimientoInsertado = false;
		boolean saldoPositivo = false;
		boolean saldoNegativo = false;
		cn = new Conexion();
        cn.Open();
        
        BigDecimal importe = transferencia.getImporte();

        
        try {
        	String queryMovimiento = "INSERT INTO MOVIMIENTOS(Fecha,Detalle,Importe,IDCuentaEmisor, IDCuentaReceptor,IDTipoMovimiento)"
	        		+ "VALUES(CURDATE(), '"+transferencia.getDetalle()+"', "+ importe +","+ transferencia.getIdCuentaEmisor() +", "+ transferencia.getIdCuentaReceptor() +  ", "+ 4 +" );";
      
        	String querySaldoNegativo = "UPDATE CUENTAS SET Saldo = Saldo - " + importe + " WHERE NumeroCuenta = " + transferencia.getIdCuentaEmisor() + ";";
        	
        	String querySaldoPositivo = "UPDATE CUENTAS SET Saldo = Saldo + " + importe + " WHERE NumeroCuenta = " + transferencia.getIdCuentaReceptor() + ";";

        	
		 movimientoInsertado = cn.execute(queryMovimiento);	
		 
		 saldoPositivo = cn.execute(querySaldoPositivo);
		 
		 saldoNegativo = cn.execute(querySaldoNegativo);
		 
		
        }
        catch(Exception e){
        	System.out.println(e.getMessage());
        }
        finally {
            cn.close();
        }
        	
        if(movimientoInsertado == true && saldoPositivo == true && saldoNegativo == true) {
        	return true;
        }else {return false;}

		 
	}


	@Override
	public ArrayList<Movimiento> listarTransferenciasDeUnCliente(int dniCliente) {
		cn = new Conexion();
        cn.Open();
        ArrayList<Movimiento> lista = new ArrayList<Movimiento>();
        
        try {
            ResultSet rs = cn.query("SELECT M.Fecha, M.Detalle, M.Importe, M.IDCuentaEmisor, M.IDCuentaReceptor FROM MOVIMIENTOS AS M INNER JOIN CUENTAS AS C ON C.NumeroCuenta = M.IDCuentaEmisor INNER JOIN CLIENTES AS CL ON CL.DNI = C.DNICliente WHERE CL.DNI = " + dniCliente);
            	while (rs.next()) {
                Movimiento regMovimiento = new Movimiento();
                regMovimiento.setIdMovimiento(rs.getInt("IDMovimiento"));
                regMovimiento.setFecha(rs.getDate("Fecha"));
                regMovimiento.setDetalle(rs.getString("Detalle"));
                regMovimiento.setImporte(rs.getBigDecimal("Importe"));
                regMovimiento.setIdCuentaEmisor(rs.getInt("IDCuentaEmisor"));
                regMovimiento.setIdCuentaReceptor(rs.getInt("IDCuentaReceptor"));
                
                lista.add(regMovimiento);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            cn.close();
        }
		
		return lista;
	}

	
}