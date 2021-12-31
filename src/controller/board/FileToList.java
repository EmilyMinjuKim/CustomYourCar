package controller.board;

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

import model.notice.NoticeDTO;

public class FileToList {

	String path;
	public ArrayList<NoticeDTO> list;

	public FileToList(String path) {
		try {
			MakeList(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<NoticeDTO> MakeList(String path) throws Exception {

		// String fileName =
		// ("E://document//LKC_Workspace//JAVA//SBC(Sexy_Best_Car)//NoiticeDTO.txt");
		String fileName = path;

		List<String> fList = new ArrayList<>();
		fList = Files.readAllLines(Paths.get(fileName));

		list = new ArrayList<>();
		for (int i = 0; i < fList.size(); i++) {

			String[] temp = fList.get(i).split("\t");

			NoticeDTO noticeDTO = new NoticeDTO(i+1, temp[0], temp[1], temp[2]);
			
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
}