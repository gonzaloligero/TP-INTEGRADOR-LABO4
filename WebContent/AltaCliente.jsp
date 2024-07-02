<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Direccion"%>
<%@page import="negocioImpl.ClienteNegImpl"%>
<!DOCTYPE html>
<html>
<head>
<title>Alta Cliente</title>
<jsp:include page="Componentes/head.jsp"></jsp:include>
<style type="text/css">
label {
	font-weight: bold;
	margin-top: 15px;
}
</style>
</head>
<body>

	<%
		ClienteNegImpl clienteNegImpl = new ClienteNegImpl(); // 
		ArrayList<Direccion> provincias = clienteNegImpl.listarProvincias();
		ArrayList<Direccion> localidades = clienteNegImpl.listarLocalidades();
	%>

	<jsp:include page="Componentes/NavBar.jsp"></jsp:include>



	<div class="row flex-grow-1 m-0">

		<div class="col-lg-9 d-flex flex-column justify-content-between">
			<div class="w-100 pt-2 text-center">
				<h1 class="mb-5">DAR DE ALTA CLIENTE</h1>
			</div>
			<div>

				<form action="ServletClientes" method="post">
					<input type="hidden" name="action" value="alta">

					<div class="row justify-content-center">

						<div class="col-md-3">
							<div class="form-group">
								<label for="nombre">Nombre</label> <input 
									type="text" class="form-control" name="nombre" id="nombre"
									placeholder="Ingrese el nombre" required>
							</div>
							<div class="form-group">
								<label for="cuil">CUIL</label> <input
									type="text" class="form-control" name="cuil" id="cuil"
									placeholder="Ingrese el CUIL" required>
							</div>
							<div class="form-group">
								<label for="fechaNacimiento">Fecha de Nacimiento</label> <input
									type="date" class="form-control" name="fechaNacimiento"
									id="fechaNacimiento"
									placeholder="Ingrese la fecha de nacimiento" required>
							</div>


							<div class="form-group">
								<label for="localidad">Localidad</label> <input
									type="text" class="form-control"
									name="localidad" id="localidad"
									placeholder="Ingrese su localidad" required>
							</div>

							<div class="form-group">
								<label for="codigoPostal">C�digo Postal</label> <input
									type="number" class="form-control"
									name="codigoPostal" id="codigoPostal"
									placeholder="Ingrese el c�digo postal" required>
							</div>
						</div>


						<div class="col-md-3">
							<div class="form-group">
								<label for="apellido">Apellido</label> <input
									type="text" class="form-control" name="apellido" id="apellido"
									placeholder="Ingrese el apellido" required>
							</div>
							<div class="form-group">
								<label for="correo">Correo</label> 
								<input type="email" class="form-control" id="correo"
									placeholder="Ingrese el correo" name="correo" required>
							</div>

							<div class="form-group">
								<label for="tel�fono">Tel�fono</label> <input 
									type="number" class="form-control" id="correo"
									placeholder="Ingrese el n�mero telef�nico" name="tel�fono"
									required>
							</div>

							<div class="form-group">
								<label for="sexo">G�nero</label> <select class="form-control"
									id="sexo" required name="sexo">
									<option value="Masculino">Masculino</option>
									<option value="Femenino">Femenino</option>
								</select>
							</div>
							<div class="form-group">
								<label for="calle">Calle</label> <input
									type="text" class="form-control" name="calle" id="calle"
									placeholder="Ingrese la calle" required>
							</div>
							<div class="form-group">
								<label for="usuario">Nombre de Usuario</label> <input
								    type="text" class="form-control" id="usuario"
									placeholder="Ingrese el nombre de usuario" name="usuario"
									required>
							</div>
						</div>


						<div class="col-md-3">
							<div class="form-group">
								<label for="dni">DNI</label> <input type="number"
									class="form-control" name="dni" id="dni"
									placeholder="Ingrese el DNI" required>
							</div>
							<div class="form-group">
								<label for="nacionalidad">Nacionalidad</label> <select
									class="form-control" name="nacionalidad" id="nacionalidad"
									required>
									<option value="">Seleccione su nacionalidad</option>
									<option value="Argentina" selected >Argentina</option>
									<option value="Australia">Australia</option>
									<option value="Alemania">Alemania</option>
									<option value="Austria">Austria</option>
									<option value="B�lgica">B�lgica</option>
									<option value="Brasil">Brasil</option>
									<option value="Canad�">Canad�</option>
									<option value="Chile">Chile</option>
									<option value="China">China</option>
									<option value="Colombia">Colombia</option>
									<option value="Corea del Sur">Corea del Sur</option>
									<option value="Dinamarca">Dinamarca</option>
									<option value="Egipto">Egipto</option>
									<option value="Emiratos �rabes Unidos">Emiratos �rabes
										Unidos</option>
									<option value="Espa�a">Espa�a</option>
									<option value="Estados Unidos">Estados Unidos</option>
									<option value="Filipinas">Filipinas</option>
									<option value="Finlandia">Finlandia</option>
									<option value="Francia">Francia</option>
									<option value="Grecia">Grecia</option>
									<option value="India">India</option>
									<option value="Indonesia">Indonesia</option>
									<option value="Irlanda">Irlanda</option>
									<option value="Israel">Israel</option>
									<option value="Italia">Italia</option>
									<option value="Jap�n">Jap�n</option>
									<option value="Malasia">Malasia</option>
									<option value="M�xico">M�xico</option>
									<option value="Noruega">Noruega</option>
									<option value="Nueva Zelanda">Nueva Zelanda</option>
									<option value="Pa�ses Bajos">Pa�ses Bajos</option>
									<option value="Pakist�n">Pakist�n</option>
									<option value="Per�">Per�</option>
									<option value="Polonia">Polonia</option>
									<option value="Portugal">Portugal</option>
									<option value="Reino Unido">Reino Unido</option>
									<option value="Rep�blica Checa">Rep�blica Checa</option>
									<option value="Rusia">Rusia</option>
									<option value="Singapur">Singapur</option>
									<option value="Sud�frica">Sud�frica</option>
									<option value="Suecia">Suecia</option>
									<option value="Suiza">Suiza</option>
									<option value="Tailandia">Tailandia</option>
									<option value="Turqu�a">Turqu�a</option>
									<option value="Ucrania">Ucrania</option>
									<option value="Uruguay">Uruguay</option>
									<option value="Venezuela">Venezuela</option>
									<option value="Vietnam">Vietnam</option>
								</select>
							</div>

							<div class="form-group">
								<label for="provincia">Provincia</label> <select
									class="form-control" id="provincia"
									name="provincia" required>
									<option value="" disabled selected>Seleccione una
										provincia</option>
									<%
										for (Direccion provincia : provincias) {
									%>
									<option value="<%=provincia.getProvincia()%>"><%=provincia.getProvincia()%></option>
									<%
										}
									%>
								</select>
							</div>
							<div class="form-group">
								<label for="numero">N�mero</label> <input 
									type="number" class="form-control" name="numero" id="numero"
									placeholder="Ingrese el n�mero" required>
							</div>
							<div class="form-group">
								<label for="contrase�a">Contrase�a</label> <input 
									type="password" class="form-control" id="contrase�a"
									name="contrase�a" placeholder="Ingrese la contrase�a" required>
							</div>
							<div class="form-group">
								<label for="contrase�a2">Reitere la contrase�a</label> <input
									type="password" class="form-control"
									id="contrase�a2" name="contrase�a2"
									placeholder="Repita la contrase�a" required>
								<div id="contrase�aError" class="text-danger">
									<%=request.getAttribute("contrase�aError") != null ? request.getAttribute("contrase�aError") : ""%>
								</div>
							</div>

							<div class="mt-3">
								<button type="submit" class="btn btn-primary">Confirmar
									Alta</button>
								<a href="Home.jsp" class="btn btn-primary">Inicio</a>
							</div>

						</div>

					</div>

				</form>


			</div>
			<div class="container">

				<a href="ServletClientes?action=listar" class="btn btn-secondary">Volver</a>
			</div>
		</div>
	</div>


	<jsp:include page="Componentes/Footer.jsp"></jsp:include>

	<jsp:include page="Componentes/script_validaciones_front.jsp"></jsp:include>






</body>
</html>
