package controlador;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
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
import excepciones.SaldoInsuficienteException;


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

			transferencia.setDetalle("Operaci�n entre clientes");
			Cuenta cuentaEmisor = cdimp.obtenerUnaCuenta(Integer.parseInt(request.getParameter("cuentaOrigen")));
			int idCuentaEmisor = cuentaEmisor.getNumeroCuenta();
			transferencia.setIdCuentaEmisor(idCuentaEmisor);

			int idCuentaReceptor = Integer.parseInt(request.getParameter("cuentaReceptora"));
			transferencia.setIdCuentaReceptor(idCuentaReceptor);

			transferencia.setIdMovimiento(1);

			try {
				retirar(cuentaEmisor, importe.doubleValue());
				mdimp.realizarTransferencia(transferencia);
				session.setAttribute("mensaje", "Transferencia realizada con �xito.");
			} catch (SaldoInsuficienteException e) {
				session.setAttribute("mensaje", e.getMessage());
			}

			request.getRequestDispatcher("HomebankingTransferencias.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("HomebankingTransferencias.jsp").forward(request, response);
		}
 
	}

	public void retirar(Cuenta cuenta, double monto) throws SaldoInsuficienteException {
		if (cuenta.getSaldo() < monto) {
			throw new SaldoInsuficienteException("No hay suficiente saldo para retirar " + monto);
		}
		cuenta.setSaldo(cuenta.getSaldo() - monto);
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        int dniCliente = cliente.getDNI();
        
        System.out.print(cliente.getApellido());
        
		Movimiento transferencia = new Movimiento();
	    MovimientoDaoImpl mdimp = new MovimientoDaoImpl();
		
	    ArrayList<Movimiento>listaTransferencias = mdimp.listarTransferenciasDeUnCliente(dniCliente);
	    request.setAttribute("listaTransferenciasCliente", listaTransferencias);	
        request.getRequestDispatcher("Homebanking.jsp").forward(request, response);
        
		doGet(request, response);
	}
	
	


}
