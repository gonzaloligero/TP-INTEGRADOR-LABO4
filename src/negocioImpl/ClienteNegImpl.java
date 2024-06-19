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
	
}
