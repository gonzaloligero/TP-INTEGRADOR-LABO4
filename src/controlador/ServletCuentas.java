package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import datos.ClienteDao;
import datos.CuentaDao;
import datosImpl.ClienteDaoImpl;
import datosImpl.CuentaDaoImpl;
import entidad.Cliente;
import entidad.Cuenta;
import negocio.ClienteNegocio;
import negocio.CuentaNegocio;
import negocioImpl.ClienteNegImpl;
import negocioImpl.CuentaNegocioImpl;


@WebServlet("/ServletCuentas")
public class ServletCuentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ServletCuentas() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		    CuentaNegocio cuentaNegocio = new CuentaNegocioImpl();
		    
		    // Obtener la sesi�n actual
		    HttpSession session = request.getSession();
		     String usuario = (String) session.getAttribute("usuario");
		    
		    // CONSEGUIR DNI DE UN USUARIO LOGUEADO
		    // String DNICliente = TraerDniCliente(usuario);
		    
		  /* if (DNICliente != null && !DNICliente.isEmpty()) {
		        ArrayList<Cuenta> listaCuentasCliente = cuentaNegocio.agregarCuentaCliente(DNICliente);
		        request.setAttribute("listaCuentas", listaCuentasCliente);
		        request.getRequestDispatcher("ListaCuentas.jsp").forward(request, response);
		    } else {
		        request.setAttribute("error", "No se pudo obtener el DNI del cliente de la sesi�n.");
		        request.getRequestDispatcher("error.jsp").forward(request, response);
		    }
		    */
		    doGet(request, response);
		}
}

	

