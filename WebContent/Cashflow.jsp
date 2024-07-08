<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entidad.Cliente" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Selección de Cliente - Banco XYZ</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed&display=swap" rel="stylesheet">
    
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
    <div class="container mt-5">
        <div class="row mb-3">
            <div class="col">
                <form id="selectClienteForm" action="ServletClientes" method="GET">
                    <div class="form-group">
                        <label for="clientes">Seleccione cliente:</label>
                        <select id="clientes" class="form-control" name="clienteId">

                            <% 
                                ArrayList<Cliente> listaClientes = (ArrayList<Cliente>) request.getAttribute("listaClientes");
                                if (listaClientes != null) {
                                    for (Cliente cliente : listaClientes) {
                            %>
							<option value="<%= cliente.getIDUsuario() %>"> <%= cliente.getDNI() %> - <%= cliente.getNombre() %> <%= cliente.getApellido() %></option>
                            <% 
                                    }
                                }
                            %>
                        </select>
                    </div>
                    <input type="hidden" name="action" value="cashflow">
                    <button type="submit" class="btn btn-primary">Ver Cashflow</button>
                </form>
            </div>
        </div>

		<form action="ServletMovimientos" method="POST">
        <div class="row">
            <div class="col">
                <table id="tablaCashflow" class="table table-bordered">
                    <thead>
                        <tr>
                            <th scope="col">Dinero Transferido</th>
                            <th scope="col">Dinero Recibido</th>
                            <th scope="col">Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
				            <td><%= String.format("$%.2f", request.getAttribute("dineroIngresado")) %></td>
				            <td><%= String.format("$%.2f", request.getAttribute("dineroTransferido")) %></td>
				            <td>$3,500</td>
				        </tr>
                    </tbody>
                </table>
            </div>
        </div>
		</form>
        <div class="row mt-3">
            <div class="col">
                <a href="InformesAdministrador.jsp" class="btn btn-primary">Volver</a>
            </div>
        </div>
    </div>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
