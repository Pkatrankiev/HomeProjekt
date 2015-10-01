package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import db.CinemaTheater;
import db.Movie;

public class TheaterProjectionScreen extends JFrame{

	private JPanel contentPane;

	public TheaterProjectionScreen(CinemaTheater theaterProjection) {
		setBackground(Color.WHITE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(1, 1, 1, 1));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel priceLabel = new JLabel();
		priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceLabel.setBackground(Color.WHITE);
		priceLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		priceLabel.setForeground(Color.RED);
		priceLabel.setBounds(10, 500, 800, 30);
		contentPane.add(priceLabel);
		
		JButton btnProgram = new JButton("����");
		btnProgram.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnProgram.setToolTipText("������ �� ����������");
		btnProgram.setBounds(720, 470, 150, 30);
		contentPane.add(btnProgram);
		
		
		
		TextLabels(theaterProjection);
		
		int x = 200;
		int y = 150;
		int colums = theaterProjection.getColumns();
		int lines = theaterProjection.getLines();
		JButton[][] btnSeat = new JButton[lines][colums];
		
		for (int i = 0; i < lines; i++) {
			y = y + 25;
			linesLabel( x, (y - 2), (i+1));
			int xx = 240;
			for (int j = 0; j < colums; j++) {
				ButtonSeats(theaterProjection, btnSeat, xx, y, i, j,priceLabel);
				xx = xx + 30;
			}
			linesLabel((xx+10), (y - 2), (i+1));
		}

		btnProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int countTicket = 0;
				int colums = theaterProjection.getColumns();
				int lines = theaterProjection.getLines();
				
				for (int i = 0; i < lines; i++) {
					for (int j = 0; j < colums; j++) {
						if (btnSeat[i][j].getText().equals("0")){
							countTicket++;
						}
					}
				}
				if (countTicket>0){
					new CustomerScreen(btnSeat, theaterProjection).setVisible(true);
				}else{
					new InfoScreen("���� ����������� �����.").setVisible(true); 
				}
				
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("DounLine");
		lblNewLabel_1.setIcon(new ImageIcon("line3.png"));
		lblNewLabel_1.setBounds(0, 536, 892, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("cinema-background.jpg"));
		lblBackground.setBounds(0, 0, 900, 600);
		getContentPane().add(lblBackground);
		
	}
	

	private void linesLabel( int x, int y, int i) {
		
		JLabel linesLabel = new JLabel(i+"");
		linesLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		linesLabel.setForeground(Color.WHITE);
		linesLabel.setBounds(x, y, 30, 25);
		contentPane.add(linesLabel);
	}
	
