package controlador;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datosImpl.CuentaDaoImpl;
import datosImpl.MovimientoDaoImpl;
import datosImpl.TipoPrestamoDaoImpl;
import entidad.Cliente;
import entidad.Cuenta;
import entidad.Movimiento;
import entidad.TipoPrestamos;


@WebServlet("/ServletTransferencias")
public class ServletTransferencias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletTransferencias() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("cliente");
		
		CuentaDaoImpl cdimp = new CuentaDaoImpl();
        int dniCliente = cliente.getDNI();

        Movimiento transferencia = new Movimiento();
        MovimientoDaoImpl mdimp = new MovimientoDaoImpl();
        
        List<Cuenta> lista = cdimp.obtenerCuentasCliente(dniCliente);
        request.setAttribute("listaCuentasCliente", lista);		
        List<Cuenta> listaReceptora = cdimp.listarCuentasTransferencia();
        request.setAttribute("listaCuentasTotales", listaReceptora);
        
        
        
        
        String action = request.getParameter("action");

        if ("transferencia".equals(action)) {
            String montoStr = request.getParameter("monto");
            BigDecimal importe = new BigDecimal(montoStr);
            transferencia.setImporte(importe);
            System.out.println(importe);
            
            transferencia.setDetalle("Operación entre clientes");
            
            int idCuentaEmisor = Integer.parseInt(request.getParameter("cuentaOrigen"));
            transferencia.setIdCuentaEmisor(idCuentaEmisor);
            
            int idCuentaReceptor = Integer.parseInt(request.getParameter("cuentaReceptora"));
            transferencia.setIdCuentaReceptor(idCuentaReceptor);
            
            transferencia.setIdMovimiento(1);
            
            mdimp.realizarTransferencia(transferencia);
            
            request.getRequestDispatcher("HomebankingTransferencias.jsp").forward(request, response);
        }
        request.getRequestDispatcher("HomebankingTransferencias.jsp").forward(request, response);
 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();


        
		doGet(request, response);
	}

}
