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
		int cc = CinemaTheater.getListCinemaTheater().size();
		ArrayList<CinemaTheater> theaterList = new ArrayList<CinemaTheater>();
		
		theaterList = ListTheaterInMovie(x);
		
		new MovieListTheaterScreen(theaterList).setVisible(true);
	}

	private ArrayList<CinemaTheater> ListTheaterInMovie(int x) {
		String cw = CinemaTheater.getListCinemaTheater().get(x).getName();
		String ff = Movie.getListMovie().get(x).getBgName();
		int cc = CinemaTheater.getListCinemaTheater().size();

		CinemaTheater[] theaterMovie = new CinemaTheater[cc];

		int indexMovie = Movie.getListMovie().get(x).getIndeksMovie();
		ArrayList<CinemaTheater> theaterList = new ArrayList<CinemaTheater>();
		String[] theaterNameList = new String[cc];
		String theater;
		int count = 0;
		boolean fl = true;
		boolean fl1 = true;
//		System.out.println("theaterNameList = "+cc);
		for (int i = 0; i < cc; i++) {
			if (CinemaTheater.getListCinemaTheater().get(i).getIndeksMovie() == indexMovie) {
				theater = CinemaTheater.getListCinemaTheater().get(i).getName();
				
				if (fl) {
					theaterNameList[0] = theater;
					theaterList.add(CinemaTheater.getListCinemaTheater().get(i));
					count++;
					fl = false;
				}
//				System.out.println(" count "+count+" <> theater "+theater);
				for (int j = 0; j < count; j++) {
//					System.out.println(j+" theaterNameList[j] = "+theaterNameList[j]);
//					System.out.println(i+" theater = "+theater+"  "+fl1);
					if (theaterNameList[j].equals(theater)) {
						fl1 = false;
						 
						}else fl1 = true;
				}
				
				
				if (fl1) {
					theaterList.add(CinemaTheater.getListCinemaTheater().get(i));
					theaterNameList[count] = theater;
//					System.out.println(count+" - "+ theaterList.get(count).getName());
					count++;
					fl1 = true;
				}
			}

		}
		for (int i = 0; i < count; i++) {
//			System.out.println(theaterNameList[i]);
		}
		for (int i = 0; i < count; i++) {
			theater = theaterList.get(i).getName();
//			System.out.println(theater);
		}
		return theaterList;
	}

	public int getX() {
		return x;
	}

}
