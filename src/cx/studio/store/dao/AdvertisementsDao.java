package cx.studio.store.dao;

import java.util.List;

public interface AdvertisementsDao {
	// 添加广告
	public int addAdv();

	// 删除广告
	public int delAdv();

	// 修改广告
	public int updateAdv();

	// 查询广告
	public List<List<Object>> selectAdv();
}
