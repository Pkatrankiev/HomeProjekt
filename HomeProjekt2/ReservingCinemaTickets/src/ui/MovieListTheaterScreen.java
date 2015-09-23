package ui;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import java.io.Console;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import logic.ButtonProjectionListener;
import db.CinemaTheater;

import javax.swing.JPopupMenu;



public class MovieListTheaterScreen extends JFrame {

	private JPanel contentPane;

	public MovieListTheaterScreen(ArrayList<CinemaTheater> TheaterForCurenMovieList) {
		setBackground(Color.WHITE);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(1, 1, 1, 1));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		int x = 10;
		int y = 150;

		int cc = TheaterForCurenMovieList.size();
		System.out.println("list " + cc);
		System.out.println();
		for (int i = 0; i < cc; i++) {
			
			y = y + 37;
			TheaterNameLabel(TheaterForCurenMovieList, x, (y-6), i);
			
			int xx = 220;
			for (int k = 0; k < 7; k++) {
			
			ButtonTimeList(TheaterForCurenMovieList, xx, y, i, k);
			xx = xx+ 90;
			}
			
		}
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("cinema-background2.jpg"));
		lblBackground.setBounds(0, 0, 900, 600);
		getContentPane().add(lblBackground);

	}

	private void ButtonTimeList(
			ArrayList<CinemaTheater> TheaterForCurenMovieList, int x, int y,
			int i, int k) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM");
		SimpleDateFormat stf = new SimpleDateFormat("HH:mm");
		SimpleDateFormat sdtf = new SimpleDateFormat("dd.MM-HH:mm");
		System.out.println(" uu "+CinemaTheater.getListdateWeek().get(k));
		
		Date day =CinemaTheater.getListdateWeek().get(k);
		Date dayNau =  new Date();
		String str = sdtf.format(dayNau);
		try {
			dayNau = sdtf.parse(str);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String date = sdf.format(day);
		
		String theaterName = TheaterForCurenMovieList.get(i).getName();
		int indexMovie = TheaterForCurenMovieList.get(i).getIndeksMovie();
		
		JButton btnTimeList = new JButton(date);
		  final JPopupMenu menu = new JPopupMenu("Menu");
		
		  int count = CreatTimeList(stf,day,dayNau, theaterName,indexMovie,menu);
		  String str1 = sdtf.format(day);
		  try {
			day = sdtf.parse(str1);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  
		  System.out.println("count list "+count); 
		  if (count>0){
				
			
          btnTimeList.addActionListener( new ActionListener() {
              public void actionPerformed(ActionEvent e) {
            	  System.out.println(" uu    ooo ");
                  menu.show(btnTimeList, btnTimeList.getWidth()/2, btnTimeList.getHeight()/2);
              }
          } );
          
		btnTimeList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnTimeList.setBackground(Color.GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnTimeList.setBackground(Color.WHITE);
			}
		});
		btnTimeList.setBackground(Color.WHITE);
		btnTimeList.setToolTipText("������ �� �� �������");
		
		  }else{
			  btnTimeList.setBackground(Color.GRAY); 
		  }
		btnTimeList.setBounds(x, y, 80, 25);
		contentPane.add(btnTimeList);
		
		JLabel lblNewLabel_1 = new JLabel("DounLine");
		lblNewLabel_1.setIcon(new ImageIcon("line2.png"));
		lblNewLabel_1.setBounds(0, 536, 892, 30);
		contentPane.add(lblNewLabel_1);

	}

	private void TheaterNameLabel(
			ArrayList<CinemaTheater> TheaterForCurenMovieList, int x, int y,
			int i) {
		JLabel theaterNameLabel = new JLabel(TheaterForCurenMovieList.get(i)
				.getName());
		theaterNameLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

			}
		});
		theaterNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		theaterNameLabel.setForeground(Color.WHITE);
		theaterNameLabel.setBounds(x, y, 200, 35);
		contentPane.add(theaterNameLabel);
	}

	
	private  int CreatTimeList(SimpleDateFormat stf, Date day1,Date dayNau,
			String theaterName, int indexMovie, final JPopupMenu menu) {
		int count = 0;
		Date time;
		Date DateAndTime;
		SimpleDateFormat sdtf = new SimpleDateFormat("dd.MM-HH:mm");
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM");
		for (int j = 0; j < CinemaTheater.getListCinemaTheater().size(); j++) {
			 String str = sdf.format(CinemaTheater.getListCinemaTheater().get(j).getDate()); 
			 Date Date = null;
			try {
				Date = sdf.parse(str);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(		day1.equals(Date)
					&& theaterName.equals(CinemaTheater.getListCinemaTheater().get(j).getName())
					&& indexMovie == CinemaTheater.getListCinemaTheater().get(j).getIndeksMovie()){
				
				DateAndTime = CinemaTheater.getListCinemaTheater().get(j).getDate();
				System.out.println("data "+sdtf.format(DateAndTime)+" -> dnes "+sdtf.format(dayNau));
				if (DateAndTime.after(dayNau)){
				
			time = 	CinemaTheater.getListCinemaTheater().get(j).getTime();
			CinemaTheater TheaterProjection = CinemaTheater.getListCinemaTheater().get(j);
			JMenuItem mntmNewMenuItem = TimeListItem(stf, time, TheaterProjection);
			
			System.out.println(day1+" <"+j+"> "+CinemaTheater.getListCinemaTheater().get(j).getDate());
			System.out.println(theaterName+" <"+j+"> "+CinemaTheater.getListCinemaTheater().get(j).getName());
			System.out.println(indexMovie+" <"+j+"> "+CinemaTheater.getListCinemaTheater().get(j).getIndeksMovie());
			
			 menu.add(mntmNewMenuItem);
			 count++;
			 
	}
			}
	
		  }return count;
	}
			
	private JMenuItem TimeListItem(SimpleDateFormat stf, Date time, CinemaTheater theaterProjection) {
			
				
		JMenuItem mntmNewMenuItem = new JMenuItem(stf.format(time));
				
				mntmNewMenuItem.addActionListener(new ButtonProjectionListener(theaterProjection));
				
				
				return mntmNewMenuItem;
			}

}
