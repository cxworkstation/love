package cx.studio.store.model;

public class ColumnName {
	// 当季推荐
	public String c1 = "当季推荐";
	// 今日免费
	public String c2 = "今日免费";
	// 新品上市
	public String c3 = "新品上市";

	public String getName(String id) {
		if ("c1".equals(id)) {
			return this.c1;
		} else if ("c2".equals(id)) {
			return this.c2;
		}
		return this.c3;
	}
}
