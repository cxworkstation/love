package cx.studio.store.dao;

import java.util.List;

public interface BaseDao {
	// 增删改操作的基础类
	public int BaseUpdate(String sql, Object[] param);

	// 修改两张表记录的基础类
	public boolean BaseUpdate(String sql1, String sql2, Object[] param1,
			Object[] param2);

	// 批量删除基础类
	public boolean DelBatch(String sql, String[] ids);

	// 查询基础类
	public List<List<Object>> BaseQuery(String sql, Object[] param);

	// 查找某个字段的基础类
	public String BaseQuery(String sql, int id);

}
