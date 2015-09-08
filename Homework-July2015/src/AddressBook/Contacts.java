package AddressBook;

public class Contacts {
	public String name;
	public String phone;
	public String eMail;
	public Adress adress;
	public Category category;

	public Contacts(String name, String phone, String eMail, Adress adress,
			Category category) {

		this.name = name;
		this.phone = phone;
		this.eMail = eMail;
		this.adress = adress;
		this.category = category;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public static String listContact(Contacts cont) {

		String s = String.format("%s, %-15s, %-15s \n"
				+ "With address: %-5s, %8s, %s \nIn Category: %s \n\n",
				cont.getName(), 
				cont.getPhone(), 
				cont.geteMail(),
				cont.adress.getCity(), 
				cont.adress.getStreet(),
				cont.adress.getStrNumber(), 
				cont.category.getCatName());

		return s;
	}

	static Contacts Cont1 = new Contacts("Ivan", "0888 123 456", "ivan@abv.bg",
			Adress.adrIvan, Category.Cat1);
	static Contacts Cont2 = new Contacts("Pesho", "0888 223344",
			"Pesho@abv.bg", Adress.adrP, Category.Cat2);
	static Contacts Cont3 = new Contacts("Irina", "0888 887777",
			"Irina@abv.bg", Adress.adrIr, Category.Cat3);

}
