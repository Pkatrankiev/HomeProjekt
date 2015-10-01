package ui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
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
import db.Movie;

import javax.swing.JPopupMenu;

public class MovieListTheaterScreen extends JFrame {

	private JPanel contentPane;

	public MovieListTheaterScreen(
			ArrayList<CinemaTheater> TheaterForCurenMovieList, Movie curentMovie) {
		setBackground(Color.WHITE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(1, 1, 1, 1));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("DounLine");
		lblNewLabel_1.setIcon(new ImageIcon("line2.png"));
		lblNewLabel_1.setBounds(0, 536, 892, 30);
		contentPane.add(lblNewLabel_1);

		TextLabels(curentMovie);

		int x = 10;
		int y = 150;

		int cc = TheaterForCurenMovieList.size();
		System.out.println("list " + cc);
		System.out.println();
		for (int i = 0; i < cc; i++) {

			y = y + 37;
			TheaterNameLabel(TheaterForCurenMovieList, x, (y - 6), i);

			int xx = 220;
			for (int k = 0; k < 7; k++) {

				ButtonTimeList(TheaterForCurenMovieList, xx, y, i, k);
				xx = xx + 90;
			}

		}

		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("cinema-background2.jpg"));
		lblBackground.setBounds(0, 0, 900, 600);
		getContentPane().add(lblBackground);

	}

	private void TextLabels(Movie curentMovie) {
		String movieLink = curentMovie.getLinkPosterMovie();
		JLabel lblMovie = new JLabel();
		lblMovie.setIcon(new ImageIcon(movieLink.replace(".", "-2.")));
		lblMovie.setBounds(10, 10, 120, 180);
		contentPane.add(lblMovie);

		String movieBgName = curentMovie.getBgName();
		JLabel lblNameMovie = new JLabel(movieBgName);
		lblNameMovie.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNameMovie.setForeground(Color.WHITE);
		lblNameMovie.setBounds(140, 10, 620, 30);
		contentPane.add(lblNameMovie);

		JLabel lblOrigName = new JLabel("Оригинално заглавие");
		lblOrigName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrigName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblOrigName.setForeground(Color.ORANGE);
		lblOrigName.setBounds(140, 40, 200, 30);
		contentPane.add(lblOrigName);

		String movieOrigName = curentMovie.origName;
		JLabel lblOrigNameMovie = new JLabel(movieOrigName);
		lblOrigNameMovie.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblOrigNameMovie.setForeground(Color.WHITE);
		lblOrigNameMovie.setBounds(360, 40, 200, 30);
		contentPane.add(lblOrigNameMovie);

		JLabel lblGenre = new JLabel("Жанр");
		lblGenre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGenre.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblGenre.setForeground(Color.ORANGE);
		lblGenre.setBounds(140, 60, 200, 30);
		contentPane.add(lblGenre);

		String movieGenre = curentMovie.getGenre();
		JLabel lblGenreMovie = new JLabel(movieGenre);
		lblGenreMovie.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblGenreMovie.setForeground(Color.WHITE);
		lblGenreMovie.setBounds(360, 60, 200, 30);
		contentPane.add(lblGenreMovie);

		JLabel lblTimee = new JLabel("Времетраене");
		lblTimee.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTimee.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTimee.setForeground(Color.ORANGE);
		lblTimee.setBounds(140, 80, 200, 30);
		contentPane.add(lblTimee);

		int movieTime = curentMovie.getMovieTime();
		String strTime = movieTime + "мин.";
		JLabel lblTimeMovie = new JLabel(strTime);
		lblTimeMovie.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTimeMovie.setForeground(Color.WHITE);
		lblTimeMovie.setBounds(360, 80, 200, 30);
		contentPane.add(lblTimeMovie);

		JLabel lblLang = new JLabel("Език");
		lblLang.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLang.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblLang.setForeground(Color.ORANGE);
		lblLang.setBounds(140, 100, 200, 30);
		contentPane.add(lblLang);

		String movieLang = curentMovie.getLanguage();
		JLabel lblLangMovie = new JLabel(movieLang);
		lblLangMovie.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblLangMovie.setForeground(Color.WHITE);
		lblLangMovie.setBounds(360, 100, 200, 30);
		contentPane.add(lblLangMovie);

		JLabel lblCountry = new JLabel("Държава/Година");
		lblCountry.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCountry.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCountry.setForeground(Color.ORANGE);
		lblCountry.setBounds(140, 120, 200, 30);
		contentPane.add(lblCountry);

		String movieCountry = curentMovie.getCountry();
		JLabel lblCountryMovie = new JLabel(movieCountry);
		lblCountryMovie.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCountryMovie.setForeground(Color.WHITE);
		lblCountryMovie.setBounds(360, 120, 200, 30);
		contentPane.add(lblCountryMovie);
	}

	private void ButtonTimeList(
			ArrayList<CinemaTheater> TheaterForCurenMovieList, int x, int y,
			int i, int k) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM");
		SimpleDateFormat stf = new SimpleDateFormat("HH:mm");
		SimpleDateFormat sdtf = new SimpleDateFormat("dd.MM-HH:mm");
		System.out.println(" uu " + CinemaTheater.getListdateWeek().get(k));

		Date day = CinemaTheater.getListdateWeek().get(k);
		Date dayNau = new Date();
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

		int count = CreatTimeList(stf, day, dayNau, theaterName, indexMovie,
				menu);
		String str1 = sdtf.format(day);
		try {
			day = sdtf.parse(str1);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// TheaterProjectionScreen();
		System.out.println("count list " + count);
		if (count > 0) {

			btnTimeList.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println(" uu    ooo ");
					menu.show(btnTimeList, btnTimeList.getWidth() / 2,
							btnTimeList.getHeight() / 2);
				}
			});

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
			btnTimeList.setToolTipText("Кликни за да избереш");

		} else {
			btnTimeList.setBackground(Color.GRAY);
		}
		btnTimeList.setBounds(x, y, 80, 25);
		contentPane.add(btnTimeList);

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

	private int CreatTimeList(SimpleDateFormat stf, Date day1, Date dayNau,
			String theaterName, int indexMovie, final JPopupMenu menu) {
		int count = 0;
		Date time;
		Date DateAndTime;
		SimpleDateFormat sdtf = new SimpleDateFormat("dd.MM-HH:mm");
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM");
		for (int j = 0; j < CinemaTheater.getListCinemaTheater().size(); j++) {
			String str = sdf.format(CinemaTheater.getListCinemaTheater().get(j)
					.getDate());
			Date Date = null;
			try {
				Date = sdf.parse(str);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (day1.equals(Date)
					&& theaterName.equals(CinemaTheater.getListCinemaTheater()
							.get(j).getName())
					&& indexMovie == CinemaTheater.getListCinemaTheater()
							.get(j).getIndeksMovie()) {

				DateAndTime = CinemaTheater.getListCinemaTheater().get(j)
						.getDate();
				System.out.println("data " + sdtf.format(DateAndTime)
						+ " -> dnes " + sdtf.format(dayNau));
				if (DateAndTime.after(dayNau)) {

					time = CinemaTheater.getListCinemaTheater().get(j)
							.getTime();
					CinemaTheater TheaterProjection = CinemaTheater
							.getListCinemaTheater().get(j);
					JMenuItem mntmNewMenuItem = TimeListItem(stf, time,
							TheaterProjection);

					System.out.println(day1
							+ " <"
							+ j
							+ "> "
							+ CinemaTheater.getListCinemaTheater().get(j)
									.getDate());
					System.out.println(theaterName
							+ " <"
							+ j
							+ "> "
							+ CinemaTheater.getListCinemaTheater().get(j)
									.getName());
					System.out.println(indexMovie
							+ " <"
							+ j
							+ "> "
							+ CinemaTheater.getListCinemaTheater().get(j)
									.getIndeksMovie());

					menu.add(mntmNewMenuItem);
					count++;

				}
			}

		}
		return count;
	}

	private JMenuItem TimeListItem(SimpleDateFormat stf, Date time,
			CinemaTheater theaterProjection) {

		JMenuItem mntmNewMenuItem = new JMenuItem(stf.format(time));

		mntmNewMenuItem.addActionListener(new ButtonProjectionListener(
				theaterProjection));

		return mntmNewMenuItem;
	}

}
