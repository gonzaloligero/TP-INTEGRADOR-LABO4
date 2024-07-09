<%@page import="entidad.Cliente"%>
<%@page import="entidad.Movimiento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de transferencias</title>

    <jsp:include page="Componentes/head.jsp"></jsp:include>    
    <jsp:include page="Componentes/script_paginado.jsp"></jsp:include>
    
<link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed&display=swap" rel="stylesheet">

    
    
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
            <h1 class="mb-5">LISTA DE TRANSFERENCIAS</h1>
        </div>
               
            

<div class="container mt-4">
    <form action="ServletMovimientos" method="post" class="d-flex align-items-center">
        <input type="hidden" name="action" value="buscarPorDni">
    </form>
</div>     
        <div>
			<a class="btn bg-azul fw-bold bi bi-arrow-left fs-5 mb-3" href="MenuAdministrador.jsp">Volver</a>
        </div>
        <div class="table-responsive">
            <table id="table_id" class="table table-striped table-sm display text-center">
                <thead>
                    <tr>
                        <th>Fecha</th>
                        <th>Detalle</th>
                        <th>Importe</th>
                        <th>Cuenta emisora</th>
                        <th>Cuenta receptora</th>

                    </tr>
                </thead>
                <form action="ServletMovimientos" method="get">
                <tbody>
                    <% 
                        ArrayList<Movimiento> listaTransferencias = new ArrayList<Movimiento>();
                        if (request.getAttribute("listaMovimientos") != null) {
                        	listaTransferencias = (ArrayList<Movimiento>) request.getAttribute("listaMovimientos");
                            for (Movimiento transferencia : listaTransferencias) { 
                    %>
                        <tr>   
                            <td><%= transferencia.getFecha() %></td>
                            <td><%= transferencia.getDetalle() %></td>
                            <td><%= transferencia.getImporte() %></td>
                            <td><%= transferencia.getIdCuentaEmisor() %></td>
                            <td><%= transferencia.getIdCuentaReceptor() %></td>
                      </tr>
                    <% 
                            } 
                        } else { 
                    %>
                        <tr>
                            <td colspan="14">No hay transferencias disponibles</td>
                        </tr>
                    <% 
                        } 
                    %>
                </tbody>
            </table>
            </form>
        </div>
    </div>

    <jsp:include page="Componentes/Footer.jsp"></jsp:include>

    
    <style>
        .table th, .table td {
            padding: 0.8rem;
        }
    </style>
</body>

</html>