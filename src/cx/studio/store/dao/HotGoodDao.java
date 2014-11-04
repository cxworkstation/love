package cx.studio.store.dao;

import java.util.List;

public interface HotGoodDao {
	// 查询前十个热门商品
	public List<List<Object>> getAllHotGoods(int n);

	// 条件查询商品
	public List<List<Object>> search(String colName, String key);
}
