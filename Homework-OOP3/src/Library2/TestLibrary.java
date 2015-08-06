package Library2;

import java.util.ArrayList;

public class TestLibrary {

	public static void main(String[] args) {

		Book book1 = new Book("Oceola", "Main Riid", 1930, false);
		Book book2 = new Book("Pod igoto", "Ivan Vazov", 1895, false);
		Book book3 = new Book("Bai Ganio", "Aleko Konstantinov", 1912, false);
		newspaper news1 = new newspaper("Duma", "12.09.1995", false);
		newspaper news2 = new newspaper("Zow", "22.05.2003", false);
		newspaper news3 = new newspaper("Konkurent", "12.02.2015", false);
		Library Lib = new Library("Kiril i Metodi", "Sofiq", "10h-22h");

		// ArrayList<publication> pub = new ArrayList<>();

		Library.allPublication.add(book1);
		Library.allPublication.add(book2);
		Library.allPublication.add(book3);
		Library.allPublication.add(news1);
		Library.allPublication.add(news2);
		Library.allPublication.add(news3);

		System.out.printf("%n-------------------------");
		System.out.printf("%nOpis na vsi`ki izdaniq.");
		int i = 0;
		for (publication curentpub : Library.allPublication) {
			i++;
			System.out.printf("%n%d-", i);
			publication.getDetails(curentpub);
		}

		System.out.printf("%n%n-------------------------");
		System.out.printf("%nNaemame 3-toto izdanie ot spisaka.");
		Library.makeEmployed(Library.allPublication.get(2));

		System.out.printf("%n-------------------------");
		System.out.printf("%nOpis na svobodnite izdaniq");
		publication.opisFreePublic();

	}
}
