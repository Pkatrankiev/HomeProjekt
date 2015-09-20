package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import java.util.Date;
import java.util.List;

import javax.xml.crypto.Data;

import ui.ScreenTest;
import db.CinemaTheater;
import db.Movie;

public class ButtonTheaterListener implements ActionListener {


	
	private CinemaTheater TheaterCurentMovie;
	private Date day;
	public ButtonTheaterListener(CinemaTheater TheaterCurentMovie, Date day) {
		this.day = day;
		this.TheaterCurentMovie = TheaterCurentMovie;
	}

//	private CinemaTheater TheaterCurentMovie;
//	private Date day;
//
//	public ButtonTheaterListener(CinemaTheater theaterCurentMovie, Date day) {
//		this.day = day;
//		this.TheaterCurentMovie = theaterCurentMovie;
//	}



//	public ButtonTheaterListener(CinemaTheater theaterCurentMovie, Date day) {
//		// TODO Auto-generated constructor stub
//		
//	}



	

//	public ButtonTheaterListener(CinemaTheater cinemaTheater, Date date) {
//		// TODO Auto-generated constructor stub
//	}

//	@Ovehrride
	public void actionPerformed(ActionEvent e) {
		
//		String str = theaterCurentMovie.getName();

//			new TheaterMovieProgramScreen().setVisible(true);
	}

	private ArrayList<CinemaTheater> ListTheaterInMovie(int x) {
		String cw = CinemaTheater.getListCinemaTheater().get(x).getName();
		String ff = Movie.getListMovie().get(x).getBgName();
		int cc = CinemaTheater.getListCinemaTheater().size();
		
		CinemaTheater[] theaterMovie = new CinemaTheater[cc];
		
		int indexMovie = Movie.getListMovie().get(x).getIndeksMovie();
		ArrayList<CinemaTheater> theaterList = new ArrayList<CinemaTheater>();
		String []theaterNameList = new String [cc];
		String theater;
		int count = 0;
		boolean fl = true;
		boolean fl1 = false;
		for (int i = 0; i < cc; i++) {
			if (CinemaTheater.getListCinemaTheater().get(i).getIndeksMovie() == indexMovie) {
				theater = CinemaTheater.getListCinemaTheater().get(i).getName();
				if (fl) {
					theaterNameList[0] = theater;
					theaterList.add(CinemaTheater.getListCinemaTheater().get(i));
					count++;
					fl = false;
				}
				for (int j = 0; j < count; j++) {
					if (!theaterNameList[j].equals(theater)) {
						fl1 =true;
						
					}
				}
				if (fl1) {
					theaterList.add(CinemaTheater.getListCinemaTheater().get(i));
					theaterNameList[count]= theater;
					System.out.println(" - _"+theaterList.get(count).getName());
					count++;
				}
			}

		}
		for (int i = 0; i < count; i++) {
			System.out.println(theaterNameList[i]);
		}
		for (int i = 0; i < count; i++) {
			theater = theaterList.get(i).getName();
			System.out.println(theater);
		}
		return theaterList;
	}

	
}
