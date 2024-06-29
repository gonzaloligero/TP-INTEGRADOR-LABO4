<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.9.1/font/bootstrap-icons.min.css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="CSS/style.css" type="text/css" rel="stylesheet" />
	<title>Insert title here</title>
	
	<style>
	
	    * {
	      padding: 0;
	      margin: 0;
	      box-sizing: border-box;
	    }
		body {
		
		    background-color: white;	
			min-height: 100vh;
			display: grid;
			place-items: center;
			font-family: sans-serif;				 
		}	
		
		.logoContenedor {	   
		   display: flex;
		   align-items:center;	   
		   justify-content: center; 	  
		   height: 100px;
	       width: 100px;
	       border-radius: 100%;
	       gap: 6px;
	       border: 5px solid #100934;
	      
		}
		
		.logo {
		  font-size: 18px;
		  font-weight: 600;
		}
		
	    h2{
	      text-align: center;
		  width: 100%;	
		  font-size: 32px;  	 	  
		}
			
		.sectionLogin {
		   display: flex;
		   flex-direction: column;
		   justify-content: start;
		   align-items: center;
		   height: 500px;
	       width: 380px;
		   box-shadow: 10px 10px 25px #100934;
		   padding: 40px;
		   border-radius: 15px;
		   gap: 25px;
		   
		}
		
		.formularioLogin{	  		 
		  display: flex;
          flex-direction: column;
          gap: 20px;     
          width:100%;         
		}
		
		.form-control {	
			 	  
			   display: flex;
			   flex-direction: column;
			   gap:4px;
			   
			   & input {
			      padding:10px;
			      border-radius: 5px;
			      outline: none;
			      border: 1px solid lightgray;	      
			   }
			   
			   & input:focus {
			   
			    border: 1px solid blue;
			   }
			   
			   & label {
			    font-size:14px;	   
			   }
	   	  
		}
		
		.btnPrincipal {
		      padding:10px;
		      border-radius: 5px;
		      cursor: pointer;
		      background: #100934;
		      color: white;
		      border:none;
		      font-size:16px;
		      font-weight: 600;
		    &:hover {
		      background: white;
		      color: #100934;
		      border: 1px solid #100934;
		      font-weight: 600;
		    }  
		}
			
		
	</style>
</head>


<body>

   <main>
	<section class="sectionLogin">	
	     <div class="logoContenedor">
	       <i class="bi bi-bank fs-1 "></i> <p class="logo">ITBank</p>
	     </div>	    	    
		 <h2>Inicia sesión</h2>
		 
		 <form class="formularioLogin" method=post action="ServletLogin">
		     <div class="form-control">
		       <label for="email" class=""> Usuario: </label> 
		       <input   type="text" name="email" placeholder="Ingrese su Usuario..." required >
		     </div>
		     
		     <div class="form-control">
		         <label for="contrasenia">Contraseña: </label>  
		         <input type="password" name="contrasenia" placeholder="Ingrese su contraseña..." required>
		     </div>
		      
		     <input type="submit" name="btnIniciarSesion" value="Iniciar Sesión" class="btnPrincipal">
		     
		 </form>
	 </section>
	
   </main>  
	 
</body>
</html>	
