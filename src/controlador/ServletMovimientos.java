package controlador;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Cliente;
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
        String action = request.getParameter("action");
        HttpSession session = request.getSession();         
        Cliente cliente = (Cliente) session.getAttribute("cliente");

        if (action != null) {
            switch (action) {
                case "listaMovimientos":
                    if (cliente != null) {
                        int dni = cliente.getDNI();
                        ArrayList<Movimiento> listaMovimientoUsuario = movimientoNegocio.listarMovimientosPorCliente(dni);
                        request.setAttribute("listaMovimientos", listaMovimientoUsuario);	        
                        request.getRequestDispatcher("/HomebankingMovimientos.jsp").forward(request, response); 
                    }
                    break;
                    
                case "transf":
                    ArrayList<Movimiento> listaMovimiento = movimientoNegocio.listarMovimientos();	       
                    for (Movimiento movimiento : listaMovimiento) {
                        System.out.println(movimiento.toString());
                    }
                    request.setAttribute("listaMovimientos", listaMovimiento);	        
                    request.getRequestDispatcher("/ListaTransferencias.jsp").forward(request, response);
                    break;

                case "buscarPorTM":
                    if (cliente != null) {
                        int dni = cliente.getDNI();
                        ArrayList<Movimiento> listaMovimientoUsuario = movimientoNegocio.listarMovimientosPorCliente(dni);
                        int tipoMovimiento = Integer.parseInt(request.getParameter("tipoMovimiento"));
                        
                        ArrayList<Movimiento> listaFiltrada = new ArrayList<>();
                        for (Movimiento reg : listaMovimientoUsuario) {
                            if (reg.getIdMovimiento() == tipoMovimiento) {
                                listaFiltrada.add(reg);
                            }
                        }
                        request.setAttribute("listaMovimientos", listaFiltrada);
                        request.getRequestDispatcher("/HomebankingMovimientos.jsp").forward(request, response);
                    }
                    break;

                default:
                    
                    break;
            }
        }
    }
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
         String action = request.getParameter("action");
         if(action.equals("cashflow")) {
        	 MovimientoNegocio movimientoNegocio = new MovimientoNegImpl();
    		 String clienteIdStr = request.getParameter("clienteDNI");
        	 int clienteId = Integer.parseInt(request.getParameter("clienteDNI"));
    	   		 
    		 float []vecMontos = movimientoNegocio.obtenerCashflow(clienteId);
    		 request.setAttribute("dineroIngresado", vecMontos[0]);
    		 request.setAttribute("dineroTransferido", vecMontos[1]);
    	     request.getRequestDispatcher("ServletClientes?action=cashflow").forward(request, response);
    		}else if(action.equals("montos")) {
    			MovimientoNegocio movimientoNegocio = new MovimientoNegImpl();
    			String fechaInicioStr = request.getParameter("fechaInicio");
    			String fechaFinStr = request.getParameter("fechaFin");
    			java.sql.Date sqlFecha1 = null;
    		    java.sql.Date sqlFecha2 = null;
    			float montos = 0;
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
    		    montos = movimientoNegocio.montosPorFecha(sqlFecha1, sqlFecha2);
    		    request.setAttribute("montoTotal", montos);
		        request.getRequestDispatcher("/MontosIngresados.jsp").forward(request, response);
    		    
    		}
         	
	}
		 

}
