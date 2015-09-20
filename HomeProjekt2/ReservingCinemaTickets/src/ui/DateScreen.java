package ui;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

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
	
	JLabel label = DefaultComponentFactory.getInstance().createLabel("New JGoodies label");
	label.setBounds(10, 96, 200, 50);
	add(label);
	
	JPopupMenu popupMenu = new JPopupMenu();
	popupMenu.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
	});
	addPopup(label, popupMenu);
	
	JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
	popupMenu.add(mntmNewMenuItem);
	
	JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
	popupMenu.add(mntmNewMenuItem_1);
}

private static void addPopup(Component component, final JPopupMenu popup) {
	component.addMouseListener(new MouseAdapter() {
		public void mousePressed(MouseEvent e) {
			if (e.isPopupTrigger()) {
				showMenu(e);
			}
		}
		public void mouseReleased(MouseEvent e) {
			if (e.isPopupTrigger()) {
				showMenu(e);
			}
		}
		private void showMenu(MouseEvent e) {
			popup.show(e.getComponent(), e.getX(), e.getY());
		}
	});
}

	}


