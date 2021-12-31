/* SBS 1�� �� ������Ʈ
 * �Խ��� ��Ʈ - �󼼺��� ��â
 * �ۼ��� : �̰�ö
 * ���� ������ : 2021.12.28
 */

package board;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import design.RoundedButton;
import view.MainFrame;
import view.car.CustomView;

public class DetailWindow {

	JFrame frame;
	JPanel contentPane;

	NoticeDTO user;

	String num;
	int boardNum;
	String name;
	String title;
	String date;
	String everything;
	
	static String dirpath = "BoardDetail";	//�� ���� ������ ����ִ� ������

	public DetailWindow(NoticeDTO user) throws IOException {
		this.user = user;
		num = user.getNum(); //��Ϲ�ȣ
		name = user.getName();
		title = user.getTitle();
		date = user.getDate();

		// ����� �׽�Ʈ
		/*
		 * System.out.println("��ȣ ȣ�� : " + num); System.out.println("�̸� ȣ�� : " + name);
		 * System.out.println("���� ȣ�� : " + title); System.out.println("��¥ ȣ�� : " +
		 * date); System.out.println(everything);
		 */
		
		// �⺻ �� ����
		frame = new JFrame();
		frame.setTitle("��Ϲ�ȣ : " + num);
		frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		frame.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		Font font = new Font("����", Font.PLAIN, 13);
		Font fontButton = new Font("����", Font.PLAIN, 17);

		JLabel titleTextLbl = new JLabel(title);
		titleTextLbl.setFont(font);
		titleTextLbl.setBounds(84, 5, 325, 21);
		contentPane.add(titleTextLbl);

		// �ؽ�Ʈ ���� ��� -----------------------------------------------------

		JTextPane detailTextPane = new JTextPane();
		detailTextPane.setEditable(false);
		JScrollPane scrollArea = new JScrollPane(detailTextPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		// ��Ϲ�ȣ�� ��ġ�ϴ� �� ���� ���� �ҷ�����
		// ��Ϲ�ȣ�� ������ ���丮 �ȿ� �̸��� ��ġ�ϴ� ������ �ҷ��� ����� ���
		//System.out.println("��Ϲ�ȣ ��� ��� �Ұǰ���? :" + num);
		FileInputStream input = new FileInputStream(dirpath + "\\" + num + ".txt");
		InputStreamReader reader = new InputStreamReader(input, "UTF-8");
		BufferedReader br = new BufferedReader(reader);
		
		// ���� ������ ��� ĳ���� �ѱ��ڽ� ����� �ϱ� ������
		// �ش� ������ ��Ʈ�� ������ �ʵ忡 �ѷ��ֱ� ���� ��ȯ�ϴ� �ڵ�
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}

			everything = sb.toString();

		} finally {

			br.close();
		}

		detailTextPane.setText(everything);

		scrollArea.setBounds(12, 58, 410, 161);
		scrollArea.setFont(font);
		contentPane.add(scrollArea);

		// -------------------------------------------------------------
		// �� ��ư �� ����

		RoundedButton closeBtn = new RoundedButton("�ݱ�");
		closeBtn.setFont(fontButton);
		closeBtn.setVerticalAlignment(SwingConstants.CENTER);
		closeBtn.setHorizontalAlignment(SwingConstants.CENTER);
		closeBtn.setBounds(325, 228, 97, 23);
		contentPane.add(closeBtn);

		JLabel nameLbl = new JLabel("\uC791\uC131\uC790");
		nameLbl.setBounds(15, 33, 57, 15);
		nameLbl.setFont(font);
		contentPane.add(nameLbl);

		JLabel titleLbl = new JLabel("\uC81C \uBAA9");
		titleLbl.setBounds(15, 8, 57, 15);
		titleLbl.setFont(font);
		contentPane.add(titleLbl);

		JLabel nameTextField = new JLabel(name);
		nameTextField.setBounds(84, 30, 110, 21);
		nameTextField.setFont(font);
		contentPane.add(nameTextField);

		JLabel dateLbl = new JLabel("\uB4F1\uB85D\uC77C");
		dateLbl.setBounds(228, 33, 57, 15);
		dateLbl.setFont(font);
		contentPane.add(dateLbl);

		JLabel nowDateLbl = new JLabel(date);
		nowDateLbl.setFont(font);
		nowDateLbl.setBounds(290, 32, 119, 15);
		contentPane.add(nowDateLbl);

		// �ݱ��ư Ŭ��----------------------------------------------------

		closeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
