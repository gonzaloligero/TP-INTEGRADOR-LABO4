package excepciones;


public class ContraseñaDiferente extends Exception{

	public ContraseñaDiferente() {
	
	}

	@Override
	public String getMessage() {
		
		return "Las contraseñas no son iguales!";
	}
	
	
	
	
	
}
