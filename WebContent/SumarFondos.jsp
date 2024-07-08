<%@page import="java.time.LocalDate"%>
<%@page import="java.sql.Date"%>
<%@page import="entidad.Cuenta"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de cuentas</title>
    <jsp:include page="Componentes/head.jsp"></jsp:include>
    <jsp:include page="Componentes/script_paginado.jsp"></jsp:include>
</head>
<body>
    <jsp:include page="Componentes/NavBar.jsp"></jsp:include>
    <div class="container">
        <div class="w-100 pt-2 text-center">
            <h1 class="mb-5">INYECCIÓN DE FONDOS</h1>
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
                </tr>
            </thead>
            <tbody>
                <% 
                    ArrayList<Cuenta> listaCuentas = (ArrayList<Cuenta>) request.getAttribute("listaFondos");
                    if (listaCuentas != null) {
                        for (Cuenta cuenta : listaCuentas) { 
                %>
                    <tr>
                        <td><%= cuenta.getIDCuenta() %></td>
                        <td><%= cuenta.getDNICliente() %></td>
                        <td><%= cuenta.getFechaCreacion() %></td>
                        <td><%= cuenta.getNumeroCuenta() %></td>
                        <td><%= cuenta.getCBU() %></td>
						<td>
						    <form action="ServletCuentas" method="get">
						        <input type="hidden" name="action" value="inyectar">
						        <input type="hidden" name="idCuenta" value="<%= cuenta.getNumeroCuenta() %>">
						        <input type="number" step="0.01" name="saldo" value="<%= cuenta.getSaldo() %>">
						        <button type="submit" class="btn btn-primary btn-sm">Actualizar</button>
						    </form>
						</td>
                  </tr>
                <% 
                        } 
                    } else { 
                %>
                    <tr>
                        <td colspan="7">No hay cuentas disponibles</td>
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
