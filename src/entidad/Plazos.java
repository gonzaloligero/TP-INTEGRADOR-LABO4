package entidad;

public class Plazos {
	private int IDPlazo;
	private int IDPrestamo;
	private String MesQuePaga;
	private double ImporteAPagarCuotas;
	private  int NroCuota;
	private boolean Estado;
	
	
	//Constructores
	
	public Plazos() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	public Plazos(int iDPlazo, int iDPrestamo, String mesQuePaga, double importeAPagarCuotas, int nroCuota,
			boolean estado) {
		super();
		IDPlazo = iDPlazo;
		IDPrestamo = iDPrestamo;
		MesQuePaga = mesQuePaga;
		ImporteAPagarCuotas = importeAPagarCuotas;
		NroCuota = nroCuota;
		Estado = estado;
	}




	//Getters y Setter
	public int getIDPlazo() {
		return IDPlazo;
	}
	public void setIDPlazo(int iDPlazo) {
		IDPlazo = iDPlazo;
	}
	public int getIDPrestamo() {
		return IDPrestamo;
	}
	public void setIDPrestamo(int iDPrestamo) {
		IDPrestamo = iDPrestamo;
	}
	public String getMesQuePaga() {
		return MesQuePaga;
	}
	public void setMesQuePaga(String mesQuePaga) {
		MesQuePaga = mesQuePaga;
	}
	public int getNroCuota() {
		return NroCuota;
	}
	public void setNroCuota(int nroCuota) {
		NroCuota = nroCuota;
	}
	
	public double getImporteAPagarCuotas() {
		return ImporteAPagarCuotas;
	}
	public void setImporteAPagarCuotas(double importeAPagarCuotas) {
		ImporteAPagarCuotas = importeAPagarCuotas;
	}



	public boolean isEstado() {
		return Estado;
	}



	public void setEstado(boolean estado) {
		Estado = estado;
	}




	@Override
	public String toString() {
		return "Plazos [IDPlazo=" + IDPlazo + ", IDPrestamo=" + IDPrestamo + ", MesQuePaga=" + MesQuePaga
				+ ", ImporteAPagarCuotas=" + ImporteAPagarCuotas + ", NroCuota=" + NroCuota + ", Estado=" + Estado
				+ "]";
	}
	
	
	
	
	

}
