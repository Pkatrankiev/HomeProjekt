package AddressBook;

public class Adress {

	String city;
	String street;
	String strNumber;
	
	public Adress(String city, String street, String strNumber) {
		
		this.city = city;
		this.street = street;
		this.strNumber = strNumber;
	}
	
	
	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getStrNumber() {
		return strNumber;
	}


	public void setStrNumber(String strNumber) {
		this.strNumber = strNumber;
	}


	public Adress addAdress (String city, String street, String strNumber){
		return   new Adress(city, street,strNumber);
	}
	
	static Adress adrIvan = new Adress("Vraca", "N.Voidivodov", "4A");
	static Adress adrP = new Adress("Pleven", "Leonova", "60");
	static Adress adrIr = new Adress("Sofia", "Hr.Botev", "12A");
}
