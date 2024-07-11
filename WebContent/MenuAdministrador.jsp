<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entidad.Usuario"%>
<html>
<head>
    <title>Menu Administrador</title>
    <jsp:include page="Componentes/head.jsp"></jsp:include>
</head>
<style>
   body {
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            min-height: 100vh;
            margin: 0;
        }
</style>

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

<body>
		<% 
            Usuario usuario = (Usuario) session.getAttribute("sessionLogin");
            if (usuario != null) {
        %>
    <jsp:include page="Componentes/NavBar.jsp"></jsp:include>
    <main>
        <div class="container">
            <div class="row flex-grow-1 m-0">
                <div class="col-lg-13 d-flex flex-column justify-content-between">
                    <div class="w-100 pt-2 text-center">
                        <h1 class="mb-5">MENU ADMINISTRADOR</h1>
                    </div>
                    <div>
                        <form action="#" method="post">
                            <div class="row justify-content-center">
                                <div class="col-md-3">
                                    <div class="mt-5">
                                        <a href="ServletClientes?action=listar" class="btn btn-primary w-100 btn-admin">Clientes</a>
                                    </div>
                                    <div class="mt-5">
                                        <a href="ServLetPrestamos?action=listar" class="btn btn-primary w-100 btn-admin">Préstamos</a>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="mt-5">
                                        <a href="ServletCuentas?action=listarCuentasGral" class="btn btn-primary w-100 btn-admin">Cuentas</a>
                                    </div>      
                                    <div class="mt-5">
                                        <a href="ServletMovimientos?action=transf" class="btn btn-primary w-100 btn-admin">Transferencias</a>
                                    </div>                                                 
                                </div>
                                <div class="col-md-3">
                                    <div class="mt-5">
                                        <a href="InformesAdministrador.jsp" class="btn btn-primary w-100 btn-admin">Informes</a>
                                    </div>  
                                             <div class="mt-5">
                                        <a href="ServletCuentas?action=fondos" class="btn btn-primary w-100 btn-admin">Fondos</a>
                                    </div>                        
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <jsp:include page="Componentes/Footer.jsp"></jsp:include>
    
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
</body>
</html>
