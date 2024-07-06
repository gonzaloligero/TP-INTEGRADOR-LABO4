package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datosImpl.CuentaDaoImpl;
import datosImpl.TipoPrestamoDaoImpl;
import entidad.Cliente;
import entidad.Cuenta;
import entidad.TipoPrestamos;


@WebServlet("/ServletTransferencias")
public class ServletTransferencias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletTransferencias() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CuentaDaoImpl cdimp = new CuentaDaoImpl();
        int dniCliente = 12121212;
        //Cliente cliente = (Cliente) session.getAttribute("cliente");
        List<Cuenta> lista = cdimp.obtenerCuentasCliente(dniCliente);
        request.setAttribute("listaCuentasCliente", lista);
        request.getRequestDispatcher("HomebankingTransferencias.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
