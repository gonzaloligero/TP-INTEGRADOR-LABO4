package controlador;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import datosImpl.PrestamoDaoImpl;
import datosImpl.TipoPrestamoDaoImpl;
import entidad.Cliente;
import entidad.Prestamos;
import negocio.PrestamosNegocio;
import negocioImpl.PrestamosNegImpl;

@WebServlet("/ServLetPrestamos")
public class ServLetPrestamos extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private PrestamosNegocio prestamoNeg = new PrestamosNegImpl();
	
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
	            switch (action) {
	                case "agregar":
	                	double montoPrestamo = Double.parseDouble(request.getParameter("montoPrestamo"));
	                    int cuotas = Integer.parseInt(request.getParameter("cuotas"));
	                    
	                    int tna = Integer.parseInt(request.getParameter("tna"));
	                   
	                      // Suponiendo que tienes un método getTNA() en tu entidad TipoPrestamos

	                    double importeAPagar = calcularImporteAPagar(montoPrestamo, cuotas, tna);
	                	// Obtener el cliente desde la sesión
	                    HttpSession session = request.getSession();
	                    
	                    Cliente cliente = (Cliente) session.getAttribute("cliente");

	                    if (cliente == null) {
	                        response.sendRedirect("Login.jsp?sessionExpired=true");
	                        return;
	                    }
	                	
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
	                    response.sendRedirect("PrestamoServlet?action=listar");
	                    break;
	                case "actualizar":
	                	PrestamoDaoImpl prestamodaoimpl = new PrestamoDaoImpl();
	                	  
	                    Prestamos prestamoActualizar = prestamodaoimpl.obtenerUno(Integer.parseInt(request.getParameter("id")));
	                    prestamoActualizar.setEstado(true);
	                    prestamoNeg.modificarPrestamo(prestamoActualizar);
	                    response.sendRedirect("ServLetPrestamos");
	                    break;
	                default:
	                    response.sendRedirect("index.jsp");
	                    break;
	            }
	        } else {
	            response.sendRedirect("index.jsp");
	        }
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
