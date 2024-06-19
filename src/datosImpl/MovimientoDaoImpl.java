package datosImpl;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;

import datos.MovimientoDao;
import entidad.Cliente;
import entidad.Movimiento;



public class MovimientoDaoImpl implements MovimientoDao {

    private Conexion cn;

    public ArrayList<Movimiento> obtenerMovimientos() {

        cn = new Conexion();
        cn.Open();
        ArrayList<Movimiento> lista = new ArrayList<Movimiento>();

        try {
            ResultSet rs = cn.query("SELECT M.IDMovimiento, M.Fecha, M.Detalle, M.Importe, M.IDCuenta ,TM.Tipo FROM MOVIMIENTOS M INNER JOIN TIPO_MOVIMIENTOS TM ON M.IDMovimiento = TM.IDMovimiento WHERE M.IDMovimiento = TM.IDMovimiento;");
            while (rs.next()) {
                Movimiento regMovimiento = new Movimiento();
                regMovimiento.setIdMovimiento(rs.getInt("m.idMovimiento"));
                regMovimiento.setFecha(rs.getDate("m.fecha"));
                regMovimiento.setDetalle(rs.getString("m.detalle"));
                regMovimiento.setImporte(rs.getBigDecimal("m.importe"));
                regMovimiento.setIdCuenta(rs.getInt("m.idCuenta"));
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
	public ArrayList<Movimiento> listarMovimiento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movimiento listarMovimiento(int idMovimiento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertarMovimiento(Movimiento movimiento) {
		// TODO Auto-generated method stub
		return false;
	}
}