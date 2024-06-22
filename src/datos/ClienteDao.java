package datos;
import java.util.ArrayList;

import entidad.Cliente;
import entidad.Direccion;

public interface ClienteDao {

	public ArrayList<Cliente> obtenerClientes();
	public Cliente obtenerUsuarioLogin(String email, String contrasenia);
	public Cliente obtenerUnCliente(int IDUsuario);
	public boolean insertarCliente(Cliente cliente);
	public boolean editarCliente(Cliente cliente);
	public boolean bajaLogicaCliente(String DNI);
	public boolean altaLogicaCliente(String DNI);
	public ArrayList<Direccion>obtenerProvincias();
	public ArrayList<Direccion>obtenerLocalidades();
	
}

