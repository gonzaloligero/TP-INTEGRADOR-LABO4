package entidad;

public class Administrador extends Usuario{
	
	private String NombreAdmin;
	private String Telefono;
	private String Email;
	private boolean Estado;
	
public Administrador() {
	this.NombreAdmin = "";
	this.Telefono = "";
	this.Email = "";
	this.Estado = true;
	setUserType(1);
	}

public Administrador(String name, String telephone, String email, boolean estado) {
	this.NombreAdmin = name;
	this.Telefono = telephone;
	this.Email = email;
	this.Estado = estado;
	setUserType(1);
}

public String getNombreAdmin() {
	return NombreAdmin;
}

public void setNombreAdmin(String nombreAdmin) {
	NombreAdmin = nombreAdmin;
}

public String getTelefono() {
	return Telefono;
}

public void setTelefono(String telefono) {
	Telefono = telefono;
}

public String getEmail() {
	return Email;
}

public void setEmail(String email) {
	Email = email;
}

public boolean isEstado() {
	return Estado;
}

public void setEstado(boolean estado) {
	Estado = estado;
}

@Override
public String toString() {
	return "Administrador [NombreAdmin=" + NombreAdmin + ", Telefono=" + Telefono + ", Email=" + Email + ", Estado="
			+ Estado + "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((Email == null) ? 0 : Email.hashCode());
	result = prime * result + (Estado ? 1231 : 1237);
	result = prime * result + ((NombreAdmin == null) ? 0 : NombreAdmin.hashCode());
	result = prime * result + ((Telefono == null) ? 0 : Telefono.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!super.equals(obj))
		return false;
	if (getClass() != obj.getClass())
		return false;
	Administrador other = (Administrador) obj;
	if (Email == null) {
		if (other.Email != null)
			return false;
	} else if (!Email.equals(other.Email))
		return false;
	if (Estado != other.Estado)
		return false;
	if (NombreAdmin == null) {
		if (other.NombreAdmin != null)
			return false;
	} else if (!NombreAdmin.equals(other.NombreAdmin))
		return false;
	if (Telefono == null) {
		if (other.Telefono != null)
			return false;
	} else if (!Telefono.equals(other.Telefono))
		return false;
	return true;
}



}
