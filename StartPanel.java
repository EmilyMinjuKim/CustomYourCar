package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class StartPanel extends JPanel {
	
	ImageIcon icon = new ImageIcon("images/mainbg2.png");;

	public StartPanel() {
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel() {
			
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);

			}

		};
		
		panel.setLayout(null);
		panel.setBounds(100, 100, 800, 600);
		add(panel);

	}

}
