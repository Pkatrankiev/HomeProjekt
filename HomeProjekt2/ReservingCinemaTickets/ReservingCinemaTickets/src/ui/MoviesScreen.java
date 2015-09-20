package ui;


import logic.ButtonListener;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;

import db.Movie;
import db.ReadFile;

public class MoviesScreen extends JFrame {

	private JPanel contentPane;

//	private JButton[] btnMovie;
	public MoviesScreen() {
//		this.btnMovie = new JButton[]	;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Филмите тази седмица");
		lblNewLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println(" - - - - - -");
				new PanelTest().setVisible(true);
			}
		});
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 10, 488, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DounLine");
		lblNewLabel_1.setIcon(new ImageIcon("line1.png"));
		lblNewLabel_1.setBounds(0, 536, 892, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(10, 35, 605, 20);
		contentPane.add(lblNewLabel_2);
		
		int x = 20;
		int y = 65;
		int line;
	
		int cc = Movie.getListMovie().size();
		for (int i = 0; i < cc; i++) {
		if (i%5==0){
			x=20;}	
			line = i/5;
			
			y =65+ line*235;
			
		JButton btn = new JButton("");

		btn.addActionListener(new ButtonListener(i));
		

		btn.setToolTipText("Кликни за да избереш");
		btn.setIcon(new ImageIcon(Movie.getListMovie().get(i).getLinkPosterMovie()));
		btn.setBounds(x, y, 150, 220);
		contentPane.add(btn);
		x=x+175;
		}
		
			
//			JButton btnMovie = new JButton("");
//			btnMovie.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent arg0) {
//				}
//			});
//			btnMovie.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent arg0) {
//				}
//			});
//			btnMovie.setToolTipText("Кликни за да избереш");
//			btnMovie.setIcon(new ImageIcon("C:\\Documents and Settings\\ibm\\Desktop\\2.jpg"));
//			btnMovie.setBounds(x, 300, 150, 220);
//			contentPane.add(btnMovie);
//			
//			JLabel lblNewLabel_3 = new JLabel("New label");
//			lblNewLabel_3.setBounds(20, 85, 872, 470);
//			contentPane.add(lblNewLabel_3);
//			x=x+175;
	
	}



}
