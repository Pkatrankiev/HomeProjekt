import java.util.Scanner;

public class PlayfairCipher {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String sr = null;

		// Въвеждаме текста за кодиране
		System.out.print("Въведете текста за кодиране! ");
		String strWord = input.nextLine();

		// перобразуваме вс.символи в големи
		String kod = strWord.toUpperCase();

		// [\d\s,:], премахва всички цифри , всички интервали, запетаи и
		// двоеточия.
		String[] kodStr = kod.split("[\\d\\s,:]+");

		// преподреждаме сринга
		// със StringBuilder в буфера преобразуваме стринга за да спестим време
		// и ресурси
		StringBuilder sb = new StringBuilder();
		for (String chap : kodStr) {
			sb.append(chap);
		}

		// добавяме 'х' м/у еднакви символи
		StringBuilder sbor = new StringBuilder();
		int n = sb.length();
		char sim = sb.charAt(0);
		sbor.append(sim);
		for (int i = 1; i < n; i++) {
			if (sim == sb.charAt(i)) {
				sbor.append('x');
			}
			sim = sb.charAt(i);
			sbor.append(sb.charAt(i));
		}
//		System.out.println(sbor);

		// добавяме 'х' за четност на реда
		n = sbor.length();
//		System.out.println(n);
		if (n % 2 != 0) {
			sbor.append('x');
		}
//		System.out.println(sbor);

		// разделяме текста на двойки
		n = sbor.length();
		n = n / 2;
		String[] dw = new String[n];
		for (int i = 0; i < n; i++) {
			dw[i] = sbor.substring(i * 2, i * 2 + 2);
//			System.out.println(dw[i]);
		}
		int nDW = n;

		// Въвеждаме кодиращата дума
		System.out.print("Въведете кодиращата дума! ");
		strWord = input.nextLine();

		// към текста добавяме всичките букви от лат.азбука
		strWord = strWord + "abcdefghiklmnopqrstuvwxyz";
		
		// перобразуваме вс.символи в големи
		kod = strWord.toUpperCase();
				
		// от този стринг ще махнем повтарящите се и празните символи
		
		// инициализираме променлива n с дължината на стринга
		n = kod.length();
		
		// и нов стринг с дължина - броя на лат.азбука
		char[] arrayT = new char[25];
		int m = 0;
		boolean f = false;// флаг за празен или повтарящ се символ
		
		arrayT[0] = kod.charAt(0);// на първа позиция в новия масив слагаме
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
//				System.out.println(m+" "+kod.charAt(i));
				arrayT[m] = kod.charAt(i);
			}
		}

		// пренареждане в матричен вид
		System.out.println("Таблицата за кодиране е:");
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

		System.out.println("Закодирането на сричките е:");

		int ia = 0;
		int ib = 0;
		int ja = 0;
		int jb = 0;

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
		for (int i = 0; i < dw2.length; i++) {
			System.out.print(dw2[i]+" ");
		}
	}

}
