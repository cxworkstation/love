package cx.studio.store.dao;

import java.util.List;

import cx.studio.store.model.Messages;

public interface MessageDao {
	// 回复留言
	public int AnswerMessage(Messages message);

	// 删除留言
	public int deleteMesssage(int id);

	// 查询未回复留言
	public List<List<Object>> checkMessage(int state);

	// 查看留言
	public List<List<Object>> checkAllMessage();
}
