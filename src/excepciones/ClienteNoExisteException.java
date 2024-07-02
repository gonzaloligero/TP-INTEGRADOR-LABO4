package excepciones;

import entidad.Cuenta;

public class ClienteNoExisteException extends Exception {
	
	String MenjajeDeError;
	
	public ClienteNoExisteException(String mensajeError) {
	    super(mensajeError);
	    this.MenjajeDeError = mensajeError;
	}

	public String getMenjajeDeError() {
		return MenjajeDeError;
	}

	public String mensajePersonalizado() {
		return "No se puede crear la cuenta, porque el cliente es inexistente.";
	}

	@Override
	public String toString() {
		return mensajePersonalizado();
	}
}
