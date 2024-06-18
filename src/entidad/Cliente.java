package entidad;

import java.sql.Date;

public class Cliente extends Usuario {
	
	private int DNI;
	private String CUIL;
	private String Nombre;
	private String Apellido;
	private String Sexo;
	private String Nacionalidad;
	private Date FechaNacimiento;
	private int IDDireccion;
	private String Email;
	private int IDUsuario;
	private boolean Estado;
	
public Cliente() {
	this.DNI = 0;
	this.CUIL = "0";
	this.Nombre = "";
	this.Apellido = "";
	this.Sexo = "";
	this.Nacionalidad = "";
	this.FechaNacimiento = Date.valueOf("2020-02-01");
	this.IDDireccion = 0;
	this.Email = "";
	this.IDUsuario = 0;
	setUserType(2);
}

public Cliente(int dni, String cuil, String nombre, String apellido, String sexo, String nacionalidad, Date fecha, int direccion, String email, int usuario) {
	this.DNI = dni;
	this.CUIL = cuil;
	this.Nombre = nombre;
	this.Apellido = apellido;
	this.Sexo = sexo;
	this.Nacionalidad = nacionalidad;
	this.FechaNacimiento = fecha;
	this.IDDireccion = direccion;
	this.Email = email;
	this.IDUsuario = usuario;
	setUserType(2);	
}

public int getDNI() {
	return DNI;
}

public void setDNI(int dNI) {
	DNI = dNI;
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

public int getIDDireccion() {
	return IDDireccion;
}

public void setIDDireccion(int iDDireccion) {
	IDDireccion = iDDireccion;
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

@Override
public String toString() {
	return "Cliente [DNI=" + DNI + ", CUIL=" + CUIL + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Sexo=" + Sexo
			+ ", Nacionalidad=" + Nacionalidad + ", FechaNacimiento=" + FechaNacimiento + ", IDDireccion=" + IDDireccion
			+ ", Email=" + Email + ", IDUsuario=" + IDUsuario + "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((Apellido == null) ? 0 : Apellido.hashCode());
	result = prime * result + ((CUIL == null) ? 0 : CUIL.hashCode());
	result = prime * result + DNI;
	result = prime * result + ((Email == null) ? 0 : Email.hashCode());
	result = prime * result + ((FechaNacimiento == null) ? 0 : FechaNacimiento.hashCode());
	result = prime * result + IDDireccion;
	result = prime * result + IDUsuario;
	result = prime * result + ((Nacionalidad == null) ? 0 : Nacionalidad.hashCode());
	result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
	result = prime * result + ((Sexo == null) ? 0 : Sexo.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Cliente other = (Cliente) obj;
	if (Apellido == null) {
		if (other.Apellido != null)
			return false;
	} else if (!Apellido.equals(other.Apellido))
		return false;
	if (CUIL == null) {
		if (other.CUIL != null)
			return false;
	} else if (!CUIL.equals(other.CUIL))
		return false;
	if (DNI != other.DNI)
		return false;
	if (Email == null) {
		if (other.Email != null)
			return false;
	} else if (!Email.equals(other.Email))
		return false;
	if (FechaNacimiento == null) {
		if (other.FechaNacimiento != null)
			return false;
	} else if (!FechaNacimiento.equals(other.FechaNacimiento))
		return false;
	if (IDDireccion != other.IDDireccion)
		return false;
	if (IDUsuario != other.IDUsuario)
		return false;
	if (Nacionalidad == null) {
		if (other.Nacionalidad != null)
			return false;
	} else if (!Nacionalidad.equals(other.Nacionalidad))
		return false;
	if (Nombre == null) {
		if (other.Nombre != null)
			return false;
	} else if (!Nombre.equals(other.Nombre))
		return false;
	if (Sexo == null) {
		if (other.Sexo != null)
			return false;
	} else if (!Sexo.equals(other.Sexo))
		return false;
	return true;
}



}
