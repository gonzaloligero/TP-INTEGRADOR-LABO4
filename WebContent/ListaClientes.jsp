<%@page import="entidad.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
        
        <div>
            <a class="btn bg-azul fw-bold bi bi-person-plus fs-5 mb-3" href="AltaCliente.jsp">Agregar</a>
        </div>
        <table id="table_id" class="table table-striped display text-center">
            <thead>
                <tr>
                    <th>Usuario</th>
                    <th>Contraseña</th>
                    <th>Nombre y Apellido</th>
                    <th>DNI</th>
                    <th>CUIL</th>
                    <th>Nacionalidad</th>
                    <th>Sexo</th>
                    <th>Fecha de Nacimiento</th>
                    <th>Correo</th>
                    <th>Telefono</th>
                    <th>Dirección</th>
                    <th>Localidad</th>
                    <th>Provincia</th>
                    <th>Accion</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
                    if (request.getAttribute("listaClientes") != null) {
                        listaClientes = (ArrayList<Cliente>) request.getAttribute("listaClientes");
                        for (Cliente cliente : listaClientes) { 
                %>
                    <tr>
                        <td><%= cliente.getUser() %></td>
                        <td><%= cliente.getPassword() %></td>
                        <td><%= cliente.getNombre() %> <%= cliente.getApellido() %></td>
                        <td><%= cliente.getDNI() %></td>
                        <td><%= cliente.getCUIL() %></td>
                        <td><%= cliente.getNacionalidad() %></td>
                        <td><%= cliente.getSexo() %></td>
                        <td><%= cliente.getFechaNacimiento() %></td>
                        <td><%= cliente.getEmail() %></td>
                        <td><%= cliente.getNumeroTelefonico() %></td>
                        <td><%= cliente.getDireccion().getCalle() %> <%= cliente.getDireccion().getNumero() %></td>
                        <td><%= cliente.getDireccion().getLocalidad() %></td>
                        <td><%= cliente.getDireccion().getProvincia() %></td>
                        <td>

                            <a href="ServletClientes?action=eliminar&id=<%= cliente.getIDUsuario() %>" class="btn btn-danger"><i class="bi bi-trash"></i></a>
                            <a href="ServletClientes?action=editar&id=<%= cliente.getDNI() %>" class="btn btn-success"><i class="bi bi-pencil-square"></i></a>
                        </td>
                    </tr>
                <% 
                        } 
                    } else { 
                %>
                    <tr>
                        <td colspan="14">No hay clientes disponibles</td>
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
