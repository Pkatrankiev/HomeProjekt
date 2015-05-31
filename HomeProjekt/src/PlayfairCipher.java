import java.util.Scanner;

public class PlayfairCipher {

	public static StringBuilder UpAndSplitMetod(String strWord) {

		// преобразуваме вс.символи в големи
		String kod = strWord.toUpperCase();

		// заместваме в стринга всички символи "J" с "I"
		kod = kod.replaceAll("J", "I");

		// [\d\s,:], премахваме всички цифри, всички интервали, , : ; . ! ?
		String[] kodStr = kod.split("[\\d\\s,:;.!?]+");

		// преобразуваме масива в сринг
		// със StringBuilder за да спестим време и ресурси
		StringBuilder encodingText = new StringBuilder();
		for (String chap : kodStr) {
			encodingText.append(chap);
		}
		return encodingText;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Въвеждаме текста за кодиране
		System.out.print("Въведете текста за кодиране! ");
		String strWord = input.nextLine();

		StringBuilder encodingText = UpAndSplitMetod(strWord);

		// добавяме 'Х' м/у еднакви символи
		StringBuilder textWithX = new StringBuilder();
		char sim = encodingText.charAt(0);
		textWithX.append(sim);
		for (int i = 1; i < encodingText.length(); i++) {
			if (sim == encodingText.charAt(i)) {
				textWithX.append('X');
			}
			sim = encodingText.charAt(i);
			textWithX.append(encodingText.charAt(i));
		}

		// добавяме 'X' за четност на реда
		if (textWithX.length() % 2 != 0) {
			textWithX.append('X');
		}

		// разделяме текста на двойки
		int n = textWithX.length() / 2;
		String[] dw = new String[n];
		for (int i = 0; i < n; i++) {
			dw[i] = textWithX.substring(i * 2, i * 2 + 2);
		}
		int nDW = n;

		// Въвеждаме кодиращата дума
		System.out.print("Въведете кодиращата дума! ");
		strWord = input.nextLine();

		// към текста добавяме всичките букви от лат.азбука
		strWord = strWord + "abcdefghiklmnopqrstuvwxyz";

		StringBuilder kod = UpAndSplitMetod(strWord);

		// инициализираме променлива n с дължината на стринга
		n = kod.length();

		// и нов стринг с дължина - броя на лат.азбука
		char[] arrayT = new char[25];
		int m = 0;
		boolean f = false;// флаг за повтарящ се символ

		arrayT[0] = kod.charAt(0);// на първа позиция в новия масив слагаме
									// първия символ от стринга

		// превъртаме чрез цикъл всеки символ на стринга и го сравняваме с
		// елементите от масива arrayT. Когато няма съвпадение го добавяме, като
		// следващ в масива
		for (int i = 0; i < n; i++) {
			f = false;
			for (int j = 0; j <= m; j++) {

				if (arrayT[j] == kod.charAt(i)) {
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
				if (kodTable[i][j] == 'I') {
					System.out.print("i/j" + " ");
				} else
					System.out.print(kodTable[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("\nЗакодирането на сричките е:");

		int ia = 0;
		int ib = 0;
		int ja = 0;
		int jb = 0;
		String sr = null;

		// инициализираме масив в които ще запишем новите закодирани срички
		String[] dw2 = new String[nDW];

		// обхождаме масива от срички
		for (int p = 0; p < nDW; p++) {
			char aDW = dw[p].charAt(0); // първа буква от сричката
			char bDW = dw[p].charAt(1); // втора буква от сричката

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
				sr = "<>";// обозначавам, че двойката букви са в правоъгълник
				aDW = kodTable[ia][jb];
				bDW = kodTable[ib][ja];
			}
			// когато символите са на един ред
			if ((ia == ib) && (ja != jb)) {
				sr = "-";// обозначавам, че двойката букви са в редица
				if (ja == 4) {
					ja = 0;
					// if (ia == 4) {
					// ia = 0;
					// } else
					// ia = ia + 1;
				} else
					ja = ja + 1;
				aDW = kodTable[ia][ja];

				if (jb == 4) {
					jb = 0;
					// if (ib == 4) {
					// ib = 0;
					// } else
					// ib = ib + 1;
				} else
					jb = jb + 1;
				bDW = kodTable[ib][jb];
			}
			// когато символите са в една колона
			if ((ja == jb) && (ia != ib)) {
				sr = "|"; // обозначавам, че двойката букви са в колона
				if (ia == 4) {
					ia = 0;
					// if (ja == 4) {
					// ja = 0;
					// } else
					// ja = ja + 1;
				} else
					ia = ia + 1;
				aDW = kodTable[ia][ja];

				if (ib == 4) {
					ib = 0;
					// if (jb == 4) {
					// jb = 0;
					// } else
					// jb = jb + 1;
				} else
					ib = ib + 1;
				bDW = kodTable[ib][jb];
			}
			// записваме закодираната сричка в поредния елемент на масива
			dw2[p] = "" + aDW + bDW;
			System.out.println(dw[p] + " " + sr + " " + dw2[p]);
		}
		System.out.println("\nЗакодираният текст е:");
		for (int i = 0; i < dw2.length; i++) {
			System.out.print(dw2[i] + " ");
		}
	}
}
