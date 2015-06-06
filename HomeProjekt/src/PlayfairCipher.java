import java.util.Scanner;

public class PlayfairCipher {

	public static StringBuilder UpAndSplitMetod(String strWord) {

		// preobrazuvame vs.simvoli v golemi
		String kod = strWord.toUpperCase();

		// zamestvame v stringa vsichki simvoli "J" s "I"
		kod = kod.replaceAll("J", "I");

		// premahvame vsichki simvoli razlichni ot bukvi
		String[] kodStr = kod.split("[^A-Z]+");

		// preobrazuvame masiva v sring
		// sas StringBuilder za da spestim vreme i resursi
		StringBuilder encodingText = new StringBuilder();
		for (String chap : kodStr) {
			encodingText.append(chap);
		}
		return encodingText;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Vavezhdame teksta za kodirane
		System.out.print("Enter the text encoding! ");
		String strWord = input.nextLine();

		StringBuilder encodingText = UpAndSplitMetod(strWord);

		// dobavyame 'X' m/u ednakvi simvoli
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

		// dobavyame 'X' za chetnost na reda
		if (textWithX.length() % 2 != 0) {
			textWithX.append('X');
		}

		// razdelyame teksta na dvoyki
		int n = textWithX.length() / 2;
		String[] dw = new String[n];
		for (int i = 0; i < n; i++) {
			dw[i] = textWithX.substring(i * 2, i * 2 + 2);
		}
		int nDW = n;

		// Vavezhdame kodirashtata duma
		System.out.print("Enter the codeword! ");
		strWord = input.nextLine();

		// kam teksta dobavyame vsichkite bukvi ot lat.azbuka
		strWord = strWord + "abcdefghiklmnopqrstuvwxyz";

		StringBuilder kod = UpAndSplitMetod(strWord);

		// initsializirame promenliva n s dalzhinata na stringa
		n = kod.length();

		// i nov string s dalzhina - broya na lat.azbuka
		char[] arrayT = new char[25];
		int m = 0;
		boolean f = false;// flag za povtaryasht se simvol

		arrayT[0] = kod.charAt(0);// na parva pozitsiya v noviya masiv slagame
									// parviya simvol ot stringa

		// prevartame chrez tsikal vseki simvol na stringa i go sravnyavame s
		// elementite ot masiva arrayT. Kogato nyama savpadenie go dobavyame,
		// kato	sledvasht v masiva
		for (int i = 1; i < n; i++) {
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

		// prenarezhdane v matrichen vid
		System.out.println("\nThe codetable is:");
		char[][] kodTable = new char[5][5];
		int k = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				kodTable[i][j] = arrayT[k];
				k++;
				if (kodTable[i][j] == 'I') {
					System.out.print("i/j" + " ");
				} else
					System.out.print(kodTable[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("\nEncoded the letters is:");

		int ia = 0;
		int ib = 0;
		int ja = 0;
		int jb = 0;
		String sr = null;

		// initsializirame masiv v koito shte zapishem novite zakodirani srichki
		String[] dw2 = new String[nDW];

		// obhozhdame masiva ot srichki
		for (int p = 0; p < nDW; p++) {
			char aDW = dw[p].charAt(0); // parva bukva ot srichkata
			char bDW = dw[p].charAt(1); // vtora bukva ot srichkata

			// dva tsikala za obhozhdate na tablitsata za razkodirane
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					// proverka kade se namira v tablitsata parvata bukva
					if (kodTable[i][j] == aDW) {
						ia = i;
						ja = j;
					}
					// proverka kade se namira v tablitsata vtorata bukva
					if (kodTable[i][j] == bDW) {
						ib = i;
						jb = j;
					}
				}
			}

			// kogato simvolite sa v pravoagalnik
			if ((ia != ib) && (ja != jb)) {
				sr = "<>";// oboznachavam, che dvoykata bukvi sa v pravoagalnik
				aDW = kodTable[ia][jb];
				bDW = kodTable[ib][ja];
			}
			// kogato simvolite sa na edin red
			if ((ia == ib) && (ja != jb)) {
				sr = "-";// oboznachavam, che dvoykata bukvi sa v reditsa
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
			// kogato simvolite sa v edna kolona
			if ((ja == jb) && (ia != ib)) {
				sr = "|"; // oboznachavam, che dvoykata bukvi sa v kolona
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
			// zapisvame zakodiranata srichka v poredniya element na masiva
			dw2[p] = "" + aDW + bDW;
			System.out.println(dw[p] + " " + sr + " " + dw2[p]);
		}
		System.out.println("\nEncrypted text:");
		for (int i = 0; i < dw2.length; i++) {
			System.out.print(dw2[i] + " ");
		}
	}
}
