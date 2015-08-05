package Animals;

public class Cat extends Animals{
	
	private static int catNum = 0;
	private static Float catAge = 0f;
	
	public Cat(String name, int age, String sex) {
		super(name, age, sex);
		catNum++;
		catAge = catAge + age;
		
	}

	@Override
	public void produceSound() {
		System.out.println("Miau - miau");

	}

	public static int getCatNum() {
		return catNum;
	}

	public static void setCatNum(int catNum) {
		Cat.catNum = catNum;
	}

	public static Float getCatAge() {
		return catAge;
	}
	
	public static Float mindCatAge(){
		return catAge/catNum;
	}
}
