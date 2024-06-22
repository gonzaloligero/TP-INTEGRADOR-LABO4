package negocio;
import java.util.ArrayList;

import entidad.Cliente;
import entidad.Direccion;

public interface ClienteNegocio {
	
	public ArrayList <Cliente> listarClientes();
	public Cliente obtenerUnCliente(int IDUsuario);
	public boolean insertarCliente(Cliente cliente);
	public boolean editarCliente(Cliente cliente);
	public boolean bajaLogicaCliente(String dni);
	public boolean altaLogicaCliente(String dni);
	public ArrayList<Direccion> listarProvincias();
	public ArrayList<Direccion> listarLocalidades();
}