	private void ButtonSeats(CinemaTheater theaterProjection, JButton[][] btnSeat, int x, int y, int i, int j, JLabel priceLabel) {
		
		
		
		JButton btn = new JButton();
		btnSeat[i][j] = btn;
		
		btnSeat[i][j].setText(theaterProjection.getSeat()[i][j]+"");
		
		if (btnSeat[i][j].getText().equals("-1")) {

			btnSeat[i][j].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btnSeat[i][j].getText().equals("0")){
						btnSeat[i][j].setText("-1");
					}else{
					btnSeat[i][j].setText("0");
					}
					priceLabel.setVisible(false);
					contentPane.repaint();
					CountTicket(btnSeat, theaterProjection, priceLabel);
					}
			});
		
			btnSeat[i][j].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnSeat[i][j].setForeground(Color.ORANGE);
					btnSeat[i][j].setBackground(Color.ORANGE);
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					
					if (btnSeat[i][j].getText().equals("0")){
						btnSeat[i][j].setForeground(Color.ORANGE);
						btnSeat[i][j].setBackground(Color.ORANGE);
						
						}else{
							btnSeat[i][j].setForeground(Color.GREEN);
							btnSeat[i][j].setBackground(Color.GREEN);
						}
				}
			});
			if (btnSeat[i][j].getText().equals("0")){
				btnSeat[i][j].setForeground(Color.ORANGE);
			btnSeat[i][j].setBackground(Color.ORANGE);
			}else{
				btnSeat[i][j].setForeground(Color.GREEN);
				btnSeat[i][j].setBackground(Color.GREEN);
			}
			btnSeat[i][j].setToolTipText("��� "+(i+1)+" ����� "+(j+1));
		} else {
			btnSeat[i][j].setForeground(Color.RED);
			btnSeat[i][j].setBackground(Color.RED);
		}
		
		btnSeat[i][j].setBounds(x, y, 25, 20);
		contentPane.add(btnSeat[i][j]);

	}

	private void TextLabels(CinemaTheater theaterProjection) {
		
		int indexMovie = theaterProjection.getIndeksMovie();
		indexMovie--;
		Movie curentMovie = Movie.getListMovie().get(indexMovie);
		
		
		String movieBgName = curentMovie.getBgName();
		JLabel lblNameMovie = new JLabel(movieBgName);
		lblNameMovie.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNameMovie.setForeground(Color.WHITE);
		lblNameMovie.setBounds(10, 10, 500, 30);
		contentPane.add(lblNameMovie);
		
		String theaterName = theaterProjection.getName();
		JLabel lblNameTheater = new JLabel(theaterName);
		lblNameTheater.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNameTheater.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNameTheater.setForeground(Color.WHITE);
		lblNameTheater.setBounds(550, 10, 320, 30);
		contentPane.add(lblNameTheater);
		
		
		JLabel moviDateProj = new JLabel("���� �� �����������");
		moviDateProj.setHorizontalAlignment(SwingConstants.CENTER);
		moviDateProj.setFont(new Font("Times New Roman", Font.BOLD, 15));
		moviDateProj.setForeground(Color.ORANGE);
		moviDateProj.setBounds(430, 40, 200, 30);
		contentPane.add(moviDateProj);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM");
		String dateProjection = sdf.format( theaterProjection.getDate());
		JLabel lbldateProjection = new JLabel(dateProjection);
		lbldateProjection.setHorizontalAlignment(SwingConstants.CENTER);
		lbldateProjection.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lbldateProjection.setForeground(Color.WHITE);
		lbldateProjection.setBounds(430, 65, 200, 25);
		contentPane.add(lbldateProjection);
		
		JLabel moviTimeProj = new JLabel("������� ���");
		moviTimeProj.setHorizontalAlignment(SwingConstants.CENTER);
		moviTimeProj.setFont(new Font("Times New Roman", Font.BOLD, 15));
		moviTimeProj.setForeground(Color.ORANGE);
		moviTimeProj.setBounds(430, 90, 200, 25);
		contentPane.add(moviTimeProj);
		
		SimpleDateFormat stf = new SimpleDateFormat("HH:mm");
		String timeProjection = stf.format( theaterProjection.getTime());
		JLabel lbltimeProjection = new JLabel(timeProjection);
		lbltimeProjection.setHorizontalAlignment(SwingConstants.CENTER);
		lbltimeProjection.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lbltimeProjection.setForeground(Color.WHITE);
		lbltimeProjection.setBounds(430, 110, 200, 25);
		contentPane.add(lbltimeProjection);
		
		
		String theaterAdress = theaterProjection.getAdres();
		JLabel lblAdressTheater = new JLabel(theaterAdress);
		lblAdressTheater.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdressTheater.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAdressTheater.setForeground(Color.ORANGE);
		lblAdressTheater.setBounds(550, 40, 320, 30);
		contentPane.add(lblAdressTheater);

		JLabel lblOrigName = new JLabel("���������� ��������");
		lblOrigName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrigName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblOrigName.setForeground(Color.ORANGE);
		lblOrigName.setBounds(10, 40, 200, 30);
		contentPane.add(lblOrigName);

		String movieOrigName = curentMovie.origName;
		JLabel lblOrigNameMovie = new JLabel(movieOrigName);
		lblOrigNameMovie.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblOrigNameMovie.setForeground(Color.WHITE);
		lblOrigNameMovie.setBounds(220, 40, 200, 30);
		contentPane.add(lblOrigNameMovie);

		JLabel lblGenre = new JLabel("����");
		lblGenre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGenre.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblGenre.setForeground(Color.ORANGE);
		lblGenre.setBounds(10, 60, 200, 30);
		contentPane.add(lblGenre);

		String movieGenre = curentMovie.getGenre();
		JLabel lblGenreMovie = new JLabel(movieGenre);
		lblGenreMovie.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblGenreMovie.setForeground(Color.WHITE);
		lblGenreMovie.setBounds(220, 60, 200, 30);
		contentPane.add(lblGenreMovie);

		JLabel lblTimee = new JLabel("�����������");
		lblTimee.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTimee.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTimee.setForeground(Color.ORANGE);
		lblTimee.setBounds(10, 80, 200, 30);
		contentPane.add(lblTimee);

		int movieTime = curentMovie.getMovieTime();
		String strTime = movieTime + "���.";
		JLabel lblTimeMovie = new JLabel(strTime);
		lblTimeMovie.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTimeMovie.setForeground(Color.WHITE);
		lblTimeMovie.setBounds(220, 80, 200, 30);
		contentPane.add(lblTimeMovie);

		JLabel lblLang = new JLabel("����");
		lblLang.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLang.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblLang.setForeground(Color.ORANGE);
		lblLang.setBounds(10, 100, 200, 30);
		contentPane.add(lblLang);

		String movieLang = curentMovie.getLanguage();
		JLabel lblLangMovie = new JLabel(movieLang);
		lblLangMovie.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblLangMovie.setForeground(Color.WHITE);
		lblLangMovie.setBounds(220, 100, 200, 30);
		contentPane.add(lblLangMovie);

		JLabel lblCountry = new JLabel("�������/������");
		lblCountry.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCountry.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCountry.setForeground(Color.ORANGE);
		lblCountry.setBounds(10, 120, 200, 30);
		contentPane.add(lblCountry);

		String movieCountry = curentMovie.getCountry();
		JLabel lblCountryMovie = new JLabel(movieCountry);
		lblCountryMovie.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCountryMovie.setForeground(Color.WHITE);
		lblCountryMovie.setBounds(220, 120, 200, 30);
		contentPane.add(lblCountryMovie);
	
		
	
	}
	
	private void CountTicket( JButton[][] btnSeat, CinemaTheater theaterProjection, JLabel priceLabel){
		int countTicket = 0;
		int colums = theaterProjection.getColumns();
		int lines = theaterProjection.getLines();
		
		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < colums; j++) {
				if (btnSeat[i][j].getText().equals("0")){
					countTicket++;
				}
			}
		}
		String str = " ����������� ������ �� ";
		if (countTicket==1){
			str = " ���������� ����� �� ";
		}
		float price = theaterProjection.getPrice() ;
		if (countTicket==0){
			priceLabel.setVisible(false);
			priceLabel.setText("");
			priceLabel.setVisible(true);
		}else{
		priceLabel.setVisible(false);
		priceLabel.setText("�� ������� ����� "+countTicket+str+String.format("%.2f",price)+
				"��. ���� ��������:"+String.format("%.2f",(countTicket*price))+"��.");
		priceLabel.setVisible(true);}
	};


}
