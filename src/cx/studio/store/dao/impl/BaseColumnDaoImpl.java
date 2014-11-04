package cx.studio.store.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import cx.studio.store.dao.BaseColumnDao;
import cx.studio.store.dao.BaseDao;
import cx.studio.store.model.ColumnName;
import cx.studio.store.model.Goods;
import cx.studio.store.utils.CodeUtil;
import cx.studio.store.utils.JdbcUtil;

public class BaseColumnDaoImpl implements BaseColumnDao {

	BaseDao baseDao = new BaseDaoImpl();
	QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());

	// 添加当季推荐商品(column_id从前台Servlet里面传过来)
	public boolean insertColumn(Goods goods, String column_id) {
		String sql1 = "insert into goods(name,oldprice,newprice,start_number,count,unit,img,product_id,puttime,type_name) values(?,?,?,?,?,?,?,?,?,?)";
		String sql2 = "insert into columns(column_name,product_id,column_id) values(?,?,?)";
		String productId = CodeUtil.getProductId();
		Object[] param1 = { goods.getName(), goods.getOldprice(),
				goods.getNewprice(), goods.getStart_number(), 0,
				goods.getUnit(), goods.getImg(), productId, goods.getPuttime(),
				goods.getType_name() };
		ColumnName c = new ColumnName();
		Object[] param2 = { c.getName(column_id), productId, column_id };
		boolean result = baseDao.BaseUpdate(sql1, sql2, param1, param2);
		return result;
	}

	// 条件查询商品
	public List<List<Object>> search(String colName, String key) {
		String sql = "select id,product_id,name,oldprice,newprice,unit,start_number,count from goods where keyword like '%"
				+ key + "%'";
		List<List<Object>> list = baseDao.BaseQuery(sql, null);
		return list;
	}

	// 添加关键字/修改关键字
	public int insertGoodsKeyword(String keyword, int id) {
		String sql = "update goods set keyword=? where id=?";
		Object[] param = { keyword, id };
		int result = baseDao.BaseUpdate(sql, param);
		return result;
	}

	// 添加备注/修改备注
	public int insertCurrentRemark(String remark, int id) {
		String sql = "update goods set remark=? where id=?";
		Object[] param = { remark, id };
		int result = baseDao.BaseUpdate(sql, param);
		return result;
	}

	// 通过id寻找当季推荐商品（除了备注和关键字）--跟根据id寻找商品一样
	public List<List<Object>> findColumnById(int id) {
		String sql = "select * from goods where id=?";
		Object[] param = { id };
		List<List<Object>> current = baseDao.BaseQuery(sql, param);
		return current;
	}

	// 修改当季推荐商品
	public int updateColumn(Goods goods) {
		String sql = "update goods set name=?,oldprice=?,newprice=?,start_number=?,unit=?,img=?,product_id=?,puttime=?,type_name=? where id=?";
		Object[] param = { goods.getName(), goods.getOldprice(),
				goods.getNewprice(), goods.getStart_number(), goods.getUnit(),
				goods.getImg(), goods.getProduct_id(), goods.getPuttime(),
				goods.getType_name(), goods.getId() };
		int result = baseDao.BaseUpdate(sql, param);
		return result;
	}

	// 批量删除当季推荐
	public boolean DelBatchColumn(String[] ids) {
		String sql = "delete from goods where id=?";
		boolean success = baseDao.DelBatch(sql, ids);
		return success;
	}

	public void demo1() {
		// 添加当季推荐商品(column_id从前台servlet里面传过来)
		Goods goods = new Goods();
		goods.setName("1ggi2p");
		goods.setOldprice(52.1);
		goods.setNewprice(43.0);
		goods.setProduct_id("aigp21");
		goods.setStart_number(130);
		goods.setType_name("1gpgg");
		goods.setUnit("g");
		goods.setImg("images/4.jpg");
		goods.setPuttime(new Date());
		String column_id = "c4";
		boolean flag = insertColumn(goods, column_id);
		System.out.println(flag);
	}

	public void demo10() {
		// 根据id删除当季推荐（只删除column表的记录，还是商品，但不在这个栏目）
		int id = 64;
		deleteColumnById(id, "c1");
	}

	// 根据id删除当季推荐（只删除column表的记录，还是商品，但不在这个栏目）
	public boolean deleteColumnById(int id, String column_id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		String sql1 = "select product_id from goods where id=?";
		String sql2 = "delete from columns where product_id=? and column_id=?";
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql1);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			String product_id = "";
			if (rs.next()) {
				product_id += rs.getString("product_id");
			}
			Object[] param = { product_id, column_id };
			int result = queryRunner.update(sql2, param);
			if (result == 1) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public void demo2() {
		// 寻找所以当季推荐商品
		List<List<Object>> l = findAllColumn("c1");
		System.out.println(l);
	}

	// 寻找所以当季推荐商品（这里得根据columns表记录查找）----这里要求产品编号唯一（所以产品编号自动生成）
	public List<List<Object>> findAllColumn(String column_id) {
		String sql = "select id,product_id,name,oldprice,newprice,unit,start_number,count from goods where product_id in(select product_id from columns where column_id=?)";
		Object[] param = { column_id };
		List<List<Object>> list = baseDao.BaseQuery(sql, param);
		return list;
	}

	// 根据id查找商品关键字
	public String findKeyWords(int id) {
		String sql = "select keyword from goods where id=?";
		String keyword = baseDao.BaseQuery(sql, id);
		return keyword;
	}

	// 根据id查找商品备注
	public String findRemark(int id) {
		String sql = "select remark from goods where id=?";
		String keyword = baseDao.BaseQuery(sql, id);
		return keyword;
	}

}
