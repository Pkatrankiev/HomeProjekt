package Dictionary;

import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
	Scanner input = new Scanner(System.in);

	public static ArrayList<CoupleWords> couplewords;

	public Dictionary() {

		this.couplewords = new ArrayList<>();
	}

	public void addTranslation(String wordEN, String wordBG) {
		CoupleWords coWords = new CoupleWords(wordEN, wordBG);
		couplewords.add(coWords);
	}

	public void lookup(String wordEN) {

		boolean fl = true;
		for (int j = 0; j < couplewords.size(); j++) {
			String wordSearch = couplewords.get(j).getWordEN();
			if (wordSearch != null) {
				if (wordSearch.equals(wordEN)) {
					fl = false;
					System.out.printf("Translation of %s is %s \n", wordEN,
							couplewords.get(j).getWordBG());
					break;
				}
			}
		}
		if (fl) {
			System.out.println("This word exists in the dictionary.");
			System.out.println("Do you want to fill in dictionary? Yes/No");
			String messadge = input.next();
			if (messadge.equals("Yes")){
			HaveAddEN(wordEN);	
			}
		}
	}

	public void lookupBG(String wordBG) {

		boolean fl = true;
		for (int j = 0; j < couplewords.size(); j++) {
			String wordSearch = couplewords.get(j).getWordBG();
			if (wordSearch != null) {
				if (wordSearch.equals(wordBG)) {
					fl = false;
					System.out.printf("Translation of %s is %s \n", wordBG,
							couplewords.get(j).getWordEN());
					break;
				}
			}
		}
		if (fl) {
			System.out.println("This word exists in the dictionary.");
			System.out.println("Do you want to fill in dictionary? Yes/No");
			String messadge = input.next();
			if (messadge.equals("Yes")){
			HaveAddBG(wordBG);	
			}
		}
	}

	public void LookForPoint(char charEN) {
		boolean fl = true;
		for (int j = 0; j < couplewords.size(); j++) {
			String charSearch = couplewords.get(j).getWordEN();
			if (charSearch != null) {
				if (charSearch.charAt(0) == charEN) {
					fl = false;
					System.out.println(couplewords.get(j).getWordEN());
				}
			}
		}
		if (fl) {
			System.out.println("In the dictionary exists word begining in "+charEN);
			
		}
	}

	public static ArrayList<CoupleWords> getCouplewords() {
		return couplewords;
	}

	public static void setCouplewords(ArrayList<CoupleWords> couplewords) {
		Dictionary.couplewords = couplewords;
	}

	public void addDict(CoupleWords word) {
		couplewords.add(word);
	}

	public void HaveAddEN(String wordEN) {
		System.out.printf("Enter the translation of the Bulgarian for %s \n",
				wordEN);
		String messadge = input.next();
		addTranslation(wordEN, messadge);

	}

	public void HaveAddBG(String wordBG) {
		System.out.printf("Enter the translation in English for %s \n", wordBG);
		String messadge = input.next();
		addTranslation(messadge, wordBG);
	}
}
