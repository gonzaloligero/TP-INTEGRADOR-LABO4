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
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
	        Usuario usuario = null;

	        if (request.getParameter("btnIniciarSesion") != null) {
	            String email = request.getParameter("email");
	            String contrasenia = request.getParameter("contrasenia");

	            if (email != null && !email.isEmpty() && contrasenia != null && !contrasenia.isEmpty()) {
	                usuario = usuarioDao.obtenerUsuarioLogin(email, contrasenia);
	            }

	            HttpSession session = request.getSession();
	            if (usuario != null) {
	                session.setAttribute("sessionLogin", usuario);
	                String redirectPage = determineRedirectPage(usuario.getUserType());
	                RequestDispatcher dispatcher = request.getRequestDispatcher(redirectPage);
	                dispatcher.forward(request, response);
	            } else {
	                request.setAttribute("error", "Invalid email or password");
	                RequestDispatcher dispatcher = request.getRequestDispatcher("erro.jsp");
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
	            return "ClienteHome.jsp"; 
	        } else {
	            return "erro.jsp"; 
	        }
	    }

}
