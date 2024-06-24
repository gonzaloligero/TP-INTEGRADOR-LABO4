<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entidad.Cliente" %>
<%@ page import="entidad.Direccion" %>
<%@ page import="negocioImpl.ClienteNegImpl" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modificar Cliente</title>
    <jsp:include page="Componentes/head.jsp"></jsp:include>
    <script>
        function autocompletarCliente() {
            var clienteSelect = document.getElementById("clienteSelect");
            var selectedOption = clienteSelect.options[clienteSelect.selectedIndex];

            document.getElementById("nombre").value = selectedOption.getAttribute("data-nombre");
            document.getElementById("apellido").value = selectedOption.getAttribute("data-apellido");
            document.getElementById("cuil").value = selectedOption.getAttribute("data-cuil");
            document.getElementById("nacionalidad").value = selectedOption.getAttribute("data-nacionalidad");
            document.getElementById("sexo").value = selectedOption.getAttribute("data-sexo");

            var fechaNacimientoISO = selectedOption.getAttribute("data-fecha-nacimiento");
            var fechaNacimiento = new Date(fechaNacimientoISO);
            var fechaFormateada = fechaNacimiento.toISOString().split('T')[0];
            document.getElementById("fechaNacimiento").value = fechaFormateada;

            document.getElementById("email").value = selectedOption.getAttribute("data-email");
            document.getElementById("numeroTelefonico").value = selectedOption.getAttribute("data-numero-telefonico");
            document.getElementById("calle").value = selectedOption.getAttribute("data-calle");
            document.getElementById("numero").value = selectedOption.getAttribute("data-numero");
            document.getElementById("localidad").value = selectedOption.getAttribute("data-localidad");
            document.getElementById("provincia").value = selectedOption.getAttribute("data-provincia");
        }
    </script>
</head>
<body>
<%
    ClienteNegImpl clienteNegImpl = new ClienteNegImpl();
    ArrayList<Direccion> provincias = clienteNegImpl.listarProvincias();
    ArrayList<Direccion> localidades = clienteNegImpl.listarLocalidades();
    Cliente nuevoRegistro = (Cliente) request.getAttribute("cliente");
%>
<jsp:include page="Componentes/NavBar.jsp"></jsp:include>

