/* SBS 1차 팀 프로젝트
 * 게시판 파트 - 테이블 생성
 * 작성자 : 이경철
 * 최종 수정일 : 2021.12.30
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

		ftl = new FileToList(e); // 리스트를 받아와 객체 생성

		Vector<String> vector = new Vector<String>();
		// 칼럼 생성
		vector.addElement("등록번호");
		vector.addElement("게시자");
		vector.addElement("제목");
		vector.addElement("등록날짜");

		model = new DefaultTableModel(vector, 0) { // JTable에 들어갈 모델 생성
			public boolean isCellEditable(int r, int c) {
				// return (c != 0) ? true : false;
				return false;
			}
		};

		// 셀 정렬 여부
		DefaultTableCellRenderer cellAlignCenter = new DefaultTableCellRenderer();
		cellAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		DefaultTableCellRenderer cellAlignRight = new DefaultTableCellRenderer();
		cellAlignRight.setHorizontalAlignment(JLabel.RIGHT);
		DefaultTableCellRenderer cellAlignLeft = new DefaultTableCellRenderer();
		cellAlignRight.setHorizontalAlignment(JLabel.LEFT);

		// 테이블 모델 역순 (등록된 역순으로 재배열)
		Collections.reverse(ftl.list);

		// 데이터를 Vector 리스트 형식으로 추가
		for (NoticeDTO data : ftl.list) {
			v = new Vector();
			v.add(data.getNum());
			v.add(data.getName());
			v.add(data.getTitle());
			v.add(data.getDate());
			model.addRow(v);
		}

		// 테이블 생성
		table = new JTable(model);

		// 셀 너비와 정렬 선택
		table.getColumn("등록번호").setPreferredWidth(90);
		table.getColumn("등록번호").setCellRenderer(cellAlignCenter);

		table.getColumn("게시자").setPreferredWidth(190);
		table.getColumn("게시자").setCellRenderer(cellAlignCenter);

		table.getColumn("제목").setPreferredWidth(500);
		table.getColumn("제목").setCellRenderer(cellAlignLeft);

		table.getColumn("등록날짜").setPreferredWidth(120);
		table.getColumn("등록날짜").setCellRenderer(cellAlignCenter);

		table.setRowHeight(25);

		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 셀 선택 유형 선택. (한 셀만 선택 가능하게)
		table.addMouseListener(this); // 셀 선택 액션

		table.setLayout(null);

		// scrolledTable = new JScrollPane(); // 생성된 테이블로 JScrollPane 생성
		scrolledTable = new JScrollPane(); // 생성된																											// 테이블로
																														// JScrollPane
																														// 생성
		scrolledTable.setViewportView(table);
	}

	// -----------------------------------------

	@Override
	public void mouseClicked(MouseEvent e) {

		row = table.getSelectedRow(); // 선택된 셀 값

		// System.out.println("클릭 위치 확인 : " + row );

		TableModel tm = table.getModel();

		// 해당 로우의 값들을 반환해주기 위한 작업
		String no = (String) tm.getValueAt(row, 0);
		String name = (String) tm.getValueAt(row, 1);
		String title = (String) tm.getValueAt(row, 2);
		String date = (String) tm.getValueAt(row, 3);

		select = new NoticeDTO(no, name, title, date);

		// 새창을 생성하여 선택된 내용을 해당하는 곳에 뿌려줌
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
