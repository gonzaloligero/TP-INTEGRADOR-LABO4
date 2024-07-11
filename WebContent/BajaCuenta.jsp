<%@page import="entidad.Cuenta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta / Baja de Cuentas</title>

    <jsp:include page="Componentes/head.jsp"></jsp:include>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
    <jsp:include page="Componentes/script_paginado.jsp"></jsp:include>
    <script type="text/javascript">
    $(document).ready(function() {
        $('#table_id').DataTable();
            location.reload();
        });
    );
</script>

</head>
<body>

     <jsp:include page="Componentes/NavBar.jsp"></jsp:include>

    <div class="container">
        <div class="w-100 pt-2 text-center">
            <h1 class="mb-5">Alta / Baja de Cuentas</h1>
            <%
		        String errorMensaje = (String) request.getAttribute("errorMensaje");
		        if (errorMensaje != null) {
		    %>
		        <p style="color: red;"><%= errorMensaje %></p>
		    <%
		        }
		    %>
            
        </div>
        <table id="table_id" class="table table-striped display text-center">
            <thead>
                <tr>
                    <th>DniCliente</th>
                    <th>Numero De Cuenta</th>
                    <th>CBU</th>
                    <th>Saldo</th>
                    <th>Tipo de cuenta</th>
                    <th>Estado</th>
                    <th>Acción</th>
                </tr>
            </thead>
            <tbody>
                <%   
                    ArrayList<Cuenta> listaCuentas = new ArrayList<Cuenta>(); 
                    if (request.getAttribute("listaCuentas") != null) {
                    	listaCuentas = (ArrayList<Cuenta>)request.getAttribute("listaCuentas");
                        for (Cuenta cuenta : listaCuentas) { 
                %>
                    <tr>
                        <td><%= cuenta.getDNICliente() %></td>
                        <td><%= cuenta.getNumeroCuenta() %> </td>
                        <td><%= cuenta.getCBU() %></td>
                        <td><%= cuenta.getSaldo() %></td>
                        <td><%= cuenta.getIDTipoCuenta() %></td>
                        <td><%= cuenta.getEstado() == true ? "Activo" : "Inactivo" %></td>
                        <td>
                            <form action="ServletCuentas" method="get">
   								<% if (cuenta.getEstado() == false) { %>	
   								<input type="hidden" name="action" value="alta">
   								<input type="hidden" name="numeroCuenta" value="<%= cuenta.getNumeroCuenta() %>">
            					<button type="submit" class="btn btn-success">Dar de Alta</button>
        							<% } else { %>	
        						<input type="hidden" name="action" value="eliminar">
   								<input type="hidden" name="numeroCuenta" value="<%= cuenta.getNumeroCuenta() %>">			
            					<button type="submit" class="btn btn-danger">Dar de Baja</button>
        					<% } %>
   								
							</form>

                        </td>
                    </tr>
                <% 
                        } 
                    } else { 
                %>
                    <tr>
                        <td colspan="6">No hay cuentas disponibles</td>
                    </tr>
                <% 
                    } 
                %>
            </tbody>
        </table>
        <div class="container">
    		<a href="ServletCuentas?action=listarCuentasGral" class="btn btn-secondary">Volver</a>
		</div>
    </div>

    <jsp:include page="Componentes/Footer.jsp"></jsp:include>   

</body>
</html>