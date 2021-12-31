/* SBS 1차 팀 프로젝트
 * 게시판 파트 - 텍스트 파일을 원하는 리스트로 생성하는 클래스
 * 작성자 : 이경철
 * 최종 수정일 : 2021.12.29
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

		//게시판 뷰에서 받아온 주소
		String fileName = path;
		
		//텍스트 파일을 통해 게시판에 뿌려줄 리스트 생성
		List<String> fList = new ArrayList<>();
		fList = Files.readAllLines(Paths.get(fileName));	//텍스트 파일의 내용을 튜플로 구분해서 리스트화

		list = new ArrayList<>();
		for (int i = 0; i < fList.size(); i++) {

			String[] temp = fList.get(i).split("\t");	//탭으로 각 내용을 짤라서 넣음

			NoticeDTO noticeDTO = new NoticeDTO(temp[0], temp[1], temp[2], temp[3]);	//등록번호, 게시자이름, 타이틀, 등록날짜
			
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