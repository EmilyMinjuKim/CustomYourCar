package view.login;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.member.MemberController;
import design.RoundedButton;
import model.member.Member;
import model.member.MemberList;
import view.Home;

public class FrameJoin extends JPanel {

	static String filename = "회원명단.txt";
	JPanel frameJoinPanel;

	public FrameJoin(JPanel homePanel) {
		this.frameJoinPanel = homePanel;

		// JPanel 구조
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setSize(900, 600);

		// 아이디, 비번 입력창
		JLabel ljoin = new JLabel("회 원 가 입");
		JLabel lID = new JLabel("아이디");
		JLabel lPW = new JLabel("비밀번호");
		JLabel lname = new JLabel("이름");
		JLabel ltel = new JLabel("전화번호");

		JTextField tfID = new JTextField(10);
		JPasswordField tfPW = new JPasswordField(10);
		JTextField tfname = new JTextField(10);
		JTextField tftel = new JTextField(10);

		ljoin.setSize(300, 40);
		ljoin.setLocation(getWidth() / 2 - 50, 60);
		ljoin.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 25));

		lID.setSize(100, 40);
		lID.setLocation(200, 150);
		lID.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));

		lPW.setSize(100, 40);
		lPW.setLocation(200, 200);
		lPW.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));

		lname.setSize(100, 40);
		lname.setLocation(200, 250);
		lname.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));


		ltel.setSize(100, 40);
		ltel.setLocation(200, 300);
		ltel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));

		tfID.setSize(300, 40);
		tfID.setLocation(getWidth() / 4 + 70, 150);
		tfID.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));

		tfPW.setSize(300, 40);
		tfPW.setLocation(getWidth() / 4 + 70, 200);
		tfPW.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));
		tfPW.setEchoChar('*');

		tfname.setSize(300, 40);
		tfname.setLocation(getWidth() / 4 + 70, 250);
		tfname.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));

		tftel.setSize(300, 40);
		tftel.setLocation(getWidth() / 4 + 70, 300);
		tftel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));

		add(ljoin);
		add(lID);
		add(lPW);
		add(lname);
		add(ltel);
		add(tfID);
		add(tfPW);
		add(tfname);
		add(tftel);

		// 하단의 버튼 설정
		RoundedButton btnDone = new RoundedButton("완료");
		RoundedButton btnHome = new RoundedButton("홈");

		btnDone.setSize(300, 40);
		btnDone.setLocation(getWidth() / 4 + 70, 400);
		btnDone.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 20));

		btnHome.setSize(300, 40);
		btnHome.setLocation((int) btnDone.getLocation().getX(), (int) btnDone.getLocation().getY() + 50);

		btnHome.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 20));

		add(btnDone);
		add(btnHome);

		// 버튼 이벤트
		btnDone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String inputID = tfID.getText();
				String inputPW = new String(tfPW.getPassword());
				String inputName = tfname.getText();
				String inputTel = tftel.getText();

				if (!inputID.isEmpty() && (!inputPW.isEmpty()) && !inputName.isEmpty() && !inputTel.isEmpty()) {
					
					MemberController cm = new MemberController();
					ArrayList<Member> memberArr = cm.readFile(filename);
					MemberList memberList = new MemberList();

					for (int i = 0; i < memberArr.size(); i++) {
						memberList.addMember(memberArr.get(i));
					}

					String idCheck = memberList.joinMember(inputID);
					
					if(!idCheck.isEmpty()) {
						JOptionPane.showMessageDialog(null, idCheck);
						return;
					}

					try (BufferedWriter br = new BufferedWriter(new FileWriter("회원명단.txt", true))) {

						br.write(inputID + "/");
						br.write(inputPW + "/");
						br.write(inputName + "/");
						br.write(inputTel + "\n");

					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "회원가입이 실패했습니다.");
					}

					JOptionPane.showMessageDialog(null, "회원가입에 성공했습니다.");
					dispose();
					new Home();

				} else {
					JOptionPane.showMessageDialog(null, "회원가입이 실패했습니다.");
				}

			}
		});

		
		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Home();
			}
		});

	}// 생성자
	
	public void dispose() {
	    JFrame parent = (JFrame) this.getTopLevelAncestor();
	    parent.dispose();
	}
}