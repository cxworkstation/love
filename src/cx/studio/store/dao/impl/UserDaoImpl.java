package cx.studio.store.dao.impl;

import java.util.Date;
import java.util.List;

import cx.studio.store.dao.BaseDao;
import cx.studio.store.dao.UserDao;
import cx.studio.store.model.Users;

public class UserDaoImpl implements UserDao {

	BaseDao baseDao = new BaseDaoImpl();

	public void demo1() {
		List<List<Object>> users = getAllUsers();
		System.out.println(users);
	}

	// 查找所有用户
	public List<List<Object>> getAllUsers() {
		String sql = "select id,username,password,telephone,emails,registtime from users";
		List<List<Object>> users = baseDao.BaseQuery(sql, null);
		return users;
	}

	public void demo4() {
		// 根据id查找用户信息
		int id = 1;
		List<List<Object>> users = findById(id);
		System.out.println(users);
	}

	// 根据id查找用户信息
	public List<List<Object>> findById(int id) {
		String sql = "select * from users where id=?";
		Object[] param = { id };
		List<List<Object>> users = baseDao.BaseQuery(sql, param);
		return users;
	}

	public void demo3() {
		// 删除用户
		int id = 2;
		int res = deleteUser(id);
		System.out.println(res);
	}

	// 删除用户
	public int deleteUser(int id) {
		String sql = "delete from users where id=?";
		Object[] param = { id };
		int result = baseDao.BaseUpdate(sql, param);
		return result;
	}

	// 批量删除
	public boolean BatchDeleteUser(String[] ids) {
		String sql = "delete from users where id=?";
		boolean flag = baseDao.DelBatch(sql, ids);
		return flag;
	}

	public void demo2() {
		Users user = new Users();
		user.setUsername("fa11q");
		user.setPassword("aaswwa");
		user.setEmail("21sa3@qq.com");
		user.setTelephone("1234w56ff349");
		user.setRegisttime(new Date());
		int r = insertUser(user);
		System.out.println(r);
	}

	// 添加用户
	public int insertUser(Users user) {
		String sql = "insert into users values(?,?,?,?,?,?)";
		Object[] param = { null, user.getUsername(), user.getPassword(),
				user.getTelephone(), user.getEmail(), user.getRegisttime() };
		int result = baseDao.BaseUpdate(sql, param);
		return result;
	}

	public int updateUser(Users user) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 管理员不可修改客户信息，但是客户可以自己修改密码，电话，email

}