<div class="container">
    <div class="w-100 pt-2 text-center">
        <h1 class="mb-5">Modificar Cliente</h1>
    </div>

    <form action="ServletClientes" method="post">
        <input type="hidden" name="action" value="actualizar">
        <input type="hidden" name="id" value="<%= nuevoRegistro.getDNI() %>">

        <div class="mb-3 col-12">
            <label for="clienteSelect" class="form-label">Selecciona un Cliente</label>
            <select class="form-control" id="clienteSelect" name="dni" onchange="autocompletarCliente()">
                <option value="">Selecciona un cliente</option>
                <% 
                    ArrayList<Cliente> listaClientes = (ArrayList<Cliente>) request.getAttribute("listaClientes");
                    if (listaClientes != null) {
                        for (Cliente cliente : listaClientes) { 
                %>
                    <option value="<%= cliente.getDNI() %>"
                            data-nombre="<%= cliente.getNombre() %>"
                            data-apellido="<%= cliente.getApellido() %>"
                            data-cuil="<%= cliente.getCUIL() %>"
                            data-nacionalidad="<%= cliente.getNacionalidad() %>"
                            data-sexo="<%= cliente.getSexo() %>"
                            data-fecha-nacimiento="<%= cliente.getFechaNacimiento() %>"
                            data-email="<%= cliente.getEmail() %>"
                            data-numero-telefonico="<%= cliente.getNumeroTelefonico() %>"
                            data-calle="<%= cliente.getDireccion().getCalle() %>"
                            data-numero="<%= cliente.getDireccion().getNumero() %>"
                            data-localidad="<%= cliente.getDireccion().getLocalidad() %>"
                            data-provincia="<%= cliente.getDireccion().getProvincia() %>">
                        <%= cliente.getDNI() %> - <%= cliente.getNombre() %> <%= cliente.getApellido() %>
                    </option>
                <% 
                        }
                    }
                %>
            </select>
        </div>

        <div class="row">
            <div class="col-md-6">
                <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" value="<%= nuevoRegistro.getNombre() %>" required>
                </div>

                <div class="mb-3">
                    <label for="apellido" class="form-label">Apellido</label>
                    <input type="text" class="form-control" id="apellido" name="apellido" value="<%= nuevoRegistro.getApellido() %>" required>
                </div>

                <div class="mb-3">
                    <label for="cuil" class="form-label">CUIL</label>
                    <input type="text" class="form-control" id="cuil" name="cuil" value="<%= nuevoRegistro.getCUIL() %>" required>
                </div>

                <div class="mb-3">
                    <label for="nacionalidad" class="form-label">Nacionalidad</label>
                    <input type="text" class="form-control" id="nacionalidad" name="nacionalidad" value="<%= nuevoRegistro.getNacionalidad() %>" required>
                </div>
                <div class="mb-3">
                    <label for="sexo" class="form-label">Sexo</label>
                    <input type="text" class="form-control" id="sexo" name="sexo" value="<%= nuevoRegistro.getSexo() %>" required>
                </div>

                <div class="mb-3">
                    <label for="fechaNacimiento" class="form-label">Fecha de Nacimiento</label>
                    <input type="date" class="form-control" id="fechaNacimiento" name="fechaNacimiento" value="<%= nuevoRegistro.getFechaNacimiento() %>" required>
                </div>
                
            </div>

            <div class="col-md-6">


                <div class="mb-3">
                    <label for="email" class="form-label">Correo</label>
                    <input type="email" class="form-control" id="email" name="email" value="<%= nuevoRegistro.getEmail() %>" required>
                </div>

                <div class="mb-3">
                    <label for="numeroTelefonico" class="form-label">Telefono</label>
                    <input type="text" class="form-control" id="numeroTelefonico" name="numeroTelefonico" value="<%= nuevoRegistro.getNumeroTelefonico() %>" required>
                </div>

                <div class="mb-3">
                    <label for="calle" class="form-label">Calle</label>
                    <input type="text" class="form-control" id="calle" name="calle" value="<%= nuevoRegistro.getDireccion().getCalle() %>" required>
                </div>

                <div class="mb-3">
                    <label for="numero" class="form-label">Número</label>
                    <input type="text" class="form-control" id="numero" name="numero" value="<%= nuevoRegistro.getDireccion().getNumero() %>" required>
                </div>

                <div class="mb-3">
                    <label for="localidad" class="form-label">Localidad</label>
                    <input type="text" class="form-control" id="localidad" name="localidad" value="<%= nuevoRegistro.getDireccion().getLocalidad() %>" required>
                </div>

                <div class="form-group">
                    <label for="provincia">Provincia</label>
                    <select class="form-control" id="provincia" name="provincia" required>
                        <option value="" disabled selected>Seleccione una provincia</option>
                        <% 
                            for (Direccion provincia : provincias) {
                        %>
                            <option value="<%= provincia.getProvincia() %>" <%= provincia.getProvincia().equals(nuevoRegistro.getDireccion().getProvincia()) ? "selected" : "" %>>
                                <%= provincia.getProvincia() %>
                            </option>
                        <% 
                            }
                        %>
                    </select>
                </div>
            </div>
        </div>

        <button type="submit" class="btn btn-primary">Guardar Cambios</button>
    </form>
    
    <div class="container mt-3">
        <a href="ServletClientes?action=listar" class="btn btn-secondary">Volver</a>
    </div>
</div>

<jsp:include page="Componentes/Footer.jsp"></jsp:include>
</body>
</html>
