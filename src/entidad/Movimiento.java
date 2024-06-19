package entidad;

import java.math.BigDecimal;
import java.sql.Date;

public class Movimiento {
 
	private int idMovimiento;
	private  Date fecha;
	private String detalle;
	private BigDecimal importe;
	private int idCuenta;
	
	
	public Movimiento() {
		this.idMovimiento = 0;
		this.fecha = Date.valueOf("2000-01-01"); ;
		this.detalle = "";
		this.importe = BigDecimal.ZERO;
		this.idCuenta = 0;
	}
	
	
	public Movimiento(int idMovimiento, Date fecha, String detalle, BigDecimal importe, int idCuenta) {
		super();
		this.idMovimiento = idMovimiento;
		this.fecha = fecha;
		this.detalle = detalle;
		this.importe = importe;
		this.idCuenta = idCuenta;
	}
	
	

	public int getIdMovimiento() {
		return idMovimiento;
	}


	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getDetalle() {
		return detalle;
	}


	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}


	public BigDecimal getImporte() {
		return importe;
	}


	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}


	public int getIdCuenta() {
		return idCuenta;
	}


	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}


	@Override
	public String toString() {
		return "Movimiento idMovimiento=" + idMovimiento + ", fecha=" + fecha + ", detalle=" + detalle + ", importe="
				+ importe + ", idCuenta=" + idCuenta ;
	}
	
	
}

