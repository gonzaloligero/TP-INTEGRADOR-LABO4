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
    <style>
        body {
            font-family: 'Roboto Condensed', sans-serif;
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
            <h1 class="mb-5">LISTA DE CUENTAS</h1>
        </div>
        <div>
            <a class="btn bg-azul fw-bold bi bi-person-plus fs-5 mb-3" href="AltaCuenta.jsp">Agregar</a>                  
            <a class="btn bg-azul fw-bold bi bi-arrow-left fs-5 mb-3" href="MenuAdministrador.jsp">Volver</a>         
            <a class="btn bg-azul fw-bold bi bi-trash fs-5 mb-3" href="ServletCuentas?action=eliminar&id=0">Alta/Baja</a>

             <a class="btn bg-azul fw-bold bi bi-search fs-5 mb-3" href="ListarCuentasDeCliente.jsp">Cuentas de un Cliente</a>

        </div>
        <table id="table_id" class="table table-striped display text-center">
            <thead>
                <tr>
                    <th>ID Cuenta</th>
                    <th>DNI Cliente</th>
                    <th>Fecha de Creaci�n</th>
                    <th>N�mero de Cuenta</th>
                    <th>CBU</th>
                    <th>Saldo</th>
                    <th>Acci�n</th>
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
                          
                          <a href="ServletCuentas?action=editar&id=<%= cuenta.getIDCuenta() %>" class="btn btn-success btn-sm"><i class="bi bi-pencil-square"></i></a>
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
