package excepciones;


public class ContraseñaDiferente extends Exception{

	public ContraseñaDiferente() {
		super("Las excepciones no son iguales. Por favor, revíselas para que coincidan");
	}
	
}
