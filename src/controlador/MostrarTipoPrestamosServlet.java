package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datosImpl.TipoPrestamoDaoImpl;
import entidad.TipoPrestamos;

@WebServlet("/MostrarTipoPrestamosServlet")
public class MostrarTipoPrestamosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TipoPrestamoDaoImpl dao = new TipoPrestamoDaoImpl();
        List<TipoPrestamos> lista = dao.obtenerTodos();
        request.setAttribute("listaTipoPrestamos", lista);
        request.getRequestDispatcher("HomebankingPedidoPrestamo.jsp").forward(request, response);
    }
}
