package cx.studio.store.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import cx.studio.store.dao.BaseDao;
import cx.studio.store.utils.JdbcUtil;

public class BaseDaoImpl implements BaseDao {
	private QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());

	public int BaseUpdate(String sql, Object[] param) {
		int result = 0;
		try {
			result = queryRunner.update(sql, param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<List<Object>> BaseQuery(String sql, Object[] param) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<List<Object>> l = new ArrayList<List<Object>>();
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			if (param != null) {
				int n = param.length;
				for (int i = 0; i < n; i++) {
					int j = i + 1;
					ps.setObject(j, param[i]);
				}
			}
			rs = ps.executeQuery();
			ResultSetMetaData rsd = rs.getMetaData();
			int count = rsd.getColumnCount();
			while (rs.next()) {
				List<Object> list = new ArrayList<Object>();
				for (int j = 0; j < count; j++) {
					list.add(rs.getObject(j + 1));
				}
				l.add(list);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (ps != null) {
						ps.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (conn != null) {
							conn.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

		}
		return l;
	}

	public String BaseQuery(String sql, int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String result = "";
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (ps != null) {
						ps.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (conn != null) {
							conn.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

		}
		return result;
	}

	// ?????????????????????????????????????????????/
	public boolean BaseUpdate(String sql1, String sql2, Object[] param1,
			Object[] param2) {
		boolean flag = false;
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);// 开启事务
			int result1 = queryRunner.update(sql1, param1);
			int result2 = queryRunner.update(sql2, param2);
			flag = ((result1 == 1) && (result2 == 1));
			if (flag) {
				DbUtils.commitAndCloseQuietly(conn);
			} else {
				DbUtils.rollbackAndCloseQuietly(conn);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean DelBatch(String sql, String[] ids) {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean flag = false;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < ids.length; i++) {
				// 每个sql语句中就一个参数（?=id)valueOf转成数值
				ps.setInt(1, Integer.valueOf(ids[i]));
				ps.addBatch();
			}
			ps.executeBatch();
			DbUtils.commitAndCloseQuietly(conn);
			flag = true;
		} catch (Exception e) {
			flag = false;
			DbUtils.rollbackAndCloseQuietly(conn);
			e.printStackTrace();
		}
		return flag;
	}

}
