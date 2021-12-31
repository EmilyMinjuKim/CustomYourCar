package view.car;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.member.MemberToken;
import design.RoundedButton;

import javax.swing.Icon;

public class FastOutCar extends JPanel {

	private JFrame frame;
	JPanel fop;
	JPanel startPanel;

	private int ttprice; // 총 견접합계
	private String gasol; // 가솔린 종류
	private String arcolor; // 차량 색상
	private String caroption; // 차량 옵션
	private String optionprice; // 옵션 가격
	private String id;

	public FastOutCar(JPanel startPanel) {
		setBackground(Color.WHITE);
		this.startPanel = startPanel;
		fop = this;
		this.id = MemberToken.tokenID;

		setSize(900, 600);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 820, 580);
		fop.add(panel);
		panel.setLayout(null);
		// 첫번째 패널
		JPanel panel1 = new JPanel();
		panel1.setBounds(12, 0, 240, 600);
		panel1.setBackground(Color.WHITE);

		panel1.setPreferredSize(new Dimension(240, 600));
		panel.add(panel1);
		panel1.setLayout(null);

		// 첫번째 패널 속 상단 패널
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 35, 240, 226);
		panel_1.setBackground(Color.WHITE);
		panel_1.setPreferredSize(new Dimension(240, 240));
		panel1.add(panel_1);

		// 첫번째 패널 속 문구
		JLabel label__1 = new JLabel("가솔린 1.0 인스퍼레이션");
		label__1.setBounds(39, 10, 167, 21);
		Font font__1 = new Font("나눔스퀘어OTF Bold", Font.BOLD, 14);
		JLabel label__2 = new JLabel("IVORY");
		label__2.setBounds(104, 37, 40, 21);
		Font font__2 = new Font("나눔스퀘어OTF Bold", Font.PLAIN, 12);
		Font font__3 = new Font("나눔스퀘어OTF Bold", Font.PLAIN, 12);
		label__1.setFont(font__1);
		label__2.setFont(font__2);
		panel_1.setLayout(null);
		label__1.setBackground(Color.white);
		panel_1.add(label__1);
		panel_1.add(label__2);

		// 첫번째 패널 속 사진
		ImageIcon img1 = new ImageIcon("images/ivoryfast.png");

		// 첫번째 패널 속 중앙 패널
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 279, 240, 96);
		panel_2.setBackground(Color.WHITE);
		panel_2.setPreferredSize(new Dimension(240, 180));
		panel1.add(panel_2);

		// 첫번째 패널 속 중앙 문구
		JLabel label__4 = new JLabel("선택 옵션 : 스토리지");
		label__4.setBounds(49, 10, 165, 20);
		Font font__4 = new Font("맑은 고딕", Font.PLAIN, 14);
		panel_2.setLayout(null);

		label__4.setFont(font__4);

		panel_2.add(label__4);

		JLabel label__4_1 = new JLabel("총 옵션 가격 : 400,000원");
		label__4_1.setBounds(38, 37, 165, 20);
		label__4_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		panel_2.add(label__4_1);

		JLabel label__4_2 = new JLabel("총 차량 가격 : 18,700,000원");
		label__4_2.setBounds(34, 66, 190, 20);
		label__4_2.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		panel_2.add(label__4_2);

		// 첫번째 패널 속 하단 패널
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 385, 240, 141);
		panel_3.setBackground(Color.WHITE);
		panel_3.setPreferredSize(new Dimension(240, 180));
		panel1.add(panel_3);

		// 첫번째 패널 속 하단 문구
		JLabel label__8 = new JLabel("총 견적 합계 : 19,100,000 원");
		label__8.setBounds(20, 10, 210, 21);
		Font font__8 = new Font("나눔스퀘어OTF Bold", Font.BOLD, 15);
		panel_3.setLayout(null);

		label__8.setFont(font__8);
		label__8.setForeground(new Color(0, 0, 128));

		panel_3.add(label__8);

		// 첫번째 패널 속 하단 버튼
		RoundedButton btn1 = new RoundedButton("계약하기");
		btn1.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 20));
		btn1.setBounds(20, 52, 200, 50);
		btn1.setBackground(new Color(0, 0, 128));
		btn1.setForeground(Color.WHITE);
		btn1.setPreferredSize(new Dimension(200, 50));
		panel_3.add(btn1);

		// 첫번째 계약하기 버튼 액션
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ArrayList payList = new ArrayList();
				ArrayList<String> caroptionlist = new ArrayList<String>();

				gasol = "인스퍼레이션";
				ttprice = 1910;

				arcolor = "IVORY";

				caroption = "스토리지";

				optionprice = "40";

				caroptionlist.add(caroption + " " + optionprice + " 만원");

				payList.add(gasol); // 0번째 차 종류
				payList.add(arcolor); // 1번째 차 컬러
				payList.add(caroptionlist); // 2번째 차 옵션
				payList.add(ttprice); // 3번째 총 가격


				panel.removeAll();
				panel.add(new CarOrderView(fop, payList, MemberToken.tokenID));
				revalidate();
				repaint();

			}

		});
