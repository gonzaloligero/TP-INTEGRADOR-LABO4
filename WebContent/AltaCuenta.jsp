<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta de Cuenta</title>

<jsp:include page="Componentes/head.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">

<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $('#table_id').DataTable();
    });
</script>

</head>
<body>

<jsp:include page="Componentes/NavBar.jsp"></jsp:include>

<div class="container">
    <div class="w-100 pt-2 text-center">
        <h1 class="mb-5">ALTA DE CUENTA</h1>
    </div>
    
    <div class="row justify-content-center">
        <div class="col-md-6">
            <form action="ServletAgregarCuenta" method="post">
                <div class="mb-3">
                    <label for="dniCliente" class="form-label">DNI Cliente</label>
                    <input type="text" class="form-control" id="dniCliente" name="dniCliente" required>
                </div>
                <button type="submit" class="btn btn-primary">Agregar Cuenta</button>
            </form>
        </div>
    </div>
    
    <div class="mt-3">
        <a class="btn bg-azul fw-bold bi bi-arrow-left fs-5" href="ListaCuentas.jsp">Volver</a>
    </div>
</div>

<jsp:include page="Componentes/Footer.jsp"></jsp:include>

</body>
</html>
