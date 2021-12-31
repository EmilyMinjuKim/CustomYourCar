/* SBS 1차 팀 프로젝트
 * 게시판 파트 - 상세보기 새창
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
	
	static String dirpath = "BoardDetail";	//상세 내용 파일이 들어있는 폴더명

	public DetailWindow(NoticeDTO user) throws IOException {
		this.user = user;
		num = user.getNum(); //등록번호
		name = user.getName();
		title = user.getTitle();
		date = user.getDate();

		// 입출력 테스트
		/*
		 * System.out.println("번호 호출 : " + num); System.out.println("이름 호출 : " + name);
		 * System.out.println("제목 호출 : " + title); System.out.println("날짜 호출 : " +
		 * date); System.out.println(everything);
		 */
		
		// 기본 뷰 생성
		frame = new JFrame();
		frame.setTitle("등록번호 : " + num);
		frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		frame.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		Font font = new Font("굴림", Font.PLAIN, 13);
		Font fontButton = new Font("굴림", Font.PLAIN, 17);

		JLabel titleTextLbl = new JLabel(title);
		titleTextLbl.setFont(font);
		titleTextLbl.setBounds(84, 5, 325, 21);
		contentPane.add(titleTextLbl);

		// 텍스트 내용 출력 -----------------------------------------------------

		JTextPane detailTextPane = new JTextPane();
		detailTextPane.setEditable(false);
		JScrollPane scrollArea = new JScrollPane(detailTextPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		// 등록번호와 일치하는 상세 보드 내용 불러오기
		// 등록번호와 지정한 디렉토리 안에 이름이 일치하는 파일을 불러와 결과값 출력
		//System.out.println("등록번호 몇번 출력 할건가요? :" + num);
		FileInputStream input = new FileInputStream(dirpath + "\\" + num + ".txt");
		InputStreamReader reader = new InputStreamReader(input, "UTF-8");
		BufferedReader br = new BufferedReader(reader);
		
		// 버퍼 리더의 경우 캐릭터 한글자식 출력을 하기 때문에
		// 해당 내용을 스트링 값으로 필드에 뿌려주기 위해 변환하는 코드
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
		// 각 버튼 뷰 생성

		RoundedButton closeBtn = new RoundedButton("닫기");
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

		// 닫기버튼 클릭----------------------------------------------------

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
