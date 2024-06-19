package entidad;

public class Direccion {

	private int ID;
	private String Calle;
	private int Numero;
	private String CodigoPostal;
	
public Direccion() {
	this.ID = 0;
	this.Calle = "";
	this.Numero = 0;
	this.CodigoPostal = "";
}

public Direccion(int id, String calle, int numero, String codPostal) {
	this.ID = id;
	this.Calle = calle;
	this.Numero = numero;
	this.CodigoPostal = codPostal;
}

public int getID() {
	return ID;
}

public void setID(int iD) {
	ID = iD;
}

public String getCalle() {
	return Calle;
}

public void setCalle(String calle) {
	Calle = calle;
}

public int getNumero() {
	return Numero;
}

public void setNumero(int numero) {
	Numero = numero;
}

public String getCodigoPostal() {
	return CodigoPostal;
}

public void setCodigoPostal(String codigoPostal) {
	CodigoPostal = codigoPostal;
}

@Override
public String toString() {
	return "Direccion [ID=" + ID + ", Calle=" + Calle + ", Numero=" + Numero + ", CodigoPostal=" + CodigoPostal + "]";
}





	
}
