<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Mis Cuentas</title>
    <jsp:include page="Componentes/head.jsp"></jsp:include>

</head>
<body class="d-flex flex-column">
    <div class="row flex-grow-1 m-0">
        <!--MAIN-->
        <div class="col-lg-9 col-md-12 d-flex flex-column justify-content-between">
            <div class="w-100 pt-2">
                <h1><i class="fas fa-wallet me-2"></i>MIS CUENTAS</h1>
            </div>
            <div class="row justify-content-center">
                <div class="col-sm-6 mb-3 mb-sm-0">
                
                    <div class="card mt-4 border-0">
                        <div class="card-body">
                            <!-- ACA van las tarjetas de cada cuenta -->
                            <div class="card mb-2">
                                <div class="card-body">
                                    <h5 class="card-title">CUENTA NRO. 00-1234567/8</h5>
                                    <form action="#" method="get">
                                        <ul class="list-group border-0">
                                            <li class="list-group-item border-0 bg-transparent d-flex justify-content-between align-items-center">
                                                <h6>Tipo Cuenta | $1,000.00</h6>
                                                <input type="submit" class="btn btn-primary btnEnviar" name="btnVerMovimientos" value="VER MOVIMIENTOS">
                                                <input type="hidden" name="numeroCuenta" value="0012345678">
                                            </li>
                                        </ul>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="card mt-4 border-0">
                        <div class="card-body">
                            <!-- ACA van las tarjetas de cada cuenta -->
                            <div class="card mb-2">
                                <div class="card-body">
                                    <h5 class="card-title">CUENTA NRO. 01-2234567/8</h5>
                                    <form action="#" method="get">
                                        <ul class="list-group border-0">
                                            <li class="list-group-item border-0 bg-transparent d-flex justify-content-between align-items-center">
                                                <h6>Tipo Cuenta | $1,500.00</h6>
                                                <input type="submit" class="btn btn-primary btnEnviar" name="btnVerMovimientos" value="VER MOVIMIENTOS">
                                                <input type="hidden" name="numeroCuenta" value="0012345678">
                                            </li>
                                        </ul>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    
                    <div class="text-center">
                        <a href="#" class="btn btn-primary btnEnviar mt-3"><i class="fa-solid fa-arrow-left me-2"></i>Volver</a>
                    </div>
                </div>
            </div>
        </div>
        <!--FIN MAIN-->
    </div>
    <!--FOOTER-->

</body>
</html>

</html>