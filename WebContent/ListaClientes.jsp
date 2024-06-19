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
                <% 
                    ArrayList<Cliente> listaClientes = (ArrayList<Cliente>) request.getAttribute("listaClientes");
                    if (listaClientes != null) {
                        for (Cliente cliente : listaClientes) { 
                %>
                    <tr>
                        <td><%= cliente.getNombre() %> <%= cliente.getApellido() %></td>
                        <td><%= cliente.getDNI() %></td>
                        <td><%= cliente.getCUIL() %></td>
                        <td><%= cliente.getNacionalidad() %></td>
                        <td>
                            <button class="btn btn-danger">
                                <i class="bi bi-trash"></i>
                            </button>
                            <button class="btn btn-success">
                                <i class="bi bi-pencil-square"></i>
                            </button>
                        </td>
                    </tr>
                <% 
                        } 
                    } else { 
                %>
                    <tr>
                        <td colspan="9">No hay clientes disponibles</td>
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
