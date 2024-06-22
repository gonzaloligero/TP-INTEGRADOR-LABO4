package controlador;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
                    int idEditar = Integer.parseInt(request.getParameter("id"));
                    Cliente clienteEditar = clienteNegocio.obtenerUnCliente(idEditar);
                    request.setAttribute("cliente", clienteEditar);
                    request.getRequestDispatcher("editarCliente.jsp").forward(request, response);
                    break;

                case "eliminar":
                    int idEliminar = Integer.parseInt(request.getParameter("id"));
                    clienteNegocio.bajaLogicaCliente(idEliminar);
                    response.sendRedirect("ServletClientes?action=listar");
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
                    String dni = request.getParameter("dni");
                    String nacionalidad = request.getParameter("nacionalidad");
                    String provincia = request.getParameter("provincia");
                    String numero = request.getParameter("numero");
                    String contraseña = request.getParameter("contraseña");
                    Cliente clienteInsertar = new Cliente();
                    clienteInsertar.setNombre(nombre);
                    clienteInsertar.setApellido(apellido);
                    clienteInsertar.setCUIL(cuil);
                 
                    //SEGUIR ACÁ (GONZA)
                    
                    
                	
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
        doGet(request, response);
    }
}
