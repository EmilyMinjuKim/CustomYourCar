package view.member;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
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
import model.car.CarOrder;
import model.member.Member;
import model.member.MemberList;
import view.car.CustomView;

public class MyInfoView extends JPanel {

	static String filename = "회원명단.txt";
	private JPanel startPanel;
	JPanel myInfoPanel;

	private JFrame frame;
	private String id;
	private static CarOrder orderInfo;
	private JTextField textField;
	private JPanel cov;

	public MyInfoView(JPanel cvp) {
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
		orderInfo = cc.getOrderCar(id);

		Border blackline = BorderFactory.createLineBorder(Color.black);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 820, 580);
		panel.setLayout(null);
		cov.add(panel);

		JLabel lMyName = new JLabel("이름 : " + name);
		lMyName.setBounds(420, 50, 300, 50);
		lMyName.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 16));
		panel.add(lMyName);

		JLabel lMyTel = new JLabel("전화번호 : " + tel);
		lMyTel.setBounds(420, 100, 300, 50);
		lMyTel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 16));
		panel.add(lMyTel);

		JLabel lblNewLabel1 = new JLabel("나의 계약정보");
		lblNewLabel1.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 20));
		lblNewLabel1.setBounds(310, 0, 199, 43);
		panel.add(lblNewLabel1);

		JLabel lbcarselect = new JLabel("선택 차량");
		lbcarselect.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 16));
		lbcarselect.setBounds(35, 270, 97, 28);
		panel.add(lbcarselect);



		JLabel lbcolor = new JLabel("선택 색상");
		lbcolor.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 16));
		lbcolor.setBounds(35, 305, 97, 28);
		panel.add(lbcolor);

		JLabel selColorLabel = new JLabel(orderInfo.getCar().getColor());
		selColorLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		selColorLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 16));
		selColorLabel.setBounds(280, 305, 97, 28);
		panel.add(selColorLabel);

		JLabel lbselect = new JLabel("선택품목");
		lbselect.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 16));
		lbselect.setBounds(35, 345, 90, 28);
		panel.add(lbselect);

		JLabel paymentLabel = new JLabel("할부개월");
		paymentLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 16));
		paymentLabel.setBounds(420, 405, 90, 34);
		panel.add(paymentLabel);
		
		JLabel addressLabel = new JLabel("탁송지역");
		addressLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 16));
		addressLabel.setBounds(420, 345, 90, 28);
		panel.add(addressLabel);
		
		// 내가 선택한 기본 차종
		
		String sort = orderInfo.getCar().getSort();
		JLabel selSortLabel = new JLabel(sort);
		selSortLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		selSortLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 16));
		selSortLabel.setBounds(280, 270, 97, 28);
		panel.add(selSortLabel);
		

		// 선택 품목 필드
		JTextArea selOptionArea = new JTextArea();
		selOptionArea.setColumns(10);
		selOptionArea.setBounds(182, 350, 200, 130);
		selOptionArea.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 16));
		panel.add(selOptionArea);
		selOptionArea.append(orderInfo.getCar().getSort()+"                  "+cc.getSortPrice(sort)+"\n");
		for (String s : orderInfo.getCar().getOptions()) {
			selOptionArea.append(s + "\n");
		}

		JLabel totalPricelLabel = new JLabel("총 가격");
		totalPricelLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 16));
		totalPricelLabel.setBounds(37, 505, 79, 28);
		panel.add(totalPricelLabel);

		JLabel totalPrice = new JLabel(orderInfo.getCar().getPrice() + " 만원");
		totalPrice.setHorizontalAlignment(SwingConstants.TRAILING);
		totalPrice.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));
		totalPrice.setBounds(274, 505, 98, 28);
		panel.add(totalPrice);

		JPanel carImgPanel = new JPanel();
		carImgPanel.setBackground(Color.WHITE);
		carImgPanel.setBounds(30, 51, 350, 220);
		panel.add(carImgPanel);

		// 선택한 차 색깔
		ImageIcon car = new ImageIcon("images/" + orderInfo.getCar().getColor().toLowerCase() + "1.png");
		Image originImg = car.getImage();
		Image changedImg = originImg.getScaledInstance(350, 220, Image.SCALE_SMOOTH);
		car = new ImageIcon(changedImg);
		JLabel img = new JLabel(car);
		carImgPanel.add(img);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.BLACK);
		panel_2_1.setBounds(10, 46, 780, 1);
		panel.add(panel_2_1);

		JLabel receiveLabel = new JLabel("인수방법");
		receiveLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 16));
		receiveLabel.setBounds(420, 225, 90, 28);
		panel.add(receiveLabel);

		// 탁송지
		JLabel region = new JLabel();
		region.setHorizontalAlignment(SwingConstants.TRAILING);
		region.setBackground(Color.WHITE);
		region.setText(orderInfo.getAddress());
		region.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 16));
		region.setBounds(615, 345, 150, 28);
		panel.add(region);

		JLabel deliveryLabel = new JLabel("배달탁송");
		deliveryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		deliveryLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 16));
		deliveryLabel.setBackground(SystemColor.textHighlightText);
		deliveryLabel.setBounds(670, 225, 120, 30);
		panel.add(deliveryLabel);

		JLabel dayLabel = new JLabel("예상출고일");
		dayLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 16));
		dayLabel.setBounds(420, 285, 110, 28);
		panel.add(dayLabel);

		// 탁송 날짜
		JLabel monthJLabel = new JLabel(orderInfo.getDeliveryDate());
		monthJLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		monthJLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 16));
		monthJLabel.setBounds(665, 285, 97, 28);
		panel.add(monthJLabel);

		// 할부개월
		JLabel Pay = new JLabel(orderInfo.getPayMonth());
		Pay.setHorizontalAlignment(SwingConstants.TRAILING);
		Pay.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 16));
		Pay.setBounds(675, 405, 90, 34);
		panel.add(Pay);

		
		//결제날짜
		String time = orderInfo.getPayDate().toString();
		
		JLabel payDay = new JLabel("결제날짜");
		payDay.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 16));
		payDay.setBounds(420, 165, 110, 34);
		panel.add(payDay);
		
		JLabel payTime = new JLabel(time);
		payTime.setHorizontalAlignment(SwingConstants.TRAILING);
		payTime.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 16));
		payTime.setBounds(650, 165, 110, 34);
		panel.add(payTime);
		
		RoundedButton cancelBtn = new RoundedButton("계약 취소하기");
		cancelBtn.setHorizontalAlignment(SwingConstants.CENTER);
		cancelBtn.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));
		cancelBtn.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
		cancelBtn.setBounds(420, 480, 350, 57);
		panel.add(cancelBtn);

		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					JOptionPane.showMessageDialog(cov, cc.deleteList(id));
					cov.removeAll();
					cov.add(new CustomView(cov));
					revalidate();
					repaint();
				} catch (IllegalArgumentException e2) {
					// TODO: handle exception
				}
			}
		});
	}

}
