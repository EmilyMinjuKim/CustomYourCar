/* SBS 1�� �� ������Ʈ
 * �Խ��� ��Ʈ - �ؽ�Ʈ ������ ���ϴ� ����Ʈ�� �����ϴ� Ŭ����
 * �ۼ��� : �̰�ö, ������
 * ���� ������ : 2021.12.30
 */

package board;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class SearchWindow {

	private JPanel contentPane;
	JScrollPane jp;
	JFrame frame;
	
	//�˻��� ����� ��� ��â.
	public SearchWindow(JScrollPane jp2) {
		this.jp = jp2;

		frame = new JFrame();
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
		frame.setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);

		contentPane.add(jp);
		
		
		
		
		
		
	}

}
