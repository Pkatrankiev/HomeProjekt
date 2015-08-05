package VideoLibrary;

import java.util.Scanner;

public class TestVideoLibrary {

	public static void main(String[] args) {

		VideoLibrary library = new VideoLibrary();

		VideoTaipe tape1 = new VideoTaipe("Ivan Ivanov", "Star Wars I", false,
				"01.01.20115", "11.01.20115");
		VideoTaipe tape2 = new VideoTaipe(null, "Star Wars II", true,
				"02.02.20115", "21.01.20115");
		VideoTaipe tape3 = new VideoTaipe("Cvetan Vasilev", "Star Wars III",
				false, "03.03.20115", "31.01.20115");
		VideoTaipe tape4 = new VideoTaipe(null, "Star Wars IV", true,
				"04.04.20115", "41.01.20115");
		VideoTaipe tape5 = new VideoTaipe(null, "Star Wars V", true,
				"05.05.20115", "51.01.20115");
		VideoTaipe tape6 = new VideoTaipe(null, "Star Wars VI", true,
				"06.06.20115", "61.01.20115");
		VideoTaipe tape7 = new VideoTaipe("Peter Serviz", "War of the Worlds",
				false, "07.07.20115", "71.01.20115");

		library.addTaipe(tape1);
		library.addTaipe(tape2);
		library.addTaipe(tape3);
		library.addTaipe(tape4);
		library.addTaipe(tape5);
		library.addTaipe(tape6);
		library.addTaipe(tape7);

		Scanner input = new Scanner(System.in);

		System.out.printf("%n-----------------------%n");
		System.out.println("Opis All Taipes:");
		VideoLibrary.OpisTape();

		String choiseName = "Ivan Ivanov";
		User user = new User(choiseName, true);
		library.addUser(user);

		choiseName = "Cvetan Vasilev";
		user = new User(choiseName, true);
		library.addUser(user);

		choiseName = "Dragan Simeonov";
		user = new User(choiseName, false);
		library.addUser(user);

		choiseName = "Peter Serviz";
		user = new User(choiseName, true);
		library.addUser(user);

		System.out.printf("%n-----------------------%n");
		System.out.println("Opis All Users:");
		VideoLibrary.OpisUser();

		System.out.print("Ime na Nov potrebitel:");
		choiseName = input.next();
		user = new User(choiseName, false);
		library.addUser(user);

		System.out.println("Izberete klient, koito ste vzema kaseta!");
		VideoLibrary.OpisUser();
		int intUserChoise = input.nextInt();

		System.out.println("Izberete kaseta za wzemane:");
		System.out.printf("%n-----------------------%n");
		System.out.println("Opis All Free Taipes:");
		VideoLibrary.OpisFreeTape();
		int intTaipeChoise = input.nextInt();
		VideoLibrary.getTaipe(intTaipeChoise);

		System.out.print("Data na vzemane:");
		String choiseMakingDate = input.next();
		VideoLibrary.setDateMaking(intTaipeChoise, choiseMakingDate);

		System.out.print("Data na vrastane:");
		String choiseReturnDate = input.next();
		VideoLibrary.setDateReturn(intTaipeChoise, choiseReturnDate);

		choiseName = VideoLibrary.getUserName(intUserChoise);
		VideoLibrary.setUserNameInTaipe(intTaipeChoise, choiseName);
		VideoLibrary.setAvailable(intTaipeChoise, false);
		VideoLibrary.setObligedUser(intUserChoise, true);

		System.out.printf("%n-----------------------%n");
		System.out.println("Opis Not Available Taipes:");
		VideoLibrary.OpisNotAvailableTape();

		System.out.printf("%n-----------------------%n");
		System.out.println("Opis na zadalgenite klienti: ");
		System.out.println();
		VideoLibrary.OpisTaipesOfObligedUser();
		
		System.out.printf("%n-----------------------%n");
		System.out.println("Izberete klient, koito ste vrasta kaseta!");
		VideoLibrary.OpisObligedUser();
		intUserChoise = input.nextInt();
		String UserName = VideoLibrary.getUserName(intUserChoise);
		
		System.out.printf("%n-----------------------%n");
		System.out.printf("%nOpis na naetite ot %s kaseti: %n",UserName);
		VideoLibrary.OpisTaipesOfUser(UserName);
		
		System.out.printf("%n-----------------------%n");
		System.out.print("Izberete kaseta za vrastane:");
		
		intTaipeChoise = input.nextInt();
		VideoLibrary.returnTaipe(intTaipeChoise);
		
		System.out.printf("%n-----------------------%n");
		System.out.println("Opis All Free Taipes:");
		VideoLibrary.OpisFreeTape();
		
	}

}
