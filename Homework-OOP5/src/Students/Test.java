package Students;

import java.util.Scanner;
public class Test {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		ClassInfo myClass = new ClassInfo("12A", "205", "Georgi Petkov");
		Students student1 = new Students("Ivo Ivov", "26.01.1990", 3.37);
		Students student2 = new Students("Ivan Ivov", "28.03.1990", 4.40);
		Students student3 = new Students("Ivailo Ivov", "11.02.1990", 5.83);
		
		Teacher teach1 = new Teacher("Georgi Borisov", "28.01.1966", 12);
		Teacher teach2 = new Teacher("Bobi Bobov", "23.02.1971", 10);
		Teacher teach3 = new Teacher("Miro Mironov", "28.03.1990", 9);
		
		myClass.addStudent(student1);
		myClass.addStudent(student2);
		myClass.addStudent(student3);
		myClass.addTeacher(teach1);
		myClass.addTeacher(teach2);
		myClass.addTeacher(teach3);
		
		System.out.println("GPA of the class is: "+myClass.classGPA());
		System.out.println("Total years of service of teachers is: "+myClass.allTeachersExp()+" years.");
		
		System.out.print("Enter the date of birth!(dd.mm)");
		String messadge;
		
		messadge = input.next();
		System.out.println("In "+messadge+" birthday have:");
		int count = myClass.gotBirthday(messadge).size();
		for (int j = 0; j < count; j++) {
			System.out.println(myClass.gotBirthday(messadge).get(j).getName());
		}
		
		
	}

}
