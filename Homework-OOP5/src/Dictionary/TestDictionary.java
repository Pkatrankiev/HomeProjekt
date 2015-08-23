package Dictionary;

import java.util.Scanner;

public class TestDictionary {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		CoupleWords Word1 = new CoupleWords("love", "�����");
		CoupleWords Word2 = new CoupleWords("access", "������");
		CoupleWords Word3 = new CoupleWords("word", "����");
		CoupleWords Word4 = new CoupleWords("stool", "����");
		CoupleWords Word5 = new CoupleWords("newspaper", "�������");
		CoupleWords Word6 = new CoupleWords("dictionary", "������");
		CoupleWords Word7 = new CoupleWords("ability", "������");
		CoupleWords Word8 = new CoupleWords("appearance", "�����");
		CoupleWords Word9 = new CoupleWords("adoption", "��������");
		
		Dictionary dict = new Dictionary();
		
		dict.addDict(Word1);
		dict.addDict(Word2);
		dict.addDict(Word3);
		dict.addDict(Word4);
		dict.addDict(Word5);
		dict.addDict(Word6);
		dict.addDict(Word7);
		dict.addDict(Word8);
		dict.addDict(Word9);
		
		
		System.out.println("Enter word in english for translation!");
		String messadge = input.next();
		dict.lookup(messadge);
		
		System.out.println("Enter word in bulgarian for translation!");
		messadge = input.next();
		dict.lookupBG(messadge);
		
		System.out.println("Enter a letter in english!");
		messadge = input.next();
		char ch = messadge.charAt(0);
		dict.LookForPoint(ch);
	}

}
