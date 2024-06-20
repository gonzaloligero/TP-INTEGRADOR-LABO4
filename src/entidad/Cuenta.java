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

 
    public Cuenta() {}


    public Cuenta(int IDCuenta, int DNICliente, Date FechaCreacion, int NumeroCuenta, String CBU, double Saldo) {
        this.IDCuenta = IDCuenta;
        this.DNICliente = DNICliente;
        this.FechaCreacion = FechaCreacion;
        this.NumeroCuenta = NumeroCuenta;
        this.CBU = CBU;
        this.Saldo = Saldo;
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

    @Override
    public String toString() {
        return "Cuenta{" +
                "IDCuenta=" + IDCuenta +
                ", DNICliente=" + DNICliente +
                ", FechaCreacion=" + FechaCreacion +
                ", NumeroCuenta=" + NumeroCuenta +
                ", CBU='" + CBU + '\'' +
                ", Saldo=" + Saldo +
                '}';
    }
    
    public static ArrayList<Cuenta> listaCuentas() {
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        cuentas.add(new Cuenta(1, 12345678, Date.valueOf("2020-01-01"), 111111, "12345678901234567890", 1000.50));
        cuentas.add(new Cuenta(2, 23456789, Date.valueOf("2021-02-02"), 222222, "23456789012345678901", 2000.75));
        cuentas.add(new Cuenta(3, 34567890, Date.valueOf("2022-03-03"), 333333, "34567890123456789012", 3000.00));
        cuentas.add(new Cuenta(4, 45678901, Date.valueOf("2023-04-04"), 444444, "45678901234567890123", 4000.25));
        cuentas.add(new Cuenta(5, 56789012, Date.valueOf("2024-05-05"), 555555, "56789012345678901234", 5000.50));
        cuentas.add(new Cuenta(6, 12345678, Date.valueOf("2024-06-06"), 666666, "67890123456789012345", 6000.75));
        cuentas.add(new Cuenta(7, 23456789, Date.valueOf("2024-07-07"), 777777, "78901234567890123456", 7000.25));
        cuentas.add(new Cuenta(8, 34567890, Date.valueOf("2024-08-08"), 888888, "89012345678901234567", 8000.50));
        cuentas.add(new Cuenta(9, 45678901, Date.valueOf("2024-09-09"), 999999, "90123456789012345678", 9000.75));
        cuentas.add(new Cuenta(10, 56789012, Date.valueOf("2024-10-10"), 101010, "01234567890123456789", 10000.00));
        cuentas.add(new Cuenta(11, 12345678, Date.valueOf("2024-11-11"), 1111111, "12345678901234567901", 11000.50));
        cuentas.add(new Cuenta(12, 23456789, Date.valueOf("2024-12-12"), 121212, "23456789012345678912", 12000.75));
        cuentas.add(new Cuenta(13, 34567890, Date.valueOf("2024-01-01"), 131313, "34567890123456789023", 13000.25));
        cuentas.add(new Cuenta(14, 45678901, Date.valueOf("2024-02-02"), 141414, "45678901234567890134", 14000.50));
        cuentas.add(new Cuenta(15, 56789012, Date.valueOf("2024-03-03"), 151515, "56789012345678901245", 15000.75));
        
        return cuentas;
    }
    
}

