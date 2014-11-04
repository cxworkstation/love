package cx.studio.store.service.impl;

import java.util.List;

import cx.studio.store.dao.GoodsDao;
import cx.studio.store.dao.impl.GoodsDaoImpl;
import cx.studio.store.model.Goods;
import cx.studio.store.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {
	GoodsDao goodsDao = new GoodsDaoImpl();

	public List<List<Object>> findAllGoods() {
		List<List<Object>> goods = goodsDao.findAllGoods();
		return goods;
	}

	public int deleteGoodsById(int id) {
		int result = goodsDao.deleteGoodsById(id);
		return result;
	}

	public int addGoods(Goods goods) {
		int result = goodsDao.insertGoods(goods);
		return result;
	}

	public int updateRemark(String remark, int id) {
		int result = goodsDao.insertGoodsRemark(remark, id);
		return result;
	}

	public String getRemark(int id) {
		String remark = goodsDao.findRemark(id);
		return remark;
	}

	public boolean DelBatch(String[] ids) {
		boolean flag = goodsDao.BatchDeleteGoods(ids);
		return flag;
	}

	public List<List<Object>> getById(int id) {
		List<List<Object>> list = goodsDao.findById(id);
		return list;
	}

	public List<List<Object>> search(String colName, String key) {
		List<List<Object>> list = goodsDao.search(colName, key);
		return list;
	}

}
