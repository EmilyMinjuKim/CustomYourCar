/* SBS 1�� �� ������Ʈ
 * �Խ��� ��Ʈ - �ؽ�Ʈ ������ ���ϴ� ����Ʈ�� �����ϴ� Ŭ����
 * �ۼ��� : �̰�ö, ������
 * ���� ������ : 2021.12.30
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

		mt = new MyTable("NoticeDTO.txt");		//�ش� �ؽ�Ʈ ������ JScrollPane Ÿ������ ����

		mt.scrolledTable.setBackground(Color.white);
		mt.scrolledTable.setPreferredSize(new Dimension(800, 395));

		panelCenter.add(mt.scrolledTable);

		// --------------------------------------------------------

		contentPane.add(panelCenter);

		JPanel panelTop = new JPanel();
		panelTop.setBounds(0, 0, 800, 100);
		panelTop.setBackground(Color.white);

		ImageIcon bannerTop = new ImageIcon("images/banner_notice.png");	// ��� ��� �̹���

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

		// �˻�â
		textField = new JTextField();
		textField.setBounds(190, 10, 150, 30);
		panelbottom2.add(textField);
		textField.setColumns(10);

		RoundedButton btnNewButton = new RoundedButton("Search!");	//�˻���ư
		btnNewButton.setBounds(350, 10, 100, 30);
		panelbottom2.add(btnNewButton);

		RoundedButton btnNewButton_1 = new RoundedButton("New Submit");	//��Ϲ�ư
		btnNewButton_1.setBounds(550, 10, 120, 30);
		panelbottom2.add(btnNewButton_1);

		// -----------------------------------------------------------
		// �ǹ̴� ������ ������ ������ ��.
		JPanel panelBottom = new JPanel();
		panelBottom.setBounds(0, 500, 800, 100);
		panelBottom.setBackground(Color.white);
		contentPane.add(panelBottom);

		// --------------------------------------------------------
		// ����ϱ� ���� (��â ������ ��)

		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SubmitWindow sw = new SubmitWindow();
				sw.frame.setVisible(true);
			}
		});

		// �˻��ϱ�
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String search = textField.getText();
				System.out.println("serach:" + search);

				if ("".equals(search)) {
					JOptionPane.showMessageDialog(null, "�˻�� �Է����ּ���.", "Warning Message", JOptionPane.WARNING_MESSAGE);
					textField.requestFocus();
					
				} else {
					try {
						
						SearchDEM sdem;	//�ʵ忡 �Է��� �˻�� ���ؼ� JScrollPane���� ���� ���� �� �ٽ� ��â�� ���ؼ� ����� ���
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
