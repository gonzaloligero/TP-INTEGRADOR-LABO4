package excepciones;

public class FechaNoValida extends Exception{

	public FechaNoValida() {
		
	}

	@Override
	public String getMessage() {
		
		return "No valido, fecha superior a la fecha actual";
	}
	
	
	
}
