package library;

public class TestLibrary {

	public static void main(String[] args) {

		library Lib = new library("Kiril i Metodi");

		Book book1 = new Book("Bag of Bones", "Stephen King", "Scribner", 1998,
				1234567l);
		Book book2 = new Book("Black House", "Stephen King", "Random House",
				2001, 123337l);
		Book book3 = new Book("Rose Madder", "Stephen King", "Viking Press",
				1995, 1874267l);
		Book book4 = new Book("Dragon Girl", "Melissa Nichols", "bookrix",
				2011, 98723567l);
		Book book5 = new Book("A cute love story", "Nidhi Agrawal",
				"Viking Press", 2010, 9872547l);
		Book book6 = new Book("My Sophomore Year", "Katie Such",
				"Random House", 2000, 837537l);

		Lib.addBook(book6);
		Lib.addBook(book5);
		Lib.addBook(book3);
		Lib.addBook(book4);
		Lib.addBook(book1);
		Lib.addBook(book2);


		Book bk;
		for (int i = 0; i < Lib.libCount(); i++) {
			bk = Lib.getBook(i);
			Lib.infoBook(bk);
			System.out.println();
		}
		System.out.println("***************************************");

		boolean fl = true;
		while (fl) {
			bk = Lib.getAutBook("Stephen King");
			if (bk != null) {
				Lib.remBook(bk);
			} else
				fl = false;
		}

		for (int i = 0; i < Lib.libCount(); i++) {
			bk = Lib.getBook(i);
			Lib.infoBook(bk);
			System.out.println();
		}

	}

	
}
