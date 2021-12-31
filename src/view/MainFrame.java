package view;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import board.BoardView;
import controller.car.CustomController;
import controller.member.MemberToken;
import model.car.Car;
import model.car.CarOrder;
import view.car.CarInfo;
import view.car.CarOrderView;
import view.car.CustomView;
import view.car.FastOutCar;
import view.member.MyInfoView;
import view.member.MySaveView;
import view.member.OrderedInfoView;

public class MainFrame extends JFrame {
	MainFrame mainFrame = this;

	// 화면 전환이 되는 패널
	private JPanel startPanel;
	private JFrame frame;
	private String id;

	public JPanel getStartPanel() {
		return startPanel;
	}

	public void setStartPanel(JPanel startPanel) {
		this.startPanel = startPanel;
	}

	public MainFrame() {
		this.id = MemberToken.getTokenID();

		setSize(950, 600);
		setLocationRelativeTo(null);

		setResizable(false);
		setTitle("SBC");

		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		getContentPane().add(panel, BorderLayout.WEST);
		panel.setPreferredSize(new Dimension(130, 0));

		startPanel = new StartPanel();
		getContentPane().add(startPanel, BorderLayout.CENTER);

		panel.setLayout(new GridLayout(6, 0, 0, 0));

		// 자동차 소개 버튼
		JButton infoBtn = new JButton("차량정보");
		infoBtn.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 15));
		infoBtn.setHorizontalAlignment(SwingConstants.LEFT);
		infoBtn.setContentAreaFilled(false);
		infoBtn.setBorderPainted(false);
		panel.add(infoBtn);

		infoBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 화면 전환
				startPanel.removeAll();
				startPanel.add(new CarInfo(startPanel));
				revalidate();
				repaint();
				infoBtn.setBackground(new Color(204, 229, 255));
			}
		});

		// 커스터마이징/빠른출고 버튼
		JButton customBtn = new JButton("커스터마이징");
		customBtn.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 15));
		customBtn.setHorizontalAlignment(SwingConstants.LEFT);
		customBtn.setContentAreaFilled(false);
		customBtn.setBorderPainted(false);
		panel.add(customBtn);
		customBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 화면 전환
				startPanel.removeAll();
				startPanel.add(new CustomView(startPanel));
				revalidate();
				repaint();
			}
		});

		// 빠른 출고
		JButton fastBtn = new JButton("빠른 출고");
		fastBtn.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 15));
		fastBtn.setHorizontalAlignment(SwingConstants.LEFT);
		fastBtn.setContentAreaFilled(false);
		fastBtn.setBorderPainted(false);
		panel.add(fastBtn);
		fastBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// 화면 전환
				startPanel.removeAll();
				startPanel.add(new FastOutCar(startPanel));
				revalidate();
				repaint();
			}
		});

		// 공지사항/문의글
		JButton noticeBtn = new JButton("게시판");
		noticeBtn.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 15));
		noticeBtn.setHorizontalAlignment(SwingConstants.LEFT);
		noticeBtn.setContentAreaFilled(false);
		noticeBtn.setBorderPainted(false);
		panel.add(noticeBtn);
		noticeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				startPanel.removeAll();
				try {
					startPanel.add(new BoardView(startPanel));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				revalidate();
				repaint();
			}
		});

		// 내 정보 버튼
		JButton myMenuBtn = new JButton("마이페이지");
		myMenuBtn.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 15));
		myMenuBtn.setHorizontalAlignment(SwingConstants.LEFT);
		myMenuBtn.setContentAreaFilled(false);
		myMenuBtn.setBorderPainted(false);
		panel.add(myMenuBtn);

		myMenuBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				CustomController cc = new CustomController();

				try {					
					startPanel.removeAll();
					startPanel.add(new MyInfoView(startPanel));
					revalidate();
					repaint();
				} catch (Exception e2) {
					try {
						startPanel.removeAll();
						startPanel.add(new MySaveView(startPanel));
						revalidate();
						repaint();
					} catch (Exception e3) {
						int result = JOptionPane.showConfirmDialog(null, "견적을 먼저 저장해 주세요.", "order please",
								JOptionPane.YES_OPTION);
						if (result == JOptionPane.YES_OPTION) {
							startPanel.removeAll();
							startPanel.add(new CustomView(startPanel));
							revalidate();
							repaint();
						}
					}
				}
			}
		});

		// log out
		JButton logoutBtn = new JButton("로그아웃");
		logoutBtn.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 15));
		logoutBtn.setHorizontalAlignment(SwingConstants.LEFT);
		logoutBtn.setContentAreaFilled(false);
		logoutBtn.setBorderPainted(false);
		panel.add(logoutBtn);

		logoutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "로그아웃 하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					dispose();
					new Home();
				}
			}
		});

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

}
