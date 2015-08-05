package library;

public class library {

	 static String name;
	public MyLibraryList<Book> book;

	public library(String name) {
		
		this.name = name;
		this.book = new MyLibraryList<Book>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyLibraryList<Book> getBook() {
		return book;
	}

	public void setBook(MyLibraryList<Book> book) {
		this.book = book;
	}
	
	public void addBook(Book bok) {
		this.book.add(bok);
	}

	public void remBook(Book bok) {
		this.book.remove(bok);
	}
	
	public int libCount(){
		return book.count();
	}
	
	public Book getAutBook(String autor) {
		for (int i = 0; i < book.count(); i++) {
			if (book.get(i).getAuthor() == autor) {
				return book.get(i);
			}
		}
		return null;
	}
	
	public Book getBook(int position) {
		return book.get(position);
	}
	
	public void infoBook(Book bok) {
		System.out.println("Title: "+bok.getTitle());
		System.out.println("Autor: "+bok.getAuthor());
		System.out.println("Publisher: "+bok.getPublisher());
		System.out.println("ISBN number: "+bok.numberISBN);
		System.out.println("Year Of Public: "+bok.yearOfPublic);
			}
	
}
