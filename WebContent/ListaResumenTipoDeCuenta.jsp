<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Cuenta"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title></title>
    <jsp:include page="Componentes/head.jsp"></jsp:include>
</head>
<body>
    <jsp:include page="Componentes/NavBar.jsp"></jsp:include>
    
    
    <div class="container">
    <h1>Resumen - Tipos de cuentas</h1>
    <p class="lead">En la siguiente tabla se presenta el saldo total por cada tipo de cuenta en nuestro sistema bancario ITBank.</p>
        <div class="mt-5">        
            <% 
            ArrayList<Cuenta> listaCuentas = (ArrayList<Cuenta>) request.getAttribute("listaCuentaResumen");           
            if (listaCuentas != null) {
            %>
            <table id="table_id" class="table table-striped display text-center">
                <thead>
                    <tr>
                        <th>Descripción de Cuenta</th>                          
                        <th>Saldo Total</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                    for (Cuenta cuenta : listaCuentas) { 
                        String descripcionCuenta = "";
                        if (cuenta.getIDTipoCuenta() == 1) {
                            descripcionCuenta = "Caja de Ahorro";
                        } else if (cuenta.getIDTipoCuenta() == 2) {
                            descripcionCuenta = "Cuenta Corriente";
                        }
                        // Puedes agregar más condiciones según los tipos de cuenta que manejes
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
            <% } %>
        </div>
        <a class="btn bg-azul fw-bold bi bi-person-plus fs-5 mb-3" href="InformesAdministrador.jsp">Volver</a>
    </div>
    
    
    
    <jsp:include page="Componentes/Footer.jsp"></jsp:include>
</body>
</html>
