<%@page import="entidad.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Modificar Cliente</title>
    <jsp:include page="Componentes/head.jsp"></jsp:include>
</head>
<body>
    <jsp:include page="Componentes/NavBar.jsp"></jsp:include>

    <div class="container">
        <div class="w-100 pt-2 text-center">
            <h1 class="mb-5">Modificar Cliente</h1>
        </div>

        <%
            Cliente cliente = (Cliente) request.getAttribute("cliente");
            if (cliente != null) {
        %>
        <form action="ServletClientes" method="post">
            <input type="hidden" name="action" value="actualizar">
            <input type="hidden" name="id" value="<%= cliente.getIDUsuario() %>">
            
            <div class="mb-3">
                <label for="user" class="form-label">Usuario</label>
                <input type="text" class="form-control" id="user" name="user" value="<%= cliente.getUser() %>" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Contraseña</label>
                <input type="password" class="form-control" id="password" name="password" value="<%= cliente.getPassword() %>" required>
            </div>
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre</label>
                <input type="text" class="form-control" id="nombre" name="nombre" value="<%= cliente.getNombre() %>" required>
            </div>
            <div class="mb-3">
                <label for="apellido" class="form-label">Apellido</label>
                <input type="text" class="form-control" id="apellido" name="apellido" value="<%= cliente.getApellido() %>" required>
            </div>
            <div class="mb-3">
                <label for="dni" class="form-label">DNI</label>
                <input type="text" class="form-control" id="dni" name="dni" value="<%= cliente.getDNI() %>" required>
            </div>
            <div class="mb-3">
                <label for="cuil" class="form-label">CUIL</label>
                <input type="text" class="form-control" id="cuil" name="cuil" value="<%= cliente.getCUIL() %>" required>
            </div>
            <div class="mb-3">
                <label for="nacionalidad" class="form-label">Nacionalidad</label>
                <input type="text" class="form-control" id="nacionalidad" name="nacionalidad" value="<%= cliente.getNacionalidad() %>" required>
            </div>
            <div class="mb-3">
                <label for="sexo" class="form-label">Sexo</label>
                <input type="text" class="form-control" id="sexo" name="sexo" value="<%= cliente.getSexo() %>" required>
            </div>
            <div class="mb-3">
                <label for="fechaNacimiento" class="form-label">Fecha de Nacimiento</label>
                <input type="date" class="form-control" id="fechaNacimiento" name="fechaNacimiento" value="<%= cliente.getFechaNacimiento() %>" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Correo</label>
                <input type="email" class="form-control" id="email" name="email" value="<%= cliente.getEmail() %>" required>
            </div>
            <div class="mb-3">
                <label for="numeroTelefonico" class="form-label">Telefono</label>
                <input type="text" class="form-control" id="numeroTelefonico" name="numeroTelefonico" value="<%= cliente.getNumeroTelefonico() %>" required>
            </div>
            <div class="mb-3">
                <label for="calle" class="form-label">Calle</label>
                <input type="text" class="form-control" id="calle" name="calle" value="<%= cliente.getDireccion().getCalle() %>" required>
            </div>
            <div class="mb-3">
                <label for="numero" class="form-label">Número</label>
                <input type="text" class="form-control" id="numero" name="numero" value="<%= cliente.getDireccion().getNumero() %>" required>
            </div>
            <div class="mb-3">
                <label for="localidad" class="form-label">Localidad</label>
                <input type="text" class="form-control" id="localidad" name="localidad" value="<%= cliente.getDireccion().getLocalidad() %>" required>
            </div>
            <div class="mb-3">
                <label for="provincia" class="form-label">Provincia</label>
                <input type="text" class="form-control" id="provincia" name="provincia" value="<%= cliente.getDireccion().getProvincia() %>" required>
            </div>
            <button type="submit" class="btn btn-primary">Guardar Cambios</button>
        </form>
        <%
            } else {
        %>
        <p>No se encontró el cliente.</p>
        <%
            }
        %>
    </div>

    <jsp:include page="Componentes/Footer.jsp"></jsp:include>
</body>
</html>
