package Library2;

public class newspaper extends publication{
	
	
	public String dateOfIssue;

	public newspaper(String title, String dateOfIssue, boolean employed) {
		super(title, employed);
		
		this.dateOfIssue = dateOfIssue;
	}

	public String getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(String dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
	
	
	

	
	
	

}
