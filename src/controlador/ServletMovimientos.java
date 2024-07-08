package controlador;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidad.Movimiento;
import negocio.MovimientoNegocio;
import negocioImpl.MovimientoNegImpl;


@WebServlet("/ServletMovimientos")
public class ServletMovimientos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletMovimientos() {
        
        }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 MovimientoNegocio movimientoNegocio = new MovimientoNegImpl();
	        

	        ArrayList<Movimiento> listaMovimiento = movimientoNegocio.listarMovimientos();
	        

	       
			for (Movimiento movimiento : listaMovimiento ) {
	            System.out.println(movimiento.toString());
	        }

	        request.setAttribute("listaMovimientos", listaMovimiento);
	        

	        request.getRequestDispatcher("/ListaTransferencias.jsp").forward(request, response);
	    }

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		doGet(request, response);
	}

}
