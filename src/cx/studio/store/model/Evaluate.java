package cx.studio.store.model;

import java.util.Date;

public class Evaluate {
	private int id;
	private String product_id;
	private String username;
	private Date puttime;
	private String content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String productId) {
		product_id = productId;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
