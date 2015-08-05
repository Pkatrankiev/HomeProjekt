package library;

public class Book extends library{

	public String title;
	public String author;
	public String publisher;
	public int yearOfPublic;
	public long numberISBN;
	 
	public Book(String title, String author, String publisher,
			int yearOfPublic, long numberISBN) {
		super(name);
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.yearOfPublic = yearOfPublic;
		this.numberISBN = numberISBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getYearOfPublic() {
		return yearOfPublic;
	}

	public void setYearOfPublic(int yearOfPublic) {
		this.yearOfPublic = yearOfPublic;
	}

	public long getNumberISBN() {
		return numberISBN;
	}

	public void setNumberISBN(long numberISBN) {
		this.numberISBN = numberISBN;
	}
	
	
	
	
	
}
