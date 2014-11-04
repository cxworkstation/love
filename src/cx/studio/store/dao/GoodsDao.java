package cx.studio.store.dao;

import java.util.List;

import cx.studio.store.model.Goods;

public interface GoodsDao {
	// 添加商品
	public int insertGoods(Goods goods);

	// 修改商品信息
	public int updateGoods(Goods goods);

	// 删除商品
	public int deleteGoodsById(int id);

	// 批量删除商品
	public boolean BatchDeleteGoods(String[] ids);

	// 通过id查找商品
	public List<List<Object>> findById(int id);

	// 查找所有商品
	public List<List<Object>> findAllGoods();

	// 根据id查找关键字
	public String findKeyWords(int id);

	// 根据id查找商品备注
	public String findRemark(int id);

	// 添加备注/修改备注
	public int insertGoodsRemark(String remark, int id);

	// 条件查询
	public List<List<Object>> search(String colName, String key);
}