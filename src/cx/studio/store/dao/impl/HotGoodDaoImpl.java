package cx.studio.store.dao.impl;

import java.util.List;

import cx.studio.store.dao.BaseDao;
import cx.studio.store.dao.HotGoodDao;

public class HotGoodDaoImpl implements HotGoodDao {
	BaseDao baseDao = new BaseDaoImpl();

	public void demo() {
		// 查询前十个热门商品
		List<List<Object>> list = getAllHotGoods(10);
		System.out.println(list);
	}

	// 查询前十个热门商品
	public List<List<Object>> getAllHotGoods(int n) {
		String sql = "select id,product_id,name,oldprice,newprice,unit,start_number,count from goods order by count desc limit ?";
		Object[] param = { n };
		List<List<Object>> list = baseDao.BaseQuery(sql, param);
		return list;
	}

	public void demo22() {
		// 条件查询商品
		List<List<Object>> s = search("product_id", "UVM022475");
		System.out.println(s);
	}

	// 条件查询商品
	public List<List<Object>> search(String colName, String key) {
		String sql = "";
		if ("product_id".equals(colName)) {
			sql = "select id,product_id,name,oldprice,newprice,unit,start_number,count from goods where product_id='"
					+ key + "'";
		} else if ("keyword".equals(colName)) {
			sql = "select id,product_id,name,oldprice,newprice,unit,start_number,count from goods where keyword like '%"
					+ key + "%'";
		} else {
			sql = "select id,product_id,name,oldprice,newprice,unit,start_number,count from goods";
		}
		List<List<Object>> list = baseDao.BaseQuery(sql, null);
		return list;
	}
}
