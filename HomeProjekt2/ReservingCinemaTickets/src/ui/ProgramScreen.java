package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import logic.ButtonProjectionListener;
import logic.ButtonScreenProgramListener;
import db.CinemaTheater;
import db.Movie;


public class ProgramScreen extends JFrame {

	private JPanel programPanel;
	private String dateLabel;
	private String theaterName;
	
	public ProgramScreen(String dateLabel, String theaterName) {
		
		this.theaterName = theaterName;
		this.dateLabel = dateLabel;

		
		setBounds(100, 100, 900, 600);
		programPanel = new JPanel();
		programPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(programPanel);
		programPanel.setLayout(null);

		ButtonTheaterList();
		ButtonDateList();
		
		LabelDate(dateLabel);
		LabelTheater(theaterName);
		
//		****************************************************************************
		int x = 10;
		int y = 150;
		SimpleDateFormat sdtf = new SimpleDateFormat("dd.MM-HH:mm");
		Date dayNau =  new Date();
		String str = sdtf.format(dayNau);
		try {
			dayNau = sdtf.parse(str);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int cc = Movie.getListMovie().size();
		System.out.println("list " + cc);
		System.out.println();
		for (int i = 0; i < cc; i++) {
			
			y = y + 37;
			MovieNameLabel(Movie.getListMovie(), x, (y-6), i);
			
			int xx = 220;
			for (int k = 10; k < 23; k++) {
			
			ButtonMovieTime(dayNau, dateLabel, theaterName, Movie.getListMovie(), xx, y, i, k);
			xx = xx+ 51;
			}
			
		}


//		********************************************************************************

		
		
		JLabel lblNewLabel_1 = new JLabel("DounLine");
		lblNewLabel_1.setIcon(new ImageIcon("line2.png"));
		lblNewLabel_1.setBounds(0, 536, 892, 30);
		programPanel.add(lblNewLabel_1);

		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("cinema-background2A.jpg"));
		lblBackground.setBounds(0, 0, 900, 600);
		getContentPane().add(lblBackground);

	}


