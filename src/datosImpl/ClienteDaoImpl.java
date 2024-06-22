package datosImpl;
import entidad.Cliente;
import entidad.Direccion;
import datos.ClienteDao;
import java.util.ArrayList;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

public class ClienteDaoImpl implements ClienteDao{

	private Conexion cn;
	
	@Override
	public ArrayList<Cliente> obtenerClientes(){
		
		
		
		
		cn = new Conexion();
		cn.Open();
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		
		try {
			ResultSet rs= cn.query("SELECT c.ESTADO, l.Nombre, p.Nombre, u.Usuario, u.Contrase�a, t.NumeroTelefonico, c.Nombre, c.Apellido, c.DNI, c.CUIL, c.Sexo, c.Nacionalidad, c.FechaNacimiento, c.Email, d.Calle AS Calle, d.Numero AS Numero, d.CodigoPostal AS CodigoPostal FROM CLIENTES AS c INNER JOIN DIRECCIONES AS d ON d.IDDireccion = c.IDDireccion INNER JOIN USUARIOS AS u ON u.IDUsuario = c.IDUsuario INNER JOIN TELEFONOS AS T ON T.DNICliente = c.DNI INNER JOIN LOCALIDADES AS l ON l.IDLocalidad = d.IDLocalidad INNER JOIN PROVINCIAS AS p ON p.IDProvincia = l.IDProvincia");
			while(rs.next()) {
				Cliente regCliente = new Cliente();
				regCliente.setUser(rs.getString("u.Usuario"));
				regCliente.setEstado(rs.getBoolean("c.ESTADO"));
				regCliente.setPassword(rs.getString("u.Contrase�a"));
				regCliente.setNombre(rs.getString("c.Nombre"));
				regCliente.setApellido(rs.getString("c.Apellido"));
				regCliente.setDNI(rs.getInt("c.DNI"));
				regCliente.setCUIL(rs.getString("c.CUIL"));
				regCliente.setSexo(rs.getString("c.Sexo"));
				regCliente.setNacionalidad(rs.getString("c.Nacionalidad"));
				regCliente.setFechaNacimiento(rs.getDate("c.FechaNacimiento"));
				regCliente.setEmail(rs.getString("c.Email"));
				regCliente.setNumeroTelefonico(rs.getString("t.NumeroTelefonico"));
				String calle = rs.getString("d.Calle");
                int numero = rs.getInt("d.Numero");
                String codigoPostal = rs.getString("d.CodigoPostal");
                String localidad = rs.getString("l.Nombre");
                String provincia = rs.getString("p.Nombre");
                regCliente.setDireccion(calle, numero, codigoPostal, localidad, provincia);    
				lista.add(regCliente);
			}
		}catch (Exception e){	
				System.out.println(e.getMessage());	
		}finally {
			cn.close();
		}
		return lista;
	}


	@Override
	public Cliente obtenerUsuarioLogin(String email, String contrasenia) {
		
		cn = new Conexion();
		cn.Open();
		Cliente cliente = new Cliente();

		try {
		    ResultSet rs = cn.query("SELECT c.Nombre, c.Apellido, c.IDUsuario, u.TipoUsuario " + 
		                            "FROM CLIENTES c " + 
		                            "JOIN USUARIOS u ON c.IDUsuario = u.IDUsuario " + 
		                            "WHERE c.Email = '"+email+"' AND u.Contrase�a = '"+contrasenia+"';");
		    if (rs.next()) {
		        cliente = new Cliente();
		        
		        cliente.setNombre(rs.getString("Nombre"));
		        cliente.setApellido(rs.getString("Apellido"));
		        cliente.setIDUsuario(rs.getInt("IDUsuario"));
		        cliente.setUserType(rs.getInt("TipoUsuario"));
		    }
		} catch (Exception e) {    
		    System.out.println(e.getMessage());    
		} finally {
		    cn.close();
		}

		return cliente;
	}


