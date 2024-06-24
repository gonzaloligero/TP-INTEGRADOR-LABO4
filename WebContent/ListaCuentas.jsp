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
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
  
    <script type="text/javascript">
        $(document).ready(function() {
            $('#table_id').DataTable();
        });
    </script>
    
</head>
<body>

    <jsp:include page="Componentes/NavBar.jsp"></jsp:include>

    <div class="container">
        <div class="w-100 pt-2 text-center">
            <h1 class="mb-5">LISTA DE CUENTAS</h1>
        </div>
        
        <div>
        	<a class="btn bg-azul fw-bold bi bi-person-plus fs-5 mb-3" href="AltaCuenta.jsp">Agregar</a>
        	<a class="btn bg-azul fw-bold bi bi-person-plus fs-5 mb-3 btn-fixed-size " href="MenuAdministrador.jsp">Volver</a>
 
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
                    ArrayList<Cuenta> listaCuentas = new ArrayList<Cuenta>(); 
                    listaCuentas = Cuenta.listaCuentas(); //(ArrayList<Cuenta>) request.getAttribute("listaCuentas");
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