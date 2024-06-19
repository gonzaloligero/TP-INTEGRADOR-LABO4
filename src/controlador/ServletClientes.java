package controlador;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.ClienteNegocio;
import negocioImpl.ClienteNegImpl;
import entidad.Cliente;


@WebServlet("/ServletClientes")
public class ServletClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
    public ServletClientes() {
        
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ClienteNegocio clienteNegocio = new ClienteNegImpl();
        

        ArrayList<Cliente> listaClientes = clienteNegocio.listarClientes();
        

        for (Cliente cliente : listaClientes) {
            System.out.println(cliente.toString());
        }

        request.setAttribute("listaClientes", listaClientes);
        

        request.getRequestDispatcher("/ListaClientes.jsp").forward(request, response);
    }




	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
