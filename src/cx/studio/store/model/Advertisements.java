package cx.studio.store.model;

import java.util.Date;

public class Advertisements {
	private int id;
	private String img;
	private String product_id;
	private int adv_sort;
	private String content;
	private Date puttime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String productId) {
		product_id = productId;
	}

	public int getAdv_sort() {
		return adv_sort;
	}

	public void setAdv_sort(int advSort) {
		adv_sort = advSort;
	}

	public Date getPuttime() {
		return puttime;
	}

	public void setPuttime(Date puttime) {
		this.puttime = puttime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
