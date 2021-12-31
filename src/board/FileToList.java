/* SBS 1�� �� ������Ʈ
 * �Խ��� ��Ʈ - �ؽ�Ʈ ������ ���ϴ� ����Ʈ�� �����ϴ� Ŭ����
 * �ۼ��� : �̰�ö
 * ���� ������ : 2021.12.29
 */

package board;

import java.awt.GridBagLayout;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class FileToList {

	String path;
	ArrayList<NoticeDTO> list;

	public FileToList(String path) {
		try {
			MakeList(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<NoticeDTO> MakeList(String path) throws Exception {

		//�Խ��� �信�� �޾ƿ� �ּ�
		String fileName = path;
		
		//�ؽ�Ʈ ������ ���� �Խ��ǿ� �ѷ��� ����Ʈ ����
		List<String> fList = new ArrayList<>();
		fList = Files.readAllLines(Paths.get(fileName));	//�ؽ�Ʈ ������ ������ Ʃ�÷� �����ؼ� ����Ʈȭ

		list = new ArrayList<>();
		for (int i = 0; i < fList.size(); i++) {

			String[] temp = fList.get(i).split("\t");	//������ �� ������ ©�� ����

			NoticeDTO noticeDTO = new NoticeDTO(temp[0], temp[1], temp[2], temp[3]);	//��Ϲ�ȣ, �Խ����̸�, Ÿ��Ʋ, ��ϳ�¥
			
			list.add(noticeDTO);
		}
		System.out.println(list.toString());
		return list;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ArrayList<NoticeDTO> getList() {
		return list;
	}

	public void setList(ArrayList<NoticeDTO> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "FileToList [path=" + path + ", list=" + list + "]";
	}
}