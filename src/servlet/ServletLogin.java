package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		if(request.getParameter("btnIniciarSesion")!=null)
		{
			request.getSession().removeAttribute("email");
			//En htttpSession obtengo todas las variables session creadas
			HttpSession session = request.getSession();
			
			String valor="";
			if(request.getParameter("email")!=null)
			{
				valor=request.getParameter("email");
			}
			
			//Mediate el setAttribute creo la variable session
			session.setAttribute("sessionLogin", valor);
			//Redirijo a otro jsp
			
			
			RequestDispatcher miDispacher = request.getRequestDispatcher("/Login.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
		    miDispacher.forward(request, response);
		}
		doGet(request, response);
	}

}
