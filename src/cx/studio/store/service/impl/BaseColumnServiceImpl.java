package cx.studio.store.service.impl;

import java.util.List;

import cx.studio.store.dao.BaseColumnDao;
import cx.studio.store.dao.impl.BaseColumnDaoImpl;
import cx.studio.store.model.Goods;
import cx.studio.store.service.BaseColumnService;

public class BaseColumnServiceImpl implements BaseColumnService {
	BaseColumnDao currentDao = new BaseColumnDaoImpl();

	public boolean addCurrent(Goods goods, String column_id) {
		boolean flag = currentDao.insertColumn(goods, column_id);
		return flag;
	}

	public boolean deleteCurrentById(int id, String column_id) {
		boolean result = currentDao.deleteColumnById(id, column_id);
		return result;
	}

	public List<List<Object>> findAllCurrent(String column_id) {
		List<List<Object>> currents = currentDao.findAllColumn(column_id);
		return currents;
	}

	public List<List<Object>> getById(int id) {
		List<List<Object>> current = currentDao.findColumnById(id);
		return current;
	}

	public String getRemark(int id) {
		String remark = currentDao.findRemark(id);
		return remark;
	}

	public int updateRemark(String remark, int id) {
		int result = currentDao.insertCurrentRemark(remark, id);
		return result;
	}

	public List<List<Object>> search(String colName, String key) {
		List<List<Object>> list = currentDao.search(colName, key);
		return list;
	}

}
