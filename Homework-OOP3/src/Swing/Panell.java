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

		// �������������� ����� 
		JPanel panel = new JPanel();
		
		// �������������� �������� � ���
		JFrame frame = new JFrame("����");
		
		// ������ ����������� ����������� �� ��������
		frame.setLayout(new FlowLayout());
		
		// ���������� �������� � ������� 4 ������, 2 ������
		panel.setLayout(new GridLayout(4, 2));
		
		// ������ �� "X" ������ �� ����� ������������
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// �������� �������
		frame.setSize(400, 250);
		
		// ��������� � �������
		frame.setLocationRelativeTo(null);
		
		// �� ���� �����
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
		JButton enterButton = new JButton("����");

		enterButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (inputName.getText().equals("Admin")
						&& inputPass.getText().equals("12345")) {
					resultLabel.setText("������ ��������!");
				} else
					resultLabel.setText("������ �������!");

			}
		});

		panel.add(enterButton);
		panel.add(freeLabel);

		// ******************ENTER BUTON**********************

		panel.add(resultLabel);

	}
}
