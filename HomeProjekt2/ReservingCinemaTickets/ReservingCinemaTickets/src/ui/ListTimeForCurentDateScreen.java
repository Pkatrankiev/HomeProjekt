package ui;

	import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import logic.ButtonListener;
import db.CinemaTheater;
import db.Movie;

	public class ListTimeForCurentDateScreen extends JFrame {

		private JPanel contentPane;
		public ListTimeForCurentDateScreen(int x, int y, 
				Date[] listTime,int countListTime) {

//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			System.out.println("cccc "+countListTime);
		setBounds(100+x, 100+y, 40, ((countListTime*25)+35));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String str=null;
		SimpleDateFormat stf = new SimpleDateFormat("HH:mm");
		
//		
//		JButton btn = new JButton("");
//		btn.addActionListener(new ButtonListener(i));
//		btn.setToolTipText("Кликни за да избереш");
//		btn.setIcon(new ImageIcon(Movie.getListMovie().get(i).getLinkPosterMovie()));
//		btn.setBounds(x, y, 150, 220);
//		contentPane.add(btn);
//		x=x+175;
		
		int yy=0;
		for (int i = 0; i < countListTime; i++) {
			str = stf.format(CinemaTheater.getListCinemaTheater().get(i).getTime());
			System.out.println("buton"+str);
			
			JButton btn = new JButton(str);
			btn.addActionListener(new ButtonListener(i));
			btn.setToolTipText("Кликни за да избереш");

			btn.setBounds(0, yy, 80, 25);
			contentPane.add(btn);
			yy=yy+25;
		}
		
//		
//		JLabel lblNewLabel = new JLabel("Филмите тази седмица");
//		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
//		lblNewLabel.setBounds(205, 10, 481, 52);
//		contentPane.add(lblNewLabel);
		
//		JLabel lblNewLabel_1 = new JLabel("New label");
//		lblNewLabel_1.setIcon(new ImageIcon("C:\\Documents and Settings\\ibm\\Desktop\\line2.png"));
//		lblNewLabel_1.setBounds(0, 536, 892, 30);
//		contentPane.add(lblNewLabel_1);
		
		
		}

		
//			public ListTimeForCurentDateScreen(int x, int y, 
//					Date[] listTime,int countListTime) {
//				
//			setLayout(null);
//			
//			int whithc = 25*countListTime;
//			System.out.println("www  "+whithc+" x  "+x+" y  "+y);
//			
//			JPanel panel = new JPanel();
//			panel.setBounds(10, 10, 100, 300);
////			panel.setBounds(x, y, 80, whithc);
//			add(panel);
//			panel.setLayout(null);
//			
//			for (int i = 0; i < listTime.length; i++) {
//			
//			JButton button = new JButton("New button");
//			button.setBounds(x, y, 80, 25);
//			y=y+25;
//			panel.add(button);
//			}
//		}
	}

	

