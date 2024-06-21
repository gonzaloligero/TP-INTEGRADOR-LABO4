package negocioImpl;


import java.util.List;

import datos.PrestamoDao;
import datosImpl.PrestamoDaoImpl;
import entidad.Prestamos;
import negocio.PrestamosNegocio;

public class PrestamosNegImpl implements PrestamosNegocio {

	private PrestamoDao prestamoDao = new PrestamoDaoImpl();

    @Override
    public boolean agregarPrestamo(Prestamos prestamo) {
        return prestamoDao.insertar(prestamo);
    }

    @Override
    public boolean modificarPrestamo(Prestamos prestamo) {
        return prestamoDao.actualizar(prestamo);
    }

    @Override
    public boolean eliminarPrestamo(int IDPrestamo) {
        return prestamoDao.eliminar(IDPrestamo);
    }

    @Override
    public Prestamos obtenerPrestamo(int IDPrestamo) {
        return prestamoDao.obtenerUno(IDPrestamo);
    }

    @Override
    public List<Prestamos> obtenerTodosLosPrestamos() {
        return prestamoDao.obtenerTodos();
    }



	

}
