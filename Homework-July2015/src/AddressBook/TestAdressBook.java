package AddressBook;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class TestAdressBook {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		ArrayList<Category> Categorylist = new ArrayList<>();
		Categorylist.add(Category.Cat1);
		Categorylist.add(Category.Cat2);
		Categorylist.add(Category.Cat3);

		ArrayList<Contacts> contacts = new ArrayList<>();
		contacts.add(Contacts.Cont1);
		contacts.add(Contacts.Cont2);
		contacts.add(Contacts.Cont3);

		// 1. Добави контакт
		System.out.printf("\n-----------------------------\n");
		System.out.println("1. Добавяне на контакт");

		contacts.add(addContact(Categorylist));

		// 2. Добави категория
		System.out.printf("\n-----------------------------\n");
		System.out.println("2. Добавяне на категория");

		addCategory(Categorylist);

		// 3. Изведи списък с всички контакти
		System.out.printf("\n-----------------------------\n");
		System.out.println("3. Извеждане на списък с всички контакти");

		listContact(contacts);

		// 4. Изведи списък с всички категории
		System.out.printf("\n-----------------------------\n");
		System.out.println("4. Изведане на списък с всички категории");

		listCategory(Categorylist);

		// 5. Търси контакти по име
		System.out.printf("\n-----------------------------\n");
		System.out.println("5. Търсене на контакти по име");

		System.out.println("Enter a name for search!");
		String name = IfKorektString();
		searchContactByName(contacts, name);

		// 6. Търси контакти по категория
		System.out.printf("\n-----------------------------\n");
		System.out.println("6. Търсене на контакти по категория");

		System.out.println("Search contacts by category");
		Category choiseCat = ChoiseCategory(Categorylist);
		searchContactByCategory(contacts, choiseCat);
		

		// 7. Записване на контактите във файл
		System.out.printf("\n-----------------------------\n");
		System.out.println(" 7. Записване на контактите във файл");
		saveContaktsInFile(contacts);
		
		input.close();
	}

	static void saveContaktsInFile(ArrayList<Contacts> contacts) {
		System.out.println("Enter the file name!");
		String fileName = IfKorektString()+".txt";
		// Create a PrintStream instance
		PrintStream fileWriter = null;
		try {
			fileWriter = new PrintStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Loop through the numbers from 1 to 20 and write them
		 for (int i = 0; i < contacts.size(); i++) {
		 fileWriter.println(Contacts.listContact(contacts.get(i)));
		 }
		// Close the stream when you are done using it
		 fileWriter.close();
	}

	static void addCategory(ArrayList<Category> Categorylist) {

		listCategory(Categorylist);
		System.out.println("Enter the name of the new category!");

		String name = IfKorektString();

		Category Cat = new Category(name);
		Categorylist.add(Cat);
		System.out.println("The new list of categories:");
		listCategory(Categorylist);
	}

	static String IfKorektString() {
		Scanner input = new Scanner(System.in);
		String name = null;
		boolean fl = true;
		while (fl) {
			name = input.next();

			if (name.equals("") || name.equals(null)) {
				fl = true;

			} else
				fl = false;

		}
		return name;
	}

	static Contacts addContact(ArrayList<Category> Categorylist) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the name!");
		String name = IfKorektString();
		System.out.println("Enter the phone number!");
		String phoNum = input.next();
		System.out.println("Enter the e-mail!");
		String eMail = input.next();

		System.out.println("Enter the Sity!");
		String sity = input.next();
		System.out.println("Enter the street!");
		String str = input.next();
		System.out.println("Enter the street number!");
		String strNum = input.next();

		Adress adr = new Adress(sity, str, strNum);

		System.out.println("To which category will add contact?");

		Category cat = ChoiseCategory(Categorylist);
		Contacts Cont = new Contacts(name, phoNum, eMail, adr, cat);
		return Cont;
	}

	static void listCategory(ArrayList<Category> Categorylist) {
		for (int i = 0; i < Categorylist.size(); i++) {
			System.out.println(i + " - " + Categorylist.get(i).getCatName());
		}
	}

	static void listContact(ArrayList<Contacts> contacts) {
		for (int i = 0; i < contacts.size(); i++) {
			System.out.println("Contakt: " + (i + 1));
			System.out.println(Contacts.listContact(contacts.get(i)));
		}
	}

	static void searchContactByName(ArrayList<Contacts> contacts, String name) {
		boolean fl = true;
		int count = 1;
		for (int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i).getName().equals(name)) {
				System.out.println(count);
				System.out.println(Contacts.listContact(contacts.get(i)));
				fl = false;
				count++;
			}
		}
		if (fl) {
			System.out.println("Missing contact with this name");
		}
	}

	static int IfKorectInt() {
		Scanner input = new Scanner(System.in);
		int i2 = 0;
		boolean fl = true;
		while (fl) {
			String imp = input.next();

			try {
				i2 = Integer.valueOf(imp);
				fl = false;
			} catch (NumberFormatException e) {
				System.err.println("Incorrectly entered value.");
				fl = true;
			}
		}
		return i2;
	}

	static Category ChoiseCategory(ArrayList<Category> Categorylist) {

		listCategory(Categorylist);
		System.out.println("Select number of category!");
		boolean fl = true;
		int i2 = 0;
		while (fl) {
			i2 = IfKorectInt();
			if (i2 <= Categorylist.size() && i2 >= 0) {
				fl = false;
			} else {
				fl = true;
				System.out.println("Enter a value between 0 to "
						+ (Categorylist.size() - 1));
			}
		}
		return Categorylist.get(i2);
	}

	static void searchContactByCategory(ArrayList<Contacts> contacts,
			Category cat) {
		boolean fl = true;
		int count = 1;
		for (int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i).getCategory() == cat) {
				System.out.println(count);
				System.out.println(Contacts.listContact(contacts.get(i)));
				fl = false;
				count++;
			}
		}
		if (fl) {
			System.out.println("Missing contact with this category");
		}
	}
}
