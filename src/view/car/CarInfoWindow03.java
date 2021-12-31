package view.car;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CarInfoWindow03 {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarInfoWindow03 window = new CarInfoWindow03();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CarInfoWindow03() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("인스퍼레이션");
		frame.setBounds(735, 220, 700, 600);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255,255,255));
		panel.setBounds(0, 55, 684, 245);
		frame.getContentPane().add(panel);
		
		ImageIcon car = new ImageIcon("images/ivory1.png");
		Image originImg = car.getImage();
		Image changedImg = originImg.getScaledInstance(350, 220, Image.SCALE_SMOOTH);
		car = new ImageIcon(changedImg);
		JLabel img=new JLabel(car);
		panel.add(img);		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 0, 684, 57);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		Font font=new Font("맑은고딕", Font.PLAIN, 16);
		
		
		JLabel lblNewLabel_2 = new JLabel("인스퍼레이션");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblNewLabel_2.setBounds(12, 0, 660, 56);
		panel_2.add(lblNewLabel_2);
				
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 277, 684, 284);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);			
		  
		JLabel lblNewLabel0 = new JLabel("                          인스퍼레이션");
		lblNewLabel0.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel0.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel0.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel0.setBounds(12, 38, 660, 25);
		panel_1.add(lblNewLabel0);
		
		
		JLabel lblNewLabel = new JLabel("SBC 캐스퍼                              은 경형 SUV에 최고의 성능을 발휘하는 카파 1.0");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 40, 660, 25);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(font);
		
		JLabel lblNewLabel1 = new JLabel("스마트 터보엔진을 사용하여 21.8km/L의 연비로 효율적인 드라이빙을 즐기실 수 있습니다.");
		lblNewLabel1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setBounds(12, 105, 660, 25);
		panel_1.add(lblNewLabel1);
		lblNewLabel1.setFont(font);
		
		JLabel lblNewLabel2 = new JLabel("구조 설계 최적화와 연소 기술 강화, 신기술 적용 최적화, 부품 소형화 및 경량화 등을 통해");
		lblNewLabel2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2.setBounds(12, 170, 660, 25);
		panel_1.add(lblNewLabel2);
		lblNewLabel2.setFont(font);
		
		JLabel lblNewLabel3 = new JLabel("시스템이 자동으로 차량 간격 감소시 감속해주어 편안하고 안전한 드라이빙을 선사합니다.");
		lblNewLabel3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel3.setBounds(12, 235, 660, 25);
		panel_1.add(lblNewLabel3);
		lblNewLabel3.setFont(font);
		
		
		
	}

	public Component setVisible(boolean b) {
		CarInfoWindow03 window = new CarInfoWindow03();
		window.frame.setVisible(true);
		return null;
	}
}
