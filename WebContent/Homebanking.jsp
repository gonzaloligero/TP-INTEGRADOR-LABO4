<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="entidad.Cliente"%>
<%@page import="entidad.Cuenta"%>
<%@page import="entidad.Movimiento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link rel="shortcut icon" href="images/favicon.png" type="">
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>HomeBanking</title>
    <!-- BOOTSTRAP STYLES -->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES -->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- CUSTOM STYLES -->
    <link href="assets/css/custom.css" rel="stylesheet" />
    <!-- GOOGLE FONTS -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <!-- FONT AWESOME STYLES (for additional icons) -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet" />
    
    
       <style>
        .LOGEARSE {
        	background: #1e1566;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            text-align: center;
        }
        .LOGEARSE a {
            color: #fff;
            text-decoration: none;
            margin-bottom: 20px;
        }
    </style>
    
    
</head>
<body>
    <div id="wrapper">
         <% 
            Cliente cliente = (Cliente) session.getAttribute("cliente");
            if (cliente != null) {
        %>
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="adjust-nav">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#" style="color:#fff;">
                        <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-bank" viewBox="0 0 16 16">
                            <path d="m8 0 6.61 3h.89a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.5.5H15v7a.5.5 0 0 1 .485.38l.5 2a.498.498 0 0 1-.485.62H.5a.498.498 0 0 1-.485-.62l.5-2A.5.5 0 0 1 1 13V6H.5a.5.5 0 0 1-.5-.5v-2A.5.5 0 0 1 .5 3h.89zM3.777 3h8.447L8 1zM2 6v7h1V6zm2 0v7h2.5V6zm3.5 0v7h1V6zm2 0v7H12V6zM13 6v7h1V6zm2-1V4H1v1zm-.39 9H1.39l-.25 1h13.72z"/>
                        </svg>
                        ITBank
                    </a>
                </div>
                <span class="logout-spn">
                    <a href="ServletLogin" style="color:#fff;">
                        ¡Bienvenido <%= cliente.getNombre() %>!
                        <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-power" viewBox="0 0 16 16">
                            <path d="M7.5 1v7h1V1h-1zM6.167 3.365A6 6 0 1 1 8 16V8h1v8A6 6 0 0 1 8 3.365a6.002 6.002 0 0 1-1.833 0z"/>
                        </svg>
                        Salir
                    </a>
                </span>
            </div>
        </div>
        <!-- /. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse collapse">
                <ul class="nav" id="main-menu">
                    <li class="active-link">
                        <a href="ServletMovimientos?action=listaMovimientos"><i class="fa fa-history"></i>Historial de Movimientos</a>
                    </li>
                    <li>                   
                        <a href="ServletTransferencias?action=listarCuentas"><i class="fa fa-refresh"></i>Transferencias</a>
                    </li>
                    <li >
                        <a href="MostrarTipoPrestamosServlet"><i class="fa fa-edit"></i>Pedido de Préstamo</a>
                    </li>
                    <li>
                        <a href="ServLetPrestamos?action=PagarPrestamo"><i class="fa fa-qrcode"></i>Pago de Préstamos</a>
                    </li>
                    <li>
                        <a href="HomebankingInfomacionPersonal.jsp"><i class="fa fa-bar-chart-o"></i>Información Personal</a>
                    </li>
                </ul>
            </div>
        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h2>Home Banking</h2>
                    </div>
                </div>



                <hr />
                <!-- /. ROW  -->
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
   
    <div class="footer">
        <div class="row">
            <div class="col-lg-12">
                &copy; 2024 ITBank | Design by: <a href="#" style="color:#fff;" target="_blank">Team Operacion java</a>
            </div>
        </div>
    </div>
    
    
        <% 
            } 
            else 
            {
        %>
        <div class="LOGEARSE">
        <a class="navbar-brand" href="#" style="color:#fff;">
                        <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-bank" viewBox="0 0 16 16">
                            <path d="m8 0 6.61 3h.89a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.5.5H15v7a.5.5 0 0 1 .485.38l.5 2a.498.498 0 0 1-.485.62H.5a.498.498 0 0 1-.485-.62l.5-2A.5.5 0 0 1 1 13V6H.5a.5.5 0 0 1-.5-.5v-2A.5.5 0 0 1 .5 3h.89zM3.777 3h8.447L8 1zM2 6v7h1V6zm2 0v7h2.5V6zm3.5 0v7h1V6zm2 0v7H12V6zM13 6v7h1V6zm2-1V4H1v1zm-.39 9H1.39l-.25 1h13.72z"/>
                        </svg>
                        ITBank
                    </a>
            <p>No has iniciado sesión. <a href="Login.jsp">Inicia sesión aquí</a>.</p>
            </div>
        <% 
            }
        %>
    
    <!-- /. WRAPPER  -->
    <!-- SCRIPTS AT THE BOTTOM TO REDUCE THE LOAD TIME -->
    <!-- JQUERY SCRIPTS -->
    <script src="assets/js/jquery-1.10.2.js"></script>
    <!-- BOOTSTRAP SCRIPTS -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- CUSTOM SCRIPTS -->
    <script src="assets/js/custom.js"></script>
</body>
</html>

