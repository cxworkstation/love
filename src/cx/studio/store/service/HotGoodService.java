package cx.studio.store.service;

import java.util.List;

public interface HotGoodService {
	public List<List<Object>> getAllHotGood(int n);

	public List<List<Object>> getTrueGood(String colName, String key);

}
