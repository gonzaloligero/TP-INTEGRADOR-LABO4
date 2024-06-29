package entidad;

public class TipoPrestamos {
	private int IDTipoPrestamo; 
	private int TNA;
	private String Tipo;
	
	
	
	
	//constructores
	public TipoPrestamos(int iDTipoPrestamo, int tna, String tipo) {
		super();
		IDTipoPrestamo = iDTipoPrestamo;
		TNA=tna;
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








	public String getTipo() {
		return Tipo;
	}




	public void setTipo(String tipo) {
		Tipo = tipo;
	}




	public int getTNA() {
		return TNA;
	}




	public void setTNA(int tNA) {
		TNA = tNA;
	}
	
	
	
	 
	

}
