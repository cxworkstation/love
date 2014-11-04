package cx.studio.store.model;

public class OdometerExpense {
	private int id;
	private String start_position;
	private String price;
	private String end_position;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStart_position() {
		return start_position;
	}

	public void setStart_position(String startPosition) {
		start_position = startPosition;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getEnd_position() {
		return end_position;
	}

	public void setEnd_position(String endPosition) {
		end_position = endPosition;
	}

}
