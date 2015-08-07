package DoublyLinkedList;

import java.util.Scanner;

public class DoublyLinkedListTest {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		MyLinkedList list1 = new MyLinkedList();
		System.out.println(list1.size());

		System.out.println("�������� �������� �� ���������.");
		System.out.println("�� ������������ �������� \"End\".");
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

		System.out.println("�������� ��������� �� ���������.");
		messadge = "";
		messadge = input.next();
		list1.remove(messadge);

		for (int i = 0; i < list1.size(); i++) {
			System.out.print(i + 1 + " - ");
			System.out.println(list1.get(i));
		}

		System.out.println("�������� ���� ��������� �� ��������.");
		messadge = "";
		messadge = input.next();

		System.out.println("�������� �������.");
		int Pos = input.nextInt();

		System.out.println(list1.get(Pos));

		list1.addInPosition(messadge, Pos);

		for (int i = 0; i < list1.size(); i++) {
			System.out.print(i + 1 + " - ");
			System.out.println(list1.get(i));
		}

		System.out
				.println("�������� �������� �� ��������� �� �������� � ��������.");
		System.out.println("�� ������������ �������� \"End\".");

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
