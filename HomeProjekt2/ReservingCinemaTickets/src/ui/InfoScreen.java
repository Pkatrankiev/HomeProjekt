package ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoScreen extends JFrame{
	
	public InfoScreen(String text) {
		
		JPanel newPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
constraints.insets = new Insets(10, 10, 10, 10);
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        newPanel.add(new JLabel(text), constraints);
        
        
        
        this.add(newPanel);
        pack();

        setLocationRelativeTo(null);
	}

}
