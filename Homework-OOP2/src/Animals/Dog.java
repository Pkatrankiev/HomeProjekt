package Animals;

public class Dog extends Animals {

	private static int dogNum = 0;
	private static Float dogAge = 0f;
	
	public Dog(String name, int age, String sex) {
		super(name, age, sex);
		
		dogNum++;
		dogAge = dogAge + age;
	}

	@Override
	public void produceSound() {
		System.out.println("Baf - baf");

	}
	
	public static Float mindDogAge(){
		return dogAge/dogNum;
	}
	

}
