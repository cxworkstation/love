package cx.studio.store.service.impl;

import java.util.List;

import cx.studio.store.dao.UserDao;
import cx.studio.store.dao.impl.UserDaoImpl;
import cx.studio.store.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();

	public int delete(int id) {
		int result = userDao.deleteUser(id);
		return result;
	}

	public List<List<Object>> getAllUsers() {
		List<List<Object>> list = userDao.getAllUsers();
		return list;
	}

	public List<List<Object>> search(String colName, String key) {
		List<List<Object>> list = userDao.search(colName, key);
		return list;
	}

}
