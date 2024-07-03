package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Direccion;
import negocio.ClienteNegocio;
import negocioImpl.ClienteNegImpl;
import entidad.Cliente;
import excepciones.ContraseñaDiferente;

@WebServlet("/ServletInformes")
public class ServletInformes extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletInformes() {
        super();}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        ClienteNegocio clienteNegocio = new ClienteNegImpl();

        if (action != null) {
            switch (action) {

                case "cashflow":
                    Cliente clienteEditar = new Cliente();
                    clienteNegocio.editarCliente(clienteEditar);
                    ArrayList<Cliente> listaDeClientes = clienteNegocio.listarClientes();
                    request.setAttribute("listaClientes", listaDeClientes);
                    request.setAttribute("cliente", clienteEditar);
                    request.getRequestDispatcher("Cashflow.jsp").forward(request, response);
                    break;
                	default:
                    response.sendRedirect("index.jsp");
                    break;
            }
        } 
    }

 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
