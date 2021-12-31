/* SBS 1�� �� ������Ʈ
 * �Խ��� ��Ʈ - ����ϱ� â
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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
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

public class SubmitWindow {

	JFrame frame;

	private JPanel contentPane;
	private JTextField titleTextField;
	private JTextField nameTextField;

	static String save = "BoardDetail";	//�ۼ��� ���� ������ ���丮
	static String filePath = "NoticeDTO.txt"; //�Խ��� �Ϻ� ������ ������ ����
																									
	public SubmitWindow() {

		frame = new JFrame();
		frame.setTitle("���� ����ϱ�");
		frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		Font font = new Font("����", Font.PLAIN, 13);
		Font fontButton = new Font("����", Font.PLAIN, 17);

		titleTextField = new JTextField("");	//���� �� �ۼ� �ʵ�
		titleTextField.setBounds(84, 5, 325, 21);
		contentPane.add(titleTextField);
		titleTextField.setColumns(10);
		
		
		JTextPane detailTextPane = new JTextPane();	//�� �� ���� �ۼ� �ʵ�
		JScrollPane scrollArea = new JScrollPane(detailTextPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);	//��ũ�� ���� �ɼ� �ο�
		scrollArea.setBounds(12, 58, 410, 161);
		scrollArea.setFont(font);
		contentPane.add(scrollArea);

		RoundedButton submitBtn = new RoundedButton("\uB4F1\uB85D");	//����ϱ� ��ư
		submitBtn.setFont(fontButton);
		submitBtn.setVerticalAlignment(SwingConstants.CENTER);
		submitBtn.setHorizontalAlignment(SwingConstants.CENTER);
		submitBtn.setBounds(325, 228, 97, 23);
		contentPane.add(submitBtn);

		JLabel nameLbl = new JLabel("\uC791\uC131\uC790");
		nameLbl.setBounds(15, 33, 57, 15);
		nameLbl.setFont(font);
		contentPane.add(nameLbl);

		JLabel titleLbl = new JLabel("\uC81C \uBAA9");
		titleLbl.setBounds(15, 8, 57, 15);
		titleLbl.setFont(font);
		contentPane.add(titleLbl);

		nameTextField = new JTextField();	//�̸� ���� �ؽ�Ʈ �ʵ�
		nameTextField.setColumns(10);
		nameTextField.setBounds(84, 30, 110, 21);
		contentPane.add(nameTextField);

		JLabel dateLbl = new JLabel("\uB4F1\uB85D\uC77C");
		dateLbl.setBounds(228, 33, 57, 15);
		dateLbl.setFont(font);
		contentPane.add(dateLbl);

		Date now = new Date();	//���� �ð��� �ҷ���, �� �ۼ� �ð� ���
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strNow2 = sdf.format(now);

		JLabel nowDateLbl = new JLabel(strNow2);
		nowDateLbl.setFont(font);
		nowDateLbl.setBounds(290, 32, 119, 15);
		contentPane.add(nowDateLbl);

		RoundedButton cancelBtn = new RoundedButton("\uCDE8\uC18C");	//��� ��ư
		cancelBtn.setVerticalAlignment(SwingConstants.CENTER);
		cancelBtn.setHorizontalAlignment(SwingConstants.CENTER);
		cancelBtn.setFont(new Font("����", Font.PLAIN, 17));
		cancelBtn.setBounds(216, 229, 97, 23);
		contentPane.add(cancelBtn);

		// ��ҹ�ư Ŭ�� : �׳� â ���� --------------------------------------

		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		// �����ư Ŭ��----------------------------------------------------
		
		submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String title = titleTextField.getText();
				String name = nameTextField.getText();
				String detail = detailTextPane.getText();
				System.out.println(detail);

				if (!title.equals("") && !name.equals("") && !detail.equals("")) {

					try {
						File dir = new File(save);
						File files[] = dir.listFiles();

						int submitnumber = files.length + 1;
						System.out.println(submitnumber);
						
						// �󼼱� �ܿ� ������ �Խ��� ���ο� ����Ǳ� ���� �� ���Ͽ� ���� 
						BufferedWriter bw = new BufferedWriter(
								new OutputStreamWriter(new FileOutputStream(filePath, true), "utf-8"));
						String lineToAppend = submitnumber + "\t" + name + "\t" + title + "\t" + strNow2 + "\n";
						bw.write(lineToAppend);
						bw.close();
						
						//�󼼱��� ��Ϲ�ȣ�� ���� �� ���� �̸����� ����
						//���� �̸��� �ش� ��Ϲ�ȣ�� ���� ��.
						//ó�� ������ ���丮 �� ���� ���� ����� �ؼ� �Ʒ� �ڵ尡 ���� �ִµ� ���� ���� �ص� ����
			
			
						BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(
								new FileOutputStream(save + "/" + submitnumber + ".txt"), "utf-8"));

						bw2.write(detail);
						bw2.close();
						
						//����ϸ鼭, �ʵ� �ʱ�ȭ, â ����
						JOptionPane.showMessageDialog(null, "��ϵǾ����ϴ�.");
						titleTextField.setText("");
						nameTextField.setText("");
						detailTextPane.setText("");

						frame.dispose();
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "�Է����� ���� �����Ͱ� �ֽ��ϴ�.");	//������ ���Է½� ���
				}

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
