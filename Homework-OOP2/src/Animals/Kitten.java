package Animals;

public class Kitten extends Cat {

	
	private static String kitSex = "Female";

	public Kitten(String kitName, int kitAge) {
		super(kitName, kitAge, kitSex); 
}

	@Override
	public void produceSound() {
		System.out.println("Miau-miau, miau-miau");

	}
	
}