package view.member;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.member.Member;
import javax.swing.JTextArea;

import controller.car.CustomController;
import controller.member.MemberToken;

public class OrderedInfoView extends JPanel {

	private JFrame frame;
	private JPanel startPanel;
	JPanel orderPanel;

	public OrderedInfoView(JPanel startPanel) {

		this.startPanel = startPanel;
		orderPanel = this;

		setBackground(new Color(255, 242, 230));
		setSize(900, 600);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(94, 54, 493, 420);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("내 정보");
		lblNewLabel.setBounds(50, 5, 139, 85);
		panel.add(lblNewLabel);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(50, 153, 266, 221);
		panel.add(textArea);

		CustomController cc = new CustomController();
		textArea.append(cc.getCar(MemberToken.tokenID).toString());
		
		

	}
}
