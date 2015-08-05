package VideoLibrary;

import java.util.ArrayList;

public class VideoLibrary {

	public static ArrayList<VideoTaipe> allTaipe;
	public static ArrayList<User> allUser;

	public VideoLibrary() {

		this.allTaipe = new ArrayList<>();
		this.allUser = new ArrayList<>();
	}

	void addTaipe(VideoTaipe taipe) {
		allTaipe.add(taipe);
	}

	public String getTitle(int position) {
		return allTaipe.get(position).title;
	}

	public static String getUserNameInTaipe(int position) {
		return allTaipe.get(position).userName;
	}

	public static void setUserNameInTaipe(int position, String userName) {
		allTaipe.get(position).setUserName(userName);
	}

	public static void setAvailable(int position, boolean available) {
		allTaipe.get(position).setAvailable(available);
	}

	public static void setObligedUser(int position, boolean available) {
		allUser.get(position).setObliged(available);
	}

	public String getDateReturn(int position) {
		return allTaipe.get(position).dateReturn;
	}

	public static void setDateReturn(int position, String dateMaking) {
		allTaipe.get(position).setDateReturn(dateMaking);
	}

	public String getDateMaking(int position) {
		return allTaipe.get(position).dateMaking;
	}

	public static void setDateMaking(int position, String dateMaking) {
		allTaipe.get(position).setDateMaking(dateMaking);
	}

	public ArrayList<VideoTaipe> getAllTaipe() {
		return allTaipe;
	}

	public static VideoTaipe getTaipe(int position) {
		return allTaipe.get(position);
	}

	public static void OpisTape() {
		for (int i = 0; i < allTaipe.size(); i++) {
			System.out.println(i + " - " + allTaipe.get(i).getTitle()
					+ " potrebitel " + allTaipe.get(i).getUserName());
		}
	}

	public static void OpisNotAvailableTape() {
		for (int i = 0; i < allTaipe.size(); i++) {
			if (!allTaipe.get(i).isAvailable()) {
				System.out.println();
				System.out.printf(
						"%s naeta ot %s na %s trqbva da q vaene na %s",
						allTaipe.get(i).getTitle(), allTaipe.get(i)
								.getUserName(),
						allTaipe.get(i).getDateMaking(), allTaipe.get(i)
								.getDateReturn());
			}
		}
	}

	public static void OpisFreeTape() {
		for (int i = 0; i < allTaipe.size(); i++) {
			if (allTaipe.get(i).isAvailable()) {
				System.out.printf("%n%d - %s", i, allTaipe.get(i).getTitle());
			}

		}
	}

	public static void OpisTaipesOfUser(String UserName) {
		int index = getNumbrUserInName(UserName);
		if (index >= 0) {
			String userName2;
			for (int j = 0; j < allTaipe.size(); j++) {
				userName2 = allTaipe.get(j).getUserName();
				if (userName2 != null) {
					if (userName2.equals(UserName)) {
						System.out.println(j + " - "
								+ allTaipe.get(j).getTitle());
					}
				}
			}
		}
	}

	public static void OpisTaipesOfObligedUser() {
		String userName1, userName2;
		for (int i = 0; i < allUser.size(); i++) {
			if (allUser.get(i).isObliged()) {
				userName1 = allUser.get(i).getUserName();
				System.out.printf("%s e vzel slednite kasetki: %n", userName1);
				for (int j = 0; j < allTaipe.size(); j++) {
					userName2 = allTaipe.get(j).getUserName();
					if (userName2 != null) {
						if (userName2.equals(userName1)) {
							System.out.println(j + " - "
									+ allTaipe.get(j).getTitle());
						}
					}
				}
			}
		}
	}

	public static void returnTaipe(int TaipeChoise) {
		setAvailable(TaipeChoise, true);
		String Name = getUserNameInTaipe(TaipeChoise);
		setUserNameInTaipe(TaipeChoise, null);
		boolean fl = true;
		for (int j = 0; j < allTaipe.size(); j++) {
			String userName2 = allTaipe.get(j).getUserName();
			if (userName2 != null) {
				if (userName2.equals(Name)) {
					fl = false;
				}
			}
		}
		if (fl) {
			int position = getNumbrUserInName(Name);
			setObligedUser(position, false);
		}
	}

	
	public static String getUserName(int position) {
		return allUser.get(position).userName;
	}

	public void addUser(User user) {
		allUser.add(user);

	}

	public void makeUser(String userName, boolean obliged) {
		User user = new User(userName, obliged);
		allUser.add(user);

	}

	public static User getUser(int UserPosition) {
		return allUser.get(UserPosition);
	}

	public static User getUserInName(String UserName) {
		User user = null;
		for (int i = 0; i < allUser.size(); i++) {
			if (UserName == allUser.get(i).getUserName()) {
				user = getUser(i);
				return user;
			}
		}
		return user;
	}

	public static int getNumbrUserInName(String UserName) {
		int number = -1;
		for (int i = 0; i < allUser.size(); i++) {
			if (UserName == allUser.get(i).getUserName()) {
				number = i;
				return number;
			}
		}
		return number;
	}

	public int getNumbrUser() {
		return allUser.size();
	}

	public static void OpisUser() {
		for (int i = 0; i < allUser.size(); i++) {
			System.out.println(i + " - " + allUser.get(i).getUserName());
		}
	}
	
	public static void OpisObligedUser() {
		for (int i = 0; i < allUser.size(); i++) {
			if (allUser.get(i).isObliged()) {
			System.out.println(i + " - " + allUser.get(i).getUserName());	
			}
			
		}
	}

}
