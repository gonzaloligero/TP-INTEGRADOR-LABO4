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
            font-family: Arial, sans-serif;
        }
        main {
            flex: 1; 
            padding: 20px;
        }
        .dashboard-section {
            background-color: #f9f9f9;
            padding: 20px;
            margin-bottom: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .dashboard-section h2 {
            margin-top: 0;
            margin-bottom: 10px;
            color: #333;
        }
        .dashboard-section p {
            margin-top: 0;
            font-size: 18px;
        }
        .dashboard-section .btn {
            margin-top: 10px;
        }
        .dashboard-section .btn-primary {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 8px 16px;
            border-radius: 4px;
            text-decoration: none;
            cursor: pointer;
        }
        .dashboard-section .btn-primary:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <jsp:include page="Componentes/NavBar.jsp"></jsp:include>


    <main>
        <div class="container">
            <div>
                <a class="btn bg-azul fw-bold bi bi-person-plus fs-5 mb-3 btn-fixed-size" href="MenuAdministrador.jsp">Volver</a>
            </div>
            
            <div class="card-group">
                <!-- Card 5 -->
                <div class="card" style="width: 18rem;">
                    <img src="https://images.squarespace-cdn.com/content/v1/5714c56a7c65e4da9938003d/1588347561425-09P0DO81CIPOOSY8ZXIQ/cash-flow-illustration-laptop-money-graph-chart-vector-68966608.jpg?format=1000w" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">CASHFLOW</h5>
                        <p class="card-text">Reporte del dinero que se ha transferido el último tiempo con los clientes involucrados</p>
                        <a href="ServletClientes?action=cashflow" class="btn btn-primary">Ver</a>
                    </div>
                </div>
                <!-- Card 6 -->
                <div class="card" style="width: 18rem;">
                    <img src="https://tyrrrz.me/_next/image?url=%2Fblog%2Ftarget-type-inference%2Fcover.png&w=1920&q=75" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">PRÉSTAMOS POR FECHA</h5>
                        <p class="card-text">Seleccione mes y año para rastrear los préstamos que han sido solicitados en ese momento</p>
                        <a href="#" class="btn btn-primary">Ver</a>
                    </div>
                </div>
                <!-- Card 7 -->
                <div class="card" style="width: 18rem;">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR34MDPHThtQz2Mefl0Rjt_BFMcT8yzhRI_wg&s" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">MONTOS INGRESADOS</h5>
                        <p class="card-text">Seleccione dos fechas de inicio y fin para determinar el dinero que ingresó en el banco en esa franja</p>
                        <a href="MontosIngresados.jsp" class="btn btn-primary">Ver</a>
                    </div>
                </div>
                <!-- Card 8 -->
                <div class="card" style="width: 18rem;">
                    <img src="https://www.worktango.com/wp-content/uploads/2022/09/Batch2_1711_5waystoengage_1280x720ArticleHeaderandHomepageThumbnail.jpg-800x450.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">REGISTRO DE APROBACIONES</h5>
                        <p class="card-text">Detalle sobre usuarios que han aprobado préstamos, su monto, fecha y estado actual</p>
                        <a href="#" class="btn btn-primary">Ver</a>
                    </div>
                </div>
                 <div class="card" style="width: 18rem;">
                    <img src="https://elviajedelcliente.com/wp-content/uploads/2020/07/portada.jpg" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">TIPOS DE CLIENTES</h5>
                        <p class="card-text">Detalle de los tipos de clientes, según el dinero en cuentas</p>
                        <a href="TiposDeClientes.jsp" class="btn btn-primary">Ver</a>
                    </div>
                </div>
                
                <div class="card" style="width: 18rem;">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSEfn657JB4oDZHKXF3h2Oeg8FaZbogk5rsw&s" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">RESUMEN DE CUENTAS POR TIPO</h5>
                        <p class="card-text">Caja de Ahorro y Cuenta Corriente, junto al saldo total en cada tipo de cuenta.</p>
                        <a href="ServletCuentas?action=Resumen" class="btn btn-primary">Ver</a>
                    </div>
                </div>
                
                
                
            </div>
        </div>
    </main>


    <jsp:include page="Componentes/Footer.jsp"></jsp:include>
</body>
</html>
