package ui;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DateScreen extends JFrame{
private JPanel contentPane;

	
	public DateScreen() {
	
//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 600, 480);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("Филмите тази седмица");
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
	lblNewLabel.setBounds(205, 10, 481, 52);
	contentPane.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("New label");
	lblNewLabel_1.setIcon(new ImageIcon("C:\\Documents and Settings\\ibm\\Desktop\\line2.png"));
	lblNewLabel_1.setBounds(0, 536, 892, 30);
	contentPane.add(lblNewLabel_1);
	
	
	}

}
