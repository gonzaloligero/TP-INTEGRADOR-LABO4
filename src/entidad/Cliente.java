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
	private int IDTelefono;
	private String NumeroTelefonico;
	private boolean Estado;
	
public Cliente() {
	super();
	this.DNI = 0;
	this.CUIL = "0";
	this.Nombre = "";
	this.Apellido = "";
	this.Sexo = "";
	this.Nacionalidad = "";
	this.FechaNacimiento = Date.valueOf("2020-02-01");
	this.IDTelefono = 0;
	this.NumeroTelefonico = "";
	this.Direccion = new Direccion();
	this.Direccion.setCalle("");
	this.Direccion.setCodigoPostal("");
	this.Direccion.setID(0);
	this.Direccion.setNumero(0);
	this.Email = "";
	this.IDUsuario = 0;
	this.Estado = true;
	this.Direccion.setLocalidad("");
	setUserType(2);
}

public Cliente(int dni, boolean estado, String localidad, String cuil, String nombre, String apellido, String sexo, String nacionalidad, Date fecha, String email, int usuario) {
	super();
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
	this.IDTelefono = 0;
	this.NumeroTelefonico = "";
	this.IDUsuario = usuario;
	this.Estado = estado;
	this.Direccion.setLocalidad(localidad);
	setUserType(2);	
}

public int getDNI() {
	return DNI;
}

public void setDNI(int dNI) {
	DNI = dNI;
}


public String getNumeroTelefonico() {
	return this.NumeroTelefonico;
}

public void setNumeroTelefonico(String numeroTelefonico) {
	this.NumeroTelefonico = numeroTelefonico;
}

public void setTelefono(int telefono) {
	this.IDTelefono = telefono;
}

public int getTelefono() {
	return this.IDTelefono;
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

public void setDireccion(String calle, int numero, String codigoPostal, String localidad, String provincia) {
	this.Direccion.setCalle(calle);
	this.Direccion.setCodigoPostal(codigoPostal);
	this.Direccion.setNumero(numero);
	this.Direccion.setLocalidad(localidad);
	this.Direccion.setProvincia(provincia);
}

@Override
public String toString() {
	return "Cliente [DNI=" + DNI + ", CUIL=" + CUIL + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Sexo=" + Sexo
			+ ", Nacionalidad=" + Nacionalidad + ", FechaNacimiento=" + FechaNacimiento + ", Direccion=" + Direccion
			+ ", Email=" + Email + ", IDUsuario=" + IDUsuario + ", Telefono=" + IDTelefono + ", Estado=" + Estado + "]";
}


}
