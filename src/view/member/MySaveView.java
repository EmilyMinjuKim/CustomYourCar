package view.member;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;

import controller.car.CustomController;
import controller.member.MemberController;
import controller.member.MemberToken;
import design.RoundedButton;
import model.car.Car;
import model.car.CarOrder;
import model.member.Member;
import model.member.MemberList;
import view.car.CarOrderView;
import view.car.CustomView;

public class MySaveView extends JPanel {

	static String filename = "회원명단.txt";
	private JPanel cov;

	private JFrame frame;
	private String id;
	private Car car;
	private JTextField textField;

	public MySaveView(JPanel cvp) {
		cov = this;

		setBackground(new Color(255, 255, 255));
		setSize(900, 600);
		setLayout(null);

		MemberController cm = new MemberController();
		ArrayList<Member> memberArr = cm.readFile(filename);
		MemberList memberList = new MemberList();

		for (int i = 0; i < memberArr.size(); i++) {
			memberList.addMember(memberArr.get(i));
		}
		this.id = MemberToken.getTokenID();
		String name = memberList.infoName(id);
		String tel = memberList.infoTel(id);

		// 주문 정보 갖고오기
		CustomController cc = new CustomController();
		this.car = cc.getCar(id);

		Border blackline = BorderFactory.createLineBorder(Color.black);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 820, 580);
		panel.setLayout(null);
		cov.add(panel);

		JLabel lMyName = new JLabel("• 이름 : " + name);
		lMyName.setBounds(30, 50, 200, 50);
		lMyName.setFont(new Font("Dialog", Font.BOLD, 16));
		panel.add(lMyName);

		JLabel lMyTel = new JLabel("• 전화번호 : " + tel);
		lMyTel.setBounds(30, 110, 250, 50);
		lMyTel.setFont(new Font("Dialog", Font.BOLD, 16));
		panel.add(lMyTel);

		JLabel lblNewLabel1 = new JLabel("나의 견적 정보");
		lblNewLabel1.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));
		lblNewLabel1.setBounds(320, 3, 199, 43);
		panel.add(lblNewLabel1);

		JLabel lbcarselect = new JLabel("• 선택 차량");
		lbcarselect.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 16));
		lbcarselect.setBounds(420, 70, 90, 28);
		panel.add(lbcarselect);

		// 내가 선택한 기본 차종
		String sort = car.getSort();
		JLabel selSortLabel = new JLabel(sort);
		selSortLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		selSortLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 16));
		selSortLabel.setBounds(673, 70, 97, 28);
		panel.add(selSortLabel);

		JLabel lbcolor = new JLabel("• 선택 색상");
		lbcolor.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 16));
		lbcolor.setBounds(420, 130, 90, 28);
		panel.add(lbcolor);

		JLabel selColorLabel = new JLabel(car.getColor());
		selColorLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		selColorLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 16));
		selColorLabel.setBounds(675, 130, 97, 28);
		panel.add(selColorLabel);

		JLabel lbselect = new JLabel("• 선택품목");
		lbselect.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 16));
		lbselect.setBounds(420, 210, 90, 28);
		panel.add(lbselect);

		// 선택 품목 필드
		JTextArea selOptionArea = new JTextArea();
		selOptionArea.setColumns(10);
		selOptionArea.setBounds(578, 213, 200, 130);
		selOptionArea.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 16));
		panel.add(selOptionArea);
		selOptionArea.append(car.getSort() + "                  " + cc.getSortPrice(sort) + "\n");
		for (String s : car.getOptions()) {
			selOptionArea.append(s + "\n");
		}

		JLabel totalPricelLabel = new JLabel("• 총 가격");
		totalPricelLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 16));
		totalPricelLabel.setBounds(420, 400, 90, 28);
		panel.add(totalPricelLabel);

		JLabel totalPrice = new JLabel(car.getPrice() + " 만원");
		totalPrice.setHorizontalAlignment(SwingConstants.TRAILING);
		totalPrice.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));
		totalPrice.setBounds(670, 400, 100, 28);
		panel.add(totalPrice);

		JPanel carImgPanel = new JPanel();
		carImgPanel.setBackground(Color.WHITE);
		carImgPanel.setBounds(30, 210, 350, 220);
		panel.add(carImgPanel);

		// 선택한 차 색깔
		ImageIcon car1 = new ImageIcon("images/" + car.getColor().toLowerCase() + "1.png");
		Image originImg = car1.getImage();
		Image changedImg = originImg.getScaledInstance(350, 220, Image.SCALE_SMOOTH);
		car1 = new ImageIcon(changedImg);
		JLabel img = new JLabel(car1);
		carImgPanel.add(img);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.BLACK);
		panel_2_1.setBounds(10, 46, 780, 1);
		panel.add(panel_2_1);

		RoundedButton correctionBtn = new RoundedButton("견적 수정하기");
		correctionBtn.setHorizontalAlignment(SwingConstants.CENTER);
		correctionBtn.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));
		correctionBtn.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
		correctionBtn.setBounds(30, 480, 355, 60);
		panel.add(correctionBtn);

		correctionBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					JOptionPane.showMessageDialog(cov, "견적 수정창으로 이동 합니다.");
					cov.removeAll();
					cov.add(new CustomView(cov));
					revalidate();
					repaint();
				} catch (IllegalArgumentException e2) {
					// TODO: handle exception
				}
			}
		});

		RoundedButton orderBtn = new RoundedButton("주문하기");
		orderBtn.setHorizontalAlignment(SwingConstants.CENTER);
		orderBtn.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));
		orderBtn.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
		orderBtn.setBounds(423, 480, 355, 60);
		panel.add(orderBtn);

		orderBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList order = new ArrayList<>();
				Car c = new Car();
				c = cc.getCar(id);
				order.add(c.getSort());
				order.add(c.getColor());
				order.add(c.getOptions());
				order.add(c.getPrice());
				JOptionPane.showMessageDialog(cov, "주문 계약 창으로 이동 합니다.");
				cov.removeAll();
				cov.add(new CarOrderView(cov, order, MemberToken.tokenID));
				revalidate();
				repaint();
			}
		});
	}

}
