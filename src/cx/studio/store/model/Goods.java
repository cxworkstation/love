package cx.studio.store.model;

import java.util.Date;

public class Goods {
	private int id;
	private String name;
	private double oldprice;
	private double newprice;
	private int start_number;
	private int count;
	private String unit;
	private String keyword;
	private String img;
	private String product_id;
	private String remark;
	private Date puttime;
	private String type_name;

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String typeName) {
		type_name = typeName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String productId) {
		product_id = productId;
	}

	public int getStart_number() {
		return start_number;
	}

	public void setStart_number(int startNumber) {
		start_number = startNumber;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public double getOldprice() {
		return oldprice;
	}

	public void setOldprice(double oldprice) {
		this.oldprice = oldprice;
	}

	public double getNewprice() {
		return newprice;
	}

	public void setNewprice(double newprice) {
		this.newprice = newprice;
	}

	public Date getPuttime() {
		return puttime;
	}

	public void setPuttime(Date puttime) {
		this.puttime = puttime;
	}

}
