package excepciones;


public class Contrase�aDiferente extends Exception{

	public Contrase�aDiferente() {
	
	}

	@Override
	public String getMessage() {
		
		return "Las contrase�as no son iguales!";
	}
	
	
	
	
	
}
