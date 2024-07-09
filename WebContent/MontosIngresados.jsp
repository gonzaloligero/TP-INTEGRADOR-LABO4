<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Selección de Fechas</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Roboto Condensed', sans-serif;
            background-color: #f0f0f0;
        }
        .container {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .form-group label {
            font-weight: bold;
        }
        .btn-primary {
            background-color: #004a80;
            border-color: #004a80;
        }
        .btn-primary:hover {
            background-color: #00365c;
            border-color: #00365c;
        }
        .list-group-item {
            background-color: #004a80;
            color: #ffffff;
            border-color: #004a80;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="row mb-3">
            <div class="col">
                <h1>Montos ingresados en IT Bank por fecha</h1>
            </div>
        </div>
        
        <form action="ServletMovimientos" method="post">
		<input type="hidden" name="action" value="montos">
        <div class="row mb-3">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="fechaInicio">Fecha de Inicio</label>
                    <input type="date" class="form-control" id="fechaInicio" name="fechaInicio">
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="fechaFin">Fecha de Fin</label>
                    <input type="date" class="form-control" id="fechaFin" name="fechaFin">
                </div>
            </div>
        </div>
        
        <div class="row mb-3">
            <div class="col">
                <button type="submit" class="btn btn-primary">Buscar</button>
            </div>
        </div>
        
        <div class="row">
            <div class="col">
                <ul class="list-group">
				    <li class="list-group-item">Monto Total: ${montoTotal}</li>
				</ul>

            </div>
        </div>
        </form>>
        <div class="row mt-3">
            <div class="col">
                <a href="InformesAdministrador.jsp" class="btn btn-primary">Volver</a>
            </div>
        </div>
    </div>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
