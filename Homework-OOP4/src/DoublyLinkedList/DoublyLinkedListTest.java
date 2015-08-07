package DoublyLinkedList;

import java.util.Scanner;

public class DoublyLinkedListTest {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		MyLinkedList list1 = new MyLinkedList();
		System.out.println(list1.size());

		System.out.println("Въведете поредица от съобщения.");
		System.out.println("За прекратяване напишете \"End\".");
		int counter = 1;

		String messadge = "";
		System.out.print(counter + " - ");
		messadge = input.next();
		while (!messadge.equals("End")) {
			list1.addInTheEnd(messadge);
			counter++;
			System.out.print(counter + " - ");
			messadge = input.next();
		}

		for (int i = 0; i < list1.size(); i++) {
			System.out.print(i + 1 + " - ");
			System.out.println(list1.get(i));
		}
		System.out.println(list1.size());

		System.out.println("Въведете съобщение за изтриване.");
		messadge = "";
		messadge = input.next();
		list1.remove(messadge);

		for (int i = 0; i < list1.size(); i++) {
			System.out.print(i + 1 + " - ");
			System.out.println(list1.get(i));
		}

		System.out.println("Въведете ново съобщение за вмъкване.");
		messadge = "";
		messadge = input.next();

		System.out.println("Изберете позиция.");
		int Pos = input.nextInt();

		System.out.println(list1.get(Pos));

		list1.addInPosition(messadge, Pos);

		for (int i = 0; i < list1.size(); i++) {
			System.out.print(i + 1 + " - ");
			System.out.println(list1.get(i));
		}

		System.out
				.println("Въведете поредица от съобщения за вмъкване в началото.");
		System.out.println("За прекратяване напишете \"End\".");

		counter = list1.size() + 1;

		messadge = "";
		System.out.print(counter + " - ");
		messadge = input.next();
		while (!messadge.equals("End")) {
			list1.addInTheBegining(messadge);
			counter++;
			System.out.print(counter + " - ");
			messadge = input.next();
		}

		for (int i = 0; i < list1.size(); i++) {
			System.out.print(i + 1 + " - ");
			System.out.println(list1.get(i));
		}
	}

}
