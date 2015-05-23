import java.util.Scanner;

public class PlayfairDeCipher {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String sr = null;

		// Въвеждаме текста за декодиране
		System.out.print("Въведете текста за декодиране! ");
		String strWord = input.nextLine();

		// перобразуваме вс.символи в големи
		String strWordBig = strWord.toUpperCase();

		// Въвеждаме кодиращата дума
		System.out.print("Въведете кодиращата дума! ");
		strWord = input.nextLine();

		// към текста добавяме всичките букви от лат.азбука
		strWord = strWord + "abcdefghiklmnopqrstuvwxyz";

		// перобразуваме вс.символи в големи
		String kod = strWord.toUpperCase();

		// от този стринг ще махнем повтарящите се и празните символи

		// инициализираме променлива n с дължината на стринга
		int n = kod.length();

		// и нов стринг с дължина - броя на лат.азбука
		char[] arrayT = new char[25];
		int m = 0;
		boolean f = false; // флаг за празен или повтарящ се символ

		arrayT[0] = kod.charAt(0); // на първа позиция в новия масив слагаме
									// първия символ от стринга

		// превъртаме чрез цикъл всеки символ на стринга и го сравняваме с
		// елементите от масива arrayT. Когато няма съвпадение го добавяме, като
		// следващ в масива
		for (int i = 0; i < n; i++) {
			f = false;
			for (int j = 0; j <= m; j++) {
				if ((arrayT[j] == kod.charAt(i)) || (kod.charAt(i) == ' ')) {
					f = true;
					break;
				}
			}
			if (f != true) {
				m++;
				arrayT[m] = kod.charAt(i);
			}
		}

		// пренареждане в матричен вид
		System.out.println("\nТаблицата за кодиране е:");
		char[][] kodTable = new char[5][5];
		int k = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (k <= m) {
					kodTable[i][j] = arrayT[k];
					k++;
				} else {
					break;
				}
				System.out.print(kodTable[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("\nРазкодирането на сричките е:");

		int ia = 0;
		int ib = 0;
		int ja = 0;
		int jb = 0;

		// превръщаме всеки символ от стринга за разкодиране в масив от символи
		char[] kodStr = strWordBig.toCharArray();

		// инициализираме стринг в които ще запишем новите разкодирани срички
		StringBuilder dw2 = new StringBuilder();

		// по инструкции закодирания текст е в срички разделени с пауза
		// обхождаме масива със стъпка 3 /сричка+пауза/
		for (int p = 0; p < kodStr.length; p = p + 3) {
			char aDW = kodStr[p]; // първа буква от сричката
			char bDW = kodStr[p + 1]; // втора буква от сричката

			// два цикъла за обхождате на таблицата за разкодиране
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					// проверка къде се намира в таблицата първата буква
					if (kodTable[i][j] == aDW) {
						ia = i;
						ja = j;
					}
					// проверка къде се намира в таблицата втората буква
					if (kodTable[i][j] == bDW) {
						ib = i;
						jb = j;
					}
				}
			}

			// когато символите са в правоъгълник
			if ((ia != ib) && (ja != jb)) {
				sr = "<>";// обозначавам, че вдойката букви са в правоъгълник
				aDW = kodTable[ia][jb];
				bDW = kodTable[ib][ja];
			}
			// когато символите са на един ред
			if ((ia == ib) && (ja != jb)) {
				sr = "-";// обозначавам, че вдойката букви са в редица
				if (ja == 0) {
					ja = 4;
				} else
					ja = ja - 1;
				aDW = kodTable[ia][ja];

				if (jb == 0) {
					jb = 4;
				} else
					jb = jb - 1;
				bDW = kodTable[ib][jb];
			}
			// когато символите са в една колона
			if ((ja == jb) && (ia != ib)) {
				sr = "|"; // обозначавам, че двойката букви са в колона
				if (ia == 0) {
					ia = 4;
				} else
					ia = ia - 1;
				aDW = kodTable[ia][ja];

				if (ib == 0) {
					ib = 4;
				} else
					ib = ib - 1;
				bDW = kodTable[ib][jb];
			}
			// записваме разкодираната сричка като пореден елемент на стринга

			System.out.println(kodStr[p] + "" + kodStr[p + 1] + " " + sr + " "
					+ aDW + bDW);
			dw2.append(aDW);
			dw2.append(bDW);
		}

		// инициализираме нов стринг в който махаме, ако има добавен Х в
		// оригиналния текст
		StringBuilder origText = new StringBuilder();

		boolean fl; // флаг за добавен Х

		// обхождаме стринга dw2 и проверяваме дали е добавен Х-ът
		for (int i = 0; i < dw2.length(); i++) {
			fl = true;
			if (dw2.charAt(i) == 'X') {
				if (i > 0) {
					if (i == dw2.length() - 1) {
						fl = false; // Х-ът е последен - добавен за четност
					} else if (dw2.charAt(i - 1) == dw2.charAt(i + 1)) {
						fl = false;// Х-ът е добавен м/у еднакви букви
					}
				}
			}
			if (fl) {
				origText.append(dw2.charAt(i));
			}
		}
		System.out.println("\nРазкодираният текст е:");
		System.out.print(origText);

	}

}
