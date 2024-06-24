<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Préstamos solicitados</title>
</head>
<jsp:include page="Componentes/head.jsp"></jsp:include>
  
   <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<style>
    body {
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            min-height: 100vh;
            margin: 0;
        }
        .btn-fixed-size {
            width: 150px; /* Establece el ancho fijo del botón */
            height: 50px; /* Establece la altura fija del botón */
        }
    </style>
</head>
<body>
 <jsp:include page="Componentes/NavBar.jsp"></jsp:include>
 
 <h1> Prestamos solicitados</h1>
 <a class="btn bg-azul fw-bold bi bi-person-plus fs-5 mb-3 btn-fixed-size " href="MenuAdministrador.jsp">Volver</a>
 
 
 <jsp:include page="Componentes/Footer.jsp"></jsp:include>
</body>
</html>