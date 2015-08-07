package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MessageList {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		Queue<String> List = new LinkedList<String>();

		System.out.println("Въведете поредица от съобщения.");
		System.out.println("За прекратяване напишете \"End\".");
		int counter = 1;

		String messadge = "";
		System.out.print(counter + " - ");
		messadge = input.next();

		while (!messadge.equals("End")) {
			List.offer(messadge);
			counter++;
			System.out.print(counter + " - ");
			messadge = input.next();
			

		}
		if (List.size() > 0) {
			System.out.println("Вие въведохте следните съобщения:");
			counter = 1;
			while (List.size() > 0) {

				messadge = List.poll();
				System.out.println(counter + " - " + messadge);
				counter++;
			}

		} else
			System.out.println("Вие нямате въведени съобщения:");

	}
}
