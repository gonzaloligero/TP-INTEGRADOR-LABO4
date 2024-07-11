package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import entidad.Cliente;
import entidad.Cuenta;
import excepciones.ClienteExcedeCantCuentas;
import excepciones.CuentaErrorOperacion;
import negocio.CuentaNegocio;
import negocio.MovimientoNegocio;
import negocioImpl.CuentaNegocioImpl;
import negocioImpl.MovimientoNegImpl;

@WebServlet("/ServletCuentas")
public class ServletCuentas extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private CuentaNegocio cuentaNegocio = new CuentaNegocioImpl();
    
    public ServletCuentas() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if (action != null) {
            switch (action) {
                case "listarCuentasGral":
                    ArrayList<Cuenta> listaCuentas = cuentaNegocio.listarCuentasGral();
                    Cuenta cuenta1 = new Cuenta();
                    listaCuentas.add(cuenta1);
                    request.setAttribute("listaCuentas", listaCuentas);
                    request.getRequestDispatcher("ListaCuentas.jsp").forward(request, response);
                    break;
                     
                case "listarCuentasCliente":
                    int dniCliente = Integer.parseInt(request.getParameter("dniCliente"));
                    ArrayList<Cuenta> listarCuentasCliente = cuentaNegocio.listarCuentasCliente(dniCliente);
                    request.setAttribute("listaCuentas", listarCuentasCliente);
                    request.getRequestDispatcher("ListarCuentasDeCliente.jsp").forward(request, response);
                    break;
                    
                case "mostrarCuentasEnTransferencias":
                    int dniClienteTransferencias = Integer.parseInt(request.getParameter("dniCliente"));
                    System.out.print(dniClienteTransferencias);
                    ArrayList<Cuenta> listarCuentasClienteTransferencias = cuentaNegocio.listarCuentasCliente(dniClienteTransferencias);
                    request.setAttribute("listaCuentasCliente", listarCuentasClienteTransferencias);
                    request.getRequestDispatcher("HomebankingTransferencias.jsp").forward(request, response);
                    break;
                    
                case "eliminar":
                	if(request.getParameter("numeroCuenta") != null) {
                		int numeroCuenta = Integer.parseInt(request.getParameter("numeroCuenta"));
                		try {
							cuentaNegocio.bajaLogicaCuenta(numeroCuenta);
						} catch (CuentaErrorOperacion e) {
						
							request.setAttribute("errorMensaje", e.getMessage());
				            request.getRequestDispatcher("BajaCuenta.jsp").forward(request, response);
				            return;
						}
                	}             	
                    ArrayList<Cuenta> listaCuentasBaja = cuentaNegocio.listarCuentasGral();
                    request.setAttribute("listaCuentas", listaCuentasBaja);
                    request.getRequestDispatcher("BajaCuenta.jsp").forward(request, response);                                      
                    
                    break;
                    
                case "alta":
                	if(request.getParameter("numeroCuenta") != null) {
                		int numeroCuenta = Integer.parseInt(request.getParameter("numeroCuenta"));
                		cuentaNegocio.altaLogicaCuenta(numeroCuenta);
                	}             	
                    ArrayList<Cuenta> listaCuentasAlta = cuentaNegocio.listarCuentasGral();
                    request.setAttribute("listaCuentas", listaCuentasAlta);
                    request.getRequestDispatcher("BajaCuenta.jsp").forward(request, response);                                      
                    
                    break;
                    
                case "editar":
                	
                	String idCuenta2 = request.getParameter("IDCuenta");                             
                    request.setAttribute("idcuenta", idCuenta2);
                    request.getRequestDispatcher("ModificarCuenta.jsp").forward(request, response);
 
                    break;
                    
                case "fondos":
                	ArrayList<Cuenta> listaFondos = cuentaNegocio.listarCuentasGral();
                    request.setAttribute("listaFondos", listaFondos);
                    request.getRequestDispatcher("SumarFondos.jsp").forward(request, response);
                    break;
                    
                case "inyectar":
                	ArrayList<Cuenta> listaFondosInyectar = cuentaNegocio.listarCuentasGral();
                    request.setAttribute("listaFondos", listaFondosInyectar);
                    int idCuenta = Integer.parseInt(request.getParameter("idCuenta"));
                    float saldo = Float.parseFloat(request.getParameter("saldo"));
                	MovimientoNegocio movimientoNegocio = new MovimientoNegImpl();
                	movimientoNegocio.inyectarDinero(saldo, idCuenta);
                    request.getRequestDispatcher("SumarFondos.jsp").forward(request, response);

                break;
                
                case "listarPorCategoria":
                    String tipoCliente = request.getParameter("categoria");
                    ArrayList<Cuenta> listaCuentasPorCategoria = new ArrayList<>();
                    
                    switch (tipoCliente) {
                        case "Bronce":
                            listaCuentasPorCategoria = cuentaNegocio.listarCuentasPorTipo(0, 1000000);
                            break;
                        case "Plata":
                            listaCuentasPorCategoria = cuentaNegocio.listarCuentasPorTipo(1000000, 2500000);
                            break;
                        case "Oro":
                            listaCuentasPorCategoria = cuentaNegocio.listarCuentasPorTipo(2500000, Double.MAX_VALUE);
                            break;
                    }
                    
                    request.setAttribute("listaCuentas", listaCuentasPorCategoria);
                    request.setAttribute("categoriaSeleccionada", tipoCliente);
                    request.getRequestDispatcher("TiposDeClientes.jsp").forward(request, response);
                    break;

                default:
                    response.sendRedirect("ListaCuentas.jsp");
                    break;
                    
                case "Resumen":
                	
                    String fechaInicioStr = request.getParameter("fechaInicio");
                    String fechaFinStr = request.getParameter("fechaFin");
                    String tipoStr = request.getParameter("categoria");
                    
                    Date sqlFecha1 = null;
            	    Date sqlFecha2 = null;
            		
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
                    
    			    				
                    int tipo = Integer.parseInt(tipoStr);                   
                    ArrayList<Cuenta> listaCuenta = cuentaNegocio.listaCuentasResumen(sqlFecha1, sqlFecha2, tipo);
                   
                    request.setAttribute("listaPrincipal", listaCuenta);
                    request.getRequestDispatcher("ListaResumenTipoDeCuenta.jsp").forward(request, response);
                	
                	
                    break;
                    
     
            }
        } else {
            response.sendRedirect("ListaCuentas.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	if (request.getParameter("BtnAgregarCuenta") != null) {
            int DNICliente = Integer.parseInt(request.getParameter("dniCliente"));
            int tipoDeCuenta = Integer.parseInt(request.getParameter("tipoDeCuenta"));

            try {
                boolean IDcuentaAgregada = cuentaNegocio.agregarCuentaCliente(DNICliente, tipoDeCuenta);
                if (IDcuentaAgregada) {
                    request.setAttribute("mensaje", "Cuenta agregada exitosamente.");
                } else {
                    request.setAttribute("mensaje", "No se pudo agregar la cuenta.");
                }
            } catch (Exception e) {
                request.setAttribute("mensaje", "Ocurrió un error: " + e.getMessage());
            }
            request.getRequestDispatcher("AltaCuenta.jsp").forward(request, response);
        }
        
        
        
        
        if(request.getParameter("btnGuardarCambios")!= null) {
        	
        	Cuenta cuentaEditar = new Cuenta();        	
            int id = Integer.parseInt(request.getParameter("idcuenta"));
            double saldo = Double.parseDouble(request.getParameter("saldo"));         
            cuentaEditar.setIDCuenta(id);
            cuentaEditar.setSaldo(saldo); 
            
            try {           	
            	boolean cuentaModificada = cuentaNegocio.editarCuenta(cuentaEditar);
            	
            	if (cuentaModificada) {
                    request.setAttribute("mensaje", "Cuenta modificada exitosamente.");
                } else {
                    request.setAttribute("mensaje", "No se pudo modificar la cuenta.");
                }
            	
            }
            catch (Exception e) {
                request.setAttribute("mensaje", "Ocurrió un error: " + e.getMessage());
            }
                                   
            RequestDispatcher dispatcher = request.getRequestDispatcher("MenuAdministrador.jsp");
            dispatcher.forward(request, response);
        }
    
    }
}
