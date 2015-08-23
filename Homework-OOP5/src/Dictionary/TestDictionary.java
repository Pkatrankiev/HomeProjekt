package Dictionary;

import java.util.Scanner;

public class TestDictionary {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		CoupleWords Word1 = new CoupleWords("love", "любов");
		CoupleWords Word2 = new CoupleWords("access", "достъп");
		CoupleWords Word3 = new CoupleWords("word", "дума");
		CoupleWords Word4 = new CoupleWords("stool", "стол");
		CoupleWords Word5 = new CoupleWords("newspaper", "вестник");
		CoupleWords Word6 = new CoupleWords("dictionary", "речник");
		CoupleWords Word7 = new CoupleWords("ability", "Умение");
		CoupleWords Word8 = new CoupleWords("appearance", "поява");
		CoupleWords Word9 = new CoupleWords("adoption", "приемане");
		
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