	@Override
	public Cliente obtenerUnCliente(int IDUsuario) {
		cn = new Conexion();
		cn.Open();
		Cliente cliente = new Cliente();

		try {
			

		    ResultSet rs = cn.query("SELECT c.ESTADO, l.Nombre, p.Nombre, u.Usuario, u.Contrase�a, t.NumeroTelefonico, c.Nombre, c.Apellido, c.DNI, c.CUIL, c.Sexo, c.Nacionalidad, c.FechaNacimiento, c.Email, d.Calle AS Calle, d.Numero AS Numero, d.CodigoPostal AS CodigoPostal FROM CLIENTES AS c INNER JOIN DIRECCIONES AS d ON d.IDDireccion = c.IDDireccion INNER JOIN USUARIOS AS u ON u.IDUsuario = c.IDUsuario INNER JOIN TELEFONOS AS T ON T.DNICliente = c.DNI INNER JOIN LOCALIDADES AS l ON l.IDLocalidad = d.IDLocalidad INNER JOIN PROVINCIAS AS p ON p.IDProvincia = l.IDProvincia WHERE IDUsuario = '" + IDUsuario + "' ");
		    if (rs.next()) {
		        cliente = new Cliente();
		        
		        cliente.setDNI(rs.getInt("c.DNI"));
		        cliente.setEstado(rs.getBoolean("c.ESTADO"));
		        cliente.setCUIL(rs.getString("c.CUIL"));
		        cliente.setNombre(rs.getString("c.Nombre"));
		        cliente.setApellido(rs.getString("c.Apellido"));
		        cliente.setSexo(rs.getString("c.Sexo"));
		        cliente.setNacionalidad(rs.getString("c.Nacionalidad"));
		        String calle = rs.getString("d.Calle");
                int numero = rs.getInt("d.Numero");
                String codigoPostal = rs.getString("d.CodigoPostal");
                String localidad = rs.getString("l.Nombre");
                String provincia = rs.getString("p.Nombre");
                cliente.setDireccion(calle, numero, codigoPostal, localidad, provincia);
                cliente.setEmail(rs.getString("Email"));
		        cliente.setIDUsuario(rs.getInt("c.IDUsuario"));
		        cliente.setUserType(2);
		    }
		} catch (Exception e) {    
		    System.out.println(e.getMessage());    
		} finally {
		    cn.close();
		}

		return cliente;

	}


	@Override
	public boolean insertarCliente(Cliente cliente) {
		cn = new Conexion();
		cn.Open();
		boolean clienteInsertado = false;
		boolean telefonoInsertado = false;
		boolean direccionInsertada = false;
		

		try {
			
			if(cliente == null) {
				System.out.println("Se ha detectado un error al querer insertar el cliente");
				return false;
			}
			
			 if (cliente.getDNI() == 0 || cliente.getCUIL() == "" || cliente.getNombre() == "" || cliente.getApellido() == "" || 
			 cliente.getSexo() == "" || cliente.getNacionalidad() == "" || cliente.getFechaNacimiento() == null || 
			 cliente.getEmail() == "" || cliente.getIDUsuario() == 0 || cliente.getTelefono() == 0 || 
			 cliente.getDireccion().getID() == 0) {
			 System.out.println("Se ha detectado un error al querer insertar el cliente: uno o m�s campos obligatorios est�n vac�os.");
			 return false;
			}
			 
			 String queryCliente = "INSERT INTO CLIENTES (DNI, CUIL, Nombre, Apellido, Sexo, Nacionalidad, FechaNacimiento, IDDireccion, Email, IDUsuario) VALUES ('" + cliente.getDNI() + "', '" + cliente.getCUIL() + "', '" + cliente.getNombre() + "', '" + cliente.getApellido() + "', '" + cliente.getSexo() + "', '" + cliente.getNacionalidad() + "', '" + cliente.getFechaNacimiento() + "', '" + cliente.getDireccion().getID() + "', '" + cliente.getEmail() + "', '" + cliente.getIDUsuario() + "')";
			 clienteInsertado = cn.execute(queryCliente);
			 
			 String queryTelefono = "INSERT INTO TELEFONOS(IDTelefono, DNICliente, NumeroTelefonico) VALUES('" + cliente.getTelefono() + "', '" + cliente.getDNI() + "', '" + cliente.getNumeroTelefonico() + "')";
			 telefonoInsertado = cn.execute(queryTelefono);
			 
			 String queryDireccion = "INSERT INTO DIRECCIONES (IDDireccion, IDLocalidad, Nombre, CodigoPostal, Calle, Numero) VALUES('" + cliente.getDireccion().getID() + "', '" + cliente.getDireccion().getLocalidad() + "', '" + cliente.getEmail() + "', '" + cliente.getDireccion().getCodigoPostal() + "', '" + cliente.getDireccion().getCalle() + "', '" + cliente.getDireccion().getNumero() + "')";
			 direccionInsertada = cn.execute(queryDireccion);
			 
		} catch (Exception e) {    
		    System.out.println(e.getMessage());    
		} finally {
		    cn.close();
		}

		if(clienteInsertado == true && telefonoInsertado == true && direccionInsertada == true) {
			return true;
		}else {
			return false;
		}
		
		
	}


