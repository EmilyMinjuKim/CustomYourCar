package view.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.member.MemberController;
import controller.member.MemberToken;
import design.RoundedButton;
import model.member.Member;
import model.member.MemberList;
import view.MainFrame;

public class FrameLogin extends JPanel {

	static String filename = "회원명단.txt";
	JPanel frameLoginPanel;

	public FrameLogin(JPanel homePanel) {
		this.frameLoginPanel = homePanel;

		// JPanel 구조
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setSize(900, 600);

		// 아이디, 비번 입력창
		JLabel lID = new JLabel("ID");
		JLabel lPW = new JLabel("PW");
		JTextField tfID = new JTextField(10);
		JPasswordField tfPW = new JPasswordField(10);

		lID.setSize(300, 50);
		lID.setLocation(getWidth() / 4, 100);
		lID.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));

		lPW.setSize(300, 50);
		lPW.setLocation(getWidth() / 4, 170);
		lPW.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));

		tfID.setSize(300, 50);
		tfID.setLocation(getWidth() / 4 + 70, 100);
		tfID.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));

		tfPW.setSize(300, 50);
		tfPW.setLocation(getWidth() / 4 + 70, 170);
		tfPW.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));
		tfPW.setEchoChar('*');

		add(lID);
		add(lPW);
		add(tfID);
		add(tfPW);

		// 하단의 버튼 설정
		RoundedButton btnLogin = new RoundedButton("로그인");
		RoundedButton btnJoin = new RoundedButton("회원가입");
		

		btnLogin.setSize(300, 40);
		btnLogin.setLocation(getWidth() / 4 + 70, 260);
		btnLogin.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));

		btnJoin.setSize(300, 40);
		btnJoin.setLocation((int) btnLogin.getLocation().getX(), (int) btnLogin.getLocation().getY() + 50);

		btnJoin.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));

		add(btnLogin);
		add(btnJoin);

		// 버튼 이벤트
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				MemberController cm = new MemberController();
				ArrayList<Member> memberArr = cm.readFile(filename);
				MemberList memberList = new MemberList();

				for (int i = 0; i < memberArr.size(); i++) {
					memberList.addMember(memberArr.get(i));
				}

				String id = tfID.getText();
				String idCheck = memberList.loginMember(id);

				if (idCheck.isEmpty()) {
					JOptionPane.showMessageDialog(null, "아이디를 확인해주세요.");
				} else {
					if (idCheck.equals(new String(tfPW.getPassword()))) {
						MemberToken.tokenID = id;
						JOptionPane.showMessageDialog(null, id + "님, 환영합니다!");
						dispose();
						new MainFrame();
					} else {
						JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요.");
					}
				}

			}
		});

		btnJoin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				frameLoginPanel.removeAll();
				frameLoginPanel.add(new FrameJoin(homePanel));
				frameLoginPanel.revalidate();
				frameLoginPanel.repaint();

			}
		});

	}// 생성자
	
	
	public void dispose() {
	    JFrame parent = (JFrame) this.getTopLevelAncestor();
	    parent.dispose();
	}
	


}