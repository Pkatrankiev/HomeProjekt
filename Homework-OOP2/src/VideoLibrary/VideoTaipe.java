package VideoLibrary;

public class VideoTaipe{

	public String userName;
	public String title;
	public boolean available;
	public String dateReturn;
	public String dateMaking;
	
	public VideoTaipe(String userName, String title, boolean available,
			String dateReturn, String dateMaking) {

		this.userName = userName;
		this.title = title;
		this.available = available;
		this.dateReturn = dateReturn;
		this.dateMaking = dateMaking;
	

	}

	public String getTitle() {
		return title;
	}

	

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	
	public String getDateReturn() {
		return dateReturn;
	}

	

	public void setDateReturn(String dateReturn) {
		this.dateReturn = dateReturn;
	}

	

	public String getDateMaking() {
		return dateMaking;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setDateMaking(String dateMaking) {
		this.dateMaking = dateMaking;
	}


	
		}
