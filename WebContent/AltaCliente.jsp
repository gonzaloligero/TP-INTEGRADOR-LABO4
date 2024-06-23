<%@page import="entidad.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $(function() {
            $("#fechaNacimiento").datepicker({
                dateFormat: "yy-mm-dd"
            });
        });
    </script>
</head>
<body>

    <a href="Principal.jsp">Inicio</a>
    <a href="ServletClientes?Param=insertarGet">Insertar articulos</a>
    <a href="ServletClientes?Param=listar">Listar articulos</a>

    <br />
    <br />

    <form method="post" action="ServletClientes">
        <input type="hidden" name="action" value="insertar" />

        <table>
            <tr>
                <td>Nombre:</td>
                <td><input type="text" name="nombre" /></td>
            </tr>
            <tr>
                <td>Apellido:</td>
                <td><input type="text" name="apellido" required /></td>
            </tr>
            <tr>
                <td>CUIL:</td>
                <td><input type="text" name="cuil" /></td>
            </tr>
            <tr>
                <td>Numero telefónico:</td>
                <td><input type="text" name="teléfono" /></td>
            </tr>
            <tr>
                <td>Fecha de Nacimiento:</td>
                <td><input type="date" name="fechaNacimiento" /></td>
            </tr>
            <tr>
                <td>Localidad:</td>
                <td><input type="text" name="localidad" /></td>
            </tr>
            <tr>
                <td>Código Postal:</td>
                <td><input type="text" name="codigoPostal" /></td>
            </tr>
            <tr>
                <td>Correo:</td>
                <td><input type="email" name="correo" /></td>
            </tr>
            <tr>
                <td>Sexo:</td>
                <td>
                    <select name="sexo">
                        <option value="M">Masculino</option>
                        <option value="F">Femenino</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Calle:</td>
                <td><input type="text" name="calle" /></td>
            </tr>
            <tr>
                <td>Usuario:</td>
                <td><input type="text" name="usuario" /></td>
            </tr>
            <tr>
                <td>DNI:</td>
                <td><input type="text" name="dni" /></td>
            </tr>
            <tr>
                <td>Nacionalidad:</td>
                <td><input type="text" name="nacionalidad" /></td>
            </tr>
            <tr>
                <td>Provincia:</td>
                <td><input type="text" name="provincia" /></td>
            </tr>
            <tr>
                <td>Número:</td>
                <td><input type="text" name="numero" /></td>
            </tr>
            <tr>
                <td>Contraseña:</td>
                <td><input type="password" name="contraseña" /></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" name="btnAceptar" value="Aceptar"></td>
            </tr>
        </table>

    </form>

</body>
</html>
