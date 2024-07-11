<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Cuenta"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Tipos de Clientes</title>
    <jsp:include page="Componentes/head.jsp"></jsp:include>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed&display=swap" rel="stylesheet">
    <style>
    	.bank-heading {
        background-color: #004a80; 
        color: white; 
        font-family: 'Roboto Condensed', Arial, sans-serif; 
        font-weight: bold; 
        padding: 20px; 
        margin-bottom: 20px; 
        border-bottom: 4px solid #002c50; 
        text-align: center; 
   		 }
        body {
            font-family: 'Roboto Condensed', Arial, sans-serif;
            background-color: #f0f0f0;
        }
        .container {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .form-group label {
            font-weight: bold;
        }
        .btn-primary {
            background-color: #004a80;
            border-color: #004a80;
        }
        .btn-primary:hover {
            background-color: #00365c;
            border-color: #00365c;
        }
        .table th, .table td {
            border-color: #dee2e6;
        }
        .table th {
            background-color: #004a80;
            color: #ffffff;
        }
    </style>
</head>
<body>
    <jsp:include page="Componentes/NavBar.jsp"></jsp:include>
    <div class="container mt-5">
        <div class="col bank-heading">
            <h1>TIPOS DE CLIENTES</h1>
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
            <button type="submit" class="btn btn-primary  bi bi-search ">Buscar</button>
            <input type="hidden" name="action" value="listarPorCategoria">
        </form>
        <div class="text-center mt-3">
			<a class="btn btn-primary" href="InformesAdministrador.jsp">Volver</a>
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
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
