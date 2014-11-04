package cx.studio.store.dao;

import java.util.List;

import cx.studio.store.model.Users;

public interface UserDao {
	// 添加用户
	public int insertUser(Users user);

	// 修改用户信息
	public int updateUser(Users user);

	// 删除用户
	public int deleteUser(int id);

	// 批量删除用户
	public boolean BatchDeleteUser(String[] ids);

	// 查看所有用户
	public List<List<Object>> getAllUsers();

	// 根据id查找用户
	public List<List<Object>> findById(int id);
}
