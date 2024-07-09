package excepciones;

public class CuentaErrorOperacion extends Exception {

	String MensajeError;
	
	public CuentaErrorOperacion() {
		super("La cuenta no se pudo desactivar.");
        this.MensajeError = "La cuenta no se pudo desactivar.";
	}
	
	public CuentaErrorOperacion(String mensaje) {
        super(mensaje);
        this.MensajeError = mensaje;
    }

	@Override
	public String getMessage() {
		
		return MensajeError;
	}

	@Override
	public String toString() {
		return "CuentaErrorOperacion [MensajeError=" + MensajeError + "]";
	}
	
	
}