//		

		// -------------------------------------------------------------

		// 두번째 패널
		JPanel panel2 = new JPanel();
		panel2.setBounds(257, 0, 240, 600);
		panel2.setBackground(Color.WHITE);
		panel2.setPreferredSize(new Dimension(240, 600));
		panel.add(panel2);
		panel2.setLayout(null);

		// 두번째 패널 속 상단 패널
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 35, 240, 226);
		panel_4.setBackground(Color.WHITE);
		panel_4.setPreferredSize(new Dimension(240, 240));
		panel2.add(panel_4);

		// 두번째 패널 속 문구
		JLabel label_1 = new JLabel("가솔린 1.0 터보 스마트");
		label_1.setBounds(42, 8, 157, 21);
		Font font_1 = new Font("나눔스퀘어OTF Bold", Font.BOLD, 14);
		JLabel label_2 = new JLabel("ORANGE");
		label_2.setBounds(97, 39, 60, 19);
		Font font_2 = new Font("나눔스퀘어OTF Bold", Font.PLAIN, 13);
		Font font_3 = new Font("나눔스퀘어OTF Bold", Font.PLAIN, 13);

		label_1.setFont(font_1);
		label_2.setFont(font_2);
		panel_4.setLayout(null);

		label_1.setBackground(Color.white);
		panel_4.add(label_1);
		panel_4.add(label_2);

		// 두번째 패널 속 사진
		ImageIcon img2 = new ImageIcon("images/orangefast.png");
		JLabel lblNewLabel_1 = new JLabel(img2);
		lblNewLabel_1.setBounds(0, 77, 240, 132);
		panel_4.add(lblNewLabel_1);

		// 두번째 패널 속 중앙 패널
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 279, 240, 96);
		panel_5.setBackground(Color.WHITE);
		panel_5.setPreferredSize(new Dimension(240, 180));
		panel2.add(panel_5);
		Font font_4 = new Font("나눔스퀘어OTF Bold", Font.BOLD, 14);
		panel_5.setLayout(null);

		JLabel label__4_3 = new JLabel("선택 옵션 : 터보 엔진");
		label__4_3.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		label__4_3.setBounds(49, 10, 165, 20);
		panel_5.add(label__4_3);

		JLabel label__4_1_1 = new JLabel("총 옵션 가격 : 950,000원");
		label__4_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		label__4_1_1.setBounds(38, 36, 165, 20);
		panel_5.add(label__4_1_1);

		JLabel label__4_2_1 = new JLabel("총 차량 가격 : 13,850,000원");
		label__4_2_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		label__4_2_1.setBounds(34, 66, 190, 20);
		panel_5.add(label__4_2_1);

		// 두번째 패널 속 하단 패널
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 385, 240, 141);
		panel_6.setBackground(Color.WHITE);
		panel_6.setPreferredSize(new Dimension(240, 180));
		panel2.add(panel_6);

		// 두번째 패널 속 하단 문구
		JLabel label_8 = new JLabel("총 견적 합계 : 14,800,000 원");
		label_8.setBounds(20, 10, 210, 21);
		Font font_8 = new Font("나눔스퀘어OTF Bold", Font.BOLD, 15);
		panel_6.setLayout(null);

		label_8.setFont(font_8);
		label_8.setForeground(new Color(0, 0, 128));

		panel_6.add(label_8);

		// 첫번째 패널 속 하단 버튼
		RoundedButton btn2 = new RoundedButton("계약하기");
		btn2.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 20));
		btn2.setBounds(20, 52, 200, 50);
		btn2.setBackground(new Color(0, 0, 128));
		btn2.setForeground(Color.WHITE);
		btn2.setPreferredSize(new Dimension(200, 50));
		panel_6.add(btn2);
		// 두번째 계약하기 버튼 액션
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				ArrayList payList2 = new ArrayList();
				ArrayList<String> caroptionlist2 = new ArrayList<String>();

				gasol = "스마트";
				ttprice = 1480;

				arcolor = "ORANGE";

				caroption = "TURBO";

				optionprice = "95";


				caroptionlist2.add(caroption + " " + optionprice + " 만원");

				payList2.add(gasol); // 0번째 차 종류
				payList2.add(arcolor); // 1번째 차 컬러
				payList2.add(caroptionlist2); // 2번째 차 옵션
				payList2.add(ttprice); // 3번째 총 가격


				panel.removeAll();
				panel.add(new CarOrderView(fop, payList2, MemberToken.tokenID));
				revalidate();
				repaint();

			}
		});
		// ---------------------------------------------------

		// 세번째 패널
		JPanel panel3 = new JPanel();
		panel3.setBounds(502, 0, 240, 600);
		panel3.setBackground(Color.WHITE);
		panel3.setPreferredSize(new Dimension(240, 600));
		panel.add(panel3);
		panel3.setLayout(null);

		// 세번째 패널 속 상단 패널
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(0, 35, 240, 226);
		panel_7.setBackground(Color.WHITE);
		panel_7.setPreferredSize(new Dimension(240, 240));
		panel3.add(panel_7);

		// 세번째 패널 속 문구
		JLabel label_1_ = new JLabel("가솔린 1.0 모던");
		label_1_.setBounds(70, 10, 113, 21);
		Font font_1_ = new Font("나눔스퀘어OTF Bold", Font.BOLD, 14);
		JLabel label_2_ = new JLabel("KHAKII");
		label_2_.setBounds(98, 37, 42, 19);
		Font font_2_ = new Font("나눔스퀘어OTF Bold", Font.PLAIN, 13);
		Font font_3_ = new Font("나눔스퀘어OTF Bold", Font.PLAIN, 13);

		label_1_.setFont(font_1_);
		label_2_.setFont(font_2_);

		label__1.setBackground(Color.white);

		ImageIcon img3 = new ImageIcon("images/ivoryfast.png");
		JLabel lblNewLabel3 = new JLabel(img3);
		lblNewLabel3.setBounds(0, 77, 240, 132);
		panel_1.add(lblNewLabel3);
		panel_7.setLayout(null);

		// 세번째 패널 속 사진

		JLabel lblNewLabel_2 = new JLabel((Icon) null);
		lblNewLabel_2.setBounds(37, 15, 0, 0);
		panel_7.add(lblNewLabel_2);
		panel_7.add(label_1_);

		JLabel label_2_1 = new JLabel("KHAKI");
		label_2_1.setBounds(109, 35, 53, 19);
		label_2_1.setFont(new Font("나눔스퀘어OTF Bold", Font.PLAIN, 13));
		panel_7.add(label_2_1);

		ImageIcon img0 = new ImageIcon("images/kakiffast.png");
		JLabel lblNewLabel_1_1 = new JLabel(img0);
		lblNewLabel_1_1.setBounds(0, 77, 240, 132);
		panel_7.add(lblNewLabel_1_1);

		// 세번째 패널 속 중앙 패널
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(0, 279, 240, 96);
		panel_8.setBackground(Color.WHITE);
		panel_8.setPreferredSize(new Dimension(240, 180));

		// 세번째 패널 속 상단 문구
		panel3.add(panel_8);
		Font font_4_ = new Font("나눔스퀘어OTF Bold", Font.BOLD, 14);
		panel_8.setLayout(null);

		JLabel label__4_3_1 = new JLabel("선택 옵션 : 네비게이션");
		label__4_3_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		label__4_3_1.setBounds(49, 10, 165, 20);
		panel_8.add(label__4_3_1);

		JLabel label__4_1_1_1 = new JLabel("총 옵션 가격 : 1,520,000원");
		label__4_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		label__4_1_1_1.setBounds(38, 40, 175, 20);
		panel_8.add(label__4_1_1_1);

		JLabel label__4_2_1_1 = new JLabel("총 차량 가격 : 15,900,000원");
		label__4_2_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		label__4_2_1_1.setBounds(34, 66, 190, 20);
		panel_8.add(label__4_2_1_1);

		// 세번째 패널 속 하단 패널
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(0, 385, 240, 141);
		panel_9.setBackground(Color.WHITE);
		panel_9.setPreferredSize(new Dimension(240, 180));
		panel3.add(panel_9);

		// 세번째 패널 속 하단 문구
		JLabel label_8_ = new JLabel("총 견적 합계 : 17,400,000 원");
		label_8_.setBounds(20, 10, 210, 21);
		Font font_8_ = new Font("나눔스퀘어OTF Bold", Font.BOLD, 15);
		panel_9.setLayout(null);

		label_8_.setFont(font_8_);
		label_8_.setForeground(new Color(0, 0, 128));

		panel_9.add(label_8_);

		// 세번째 패널 속 하단 버튼
		RoundedButton btn3 = new RoundedButton("계약하기");
		btn3.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 20));
		btn3.setBounds(20, 52, 200, 50);
		btn3.setBackground(new Color(0, 0, 128));
		btn3.setForeground(Color.WHITE);
		btn3.setPreferredSize(new Dimension(200, 50));
		panel_9.add(btn3);

		// 세번째 계약하기 버튼 액션
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ArrayList payList3 = new ArrayList();
				ArrayList<String> caroptionlist3 = new ArrayList<String>();

				gasol = "모던";
				ttprice = 1742;

				arcolor = "KHAKII";

				caroption = "NAVI";

				optionprice = "152";

				caroptionlist3.add(caroption + " " + optionprice + " 만원");

				payList3.add(gasol); // 0번째 차 종류
				payList3.add(arcolor); // 1번째 차 컬러
				payList3.add(caroptionlist3); // 2번째 차 옵션
				payList3.add(ttprice); // 3번째 총 가격

				panel.removeAll();
				panel.add(new CarOrderView(fop, payList3, MemberToken.tokenID));
				revalidate();
				repaint();

			}
		});

	}
}
