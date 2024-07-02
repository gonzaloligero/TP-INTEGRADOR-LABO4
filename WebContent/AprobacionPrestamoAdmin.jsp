<%@page import="entidad.Prestamos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Pedidos de Préstamos</title>

    <jsp:include page="Componentes/head.jsp"></jsp:include>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
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
            <h1 class="mb-5">LISTA DE PRÉSTAMOS</h1>
        </div>
        
        <div>
            <a class="btn bg-azul fw-bold bi bi-person-plus fs-5 mb-3" href="MenuAdministrador.jsp">Volver</a>
        </div>
        
        <div class="table-responsive">
            <table id="table_id" class="table table-striped table-sm display text-center">
                <thead>
                    <tr>
                        <th>DNI</th>
                        <th>Tipo de Préstamo</th>
                        <th>Monto Pedido</th>
                        <th>Importe a Pagar</th>
                        <th>Cuotas</th>
                        <th>Fecha Pedido</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        ArrayList<Prestamos> listaPrestamos = new ArrayList<Prestamos>();
                        if (request.getAttribute("listaPrestamos") != null) {
                            listaPrestamos = (ArrayList<Prestamos>) request.getAttribute("listaPrestamos");
                            for (Prestamos prestamo : listaPrestamos) { 
                                if (!prestamo.isEstado()) { // Verificar si el préstamo no está aprobado
                    %>
                        <tr>
                            <td><%= prestamo.getDNICliente() %></td>
                            <td><%= prestamo.getIDTipoPrestamo() %></td>
                            <td><%= prestamo.getMontoPedido() %></td>
                            <td><%= prestamo.getImporteAPagar() %></td>
                            <td><%= prestamo.getCuotas() %></td>
                            <td><%= prestamo.getFecha() %></td>
                            <td>
                                <a href="ServLetPrestamos?action=editar&id=<%= prestamo.getIDPrestamo() %>" class="btn btn-success btn-sm">Aprobar</a>
                                <a href="ServLetPrestamos?action=eliminar&id=<%= prestamo.getIDPrestamo() %>" class="btn btn-danger btn-sm">Eliminar</a>
                            </td>
                        </tr>
                    <% 
                                }
                            } 
                        } else { 
                    %>
                        <tr>
                            <td colspan="8">No hay Préstamos Disponibles</td>
                        </tr>
                    <% 
                        } 
                    %>
                </tbody>
            </table>
        </div>
    </div>

    <jsp:include page="Componentes/Footer.jsp"></jsp:include>

    <!-- CSS personalizado -->
    <style>
        .table th, .table td {
            padding: 0.5rem; /* Reducir el padding para hacer la tabla más compacta */
        }
    </style>
</body>
</html>
A
