package db;

import java.util.ArrayList;

public class Customer {
	
	
	private String Name ;
	private String Family ;
	private String Adress;
	private String NameTheater;
	private String AdressTheater ;
	private String NameMovie;
	private String Date;
	private String Time ;
	private String Price ;
	private int NumberTickets;
	private String[]Thiket ;
	public Customer(String name, String family, String adress,
			String nameTheater, String adressTheater, String nameMovie,
			String date, String time, String price, int numberTickets,
			String[] thiket) {
		
		Name = name;
		Family = family;
		Adress = adress;
		NameTheater = nameTheater;
		AdressTheater = adressTheater;
		NameMovie = nameMovie;
		Date = date;
		Time = time;
		Price = price;
		NumberTickets = numberTickets;
		Thiket = thiket;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getFamily() {
		return Family;
	}
	public void setFamily(String family) {
		Family = family;
	}
	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
	public String getNameTheater() {
		return NameTheater;
	}
	public void setNameTheater(String nameTheater) {
		NameTheater = nameTheater;
	}
	public String getAdressTheater() {
		return AdressTheater;
	}
	public void setAdressTheater(String adressTheater) {
		AdressTheater = adressTheater;
	}
	public String getNameMovie() {
		return NameMovie;
	}
	public void setNameMovie(String nameMovie) {
		NameMovie = nameMovie;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public int getNumberTickets() {
		return NumberTickets;
	}
	public void setNumberTickets(int numberTickets) {
		NumberTickets = numberTickets;
	}
	public String[] getThiket() {
		return Thiket;
	}
	public void setThiket(String[] thiket) {
		Thiket = thiket;
	}
	public static ArrayList<Customer> getListCustomer() {
		return ListCustomer;
	}
	public static void setListCustomer(ArrayList<Customer> listCustomer) {
		ListCustomer = listCustomer;
	}
	private static ArrayList<Customer> ListCustomer = new ArrayList<>();
	

}
