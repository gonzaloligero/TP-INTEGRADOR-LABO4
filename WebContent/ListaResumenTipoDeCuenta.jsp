<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Cuenta"%>
<%@page import="java.util.List"%>
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
            List<ArrayList<Cuenta>> listaPrincipal = (List<ArrayList<Cuenta>>)request.getAttribute("listaPrincipal");
            if (listaPrincipal != null && !listaPrincipal.isEmpty()) {
            %>
            <h2>Saldo Total por Tipo de Cuenta</h2>
            <table id="table_id" class="table table-striped display text-center">
               
                    <tr>
                        <th>Descripción de Cuenta</th>
                        <th>Saldo Total</th>
                    </tr>
               
                
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
               
               
            </table>

            <h2>Detalle de Cuentas</h2>
            <table id="table_general" class="table table-striped display text-center">
                
                    <tr>
                       
                        <th>DNI Cliente</th>
                        <th>Descripción de Cuenta</th>
                        <th>Fecha Creacion</th>                   
                        <th>Saldo</th>
                        <th>Estado</th>
                    </tr>
                
               
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
                
            </table>
            <% 
            } else { 
            %>
            <p>No hay datos disponibles.</p>
            <% 
            } 
            %>
        </div>
      
        <a class="btn bg-azul fw-bold bi bi-person-plus fs-5 mb-3" href="InformesAdministrador.jsp">Volver</a>
    </div>

    <jsp:include page="Componentes/Footer.jsp"></jsp:include>
</body>
</html>
