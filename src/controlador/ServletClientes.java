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
                    
                case "insertar":
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
                    Cliente clienteInsertar = new Cliente();
                    clienteInsertar.setNombre(nombre);
                    clienteInsertar.setApellido(apellido);
                    clienteInsertar.setCUIL(cuil);
                 
                   
                    
                	
                	clienteNegocio.insertarCliente(clienteInsertar);
                	response.sendRedirect("AltaCliente.jsp");

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

        if ("actualizar".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String user = request.getParameter("user");
            String password = request.getParameter("password");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String dni = request.getParameter("dni");
            String cuil = request.getParameter("cuil");
            String nacionalidad = request.getParameter("nacionalidad");
            String sexo = request.getParameter("sexo");
            Date fechaNacimiento = Date.valueOf(request.getParameter("fechaNacimiento"));
            String email = request.getParameter("email");
            String numeroTelefonico = request.getParameter("numeroTelefonico");
            String calle = request.getParameter("calle");
            int numero = Integer.parseInt(request.getParameter("numero"));
            String localidad = request.getParameter("localidad");
            String provincia = request.getParameter("provincia");

            Cliente clienteActualizar = new Cliente();
            clienteActualizar.setIDUsuario(id);
            clienteActualizar.setUser(user);
            clienteActualizar.setPassword(password);
            clienteActualizar.setNombre(nombre);
            clienteActualizar.setApellido(apellido);
            clienteActualizar.setDNI(Integer.parseInt(dni));
            clienteActualizar.setCUIL(cuil);
            clienteActualizar.setNacionalidad(nacionalidad);
            clienteActualizar.setSexo(sexo);
            clienteActualizar.setFechaNacimiento(fechaNacimiento);
            clienteActualizar.setEmail(email);
            clienteActualizar.setNumeroTelefonico(numeroTelefonico);
            clienteActualizar.setDireccion(calle, numero, "", localidad, provincia);

            boolean exito = clienteNegocio.editarCliente(clienteActualizar);

            if (exito) {
                response.sendRedirect("ServletClientes?action=listar");
            } else {
                request.setAttribute("error", "No se pudo actualizar el cliente");
                request.getRequestDispatcher("editarCliente.jsp").forward(request, response);
            }
            
        } else if ("baja".equals(action)) {
            String idBaja = request.getParameter("dni");
            boolean exito = clienteNegocio.bajaLogicaCliente(idBaja);

            if (exito) {
                response.sendRedirect("ServletClientes?action=listar");
            } else {
                request.setAttribute("error", "No se pudo dar de baja el cliente");
                request.getRequestDispatcher("bajaCliente.jsp").forward(request, response);
            }
        } else {
            doGet(request, response);
        }
    }
}
