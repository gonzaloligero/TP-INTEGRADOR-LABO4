package excepciones;
import entidad.Cliente;

public class ClienteRepetido extends Exception{

	String MensajeError;
			
	public ClienteRepetido(String mensajeError) {
		super();
		MensajeError = mensajeError;
	}

	public String getMensajeError() {
		return "El DNI ya existe!!!";
	}

	public void setMensajeError() {
		MensajeError = "No es posible ingresar el cliente debido a que ya existe en la base de datos";
	}
	
	public String mensajePersonalizado(Cliente cliente) {
		return "El cliente con DNI " + cliente.getDNI() + " ya existe en la base de datos";
	}

	@Override
	public String toString() {
		return "ClienteRepetido: " + getMessage();
	}	
}


