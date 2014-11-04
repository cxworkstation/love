package cx.studio.store.service.impl;

import java.util.List;

import cx.studio.store.dao.HotGoodDao;
import cx.studio.store.dao.impl.HotGoodDaoImpl;
import cx.studio.store.service.HotGoodService;

public class HotGoodServiceImpl implements HotGoodService {
	HotGoodDao hotGoodDao = new HotGoodDaoImpl();

	public List<List<Object>> getAllHotGood(int n) {
		List<List<Object>> list = hotGoodDao.getAllHotGoods(n);
		return list;
	}

	public List<List<Object>> getTrueGood(String colName, String key) {
		List<List<Object>> list = hotGoodDao.search(colName, key);
		return list;
	}
}
