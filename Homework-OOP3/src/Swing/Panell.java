package Swing;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panell {

	public static void main(String[] args) {

		// инициализираме панел 
		JPanel panel = new JPanel();
		
		// инициализираме прозорец с име
		JFrame frame = new JFrame("Вход");
		
		// задава автоматично разширяване на обектите
		frame.setLayout(new FlowLayout());
		
		// подреждаме обектите в решетка 4 редици, 2 колони
		panel.setLayout(new GridLayout(4, 2));
		
		// задава на "X" бутона да спира приложението
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// задаваме размери
		frame.setSize(400, 250);
		
		// поставяме в средата
		frame.setLocationRelativeTo(null);
		
		// да бъде видим
		frame.setVisible(true);

		frame.add(panel);

		JLabel resultLabel = new JLabel();
		JLabel nameLabel = new JLabel("Ime");
		JLabel passLabel = new JLabel("Pass");
		JLabel freeLabel = new JLabel(" ");

		JTextField inputName = new JTextField();
		JTextField inputPass = new JTextField();

		panel.add(nameLabel);
		panel.add(inputName);

		panel.add(passLabel);
		panel.add(inputPass);

		// ******************ENTER BUTON**********************
		JButton enterButton = new JButton("ВХОД");

		enterButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (inputName.getText().equals("Admin")
						&& inputPass.getText().equals("12345")) {
					resultLabel.setText("Достъп разрешен!");
				} else
					resultLabel.setText("Достъп отказан!");

			}
		});

		panel.add(enterButton);
		panel.add(freeLabel);

		// ******************ENTER BUTON**********************

		panel.add(resultLabel);

	}
}
