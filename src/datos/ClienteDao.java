package datos;
import java.util.ArrayList;

import entidad.Cliente;

public interface ClienteDao {

	public ArrayList<Cliente> obtenerClientes();
	public Cliente obtenerUsuarioLogin(String email, String contrasenia);
	/*public Cliente obtenerUnCliente(int IDUsuario);
	public boolean insertarCliente(Cliente cliente);
	public boolean editarCliente(Cliente cliente);
	public boolean bajaLogicaCliente(int IDUsuario);*/
	
	
}

