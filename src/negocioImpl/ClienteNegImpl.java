package negocioImpl;
import java.util.ArrayList;

import datos.ClienteDao;
import entidad.Cliente;
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
	public Cliente obtenerUnCliente(int IDUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean bajaLogicaCliente(int IDUsuario) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
