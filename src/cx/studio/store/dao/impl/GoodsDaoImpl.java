package cx.studio.store.dao.impl;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import cx.studio.store.dao.BaseDao;
import cx.studio.store.dao.GoodsDao;
import cx.studio.store.model.Goods;
import cx.studio.store.utils.CodeUtil;

public class GoodsDaoImpl implements GoodsDao {
	BaseDao baseDao = new BaseDaoImpl();

	// 根据id删除商品
	public int deleteGoodsById(int id) {
		String sql = "delete from goods where id=?";
		Object[] param = { id };
		int result = baseDao.BaseUpdate(sql, param);
		return result;
	}

	public void demo9() {
		// 批量删除商品
		String[] ids = { "4", "5", "7" };
		boolean s = BatchDeleteGoods(ids);
		System.out.println(s);
	}

	// 批量删除商品
	public boolean BatchDeleteGoods(String[] ids) {
		String sql = "delete from goods where id=?";
		boolean success = baseDao.DelBatch(sql, ids);
		return success;
	}

	public void demo5() {
		// 查看所有的商品
		List<List<Object>> goods = findAllGoods();
		System.out.println(goods);
	}

	@Test
	public void demo6() {
		// 根据id查找商品详情
		int id = 32;
		List<List<Object>> good = findById(id);
		System.out.println(good);
	}

	public void demo7() {
		// 根据id查找商品关键字
		int id = 4;
		String s = findKeyWords(id);
		System.out.println(s);
	}

	public void demo8() {
		// 根据id查找商品备注
		int id = 31;
		String s = findRemark(id);
		System.out.println(s);
	}

	// 查看所有的商品

	public List<List<Object>> findAllGoods() {
		String sql = "select id,product_id,name,oldprice,newprice,unit,start_number,count from goods";
		List<List<Object>> goods = baseDao.BaseQuery(sql, null);
		return goods;
	}

	// 根据id查找商品详情
	public List<List<Object>> findById(int id) {
		String sql = "select id,img,name,oldprice,newprice,start_number,unit,type_name from goods where id=?";
		Object[] param = { id };
		List<List<Object>> good = baseDao.BaseQuery(sql, param);
		return good;
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

	public void demo1() {
		// 添加商品(除了关键字和备注)
		Goods goods = new Goods();
		goods.setName("D1ssA");
		goods.setOldprice(5.0);
		goods.setNewprice(2.0);
		goods.setProduct_id("lss1soosu");
		goods.setStart_number(1);
		goods.setType_name("class3");
		goods.setUnit("g");
		goods.setImg("images/6.jpg");
		goods.setPuttime(new Date());
		int back = insertGoods(goods);
		System.out.println(back);
	}

	public void demo2() {
		// 添加关键字/修改关键字
		String keyword = "fruit_apple";
		int id = 4;
		int back = insertGoodsKeyword(keyword, id);
		System.out.println(back);
	}

	public void demo3() {
		// 添加备注/修改备注
		String remark = "this is a good apple";
		int id = 4;
		insertGoodsRemark(remark, id);
	}

	public void demo4() {
		// 修改详情
		Goods goods = new Goods();
		goods.setName("xlqsss23");
		goods.setOldprice(2.0);
		goods.setNewprice(3.0);
		goods.setProduct_id("f89ss789");
		goods.setStart_number(1);
		goods.setType_name("class2");
		goods.setUnit("g");
		goods.setImg("images/2.jpg");
		goods.setPuttime(new Date());
		goods.setId(4);
		updateGoods(goods);
	}

	// 添加关键字/修改关键字
	public int insertGoodsKeyword(String keyword, int id) {
		String sql = "update goods set keyword=? where id=?";
		Object[] param = { keyword, id };
		int result = baseDao.BaseUpdate(sql, param);
		return result;
	}

	// 添加备注/修改备注
	public int insertGoodsRemark(String remark, int id) {
		String sql = "update goods set remark=? where id=?";
		Object[] param = { remark, id };
		int result = baseDao.BaseUpdate(sql, param);
		return result;
	}

	// 添加商品(除了备注)
	public int insertGoods(Goods goods) {
		String sql = "insert into goods(name,oldprice,newprice,start_number,count,unit,keyword,img,product_id,puttime,type_name) values(?,?,?,?,?,?,?,?,?,?,?)";
		Object[] param = { goods.getName(), goods.getOldprice(),
				goods.getNewprice(), goods.getStart_number(), 0,
				goods.getUnit(),
				CodeUtil.getKeyWord(goods.getName(), goods.getType_name()),
				goods.getImg(), CodeUtil.getProductId(), goods.getPuttime(),
				goods.getType_name() };
		int result = baseDao.BaseUpdate(sql, param);
		return result;
	}

	// 修改商品详细信息(除了关键字和备注)
	public int updateGoods(Goods goods) {
		String sql = "update goods set name=?,oldprice=?,newprice=?,start_number=?,unit=?,img=?,product_id=?,puttime=?,type_name=? where id=?";
		Object[] param = { goods.getName(), goods.getOldprice(),
				goods.getNewprice(), goods.getStart_number(), goods.getUnit(),
				goods.getImg(), goods.getProduct_id(), goods.getPuttime(),
				goods.getType_name(), goods.getId() };
		int result = baseDao.BaseUpdate(sql, param);
		return result;
	}

	public void demo11() {
		// 条件查询商品
		List<List<Object>> a = search("keyword", "苹果");
		System.out.println(a);
	}

	// 条件查询商品
	public List<List<Object>> search(String colName, String key) {
		String sql = "";
		if ("product_id".equals(colName)) {
			sql = "select id,product_id,name,oldprice,newprice,unit,start_number,count from goods where product_id='"
					+ key + "'";
		} else if ("keyword".equals(colName)) {
			sql = "select id,product_id,name,oldprice,newprice,unit,start_number,count from goods where keyword like '%"
					+ key + "%'";
		} else {
			// 空
			sql = "select id,product_id,name,oldprice,newprice,unit,start_number,count from goods";
		}
		List<List<Object>> list = baseDao.BaseQuery(sql, null);
		return list;
	}
}
