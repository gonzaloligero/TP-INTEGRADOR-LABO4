package entidad;

public class TipoPrestamos {
	private int IDTipoPrestamo; 
	private int IDPrestamo;
	private String Tipo;
	
	
	
	
	//constructores
	public TipoPrestamos(int iDTipoPrestamo, int iDPrestamo, String tipo) {
		super();
		IDTipoPrestamo = iDTipoPrestamo;
		IDPrestamo = iDPrestamo;
		Tipo = tipo;
	}




	public TipoPrestamos() {
		super();
		// TODO Auto-generated constructor stub
	}


// Getters y Setters

	public int getIDTipoPrestamo() {
		return IDTipoPrestamo;
	}




	public void setIDTipoPrestamo(int iDTipoPrestamo) {
		IDTipoPrestamo = iDTipoPrestamo;
	}




	public int getIDPrestamo() {
		return IDPrestamo;
	}




	public void setIDPrestamo(int iDPrestamo) {
		IDPrestamo = iDPrestamo;
	}




	public String getTipo() {
		return Tipo;
	}




	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	
	
	
	 
	

}
