package Library2;

import java.util.ArrayList;

public class Library {

	private String libraryName;
	private String libraryAdress;
	private String workTime;
	public static ArrayList<publication> allPublication;

	public Library(String libraryName, String libraryAdress, String workTime) {

		this.libraryName = libraryName;
		this.libraryAdress = libraryAdress;
		this.workTime = workTime;
		this.allPublication = new ArrayList<>();
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public String getLibraryAdress() {
		return libraryAdress;
	}

	public void setLibraryAdress(String libraryAdress) {
		this.libraryAdress = libraryAdress;
	}

	public String getWorkTime() {
		return workTime;
	}

	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}

	public void add(publication pub) {
		allPublication.add(pub);
	}

	public static void makeEmployed(publication curentPublic) {
		for (int i = 0; i < allPublication.size(); i++) {
			if (allPublication.get(i).equals(curentPublic)) {
				allPublication.get(i).Book();
			}

		}
	}
}
