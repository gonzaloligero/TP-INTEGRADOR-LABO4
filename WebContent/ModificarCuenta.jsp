<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="Componentes/head.jsp"></jsp:include>

<style>
   .contenedor {
     
    display: flex;
    flex-direction: column; /* Coloca los elementos en columna */
    align-items: center; /* Centra los elementos horizontalmente */
    gap: 2rem; /* Espacio entre los elementos */
    /* Opcional: para centrar el contenedor en la página */
    justify-content: center; /* Centra los elementos verticalmente dentro del contenedor */
    padding-top: 4rem;
     
   }

</style>

</head>

 <body>  
    <jsp:include page="Componentes/NavBar.jsp"></jsp:include>  
    <div class="container">
    <div class="w-100 pt-2 text-center">
        <h1>MODIFICAR CUENTA</h1>
    </div>
<%  
    String idCuenta = request.getParameter("id");
%>
    <form action="ServletCuentas" method="post">  
    	<div class="contenedor">  	
    		<div>
             <label>ID CUENTA</label>
             
              <!-- Campo oculto para enviar el valor al servidor -->
		    <input type="hidden" name="idcuenta" value="<%= idCuenta != null ? idCuenta : "" %>">
               <!-- Campo de texto solo lectura para mostrar el valor -->
		     <input type="text" value="<%= idCuenta != null ? idCuenta : "" %>" readonly>		              	
           </div>        
	       <div>
		    <label> Saldo </label> 
		    <input type="number" name="saldo" placeholder="Ingrese el saldo..." min="0.00" required>
	       </div>		 
          <button type="submit" name="btnGuardarCambios" class="btn btn-primary">Guardar Cambios</button> 	
    	</div>	     
    </form>
    
    <div class="container mt-3">
        <a href="ServletCuentas?action=listarCuentasGral" class="btn btn-secondary">Volver</a>
    </div>
</div>
     
   <jsp:include page="Componentes/Footer.jsp"></jsp:include>
 </body>
</html>