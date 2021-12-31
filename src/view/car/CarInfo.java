package view.car;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CarInfo extends JPanel implements ActionListener {

	private JFrame frame;
	private JPanel cvp;
	private JPanel cov;

	public CarInfo(JPanel startPanel) {
		this.cvp = cvp;
		cov = this;

		setSize(900, 600);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 820, 580);
		panel.setLayout(null);
		cov.add(panel);

		JLabel lblNewLabel_1 = new JLabel("트림 / 가격");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(34, 10, 81, 25);
		panel.add(lblNewLabel_1);

		JButton lblNewLabel = new JButton("스마트");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(35, 81, 80, 40);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		panel.add(lblNewLabel);

		lblNewLabel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CarInfoWindow01 car01 = new CarInfoWindow01();
				car01.setVisible(true);

			}
		});

		JLabel lblNewLabel_1_1 = new JLabel("기본품목");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(155, 10, 81, 25);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2 = new JLabel("파워트레인 / 성능");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2.setBounds(166, 48, 113, 15);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3_3_1 = new JLabel("스마트스트림 가솔린 1.0엔진,");
		lblNewLabel_3_3_1.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_3_3_1.setBounds(166, 73, 167, 15);
		panel.add(lblNewLabel_3_3_1);

		JLabel lblNewLabel_3_1_2_1 = new JLabel("4단 자동변속기,");
		lblNewLabel_3_1_2_1.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_3_1_2_1.setBounds(317, 73, 81, 15);
		panel.add(lblNewLabel_3_1_2_1);

		JLabel lblNewLabel_3_1_1 = new JLabel("풋파킹 브레이크");
		lblNewLabel_3_1_1.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_3_1_1.setBounds(399, 73, 81, 15);
		panel.add(lblNewLabel_3_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("외관");
		lblNewLabel_2_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(166, 98, 38, 15);
		panel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_3_2 = new JLabel("메탈페인트 라디에이터 그릴,");
		lblNewLabel_3_2.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_3_2.setBounds(166, 123, 167, 15);
		panel.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_2_1 = new JLabel("LED주간주행등,");
		lblNewLabel_3_2_1.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_3_2_1.setBounds(313, 123, 103, 15);
		panel.add(lblNewLabel_3_2_1);

		JLabel lblNewLabel_3_2_1_1 = new JLabel("바디컬러 아웃사이드 미러");
		lblNewLabel_3_2_1_1.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_3_2_1_1.setBounds(396, 123, 167, 15);
		panel.add(lblNewLabel_3_2_1_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("안전");
		lblNewLabel_2_1_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2_1_1.setBounds(166, 148, 113, 15);
		panel.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_3_2_2 = new JLabel("타이어 응급처치 키트,");
		lblNewLabel_3_2_2.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_3_2_2.setBounds(166, 173, 167, 15);
		panel.add(lblNewLabel_3_2_2);

		JLabel lblNewLabel_3_2_2_1 = new JLabel("세이프티 언락,");
		lblNewLabel_3_2_2_1.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_3_2_2_1.setBounds(278, 173, 81, 15);
		panel.add(lblNewLabel_3_2_2_1);

		JLabel lblNewLabel_3_2_2_1_1 = new JLabel("후석 승객 알림");
		lblNewLabel_3_2_2_1_1.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_3_2_2_1_1.setBounds(355, 173, 167, 15);
		panel.add(lblNewLabel_3_2_2_1_1);

		JButton lblNewLabel_4 = new JButton("모던");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_4.setBounds(35, 256, 80, 40);
		lblNewLabel_4.setBackground(new Color(255, 255, 255));
		panel.add(lblNewLabel_4);

		lblNewLabel_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CarInfoWindow02 car02 = new CarInfoWindow02();
				car02.setVisible(true);
			}
		});

		JLabel lblNewLabel_2_2 = new JLabel("파워트레인 / 성능");
		lblNewLabel_2_2.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2_2.setBounds(166, 220, 113, 15);
		panel.add(lblNewLabel_2_2);

		JLabel lblNewLabel_3_3 = new JLabel("스마트스트림 가솔린 1.0엔진,");
		lblNewLabel_3_3.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_3_3.setBounds(166, 245, 167, 15);
		panel.add(lblNewLabel_3_3);

		JLabel lblNewLabel_3_1_2 = new JLabel("4단 자동변속기,");
		lblNewLabel_3_1_2.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_3_1_2.setBounds(317, 245, 81, 15);
		panel.add(lblNewLabel_3_1_2);

		JLabel lblNewLabel_3_1_1_1 = new JLabel("풋파킹 브레이크");
		lblNewLabel_3_1_1_1.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_3_1_1_1.setBounds(399, 245, 81, 15);
		panel.add(lblNewLabel_3_1_1_1);

		JLabel lblNewLabel_2_1_2 = new JLabel("외관");
		lblNewLabel_2_1_2.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2_1_2.setBounds(166, 269, 113, 15);
		panel.add(lblNewLabel_2_1_2);

		JLabel lblNewLabel_3_2_3 = new JLabel("메탈페인트 라디에이터 그릴,");
		lblNewLabel_3_2_3.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_3_2_3.setBounds(166, 292, 167, 15);
		panel.add(lblNewLabel_3_2_3);

		JLabel lblNewLabel_3_2_1_2 = new JLabel("LED주간주행등,");
		lblNewLabel_3_2_1_2.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_3_2_1_2.setBounds(313, 292, 167, 15);
		panel.add(lblNewLabel_3_2_1_2);

		JLabel lblNewLabel_3_2_1_1_1 = new JLabel("메탈페인트 스키드 플레이");
		lblNewLabel_3_2_1_1_1.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_3_2_1_1_1.setBounds(396, 292, 167, 15);
		panel.add(lblNewLabel_3_2_1_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("안전");
		lblNewLabel_2_1_1_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2_1_1_1.setBounds(166, 314, 113, 15);
		panel.add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_3_2_2_2 = new JLabel("타이어 응급처치 키트,");
		lblNewLabel_3_2_2_2.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_3_2_2_2.setBounds(166, 335, 167, 15);
		panel.add(lblNewLabel_3_2_2_2);

		JLabel lblNewLabel_3_2_2_1_2 = new JLabel("세이프티 언락,");
		lblNewLabel_3_2_2_1_2.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_3_2_2_1_2.setBounds(278, 335, 81, 15);
		panel.add(lblNewLabel_3_2_2_1_2);

		JLabel lblNewLabel_3_2_2_1_1_1 = new JLabel("후석 승객 알림");
		lblNewLabel_3_2_2_1_1_1.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_3_2_2_1_1_1.setBounds(355, 335, 167, 15);
		panel.add(lblNewLabel_3_2_2_1_1_1);

		JButton lblNewLabel_5 = new JButton("인스퍼레이션");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_5.setBounds(7, 420, 130, 40);
		lblNewLabel_5.setBackground(new Color(255, 255, 255));
		panel.add(lblNewLabel_5);

		lblNewLabel_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CarInfoWindow03 car03 = new CarInfoWindow03();
				car03.setVisible(true);
			}
		});

		JLabel lblNewLabel_2_3 = new JLabel("파워트레인 / 성능");
		lblNewLabel_2_3.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2_3.setBounds(166, 386, 113, 15);
		panel.add(lblNewLabel_2_3);

		JLabel lblNewLabel_3_4 = new JLabel("스마트스트림 가솔린 1.0엔진,");
		lblNewLabel_3_4.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_3_4.setBounds(166, 411, 167, 15);
		panel.add(lblNewLabel_3_4);

		JLabel lblNewLabel_3_1_3 = new JLabel("4단 자동변속기,");
		lblNewLabel_3_1_3.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_3_1_3.setBounds(317, 411, 81, 15);
		panel.add(lblNewLabel_3_1_3);

		JLabel lblNewLabel_3_1_1_2 = new JLabel("풋파킹 브레이크");
		lblNewLabel_3_1_1_2.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_3_1_1_2.setBounds(399, 411, 81, 15);
		panel.add(lblNewLabel_3_1_1_2);

		JLabel lblNewLabel_2_1_3 = new JLabel("외관");
		lblNewLabel_2_1_3.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2_1_3.setBounds(166, 435, 113, 15);
		panel.add(lblNewLabel_2_1_3);

		JLabel lblNewLabel_3_2_4 = new JLabel("메탈페인트 라디에이터 그릴,");
		lblNewLabel_3_2_4.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_3_2_4.setBounds(166, 458, 167, 15);
		panel.add(lblNewLabel_3_2_4);

		JLabel lblNewLabel_3_2_1_3 = new JLabel("LED주간주행등,");
		lblNewLabel_3_2_1_3.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_3_2_1_3.setBounds(313, 458, 90, 15);
		panel.add(lblNewLabel_3_2_1_3);

		JLabel lblNewLabel_3_2_1_1_2 = new JLabel("프로젝션 헤드램프");
		lblNewLabel_3_2_1_1_2.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_3_2_1_1_2.setBounds(395, 458, 167, 15);
		panel.add(lblNewLabel_3_2_1_1_2);

		JLabel lblNewLabel_2_1_1_2 = new JLabel("안전");
		lblNewLabel_2_1_1_2.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2_1_1_2.setBounds(166, 480, 113, 15);
		panel.add(lblNewLabel_2_1_1_2);

		JLabel lblNewLabel_3_2_2_3 = new JLabel("타이어 응급처치 키트,");
		lblNewLabel_3_2_2_3.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_3_2_2_3.setBounds(166, 501, 167, 15);
		panel.add(lblNewLabel_3_2_2_3);

		JLabel lblNewLabel_3_2_2_1_3 = new JLabel("세이프티 언락,");
		lblNewLabel_3_2_2_1_3.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_3_2_2_1_3.setBounds(278, 501, 81, 15);
		panel.add(lblNewLabel_3_2_2_1_3);

		JLabel lblNewLabel_3_2_2_1_1_2 = new JLabel("후석 승객 알림,");
		lblNewLabel_3_2_2_1_1_2.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_3_2_2_1_1_2.setBounds(355, 501, 81, 15);
		panel.add(lblNewLabel_3_2_2_1_1_2);

		JLabel lblNewLabel_3_2_1_1_2_1 = new JLabel("유아용 시트 고정장치");
		lblNewLabel_3_2_1_1_2_1.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_3_2_1_1_2_1.setBounds(434, 501, 167, 15);
		panel.add(lblNewLabel_3_2_1_1_2_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("선택품목");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(549, 10, 81, 25);
		panel.add(lblNewLabel_1_1_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(560, 45, 219, 4);
		panel.add(panel_2);

		JLabel lblNewLabel_3_5 = new JLabel("선루프                   400,000원");
		lblNewLabel_3_5.setForeground(new Color(106, 90, 205));
		lblNewLabel_3_5.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_3_5.setBounds(580, 90, 198, 15);
		panel.add(lblNewLabel_3_5);

		JLabel lblNewLabel_3_5_1 = new JLabel("캐스퍼 액티브 I       950,000원");
		lblNewLabel_3_5_1.setForeground(new Color(106, 90, 205));
		lblNewLabel_3_5_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_3_5_1.setBounds(580, 65, 198, 15);
		panel.add(lblNewLabel_3_5_1);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.BLACK);
		panel_2_1.setBounds(560, 174, 219, 4);
		panel.add(panel_2_1);

		JLabel lblNewLabel_3_5_2 = new JLabel("선루프                   400,000원");
		lblNewLabel_3_5_2.setForeground(new Color(106, 90, 205));
		lblNewLabel_3_5_2.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_3_5_2.setBounds(580, 245, 198, 15);
		panel.add(lblNewLabel_3_5_2);

		JLabel lblNewLabel_3_5_1_2 = new JLabel("캐스퍼 액티브 I       950,000원");
		lblNewLabel_3_5_1_2.setForeground(new Color(106, 90, 205));
		lblNewLabel_3_5_1_2.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_3_5_1_2.setBounds(580, 193, 198, 15);
		panel.add(lblNewLabel_3_5_1_2);

		JLabel lblNewLabel_3_5_1_2_1 = new JLabel("SBC 스마트센스 I    700,000원");
		lblNewLabel_3_5_1_2_1.setForeground(new Color(106, 90, 205));
		lblNewLabel_3_5_1_2_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_3_5_1_2_1.setBounds(580, 302, 198, 15);
		panel.add(lblNewLabel_3_5_1_2_1);

		JLabel lblNewLabel_3_5_1_2_1_1 = new JLabel("스토리지                  70,000원");
		lblNewLabel_3_5_1_2_1_1.setForeground(new Color(106, 90, 205));
		lblNewLabel_3_5_1_2_1_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_3_5_1_2_1_1.setBounds(580, 330, 198, 15);
		panel.add(lblNewLabel_3_5_1_2_1_1);

		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBackground(Color.BLACK);
		panel_2_2.setBounds(560, 390, 219, 4);
		panel.add(panel_2_2);

		JLabel lblNewLabel_3_5_2_1 = new JLabel("선루프                   400,000원");
		lblNewLabel_3_5_2_1.setForeground(new Color(106, 90, 205));
		lblNewLabel_3_5_2_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_3_5_2_1.setBounds(580, 411, 198, 15);
		panel.add(lblNewLabel_3_5_2_1);

		JLabel lblNewLabel_3_5_2_1_1 = new JLabel("스토리지                  70,000원");
		lblNewLabel_3_5_2_1_1.setForeground(new Color(106, 90, 205));
		lblNewLabel_3_5_2_1_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_3_5_2_1_1.setBounds(580, 500, 198, 15);
		panel.add(lblNewLabel_3_5_2_1_1);

		JLabel lblNewLabel_3_5_1_2_1_2 = new JLabel("17인치 아로이 휠    550,000원");
		lblNewLabel_3_5_1_2_1_2.setForeground(new Color(106, 90, 205));
		lblNewLabel_3_5_1_2_1_2.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_3_5_1_2_1_2.setBounds(580, 220, 198, 15);
		panel.add(lblNewLabel_3_5_1_2_1_2);

		JLabel lblNewLabel_3_5_1_2_1_3 = new JLabel("멀티미디어 내비    1,430,000원");
		lblNewLabel_3_5_1_2_1_3.setForeground(new Color(106, 90, 205));
		lblNewLabel_3_5_1_2_1_3.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_3_5_1_2_1_3.setBounds(580, 273, 198, 15);
		panel.add(lblNewLabel_3_5_1_2_1_3);

		JLabel lblNewLabel_3_5_1_2_1_4 = new JLabel("SBC 스마트센스 II    900,000원");
		lblNewLabel_3_5_1_2_1_4.setForeground(new Color(106, 90, 205));
		lblNewLabel_3_5_1_2_1_4.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_3_5_1_2_1_4.setBounds(580, 470, 198, 15);
		panel.add(lblNewLabel_3_5_1_2_1_4);

		JLabel lblNewLabel_3_5_1_2_1_3_1 = new JLabel("멀티미디어 내비    1,430,000원");
		lblNewLabel_3_5_1_2_1_3_1.setForeground(new Color(106, 90, 205));
		lblNewLabel_3_5_1_2_1_3_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_3_5_1_2_1_3_1.setBounds(580, 440, 198, 15);
		panel.add(lblNewLabel_3_5_1_2_1_3_1);

		JLabel lblNewLabel_3_5_1_2_1_3_2 = new JLabel("멀티미디어 내비    1,430,000원");
		lblNewLabel_3_5_1_2_1_3_2.setForeground(new Color(106, 90, 205));
		lblNewLabel_3_5_1_2_1_3_2.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_3_5_1_2_1_3_2.setBounds(580, 117, 198, 15);
		panel.add(lblNewLabel_3_5_1_2_1_3_2);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("선택품목");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(549, 140, 81, 25);
		panel.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("선택품목");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1.setBounds(549, 355, 81, 25);
		panel.add(lblNewLabel_1_1_1_1_1);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
