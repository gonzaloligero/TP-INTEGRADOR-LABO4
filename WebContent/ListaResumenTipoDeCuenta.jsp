<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Cuenta"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title></title>
    <jsp:include page="Componentes/head.jsp"></jsp:include>
    
   
</head>

<body>
 <jsp:include page="Componentes/NavBar.jsp"></jsp:include> 
    <div class="container mt-5">
        <div class="row mb-3">
            <div class="col">
                <h1>Selecciona las Fechas</h1>
            </div>
        </div>     
        <form action="ServletCuentas" method="get">
        <input type="hidden" name="action" value="Resumen">
            <div class="row mb-3">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="fechaInicio">Fecha de Inicio</label>
                        <input type="date" class="form-control" id="fechaInicio" name="fechaInicio" required>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="fechaFin">Fecha de Fin</label>
                        <input type="date" class="form-control" id="fechaFin" name="fechaFin" required>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="categoria">Seleccione Tipo de Cuenta:</label>
                <select class="form-control" id="categoria" name="categoria" required>
                    <option value="">Seleccione el tipo de cuenta</option>
                    <option value="1">Caja de Ahorro</option>
                    <option value="2">Cuenta Corriente</option>
                </select>
            </div>
            <div class="row mb-3">
                <div class="col">
                    <button type="submit"  class="btn btn-primary">Buscar</button>
                </div>
            </div>
        </form>
        
        <hr>
        
        <div class="row mb-3">
        
            <div class="col">
                <h2>Detalle de Cuentas</h2>
                <% 
                ArrayList<Cuenta> listaPrincipal = (ArrayList<Cuenta>) request.getAttribute("listaPrincipal");
                if (listaPrincipal != null && !listaPrincipal.isEmpty()) {
                %>
                <table id="table_general" class="table table-striped display text-center">
                    <thead>
                        <tr>
                            <th>DNI Cliente</th>
                            <th>Descripción de Cuenta</th>
                            <th>Fecha Creación</th>
                            <th>Saldo</th>
                            <th>Estado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% 
                        for (Cuenta cuenta : listaPrincipal) {
                            String descripcionCuenta = "";
                            if (cuenta.getIDTipoCuenta() == 1) {
                                descripcionCuenta = "Caja de Ahorro";
                            } else if (cuenta.getIDTipoCuenta() == 2) {
                                descripcionCuenta = "Cuenta Corriente";
                            }
                        %>
                        <tr>
                            <td><%= cuenta.getDNICliente() %></td>
                            <td><%= descripcionCuenta %></td>
                            <td><%= cuenta.getFechaCreacion() %></td>
                            <td><%= "$" + cuenta.getSaldo() %></td>
                            <td><%= cuenta.getEstado() ? "Activo" : "Inactivo" %></td>
                        </tr>
                        <% 
                        }
                        %>
                    </tbody>
                </table>
                <% 
                } else { 
                %>
                <p>No hay datos disponibles.</p>
                <% 
                } 
                %>
            </div>
        </div>
        
        <div class="row mt-3">
            <div class="col">
                <a href="InformesAdministrador.jsp" class="btn btn-primary">Volver</a>
            </div>
        </div>
    </div>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <jsp:include page="Componentes/Footer.jsp"></jsp:include>
</body>



</html>	
