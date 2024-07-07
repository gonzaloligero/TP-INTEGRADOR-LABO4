package datosImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Plazos;
import datos.PlazosPrestamoDao;


public class PlazosPrestamoImpleDao implements PlazosPrestamoDao {

    private Conexion cn;

    private static final String SELECT_ALL = "SELECT * FROM Plazos";
    private static final String INSERT = "INSERT INTO Plazos (IDPrestamo, MesQuePaga, ImporteAPagarCuotas, NroCuota, Estado) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE Plazos SET IDPrestamo = ?, MesQuePaga = ?, ImporteAPagarCuotas = ?, NroCuota = ?, Estado = ? WHERE IDPlazo = ?";
    private static final String DELETE = "DELETE FROM Plazos WHERE IDPlazo = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM Plazos WHERE IDPlazo = ?";

    @Override
    public List<Plazos> obtenerTodos() {
        List<Plazos> lista = new ArrayList<>();
        cn = new Conexion();
        cn.Open();
        try { 
            ResultSet rs = cn.query(SELECT_ALL);
            while (rs.next()) {
                Plazos plazo = new Plazos();
                plazo.setIDPlazo(rs.getInt("IDPlazo"));
                plazo.setIDPrestamo(rs.getInt("IDPrestamo"));
                plazo.setMesQuePaga(rs.getString("MesQuePaga"));
                plazo.setImporteAPagarCuotas(rs.getDouble("ImporteAPagarCuotas"));
                plazo.setNroCuota(rs.getInt("NroCuota"));
                plazo.setEstado(rs.getBoolean("Estado"));
                lista.add(plazo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cn.close();
        }
        return lista;
    }

    
    @Override
    public List<Plazos> obtenerCuotasPorPrestamo(int idPrestamo) {
        List<Plazos> cuotasList = new ArrayList<>();
        cn = new Conexion();
        cn.Open();

        try {
            String SELECT_CUOTAS = "SELECT * FROM CUOTAS WHERE IDPrestamo=" + idPrestamo;
            ResultSet rs = cn.query(SELECT_CUOTAS);

            while (rs.next()) {
            	  Plazos plazo = new Plazos();
                  plazo.setIDPlazo(rs.getInt("IDPlazo"));
                  plazo.setIDPrestamo(rs.getInt("IDPrestamo"));
                  plazo.setMesQuePaga(rs.getString("MesQuePaga"));
                  plazo.setImporteAPagarCuotas(rs.getDouble("ImporteAPagarCuotas"));
                  plazo.setNroCuota(rs.getInt("NroCuota"));
                  plazo.setEstado(rs.getBoolean("Estado"));
                  cuotasList.add(plazo);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            cn.close();
        }

        return cuotasList;
    }

    @Override
    public List<Plazos> obtenerCuotasPorDNI(int dni) {
        List<Plazos> cuotasList = new ArrayList<>();
        cn = new Conexion();
        cn.Open();

        try {
            String SELECT_CUOTAS = "SELECT * FROM plazos c INNER JOIN PRESTAMOS p ON c.IDPrestamo = p.IDPrestamo WHERE p.DNICLiente=" + dni;
            ResultSet rs = cn.query(SELECT_CUOTAS);

            while (rs.next()) {
                Plazos plazo = new Plazos();
                plazo.setIDPlazo(rs.getInt("IDPlazo"));
                plazo.setIDPrestamo(rs.getInt("IDPrestamo"));
                plazo.setMesQuePaga(rs.getString("MesQuePaga"));
                plazo.setImporteAPagarCuotas(rs.getDouble("ImporteAPagarCuotas"));
                plazo.setNroCuota(rs.getInt("NroCuota"));
                plazo.setEstado(rs.getBoolean("Estado"));
                cuotasList.add(plazo);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            cn.close();
        }

        return cuotasList;
    }

    
    
    
    @Override
    public boolean agregar(Plazos plazo) {
        cn = new Conexion();
        cn.Open();
        boolean resultado = false;
        try {
            resultado = cn.execute(UPDATE);
        } finally {
            cn.close();
        }
        return resultado;
    }

    @Override
    public boolean actualizar(Plazos plazo) {
        cn = new Conexion();
        cn.Open();
        boolean resultado = false;
        try {
        	
     resultado = cn.execute("UPDATE Plazos SET IDPrestamo = " + plazo.getIDPrestamo() + ", MesQuePaga = " + plazo.getMesQuePaga() + ", ImporteAPagarCuotas = " + plazo.getImporteAPagarCuotas() + ", NroCuota = " + plazo.getNroCuota()+ ", Estado =" + (plazo.isEstado()? 1 : 0)+ "  WHERE IDPlazo =" + plazo.getIDPlazo());
        } finally {
            cn.close();
        }
        return resultado;
    }



    @Override
    public Plazos obtenerPorId(int id) {
        Plazos plazo = null;
        cn = new Conexion();
        cn.Open();
        try {
            ResultSet rs = cn.query("SELECT * FROM Plazos WHERE IDPlazo = "+ id);
            if (rs.next()) {
                plazo = new Plazos();
                plazo.setIDPlazo(rs.getInt("IDPlazo"));
                plazo.setIDPrestamo(rs.getInt("IDPrestamo"));
                plazo.setMesQuePaga(rs.getString("MesQuePaga"));
                plazo.setImporteAPagarCuotas(rs.getDouble("ImporteAPagarCuotas"));
                plazo.setNroCuota(rs.getInt("NroCuota"));
                plazo.setEstado(rs.getBoolean("Estado"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cn.close();
        }
        return plazo;
    }

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}


}

