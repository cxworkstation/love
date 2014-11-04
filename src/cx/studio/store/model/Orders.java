package cx.studio.store.model;

import java.util.Date;

public class Orders {
	private int id;
	private String order_id;
	private int number;
	private String product_id;
	private String address;
	private String telephone;
	private int state;
	private Date booktime;
	private String payment_method;
	private String distance;
	private String expense;
	private double totalmoney;

	public Date getBooktime() {
		return booktime;
	}

	public void setBooktime(Date booktime) {
		this.booktime = booktime;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(String paymentMethod) {
		payment_method = paymentMethod;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getExpense() {
		return expense;
	}

	public void setExpense(String expense) {
		this.expense = expense;
	}

	public double getTotalmoney() {
		return totalmoney;
	}

	public void setTotalmoney(double totalmoney) {
		this.totalmoney = totalmoney;
	}

	private int isReceiving;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String orderId) {
		order_id = orderId;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String productId) {
		product_id = productId;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getIsReceiving() {
		return isReceiving;
	}

	public void setIsReceiving(int isReceiving) {
		this.isReceiving = isReceiving;
	}

}
