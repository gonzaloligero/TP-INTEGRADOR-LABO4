package excepciones;

public class SaldoInsuficienteException extends Exception {

    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public SaldoInsuficienteException() {
        super("Saldo insuficiente en la cuenta.");
    }

    
    public SaldoInsuficienteException(String message) {
        super(message);
    }

  
    public SaldoInsuficienteException(String message, Throwable cause) {
        super(message, cause);
    }

    
    public SaldoInsuficienteException(Throwable cause) {
        super(cause);
    }
}