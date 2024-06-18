package entidad;

public class Usuario {
	
	private static int IDCounter = 1;
	private final int ID;
	private String User;
	private String Password;
	private int UserType;; 

public Usuario() {
	this.ID = IDCounter++;
	this.User = "test";
	this.Password = "test";
	this.UserType = 0;
}	

public Usuario (String usuario, String contraseņa, int tipoUsuario) {
	this.ID = IDCounter++;
	this.User = usuario;
	this.Password = contraseņa;
	this.UserType = tipoUsuario;
}

public String getUser() {
	return User;
}

public void setUser(String user) {
	User = user;
}

public String getPassword() {
	return Password;
}

public void setPassword(String password) {
	Password = password;
}

public int getUserType() {
	return UserType;
}

public void setUserType(int userType) {
	UserType = userType;
}

@Override
public String toString() {
	return "Usuario [ID=" + ID + ", User=" + User + ", Password=" + Password + ", UserType=" + UserType + "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ID;
	result = prime * result + ((Password == null) ? 0 : Password.hashCode());
	result = prime * result + ((User == null) ? 0 : User.hashCode());
	result = prime * result + UserType;
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
	Usuario other = (Usuario) obj;
	if (ID != other.ID)
		return false;
	if (Password == null) {
		if (other.Password != null)
			return false;
	} else if (!Password.equals(other.Password))
		return false;
	if (User == null) {
		if (other.User != null)
			return false;
	} else if (!User.equals(other.User))
		return false;
	if (UserType != other.UserType)
		return false;
	return true;
}
	


}
