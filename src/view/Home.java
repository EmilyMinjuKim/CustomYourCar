package view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import view.login.FrameJoin;
import view.login.FrameLogin;

public class Home extends JFrame {
	
	JScrollPane scrollPane;
	ImageIcon icon;

	public Home() {
		
		setTitle("SBC");
		setSize(900, 600);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		icon = new ImageIcon("images/main.png");
		
		JPanel panel = new JPanel() {

			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);

				setOpaque(false);
				super.paintComponent(g);
			}
		};

		JButton btnLogin = new JButton("로그인");
		JButton btnJoin = new JButton("회원가입");

		panel.setLayout(null);

		btnLogin.setSize(250, 50);
		btnLogin.setLocation(100, 470);
		btnLogin.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 26));
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(false);
		

		btnJoin.setSize(250, 50);
		btnJoin.setLocation(480, 470);
		btnJoin.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 26));
		btnJoin.setContentAreaFilled(false);
		btnJoin.setBorderPainted(false);
		

		panel.add(btnLogin);
		panel.add(btnJoin);

		scrollPane = new JScrollPane(panel);
		setContentPane(scrollPane);

		setVisible(true);
		
		//로그인 버튼 
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panel.removeAll();
				panel.add(new FrameLogin(panel));
				panel.revalidate();
				panel.repaint();

			}
		});

		// 회원가입 버튼
		btnJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.add(new FrameJoin(panel));
				panel.revalidate();
				panel.repaint();
			}
		});

	}
}

