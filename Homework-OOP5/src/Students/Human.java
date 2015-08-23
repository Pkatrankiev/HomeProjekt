package Students;

public class Human {
	
	private String name;
	private String bornDate;
	
	public Human(String name, String bornDate) {
		super();
		this.name = name;
		this.bornDate = bornDate;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getBornDate() {
		return bornDate;
	}
	public void setBornDate(String bornDate) {
		this.bornDate = bornDate;
	}

}
