package datosImpl;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidad.TipoPrestamos;
public class TipoPrestamoDaoImpl {
	 private Conexion cn;

	    public List<TipoPrestamos> obtenerTodos() {
	        cn = new Conexion();
	        cn.Open();
	        List<TipoPrestamos> lista = new ArrayList<TipoPrestamos>();

	        try {
	            String query = "SELECT * FROM TIPO_PRESTAMOS";
	            ResultSet rs = cn.query(query);
	            while (rs.next()) {
	                TipoPrestamos tipoPrestamo = new TipoPrestamos();
	                tipoPrestamo.setIDTipoPrestamo(rs.getInt("IDTipoPrestamo"));
	                tipoPrestamo.setTipo(rs.getString("Tipo"));
	                tipoPrestamo.setTNA(rs.getInt("TNA"));
	                lista.add(tipoPrestamo);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            cn.close();
	        }
	        return lista;
	    }
	}