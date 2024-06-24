package datosImpl;

import entidad.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import datos.UsuarioDao;

public class UsuarioDaoImpl implements UsuarioDao {

    private Conexion cn;

    @Override
    public Usuario obtenerUsuarioPorNombre(String nombreUsuario) {
        cn = new Conexion();
        cn.Open();
        Usuario usuario = null;

        try {
            String query = "SELECT IDUsuario, Usuario, Contraseña, TipoUsuario FROM USUARIOS WHERE Usuario = ?";
            PreparedStatement statement = cn.Open().prepareStatement(query);
            statement.setString(1, nombreUsuario);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setID(rs.getInt("IDUsuario"));
                usuario.setUser(rs.getString("Usuario"));
                usuario.setPassword(rs.getString("Contraseña"));
                usuario.setUserType(rs.getInt("TipoUsuario"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cn.close();
        }
        return usuario;
    }

    @Override
    public boolean autenticarUsuario(String nombreUsuario, String contraseña) {
        Usuario usuario = obtenerUsuarioPorNombre(nombreUsuario);
        if (usuario != null && usuario.verificarContraseña(contraseña)){
        	
            return true;
        }
        return false;
    }
    
    public Usuario obtenerUsuarioLogin(String email, String contrasenia) {
        cn = new Conexion();
        cn.Open();
        Usuario usuario = null;

        try {
            String query = "SELECT * FROM USUARIOS WHERE Usuario = '" + email + "' AND Contraseña = '" + contrasenia + "'";
            ResultSet rs = cn.query(query);

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setUser(rs.getString("Usuario"));
                usuario.setPassword(rs.getString("Contraseña"));
                usuario.setUserType(rs.getInt("TipoUsuario"));
                // Otras asignaciones si es necesario
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cn.close();
        }

        return usuario;
    }
    
    
}

