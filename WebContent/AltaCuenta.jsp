<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta de Cuenta</title>

<jsp:include page="Componentes/head.jsp"></jsp:include>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $('#table_id').DataTable();
        <% if (request.getAttribute("mensaje") != null) { %>
            $('#messageModal').modal('show');
        <% } %>
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
            <form action="ServletCuentas" method="post">
                <div class="mb-3">
                    <label for="dniCliente" class="form-label">DNI Cliente</label>
                    <input type="text" class="form-control" id="dniCliente" name="dniCliente" required>
                </div>
                <div class="mb-3">
                    <label for="tipoDeCuenta" class="form-label">TIPO DE CUENTA</label>
                    <select class="form-control" name="tipoDeCuenta" id="tipoDeCuenta" required>
                        <option value="">Selecciona un tipo</option>
                        <option value="1">Caja de Ahorro</option>
                        <option value="2">Cuenta corriente</option>
                    </select>
                </div>
                <button type="submit" name="BtnAgregarCuenta" class="btn btn-primary">Agregar Cuenta</button>
            </form>
        </div>
    </div>
    
    <div class="mt-3">
        <a class="btn bg-azul fw-bold bi bi-arrow-left fs-5" href="ServletCuentas?action=listarCuentasGral">Volver</a>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="messageModal" tabindex="-1" role="dialog" aria-labelledby="messageModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="messageModalLabel">Mensaje</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <%= request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "" %>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="Componentes/Footer.jsp"></jsp:include>

</body>
</html>
