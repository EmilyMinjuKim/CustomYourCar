/* SBS 1차 팀 프로젝트
 * 게시판 파트 - 등록하기 창
 * 작성자 : 이경철
 * 최종 수정일 : 2021.12.28
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

	static String save = "BoardDetail";	//작성한 글을 저장할 디렉토리
	static String filePath = "NoticeDTO.txt"; //게시판 일부 사항을 저장할 파일
																									
	public SubmitWindow() {

		frame = new JFrame();
		frame.setTitle("새글 등록하기");
		frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		Font font = new Font("굴림", Font.PLAIN, 13);
		Font fontButton = new Font("굴림", Font.PLAIN, 17);

		titleTextField = new JTextField("");	//제목 글 작성 필드
		titleTextField.setBounds(84, 5, 325, 21);
		contentPane.add(titleTextField);
		titleTextField.setColumns(10);
		
		
		JTextPane detailTextPane = new JTextPane();	//상세 글 내용 작성 필드
		JScrollPane scrollArea = new JScrollPane(detailTextPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);	//스크롤 여부 옵션 부여
		scrollArea.setBounds(12, 58, 410, 161);
		scrollArea.setFont(font);
		contentPane.add(scrollArea);

		RoundedButton submitBtn = new RoundedButton("\uB4F1\uB85D");	//등록하기 버튼
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

		nameTextField = new JTextField();	//이름 넣을 텍스트 필드
		nameTextField.setColumns(10);
		nameTextField.setBounds(84, 30, 110, 21);
		contentPane.add(nameTextField);

		JLabel dateLbl = new JLabel("\uB4F1\uB85D\uC77C");
		dateLbl.setBounds(228, 33, 57, 15);
		dateLbl.setFont(font);
		contentPane.add(dateLbl);

		Date now = new Date();	//현재 시각을 불러와, 글 작성 시간 등록
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strNow2 = sdf.format(now);

		JLabel nowDateLbl = new JLabel(strNow2);
		nowDateLbl.setFont(font);
		nowDateLbl.setBounds(290, 32, 119, 15);
		contentPane.add(nowDateLbl);

		RoundedButton cancelBtn = new RoundedButton("\uCDE8\uC18C");	//취소 버튼
		cancelBtn.setVerticalAlignment(SwingConstants.CENTER);
		cancelBtn.setHorizontalAlignment(SwingConstants.CENTER);
		cancelBtn.setFont(new Font("굴림", Font.PLAIN, 17));
		cancelBtn.setBounds(216, 229, 97, 23);
		contentPane.add(cancelBtn);

		// 취소버튼 클릭 : 그냥 창 닫힘 --------------------------------------

		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		// 저장버튼 클릭----------------------------------------------------
		
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
						
						// 상세글 외에 사항은 게시판 메인에 노출되기 위해 한 파일에 저장 
						BufferedWriter bw = new BufferedWriter(
								new OutputStreamWriter(new FileOutputStream(filePath, true), "utf-8"));
						String lineToAppend = submitnumber + "\t" + name + "\t" + title + "\t" + strNow2 + "\n";
						bw.write(lineToAppend);
						bw.close();
						
						//상세글은 등록번호에 따라 각 파일 이름으로 저장
						//파일 이름은 해당 등록번호를 따라 감.
						//처음 구조는 디렉토리 내 파일 수로 계산을 해서 아래 코드가 남아 있는데 차후 삭제 해도 무관
			
			
						BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(
								new FileOutputStream(save + "/" + submitnumber + ".txt"), "utf-8"));

						bw2.write(detail);
						bw2.close();
						
						//등록하면서, 필드 초기화, 창 닫음
						JOptionPane.showMessageDialog(null, "등록되었습니다.");
						titleTextField.setText("");
						nameTextField.setText("");
						detailTextPane.setText("");

						frame.dispose();
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "입력하지 않은 데이터가 있습니다.");	//데이터 미입력시 출력
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
