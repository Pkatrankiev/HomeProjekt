package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import ui.MovieListTheaterScreen;
import db.CinemaTheater;
import db.Movie;

public class ButtonListener implements ActionListener {

	private int x;

	public ButtonListener(int x) {
		this.x = x;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		ArrayList<CinemaTheater> theaterList = new ArrayList<CinemaTheater>();

		theaterList = ListTheaterInMovie(x);
		Movie curentMovie = Movie.getListMovie().get(x);
		new MovieListTheaterScreen(theaterList, curentMovie).setVisible(true);
	}

	private ArrayList<CinemaTheater> ListTheaterInMovie(int x) {

		int cc = CinemaTheater.getListCinemaTheater().size();
		int indexMovie = Movie.getListMovie().get(x).getIndeksMovie();
		ArrayList<CinemaTheater> theaterList = new ArrayList<CinemaTheater>();
		String[] theaterNameList = new String[cc];
		String theater;
		int count = 0;
		boolean fl = true;
		boolean fl1 = true;

		for (int i = 0; i < cc; i++) {
			if (CinemaTheater.getListCinemaTheater().get(i).getIndeksMovie() == indexMovie) {
				theater = CinemaTheater.getListCinemaTheater().get(i).getName();

				if (fl) {
					theaterNameList[0] = theater;
					theaterList
							.add(CinemaTheater.getListCinemaTheater().get(i));
					count++;
					fl = false;
				}
				for (int j = 0; j < count; j++) {

					if (theaterNameList[j].equals(theater)) {
						fl1 = false;

					} else
						fl1 = true;
				}

				if (fl1) {
					theaterList
							.add(CinemaTheater.getListCinemaTheater().get(i));
					theaterNameList[count] = theater;

					count++;
					fl1 = true;
				}
			}

		}
		for (int i = 0; i < count; i++) {

		}
		for (int i = 0; i < count; i++) {
			theater = theaterList.get(i).getName();

		}
		return theaterList;
	}

	public int getX() {
		return x;
	}

}
