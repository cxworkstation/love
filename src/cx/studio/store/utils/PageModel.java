package cx.studio.store.utils;

import java.util.List;

public class PageModel {
	// 查询结果集
	private List<List<Object>> list;
	// 总记录
	private Long totalCount;
	// 每页显示的记录数
	private int pageSize;
	// 当前是第几条记录
	private int pageOffset;

	public PageModel() {
		this.pageSize = 15;// 默认每页15条记录
	}

	public List<List<Object>> getList() {
		return list;
	}

	public void setList(List<List<Object>> list) {
		this.list = list;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageOffset() {
		return pageOffset;
	}

	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}

}
