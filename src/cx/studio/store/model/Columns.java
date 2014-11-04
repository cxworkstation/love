package cx.studio.store.model;

public class Columns {
	private int id;
	private String column_name;
	private String product_id;
	private String column_id;

	public String getColumn_id() {
		return column_id;
	}

	public void setColumn_id(String columnId) {
		column_id = columnId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColumn_name() {
		return column_name;
	}

	public void setColumn_name(String columnName) {
		column_name = columnName;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String productId) {
		product_id = productId;
	}

}
