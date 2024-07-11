<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Prestamos"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Selección de Fechas</title>
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
            font-family: 'Roboto Condensed', sans-serif;
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
        .list-group-item {
            background-color: #004a80;
            color: #ffffff;
            border-color: #004a80;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="row mb-3">
            <div class="col bank-heading">
                <h1>PRÉSTAMOS POR FECHA</h1>
            </div>
        </div>
        
        <form action="ServLetPrestamos" method="get">
		<input type="hidden" name="action" value="prestamos_por_fecha">
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
        
        <div class="row mb-3">
            <div class="col">
                <button type="submit" class="btn btn-primary">Buscar</button>
            </div>
        </div>
        
                <table id="table_id" class="table table-striped display text-center">
            <thead>
                <tr>
                    
                    <th>TIPO</th>
                    <th>DNI CLIENTE</th>
                    <th>MONTO PEDIDO</th>
                    <th>IMPORTE A PAGAR</th>
                    <th>CUOTAS</th>
                    <th>FECHA</th>
                    <th>ESTADO</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    ArrayList<Prestamos> listaPrestamos = (ArrayList<Prestamos>) request.getAttribute("listaPrestamos");
                    if (listaPrestamos != null) {
                        for (Prestamos item : listaPrestamos) { 
                %>
                    <tr>
                        
                        <td><%= item.getIDTipoPrestamo() %></td>
                        <td><%= item.getDNICliente() %></td>
                        <td><%= item.getMontoPedido() %></td>
                        <td><%= item.getImporteAPagar() %></td>
                        <td><%= item.getCuotas() %></td>                     
                        <td><%= item.getFecha() %></td>                            
                        <td><%= item.isEstado() %></td>                            
                        
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
        
        
        </div>

        </form>
        
        <div class="row mt-3">
        <div class="col text-center">
            <a href="InformesAdministrador.jsp" class="btn btn-primary">Volver</a>
        </div>
    </div>
    </div>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
