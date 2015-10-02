import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.ScrollPane;
import java.awt.Label;
import java.awt.Button;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.DropMode;
import javax.swing.UIManager;


public class ssss extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	public ssss() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setForeground(Color.BLACK);
		getContentPane().setLayout(null);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("\u0418\u043C\u0435");
		lblNewJgoodiesTitle.setForeground(Color.WHITE);
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewJgoodiesTitle.setBounds(10, 38, 122, 14);
		getContentPane().add(lblNewJgoodiesTitle);
		
		JTextPane textPane = new JTextPane();
		textPane.setBorder(UIManager.getBorder("PasswordField.border"));
		textPane.setForeground(Color.BLACK);
		textPane.setBackground(Color.WHITE);
		textPane.setBounds(10, 63, 148, 87);
		getContentPane().add(textPane);
		
		textField = new JTextField();
		textField.setBounds(63, 161, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(50, 200, 94, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ssss frame = new ssss();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
