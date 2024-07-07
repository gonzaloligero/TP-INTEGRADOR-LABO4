package datos;

import java.util.List;

import entidad.Plazos;

public interface PlazosPrestamoDao {
		List<Plazos> obtenerTodos();
	    boolean agregar(Plazos plazo);
	    boolean actualizar(Plazos plazo);
	    boolean eliminar(int id);
	    Plazos obtenerPorId(int id);
		List<Plazos> obtenerCuotasPorPrestamo(int idPrestamo);
		List<Plazos> obtenerCuotasPorDNI(int dni);
}
