package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datosImpl.ClienteDaoImpl;
import datosImpl.UsuarioDaoImpl;
import entidad.Cliente;
import entidad.Usuario;
import excepciones.UsuarioNoEncontradoException;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletLogin() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false); // Obtener la sesión si existe
        if (session != null) {
            session.invalidate(); // Invalidar la sesión
        }
        response.sendRedirect("Login.jsp");
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
	        Usuario usuario = null;
	        ClienteDaoImpl Dao = new ClienteDaoImpl();
	        if (request.getParameter("btnIniciarSesion") != null) {
	            String email = request.getParameter("email");
	            String contrasenia = request.getParameter("contrasenia");

	            if (email != null && !email.isEmpty() && contrasenia != null && !contrasenia.isEmpty()) {
	                try {
						usuario = usuarioDao.obtenerUsuarioLogin(email, contrasenia);
					} catch (UsuarioNoEncontradoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						request.setAttribute("errorMensaje", e.getMessage());
			            request.getRequestDispatcher("Login.jsp").forward(request, response);
					}
	            }

	            HttpSession session = request.getSession();
	            if (usuario != null) {
	            	Cliente cliente = Dao.obtenerUnClientePorIDUsuario(usuario.getID());
	            	session.setAttribute("cliente", cliente);
	                session.setAttribute("sessionLogin", usuario);
	                String redirectPage = determineRedirectPage(usuario.getUserType());
	                RequestDispatcher dispatcher = request.getRequestDispatcher(redirectPage);
	                dispatcher.forward(request, response);
	            } else {
	                request.setAttribute("error", "Invalid email or password");
	                RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
	                dispatcher.forward(request, response);
	            }
	        } else {
	            doGet(request, response);
	        }
	    }
	    
	    private String determineRedirectPage(int userType) {
	        if (userType == 1) {
	            return "MenuAdministrador.jsp";
	        } else if (userType == 2) {
	            return "Homebanking.jsp"; 
	        } else {
	            return "error.jsp"; 
	        }
	    }

}
