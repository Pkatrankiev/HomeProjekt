package Human;

public class Student extends Human {

	public String numberGSM;
	public String numberKlass;

	public Student(String name, long egn, int age, String numberGSM,
			String numberKlass) {
		super(name, egn, age);

		this.numberGSM = numberGSM;
		this.numberKlass = numberKlass;
	}

	public String getnumberGSM() {
		return numberGSM;
	}

	public void setNumberGSM(String numberGSM) {
		this.numberGSM = numberGSM;
	}

	public String getNumberKlass() {
		return numberKlass;
	}

	public void setNumberKlass(String numberKlass) {
		this.numberKlass = numberKlass;
	}

	public String getGSMoperator(String numberGSM) {
		String operator;

		switch (numberGSM.charAt(3)) {
		case '7':
			operator = "Vivatel";
			break;
		case '8':
			operator = "M-Tel";
			break;
		case '9':
			operator = "Telenor";
			break;
		default:
			operator = "Nevalifden nomer:";
			break;
		}
		return operator;
	}
}
