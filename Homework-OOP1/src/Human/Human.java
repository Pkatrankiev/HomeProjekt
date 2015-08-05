package Human;

public class Human extends EGNExtractor {
	public String name;
	public int age;

	public Human(String name, long egn, int age) {
		super(egn);
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender(long egn) {
		return EGNextrakt(egn);
	}
}
