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
<<<<<<< HEAD
		// TODO Auto-generated method stub
		return null;
=======
		return clienteDao.obtenerUnCliente(IDUsuario);
>>>>>>> origin/main
	}

	@Override
	public boolean insertarCliente(Cliente cliente) {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		return false;
=======
		return clienteDao.insertarCliente(cliente);
>>>>>>> origin/main
	}

	@Override
	public boolean editarCliente(Cliente cliente) {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		return false;
=======
		return clienteDao.editarCliente(cliente);
>>>>>>> origin/main
	}

	@Override
	public boolean bajaLogicaCliente(int IDUsuario) {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		return false;
	}
=======
		return clienteDao.bajaLogicaCliente(IDUsuario);
	}

>>>>>>> origin/main
	
}
