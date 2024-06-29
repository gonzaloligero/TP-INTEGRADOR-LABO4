<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="entidad.TipoPrestamos"%>
<%@page import="entidad.Cliente"%>
<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <jsp:include page="Componentes/head.jsp"></jsp:include>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menú Lateral - Banco</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome Icons -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        .sidebar {
            position: fixed;
            top: 0;
            left: 0;
            height: 100%;
            width: 250px;
            background: #000;
            color: #fff;
            transition: all 0.3s;
            z-index: 999;
            padding-top: 60px;
        }
        .sidebar ul {
            list-style-type: none;
            padding: 0;
        }
        .sidebar ul li {
            padding: 10px 15px;
            border-bottom: 1px solid #555;
        }
        .sidebar ul li a {
            color: #fff;
            text-decoration: none;
            display: block;
        }
        .sidebar ul li a:hover {
            background-color: #555;
        }
        .content {
            margin-left: 250px;
            padding: 20px;
        }
    </style>
</head>
<body>
    <jsp:include page="Componentes/NavBar.jsp"></jsp:include>

    <!-- Incluir el menú lateral -->
    <%@ include file="Componentes/MenuCliente.jsp" %>

    <!-- Contenido principal -->
    <div class="content">
    <% 
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        if (cliente != null) {
    %>
        <h1><%= cliente.getNombre() %> Pedí un préstamo hoy</h1>
        <!-- Suponiendo que tienes un formulario para seleccionar la cuenta -->
        <form action="ServLetPrestamos" method="post">
            <input type="hidden" name="action" value="agregar">
            <label for="montoPrestamo">Monto del préstamo:</label>
            <input type="number" id="MontoPedido" name="montoPrestamo" step="0.01" required>

            <label for="cuotas">Cantidad de cuotas:</label>
            <input type="number" id="cuotas" name="cuotas" required>

            <div class="form-group">
                <label for="tipoPrestamo">Tipo de Préstamo:</label>
                <select id="tipoPrestamo" name="tipoPrestamo" class="form-control" required>
                    <option value="" disabled selected>Seleccione un tipo de préstamo</option>
                    <%
                        List<TipoPrestamos> listaTiposPrestamo = (List<TipoPrestamos>) request.getAttribute("listaTipoPrestamos");
                        if (listaTiposPrestamo != null) {
                            for (TipoPrestamos tipoPrestamo : listaTiposPrestamo) {
                    %>
                                <option value="<%= tipoPrestamo.getIDTipoPrestamo() %>" data-tna="<%= tipoPrestamo.getTNA() %>"><%= tipoPrestamo.getTipo() %></option>
                    <%
                            }
                        } else {
                    %>
                        <option value="" disabled>No hay tipos de préstamo disponibles</option>
                    <%
                        }
                    %>
                </select>
            </div>

            <!-- Campo oculto para el TNA -->
            <input type="hidden" id="tna" name="tna">

            <input type="submit" value="Solicitar Préstamo">
        </form>

        <div>
            <h2>Importe a Pagar: <span id="importeAPagar">0.00</span></h2>
        </div>
    <% 
        } else {
    %>
        <p>No has iniciado sesión. <a href="login.jsp">Inicia sesión aquí</a>.</p>
    <% 
        }
    %>
    </div>

    <!-- Bootstrap JS y Popper.js (opcional, solo necesario para dropdowns y cosas similares) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
    <!-- JavaScript para el cálculo en tiempo real y actualización del campo oculto -->
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            const montoInput = document.getElementById('MontoPedido');
            const cuotasInput = document.getElementById('cuotas');
            const tipoPrestamoSelect = document.getElementById('tipoPrestamo');
            const tnaInput = document.getElementById('tna');
            const importeAPagarSpan = document.getElementById('importeAPagar');

            function calcularImporteAPagar() {
                const monto = parseFloat(montoInput.value);
                const cuotas = parseInt(cuotasInput.value);
                const selectedOption = tipoPrestamoSelect.options[tipoPrestamoSelect.selectedIndex];
                const tna = parseFloat(selectedOption.getAttribute('data-tna'));

                if (!isNaN(monto) && !isNaN(cuotas) && !isNaN(tna)) {
                    const interesMensual =(tna /12)/ 100;
                    const cuotaMensual = (monto * interesMensual) / (1 - Math.pow(1 + interesMensual, -cuotas));
                    const importeAPagar = cuotaMensual * cuotas;
                    importeAPagarSpan.textContent = importeAPagar.toFixed(2);
                } else {
                    importeAPagarSpan.textContent = '0.00';
                }
            }

            function actualizarTNA() {
                const selectedOption = tipoPrestamoSelect.options[tipoPrestamoSelect.selectedIndex];
                const tna = selectedOption.getAttribute('data-tna');
                tnaInput.value = tna;
            }

            montoInput.addEventListener('input', calcularImporteAPagar);
            cuotasInput.addEventListener('input', calcularImporteAPagar);
            tipoPrestamoSelect.addEventListener('change', function() {
                actualizarTNA();
                calcularImporteAPagar();
            });

            // Inicializar el TNA y el importe a pagar al cargar la página
            if (tipoPrestamoSelect.selectedIndex > 0) {
                actualizarTNA();
                calcularImporteAPagar();
            }
        });
    </script>

</body>
</html>


