package excepciones;

public class UsuarioNoEncontradoException extends Exception {

	public UsuarioNoEncontradoException(String mensaje) {
        super(mensaje);
    }

    @Override
    public String toString() {
        return "UsuarioNoEncontradoException: " + getMessage();
    }
}
