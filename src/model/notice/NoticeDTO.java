package model.notice;

public class NoticeDTO {

	int num;
	String name;
	String title;
	String date;
	String detail;

	public NoticeDTO(int num, String name, String title, String date, String detail) {
		this.num = num;
		this.name = name;
		this.title = title;
		this.date = date;
		this.detail = detail;
	}
	
	public NoticeDTO(int num, String name, String title, String date) {
		this.num = num;
		this.name = name;
		this.title = title;
		this.date = date;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
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