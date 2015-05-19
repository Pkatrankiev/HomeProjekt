import java.util.Scanner;

public class PlayfairDeCipher {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String sr = null;

		// ��������� ������ �� ����������
		System.out.print("�������� ������ �� ����������! ");
		String strWord = input.nextLine();

		// ������������� ��.������� � ������
		String strWordBig = strWord.toUpperCase();

		// ��������� ���������� ����
		System.out.print("�������� ���������� ����! ");
		strWord = input.nextLine();

		// ��� ������ �������� �������� ����� �� ���.������
		strWord = strWord + "abcdefghiklmnopqrstuvwxyz";

		// ������������� ��.������� � ������
		String kod = strWord.toUpperCase();

		// �� ���� ������ �� ������ ����������� �� � �������� �������

		// �������������� ���������� n � ��������� �� �������
		int n = kod.length();

		// � ��� ������ � ������� - ���� �� ���.������
		char[] arrayT = new char[25];
		int m = 0;
		boolean f = false; // ���� �� ������ ��� �������� �� ������

		arrayT[0] = kod.charAt(0); // �� ����� ������� � ����� ����� �������
									// ������ ������ �� �������

		// ���������� ���� ����� ����� ������ �� ������� � �� ���������� �
		// ���������� �� ������ arrayT. ������ ���� ���������� �� ��������, ����
		// ������� � ������
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

		// ������������ � �������� ���
		System.out.println("��������� �� �������� �:");
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

		System.out.println("������������� �� �������� �:");

		int ia = 0;
		int ib = 0;
		int ja = 0;
		int jb = 0;
		int l = 0;

		// ���������� ����� ������ �� ������� �� ����������� � ����� �� �������
		char[] kodStr = strWordBig.toCharArray();

		// �������������� ����� � ����� �� ������� ������ ����������� ������
		String[] dw2 = new String[kodStr.length];

		// �� ���������� ����������� ����� � � ������ ��������� � �����
		// ��������� ������ � ��� ������ 3 /������+�����/
		for (int p = 0; p < kodStr.length; p = p + 3) {
			char aDW = kodStr[p]; // ����� ����� �� ��������
			char bDW = kodStr[p + 1]; // ����� ����� �� ��������

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
			// ������ ��������� �� � ���� ������
			if ((ja == jb) && (ia != ib)) {
				sr = "|"; // �����������, �� �������� ����� �� � ������
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
			// ��������� ������������� ������ � �������� ������� �� ������
			dw2[l] = "" + aDW + bDW;
			System.out.println(kodStr[p] + "" + kodStr[p + 1] + " " + sr + " "
					+ dw2[l]);
			l++;
		}
		for (int i = 0; i < l; i++) {
			System.out.print(dw2[i]);
		}
	}

}
