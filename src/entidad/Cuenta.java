package entidad;

import java.sql.Date;
import java.util.ArrayList;

public class Cuenta {
    private int IDCuenta;
    private int DNICliente;
    private Date FechaCreacion;
    private int NumeroCuenta;
    private String CBU;
    private double Saldo;
    private int IDTipoCuenta;
    
    
    
    public Cuenta() { 	
    	this.IDCuenta = 0;
        this.DNICliente = 0;
        this.FechaCreacion = Date.valueOf("2020-02-01");
        this.NumeroCuenta = 0;
        this.CBU = "";
        this.Saldo = 0;
        this.IDTipoCuenta=0;
        
	
    }
  
    
    public Cuenta(int IDCuenta, int DNICliente, Date FechaCreacion, int NumeroCuenta, String CBU, double Saldo, int IDTipoCuenta) {
        this.IDCuenta = IDCuenta;
        this.DNICliente = DNICliente;
        this.FechaCreacion = FechaCreacion;
        this.NumeroCuenta = NumeroCuenta;
        this.CBU = CBU;
        this.Saldo = Saldo;
        this.IDTipoCuenta=IDTipoCuenta;
        
    }


    public int getIDCuenta() {
        return IDCuenta;
    }

    public void setIDCuenta(int IDCuenta) {
        this.IDCuenta = IDCuenta;
    }

    public int getDNICliente() {
        return DNICliente;
    }

    public void setDNICliente(int DNICliente) {
        this.DNICliente = DNICliente;
    }

    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(Date FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }

    public int getNumeroCuenta() {
        return NumeroCuenta;
    }

    public void setNumeroCuenta(int NumeroCuenta) {
        this.NumeroCuenta = NumeroCuenta;
    }

    public String getCBU() {
        return CBU;
    }

    public void setCBU(String CBU) {
        this.CBU = CBU;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }
    
    public double getIDTipoCuenta() {
        return IDTipoCuenta;
    }

    public void setIDTipoCuenta(int IDTipoCuenta) {
        this.IDTipoCuenta = IDTipoCuenta;
    }
       
    
   
    @Override
	public String toString() {
		return "Cuenta IDCuenta=" + IDCuenta + ", DNICliente=" + DNICliente + ", FechaCreacion=" + FechaCreacion
				+ ", NumeroCuenta=" + NumeroCuenta + ", CBU=" + CBU + ", Saldo=" + Saldo + ", IDTipoCuenta="
				+ IDTipoCuenta  ;
	}

}

