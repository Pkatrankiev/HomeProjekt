package Date;

public class test {

	public static void main(String[] args) {
		
		holidayDate date1 = new holidayDate(24,12);

		if (date1.ifHolidayDate()) {
			System.out.println("Date " + date1.getNewDate() + "/"
					+ +date1.getNewMont() + " is Holiday.");
		} else
			System.out.println("Date " + date1.getNewDate() + "/"
					+ +date1.getNewMont() + " is no Holiday.");

	}

}
