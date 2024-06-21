package entidad;

public class Plazos {
	private int IDPlazo;
	private int IDPrestamo;
	private String MesQuePaga;
	private  int NroCuota;
	
	
	//Constructores
	
	public Plazos() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Plazos(int iDPlazo, int iDPrestamo, String mesQuePaga, int nroCuota) {
		super();
		IDPlazo = iDPlazo;
		IDPrestamo = iDPrestamo;
		MesQuePaga = mesQuePaga;
		NroCuota = nroCuota;
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
	@Override
	public String toString() {
		return "Plazos [IDPlazo=" + IDPlazo + ", IDPrestamo=" + IDPrestamo + ", MesQuePaga=" + MesQuePaga
				+ ", NroCuota=" + NroCuota + "]";
	}
	
	
	

}
