package datosImpl;
import entidad.Cliente;
import entidad.Direccion;
import datos.ClienteDao;
import java.util.ArrayList;
import java.sql.ResultSet;

public class ClienteDaoImpl implements ClienteDao{

	private Conexion cn;
	
	public ArrayList<Cliente> obtenerClientes(){
		
		cn = new Conexion();
		cn.Open();
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		
		try {
			ResultSet rs= cn.query("SELECT c.Nombre, c.Apellido, c.DNI, c.CUIL, c.Sexo, c.Nacionalidad, c.FechaNacimiento, d.Calle AS Calle, d.Numero AS Numero, d.CodigoPostal AS CodigoPostal FROM CLIENTES AS c INNER JOIN DIRECCIONES AS d ON d.IDDireccion = c.IDDireccion");
			while(rs.next()) {
				Cliente regCliente = new Cliente();
				regCliente.setNombre(rs.getString("c.Nombre"));
				regCliente.setApellido(rs.getString("c.Apellido"));
				regCliente.setDNI(rs.getInt("c.DNI"));
				regCliente.setCUIL(rs.getString("c.CUIL"));
				regCliente.setSexo(rs.getString("c.Sexo"));
				regCliente.setNacionalidad(rs.getString("c.Nacionalidad"));
				regCliente.setFechaNacimiento(rs.getDate("c.FechaNacimiento"));
				String calle = rs.getString("d.Calle");
                int numero = rs.getInt("d.Numero");
                String codigoPostal = rs.getString("d.CodigoPostal");
                regCliente.setDireccion(calle, numero, codigoPostal);
				lista.add(regCliente);
			}
		}catch (Exception e){	
				System.out.println(e.getMessage());	
		}finally {
			cn.close();
		}
		return lista;
	}
	
	
}