	private void ButtonMovieTime(Date dayNau, String dateLabel,String theaterName,
		ArrayList<Movie> ListMovie, int x, int y,
		int i, int k) {
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM");
	SimpleDateFormat stf = new SimpleDateFormat("HH:mm");
	SimpleDateFormat sttf = new SimpleDateFormat("HH");

	
	int indexCurentMovie = ListMovie.get(i).indeksMovie;

	Date time;
	Date DateAndTime;
	boolean fl = false;
	for (int j = 0; j < CinemaTheater.getListCinemaTheater().size(); j++) {
		
		if(		dateLabel.equals(sdf.format(CinemaTheater.getListCinemaTheater().get(j).getDate()))
				&& theaterName.equals(CinemaTheater.getListCinemaTheater().get(j).getName())
				&& indexCurentMovie == CinemaTheater.getListCinemaTheater().get(j).getIndeksMovie()
			){
			
			DateAndTime = CinemaTheater.getListCinemaTheater().get(j).getDate();
//			System.out.println("data "+sdtf.format(DateAndTime)+" -> dnes "+sdtf.format(dayNau));
			
			if (DateAndTime.after(dayNau)){
				fl = true;
			}
			
		time = 	CinemaTheater.getListCinemaTheater().get(j).getTime();
		 String str1 = sttf.format(time);
		
		 if (Integer.parseInt(str1)==k){
			 
		
			 CinemaTheater theaterProjection = CinemaTheater.getListCinemaTheater().get(j);
			 JButton btnMovieTime = new JButton(stf.format(theaterProjection.getTime()));
			if (fl){
				
				btnMovieTime.addActionListener(new ButtonProjectionListener(theaterProjection));
				
			 btnMovieTime.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnMovieTime.setBackground(Color.GRAY);
					}

					@Override
					public void mouseExited(MouseEvent e) {
						btnMovieTime.setBackground(Color.WHITE);
					}
				});
			 btnMovieTime.setBackground(Color.WHITE);
			 btnMovieTime.setToolTipText("Кликни за да избереш");
				
				  }else{
					  btnMovieTime.setBackground(Color.GRAY); 
				  }
			btnMovieTime.setFont(new Font("Times New Roman", Font.BOLD, 8));
		 btnMovieTime.setBounds(x, y, 51, 25);
		 programPanel.add(btnMovieTime);
			 
			
		
		 }
		}
}
	}

	private void MovieNameLabel(
		ArrayList<Movie> ListMovie, int x, int y,
		int i) {
	JLabel movieNameLabel = new JLabel(ListMovie.get(i).getBgName());
	movieNameLabel.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {

		}
	});
	movieNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
	movieNameLabel.setForeground(Color.WHITE);
	movieNameLabel.setBounds(x, y, 200, 35);
	programPanel.add(movieNameLabel);
}



	private void LabelDate(String Date) {
		
		JLabel lblDateLabel = new JLabel();
		System.out.println("dddddddd "+Date);
		lblDateLabel.setText(Date);
		lblDateLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblDateLabel.setForeground(Color.WHITE);
		lblDateLabel.setBounds(50, 55, 100, 25);
		programPanel.add(lblDateLabel);
		
		
	}
	
	private void LabelTheater(String theaterName) {
		
		
		
		JLabel lblTheaterLabel = new JLabel(theaterName);
		lblTheaterLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTheaterLabel.setForeground(Color.WHITE);
		lblTheaterLabel.setBounds(680, 55, 180, 25);
		programPanel.add(lblTheaterLabel);
		
	}

	private void ButtonDateList() {

		{
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM");
			SimpleDateFormat stf = new SimpleDateFormat("HH:mm");
			SimpleDateFormat sdtf = new SimpleDateFormat("dd.MM-HH:mm");

			Date dayNau = new Date();
			String str = sdtf.format(dayNau);
			try {
				dayNau = sdtf.parse(str);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}

			JButton btnProgram = new JButton("ДАТА");
			final JPopupMenu menu = new JPopupMenu("Menu");

			int count = CreatDateList(stf, dayNau, menu);

//			System.out.println("count list " + count);
			if (count > 0) {

				btnProgram.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
//						System.out.println(" uu    ooo ");
						menu.show(btnProgram, btnProgram.getWidth() / 2,
								btnProgram.getHeight() / 2);
					}
				});

				btnProgram.addMouseListener(new MouseAdapter() {
					// @Override
					// public void mouseEntered(MouseEvent e) {
					// btnTimeList.setBackground(Color.GRAY);
					// }

					@Override
					public void mouseExited(MouseEvent e) {
						btnProgram.setBackground(Color.WHITE);
					}
				});
				btnProgram.setBackground(Color.WHITE);
				btnProgram.setToolTipText("Кликни за да избереш");

			} else {
				btnProgram.setBackground(Color.GRAY);
			}
			btnProgram.setFont(new Font("Times New Roman", Font.BOLD, 20));
			btnProgram.setBounds(10, 20, 150, 30);
			programPanel.add(btnProgram);
		}

	}

	private int CreatDateList(SimpleDateFormat stf, Date dayNau,final JPopupMenu menu) {
		int count = 0;
		Date date;
		Date DateAndTime;
		Date[] dateList = new Date[CinemaTheater.getListCinemaTheater().size()];
		int countDateList = 0;
		SimpleDateFormat sdtf = new SimpleDateFormat("dd.MM-HH:mm");
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM");
		boolean fl = true;
		for (int j = 0; j < CinemaTheater.getListCinemaTheater().size(); j++) {

			DateAndTime = CinemaTheater.getListCinemaTheater().get(j).getDate();

			if (DateAndTime.after(dayNau)) {
//				System.out.println("data " + sdtf.format(DateAndTime)
//						+ " -> dnes " + sdtf.format(dayNau));
				fl = true;
//				System.out.println("count  " + countDateList);
				for (int i = 0; i < countDateList; i++) {
//					System.out.println(countDateList + "  data "
//							+ sdtf.format(DateAndTime) + " -> dateList "
//							+ sdtf.format(dateList[i]));

					if (sdf.format(DateAndTime).equals(sdf.format(dateList[i]))) {

						fl = false;
						break;
					}
				}
				if (fl) {
					dateList[countDateList] = DateAndTime;
					countDateList++;

					date = CinemaTheater.getListCinemaTheater().get(j)
							.getDate();
					CinemaTheater TheaterProjection = CinemaTheater
							.getListCinemaTheater().get(j);
					JMenuItem mntmNewMenuItem = DateListItem(sdf, date, theaterName);

					menu.add(mntmNewMenuItem);
					count++;

				}
			}

		}
		return count;
	}
	
	
	private JMenuItem DateListItem(SimpleDateFormat sdf, Date date, String theaterName) {

		JMenuItem mntmNewMenuItem = new JMenuItem(sdf.format(date));
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProgramScreen.this.dispose();
				new ProgramScreen(sdf.format(date), theaterName).setVisible(true);
			}
		});
		return mntmNewMenuItem;
	}
	

	private void ButtonTheaterList() {

		{
			JButton btnTheater = new JButton("КИНО САЛОН");
			final JPopupMenu menu = new JPopupMenu("Menu");

			int count = CreatTheaterList(menu);

//			System.out.println("count list " + count);
			if (count > 0) {

				btnTheater.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
//						System.out.println(" uu    ooo ");
						menu.show(btnTheater, btnTheater.getWidth() / 2,
								btnTheater.getHeight() / 2);
					}
				});

				btnTheater.addMouseListener(new MouseAdapter() {
					// @Override
					// public void mouseEntered(MouseEvent e) {
					// btnTimeList.setBackground(Color.GRAY);
					// }

					@Override
					public void mouseExited(MouseEvent e) {
						btnTheater.setBackground(Color.WHITE);
					}
				});
				btnTheater.setBackground(Color.WHITE);
				btnTheater.setToolTipText("Кликни за да избереш");

			} else {
				btnTheater.setBackground(Color.GRAY);
			}
			btnTheater.setFont(new Font("Times New Roman", Font.BOLD, 17));

			btnTheater.setBounds(680, 20, 180, 30);
			programPanel.add(btnTheater);
		}

	}

	
	private int CreatTheaterList(final JPopupMenu menu) {
		int count = 0;

		String Theater;
		String[] theaterList = new String[CinemaTheater.getListCinemaTheater()
				.size()];
		int countTheaterList = 0;

		boolean fl = true;
		for (int j = 0; j < CinemaTheater.getListCinemaTheater().size(); j++) {

			Theater = CinemaTheater.getListCinemaTheater().get(j).getName();

			fl = true;
//			System.out.println("count  " + countTheaterList);
			for (int i = 0; i < countTheaterList; i++) {
//				System.out.println(countTheaterList + "  data " + Theater
//						+ " -> dateList " + theaterList[i]);

				if (Theater.equals(theaterList[i])) {

					fl = false;
					break;
				}
			}
			if (fl) {
				theaterList[countTheaterList] = Theater;
				countTheaterList++;

				CinemaTheater TheaterProjection = CinemaTheater
						.getListCinemaTheater().get(j);
				JMenuItem mntmNewMenuItem = TheaterListItem(TheaterProjection, dateLabel);

				menu.add(mntmNewMenuItem);
				count++;

			}

		}
		return count;
	}

	
	private JMenuItem TheaterListItem(CinemaTheater theaterProjection, String dateLabel) {

		JMenuItem mntmNewMenuItem = new JMenuItem(theaterProjection.getName());

//		mntmNewMenuItem.addActionListener(new ButtonProjectionListener(theaterProjection));
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProgramScreen.this.dispose();
				new ProgramScreen(dateLabel, theaterProjection.getName()).setVisible(true);
			}
		});
		

		return mntmNewMenuItem;
	}

	public String getDate() {
		return dateLabel;
	}

	public void setDate(String date) {
		this.dateLabel = dateLabel;
	}
//
//	public String getTheaterName() {
//		return theaterName;
//	}
//
//	public void setTheaterName(String theaterName) {
//		this.theaterName = theaterName;
//	}

}
