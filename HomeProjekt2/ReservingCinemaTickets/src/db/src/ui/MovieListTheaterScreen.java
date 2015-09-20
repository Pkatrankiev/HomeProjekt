package ui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import logic.ButtonTheaterListener;
import db.CinemaTheater;

import javax.swing.JPopupMenu;

import java.awt.Component;

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
		int y = 10;

		int cc = TheaterForCurenMovieList.size();
		System.out.println("list " + cc);
		for (int i = 0; i < cc; i++) {
			
			y = 10 + i * 37;
			TheaterNameLabel(TheaterForCurenMovieList, x, y, i);
			int xx = 220;
			for (int k = 0; k < 7; k++) {
			
			ButtonTimeList(TheaterForCurenMovieList, xx, y, i, k);
			xx = xx+ 90;
			}
			
		}

	}

	private void ButtonTimeList(
			ArrayList<CinemaTheater> TheaterForCurenMovieList, int x, int y,
			int i, int k) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM");
		System.out.println(CinemaTheater.getListdateWeek().get(k));
		String date = sdf.format(CinemaTheater.getListdateWeek().get(k));
		JButton btnTimeList1 = new JButton(date);
		btnTimeList1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnTimeList1.setBackground(Color.GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnTimeList1.setBackground(Color.WHITE);
			}
		});
		btnTimeList1.setBackground(Color.WHITE);
		btnTimeList1.setToolTipText("Кликни за да избереш");
		btnTimeList1.setBounds(x, y, 80, 25);
		contentPane.add(btnTimeList1);

		Date day1 = CinemaTheater.getListdateWeek().get(k);
		CinemaTheater cinemaTheater = TheaterForCurenMovieList.get(i);
		btnTimeList1.addActionListener(new ButtonTheaterListener(cinemaTheater,
				day1));
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
		theaterNameLabel.setBackground(Color.WHITE);
		theaterNameLabel.setBounds(x, y, 200, 35);
		contentPane.add(theaterNameLabel);
	}

}
