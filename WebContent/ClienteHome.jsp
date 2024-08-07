<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="Componentes/head.jsp"></jsp:include>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Men� Lateral - Banco</title>
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
<title>Insert title here</title>
</head>
<body>

<jsp:include page= "Componentes/NavBar.jsp"></jsp:include>


     <!-- Incluir el men� lateral -->
    <%@ include file="Componentes/MenuCliente.jsp" %>

    <!-- Contenido principal -->
    <div class="content">
        <h1>Historial de Movimientos</h1>
        <!-- Suponiendo que tienes un formulario para seleccionar la cuenta -->
<form>
    <label for="cuenta">Selecciona una cuenta:</label>
    <select id="cuenta" name="cuenta">
        <!-- Las opciones de cuentas se generan din�micamente aqu� -->
    </select>
    <input type="submit" value="Ver Movimientos">
</form>

<!-- Tabla para mostrar los movimientos -->
<table>
    <thead>
        <tr>
            <th>Fecha</th>
            <th>Detalle</th>
            <th>Importe</th>
        </tr>
    </thead>
    <tbody>
        <!-- Los movimientos se insertar�n aqu� din�micamente -->
    </tbody>
</table>

    </div>

    <!-- Bootstrap JS y Popper.js (opcional, solo necesario para dropdowns y cosas similares) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>



</body>
</html>