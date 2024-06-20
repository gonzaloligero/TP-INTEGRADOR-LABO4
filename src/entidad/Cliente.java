package entidad;

import java.sql.Date;
import java.util.ArrayList;

public class Cliente extends Usuario {
	
	private int DNI;
	private String CUIL;
	private String Nombre;
	private String Apellido;
	private String Sexo;
	private String Nacionalidad;
	private Date FechaNacimiento;
	private Direccion Direccion;
	private String Email;
	private int IDUsuario;
	private String Telefono;
	private boolean Estado;
	
public Cliente() {
	this.DNI = 0;
	this.CUIL = "0";
	this.Nombre = "";
	this.Apellido = "";
	this.Sexo = "";
	this.Nacionalidad = "";
	this.FechaNacimiento = Date.valueOf("2020-02-01");
	this.Telefono = "";
	this.Direccion = new Direccion();
	this.Direccion.setCalle("");
	this.Direccion.setCodigoPostal("");
	this.Direccion.setID(0);
	this.Direccion.setNumero(0);
	this.Email = "";
	this.IDUsuario = 0;
	setUserType(2);
}

public Cliente(int dni, String cuil, String nombre, String apellido, String sexo, String nacionalidad, Date fecha, String email, int usuario) {
	this.DNI = dni;
	this.CUIL = cuil;
	this.Nombre = nombre;
	this.Apellido = apellido;
	this.Sexo = sexo;
	this.Nacionalidad = nacionalidad;
	this.FechaNacimiento = fecha;
	this.Direccion = new Direccion();
	this.Direccion.setCalle("");
	this.Direccion.setCodigoPostal("");
	this.Direccion.setID(0);
	this.Direccion.setNumero(0);
	this.Email = email;
	this.Telefono = "";
	this.IDUsuario = usuario;
	setUserType(2);	
}

public int getDNI() {
	return DNI;
}

public void setDNI(int dNI) {
	DNI = dNI;
}

public void setTelefono(String telefono) {
	this.Telefono = telefono;
}

public String getTelefono() {
	return this.Telefono;
}

public String getCUIL() {
	return CUIL;
}

public void setCUIL(String cUIL) {
	CUIL = cUIL;
}

public String getNombre() {
	return Nombre;
}

public void setNombre(String nombre) {
	Nombre = nombre;
}

public String getApellido() {
	return Apellido;
}

public void setApellido(String apellido) {
	Apellido = apellido;
}

public String getSexo() {
	return Sexo;
}

public void setSexo(String sexo) {
	Sexo = sexo;
}

public String getNacionalidad() {
	return Nacionalidad;
}

public void setNacionalidad(String nacionalidad) {
	Nacionalidad = nacionalidad;
}

public Date getFechaNacimiento() {
	return FechaNacimiento;
}

public void setFechaNacimiento(Date fechaNacimiento) {
	FechaNacimiento = fechaNacimiento;
}

public String getEmail() {
	return Email;
}

public void setEmail(String email) {
	Email = email;
}

public int getIDUsuario() {
	return IDUsuario;
}

public void setIDUsuario(int iDUsuario) {
	IDUsuario = iDUsuario;
}

public void setEstado(boolean estado) {
	this.Estado = estado;
}

public boolean getEstado() {
	return this.Estado;
}



public Direccion getDireccion() {
	return this.Direccion;
}

public void setDireccion(String calle, int numero, String codigoPostal) {
	this.Direccion.setCalle(calle);
	this.Direccion.setCodigoPostal(codigoPostal);
	this.Direccion.setNumero(numero);
}

@Override
public String toString() {
	return "Cliente [DNI=" + DNI + ", CUIL=" + CUIL + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Sexo=" + Sexo
			+ ", Nacionalidad=" + Nacionalidad + ", FechaNacimiento=" + FechaNacimiento + ", Direccion=" + Direccion
			+ ", Email=" + Email + ", IDUsuario=" + IDUsuario + ", Telefono=" + Telefono + ", Estado=" + Estado + "]";
}


public static ArrayList<Cliente> listaClientes() {
    ArrayList<Cliente> clientes = new ArrayList<>();
    clientes.add(new Cliente(12345678, "20-12345678-9", "Juan", "Pérez", "M", "Argentina", Date.valueOf("1990-01-01"), "juan.perez@example.com", 1));
    clientes.add(new Cliente(23456789, "20-23456789-8", "María", "Gómez", "F", "Argentina", Date.valueOf("1991-02-02"), "maria.gomez@example.com", 2));
    clientes.add(new Cliente(34567890, "20-34567890-7", "Pedro", "Martínez", "M", "Argentina", Date.valueOf("1992-03-03"), "pedro.martinez@example.com", 3));
    clientes.add(new Cliente(45678901, "20-45678901-6", "Ana", "López", "F", "Argentina", Date.valueOf("1993-04-04"), "ana.lopez@example.com", 4));
    clientes.add(new Cliente(56789012, "20-56789012-5", "Luis", "García", "M", "Argentina", Date.valueOf("1994-05-05"), "luis.garcia@example.com", 5));
    clientes.add(new Cliente(67890123, "20-67890123-4", "Laura", "Fernández", "F", "Argentina", Date.valueOf("1995-06-06"), "laura.fernandez@example.com", 6));
    clientes.add(new Cliente(78901234, "20-78901234-3", "Carlos", "Rodríguez", "M", "Argentina", Date.valueOf("1996-07-07"), "carlos.rodriguez@example.com", 7));
    clientes.add(new Cliente(89012345, "20-89012345-2", "Sofía", "Sánchez", "F", "Argentina", Date.valueOf("1997-08-08"), "sofia.sanchez@example.com", 8));
    clientes.add(new Cliente(90123456, "20-90123456-1", "Diego", "López", "M", "Argentina", Date.valueOf("1998-09-09"), "diego.lopez@example.com", 9));
    clientes.add(new Cliente(12345678, "20-12345678-9", "Camila", "Pérez", "F", "Argentina", Date.valueOf("1990-01-01"), "camila.perez@example.com", 10));
    clientes.add(new Cliente(23456789, "20-23456789-8", "Martín", "Gómez", "M", "Argentina", Date.valueOf("1991-02-02"), "martin.gomez@example.com", 11));
    clientes.add(new Cliente(34567890, "20-34567890-7", "Lucía", "Martínez", "F", "Argentina", Date.valueOf("1992-03-03"), "lucia.martinez@example.com", 12));
    clientes.add(new Cliente(45678901, "20-45678901-6", "Federico", "López", "M", "Argentina", Date.valueOf("1993-04-04"), "federico.lopez@example.com", 13));
    clientes.add(new Cliente(56789012, "20-56789012-5", "Valeria", "García", "F", "Argentina", Date.valueOf("1994-05-05"), "valeria.garcia@example.com", 14));
    clientes.add(new Cliente(67890123, "20-67890123-4", "Jorge", "Fernández", "M", "Argentina", Date.valueOf("1995-06-06"), "jorge.fernandez@example.com", 15));
    return clientes;
}




}
