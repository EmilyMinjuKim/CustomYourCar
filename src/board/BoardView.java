/* SBS 1차 팀 프로젝트
 * 게시판 파트 - 텍스트 파일을 원하는 리스트로 생성하는 클래스
 * 작성자 : 이경철, 정유진
 * 최종 수정일 : 2021.12.30
 */

package board;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import design.RoundedButton;

import java.awt.GridBagLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class BoardView extends JPanel {

	JPanel contentPane;
	private JPanel startPanel;
	private JTextField textField;
	MyTable mt;
	FileToList flt;
	JTable table;
	ArrayList<NoticeDTO> list;

	public BoardView() {
	}

	public BoardView(JPanel startPanel) throws Exception {

		this.startPanel = startPanel;
		contentPane = this;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelCenter = new JPanel();
		panelCenter.setBounds(0, 105, 800, 400);
		panelCenter.setBackground(Color.white);

		// ------------------------------------------------------

		mt = new MyTable("NoticeDTO.txt");		//해당 텍스트 파일을 JScrollPane 타입으로 리턴

		mt.scrolledTable.setBackground(Color.white);
		mt.scrolledTable.setPreferredSize(new Dimension(800, 395));

		panelCenter.add(mt.scrolledTable);

		// --------------------------------------------------------

		contentPane.add(panelCenter);

		JPanel panelTop = new JPanel();
		panelTop.setBounds(0, 0, 800, 100);
		panelTop.setBackground(Color.white);

		ImageIcon bannerTop = new ImageIcon("images/banner_notice.png");	// 상단 배너 이미지

		JLabel lblTop = new JLabel(bannerTop);

		panelTop.add(lblTop);
		contentPane.add(panelTop);

		JPanel panelbottom2 = new JPanel();
		panelbottom2.setBounds(0, 505, 780, 50);
		panelbottom2.setBackground(Color.white);
		contentPane.add(panelbottom2);
		panelbottom2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Keyword Serch");
		lblNewLabel.setBounds(90, 10, 100, 30);
		panelbottom2.add(lblNewLabel);

		// 검색창
		textField = new JTextField();
		textField.setBounds(190, 10, 150, 30);
		panelbottom2.add(textField);
		textField.setColumns(10);

		RoundedButton btnNewButton = new RoundedButton("Search!");	//검색버튼
		btnNewButton.setBounds(350, 10, 100, 30);
		panelbottom2.add(btnNewButton);

		RoundedButton btnNewButton_1 = new RoundedButton("New Submit");	//등록버튼
		btnNewButton_1.setBounds(550, 10, 120, 30);
		panelbottom2.add(btnNewButton_1);

		// -----------------------------------------------------------
		// 의미는 없지만 없으면 에러가 남.
		JPanel panelBottom = new JPanel();
		panelBottom.setBounds(0, 500, 800, 100);
		panelBottom.setBackground(Color.white);
		contentPane.add(panelBottom);

		// --------------------------------------------------------
		// 등록하기 누름 (새창 열려야 함)

		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SubmitWindow sw = new SubmitWindow();
				sw.frame.setVisible(true);
			}
		});

		// 검색하기
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String search = textField.getText();
				System.out.println("serach:" + search);

				if ("".equals(search)) {
					JOptionPane.showMessageDialog(null, "검색어를 입력해주세요.", "Warning Message", JOptionPane.WARNING_MESSAGE);
					textField.requestFocus();
					
				} else {
					try {
						
						SearchDEM sdem;	//필드에 입력한 검색어를 통해서 JScrollPane으로 리턴 받은 후 다시 새창을 통해서 결과값 출력
						sdem = new SearchDEM(search);

						JScrollPane jp = sdem.jsp;

						SearchWindow test2 = new SearchWindow(jp);
						test2.frame.setVisible(true);

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

	}

}
