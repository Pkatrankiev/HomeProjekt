import java.util.Scanner;

public class PlayfairCipher {

	public static StringBuilder UpAndSplitMetod(String strWord) {

		// ������������� ��.������� � ������
		String kod = strWord.toUpperCase();

		// ���������� � ������� ������ ������� "J" � "I"
		kod = kod.replaceAll("J", "I");

		// [\d\s,:], ���������� ������ �����, ������ ���������, , : ; . ! ?
		String[] kodStr = kod.split("[\\d\\s,:;.!?]+");

		// ������������� ������ � �����
		// ��� StringBuilder �� �� ������� ����� � �������
		StringBuilder encodingText = new StringBuilder();
		for (String chap : kodStr) {
			encodingText.append(chap);
		}
		return encodingText;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// ��������� ������ �� ��������
		System.out.print("�������� ������ �� ��������! ");
		String strWord = input.nextLine();

		StringBuilder encodingText = UpAndSplitMetod(strWord);

		// �������� '�' �/� ������� �������
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

		// �������� 'X' �� ������� �� ����
		if (textWithX.length() % 2 != 0) {
			textWithX.append('X');
		}

		// ��������� ������ �� ������
		int n = textWithX.length() / 2;
		String[] dw = new String[n];
		for (int i = 0; i < n; i++) {
			dw[i] = textWithX.substring(i * 2, i * 2 + 2);
		}
		int nDW = n;

		// ��������� ���������� ����
		System.out.print("�������� ���������� ����! ");
		strWord = input.nextLine();

		// ��� ������ �������� �������� ����� �� ���.������
		strWord = strWord + "abcdefghiklmnopqrstuvwxyz";

		StringBuilder kod = UpAndSplitMetod(strWord);

		// �������������� ���������� n � ��������� �� �������
		n = kod.length();

		// � ��� ������ � ������� - ���� �� ���.������
		char[] arrayT = new char[25];
		int m = 0;
		boolean f = false;// ���� �� �������� �� ������

		arrayT[0] = kod.charAt(0);// �� ����� ������� � ����� ����� �������
									// ������ ������ �� �������

		// ���������� ���� ����� ����� ������ �� ������� � �� ���������� �
		// ���������� �� ������ arrayT. ������ ���� ���������� �� ��������, ����
		// ������� � ������
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

		// ������������ � �������� ���
		System.out.println("\n��������� �� �������� �:");
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

		System.out.println("\n������������ �� �������� �:");

		int ia = 0;
		int ib = 0;
		int ja = 0;
		int jb = 0;
		String sr = null;

		// �������������� ����� � ����� �� ������� ������ ���������� ������
		String[] dw2 = new String[nDW];

		// ��������� ������ �� ������
		for (int p = 0; p < nDW; p++) {
			char aDW = dw[p].charAt(0); // ����� ����� �� ��������
			char bDW = dw[p].charAt(1); // ����� ����� �� ��������

			// ��� ������ �� ��������� �� ��������� �� �����������
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					// �������� ���� �� ������ � ��������� ������� �����
					if (kodTable[i][j] == aDW) {
						ia = i;
						ja = j;
					}
					// �������� ���� �� ������ � ��������� ������� �����
					if (kodTable[i][j] == bDW) {
						ib = i;
						jb = j;
					}
				}
			}

			// ������ ��������� �� � ������������
			if ((ia != ib) && (ja != jb)) {
				sr = "<>";// �����������, �� �������� ����� �� � ������������
				aDW = kodTable[ia][jb];
				bDW = kodTable[ib][ja];
			}
			// ������ ��������� �� �� ���� ���
			if ((ia == ib) && (ja != jb)) {
				sr = "-";// �����������, �� �������� ����� �� � ������
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
			// ������ ��������� �� � ���� ������
			if ((ja == jb) && (ia != ib)) {
				sr = "|"; // �����������, �� �������� ����� �� � ������
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
			// ��������� ������������ ������ � �������� ������� �� ������
			dw2[p] = "" + aDW + bDW;
			System.out.println(dw[p] + " " + sr + " " + dw2[p]);
		}
		System.out.println("\n������������ ����� �:");
		for (int i = 0; i < dw2.length; i++) {
			System.out.print(dw2[i] + " ");
		}
	}
}
