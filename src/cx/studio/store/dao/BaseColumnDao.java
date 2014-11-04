package cx.studio.store.dao;

import java.util.List;

import cx.studio.store.model.Goods;

public interface BaseColumnDao {
	// 添加商品
	public boolean insertColumn(Goods goods, String column_id);

	// 修改商品信息
	public int updateColumn(Goods goods);

	// 删除商品
	public boolean deleteColumnById(int id, String column_id);

	// 批量删除商品
	public boolean DelBatchColumn(String[] ids);

	// 通过id查找商品
	public List<List<Object>> findColumnById(int id);

	// 查找所有商品
	public List<List<Object>> findAllColumn(String column_id);

	// 根据id查找关键字
	public String findKeyWords(int id);

	// 通过id查找备注
	public String findRemark(int id);

	// 添加备注/修改备注
	public int insertCurrentRemark(String remark, int id);

	// 添加关键字/修改关键字
	public int insertGoodsKeyword(String keyword, int id);

	// 条件查询商品
	public List<List<Object>> search(String colName, String key);
}
