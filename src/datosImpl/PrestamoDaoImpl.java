package datosImpl;

import java.util.List;

import datos.PrestamoDao;
import entidad.Prestamos;

public class PrestamoDaoImpl implements PrestamoDao{
    private static final String INSERT = "INSERT INTO PRESTAMOS (DNICliente, MontoPedido, ImporteAPagar, Cuotas, Fecha, Estado) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE PRESTAMOS SET DNICliente=?, MontoPedido=?, ImporteAPagar=?, Cuotas=?, Fecha=?, Estado=? WHERE IDPrestamo=?";
    private static final String DELETE = "DELETE FROM PRESTAMOS WHERE IDPrestamo=?";
    private static final String SELECT_ONE = "SELECT * FROM PRESTAMOS WHERE IDPrestamo=?";
    private static final String SELECT_ALL = "SELECT * FROM PRESTAMOS";
	
	

	@Override
	public boolean insertar(Prestamos prestamo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(Prestamos prestamo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int IDPrestamo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Prestamos obtenerUno(int IDPrestamo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prestamos> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	

}