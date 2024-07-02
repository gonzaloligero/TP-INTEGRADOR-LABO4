package excepciones;

import entidad.Cliente;
import entidad.Cuenta;

public class ClienteExcedeCantCuentas extends Exception{

	String MensajeError;
	
	public ClienteExcedeCantCuentas(String mensajeError) {
		super(mensajeError);
		MensajeError = mensajeError;
	}

	public String getMensajeError() {
		return MensajeError;
	}

	public String mensajePersonalizado(Cuenta cuenta) {
		return "La cuenta con DNI " + cuenta.getDNICliente() + " posee ya 3 cuentas, es el tope maximo permitido";
	}

	@Override
	public String toString() {
		return "ClienteExcedeCantCuentas [MensajeError=" + MensajeError + "]";
	}
	
}
