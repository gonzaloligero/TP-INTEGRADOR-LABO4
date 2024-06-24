package datos;

import entidad.Usuario;

public interface UsuarioDao {
	Usuario obtenerUsuarioPorNombre(String nombreUsuario);
	boolean autenticarUsuario(String nombreUsuario, String contraseña);

}
