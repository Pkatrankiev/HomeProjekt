package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.MovieListTheaterScreen;
import ui.TheaterProjectionScreen;
import db.CinemaTheater;

public class ButtonProjectionListener implements ActionListener{

	private CinemaTheater theaterProjection;
	public ButtonProjectionListener(CinemaTheater theaterProjection) {
		this.theaterProjection = theaterProjection;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		new TheaterProjectionScreen(theaterProjection).setVisible(true);
		
	}

}
