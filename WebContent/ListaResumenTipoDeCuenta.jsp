<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Cuenta"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Resumen - Tipos de cuentas</title>
    <jsp:include page="Componentes/head.jsp"></jsp:include>
    
    <style>
        body {
            font-family: 'Roboto Condensed', Arial, sans-serif;
            background-color: #f0f0f0;
        }
        .container {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            margin-top: 20px;
            margin-bottom: 20px;
        }
        h1, h2 {
            color: #004a80;
            text-align: center;
        }
        .lead {
            text-align: center;
        }
        .table {
            margin-top: 20px;
        }
        .btn {
            color: #ffffff;
            background-color: #004a80;
            border-color: #004a80;
        }
        .btn:hover {
            background-color: #00365c;
            border-color: #00365c;
        }
    </style>
</head>

<body>
<<<<<<< HEAD
    <jsp:include page="Componentes/NavBar.jsp"></jsp:include>

    <div class="container">
        <h1>Resumen - Tipos de cuentas</h1>
        <p class="lead">En la siguiente tabla se presenta el saldo total por cada tipo de cuenta en nuestro sistema bancario ITBank.</p>
        
        <div class="mt-5">
            <%
            List<ArrayList<Cuenta>> listaPrincipal = (List<ArrayList<Cuenta>>)request.getAttribute("listaPrincipal");
            if (listaPrincipal != null && !listaPrincipal.isEmpty()) {
            %>
            <h2>Saldo Total por Tipo de Cuenta</h2>
            <table id="table_id" class="table table-striped display text-center">
                <thead>
                    <tr>
                        <th>Descripción de Cuenta</th>
                        <th>Saldo Total</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    for (Cuenta cuenta : listaPrincipal.get(0)) {
                        String descripcionCuenta = "";
                        if (cuenta.getIDTipoCuenta() == 1) {
                            descripcionCuenta = "Caja de Ahorro";
                        } else if (cuenta.getIDTipoCuenta() == 2) {
                            descripcionCuenta = "Cuenta Corriente";
                        }
                    %>
                    <tr>
                        <td><%= descripcionCuenta %></td>
                        <td><%= cuenta.getSaldo() %></td>
                    </tr>
                    <% 
                    }
                    %>
                </tbody>
            </table>

            <h2>Detalle de Cuentas</h2>
            <table id="table_general" class="table table-striped display text-center">
                <thead>
                    <tr>
                        <th>DNI Cliente</th>
                        <th>Descripción de Cuenta</th>
                        <th>Fecha Creacion</th>
                        <th>Saldo</th>
                        <th>Estado</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    for (Cuenta cuenta : listaPrincipal.get(1)) {
                        String descripcionCuenta2 = "";
                        if (cuenta.getIDTipoCuenta() == 1) {
                            descripcionCuenta2 = "Caja de Ahorro";
                        } else if (cuenta.getIDTipoCuenta() == 2) {
                            descripcionCuenta2 = "Cuenta Corriente";
                        }
                    %>
                    <tr>
                        <td><%= cuenta.getDNICliente() %></td> 
                        <td><%= descripcionCuenta2 %></td>
                        <td><%= cuenta.getFechaCreacion() %></td>
                        <td><%= cuenta.getSaldo() %></td>
                        <td><%= cuenta.getEstado() ? "Activo" : "Inactivo" %></td>
                    </tr>
                    <% 
                    }
                    %>
                </tbody>
            </table>
            <% 
            } else { 
            %>
            <p>No hay datos disponibles.</p>
            <% 
            } 
            %>
        </div>
      
        <a class="btn bg-azul fw-bold fs-5 mb-3" href="InformesAdministrador.jsp">Volver</a>
=======
 <jsp:include page="Componentes/NavBar.jsp"></jsp:include> 
    <div class="container mt-5">
        <div class="row mb-3">
            <div class="col">
                <h1>Selecciona las Fechas</h1>
            </div>
        </div>
        
        <form action="ServletCuentas" method="get">
        <input type="hidden" name="action" value="Resumen">
            <div class="row mb-3">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="fechaInicio">Fecha de Inicio</label>
                        <input type="date" class="form-control" id="fechaInicio" name="fechaInicio" required>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="fechaFin">Fecha de Fin</label>
                        <input type="date" class="form-control" id="fechaFin" name="fechaFin" required>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="categoria">Seleccione Tipo de Cuenta:</label>
                <select class="form-control" id="categoria" name="categoria">
                    <option value="">Seleccione el tipo de cuenta</option>
                    <option value="1">Caja de Ahorro</option>
                    <option value="2">Cuenta Corriente</option>
                </select>
            </div>
            <div class="row mb-3">
                <div class="col">
                    <button type="submit"  class="btn btn-primary">Buscar</button>
                </div>
            </div>
        </form>
        
        <hr>
        
        <div class="row mb-3">
            <div class="col">
                <h2>Detalle de Cuentas</h2>
                <% 
                ArrayList<Cuenta> listaPrincipal = (ArrayList<Cuenta>) request.getAttribute("listaPrincipal");
                if (listaPrincipal != null && !listaPrincipal.isEmpty()) {
                %>
                <table id="table_general" class="table table-striped display text-center">
                    <thead>
                        <tr>
                            <th>DNI Cliente</th>
                            <th>Descripción de Cuenta</th>
                            <th>Fecha Creación</th>
                            <th>Saldo</th>
                            <th>Estado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% 
                        for (Cuenta cuenta : listaPrincipal) {
                            String descripcionCuenta = "";
                            if (cuenta.getIDTipoCuenta() == 1) {
                                descripcionCuenta = "Caja de Ahorro";
                            } else if (cuenta.getIDTipoCuenta() == 2) {
                                descripcionCuenta = "Cuenta Corriente";
                            }
                        %>
                        <tr>
                            <td><%= cuenta.getDNICliente() %></td>
                            <td><%= descripcionCuenta %></td>
                            <td><%= cuenta.getFechaCreacion() %></td>
                            <td><%= "$" + cuenta.getSaldo() %></td>
                            <td><%= cuenta.getEstado() ? "Activo" : "Inactivo" %></td>
                        </tr>
                        <% 
                        }
                        %>
                    </tbody>
                </table>
                <% 
                } else { 
                %>
                <p>No hay datos disponibles.</p>
                <% 
                } 
                %>
            </div>
        </div>
        
        <div class="row mt-3">
            <div class="col">
                <a href="InformesAdministrador.jsp" class="btn btn-primary">Volver</a>
            </div>
        </div>
>>>>>>> 13a7ab1e05a2ca87a4ca389d9b831721d84653e7
    </div>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <jsp:include page="Componentes/Footer.jsp"></jsp:include>
</body>



</html>