	@Override
	public boolean editarCliente(Cliente cliente) {
		boolean clienteEditado = false;

		cn = new Conexion();
		cn.Open();	

		String query = "UPDATE CLIENTES SET CUIL='" + cliente.getCUIL() + "', Nombre='" + cliente.getNombre() + "', Apellido='" + cliente.getApellido() + "', Sexo='" + cliente.getSexo() + "', Nacionalidad='" + cliente.getNacionalidad() + "', FechaNacimiento='" + cliente.getFechaNacimiento() + "', IDDireccion='" + cliente.getDireccion().getID() + "', Email='" + cliente.getEmail() + "', IDUsuario='" + cliente.getIDUsuario() + "' WHERE DNI='" + cliente.getDNI() + "'";

		
		try
		 {
			clienteEditado=cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return clienteEditado;
	}


	@Override
	public boolean bajaLogicaCliente(String dni) {
		boolean clienteDesactivado = false;
		
		cn = new Conexion();
		cn.Open();		 
		String query = "UPDATE CLIENTES SET ESTADO = 0 WHERE DNI="+dni;
		try
		 {
			clienteDesactivado=cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return clienteDesactivado;
	}


	@Override
	public ArrayList<Direccion> obtenerProvincias() {

		
		cn = new Conexion();
		cn.Open();
		ArrayList<Direccion> lista = new ArrayList<Direccion>();
		
		try {
			ResultSet rs= cn.query("SELECT Nombre FROM PROVINCIAS");
			while(rs.next()) {
				Direccion regDireccion = new Direccion();
				regDireccion.setProvincia(rs.getString("Nombre"));   
				lista.add(regDireccion);
			}
		}catch (Exception e){	
				System.out.println(e.getMessage());	
		}finally {
			cn.close();
		}
		return lista;
	}


	@Override
	public ArrayList<Direccion> obtenerLocalidades() {
		cn = new Conexion();
		cn.Open();
		ArrayList<Direccion> lista = new ArrayList<Direccion>();
		
		try {
			ResultSet rs= cn.query("SELECT l.Nombre FROM LOCALIDADES AS l INNER JOIN PROVINCIAS AS p ON l.IDProvincia = p.IDProvincia");
			while(rs.next()) {
				Direccion regDireccion = new Direccion();
				regDireccion.setLocalidad(rs.getString("l.Nombre"));   
				lista.add(regDireccion);
			}
		}catch (Exception e){	
				System.out.println(e.getMessage());	
		}finally {
			cn.close();
		}
		return lista;
	}


	@Override
	public boolean altaLogicaCliente(String DNI) {
boolean clienteDesactivado = false;
		
		cn = new Conexion();
		cn.Open();		 
		String query = "UPDATE CLIENTES SET ESTADO = 1 WHERE DNI="+DNI;
		try
		 {
			clienteDesactivado=cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return clienteDesactivado;
	}
	

	
	
}
