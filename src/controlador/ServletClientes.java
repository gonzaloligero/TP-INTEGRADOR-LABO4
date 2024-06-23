package controlador;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import negocio.ClienteNegocio;
import negocioImpl.ClienteNegImpl;
import entidad.Cliente;

@WebServlet("/ServletClientes")
public class ServletClientes extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServletClientes() {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        ClienteNegocio clienteNegocio = new ClienteNegImpl();

        if (action != null) {
            switch (action) {
                case "listar":
                    ArrayList<Cliente> listaClientes = clienteNegocio.listarClientes();
                    request.setAttribute("listaClientes", listaClientes);
                    request.getRequestDispatcher("ListaClientes.jsp").forward(request, response); 
                    break;

                case "editar":
                    Cliente clienteEditar = new Cliente();
                    clienteNegocio.editarCliente(clienteEditar);
                    ArrayList<Cliente> listaDeClientes = clienteNegocio.listarClientes();
                    request.setAttribute("listaClientes", listaDeClientes);
                    request.setAttribute("cliente", clienteEditar);
                    request.getRequestDispatcher("ModificarCliente.jsp").forward(request, response);
 
                    break;

                case "eliminar":
                	String DNI = request.getParameter("dni");
                    ArrayList<Cliente> listaClientesBaja = clienteNegocio.listarClientes();
                    request.setAttribute("listaClientes", listaClientesBaja);
                    request.getRequestDispatcher("BajaCliente.jsp").forward(request, response);
                    clienteNegocio.bajaLogicaCliente(DNI);
                    break;
                    
                case "alta":
                	String dniAlta = request.getParameter("dni");
                    ArrayList<Cliente> listaClientesAlta = clienteNegocio.listarClientes();
                    request.setAttribute("listaClientes", listaClientesAlta);
                    request.getRequestDispatcher("BajaCliente.jsp").forward(request, response);
                    clienteNegocio.altaLogicaCliente(dniAlta);
                	break;
                    
                case "insertarGet":
                    try {
                       
                        String nombre = request.getParameter("nombre");
                        String apellido = request.getParameter("apellido");
                        String cuil = request.getParameter("cuil");
                        String fechaNacimiento = request.getParameter("fechaNacimiento");
                        String localidad = request.getParameter("localidad");
                        String codigoPostal = request.getParameter("codigoPostal");
                        String correo = request.getParameter("correo");
                        String sexo = request.getParameter("sexo");
                        String calle = request.getParameter("calle");
                        String usuario = request.getParameter("usuario");
                        String dni2 = request.getParameter("dni");
                        String nacionalidad = request.getParameter("nacionalidad");
                        String provincia = request.getParameter("provincia");
                        String numero = request.getParameter("numero");
                        String contraseña = request.getParameter("contraseña");

                       
                        nombre = (nombre != null && !nombre.isEmpty()) ? nombre : "";
                        apellido = (apellido != null && !apellido.isEmpty()) ? apellido : "";
                        cuil = (cuil != null && !cuil.isEmpty()) ? cuil : "";
                        fechaNacimiento = (fechaNacimiento != null && !fechaNacimiento.isEmpty()) ? fechaNacimiento : "1970-01-01";
                        localidad = (localidad != null && !localidad.isEmpty()) ? localidad : "";
                        codigoPostal = (codigoPostal != null && !codigoPostal.isEmpty()) ? codigoPostal : "";
                        correo = (correo != null && !correo.isEmpty()) ? correo : "";
                        sexo = (sexo != null && !sexo.isEmpty()) ? sexo : "M";
                        calle = (calle != null && !calle.isEmpty()) ? calle : "";
                        usuario = (usuario != null && !usuario.isEmpty()) ? usuario : "";
                        dni2 = (dni2 != null && !dni2.isEmpty()) ? dni2 : "0";
                        nacionalidad = (nacionalidad != null && !nacionalidad.isEmpty()) ? nacionalidad : "";
                        provincia = (provincia != null && !provincia.isEmpty()) ? provincia : "";
                        numero = (numero != null && !numero.isEmpty()) ? numero : "0";
                        contraseña = (contraseña != null && !contraseña.isEmpty()) ? contraseña : "";

                       
                        int dniInt = Integer.parseInt(dni2);
                        int numeroInt = Integer.parseInt(numero);

                        
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date parsedDate = (Date) sdf.parse(fechaNacimiento);
                        java.sql.Date fechaNacimientoSql = new java.sql.Date(parsedDate.getTime());

                        
                        Cliente clienteInsertar = new Cliente();
                        clienteInsertar.setNombre(nombre);
                        clienteInsertar.setApellido(apellido);
                        clienteInsertar.setCUIL(cuil);
                        clienteInsertar.setDNI(dniInt);
                        clienteInsertar.setEmail(correo);
                        clienteInsertar.setNacionalidad(nacionalidad);
                        clienteInsertar.setFechaNacimiento(fechaNacimientoSql);
                        clienteInsertar.setSexo(sexo);
                        clienteInsertar.setDireccion(calle, numeroInt, codigoPostal, localidad, provincia);
                        clienteInsertar.setUser(usuario);
                        clienteInsertar.setPassword(contraseña);

                       
                        clienteNegocio.insertarCliente(clienteInsertar);

                      
                        response.sendRedirect("AltaCliente.jsp");
                    } catch (NumberFormatException e) {
                        
                        e.printStackTrace();
                        response.sendRedirect("error.jsp");
                    } catch (ParseException e) {
                       
                        e.printStackTrace();
                        response.sendRedirect("error.jsp");
                    } catch (Exception e) {
                        
                        e.printStackTrace();
                        response.sendRedirect("error.jsp");
                    }
                    break;

                default:
                    
                    response.sendRedirect("index.jsp");
                    break;
            }
        } 
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        ClienteNegocio clienteNegocio = new ClienteNegImpl();

