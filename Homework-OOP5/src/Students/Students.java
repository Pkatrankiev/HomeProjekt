package Students;

public class Students extends Human{
	private double gpa;

	public Students(String name, String bornDate, double gpa) {
		super(name, bornDate);
		this.gpa = gpa;
		
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

}
