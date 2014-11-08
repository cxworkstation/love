package cx.studio.store.dao;

import java.util.List;

public interface EvaluatesDao {
	// 查看所有评论
	public List<List<Object>> getAllEvaluates();

	// 删除评论
	public int delete(int id);

	// 条件查找
	public List<List<Object>> search(String colName, String key);
}
