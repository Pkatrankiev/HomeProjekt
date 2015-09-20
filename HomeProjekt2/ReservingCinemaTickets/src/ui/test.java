package ui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JInternalFrame;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class test extends JFrame {
	public test() {
		setLayout(null);
		
		JLabel label = DefaultComponentFactory.getInstance().createLabel("New JGoodies label");
		label.setBounds(100, 100, 200, 50);
		add(label);
		
		JPopupMenu popup = new JPopupMenu();
		popup.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 1) {
                    Rectangle bounds = getSafeScreenBounds(e.getPoint());
                    Point point = e.getPoint();
                    int x = point.x;
                    int y = point.y;
                    if (y < bounds.y) {
                        y = bounds.y;
                    } else if (y > bounds.y + bounds.height) {
                        y = bounds.y + bounds.height;
                    }
                    if (x < bounds.x) {
                        x = bounds.x;
                    } else if (x > bounds.x + bounds.width) {
                        x = bounds.x + bounds.width;
                    }
                    if (x + popup.getPreferredSize().width > bounds.x + bounds.width) {
                        x = (bounds.x + bounds.width) - popup.getPreferredSize().width;
                    }
                    if (y + popup.getPreferredSize().height > bounds.y + bounds.height) {
                        y = (bounds.y + bounds.height) - popup.getPreferredSize().height;
                    }
                    popup.setLocation(x, y);
                    popup.setVisible(true);
                }
            }
		});
		addPopup(label, popup);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		popup.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		popup.add(mntmNewMenuItem_1);
	}
	
	  public static Rectangle getSafeScreenBounds(Point pos) {

	        Rectangle bounds = getScreenBoundsAt(pos);
	        Insets insets = getScreenInsetsAt(pos);

	        bounds.x += insets.left;
	        bounds.y += insets.top;
	        bounds.width -= (insets.left + insets.right);
	        bounds.height -= (insets.top + insets.bottom);

	        return bounds;

	    }
	
	  public static Insets getScreenInsetsAt(Point pos) {
	        GraphicsDevice gd = getGraphicsDeviceAt(pos);
	        Insets insets = null;
	        if (gd != null) {
	            insets = Toolkit.getDefaultToolkit().getScreenInsets(gd.getDefaultConfiguration());
	        }
	        return insets;
	    }

	    public static Rectangle getScreenBoundsAt(Point pos) {
	        GraphicsDevice gd = getGraphicsDeviceAt(pos);
	        Rectangle bounds = null;
	        if (gd != null) {
	            bounds = gd.getDefaultConfiguration().getBounds();
	        }
	        return bounds;
	    }

	    public static GraphicsDevice getGraphicsDeviceAt(Point pos) {

	        GraphicsDevice device = null;

	        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	        GraphicsDevice lstGDs[] = ge.getScreenDevices();

	        ArrayList<GraphicsDevice> lstDevices = new ArrayList<GraphicsDevice>(lstGDs.length);

	        for (GraphicsDevice gd : lstGDs) {

	            GraphicsConfiguration gc = gd.getDefaultConfiguration();
	            Rectangle screenBounds = gc.getBounds();

	            if (screenBounds.contains(pos)) {

	                lstDevices.add(gd);

	            }

	        }

	        if (lstDevices.size() > 0) {
	            device = lstDevices.get(0);
	        } else {
	            device = ge.getDefaultScreenDevice();
	        }

	        return device;

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
