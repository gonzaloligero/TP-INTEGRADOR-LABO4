<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<body>
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
                                </div>
                                <div class="col-md-3">
                                    <div class="mt-5">
                                        <a href="InformesAdministrador.jsp" class="btn btn-primary w-100 btn-admin">Informes</a>
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
</body>
</html>
