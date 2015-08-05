package Human;

public class Teacher extends Human{
	
	public int hoursPerWeek;
	public String specialty;
	
	public Teacher(String name, long egn, int age, int hoursPerWeek,
			String specialty) {
		super(name, egn, age);
		
		this.hoursPerWeek = hoursPerWeek;
		this.specialty = specialty;
	}

	public int getHoursPerWeek() {
		return hoursPerWeek;
	}

	
	public void setHoursPerWeek(int hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
	
	
	@Override
	public String EGNextrakt(long egn) {
		// TODO Auto-generated method stub
		return super.EGNextrakt(egn);
	}

	public String FullLoad (int hoursPerWeek){
		String str;
		if (hoursPerWeek>=22) {
			str = "This Teacher is of full Load in school.";
		}else str = "This Teacher is no of full Load in school.";
		return str;
	}
	

}
