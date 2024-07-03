package datos;
import java.util.ArrayList;
import java.util.Map;

import entidad.Cliente;
import entidad.Direccion;

public interface ClienteDao {

	public ArrayList<Cliente> obtenerClientes();
	public Cliente obtenerUsuarioLogin(String email, String contrasenia);
	public Cliente obtenerUnCliente(String dni);
	public boolean insertarCliente(Cliente cliente);
	public boolean editarCliente(Cliente cliente);
	public boolean bajaLogicaCliente(String DNI);
	public boolean altaLogicaCliente(String DNI);
	public ArrayList<Direccion>obtenerProvincias();
	public ArrayList<Direccion>obtenerLocalidades();
	public ArrayList<Integer> obtenerCantidadClientesPorProvincia();
	Cliente obtenerUnClientePorIDUsuario(int idUsuario);
	
	
}

