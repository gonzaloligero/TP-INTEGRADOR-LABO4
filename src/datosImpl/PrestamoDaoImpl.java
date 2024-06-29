package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import datos.PrestamoDao;
import entidad.Prestamos;

public class PrestamoDaoImpl implements PrestamoDao {
    private static final String INSERT = "INSERT INTO PRESTAMOS (DNICliente,IDTipoPrestamo, MontoPedido, ImporteAPagar, Cuotas, Fecha, Estado) VALUES (?,?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE PRESTAMOS SET DNICliente=?, MontoPedido=?, ImporteAPagar=?, Cuotas=?, Fecha=?, Estado=? WHERE IDPrestamo=?";
    private static final String DELETE = "DELETE FROM PRESTAMOS WHERE IDPrestamo=?";
    private static final String SELECT_ONE = "SELECT * FROM PRESTAMOS WHERE IDPrestamo=?";
    private static final String SELECT_ALL = "SELECT * FROM PRESTAMOS";

    private Conexion cn;

    
    
    
    @Override
    public boolean insertar(Prestamos prestamo) {
        cn = new Conexion();
        cn.Open();
        boolean prestamoInsertado = false;

        try {
            if (prestamo == null) {
                System.out.println("Se ha detectado un error al querer insertar el prestamo");
                return prestamoInsertado;
            }

            String INSERT = "INSERT INTO PRESTAMOS (IDTipoPrestamo, DNICliente, MontoPedido, ImporteAPagar, Cuotas, Fecha, Estado) VALUES ("
                    + prestamo.getIDTipoPrestamo() + ", "
                    + prestamo.getDNICliente() + ", "
                    + prestamo.getMontoPedido() + ", "
                    + prestamo.getImporteAPagar() + ", "
                    + prestamo.getCuotas() + ", "
                    + "'" + new java.sql.Date(prestamo.getFecha().getTime()) + "', "
                    + (prestamo.isEstado() ? 1 : 0) + ")";


            prestamoInsertado = cn.execute(INSERT);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            cn.close();
        }

        return prestamoInsertado;
    }

    @Override
    public boolean actualizar(Prestamos prestamo) {
        cn = new Conexion();
        cn.Open();
        boolean prestamoActualizado = false;

        try {
            if (prestamo == null) {
                System.out.println("Se ha detectado un error al querer actualizar el prestamo");
                return prestamoActualizado;
            }

            String UPDATE = "UPDATE PRESTAMOS SET IDTipoPrestamo="  + prestamo.getIDTipoPrestamo() + ",  DNICliente=" + prestamo.getDNICliente() + ", MontoPedido="
                    + prestamo.getMontoPedido() + ", ImporteAPagar=" + prestamo.getImporteAPagar() + ", Cuotas="
                    + prestamo.getCuotas() + ", Fecha='" + new java.sql.Date(prestamo.getFecha().getTime())
                    + "', Estado=" + (prestamo.isEstado() ? 1 : 0) + " WHERE IDPrestamo=" + prestamo.getIDPrestamo();

            prestamoActualizado = cn.execute(UPDATE);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            cn.close();
        }

        return prestamoActualizado;
    }

    @Override
    public boolean eliminar(int IDPrestamo) {
        cn = new Conexion();
        cn.Open();
        boolean prestamoEliminado = false;

        try {
            String DELETE = "DELETE FROM PRESTAMOS WHERE IDPrestamo=" + IDPrestamo;
            prestamoEliminado = cn.execute(DELETE);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            cn.close();
        }

        return prestamoEliminado;
    }

    @Override
    public Prestamos obtenerUno(int IDPrestamo) {
        cn = new Conexion();
        cn.Open();
        Prestamos prestamo = null;

        try {
            String SELECT_ONE = "SELECT * FROM PRESTAMOS WHERE IDPrestamo=" + IDPrestamo;
            ResultSet rs = cn.query(SELECT_ONE);

            if (rs.next()) {
                prestamo = new Prestamos();
                prestamo.setIDPrestamo(rs.getInt("IDPrestamo"));
                prestamo.setIDTipoPrestamo(rs.getInt("IDTipoPrestamo"));
                prestamo.setDNICliente(rs.getInt("DNICliente"));
                prestamo.setMontoPedido(rs.getDouble("MontoPedido"));
                prestamo.setImporteAPagar(rs.getDouble("ImporteAPagar"));
                prestamo.setCuotas(rs.getInt("Cuotas"));
                prestamo.setFecha(rs.getDate("Fecha"));
                prestamo.setEstado(rs.getBoolean("Estado"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            cn.close();
        }

        return prestamo;
    }

    
    
    
    @Override
    public List<Prestamos> obtenerTodos() {
        cn = new Conexion();
        cn.Open();
        List<Prestamos> prestamosList = new ArrayList<>();

        try {
            String SELECT_ALL = "SELECT * FROM PRESTAMOS";
            ResultSet rs = cn.query(SELECT_ALL);

            while (rs.next()) {
                Prestamos prestamo = new Prestamos();
                prestamo.setIDPrestamo(rs.getInt("IDPrestamo"));
                prestamo.setIDTipoPrestamo(rs.getInt("IDTipoPrestamo"));
                prestamo.setDNICliente(rs.getInt("DNICliente"));
                prestamo.setMontoPedido(rs.getDouble("MontoPedido"));
                prestamo.setImporteAPagar(rs.getDouble("ImporteAPagar"));
                prestamo.setCuotas(rs.getInt("Cuotas"));
                prestamo.setFecha(rs.getDate("Fecha"));
                prestamo.setEstado(rs.getBoolean("Estado"));

                prestamosList.add(prestamo);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            cn.close();
        }

        return prestamosList;
    }
}
