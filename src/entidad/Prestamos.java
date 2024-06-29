package entidad;

import java.util.Date;

public class Prestamos {
	private int IDPrestamo;
	private int IDTipoPrestamo;
	private int DNICliente;
	private double MontoPedido; 
	private double ImporteAPagar;
	private int Cuotas;
	private Date Fecha;
	private boolean Estado;
	
	
	
	//constructores
	
	public Prestamos() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Prestamos(int iDPrestamo, int iDTipoPrestamo, int dNICliente, double montoPedido, double importeAPagar,
			int cuotas, Date fecha, boolean estado) {
		super();
		IDPrestamo = iDPrestamo;
		IDTipoPrestamo = iDTipoPrestamo;
		DNICliente = dNICliente;
		MontoPedido = montoPedido;
		ImporteAPagar = importeAPagar;
		Cuotas = cuotas;
		Fecha = fecha;
		Estado = estado;
	}



	//Getter y setter
	public int getIDPrestamo() {
		return IDPrestamo;
	}
	public void setIDPrestamo(int iDPrestamo) {
		IDPrestamo = iDPrestamo;
	}
	public int getDNICliente() {
		return DNICliente;
	}
	public void setDNICliente(int dNICliente) {
		DNICliente = dNICliente;
	}
	public double getMontoPedido() {
		return MontoPedido;
	}
	public void setMontoPedido(double montoPedido) {
		MontoPedido = montoPedido;
	}
	public double getImporteAPagar() {
		return ImporteAPagar;
	}
	public void setImporteAPagar(double importeAPagar) {
		ImporteAPagar = importeAPagar;
	}
	public int getCuotas() {
		return Cuotas;
	}
	public void setCuotas(int cuotas) {
		Cuotas = cuotas;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public boolean isEstado() {
		return Estado;
	}
	public void setEstado(boolean estado) {
		Estado = estado;
	}

	public int getIDTipoPrestamo() {
		return IDTipoPrestamo;
	}
	public void setIDTipoPrestamo(int iDTipoPrestamo) {
		IDTipoPrestamo = iDTipoPrestamo;
	}



	@Override
	public String toString() {
		return "Prestamos [IDPrestamo=" + IDPrestamo + ", IDTipoPrestamo=" + IDTipoPrestamo + ", DNICliente="
				+ DNICliente + ", MontoPedido=" + MontoPedido + ", ImporteAPagar=" + ImporteAPagar + ", Cuotas="
				+ Cuotas + ", Fecha=" + Fecha + ", Estado=" + Estado + "]";
	}

	
	
	
	
	
	
	
	

}
