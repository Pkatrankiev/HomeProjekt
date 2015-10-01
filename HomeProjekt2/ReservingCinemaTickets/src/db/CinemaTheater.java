package db;

import java.util.ArrayList;
import java.util.Date;

public class CinemaTheater {
	
	private int[][] seat;
	private int indeksMovie;
	private String name;
	private String adres;
	private int lines;
	private int columns;
	private Date date;
	private Date time;
	private float price;

	public CinemaTheater(int indeksMovie, String name, String adres,
						Date date, Date time, float price,
							int lines, int columns, int[][] seat) {
		
		this.seat = seat;
		this.indeksMovie = indeksMovie;
		this.name = name;
		this.adres = adres;
		this.lines = lines;
		this.columns = columns;
		this.date = date;
		this.time = time;
		this.price = price;
	}


	public int getIndeksMovie() {
		return indeksMovie;
	}


	public void setIndeksMovie(int indeksMovie) {
		this.indeksMovie = indeksMovie;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Date getTime() {
		return time;
	}


	public void setTime(Date time) {
		this.time = time;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public int[][] getSeat() {
		return seat;
	}


	public void setSeat(int[][] seat) {
		this.seat = seat;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAdres() {
		return adres;
	}


	public void setAdres(String adres) {
		this.adres = adres;
	}


	public int getLines() {
		return lines;
	}


	public void setLines(int lines) {
		this.lines = lines;
	}


	public int getColumns() {
		return columns;
	}


	public void setColumns(int columns) {
		this.columns = columns;
	}

	public static ArrayList<CinemaTheater> getListCinemaTheater() {
		return ListCinemaTheater;
	}
	public static void setListCinemaTheater(ArrayList<CinemaTheater> listCinemaTheater) {
		ListCinemaTheater = listCinemaTheater;
	}
	private static ArrayList<CinemaTheater> ListCinemaTheater = new ArrayList<>();
	
//	********************
	
	public static ArrayList<Date> getListdateWeek() {
		return ListdateWeek;
	}
	public static void setListdateWeek(ArrayList<Date> listdateWeek) {
		ListdateWeek = listdateWeek;
	}
	private static ArrayList<Date> ListdateWeek = new ArrayList<>();
	
//	8888888888888
	
}
