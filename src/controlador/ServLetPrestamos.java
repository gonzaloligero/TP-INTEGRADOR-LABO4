package controlador;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import datosImpl.CuentaDaoImpl;
import datosImpl.PlazosPrestamoImpleDao;

import datosImpl.PrestamoDaoImpl;
import datosImpl.TipoPrestamoDaoImpl;
import entidad.Cliente;
import entidad.Cuenta;
import entidad.Prestamos;
import excepciones.SaldoInsuficienteException;
import entidad.Plazos;
import negocio.MovimientoNegocio;
import negocio.PrestamosNegocio;
import negocioImpl.MovimientoNegImpl;
import negocioImpl.PrestamosNegImpl;

@WebServlet("/ServLetPrestamos")
public class ServLetPrestamos extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private PrestamosNegocio prestamoNeg = new PrestamosNegImpl();
	private PrestamoDaoImpl pc = new PrestamoDaoImpl();
	private PlazosPrestamoImpleDao ppi = new PlazosPrestamoImpleDao();
	private CuentaDaoImpl cdi = new CuentaDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "listar":
				List<Prestamos> lista = prestamoNeg.obtenerTodosLosPrestamos();
				request.setAttribute("listaPrestamos", lista);
				request.getRequestDispatcher("AprobacionPrestamoAdmin.jsp").forward(request, response);
				break;
			case "editar":
				PrestamoDaoImpl prestamodaoimpl = new PrestamoDaoImpl();

				Prestamos prestamoActualizar = prestamodaoimpl.obtenerUno(Integer.parseInt(request.getParameter("id")));
				prestamoActualizar.setEstado(true);
				prestamodaoimpl.actualizar(prestamoActualizar);
				response.sendRedirect("ServLetPrestamos?action=listar");
				break;
			case "eliminar":
				PrestamoDaoImpl prestamodaoimpl2 = new PrestamoDaoImpl();
				int idEliminar = Integer.parseInt(request.getParameter("id"));
				prestamodaoimpl2.eliminar(idEliminar);
				response.sendRedirect("ServLetPrestamos?action=listar");
				break;

				//Pagina HomebankingPagoPrestamo.jsp
			case "PagarPrestamo":
					HttpSession session = request.getSession();

					Cliente cliente = (Cliente) session.getAttribute("cliente");

					if (cliente == null) {
						response.sendRedirect("Login.jsp?sessionExpired=true");
						return;
					}

					List<Prestamos> lista2 = pc.obtenerTodosPrestamosCliente(cliente.getDNI());
					List<Plazos> lista3 = ppi.obtenerCuotasPorDNI(cliente.getDNI());
					List<Cuenta> lista4 = cdi.obtenerCuentasCliente(cliente.getDNI());


					request.setAttribute("listaPrestamosCliente", lista2);

					request.setAttribute("listaPlazosCliente", lista3);
					request.setAttribute("listaCuentaCliente", lista4);
					request.getRequestDispatcher("HomebankingPagoPrestamo.jsp").forward(request, response);

				break;
				
			case "prestamos_por_fecha":
			    PrestamosNegImpl prestamoNeg = new PrestamosNegImpl();
			    ArrayList<Prestamos> listaPrestamo = (ArrayList<Prestamos>) prestamoNeg.obtenerTodosLosPrestamos();
			    ArrayList<Prestamos> listaFiltrada = new ArrayList<>();
			    System.out.println(listaPrestamo);
			    
			    String fechaInicioStr = request.getParameter("fechaInicio");
			    String fechaFinStr = request.getParameter("fechaFin");
			    
			    LocalDate fechaI = LocalDate.parse(fechaInicioStr);
			    LocalDate fechaF = LocalDate.parse(fechaFinStr);
			    
			    for (Prestamos item : listaPrestamo) {
			        
			        java.sql.Date fechaPrestamoDate = (java.sql.Date) item.getFecha();
			        
			       
			        LocalDate fechaPrestamo = fechaPrestamoDate.toLocalDate();
			        
			        if ((fechaPrestamo.isEqual(fechaI) || fechaPrestamo.isAfter(fechaI)) && 
			            (fechaPrestamo.isEqual(fechaF) || fechaPrestamo.isBefore(fechaF))) {
			            listaFiltrada.add(item);
			        }
			    }
			    
			    request.setAttribute("listaPrestamos", listaFiltrada);
			    request.getRequestDispatcher("/PrestamosPorFecha.jsp").forward(request, response);
			    
			    break;
				




			default:
				response.sendRedirect("index.jsp");
				break;
			}
		} else {
			response.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null) {


			HttpSession session = request.getSession();

			Cliente cliente = (Cliente) session.getAttribute("cliente");

			if (cliente == null) {
				response.sendRedirect("Login.jsp?sessionExpired=true");
				return;
			}

			switch (action) {


			case "agregar":
				double montoPrestamo = Double.parseDouble(request.getParameter("montoPrestamo"));
				int cuotas = Integer.parseInt(request.getParameter("cuotas"));

				int tna = Integer.parseInt(request.getParameter("tna"));

				// Suponiendo que tienes un método getTNA() en tu entidad TipoPrestamos

				double importeAPagar = calcularImporteAPagar(montoPrestamo, cuotas, tna);
				// Obtener el cliente desde la sesión


				Prestamos prestamoNuevo = new Prestamos();
				prestamoNuevo.setIDTipoPrestamo(Integer.parseInt(request.getParameter("tipoPrestamo")));
				//prestamoNuevo.setDNICliente(11111111);
				prestamoNuevo.setDNICliente(cliente.getDNI());
				prestamoNuevo.setMontoPedido(Double.parseDouble(request.getParameter("montoPrestamo")));

				prestamoNuevo.setCuotas(Integer.parseInt(request.getParameter("cuotas")));
				prestamoNuevo.setImporteAPagar(importeAPagar);

				prestamoNuevo.setFecha(new Date());
				System.out.println("Fecha del préstamo: " + prestamoNuevo.getFecha());
				prestamoNuevo.setEstado(false);
				prestamoNeg.agregarPrestamo(prestamoNuevo);
				session.setAttribute("mensaje", "Pedido de Préstamo agregado exitosamente.");
				response.sendRedirect("HomebankingPedidoPrestamo.jsp");

				break;
			case "actualizar":
				PrestamoDaoImpl prestamodaoimpl = new PrestamoDaoImpl();

				Prestamos prestamoActualizar = prestamodaoimpl.obtenerUno(Integer.parseInt(request.getParameter("id")));
				prestamoActualizar.setEstado(true);
				prestamoNeg.modificarPrestamo(prestamoActualizar);
				response.sendRedirect("ServLetPrestamos");
				break;

			case "Pagar":
				int idPlazo = Integer.parseInt(request.getParameter("selectCuota"));
				int idCuenta = Integer.parseInt(request.getParameter("selectCuenta"));

				Plazos plazo = ppi.obtenerPorId(idPlazo);
				Cuenta cuenta = cdi.obtenerUnaCuenta(idCuenta);

				try {
					retirar(cuenta, plazo.getImporteAPagarCuotas());
					cdi.editarCuenta(cuenta);
					plazo.setEstado(true);
					ppi.actualizar(plazo);
					session.setAttribute("mensaje", "El pago de la cuota se realizó con éxito.");
				} catch (SaldoInsuficienteException e) {
					session.setAttribute("mensaje", e.getMessage());
				}

				List<Prestamos> lista2 = pc.obtenerTodosPrestamosCliente(cliente.getDNI());
				List<Plazos> lista3 = ppi.obtenerCuotasPorDNI(cliente.getDNI());
				List<Cuenta> lista4 = cdi.obtenerCuentasCliente(cliente.getDNI());

				request.setAttribute("listaPrestamosCliente", lista2);
				request.setAttribute("listaPlazosCliente", lista3);
				request.setAttribute("listaCuentaCliente", lista4);
				request.getRequestDispatcher("HomebankingPagoPrestamo.jsp").forward(request, response);












				break;

			default:
				response.sendRedirect("index.jsp");
				break;
			}
		} else {
			response.sendRedirect("index.jsp");
		}
	}





	public void retirar(Cuenta cuenta, double monto) throws SaldoInsuficienteException {
		if (cuenta.getSaldo() < monto) {
			throw new SaldoInsuficienteException("No hay suficiente saldo para retirar " + monto);
		}
		cuenta.setSaldo(cuenta.getSaldo() - monto);
	}







	private Date convertirFecha(String fechaStr) throws java.text.ParseException {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return formatoFecha.parse(fechaStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	private double calcularImporteAPagar(double montoPrestamo, int cuotas, double tna) {
		double interesMensual = tna / 12 / 100;
		double cuotaMensual = (montoPrestamo * interesMensual) / (1 - Math.pow(1 + interesMensual, -cuotas));
		return cuotaMensual * cuotas;
	}



}
