package cx.studio.store.service;

import java.util.List;

import cx.studio.store.model.Goods;

public interface BaseColumnService {
	// 找到所有当季推荐商品
	public List<List<Object>> findAllCurrent(String column_id);

	// 删除商品
	public boolean deleteCurrentById(int id, String column_id);

	// 添加商品
	public boolean addCurrent(Goods goods, String column_id);

	// 得到备注
	public String getRemark(int id);

	// 修改备注
	public int updateRemark(String remark, int id);

	// 通过id查找商品
	public List<List<Object>> getById(int id);

	// 条件查询商品
	public List<List<Object>> search(String colName, String key);

}
