package cx.studio.store.service;

import java.util.List;

public interface UserService {
	// 删除用户
	public int delete(int id);

	// 查找所有用户
	public List<List<Object>> getAllUsers();

	// 条件查找用户
	public List<List<Object>> search(String colName, String key);
}
