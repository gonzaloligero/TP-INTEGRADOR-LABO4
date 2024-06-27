package excepciones;
import entidad.Cliente;

public class UsuarioRepetido extends Exception {

	String MensajeError;
	
	public UsuarioRepetido(String mensajeError) {
		super();
		MensajeError = mensajeError;
	}

	public String getMensajeError() {
		return MensajeError;
	}

	public void setMensajeError() {
		MensajeError = "El usuario ya figura en la base de datos";
	}
	
	public String mensajePersonalizado(Cliente cliente) {
		return "El usuario " + cliente.getUser() + " ya existe en la base de datos. Seleccione otro por favor";
	}

	@Override
	public String toString() {
		return "UsuarioRepetido: " + getMessage();
	}	
	
}


