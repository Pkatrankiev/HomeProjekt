package logic;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TheaterMovieProgramScreen extends JFrame {

	private JPanel contentPane;


	public TheaterMovieProgramScreen() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Филмите тази седмица");
		
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 10, 488, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DounLine");
		lblNewLabel_1.setIcon(new ImageIcon("line2.png"));
		lblNewLabel_1.setBounds(0, 536, 892, 30);
		contentPane.add(lblNewLabel_1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
