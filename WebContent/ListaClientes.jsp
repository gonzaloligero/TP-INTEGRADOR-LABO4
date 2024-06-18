<%@page import="java.time.LocalDate"%>
<%@page import="java.sql.Date"%>
<%@page import="entidad.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de clientes</title>
    
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
            <h1 class="mb-5">LISTA DE CLIENTES</h1>
        </div>
        
        <table id="table_id" class="table table-striped  display text-center">
            <thead>
                <tr>
                    <th>Nombre de Usuario</th>
                    <th>Nombre y Apellido</th>
                    <th>DNI</th>
                    <th>CUIL</th>
                    <th>Nacionalidad</th>
                    <th>Fecha de Nacimiento</th>
                    <th>Correo</th>
                    <th>Telefono</th>
                    <th>Accion</th>
                </tr>
            </thead>
            <tbody>
                <%-- Itera sobre la lista de clientes y muestra cada uno --%>
                <% Cliente cliente = new Cliente(); %>
                <% for (int i = 0; i<8; i++) { %>
                	<%  cliente.setIDUsuario(1122); 
                		cliente.setNombre("Larry");
                		cliente.setApellido(" Capote");
                		cliente.setDNI(11122233);
                		cliente.setCUIL("20-111222233-0");
                		cliente.setNacionalidad("Extraterrestre");
                		cliente.setEmail("larry@demarte.com");
                		
                	%>
                    <tr>
                        <td><%= cliente.getIDUsuario() %></td>
                        <td><%= cliente.getNombre() %> <%= cliente.getApellido() %></td>
                        <td><%= cliente.getDNI() %></td>
                        <td><%= cliente.getCUIL() %></td>
                        <td><%= cliente.getNacionalidad() %></td>
                        <td><%= 11/05/2000 %></td>
                        <td><%= cliente.getEmail() %></td>
                        <td><%= 1122334455 %></td>
                        <td>
                            <button class="btn btn-danger">
                                <i class="bi bi-trash"></i>
                            </button>
                            <button class="btn btn-success">
                                <i class="bi bi-pencil-square"></i>
                            </button>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>

    <jsp:include page="Componentes/Footer.jsp"></jsp:include>
</body>
</html>

