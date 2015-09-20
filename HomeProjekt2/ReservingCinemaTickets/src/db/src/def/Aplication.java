package def;

import java.awt.EventQueue;
import ui.MoviesScreen;
import db.ReadFile;

public class Aplication {

	public static void main(String[] args) {
		
		ReadFile.readCinemaTheaterFile();
		ReadFile.readMovieFile();
		
		MoviesScreen frame = new MoviesScreen();
		frame.setVisible(true);
		
//		EventQueue.invokeLater(new Runnable() {
//			
//			public void run() {
//				try {
//					MoviesScreen frame = new MoviesScreen();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});


	}

}



