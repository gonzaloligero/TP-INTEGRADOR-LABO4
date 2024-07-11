package datosImpl;
import entidad.Cliente;
import entidad.Direccion;
import datos.ClienteDao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDaoImpl implements ClienteDao{

	private Conexion cn;
	private CuentaDaoImpl cuentaDao;
	private MovimientoDaoImpl movimientoDao;
	
	@Override
	public ArrayList<Cliente> obtenerClientes(){
		
		
		
		
		cn = new Conexion();
		cn.Open();
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		
		try {
			ResultSet rs= cn.query("SELECT c.ESTADO, l.Nombre, p.Nombre, u.Usuario, u.Contraseña, t.NumeroTelefonico, c.Nombre, c.Apellido, c.DNI, c.CUIL, c.Sexo, c.Nacionalidad, c.FechaNacimiento, c.Email, d.Calle AS Calle, d.Numero AS Numero, d.CodigoPostal AS CodigoPostal FROM CLIENTES AS c INNER JOIN DIRECCIONES AS d ON d.IDDireccion = c.IDDireccion INNER JOIN USUARIOS AS u ON u.IDUsuario = c.IDUsuario INNER JOIN TELEFONOS AS T ON T.DNICliente = c.DNI INNER JOIN LOCALIDADES AS l ON l.IDLocalidad = d.IDLocalidad INNER JOIN PROVINCIAS AS p ON p.IDProvincia = l.IDProvincia");
			while(rs.next()) {
				Cliente regCliente = new Cliente();
				regCliente.setUser(rs.getString("u.Usuario"));
				regCliente.setEstado(rs.getBoolean("c.ESTADO"));
				regCliente.setPassword(rs.getString("u.Contraseña"));
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
		                            "WHERE c.Email = '"+email+"' AND u.Contraseña = '"+contrasenia+"';");
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
	public Cliente obtenerUnCliente(String dni) {
		cn = new Conexion();
		cn.Open();
		Cliente cliente = new Cliente();

		try {
			

		    ResultSet rs = cn.query("SELECT c.ESTADO, l.Nombre, p.Nombre, u.Usuario, u.Contraseña, t.NumeroTelefonico, c.Nombre, c.Apellido, c.DNI, c.CUIL, c.Sexo, c.Nacionalidad, c.FechaNacimiento, c.Email, d.Calle AS Calle, d.Numero AS Numero, d.CodigoPostal AS CodigoPostal FROM CLIENTES AS c INNER JOIN DIRECCIONES AS d ON d.IDDireccion = c.IDDireccion INNER JOIN USUARIOS AS u ON u.IDUsuario = c.IDUsuario INNER JOIN TELEFONOS AS T ON T.DNICliente = c.DNI INNER JOIN LOCALIDADES AS l ON l.IDLocalidad = d.IDLocalidad INNER JOIN PROVINCIAS AS p ON p.IDProvincia = l.IDProvincia WHERE DNI = " + dni);
		    if (rs.next()) {
		        cliente = new Cliente();
		        
		        cliente.setDNI(rs.getInt("c.DNI"));
		        cliente.setEstado(rs.getBoolean("c.ESTADO"));
		        cliente.setCUIL(rs.getString("c.CUIL"));
		        cliente.setNombre(rs.getString("c.Nombre"));
		        cliente.setApellido(rs.getString("c.Apellido"));
		        cliente.setSexo(rs.getString("c.Sexo"));
		        cliente.setNacionalidad(rs.getString("c.Nacionalidad"));
		        cliente.setFechaNacimiento(rs.getDate("c.FechaNacimiento"));
		        cliente.setNumeroTelefonico(rs.getString("t.NumeroTelefonico"));
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
	    boolean usuarioInsertado = false;
	    boolean cuentaInsertada = false;
	    boolean movimientoInsertado = false;
            int idLocalidad = 0;

		try {		
			if(cliente == null) {
				System.out.println("Se ha detectado un error al querer insertar el cliente");
				return false;}	
			
			
			//VERIFICACIÓN SI EL USUARIO YA EXISTE. FALTA EL MENSAJE EN EL JSP
			ResultSet queryUsuarioExistente = cn.query("SELECT Usuario FROM USUARIOS WHERE Usuario = '" + cliente.getUser() + "'");		
			if(queryUsuarioExistente.next()) {
				return false;}
			
			//VERIFICACIÓN SI EL CLIENTE YA EXISTE. FALTA EL MENSAJE EN EL JSP
			ResultSet queryClienteExistente = cn.query("SELECT DNI FROM CLIENTES WHERE DNI =" + cliente.getDNI());	
			if(queryClienteExistente.next()) {
				return false;}

			
			
			 String queryUsuario = "INSERT INTO USUARIOS (Usuario, Contraseña, TipoUsuario, Estado) VALUES('" + cliente.getUser() + "', '" + cliente.getPassword() + "', 2, 1)";
			 usuarioInsertado = cn.execute(queryUsuario);
			 
			 
			 String provincia = cliente.getDireccion().getProvincia();
			 int provinciaNumero = 1;
			 switch(provincia) {
			     case "Buenos Aires":
			         provinciaNumero = 1;
			         break;
			     case "Catamarca":
			         provinciaNumero = 2;
			         break;
			     case "Chaco":
			         provinciaNumero = 3;
			         break;
			     case "Chubut":
			         provinciaNumero = 4;
			         break;
			     case "Córdoba":
			         provinciaNumero = 5;
			         break;
			     case "Corrientes":
			         provinciaNumero = 6;
			         break;
			     case "Entre Ríos":
			         provinciaNumero = 7;
			         break;
			     case "Formosa":
			         provinciaNumero = 8;
			         break;
			     case "Jujuy":
			         provinciaNumero = 9;
			         break;
			     case "La Pampa":
			         provinciaNumero = 10;
			         break;
			     case "La Rioja":
			         provinciaNumero = 11;
			         break;
			     case "Mendoza":
			         provinciaNumero = 12;
			         break;
			     case "Misiones":
			         provinciaNumero = 13;
			         break;
			     case "Neuquén":
			         provinciaNumero = 14;
			         break;
			     case "Río Negro":
			         provinciaNumero = 15;
			         break;
			     case "Salta":
			         provinciaNumero = 16;
			         break;
			     case "San Juan":
			         provinciaNumero = 17;
			         break;
			     case "San Luis":
			         provinciaNumero = 18;
			         break;
			     case "Santa Cruz":
			         provinciaNumero = 19;
			         break;
			     case "Santa Fe":
			         provinciaNumero = 20;
			         break;
			     case "Santiago del Estero":
			         provinciaNumero = 21;
			         break;
			     case "Tierra del Fuego":
			         provinciaNumero = 22;
			         break;
			     case "Tucumán":
			         provinciaNumero = 23;
			         break;
			     case "Ciudad Autónoma de Buenos Aires":
			         provinciaNumero = 24;
			         break;
			     case "CABA":
			         provinciaNumero = 24;
			         break;
			 }
		 
			 cliente.getDireccion().setIDProvincia(provinciaNumero);
			 cliente.getDireccion().getIDProvincia();
			 
			 cliente.getDireccion().getLocalidad();
			 
			 ResultSet queryLocalidad = cn.query("SELECT IDLocalidad FROM LOCALIDADES WHERE Nombre='" + cliente.getDireccion().getLocalidad() + "'" + "AND IDProvincia = " + provinciaNumero);
	
			 if(queryLocalidad.next()) {
				 idLocalidad = queryLocalidad.getInt("IDLocalidad");
			 }
	
			 
			 ResultSet queryNuevaLocalidad = cn.query("SELECT IDLocalidad FROM LOCALIDADES ORDER BY IDLocalidad DESC LIMIT 1");
			 int idNuevaLocalidad = 0;
			 
			 
			 if(queryNuevaLocalidad.next()) {
				 idNuevaLocalidad = queryNuevaLocalidad.getInt("IDLocalidad");
				 idNuevaLocalidad++;
			 }

 if(idLocalidad != 0) {
				 cliente.getDireccion().setIDLocalidad(idLocalidad);
			 }else {
				 
				 cliente.getDireccion().setIDLocalidad(idNuevaLocalidad);
				 String queryLocalidadNueva = "INSERT INTO LOCALIDADES(IDLocalidad, Nombre, IDProvincia) VALUES (" + idNuevaLocalidad + ", '" + cliente.getDireccion().getLocalidad() + "', " + cliente.getDireccion().getIDProvincia() + ")";
				 cn.execute(queryLocalidadNueva);
			 }
	        String queryDireccion = "INSERT INTO DIRECCIONES (IDLocalidad, CodigoPostal, Calle, Numero) VALUES (" + cliente.getDireccion().getIDLocalidad() + ", '" + cliente.getDireccion().getCodigoPostal() + "', '" + cliente.getDireccion().getCalle() + "', " + cliente.getDireccion().getNumero() + ")";
	        direccionInsertada = cn.execute(queryDireccion);

	        String queryCliente = "INSERT INTO CLIENTES (DNI, CUIL, Nombre, Apellido, Sexo, Nacionalidad, FechaNacimiento, IDDireccion, Email, IDUsuario) VALUES ('" + cliente.getDNI() + "', '" + cliente.getCUIL() + "', '" + cliente.getNombre() + "', '" + cliente.getApellido() + "', '" + cliente.getSexo() + "', '" + cliente.getNacionalidad() + "', '" + cliente.getFechaNacimiento() + "', (SELECT MAX(IDDireccion) FROM DIRECCIONES), '" + cliente.getEmail() + "', (SELECT MAX(IDUsuario) FROM USUARIOS))";
	        clienteInsertado = cn.execute(queryCliente);

                 cliente.getNumeroTelefonico();
	        String queryTelefono = "INSERT INTO TELEFONOS(DNICliente, NumeroTelefonico) VALUES('" + cliente.getDNI() + "', '" + cliente.getNumeroTelefonico() + "')";
	        telefonoInsertado = cn.execute(queryTelefono);
	        
	        cuentaDao = new CuentaDaoImpl();
	        
	        cuentaDao.agregarCuentaCliente(cliente.getDNI(),2);
	        cuentaDao.agregarCuentaCliente(cliente.getDNI(),1);

	        

	    } catch (Exception e) {    
	        System.out.println(e.getMessage());    
	    } finally {
	        cn.close();
	    }

	    return usuarioInsertado && telefonoInsertado && direccionInsertada && clienteInsertado && cuentaInsertada && movimientoInsertado;
	}


	@Override
	public boolean editarCliente(Cliente cliente) {
		boolean clienteEditado = false;
		boolean usuarioEditado = false;
		boolean localidadEditada = false;
		boolean provinciaEditada = false;
		boolean telefonoEditado = false;
		boolean direccionEditada = false;
		int nuevoIDDireccion = 0;

		cn = new Conexion();
		cn.Open();	
		
		cliente.getDireccion().getLocalidad();
		
		
		String provincia = cliente.getDireccion().getProvincia();
		 int provinciaNumero = 1;
		 switch(provincia) {
		     case "Buenos Aires":
		         provinciaNumero = 1;
		         break;
		     case "Catamarca":
		         provinciaNumero = 2;
		         break;
		     case "Chaco":
		         provinciaNumero = 3;
		         break;
		     case "Chubut":
		         provinciaNumero = 4;
		         break;
		     case "Córdoba":
		         provinciaNumero = 5;
		         break;
		     case "Corrientes":
		         provinciaNumero = 6;
		         break;
		     case "Entre Ríos":
		         provinciaNumero = 7;
		         break;
		     case "Formosa":
		         provinciaNumero = 8;
		         break;
		     case "Jujuy":
		         provinciaNumero = 9;
		         break;
		     case "La Pampa":
		         provinciaNumero = 10;
		         break;
		     case "La Rioja":
		         provinciaNumero = 11;
		         break;
		     case "Mendoza":
		         provinciaNumero = 12;
		         break;
		     case "Misiones":
		         provinciaNumero = 13;
		         break;
		     case "Neuquén":
		         provinciaNumero = 14;
		         break;
		     case "Río Negro":
		         provinciaNumero = 15;
		         break;
		     case "Salta":
		         provinciaNumero = 16;
		         break;
		     case "San Juan":
		         provinciaNumero = 17;
		         break;
		     case "San Luis":
		         provinciaNumero = 18;
		         break;
		     case "Santa Cruz":
		         provinciaNumero = 19;
		         break;
		     case "Santa Fe":
		         provinciaNumero = 20;
		         break;
		     case "Santiago del Estero":
		         provinciaNumero = 21;
		         break;
		     case "Tierra del Fuego":
		         provinciaNumero = 22;
		         break;
		     case "Tucumán":
		         provinciaNumero = 23;
		         break;
		     case "Ciudad Autónoma de Buenos Aires":
		         provinciaNumero = 24;
		         break;
		     case "CABA":
		         provinciaNumero = 24;
		         break;
		 }
		
		 ResultSet queryLocalidad1 = cn.query("SELECT IDLocalidad FROM LOCALIDADES WHERE Nombre='" + cliente.getDireccion().getLocalidad() + "'" + "AND IDProvincia = " + provinciaNumero);
		 int idLocalidad = 0;
		 
		 try {
			if(queryLocalidad1.next()) {
				 idLocalidad = queryLocalidad1.getInt("IDLocalidad");
			 }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}


		 
		 ResultSet queryNuevaLocalidad = cn.query("SELECT IDLocalidad FROM LOCALIDADES ORDER BY IDLocalidad DESC LIMIT 1");
		 int idNuevaLocalidad = 0;
		 
		 
		 try {
			if(queryNuevaLocalidad.next()) {
				 idNuevaLocalidad = queryNuevaLocalidad.getInt("IDLocalidad");
				 idNuevaLocalidad++;
			 }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		 
		 if(idLocalidad != 0) {
			 cliente.getDireccion().setIDLocalidad(idLocalidad);
		 }else {
			 
			 cliente.getDireccion().setIDLocalidad(idNuevaLocalidad);
			 cliente.getDireccion().getIDLocalidad();
			 cliente.getDireccion().setIDProvincia(provinciaNumero);
			 cliente.getDireccion().getIDProvincia();
			 cliente.getDireccion().getLocalidad();
			 if(cliente.getDireccion().getLocalidad() != "") {
				 String queryLocalidadNueva = "INSERT INTO LOCALIDADES(IDLocalidad, Nombre, IDProvincia) VALUES (" + cliente.getDireccion().getIDLocalidad() + ", '" + cliente.getDireccion().getLocalidad() + "', " + cliente.getDireccion().getIDProvincia() + ")";
				 cn.execute(queryLocalidadNueva);
				 idLocalidad = idNuevaLocalidad;
			 }
			
		 }
		 
		 ResultSet verificacionNuevaDireccion = cn.query("SELECT Calle, Numero, CodigoPostal, IDLocalidad FROM DIRECCIONES AS d INNER JOIN CLIENTES AS c ON c.IDDireccion = d.IDDireccion");
		 
		 		 
		 try {
				if(verificacionNuevaDireccion.next()) {
					String calle = verificacionNuevaDireccion.getString("Calle");
					int numero = verificacionNuevaDireccion.getInt("Numero");
					String codigoPostal = verificacionNuevaDireccion.getString("CodigoPostal");
					int idLoca = verificacionNuevaDireccion.getInt("IDLocalidad");
					
						if(cliente.getDireccion().getCalle() != calle || cliente.getDireccion().getNumero() != numero || cliente.getDireccion().getCodigoPostal() != codigoPostal || cliente.getDireccion().getIDLocalidad() != idLoca) {
							String queryDireccion = "INSERT INTO DIRECCIONES (IDLocalidad, CodigoPostal, Calle, Numero) VALUES (" + idLocalidad + ", '" + cliente.getDireccion().getCodigoPostal() + "', '" + cliente.getDireccion().getCalle() + "', " + cliente.getDireccion().getNumero() + ")";
							direccionEditada = cn.execute(queryDireccion);}
							ResultSet nuevoIDDire = cn.query("SELECT IDDireccion FROM DIRECCIONES ORDER BY IDDireccion DESC LIMIT 1");
							if(nuevoIDDire.next()) {
								int idNuevaDireccion = nuevoIDDire.getInt("IDDireccion");
								String actualizacionDireccion = "UPDATE CLIENTES SET IDDireccion = " + idNuevaDireccion + " WHERE DNI = " + cliente.getDNI();
								cn.execute(actualizacionDireccion);
							}
					}
				
					
	 
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		 
		
		 
		String queryUsuario = "UPDATE USUARIOS SET Contraseña ='" + cliente.getPassword() + "' WHERE Usuario = '" + cliente.getUser() + "'";
		String queryCliente = "UPDATE CLIENTES SET Nombre='" + cliente.getNombre() + "',Apellido='"+cliente.getApellido()+ "',CUIL='" + cliente.getCUIL()+  "', Nacionalidad='" + cliente.getNacionalidad() +  "', Sexo='" + cliente.getSexo() + "', FechaNacimiento='" + cliente.getFechaNacimiento() +   "', Email='" + cliente.getEmail() + "' WHERE DNI='" + cliente.getDNI() + "'";
		String queryTelefono = "UPDATE TELEFONOS SET NumeroTelefonico = '" + cliente.getNumeroTelefonico() + "' WHERE DNICliente = " + cliente.getDNI();

		//String query = "UPDATE CLIENTES SET CUIL='" + cliente.getCUIL() + "', Nombre='" + cliente.getNombre() + "', Apellido='" + cliente.getApellido() + "', Sexo='" + cliente.getSexo() + "', Nacionalidad='" + cliente.getNacionalidad() + "', FechaNacimiento='" + cliente.getFechaNacimiento() + "', IDDireccion='" + cliente.getDireccion().getID() + "', Email='" + cliente.getEmail() + "', IDUsuario='" + cliente.getIDUsuario() + "' WHERE DNI='" + cliente.getDNI() + "'";
		String query = "UPDATE CLIENTES SET Nombre='" + cliente.getNombre() + "',Apellido='"+cliente.getApellido()+ "',CUIL='" + cliente.getCUIL()+  "', Nacionalidad='" + cliente.getNacionalidad() +  "', Sexo='" + cliente.getSexo() + "', FechaNacimiento='" + cliente.getFechaNacimiento() +   "', Email='" + cliente.getEmail() +                   "' WHERE DNI='" + cliente.getDNI() + "'";

		
		try
		 {
			
			usuarioEditado = cn.execute(queryUsuario);
			clienteEditado=cn.execute(queryCliente);
			telefonoEditado = cn.execute(queryTelefono);


		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		
		if(usuarioEditado == true && clienteEditado == true && telefonoEditado == true) {
			return true;
		}else {return false;}
		
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
				System.out.print(regDireccion.getProvincia());
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
boolean clienteActivado = false;
		
		cn = new Conexion();
		cn.Open();		 
		String query = "UPDATE CLIENTES SET ESTADO = 1 WHERE DNI="+DNI;
		try
		 {
			clienteActivado=cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return clienteActivado;
	}
	
	
	//Emmma obtener Cliente con el usuario
	@Override

	public Cliente obtenerUnClientePorIDUsuario(int idUsuario) {
	    Conexion cn = new Conexion();
	    Cliente cliente = null;
	    ResultSet rs = null;

	    try {
	        cn.Open();  // Abre la conexión
	        String query = "SELECT c.ESTADO, l.Nombre AS NombreLocalidad, p.Nombre AS NombreProvincia, " +
	                       "u.Usuario, u.Contraseña, t.NumeroTelefonico, c.Nombre, c.Apellido, " +
	                       "c.DNI, c.CUIL, c.Sexo, c.Nacionalidad, c.FechaNacimiento, c.Email, " +
	                       "d.Calle, d.Numero, d.CodigoPostal " +
	                       "FROM CLIENTES AS c " +
	                       "INNER JOIN DIRECCIONES AS d ON d.IDDireccion = c.IDDireccion " +
	                       "INNER JOIN USUARIOS AS u ON u.IDUsuario = c.IDUsuario " +
	                       "INNER JOIN TELEFONOS AS t ON t.DNICliente = c.DNI " +
	                       "INNER JOIN LOCALIDADES AS l ON l.IDLocalidad = d.IDLocalidad " +
	                       "INNER JOIN PROVINCIAS AS p ON p.IDProvincia = l.IDProvincia " +
	                       "WHERE c.IDUsuario = " + idUsuario;
	        
	        rs = cn.query(query);

	        if (rs.next()) {
	            cliente = new Cliente();
	            cliente.setDNI(rs.getInt("DNI"));
	            cliente.setEstado(rs.getBoolean("ESTADO"));
	            cliente.setCUIL(rs.getString("CUIL"));
	            cliente.setNombre(rs.getString("Nombre"));
	            cliente.setApellido(rs.getString("Apellido"));
	            cliente.setSexo(rs.getString("Sexo"));
	            cliente.setNacionalidad(rs.getString("Nacionalidad"));
	            cliente.setFechaNacimiento(rs.getDate("FechaNacimiento"));
	            cliente.setNumeroTelefonico(rs.getString("NumeroTelefonico"));
	            
	            String calle = rs.getString("Calle");
	            int numero = rs.getInt("Numero");
	            String codigoPostal = rs.getString("CodigoPostal");
	            String localidad = rs.getString("NombreLocalidad");
	            String provincia = rs.getString("NombreProvincia");
	            cliente.setDireccion(calle, numero, codigoPostal, localidad, provincia);
	            
	            cliente.setEmail(rs.getString("Email"));
	            cliente.setIDUsuario(rs.getInt("IDUsuario"));
	            cliente.setUserType(2);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            cn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return cliente;
	}



	@Override
	public ArrayList<Integer> obtenerCantidadClientesPorProvincia() {
	    ArrayList<Integer> cantidadClientes = new ArrayList<>();
	    cn = new Conexion();
	    ResultSet rs = null;
	    try {
	        cn.Open();
	        
	        String queryClientePorProvincia = "SELECT COUNT(c.DNI) AS cantidad FROM PROVINCIAS p JOIN LOCALIDADES l ON p.IDProvincia = l.IDProvincia JOIN DIRECCIONES d ON l.IDLocalidad = d.IDLocalidad JOIN CLIENTES c ON d.IDDireccion = c.IDDireccion GROUP BY p.Nombre";
	        rs = cn.query(queryClientePorProvincia);
	        
	        while (rs.next()) {
	            int cantidad = rs.getInt("cantidad");
	            cantidadClientes.add(cantidad);
	        }
	        rs.close();
	        cn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return cantidadClientes;
	}




	
	

	
	
}
