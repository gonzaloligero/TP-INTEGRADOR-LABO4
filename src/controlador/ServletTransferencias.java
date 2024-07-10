package controlador;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import negocio.MovimientoNegocio;
import negocioImpl.MovimientoNegImpl;


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

			transferencia.setDetalle("Operación entre clientes");
			Cuenta cuentaEmisor = cdimp.obtenerUnaCuenta(Integer.parseInt(request.getParameter("cuentaOrigen")));
			int idCuentaEmisor = cuentaEmisor.getNumeroCuenta();
			transferencia.setIdCuentaEmisor(idCuentaEmisor);

			int idCuentaReceptor = Integer.parseInt(request.getParameter("cuentaReceptora"));
			transferencia.setIdCuentaReceptor(idCuentaReceptor);

			transferencia.setIdMovimiento(1);

			try {
				retirar(cuentaEmisor, importe.doubleValue());
				mdimp.realizarTransferencia(transferencia);
				session.setAttribute("mensaje", "Transferencia realizada con éxito.");
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
        String action = request.getParameter("action");
        
        if(!action.equals("rastreador")) {
        	Cliente cliente = (Cliente) session.getAttribute("cliente");
            int dniCliente = cliente.getDNI();

    		Movimiento transferencia = new Movimiento();
    	    MovimientoDaoImpl mdimp = new MovimientoDaoImpl();
    		
    	    ArrayList<Movimiento>listaTransferencias = mdimp.listarTransferenciasDeUnCliente(dniCliente);
    	    request.setAttribute("listaTransferenciasCliente", listaTransferencias);	
            request.getRequestDispatcher("Homebanking.jsp").forward(request, response);
        }
        
        
        if(action.equals("rastreador")) {
       	 MovimientoNegocio movimientoNegocio = new MovimientoNegImpl();
       	String fechaInicioStr = request.getParameter("fechaInicio");
		String fechaFinStr = request.getParameter("fechaFin");
		String cantidadStr = request.getParameter("cantidad");
		float dinero = Float.parseFloat(cantidadStr);
		java.sql.Date sqlFecha1 = null;
	    java.sql.Date sqlFecha2 = null;
		int montosTotales = 0;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilFecha1;
		java.util.Date utilFecha2;
		try {
			utilFecha1 = dateFormat.parse(fechaInicioStr);
			utilFecha2 = dateFormat.parse(fechaFinStr);
	        sqlFecha1 = new java.sql.Date(utilFecha1.getTime());
	        sqlFecha2 = new java.sql.Date(utilFecha2.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
        montosTotales = movimientoNegocio.rastrearTransferencias(sqlFecha1, sqlFecha2, dinero);
        request.setAttribute("transferenciasTotales", montosTotales);
        request.getRequestDispatcher("/RastreadorTransferencias.jsp").forward(request, response);
        }
        
        
		doGet(request, response);
	}
	
	


}
