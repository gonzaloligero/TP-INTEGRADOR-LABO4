package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletAgregarCuenta")
public class ServletAgregarCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletAgregarCuenta() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String dniCliente = request.getParameter("dniCliente");
	        String numeroCuenta = generarNumeroCuenta();
	        String cbu = generarCBU();
	        double saldo = 10000.00;

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tu_base_de_datos", "tu_usuario", "tu_contraseña");

	            String query = "INSERT INTO Cuenta (DNICliente, FechaCreacion, NumeroCuenta, CBU, Saldo) VALUES (?, CURDATE(), ?, ?, ?)";
	            PreparedStatement ps = con.prepareStatement(query);
	            ps.setString(1, dniCliente);
	            ps.setString(2, numeroCuenta);
	            ps.setString(3, cbu);
	            ps.setDouble(4, saldo);

	            ps.executeUpdate();
	            ps.close();
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        response.sendRedirect("ListaCuentas.jsp");
	    }

	    private String generarNumeroCuenta() {
	       
	        return "auto-generated-account-number";
	    }

	    private String generarCBU() {
	        
	        return "auto-generated-cbu";
	    }

}
