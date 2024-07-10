<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Cuenta"%>
<!DOCTYPE html>
<html>
<head>
    <title>Tipos de Clientes</title>
    <jsp:include page="Componentes/head.jsp"></jsp:include>
</head>
<body>
    <jsp:include page="Componentes/NavBar.jsp"></jsp:include>
    <div class="container">
        <div class="w-100 pt-2 text-center">
            <h1 class="mb-5">Tipos de Clientes</h1>
        </div>
        <form method="get" action="ServletCuentas">
            <div class="form-group">
                <label for="categoria">Seleccione Categoría:</label>
                <select class="form-control" id="categoria" name="categoria">
                	<option value="">Seleccione el tipo de cuenta</option>
                    <option value="Bronce">Bronce</option>
                    <option value="Plata">Plata</option>
                    <option value="Oro">Oro</option>
                </select>
            </div>
            <button type="submit" class="btn bg-azul fw-bold bi bi-search fs-5 mb-3">Ver</button>
            <input type="hidden" name="action" value="listarPorCategoria">
        </form>
        <div>
            <a class="btn bg-azul fw-bold bi bi-person-plus fs-5 mb-3" href="MenuAdministrador.jsp">Volver</a>
        </div>
        <div class="mt-5">
            <h2>Resultado:</h2>
            <% 
                ArrayList<Cuenta> listaCuentas = (ArrayList<Cuenta>) request.getAttribute("listaCuentas");
                String categoriaSeleccionada = (String) request.getAttribute("categoriaSeleccionada");
                if (listaCuentas != null && categoriaSeleccionada != null) {
            %>
                <h3>Categoría: <%= categoriaSeleccionada %></h3>
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
                            for (Cuenta cuenta : listaCuentas) { 
                        %>
                            <tr>
                                <td><%= cuenta.getIDCuenta() %></td>
                                <td><%= cuenta.getDNICliente() %></td>
                                <td><%= cuenta.getFechaCreacion() %></td>
                                <td><%= cuenta.getNumeroCuenta() %></td>
                                <td><%= cuenta.getCBU() %></td>
                                <td><%= cuenta.getSaldo() %></td>
                            </tr>
                        <% 
                            } 
                        %>
                    </tbody>
                </table>
            <% } %>
        </div>
    </div>
    <jsp:include page="Componentes/Footer.jsp"></jsp:include>
</body>
</html>
