package cx.studio.store.dao.impl;

import java.util.List;

import cx.studio.store.dao.BaseDao;
import cx.studio.store.dao.EvaluatesDao;

public class EvaluatesDaoImpl implements EvaluatesDao {
	BaseDao baseDao = new BaseDaoImpl();

	public void demo() {
		List<List<Object>> w = getAllEvaluates();
		System.out.println(w);
	}

	public List<List<Object>> getAllEvaluates() {
		String sql = "select evaluate.id,a.name,evaluate.username,evaluate.puttime,evaluate.content from evaluate, (select name,product_id from goods ) as a where a.product_id=evaluate.product_id";
		List<List<Object>> evaluates = baseDao.BaseQuery(sql, null);
		return evaluates;
	}

	public int delete(int id) {
		String sql = "delete from evaluate where id=?";
		Object[] param = { id };
		int result = baseDao.BaseUpdate(sql, param);
		return result;
	}

	public void demo3() {
		List<List<Object>> s = search("username", "fag");
		System.out.println(s);
	}

	public List<List<Object>> search(String colName, String key) {
		String sql = "select evaluate.id,a.name,evaluate.username,evaluate.puttime,evaluate.content from evaluate, (select name,product_id from goods ) as a where a.product_id=evaluate.product_id";
		if ("username".equals(colName)) {
			sql = "select evaluate.id,a.name,evaluate.username,evaluate.puttime,evaluate.content from evaluate, (select name,product_id from goods ) as a where a.product_id=evaluate.product_id and username=?";
		} else if ("name".equals(colName)) {
			sql = "select evaluate.id,a.name,evaluate.username,evaluate.puttime,evaluate.content from evaluate, (select name,product_id from goods where name=?) as a where a.product_id=evaluate.product_id ";
		}
		Object[] param = { key };
		List<List<Object>> e = baseDao.BaseQuery(sql, param);
		return e;
	}
}
