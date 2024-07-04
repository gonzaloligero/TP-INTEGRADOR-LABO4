package entidad;

import java.math.BigDecimal;
import java.sql.Date;

public class Movimiento {
 
	private int idMovimiento;
	private  Date fecha;
	private String detalle;
	private BigDecimal importe;
	private int idCuentaEmisor;
	private int idCuentaReceptor;
	private String tipoMovimiento;

	
	public Movimiento() {
		this.idMovimiento = 0;
		this.fecha = Date.valueOf("2000-01-01"); ;
		this.detalle = "";
		this.importe = BigDecimal.ZERO;
		this.idCuentaEmisor = 0;
		this.idCuentaReceptor = 0;
		this.tipoMovimiento = "";
	}
	
	
	public Movimiento(int idMovimiento, Date fecha, String detalle, BigDecimal importe, int idCuentaEmisor, int idCuentaReceptor, String tipoMovimiento) {
		super();
		this.idMovimiento = idMovimiento;
		this.fecha = fecha;
		this.detalle = detalle;
		this.importe = importe;
		this.idCuentaEmisor = idCuentaEmisor;
		this.idCuentaReceptor = idCuentaReceptor;
		this.tipoMovimiento = tipoMovimiento;
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


	public int getIdCuentaEmisor() {
		return idCuentaEmisor;
	}


	public void setIdCuentaEmisor(int idCuentaEmisor) {
		this.idCuentaEmisor = idCuentaEmisor;
	}


	public int getIdCuentaReceptor() {
		return idCuentaReceptor;
	}


	public void setIdCuentaReceptor(int idCuentaReceptor) {
		this.idCuentaReceptor = idCuentaReceptor;
	}


	public String getTipoMovimiento() {
		return tipoMovimiento;
	}


	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}


	@Override
	public String toString() {
		return "Movimiento [idMovimiento=" + idMovimiento + ", fecha=" + fecha + ", detalle=" + detalle + ", importe="
				+ importe + ", idCuentaEmisor=" + idCuentaEmisor + ", idCuentaReceptor=" + idCuentaReceptor
				+ ", tipoMovimiento=" + tipoMovimiento + "]";
	}




	
	
	
}

