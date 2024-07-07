package datos;





import java.util.List;

import entidad.Prestamos;

public interface PrestamoDao {
	public boolean insertar(Prestamos prestamo);
    public boolean actualizar(Prestamos prestamo);
    public boolean eliminar(int IDPrestamo);
    public Prestamos obtenerUno(int IDPrestamo);
    public List<Prestamos> obtenerTodos();
	Prestamos obtenerPrestamosCliente(int DNICliente);
	List<Prestamos> obtenerTodosPrestamosCliente(int DNICliente);

}
