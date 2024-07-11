package controlador;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import datosImpl.UsuarioDaoImpl;
import negocio.ClienteNegocio;
import negocioImpl.ClienteNegImpl;
import sun.launcher.resources.launcher;
import entidad.Cliente;
import entidad.Usuario;
import excepciones.ClienteRepetido;
import excepciones.ContraseñaDiferente;
import excepciones.UsuarioRepetido;

@WebServlet("/ServletClientes")
public class ServletClientes extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServletClientes() {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        ClienteNegocio clienteNegocio = new ClienteNegImpl();
        ArrayList<Cliente> listaClientes; 
        if (action != null) {
            switch (action) {
            
            	case "cashflow":
            		ArrayList<Cliente> listaClientesCashflow = clienteNegocio.listarClientes();
            		request.setAttribute("listaClientes", listaClientesCashflow);
            		request.getRequestDispatcher("Cashflow.jsp").forward(request, response); 
                break;

                case "listar":
                	listaClientes = clienteNegocio.listarClientes();
                    request.setAttribute("listaClientes", listaClientes);
                    request.getRequestDispatcher("ListaClientes.jsp").forward(request, response); 
                    break;
                case "buscarPorDni":
                    listaClientes = clienteNegocio.listarClientes();
                    ArrayList<Cliente> listaFiltrada = new ArrayList<>();
                    
                    String dniParam = request.getParameter("dni");
                    
                    if (dniParam == null || dniParam.isEmpty()) {
                        
                        request.setAttribute("listaClientes", listaClientes);
                    } else {
                        
                        int dni = Integer.parseInt(dniParam);
                        for (Cliente cliente : listaClientes) {
                            if (cliente.getDNI() == dni) {
                                listaFiltrada.add(cliente);
                                break; 
                            }
                        }
                        request.setAttribute("listaClientes", listaFiltrada);
                    }
                    
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
            String user = request.getParameter("usuario");
            String password = request.getParameter("password");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String dni = request.getParameter("dni");
            String cuil = request.getParameter("cuil");
            String nacionalidad = request.getParameter("nacionalidad");
            String sexo = request.getParameter("sexo");
            String usuario = request.getParameter("usuario");
            String contraseña = request.getParameter("contraseña");
            String telefono = request.getParameter("telefono");
            
            
            String fechaNacStr = request.getParameter("fechaNacimiento");                  
           
            
            //Date fechaNacimiento = Date.valueOf(request.getParameter("fechaNacimiento"));
            String email = request.getParameter("email");
            String numeroTelefonico = request.getParameter("numeroTelefonico");
            String calle = request.getParameter("calle");
            int numero = Integer.parseInt(request.getParameter("numero"));
            String localidad = request.getParameter("localidad");
            String provincia = request.getParameter("provincia");
            String codigoPostal = request.getParameter("codigoPostal");

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
            clienteActualizar.getDireccion().setLocalidad(localidad);
            clienteActualizar.getDireccion().setProvincia(provincia);
            clienteActualizar.getDireccion().setCodigoPostal(codigoPostal);
            clienteActualizar.setNumeroTelefonico(telefono);
            
            try {
                LocalDate localDate = LocalDate.parse(fechaNacStr);                           
               clienteActualizar.setFechaNacimiento(java.sql.Date.valueOf(localDate));
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            
            
            //clienteActualizar.setFechaNacimiento(fechaNacimiento);
            clienteActualizar.setEmail(email);
            clienteActualizar.setNumeroTelefonico(numeroTelefonico);
            clienteActualizar.setDireccion(calle, numero, codigoPostal, localidad, provincia);

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
        } else if("alta".equals(action)) {
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
            String telefono = request.getParameter("teléfono");
            String contraseñaRepetida = request.getParameter("contraseña2");
            
            //aca guardo los datos del cliente para poder recuperarlos en casode que se lance la excepcion de cliente repetido
            Cliente clienteForm = new Cliente();
            clienteForm.setNombre(nombre);
            clienteForm.setApellido(apellido);
            clienteForm.setCUIL(cuil);
            clienteForm.setTelefono(Integer.parseInt(telefono));
            clienteForm.setDNI(Integer.parseInt(dni2));
            clienteForm.setEmail(correo);
            clienteForm.setSexo(sexo);
            clienteForm.setNacionalidad(nacionalidad);
            clienteForm.getDireccion().setProvincia(provincia);
            clienteForm.getDireccion().setLocalidad(localidad);
            clienteForm.getDireccion().setCalle(calle);
            clienteForm.getDireccion().setCodigoPostal(codigoPostal);
            clienteForm.getDireccion().setNumero(Integer.parseInt(numero));
            clienteForm.setUser(usuario);
            clienteForm.setPassword(contraseña);
            clienteForm.setNumeroTelefonico(telefono);

            try {
                LocalDate localDate = LocalDate.parse(fechaNacimiento);
                clienteForm.setFechaNacimiento(java.sql.Date.valueOf(localDate));
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            
            
            
            //Validacion de contraseñas repetidas
            if(!contraseña.equals(contraseñaRepetida)) {
                try {
                    throw new ContraseñaDiferente();
                } catch (ContraseñaDiferente e) {
                	
                    request.setAttribute("contraseñaError", e.getMessage());
                    request.getRequestDispatcher("AltaCliente.jsp").forward(request, response);
                    return;
                }
            }
            
            
            ClienteNegocio clienteNeg = new ClienteNegImpl();
            Cliente nuevo = clienteNeg.obtenerUnCliente(dni2);
            
            UsuarioDaoImpl ud = new UsuarioDaoImpl();
            
            String dnistr = String.valueOf(nuevo.getDNI());
            
            
            //Validacion de dni usando excepcion
            try {
				if(dni2.equals(dnistr)) {
					throw new ClienteRepetido("El DNI ingresado ya existe");
				}
			} catch (ClienteRepetido e) {
				
				request.setAttribute("cliente", clienteForm);
				request.setAttribute("dnirepetido", "El DNI "+ dni2 + " ya esta registrado");
                request.getRequestDispatcher("AltaCliente.jsp").forward(request, response);   
			}
            
            
            //validacion de usuario usando  excepcion
            try {
            	if(ud.obtenerUsuarioPorNombre(usuario) != null) {
            		throw new UsuarioRepetido("El usuario ya existe");
            	}
				
			} catch (UsuarioRepetido e) {
				request.setAttribute("cliente", clienteForm);
				request.setAttribute("usuariorepetido", "El Usuario "+ usuario + " ya esta registrado");
                request.getRequestDispatcher("AltaCliente.jsp").forward(request, response); 
			}
            

            
            
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
            clienteInsertar.getDireccion().setProvincia(provincia);
            clienteInsertar.getDireccion().setLocalidad(localidad);
            clienteInsertar.getDireccion().setCalle(calle);
            clienteInsertar.getDireccion().setCodigoPostal(codigoPostal);
            clienteInsertar.getDireccion().setNumero(numeroInt);
            
            try {
                LocalDate localDate = LocalDate.parse(fechaNacimiento);                           
            clienteInsertar.setFechaNacimiento(java.sql.Date.valueOf(localDate));
            } catch (Exception e) {
                e.printStackTrace();
            }
            clienteInsertar.setSexo(sexo);
            //clienteInsertar.setDireccion(calle, numeroInt, codigoPostal, localidad, provincia);
            clienteInsertar.setUser(usuario);
            clienteInsertar.setPassword(contraseña);
            clienteInsertar.setNumeroTelefonico(telefono);

            
            clienteNegocio.insertarCliente(clienteInsertar);           	
            request.setAttribute("mensaje", "Cliente agregada exitosamente.");

           
            request.getRequestDispatcher("AltaCliente.jsp").forward(request, response); 	
	
        	
        }
        else {
            doGet(request, response);
        }
    }
}
