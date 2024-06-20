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
import entidad.Cliente;

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
		
		ClienteDaoImpl x = new ClienteDaoImpl();
		Cliente cliente = new Cliente();
		
		if(request.getParameter("btnIniciarSesion")!=null)
		{
			
			request.getSession().removeAttribute("email");
			request.getSession().removeAttribute("contrasenia");
			//En htttpSession obtengo todas las variables session creadas
			HttpSession session = request.getSession();
			
			String datoEmail="";
			String datoContrasenia="";
			if(request.getParameter("email")!=null && request.getParameter("contrasenia")!=null)
			{
				
				datoEmail = request.getParameter("email");
				datoContrasenia = request.getParameter("contrasenia");
				cliente = x.obtenerUsuarioLogin(datoEmail,datoContrasenia);
										
			}
			
			//Mediate el setAttribute creo la variable session
			session.setAttribute("sessionLogin", cliente);
			//Redirijo a otro jsp
			
			System.out.println(request.getParameter("email"));
			System.out.println(request.getParameter("contrasenia"));
			RequestDispatcher miDispacher = request.getRequestDispatcher("/Home.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
		    miDispacher.forward(request, response);
		}
		doGet(request, response);
	}

}
