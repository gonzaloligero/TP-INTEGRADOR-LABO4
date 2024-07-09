package excepciones;

public class ParametroInvalido extends Exception {

	String MensajeError;
	
	public ParametroInvalido () {
		super("Error de parametro");
        this.MensajeError = "Error de parametro";
	}
	
	public ParametroInvalido (String mensaje) {
		super(mensaje);
        this.MensajeError = mensaje;
		}

	@Override
	public String getMessage() {
		return MensajeError;
	}

	@Override
	public String toString() {
		return "ParametroInvalido [MensajeError=" + MensajeError + "]";
	}
	
	
}
