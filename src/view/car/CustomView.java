package view.car;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import controller.car.CustomController;
import controller.member.MemberToken;
import model.car.CarOption.OPTION;
import model.car.CarOption.OUTCOLOR;
import model.car.CarOption.SORT;
import view.Home;
import view.member.MyInfoView;
import view.member.MySaveView;

import javax.swing.Icon;

public class CustomView extends JPanel {

	private JFrame frame;
	JPanel cvp;
	JPanel startPanel;
	public ArrayList orderList;// 자동차 정보 리스트
	SORT sort;// 자동차 종료
	OPTION option;// 자동차 옵션
	OUTCOLOR outColor;// 자동차 외관 색
	int allPrice;// 최종가격
	int sortPrice;// 기본 자동차 가격

	public CustomView(JPanel startPanel) {
		this.startPanel = startPanel;
		cvp = this;
		sortPrice = SORT.MODERN.getSortPrice();

		setBackground(Color.WHITE);
		setSize(900, 600);
		setLayout(null);

		// 초이스 패널
		JPanel choicePanel1 = new JPanel();
		choicePanel1.setBackground(Color.WHITE);
		choicePanel1.setBounds(35, 23, 374, 563);
		this.add(choicePanel1);
		choicePanel1.setLayout(null);

		// 트림 종류 선택
		JLabel choLa1 = new JLabel("트림");
		choLa1.setHorizontalAlignment(SwingConstants.CENTER);
		choLa1.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 24));
		choLa1.setBounds(0, 10, 48, 28);
		choicePanel1.add(choLa1);

		JButton sortBtn1 = new JButton("");
		sortBtn1.setBackground(Color.WHITE);
		sortBtn1.setText("<HTML><body style='text-align:center;'>스마트<br>1385 만원</HTML>");
		sortBtn1.setBounds(2, 65, 114, 39);
		choicePanel1.add(sortBtn1);

		JButton sortBtn2 = new JButton();
		sortBtn2.setBackground(Color.WHITE);
		sortBtn2.setText("<HTML><body style='text-align:center;'>모던<br>1590 만원</HTML>");
		sortBtn2.setForeground(Color.BLACK);
		sortBtn2.setBounds(115, 65, 114, 39);
		choicePanel1.add(sortBtn2);

		JButton sortBtn3 = new JButton("");
		sortBtn3.setBackground(Color.WHITE);
		sortBtn3.setText("<HTML><body style='text-align:center;'>인스퍼레이션<br>1870 만원</HTML>");
		sortBtn3.setForeground(Color.BLACK);
		sortBtn3.setBounds(228, 65, 114, 39);
		choicePanel1.add(sortBtn3);

		// 외관 종류 선택
		JLabel choLa2 = new JLabel("외관");
		choLa2.setHorizontalAlignment(SwingConstants.CENTER);
		choLa2.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 24));
		choLa2.setBounds(0, 145, 48, 28);
		choicePanel1.add(choLa2);

		JButton colorBtn1 = new JButton("IVORY");
		colorBtn1.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 15));
		colorBtn1.setBackground(new Color(228, 227, 222));
		colorBtn1.setForeground(Color.BLACK);
		colorBtn1.setBounds(2, 195, 114, 39);
		choicePanel1.add(colorBtn1);

		JButton colorBtn2 = new JButton("ORANGE");
		colorBtn2.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 15));
		colorBtn2.setBackground(new Color(176, 5, 21));
		colorBtn2.setForeground(Color.LIGHT_GRAY);
		colorBtn2.setBounds(115, 195, 114, 39);
		choicePanel1.add(colorBtn2);

		JButton colorBtn3 = new JButton("KHAKII");
		colorBtn3.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 15));
		colorBtn3.setBackground(new Color(52, 55, 46));
		colorBtn3.setForeground(Color.LIGHT_GRAY);
		colorBtn3.setBounds(228, 195, 114, 39);
		choicePanel1.add(colorBtn3);

		// 추가 옵션 선택
		JLabel choLa3 = new JLabel("선택품목");
		choLa3.setHorizontalAlignment(SwingConstants.CENTER);
		choLa3.setFont(new Font("나눔스퀘어OTF Bold", Font.PLAIN, 24));
		choLa3.setBounds(0, 270, 96, 28);
		choicePanel1.add(choLa3);

		ButtonGroup bg = new ButtonGroup();
		JButton optBtn1 = new JButton("STORAGE", new ImageIcon("images/storage.png"));
		optBtn1.setHorizontalTextPosition(JButton.CENTER);
		optBtn1.setForeground(Color.WHITE);
		optBtn1.setToolTipText(
				"<HTML><body style='text-align:center;'><h1>스토리지<br>동승석 시트백 보드 & 러기지 볼팅<br>40 만원<h1></HTML>");
		optBtn1.setBounds(213, 490, 130, 23);
		choicePanel1.add(optBtn1);

		JButton optBtn2 = new JButton("SMARTSENSOR", new ImageIcon("images/sensor.png"));

		optBtn2.setHorizontalTextPosition(JButton.CENTER);
		optBtn2.setForeground(Color.WHITE);
		optBtn2.setToolTipText(
				"<HTML><body style='text-align:center;'><h1>스마트센서<br>전방 충돌 방지 <br> 후측방 충돌방지 보조<br>안전하차경고 <br> 스마트 크루즈 컨트롤<br>70 만원<h1></HTML>");

		optBtn2.setBounds(213, 455, 130, 23);
		choicePanel1.add(optBtn2);

		JButton optBtn3 = new JButton("WHEELPK", new ImageIcon("images/wheel.png"));
		optBtn3.setHorizontalTextPosition(JButton.CENTER);
		optBtn3.setForeground(Color.WHITE);
		optBtn3.setToolTipText(
				"<HTML><body style='text-align:center;'><h1>휠패키지 17인치 <br>알로이 휠<br>타이어<br>후륜 디스크 브레이크<br>55만원<br></p><h1></body></HTML>");

		optBtn3.setBounds(213, 350, 130, 23);
		choicePanel1.add(optBtn3);

		JButton optBtn4 = new JButton("NAVI", new ImageIcon("images/navi.png"));
		optBtn4.setForeground(Color.WHITE);
		optBtn4.setHorizontalTextPosition(JButton.CENTER);
		optBtn4.setBackground(new Color(52, 55, 46));
		optBtn4.setToolTipText(
				"<HTML><body style='text-align:center;'><h1>네비<br>하이패스 & 룸미러<br>후방모니터<br>152만원<h1></HTML>");
		optBtn4.setBounds(213, 420, 130, 23);
		choicePanel1.add(optBtn4);

		JButton optBtn5 = new JButton("SUNROOF", new ImageIcon("images/sunroof.png"));
		optBtn5.setHorizontalTextPosition(JButton.CENTER);
		optBtn5.setForeground(Color.BLACK);
		optBtn5.setBackground(Color.WHITE);
		optBtn5.setToolTipText("<HTML><body style='text-align:center;'><h1>선루프<br>A필라 블랙 테이프<br>40 만원<h1></HTML>");
		optBtn5.setBounds(213, 385, 130, 23);
		choicePanel1.add(optBtn5);

		JButton optBtn6 = new JButton("TURBO", new ImageIcon("images/turbo.png"));
		optBtn6.setHorizontalTextPosition(JButton.CENTER);
		optBtn6.setForeground(Color.WHITE);
		optBtn6.setToolTipText(
				"<HTML><body style='text-align:center;'><h1>액티브<br>터보 외장 패키지<br>터보엔진 디스크<br>브레이크<br>95 만원<h1></HTML>");
		optBtn6.setBounds(213, 315, 130, 23);
		choicePanel1.add(optBtn6);

		JCheckBox turboCk = new JCheckBox("turbo");
		turboCk.setBackground(Color.WHITE);
		turboCk.setBounds(0, 315, 125, 23);
		choicePanel1.add(turboCk);

		JCheckBox sunroofCk = new JCheckBox("sunroof");
		sunroofCk.setBackground(Color.WHITE);
		sunroofCk.setBounds(0, 385, 125, 23);
		choicePanel1.add(sunroofCk);

		JCheckBox naviCk = new JCheckBox("navi");
		naviCk.setBackground(Color.WHITE);
		naviCk.setBounds(0, 420, 125, 23);
		choicePanel1.add(naviCk);

		JCheckBox storageCk = new JCheckBox("storage");
		storageCk.setBackground(Color.WHITE);
		storageCk.setBounds(0, 490, 125, 23);
		choicePanel1.add(storageCk);

		JCheckBox sensorCk = new JCheckBox("sensor");
		sensorCk.setBackground(Color.WHITE);
		sensorCk.setBounds(0, 455, 125, 23);
		choicePanel1.add(sensorCk);

		JCheckBox wheelCk = new JCheckBox("wheel");
		wheelCk.setBackground(Color.WHITE);
		wheelCk.setBounds(0, 350, 125, 23);
		choicePanel1.add(wheelCk);
		this.add(choicePanel1);

		JLabel carLabel = new JLabel();
		carLabel.setBounds(420, 8, 343, 264);
		add(carLabel);

		// 자동차 사진 시작
		String imgPath = "Images/casper.jpg";
		ImageIcon originIcon = new ImageIcon(imgPath);
		Image originImg = originIcon.getImage();
		Image ChangedImg = originImg.getScaledInstance(350, 220, Image.SCALE_SMOOTH);
		ImageIcon Icon = new ImageIcon(ChangedImg);
		carLabel.setIcon(Icon);

		JLabel imgLavel = new JLabel((Icon) null);
		imgLavel.setBounds(420, 25, 343, 245);
		add(imgLavel);

		JLabel choiceListLabel = new JLabel();
		choiceListLabel.setBounds(424, 300, 343, 257);
		add(choiceListLabel);

		JLabel trimLa = new JLabel("트림 :");
		trimLa.setHorizontalAlignment(SwingConstants.CENTER);
		trimLa.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));
		trimLa.setBounds(408, 262, 65, 32);
		add(trimLa);

		JLabel trimLabel = new JLabel();
		trimLabel.setText("모던");
		trimLabel.setHorizontalAlignment(SwingConstants.CENTER);
		trimLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));
		trimLabel.setBounds(558, 260, 118, 32);
		add(trimLabel);

		JLabel colorLa = new JLabel("색상 :");
		colorLa.setHorizontalAlignment(SwingConstants.CENTER);
		colorLa.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));
		colorLa.setBounds(408, 300, 65, 32);
		add(colorLa);

		JLabel outerLabel = new JLabel();
		outerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		outerLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));
		outerLabel.setText("IVORY");
		outerLabel.setBounds(554, 303, 128, 32);
		add(outerLabel);

		JLabel optLa = new JLabel("선택품목 :");
		optLa.setHorizontalAlignment(SwingConstants.CENTER);
		optLa.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));
		optLa.setBounds(408, 340, 99, 32);
		add(optLa);

		JButton orderListBtn = new JButton("견적내기");
		orderListBtn.setBackground(Color.WHITE);
		orderListBtn.setBounds(410, 520, 110, 30);
		add(orderListBtn);

		JTextArea orderArea = new JTextArea();
		orderArea.setColumns(10);
		orderArea.setBounds(555, 345, 250, 140);
		add(orderArea);

		JButton orderBtn = new JButton("주문하기");
		orderBtn.setBackground(Color.WHITE);
		orderBtn.setBounds(650, 520, 110, 30);
		add(orderBtn);

		JButton orderSaveBtn = new JButton("견적저장");
		orderSaveBtn.setBackground(Color.WHITE);
		orderSaveBtn.setBounds(530, 520, 110, 30);
		add(orderSaveBtn);

		JTextArea orderArea_1 = new JTextArea();
		orderArea_1.setColumns(10);
		orderArea_1.setBounds(425, 492, 550, 26);
		orderArea_1.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));
		add(orderArea_1);

		CustomController cc = new CustomController();
		// ----------------------------------------------------------------

		// 견적내기 버튼 클릭시 이벤트
		orderListBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				orderList = new ArrayList();
				ArrayList<String> optionList = new ArrayList();// 옵션+가격

				if (!(orderArea.getText().equals("") || orderArea.getText() == null)) {
					orderArea.setText("");
					orderList.clear();
					allPrice = 0;
				}

				if (turboCk.isSelected()) {
					optionList.add(turboCk.getText() + "\t    " + " "+OPTION.TURBO.getOptPrice() + " 만원");
					allPrice += OPTION.TURBO.getOptPrice();
				}
				if (sunroofCk.isSelected()) {
					optionList.add(sunroofCk.getText() + "\t    " + " "+OPTION.SUNROOF.getOptPrice() + " 만원");
					allPrice += OPTION.SUNROOF.getOptPrice();
				}
				if (naviCk.isSelected()) {
					optionList.add(naviCk.getText() + "\t   " + OPTION.NAVI.getOptPrice() + " 만원");
					allPrice += OPTION.NAVI.getOptPrice();
				}
				if (storageCk.isSelected()) {
					optionList.add(storageCk.getText() + "\t    " + " "+OPTION.STORAGE.getOptPrice() + " 만원");
					allPrice += OPTION.STORAGE.getOptPrice();
				}
				if (sensorCk.isSelected()) {
					optionList.add(sensorCk.getText() + "\t    " + " "+OPTION.SMARTSENSOR.getOptPrice() + " 만원");
					allPrice += OPTION.SMARTSENSOR.getOptPrice();
				}
				if (wheelCk.isSelected()) {
					optionList.add(wheelCk.getText() + "\t    " + " "+OPTION.WHEELPK.getOptPrice() + " 만원");
					allPrice += OPTION.WHEELPK.getOptPrice();
				}

				allPrice += sortPrice;// 총 가격
				String imgpath = outerLabel.getText().toLowerCase();

				orderList.add(trimLabel.getText());// 0번째 차종류
				orderList.add(outerLabel.getText());// 1번째 차 색
				orderList.add(optionList);// 2번째 옵션 + 가격
				orderList.add(allPrice);// 3번째 총 가격
				// orderList.add(options);// 4번째 옵션 리스트
				orderArea.append(trimLabel.getText() + "\t" + sortPrice + " 만원\n");
				orderArea.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 17));

				for (String s : optionList) {
					orderArea.append(s + "\n");
				}
				orderArea_1.append("총 가격 : " + "\t" + "                        " + allPrice + "만원                                  ");			
			}
		});

		// 견적 저장 버튼 클릭 이벤트
		orderSaveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
