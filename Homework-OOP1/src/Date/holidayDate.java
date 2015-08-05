package Date;

import java.util.Date;


public class holidayDate extends Date {

	public static int newDate;
	public static int newMont;

	public holidayDate(int newDate, int newMont) {
		super();
		this.newDate = newDate;
		this.newMont = newMont;
	}
	
	
	public static int getNewDate() {
		return newDate;
	}

	public void setNewDate(int newDate) {
		this.newDate = newDate;
	}

	public static int getNewMont() {
		return newMont;
	}

	public void setNewMont(int newMont) {
		this.newMont = newMont;
	}

	public boolean ifHolidayDate (){
		
		boolean fl= false; 
		
		switch (holidayDate.getNewMont()) {
		case 1:if (holidayDate.getNewDate()==1){fl = true;	}break;
		case 3:if (getNewDate()==3){fl = true;	}break;
		case 5:if (getNewDate()==1||getNewDate()==6||getNewDate()==24){fl = true;}break;
		case 9:if (getNewDate()==6||getNewDate()==22){fl = true;	}break;
		case 10:if (getNewDate()==1){fl = true;	}break;
		case 12:if (getNewDate()==24||getNewDate()==25||getNewDate()==26){fl = true;}break;
		};
	
		return fl;
	}
	
}