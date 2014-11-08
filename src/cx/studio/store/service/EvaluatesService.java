package cx.studio.store.service;

import java.util.List;

public interface EvaluatesService {
	// 查找所有评论信息
	public List<List<Object>> getAllEvaluates();

	// 删除评论
	public int delete(int id);

	// 条件查询
	public List<List<Object>> search(String colName, String key);
}
