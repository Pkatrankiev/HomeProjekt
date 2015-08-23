package Students;
import java.util.ArrayList;

public class ClassInfo {
	
	private String classNumber;
	private String roomNumber;
	private String classManager;
	private ArrayList<Students> students;
	private ArrayList<Teacher> teachers;
	
	public ClassInfo(String classNumber, String roomNumber, String classManager) {
		super();
		this.students = new ArrayList<>();
		this.teachers = new ArrayList<>();
		this.classNumber = classNumber;
		this.roomNumber = roomNumber;
		this.classManager = classManager;
	}
	
	public void addStudent(Students stud) {
		this.students.add(stud);
	}
	
	public void addTeacher(Teacher teach) {
		this.teachers.add(teach);
	}
	
	public double classGPA() {
		double gpa = 0;
		int count = 0;
		
		for (int i = 0; i < students.size(); i++) {
			gpa = gpa + students.get(i).getGpa();
			count++;
		}
		
		return (gpa/count);
	}
	
	public int allTeachersExp() {
		int years = 0;
		for (int i = 0; i < teachers.size(); i++) {
			years = years + teachers.get(i).getExp();
		}
		return years;
	}
	
	public ArrayList<Human> gotBirthday(String date) {
		ArrayList<Human> allBirthdays = new ArrayList<>();
		String stDate;
		for (int i = 0; i < teachers.size(); i++) {
			stDate = teachers.get(i).getBornDate().substring(0,5);
		if (date.equals(stDate)) {
				allBirthdays.add(teachers.get(i));
			}
		}
		
		for (int i = 0; i < students.size(); i++) {
			stDate = students.get(i).getBornDate().substring(0,5);
			if (date.equals(stDate)) {
				allBirthdays.add(students.get(i));
			}
		}
		
		return allBirthdays;
		
	}
	
	

	public String getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getClassManager() {
		return classManager;
	}
	public void setClassManager(String classManager) {
		this.classManager = classManager;
	}
	

}
