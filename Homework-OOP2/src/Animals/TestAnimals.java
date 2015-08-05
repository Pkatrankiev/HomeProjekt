package Animals;

public class TestAnimals {

	public static void main(String[] args) {
		
		Animals[] animal = new Animals[11];
		
		Dog dog1 = new Dog ("Pufi",2,"Male");
		Dog dog2 = new Dog ("Roko",1,"Male");
		Dog dog3 = new Dog ("Fifi",3,"Female");
		
		Cat cat1 = new Cat ("Mimi",2,"Female");
		Cat cat2 = new Cat ("Timi",1,"Male");
		Tomcat Tcat3 = new Tomcat ("Tom",3);
		Tomcat Tcat4 = new Tomcat ("Stich",2);
		Kitten Kcat5 = new Kitten ("Sisi",1);
		Kitten Kcat6 = new Kitten ("Maca",3);
		
		Frog frog1 = new Frog ("Kriki",1,"Female");
		Frog frog2 = new Frog ("Karmit",2,"Female");
		
		animal[0] = cat1;
		animal[1] = cat2;
		animal[2] = Tcat3;
		animal[3] = Tcat4;
		animal[4] = Kcat5;
		animal[5] = Kcat6;
		animal[6] = frog1;
		animal[7] = frog2;
		animal[8] = dog1;
		animal[9] = dog2;
		animal[10] = dog3;
		
		
		
		for (int i = 0; i < animal.length; i++) {
		System.out.println("My name is: "+ animal[i].getName());
		
		System.out.print("I say: ");
		animal[i].produceSound();
		System.out.println("****************");
		}
		
		
		System.out.println("Average age for Cats is: "+ cat1.mindCatAge());
		System.out.println("Average age for Dogs is: "+ dog1.mindDogAge());
		System.out.println("Average age for Frogs is: "+ frog1.mindFrogAge());
	}

	
}
