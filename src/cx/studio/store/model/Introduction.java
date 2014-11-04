package cx.studio.store.model;

import java.util.Date;

public class Introduction {
	private int id;
	private String title;
	private String content;
	private Date puttime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPuttime() {
		return puttime;
	}

	public void setPuttime(Date puttime) {
		this.puttime = puttime;
	}

}
