package cx.studio.store.service.impl;

import java.util.List;

import cx.studio.store.dao.EvaluatesDao;
import cx.studio.store.dao.impl.EvaluatesDaoImpl;
import cx.studio.store.service.EvaluatesService;

public class EvaluatesServiceImpl implements EvaluatesService {
	EvaluatesDao evaluatesDao = new EvaluatesDaoImpl();

	public List<List<Object>> getAllEvaluates() {
		List<List<Object>> e = evaluatesDao.getAllEvaluates();
		return e;
	}

	public int delete(int id) {
		return evaluatesDao.delete(id);
	}

	public List<List<Object>> search(String colName, String key) {
		List<List<Object>> e = evaluatesDao.search(colName, key);
		return e;
	}
}
