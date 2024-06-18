<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Lista de clientes</title>
	<jsp:include page="Componentes/head.jsp"></jsp:include>
</head>
<body>

	<jsp:include page="Componentes/NavBar.jsp"></jsp:include>

	<div class="container">
	    <div class="w-100 pt-2 text-center">
                <h1 class="mb-5">LISTA DE CLIENTES</h1>
        </div>
		<table id="table_id" class="table table-striped  display text-center">
			<thead>
				<tr>
					<th>Nombre de Usuario</th>
					<th>Nombre y Apellido</th>
					<th>DNI</th>
					<th>CUIL</th>
					<th>Nacionalidad</th>
					<th>Fecha de Nacimiento</th>
					<th>Correo</th>
					<th>Telefono</th>
					<th>Accion</th>
				</tr>
			</thead>
			<tbody>

				<tr>
					<td>PePito</td>
					<td>Pablo Prueba</td>
					<td>11223344</td>
					<td>20-11223344-0</td>
					<td>Argentino</td>
					<td>05/05/2000</td>
					<td>pepito@prueba</td>
					<td>11335544</td>

					<td>
						<button class="btn btn-danger">
							<i class="bi bi-trash"></i>
						</button>
						<button class="btn btn-success">
							<i class="bi bi-pencil-square"></i>
						</button>
					</td>

				</tr>

			</tbody>
		</table>
	</div>

	<jsp:include page="Componentes/Footer.jsp"></jsp:include>
</body>
</html>