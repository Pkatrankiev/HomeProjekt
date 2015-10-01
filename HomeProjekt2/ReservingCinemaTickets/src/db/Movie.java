package db;

import java.util.ArrayList;

public class Movie {
	
	public int indeksMovie;
	public String linkPosterMovie;
	public String bgName;
	public String origName;
	public int movieTime;
	public String genre;
	public String language;
	public String country;
	public Movie(int indeksMovie, String linkPosterMovie, String bgName, String origName,
			int movieTime, String genre, String language, String country) {
		
		this.indeksMovie = indeksMovie;
		this.linkPosterMovie = linkPosterMovie;
		this.bgName = bgName;
		this.origName = origName;
		this.movieTime = movieTime;
		this.genre = genre;
		this.language = language;
		this.country = country;
	}
	public int getIndeksMovie() {
		return indeksMovie;
	}
	public void setIndeksMovie(int indeksMovie) {
		this.indeksMovie = indeksMovie;
	}
	public String getBgName() {
		return bgName;
	}
	public void setBgName(String bgName) {
		this.bgName = bgName;
	}
	public String getOrigName() {
		return origName;
	}
	public void setOrigName(String origName) {
		this.origName = origName;
	}
	public int getMovieTime() {
		return movieTime;
	}
	public void setMovieTime(int movieTime) {
		this.movieTime = movieTime;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLinkPosterMovie() {
		return linkPosterMovie;
	}
	public void setLinkPosterMovie(String linkPosterMovie) {
		this.linkPosterMovie = linkPosterMovie;
	}
	public static ArrayList<Movie> getListMovie() {
		return ListMovie;
	}
	public static void setListMovie(ArrayList<Movie> listMovie) {
		ListMovie = listMovie;
	}
	private static ArrayList<Movie> ListMovie = new ArrayList<>();

}
