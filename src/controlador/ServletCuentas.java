package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Cliente;
import entidad.Cuenta;
import excepciones.ClienteExcedeCantCuentas;
import negocio.CuentaNegocio;
import negocioImpl.CuentaNegocioImpl;

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
                		cuentaNegocio.bajaLogicaCuenta(numeroCuenta);
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
                    Cuenta cuentaEditar = new Cuenta();
              
                    ArrayList<Cuenta> listaDeCuentas = cuentaNegocio.listarCuentasGral();
                    request.setAttribute("listaCuentas", listaDeCuentas);
                    request.setAttribute("cuenta", cuentaEditar);
                    request.getRequestDispatcher("ModificarCuenta.jsp").forward(request, response);
 
                    break;   
                    

                default:
                    response.sendRedirect("ListaCuentas.jsp");
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
                request.setAttribute("mensaje", "Ocurri� un error: " + e.getMessage());
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
                request.setAttribute("mensaje", "Ocurri� un error: " + e.getMessage());
            }
                                   
            RequestDispatcher dispatcher = request.getRequestDispatcher("MenuAdministrador.jsp");
            dispatcher.forward(request, response);
        }
    
    }
}
