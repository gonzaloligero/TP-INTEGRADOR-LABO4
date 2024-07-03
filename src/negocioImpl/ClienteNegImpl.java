package negocioImpl;
import java.util.ArrayList;
import java.util.Map;

import datos.ClienteDao;
import entidad.Cliente;
import entidad.Direccion;
import datosImpl.ClienteDaoImpl;
import negocio.ClienteNegocio;

public class ClienteNegImpl implements ClienteNegocio{
	
	private ClienteDao clienteDao = new ClienteDaoImpl();

	
	public ClienteNegImpl(ClienteDao clDao) {
		this.clienteDao = clDao;
	}
	
	public ClienteNegImpl() {}
	
	public ArrayList<Cliente> listarClientes(){
		return(ArrayList<Cliente>) clienteDao.obtenerClientes();
		
	}

	@Override
	public Cliente obtenerUnCliente(String dnicliente) {

	

		return clienteDao.obtenerUnCliente(dnicliente);

	}

	@Override
	public boolean insertarCliente(Cliente cliente) {

	
		return clienteDao.insertarCliente(cliente);

	}

	@Override
	public boolean editarCliente(Cliente cliente) {

	

		return clienteDao.editarCliente(cliente);

	}

	@Override
	public boolean bajaLogicaCliente(String dni) {


		return clienteDao.bajaLogicaCliente(dni);
	}

	@Override
	public ArrayList<Direccion> listarProvincias() {
		return(ArrayList<Direccion>) clienteDao.obtenerProvincias();
	}
	
	@Override
	public ArrayList<Direccion> listarLocalidades() {
		return(ArrayList<Direccion>) clienteDao.obtenerLocalidades();
	}

	@Override
	public boolean altaLogicaCliente(String dni) {
		return clienteDao.altaLogicaCliente(dni);
	}

	@Override
	public ArrayList<Integer> obtenerCantidadClientesPorProvincia(){
		return clienteDao.obtenerCantidadClientesPorProvincia();
	}

	
}
