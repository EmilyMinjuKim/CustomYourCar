/* SBS 1차 팀 프로젝트
 * 게시판 파트 - DTO
 * 작성자 : 이경철, 정유진
 * 최종 수정일 : 2021.12.30
 */

package board;

public class NoticeDTO {

	String num;
	String name;
	String title;
	String date;
	String detail;


	
	public NoticeDTO(String num, String name, String title, String date) {
		this.num = num;
		this.name = name;
		this.title = title;
		this.date = date;
	}



	public String getNum() {
		return num;
	}



	public void setNum(String num) {
		this.num = num;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}