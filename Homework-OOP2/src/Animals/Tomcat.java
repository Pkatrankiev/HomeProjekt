package Animals;

public class Tomcat extends Cat{

	private static String tomSex = "Male";
			
	
	public Tomcat(String name, int age) {
		super(name, age, tomSex);
		
	}


	@Override
	public void produceSound() {
		System.out.println("Murr-Miau, murr-miau");
//		super.produceSound();
	}

}
