package ui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.CinemaTheater;

public class TheaterProjectionScreen extends JFrame{

	private JPanel contentPane;

	public TheaterProjectionScreen(CinemaTheater theaterProjection) {
		setBackground(Color.WHITE);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(1, 1, 1, 1));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("DounLine");
		lblNewLabel_1.setIcon(new ImageIcon("line3.png"));
		lblNewLabel_1.setBounds(0, 536, 892, 30);
		contentPane.add(lblNewLabel_1);
	}
}
