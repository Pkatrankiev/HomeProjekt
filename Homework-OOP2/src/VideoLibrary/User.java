package VideoLibrary;



public class User {


	public  String userName;
	public  boolean obliged;

	public User(String userName,boolean obliged) {

		this.userName = userName;
		this.obliged = obliged;
		
	}

	public boolean isObliged() {
		return obliged;
	}

	public void setObliged(boolean obliged) {
		this.obliged = obliged;
	}

	public String getUserName() {
		return userName;
	}

	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	

	
}
