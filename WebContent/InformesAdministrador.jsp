<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Dashboard de Administrador</title>
    <jsp:include page="Componentes/head.jsp"></jsp:include>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Roboto Condensed', sans-serif;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            min-height: 100vh;
            margin: 0;
            background-color: #f8f9fa;
        }
        main {
            flex: 1; 
            padding: 20px;
        }
        .container {
            max-width: 1200px;
            margin: auto;
            padding: 20px;
        }
        .card-group {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            gap: 20px;
        }
        .card {
            flex: 1 1 calc(33.333% - 20px);
            display: flex;
            flex-direction: column;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            transition: transform 0.3s ease;
        }
        .card:hover {
            transform: translateY(-5px);
        }
        .card img {
            border-top-left-radius: 5px;
            border-top-right-radius: 5px;
            max-height: 180px;
            object-fit: cover;
        }
        .card-body {
            flex: 1;
            padding: 20px;
            background-color: #fff;
            display: flex;
            flex-direction: column;
        }
        .card-title {
            margin-top: 0;
            margin-bottom: 10px;
            color: #007bff;
        }
        .card-text {
            flex: 1;
            margin-top: 0;
            font-size: 16px;
            color: #333;
        }
        .btn-primary {
            background-color: #004a80;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            text-decoration: none;
            cursor: pointer;
            margin-top: 10px;
            align-self: flex-end;
        }
        .btn-primary:hover {
            background-color: #00365c;
        }
        .btn-fixed-size {
            min-width: 150px;
        }
    </style>
</head>
<body>
    <jsp:include page="Componentes/NavBar.jsp"></jsp:include>

    <main>
        <div class="container">
            <div>
				<a class="btn bg-azul fw-bold bi bi-arrow-left fs-5 mb-3 btn-fixed-size" href="MenuAdministrador.jsp">Volver</a>
            </div>
            
            <div class="card-group">
                <div class="card">
                    <img src="https://images.squarespace-cdn.com/content/v1/5714c56a7c65e4da9938003d/1588347561425-09P0DO81CIPOOSY8ZXIQ/cash-flow-illustration-laptop-money-graph-chart-vector-68966608.jpg?format=1000w" class="card-img-top" alt="CASHFLOW">
                    <div class="card-body">
                        <h5 class="card-title">CASHFLOW</h5>
                        <p class="card-text">Seleccione un cliente para ver el reporte del dinero que se ha transferido en el �ltimo tiempo con los clientes involucrados y el total de efectivo.</p>
                        <a href="ServletClientes?action=cashflow" class="btn btn-primary">Ver</a>
                    </div>
                </div>
                <div class="card">
                    <img src="https://tyrrrz.me/_next/image?url=%2Fblog%2Ftarget-type-inference%2Fcover.png&w=1920&q=75" class="card-img-top" alt="PR�STAMOS POR FECHA">
                    <div class="card-body">
                        <h5 class="card-title">PR�STAMOS POR FECHA</h5>
                        <p class="card-text">Seleccione mes y a�o para rastrear los pr�stamos que han sido solicitados en ese momento.</p>
                        <a href="PrestamosPorFecha.jsp" class="btn btn-primary">Ver</a>
                    </div>
                </div>
                <div class="card">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR34MDPHThtQz2Mefl0Rjt_BFMcT8yzhRI_wg&s" class="card-img-top" alt="MONTOS INGRESADOS">
                    <div class="card-body">
                        <h5 class="card-title">MONTOS INGRESADOS</h5>
                        <p class="card-text">Seleccione dos fechas de inicio y fin para determinar el dinero que ingres� en el banco en esa franja.</p>
                        <a href="MontosIngresados.jsp" class="btn btn-primary">Ver</a>
                    </div>
                </div>
                <div class="card">
                    <img src="https://www.worktango.com/wp-content/uploads/2022/09/Batch2_1711_5waystoengage_1280x720ArticleHeaderandHomepageThumbnail.jpg-800x450.png" class="card-img-top" alt="RASTREADOR DE TRANSFERENCIAS POR MONTO">
                    <div class="card-body">
                        <h5 class="card-title">RASTREADOR DE TRANSFERENCIAS POR MONTO</h5>
                        <p class="card-text">Detalle sobre las transferencias que superan un valor especifico en una franja seleccionada.</p>
                        <a href="RastreadorTransferencias.jsp" class="btn btn-primary">Ver</a>
                    </div>
                </div>
                <div class="card">
                    <img src="https://elviajedelcliente.com/wp-content/uploads/2020/07/portada.jpg" class="card-img-top" alt="TIPOS DE CLIENTES">
                    <div class="card-body">
                        <h5 class="card-title">TIPOS DE CLIENTES</h5>
                        <p class="card-text">Detalle de los tipos de clientes, seg�n el dinero en las cuentas, discriminados en categor�as o niveles como bronce, plata y oro.</p>
                        <a href="TiposDeClientes.jsp" class="btn btn-primary">Ver</a>
                    </div>
                </div>
               <div class="card" style="width: 18rem;">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSEfn657JB4oDZHKXF3h2Oeg8FaZbogk5rsw&s" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">REPORTE DE CUENTAS POR FECHA Y TIPO</h5>
                        <p class="card-text">Establece un rango de fecha e indique el tipo de cuenta que desea listar.</p>
                        <a href="ListaResumenTipoDeCuenta.jsp" class="btn btn-primary">Ver</a>
                    </div>
        </div>
            </div>
        </div>
    </main>

    <jsp:include page="Componentes/Footer.jsp"></jsp:include>
</body>
</html>
