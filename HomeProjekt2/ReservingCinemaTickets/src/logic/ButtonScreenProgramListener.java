package logic;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ui.ProgramScreen;


public class ButtonScreenProgramListener implements ActionListener {
	
	private String date;
	private String nameTheater;
	private int x;
	
	public  ButtonScreenProgramListener(int x, String date, String nameTheater){
		
		this.date = date;
		this.nameTheater = nameTheater;
		this.x=x;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		if (x<0){
			
			ProgramScreen.isDefaultLookAndFeelDecorated();
		}
		else{
		new ProgramScreen(date, nameTheater).setVisible(true);
	}
	}
	
	
}
