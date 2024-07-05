<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Cuenta"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Listar Cuentas de Cliente</title>
    <jsp:include page="Componentes/head.jsp"></jsp:include>
    <jsp:include page="Componentes/script_paginado.jsp"></jsp:include>
</head>
<body>
    <jsp:include page="Componentes/NavBar.jsp"></jsp:include>
    <div class="container">
        <div class="w-100 pt-2 text-center">
            <h1 class="mb-5">LISTA DE CUENTAS DE CLIENTE</h1>
        </div>
        <form method="get" action="ServletCuentas">
            <div class="form-group">
                <label for="dniCliente">Ingrese DNI del Cliente:</label>
                <input type="text" class="form-control" id="dniCliente" name="dniCliente" required>
            </div>
            <button type="submit" class="btn bg-azul fw-bold bi bi-search fs-5 mb-3">Buscar</button>
            <input type="hidden" name="action" value="listarCuentasCliente">
        </form>
        <div>
            <a class="btn bg-azul fw-bold bi bi-person-plus fs-5 mb-3" href="MenuAdministrador.jsp">Volver</a>
        </div>
        <table id="table_id" class="table table-striped display text-center">
            <thead>
                <tr>
                    <th>ID Cuenta</th>
                    <th>DNI Cliente</th>
                    <th>Fecha de Creación</th>
                    <th>Número de Cuenta</th>
                    <th>CBU</th>
                    <th>Saldo</th>
                    <th>Acción</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    ArrayList<Cuenta> listaCuentas = (ArrayList<Cuenta>) request.getAttribute("listaCuentas");
                    if (listaCuentas != null) {
                        for (Cuenta cuenta : listaCuentas) { 
                %>
                    <tr>
                        <td><%= cuenta.getIDCuenta() %></td>
                        <td><%= cuenta.getDNICliente() %></td>
                        <td><%= cuenta.getFechaCreacion() %></td>
                        <td><%= cuenta.getNumeroCuenta() %></td>
                        <td><%= cuenta.getCBU() %></td>
                        <td><%= cuenta.getSaldo() %></td>
                        <td>
                            <button class="btn btn-danger btn-sm"><i class="bi bi-trash"></i></button>
                            <button class="btn btn-success btn-sm"><i class="bi bi-pencil-square"></i></button>
                        </td>
                    </tr>
                <% 
                        } 
                    } else { 
                %>
                    <tr>
                        <td colspan="7">No hay cuentas disponibles para este DNI</td>
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
