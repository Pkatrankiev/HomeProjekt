package Animals;

public class Frog extends Animals{

	private static int frogNum = 0;
	private static Float frogAge = 0f;
	
	public Frog(String name, int age, String sex) {
		super(name, age, sex);
		
		frogNum++;
		frogAge = frogAge + age;
	
	}

	@Override
	public void produceSound() {
		System.out.println("Kvak - kvak");

	}
	
	public static Float mindFrogAge(){
		return frogAge/frogNum;
	}
	
}
