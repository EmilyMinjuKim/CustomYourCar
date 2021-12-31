package view.car;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import controller.car.CustomController;
import design.RoundedButton;
import view.member.MyInfoView;

public class CarOrderView extends JPanel {

	private JFrame frame;
	private JPanel cov;
	private ArrayList orderList;// 주문내역
	private String id;// 주문자id
	private String payMonth;// 할부개월
	private String region; // 탁송지
	private String city;// 탁송지
	private String LocalMonth;
	LocalDate now = LocalDate.now();
	private JTextField textField;
	private JPanel StartPanel;

	public CarOrderView(JPanel cvp, ArrayList orderList, String id) {
		cov = this;
		this.orderList = orderList;
		this.id = id;
		this.payMonth = "일시불";
		this.region = "서울";
		this.city = "서울특별시";
		this.LocalMonth = "2022년 2월";

		setSize(900, 600);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 820, 580);
		panel.setLayout(null);
		cov.add(panel);

		JPanel line1 = new JPanel();
		line1.setBackground(Color.BLACK);
		line1.setBounds(10, 47, 780, 2);
		panel.add(line1);

		JLabel priceLabel = new JLabel("최종 차량 결제 정보");
		priceLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));
		priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceLabel.setBounds(290, 0, 199, 43);
		panel.add(priceLabel);

		JLabel addressInfoLabel = new JLabel("인수 정보");
		addressInfoLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 20));
		addressInfoLabel.setBounds(550, 60, 90, 34);
		panel.add(addressInfoLabel);

		// 지역 및 날짜 선택정보 시작
		String[] select = { "서울", "경기", "경남", "부산" };
		String[] select1 = { "서울특별시" };
		String[] select2 = { "가평군", "고양시", "과천시", "광명시", "광주시" };
		String[] select3 = { "거제시", "창원시", "마산시", "밀양시", "통영시" };
		String[] select4 = { "부산광역시" };
		JComboBox cityComboBox = new JComboBox(select);
		cityComboBox.setForeground(Color.DARK_GRAY);
		cityComboBox.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 15));
		cityComboBox.setBounds(510, 218, 125, 50);
		cityComboBox.setBackground(Color.WHITE);
		panel.add(cityComboBox);

		JComboBox seoulComboBox = new JComboBox(select1);
		seoulComboBox.setForeground(Color.DARK_GRAY);
		seoulComboBox.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 15));
		seoulComboBox.setBounds(636, 218, 135, 50);
		seoulComboBox.setBackground(Color.WHITE);
		seoulComboBox.setToolTipText(select1[0]);
		panel.add(seoulComboBox);

		JComboBox gyeonggiComboBox = new JComboBox(select2);
		gyeonggiComboBox.setForeground(Color.DARK_GRAY);
		gyeonggiComboBox.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 15));
		gyeonggiComboBox.setBounds(636, 218, 135, 50);
		gyeonggiComboBox.setBackground(Color.WHITE);
		gyeonggiComboBox.setToolTipText(select2[0]);
		panel.add(gyeonggiComboBox);

		JComboBox gyeongnamComboBox = new JComboBox(select3);
		gyeongnamComboBox.setForeground(Color.DARK_GRAY);
		gyeongnamComboBox.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 15));
		gyeongnamComboBox.setBounds(636, 218, 135, 50);
		gyeongnamComboBox.setBackground(Color.WHITE);
		gyeongnamComboBox.setToolTipText(select3[0]);
		panel.add(gyeongnamComboBox);

		JComboBox busanComboBox = new JComboBox(select4);
		busanComboBox.setForeground(Color.DARK_GRAY);
		busanComboBox.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 15));
		busanComboBox.setBounds(636, 218, 135, 50);
		busanComboBox.setBackground(Color.WHITE);
		busanComboBox.setToolTipText(select4[0]);
		panel.add(busanComboBox);

		// 배송 가능 날짜
		String[] ym = { "2022년 2월" };
		String[] ym1 = { "2022년 5월", "2022년 8월", "2022년 1월", "2022년 3월", "2022년 6월" };
		String[] ym2 = { "2022년 3월", "2022년 10월", "2022년 6월", "2023년 2월", "2022년 4월" };
		String[] ym3 = { "2023년 1월" };
		JLabel monthJLabel = new JLabel();
		monthJLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		monthJLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.PLAIN, 18));
		monthJLabel.setBounds(665, 325, 103, 28);
		panel.add(monthJLabel);
		monthJLabel.setText(ym[0]);
		monthJLabel.setText(ym1[0]);
		monthJLabel.setText(ym2[0]);
		monthJLabel.setText(ym3[0]);
		monthJLabel.setVisible(false);

		// 지역 및 날짜 선택정보
		JLabel addressLabel = new JLabel("탁송지역");
		addressLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));
		addressLabel.setBounds(411, 231, 90, 28);
		panel.add(addressLabel);

		JLabel receiveLabel = new JLabel("인수방법");
		receiveLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));
		receiveLabel.setBounds(411, 128, 90, 28);
		panel.add(receiveLabel);

		JLabel dayLabel = new JLabel("예상출고일");
		dayLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));
		dayLabel.setBounds(411, 328, 125, 28);
		panel.add(dayLabel);

		JButton deliveryLabel = new JButton("배달 탁송");
		deliveryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		deliveryLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.PLAIN, 18));
		deliveryLabel.setToolTipText("<html><Strong><h2>   탁송기사가 고객님이 원하시는</p><br>장소로 차량을 배송해 드립니다.   <h2><Strong>");
		deliveryLabel.setBackground(SystemColor.textHighlightText);
		deliveryLabel.setBounds(650, 127, 120, 30);
		panel.add(deliveryLabel);

		JPanel line2 = new JPanel();
		line2.setBackground(Color.BLACK);
		line2.setBounds(400, 395, 393, 2);
		panel.add(line2);

		JPanel line3 = new JPanel();
		line3.setBackground(Color.BLACK);
		line3.setBounds(10, 255, 368, 2);
		panel.add(line3);

		JPanel carImgPanel = new JPanel();
		carImgPanel.setBackground(Color.WHITE);
		carImgPanel.setBounds(12, 45, 365, 210);
		panel.add(carImgPanel);

		JPanel line4 = new JPanel();
		line4.setBackground(Color.BLACK);
		line4.setBounds(388, 47, 1, 517);
		panel.add(line4);

		JLabel paymentLabel = new JLabel("할부개월");
		paymentLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 20));
		paymentLabel.setBounds(410, 421, 90, 34);
		panel.add(paymentLabel);

		String[] selectPay = { "일시불", "5개월", "12개월", "24개월", "36개월" };
		JComboBox PayComboBox = new JComboBox(selectPay);
		PayComboBox.setForeground(Color.DARK_GRAY);
		PayComboBox.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 15));
		PayComboBox.setBounds(598, 427, 170, 25);
		PayComboBox.setBackground(Color.WHITE);
		panel.add(PayComboBox);
		int index = PayComboBox.getSelectedIndex();

		// 할부 개월 선택
		PayComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				int month = cb.getSelectedIndex();
				switch (month) {
				case 0:
					payMonth = "일시불";
					break;
				case 1:
					payMonth = "5개월";
					break;
				case 2:
					payMonth = "12개월";
					break;
				case 3:
					payMonth = "24개월";
					break;
				case 4:
					payMonth = "36개월";
					break;
				}
			}
		});

		System.out.println(selectPay[index]);

		// 선택한 차량 색 가져오기.
		String colorpath = (String) orderList.get(1);
		System.out.println("colorpath:" + colorpath);
		ImageIcon car = new ImageIcon("images/" + colorpath.toLowerCase() + "1.png");
		Image originImg = car.getImage();
		Image changedImg = originImg.getScaledInstance(350, 220, Image.SCALE_SMOOTH);
		car = new ImageIcon(changedImg);
		JLabel img = new JLabel(car);
		carImgPanel.add(img);

		JLabel sortLabel = new JLabel("선택 차량");
		sortLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));
		sortLabel.setBounds(20, 277, 79, 28);
		panel.add(sortLabel);

		// 선택차량 종류
		String sort = (String) orderList.get(0);
		JLabel choiceSortLabel = new JLabel(sort);
		choiceSortLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 17));
		choiceSortLabel.setBounds(150, 279, 175, 22);
		panel.add(choiceSortLabel);

		// 기본선택 가격
		CustomController cc = new CustomController();
		JLabel sortPriceLabel = new JLabel(cc.getSortPrice(sort));
		sortPriceLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		sortPriceLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 17));
		sortPriceLabel.setBounds(175, 279, 175, 22);
		panel.add(sortPriceLabel);

		JLabel choiceLabel = new JLabel("선택 품목");
		choiceLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));
		choiceLabel.setBounds(20, 367, 79, 28);
		panel.add(choiceLabel);

		// 선택한 차량 색
		JLabel colorLabel = new JLabel((String) orderList.get(1));
		colorLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		colorLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 17));
		colorLabel.setBounds(174, 319, 175, 22);
		panel.add(colorLabel);

		// 선택 옵션 리스트에 대한 가격을 뽑아오는 메소드 호출.
		ArrayList list = (ArrayList) orderList.get(2);
		// ArrayList prices = cc.getOptionPrice(list);

		JTextArea choiceList = new JTextArea();
		choiceList.setBounds(150, 372, 220, 140);
		choiceList.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 17));
		choiceList.setAlignmentX(RIGHT_ALIGNMENT);
		panel.add(choiceList);

		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String option = it.next();
			choiceList.append(option + "\n");
		}

		int price = (int) orderList.get(3);
		JLabel priceInfoLabel = new JLabel("총 견적 합계 :");
		priceInfoLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));
		priceInfoLabel.setBounds(20, 520, 143, 22);
		panel.add(priceInfoLabel);

		JLabel myPriceLabel = new JLabel(price + " 만원");
		myPriceLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		myPriceLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 19));
		myPriceLabel.setBounds(180, 520, 175, 22);
		panel.add(myPriceLabel);

		RoundedButton buyBtn = new RoundedButton("계약하기");
		buyBtn.setHorizontalAlignment(SwingConstants.CENTER);
		buyBtn.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));
		buyBtn.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
		buyBtn.setBounds(424, 487, 346, 57);
		panel.add(buyBtn);

		JLabel sortLabel_1 = new JLabel("선택 색상");
		sortLabel_1.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));
		sortLabel_1.setBounds(20, 319, 79, 28);
		panel.add(sortLabel_1);

		// -------------------------------------------------------------------------------------------
		// 계약하기 버튼 이벤트
		buyBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList buyInfo = new ArrayList();
				if (buyInfo.size() > 0) {
					buyInfo.clear();
				}
				String address = region + " " + city;// 탁송주소

				buyInfo.add(address);// 0번째 탁송지
				buyInfo.add(payMonth);// 1번째 할부개월
				buyInfo.add(LocalMonth);// 2번째 탁송날짜
				buyInfo.add(now);// 3번째 결제일
				try {
					if (cc.getOrderCar(id).getPayDate() == null) {
						JOptionPane.showMessageDialog(cov, cc.buyCar(buyInfo, orderList, id));
						cov.removeAll();
						cov.add(new MyInfoView(cov));						
						revalidate();
						repaint();
					} else {
						JOptionPane.showMessageDialog(cov, "이미 주문하신 차량이 있습니다. 출고 후 재주문 부탁드립니다.");
						cov.removeAll();
						cov.add(new MyInfoView(cov));						
						revalidate();
						repaint();
					}

				} catch (IllegalArgumentException e3) {

				}
			}
		});

		// 지역 선택 버튼 이벤트
		cityComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e1) {
				JComboBox cityComboBox = (JComboBox) e1.getSource();
				int index = cityComboBox.getSelectedIndex();
			
				switch (index) {
				case 0:
					city = select1[0];
					region = select[0];
					seoulComboBox.setVisible(true);
					seoulComboBox.setSelectedItem(select1[index]);
					
					break;

				case 1:
					city = select2[0];
					region = select[1];

					seoulComboBox.setVisible(false);
					gyeonggiComboBox.setVisible(true);
					gyeonggiComboBox.setSelectedItem(select2[0]);

					break;

				case 2:
					city = select3[0];
					region = select[2];

					seoulComboBox.setVisible(false);
					gyeonggiComboBox.setVisible(false);
					gyeongnamComboBox.setVisible(true);
					gyeongnamComboBox.setSelectedItem(select3[0]);

					break;

				case 3:
					city = select4[0];
					region = select[3];
					seoulComboBox.setVisible(false);
					gyeonggiComboBox.setVisible(false);
					gyeongnamComboBox.setVisible(false);
					busanComboBox.setVisible(true);
					busanComboBox.setSelectedItem(select4[0]);

					break;

				}
			}
		});

		// 도시 선택 버튼 이벤트
		gyeonggiComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				int selCity = cb.getSelectedIndex();

				switch (selCity) {
				case 0:
					city = "가평군";
					break;
				case 1:
					city = "고양시";
					break;
				case 2:
					city = "과천시";
					break;
				case 3:
					city = "광명시";
					break;
				case 4:
					city = "광주시";
					break;
				}
			}
		});

		gyeongnamComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				int selCity = cb.getSelectedIndex();
				switch (selCity) {
				case 0:
					city = "거제시";
					break;
				case 1:
					city = "창원시";
					break;
				case 2:
					city = "마산시";
					break;
				case 3:
					city = "밀양시";
					break;
				case 4:
					city = "통영시";
					break;
				}
			}
		});

		seoulComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				monthJLabel.setVisible(true);
				JComboBox YComboBox = (JComboBox) e.getSource();
				int index1 = YComboBox.getSelectedIndex();
				monthJLabel.setText(ym[index1]);
				if (index1 == 0) {
					LocalMonth = "";
					city = select1[0];
					LocalMonth = ym[0];
				}
			}
		});

		gyeonggiComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				monthJLabel.setVisible(true);
				JComboBox YComboBox = (JComboBox) e.getSource();
				int index2 = YComboBox.getSelectedIndex();
				monthJLabel.setText(ym1[index2]);
				if (index2 == 0) {
					LocalMonth = "";
					city = select1[0];
					LocalMonth = ym1[0];
				} else if (index2 == 1) {
					LocalMonth = "";
					city = select1[0];
					LocalMonth = ym1[1];
				} else if (index2 == 2) {
					LocalMonth = "";
					city = select1[0];
					LocalMonth = ym1[2];
				} else if (index2 == 3) {
					LocalMonth = "";
					city = select1[0];
					LocalMonth = ym1[3];
				} else if (index2 == 4) {
					LocalMonth = "";
					city = select1[0];
					LocalMonth = ym1[4];
				} else if (index2 == 5) {
					LocalMonth = "";
					city = select1[0];
					LocalMonth = ym1[5];
				}
			}
		});

		gyeongnamComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				monthJLabel.setVisible(true);
				JComboBox YComboBox = (JComboBox) e.getSource();
				int index3 = YComboBox.getSelectedIndex();
				monthJLabel.setText(ym2[index3]);
				if (index3 == 0) {
					LocalMonth = "";
					city = select2[0];
					LocalMonth = ym2[0];
				} else if (index3 == 1) {
					LocalMonth = "";
					city = select2[0];
					LocalMonth = ym2[1];
				} else if (index3 == 2) {
					LocalMonth = "";
					city = select2[0];
					LocalMonth = ym2[2];
				} else if (index3 == 3) {
					LocalMonth = "";
					city = select2[0];
					LocalMonth = ym2[3];
				} else if (index3 == 4) {
					LocalMonth = "";
					city = select2[0];
					LocalMonth = ym2[4];
				} else if (index3 == 5) {
					LocalMonth = "";
					city = select2[0];
					LocalMonth = ym2[5];
				}
			}
		});

		busanComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				monthJLabel.setVisible(true);
				JComboBox YComboBox = (JComboBox) e.getSource();
				int index4 = YComboBox.getSelectedIndex();
				monthJLabel.setText(ym3[index4]);

				if (index4 == 0) {
					LocalMonth = "";
					city = select3[0];
					LocalMonth = ym3[0];
				}
			}
		});

	}
}