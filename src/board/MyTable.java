/* SBS 1�� �� ������Ʈ
 * �Խ��� ��Ʈ - ���̺� ����
 * �ۼ��� : �̰�ö
 * ���� ������ : 2021.12.30
 */

package board;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class MyTable extends JFrame implements MouseListener {

	JScrollPane scrolledTable;
	JTable table;
	int row;
	DefaultTableModel model;
	FileToList ftl;
	Vector v;
	NoticeDTO select;

	public MyTable() {
	}

	public MyTable(String e) throws Exception {

		ftl = new FileToList(e); // ����Ʈ�� �޾ƿ� ��ü ����

		Vector<String> vector = new Vector<String>();
		// Į�� ����
		vector.addElement("��Ϲ�ȣ");
		vector.addElement("�Խ���");
		vector.addElement("����");
		vector.addElement("��ϳ�¥");

		model = new DefaultTableModel(vector, 0) { // JTable�� �� �� ����
			public boolean isCellEditable(int r, int c) {
				// return (c != 0) ? true : false;
				return false;
			}
		};

		// �� ���� ����
		DefaultTableCellRenderer cellAlignCenter = new DefaultTableCellRenderer();
		cellAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		DefaultTableCellRenderer cellAlignRight = new DefaultTableCellRenderer();
		cellAlignRight.setHorizontalAlignment(JLabel.RIGHT);
		DefaultTableCellRenderer cellAlignLeft = new DefaultTableCellRenderer();
		cellAlignRight.setHorizontalAlignment(JLabel.LEFT);

		// ���̺� �� ���� (��ϵ� �������� ��迭)
		Collections.reverse(ftl.list);

		// �����͸� Vector ����Ʈ �������� �߰�
		for (NoticeDTO data : ftl.list) {
			v = new Vector();
			v.add(data.getNum());
			v.add(data.getName());
			v.add(data.getTitle());
			v.add(data.getDate());
			model.addRow(v);
		}

		// ���̺� ����
		table = new JTable(model);

		// �� �ʺ�� ���� ����
		table.getColumn("��Ϲ�ȣ").setPreferredWidth(90);
		table.getColumn("��Ϲ�ȣ").setCellRenderer(cellAlignCenter);

		table.getColumn("�Խ���").setPreferredWidth(190);
		table.getColumn("�Խ���").setCellRenderer(cellAlignCenter);

		table.getColumn("����").setPreferredWidth(500);
		table.getColumn("����").setCellRenderer(cellAlignLeft);

		table.getColumn("��ϳ�¥").setPreferredWidth(120);
		table.getColumn("��ϳ�¥").setCellRenderer(cellAlignCenter);

		table.setRowHeight(25);

		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // �� ���� ���� ����. (�� ���� ���� �����ϰ�)
		table.addMouseListener(this); // �� ���� �׼�

		table.setLayout(null);

		// scrolledTable = new JScrollPane(); // ������ ���̺�� JScrollPane ����
		scrolledTable = new JScrollPane(); // ������																											// ���̺��
																														// JScrollPane
																														// ����
		scrolledTable.setViewportView(table);
	}

	// -----------------------------------------

	@Override
	public void mouseClicked(MouseEvent e) {

		row = table.getSelectedRow(); // ���õ� �� ��

		// System.out.println("Ŭ�� ��ġ Ȯ�� : " + row );

		TableModel tm = table.getModel();

		// �ش� �ο��� ������ ��ȯ���ֱ� ���� �۾�
		String no = (String) tm.getValueAt(row, 0);
		String name = (String) tm.getValueAt(row, 1);
		String title = (String) tm.getValueAt(row, 2);
		String date = (String) tm.getValueAt(row, 3);

		select = new NoticeDTO(no, name, title, date);

		// ��â�� �����Ͽ� ���õ� ������ �ش��ϴ� ���� �ѷ���
		DetailWindow frame;

		try {
			frame = new DetailWindow(select);
			frame.frame.setVisible(true);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
