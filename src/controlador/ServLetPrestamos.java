package controlador;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import entidad.Prestamos;
import negocio.PrestamosNegocio;
import negocioImpl.PrestamosNegImpl;


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
	                    request.getRequestDispatcher("listarPrestamos.jsp").forward(request, response);
	                    break;
	                case "editar":
	                    int idEditar = Integer.parseInt(request.getParameter("id"));
	                    Prestamos prestamoEditar = prestamoNeg.obtenerPrestamo(idEditar);
	                    request.setAttribute("prestamo", prestamoEditar);
	                    request.getRequestDispatcher("editarPrestamo.jsp").forward(request, response);
	                    break;
	                case "eliminar":
	                    int idEliminar = Integer.parseInt(request.getParameter("id"));
	                    prestamoNeg.eliminarPrestamo(idEliminar);
	                    response.sendRedirect("PrestamoServlet?action=listar");
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
	                    Prestamos prestamoNuevo = new Prestamos();
	                    prestamoNuevo.setDNICliente(Integer.parseInt(request.getParameter("DNICliente")));
	                    prestamoNuevo.setMontoPedido(Double.parseDouble(request.getParameter("MontoPedido")));
	                    prestamoNuevo.setImporteAPagar(Double.parseDouble(request.getParameter("ImporteAPagar")));
	                    prestamoNuevo.setCuotas(Integer.parseInt(request.getParameter("Cuotas")));
					try {
						prestamoNuevo.setFecha(convertirFecha(request.getParameter("Fecha")));
					} catch (java.text.ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                    prestamoNuevo.setEstado(Boolean.parseBoolean(request.getParameter("Estado")));
	                    prestamoNeg.agregarPrestamo(prestamoNuevo);
	                    response.sendRedirect("PrestamoServlet?action=listar");
	                    break;
	                case "actualizar":
	                    Prestamos prestamoActualizar = new Prestamos();
	                    prestamoActualizar.setIDPrestamo(Integer.parseInt(request.getParameter("IDPrestamo")));
	                    prestamoActualizar.setDNICliente(Integer.parseInt(request.getParameter("DNICliente")));
	                    prestamoActualizar.setMontoPedido(Double.parseDouble(request.getParameter("MontoPedido")));
	                    prestamoActualizar.setImporteAPagar(Double.parseDouble(request.getParameter("ImporteAPagar")));
	                    prestamoActualizar.setCuotas(Integer.parseInt(request.getParameter("Cuotas")));
					try {
						prestamoActualizar.setFecha(convertirFecha(request.getParameter("Fecha")));
					} catch (java.text.ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                    prestamoActualizar.setEstado(Boolean.parseBoolean(request.getParameter("Estado")));
	                    prestamoNeg.modificarPrestamo(prestamoActualizar);
	                    response.sendRedirect("PrestamoServlet?action=listar");
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
	
	

}
