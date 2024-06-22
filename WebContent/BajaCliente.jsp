<%@page import="entidad.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Baja de clientes</title>

    <jsp:include page="Componentes/head.jsp"></jsp:include>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
    <script type="text/javascript">
        $(document).ready(function() {
            $('#table_id').DataTable();
        });
    </script>
</head>
<body>
    <jsp:include page="Componentes/NavBar.jsp"></jsp:include>

    <div class="container">
        <div class="w-100 pt-2 text-center">
            <h1 class="mb-5">Baja de Clientes</h1>
        </div>
        <table id="table_id" class="table table-striped display text-center">
            <thead>
                <tr>
                    <th>Usuario</th>
                    <th>Nombre y Apellido</th>
                    <th>DNI</th>
                    <th>Correo</th>
                    <th>Telefono</th>
                    <th>Estado</th>
                    <th>Acción</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
                    if (request.getAttribute("listaClientes") != null) {
                        listaClientes = (ArrayList<Cliente>)request.getAttribute("listaClientes");
                        for (Cliente cliente : listaClientes) { 
                %>
                    <tr>
                        <td><%= cliente.getUser() %></td>
                        <td><%= cliente.getNombre() %> <%= cliente.getApellido() %></td>
                        <td><%= cliente.getDNI() %></td>
                        <td><%= cliente.getEmail() %></td>
                        <td><%= cliente.getNumeroTelefonico() %></td>
                        <td><%= cliente.getEstado() == true ? "Activo" : "Inactivo" %></td>
                        <td>
                            <form action="ServletClientes" method="get">
    							<input type="hidden" name="action" value="eliminar">
   								<input type="hidden" name="dni" value="<%= cliente.getDNI() %>">
   								<% if (cliente.getEstado() == false) { %>	
            					<button type="submit" class="btn btn-success">Dar de Alta</button>
        							<% } else { %>			
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
                        <td colspan="6">No hay clientes disponibles</td>
                    </tr>
                <% 
                    } 
                %>
            </tbody>
        </table>
    </div>

    <jsp:include page="Componentes/Footer.jsp"></jsp:include>
</body>
</html>
