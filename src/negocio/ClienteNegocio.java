package negocio;
import java.util.ArrayList;
import java.util.Map;

import entidad.Cliente;
import entidad.Direccion;

public interface ClienteNegocio {
	
	public ArrayList <Cliente> listarClientes();
	public Cliente obtenerUnCliente(String dnicliente);
	public boolean insertarCliente(Cliente cliente);
	public boolean editarCliente(Cliente cliente);
	public boolean bajaLogicaCliente(String dni);
	public boolean altaLogicaCliente(String dni);
	public ArrayList<Direccion> listarProvincias();
	public ArrayList<Direccion> listarLocalidades();
	public ArrayList<Integer> obtenerCantidadClientesPorProvincia();

}

