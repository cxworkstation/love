package cx.studio.store.service;

import java.util.List;

import cx.studio.store.model.Goods;

public interface GoodsService {
	// 找到所有商品
	public List<List<Object>> findAllGoods();

	// 删除商品
	public int deleteGoodsById(int id);

	// 添加商品
	public int addGoods(Goods goods);

	// 得到备注
	public String getRemark(int id);

	// 修改备注
	public int updateRemark(String remark, int id);

	// 通过id查找商品
	public List<List<Object>> getById(int id);

	// 批量删除
	public boolean DelBatch(String[] ids);

	// 条件查询
	public List<List<Object>> search(String colName, String key);
}