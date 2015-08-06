package Library2;

public class Book extends publication {
	
	public int yearOfIssue;
	public String author;
	
	public Book(String title, String author, int yearOfIssue, boolean employed) {
		super(title, employed);
		
		this.yearOfIssue = yearOfIssue;
		this.author = author;
	}

	public int getYearOfIssue() {
		return yearOfIssue;
	}

	public void setYearOfIssue(int yearOfIssue) {
		this.yearOfIssue = yearOfIssue;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	

}
