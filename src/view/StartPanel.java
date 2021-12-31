package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartPanel extends JPanel {

	ImageIcon icon = new ImageIcon("images/main2.png");

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
