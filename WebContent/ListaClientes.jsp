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
    <jsp:include page="Componentes/script_paginado.jsp"></jsp:include>
    

    
    
    <style>
    body {
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            min-height: 100vh;
            margin: 0;
        }
    </style>
</head>

<body>
    <jsp:include page="Componentes/NavBar.jsp"></jsp:include>
    
   
    <div class="container">
        <div class="w-100 pt-2 text-center">
            <h1 class="mb-5">LISTA DE CLIENTES</h1>
        </div>
        
        <div>
            <a class="btn bg-azul fw-bold bi bi-person-plus fs-5 mb-3" href="AltaCliente.jsp">Agregar</a>
			<a class="btn bg-azul fw-bold bi bi-pencil fs-5 mb-3" href="ServletClientes?action=editar&id=99999999">Modificar</a>
			<a class="btn bg-azul fw-bold bi bi-trash fs-5 mb-3" href="ServletClientes?action=eliminar&id=0">Alta/Baja</a>
			<a class="btn bg-azul fw-bold bi bi-arrow-left fs-5 mb-3" href="MenuAdministrador.jsp">Volver</a>
        </div>
        
        <div class="table-responsive">
            <table id="table_id" class="table table-striped table-sm display text-center">
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
                        <th>Teléfono</th>
                        <th>Dirección</th>
                        <th>Localidad</th>
                        <th>Provincia</th>
                        <th>Acción</th>
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
                            <% 
							    String contraseña = cliente.getPassword();
							    StringBuilder contraseñaOculta = new StringBuilder();
							    for (int i = 0; i < contraseña.length(); i++) {
							        contraseñaOculta.append("*");}%>
                            <td><%= contraseñaOculta.toString() %></td>
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
                                <a href="ServletClientes?action=eliminar&id=<%= cliente.getIDUsuario() %>" class="btn btn-danger btn-sm"><i class="bi bi-trash"></i></a>
                                <a href="ServletClientes?action=editar&id=<%= cliente.getDNI() %>" class="btn btn-success btn-sm"><i class="bi bi-pencil-square"></i></a>
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
    </div>

    <jsp:include page="Componentes/Footer.jsp"></jsp:include>

    
    <style>
        .table th, .table td {
            padding: 0.8rem;
        }
    </style>
</body>

</html>