        if (action != null) {
            switch (action) {
                case "insertar":
                    try {
                        String nombre = request.getParameter("nombre");
                        String apellido = request.getParameter("apellido");
                        String cuil = request.getParameter("cuil");
                        String fechaNacimiento = request.getParameter("fechaNacimiento");

                        nombre = (nombre != null && !nombre.isEmpty()) ? nombre : "";
                        apellido = (apellido != null && !apellido.isEmpty()) ? apellido : "";
                        cuil = (cuil != null && !cuil.isEmpty()) ? cuil : "";
                        fechaNacimiento = (fechaNacimiento != null && !fechaNacimiento.isEmpty()) ? fechaNacimiento : "1970-01-01";

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date parsedDate = sdf.parse(fechaNacimiento);
                        java.sql.Date fechaNacimientoSql = new java.sql.Date(parsedDate.getTime());

                        String localidad = request.getParameter("localidad");
                        String codigoPostal = request.getParameter("codigoPostal");
                        String correo = request.getParameter("correo");
                        String sexo = request.getParameter("sexo");
                        String calle = request.getParameter("calle");
                        String usuario = request.getParameter("usuario");
                        String dni2 = request.getParameter("dni");
                        String nacionalidad = request.getParameter("nacionalidad");
                        String provincia = request.getParameter("provincia");
                        String numero = request.getParameter("numero");
                        String contraseña = request.getParameter("contraseña");
                        String telefono = request.getParameter("teléfono");

                        localidad = (localidad != null && !localidad.isEmpty()) ? localidad : "";
                        codigoPostal = (codigoPostal != null && !codigoPostal.isEmpty()) ? codigoPostal : "";
                        correo = (correo != null && !correo.isEmpty()) ? correo : "";
                        sexo = (sexo != null && !sexo.isEmpty()) ? sexo : "M";
                        calle = (calle != null && !calle.isEmpty()) ? calle : "";
                        usuario = (usuario != null && !usuario.isEmpty()) ? usuario : "";
                        dni2 = (dni2 != null && !dni2.isEmpty()) ? dni2 : "0";
                        nacionalidad = (nacionalidad != null && !nacionalidad.isEmpty()) ? nacionalidad : "";
                        provincia = (provincia != null && !provincia.isEmpty()) ? provincia : "";
                        numero = (numero != null && !numero.isEmpty()) ? numero : "0";
                        contraseña = (contraseña != null && !contraseña.isEmpty()) ? contraseña : "";

                        int dniInt = Integer.parseInt(dni2);
                        int numeroInt = Integer.parseInt(numero);

                        Cliente clienteInsertar = new Cliente();
                        clienteInsertar.setNombre(nombre);
                        clienteInsertar.setApellido(apellido);
                        clienteInsertar.setCUIL(cuil);
                        clienteInsertar.setNumeroTelefonico(telefono);
                        clienteInsertar.setDNI(dniInt);
                        clienteInsertar.setEmail(correo);
                        clienteInsertar.setNacionalidad(nacionalidad);
                        clienteInsertar.setFechaNacimiento(fechaNacimientoSql);
                        clienteInsertar.setSexo(sexo);
                        clienteInsertar.setDireccion(calle, numeroInt, codigoPostal, localidad, provincia);
                        clienteInsertar.setUser(usuario);
                        clienteInsertar.setPassword(contraseña);

                        
                        clienteNegocio.insertarCliente(clienteInsertar);

                       
                        response.sendRedirect("AltaCliente.jsp");
                    } catch (Exception e) {
                        e.printStackTrace();
                        response.sendRedirect("error.jsp");
                    }
                    return; 

                default:
                    response.sendRedirect("index.jsp");
                    return; 
            }
        } else {
            response.sendRedirect("index.jsp");
        }
    }


    

}
