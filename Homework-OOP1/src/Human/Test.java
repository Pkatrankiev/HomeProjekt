package Human;

public class Test {

	public static void main(String[] args) {
		
		Teacher lector1 = new Teacher("Ivan Ivanov",6604231962l, 45, 22, "biology");
		Student stud1 = new Student("Ivanka Stoianova", 8810051938l, 22, "0888453288", "10A");
		
		System.out.println("The student "+ stud1.getName()+" is: "+stud1.EGNextrakt(stud1.getEgn()));
		System.out.println(lector1.getName()+" is lector of "+lector1.getSpecialty()+"."
		+lector1.FullLoad(lector1.getHoursPerWeek()));
		
		
}

}
