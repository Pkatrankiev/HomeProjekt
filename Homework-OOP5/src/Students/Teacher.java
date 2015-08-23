package Students;

public class Teacher extends Human{
	private int exp;

	public Teacher(String name, String bornDate, int exp) {
		super(name, bornDate);
		this.exp = exp;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

}