//					MemberToken.tokenID = "soldesk";
					System.out.println("현재 접속자: 커스텀뷰" + MemberToken.tokenID);
					cc.inputCar(orderList, MemberToken.tokenID);// 견적저장메소드

					if (MemberToken.tokenID != null) {
						JOptionPane.showMessageDialog(cvp, "견적이 저장 되었습니다.");						
						
							int result = JOptionPane.showConfirmDialog(null, "마이페이지로 이동하시겠습니까?", "Message", JOptionPane.YES_NO_OPTION);
							if (result == JOptionPane.YES_OPTION) {								
								cvp.removeAll();
								cvp.add(new MySaveView(cvp));
								revalidate();
								repaint();
							}

						
						}
				} catch (NullPointerException e2) {
					// e2.printStackTrace();
					JOptionPane.showMessageDialog(cvp, "견적을 먼저 내주세요.");
					System.out.println("견적을 내주세요. ");
					
				}
			}
		});

		// 주문하기 버튼 클릭시 이벤트
		orderBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (MemberToken.tokenID == null) {
					JOptionPane.showMessageDialog(cvp, "로그인을 먼저 해주세요.");
				} else {
					if (orderList == null) {
						JOptionPane.showMessageDialog(cvp, "견적을 먼저 내주세요.");
					} else {
						System.out.println("현재 접속자: 커스텀뷰" + MemberToken.tokenID);
						cvp.removeAll();
						cvp.add(new CarOrderView(cvp, orderList, MemberToken.tokenID));
						revalidate();
						repaint();
					}
				}
			}
		});

		// 기본 선택 옵션 출력 이벤트
		sortBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				trimLabel.setText(SORT.SMART.getSort());
				sortPrice = SORT.SMART.getSortPrice();
				cvp.add(trimLabel);

				// 기본 선택 3개만 체크 가능 이벤트
				if (storageCk.isSelected())
					storageCk.setSelected(false);

				if (sensorCk.isSelected())
					sensorCk.setSelected(false);

				if (wheelCk.isSelected())
					wheelCk.setSelected(false);

				storageCk.setEnabled(false);
				sensorCk.setEnabled(false);
				wheelCk.setEnabled(false);
				turboCk.setEnabled(true);
				sunroofCk.setEnabled(true);
				naviCk.setEnabled(true);

			}
		});

		sortBtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				trimLabel.setText(SORT.MODERN.getSort());
				sortPrice = SORT.MODERN.getSortPrice();
				cvp.add(trimLabel);

				storageCk.setEnabled(true);
				sensorCk.setEnabled(true);
				wheelCk.setEnabled(true);
				turboCk.setEnabled(true);
				sunroofCk.setEnabled(true);
				naviCk.setEnabled(true);

			}
		});

		sortBtn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				trimLabel.setText(SORT.INSPIRATION.getSort());
				sortPrice = SORT.INSPIRATION.getSortPrice();
				cvp.add(trimLabel);

				if (storageCk.isSelected())
					storageCk.setSelected(false);

				if (turboCk.isSelected())
					turboCk.setSelected(false);

				if (wheelCk.isSelected())
					wheelCk.setSelected(false);

				storageCk.setEnabled(true);
				sensorCk.setEnabled(true);
				naviCk.setEnabled(true);
				sunroofCk.setEnabled(true);
				turboCk.setEnabled(false);
				wheelCk.setEnabled(false);
			}
		});

		// 버튼 클릭 시 자동차 사진 변경 이벤트
		colorBtn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ImageIcon carImg = new ImageIcon("Images/ivory1.png");
				Image originImg = carImg.getImage();
				Image changedImg = originImg.getScaledInstance(350, 220, Image.SCALE_SMOOTH);
				carImg = new ImageIcon(changedImg);
				carLabel.setIcon(carImg);

				cvp.repaint();

				// 외관 선택 옵션 출력
				String color = colorBtn1.getText();
				outerLabel.setText(color);
				cvp.add(outerLabel);
			}
		});

		colorBtn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ImageIcon carImg = new ImageIcon("Images/orange1.png");
				Image originImg = carImg.getImage();
				Image changedImg = originImg.getScaledInstance(350, 220, Image.SCALE_SMOOTH);
				carImg = new ImageIcon(changedImg);
				carLabel.setIcon(carImg);

				cvp.repaint();

				// 외관 선택 옵션 출력
				String color = colorBtn2.getText();
				outerLabel.setText(color);
				cvp.add(outerLabel);
			}
		});

		colorBtn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ImageIcon carImg = new ImageIcon("Images/khakii1.png");
				Image originImg = carImg.getImage();
				Image changedImg = originImg.getScaledInstance(350, 220, Image.SCALE_SMOOTH);
				carImg = new ImageIcon(changedImg);
				carLabel.setIcon(carImg);

				cvp.repaint();

				// 외관 선택 옵션 출력
				String color = colorBtn3.getText();
				outerLabel.setText(color);
				cvp.add(outerLabel);
			}
		});

		setVisible(true);
	}
}
