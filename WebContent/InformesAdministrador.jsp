<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
    </style>


</head>

<body>

	  <jsp:include page="Componentes/NavBar.jsp"></jsp:include>
	 <main> 
	 <h1>Página informes de administrador</h1>
	 <a class="btn bg-azul fw-bold bi bi-person-plus fs-5 mb-3" href="MenuAdministrador.jsp">Volver</a>
	 </main>
	 <jsp:include page="Componentes/Footer.jsp"></jsp:include>
	 
</body>
</html>