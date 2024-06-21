package negocio;



import java.util.List;

import entidad.Prestamos;

public interface PrestamosNegocio {

	  public boolean agregarPrestamo(Prestamos prestamo);
	    public boolean modificarPrestamo(Prestamos prestamo);
	    public boolean eliminarPrestamo(int IDPrestamo);
	    public Prestamos obtenerPrestamo(int IDPrestamo);
	    public List<Prestamos> obtenerTodosLosPrestamos();
	
}
