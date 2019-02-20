package com.gdpi.maker.dao;

import java.util.List;

import com.gdpi.maker.pojo.Forum;
import com.gdpi.maker.pojo.ForumWithBLOBs;

public interface ForumDao {
	/**
	 * 添加作品
	 * @param forumWithBLOBs 需要添加的作品信息
	 * @return
	 */
	int addForum(ForumWithBLOBs forumWithBLOBs);

	/**
	 * 根据作品Id删除作品
	 * @param forumId 作品Id
	 * @return
	 */
	int deleteForum(String forumId);

	/**
	 * 查询作品
	 * @param forumWithBLOBs 需要查询的条件信息
	 * @return
	 */
	List<ForumWithBLOBs> selectForum(ForumWithBLOBs forumWithBLOBs);
	
	/**
	 * 查询一个作品
	 * @param forum 需要查询的条件信息
	 * @return
	 */
	ForumWithBLOBs selectOneForum(Forum forum);

	/**
	 * 根据Id查询作品
	 * @param forumId 作品Id
	 * @return
	 */
	ForumWithBLOBs selectByPrimaryKey(String forumId);

	/**
	 * 根据作品Id修改作品信息
	 * @param forumWithBLOBs 修改的信息
	 * @return
	 */
	int updateForum(ForumWithBLOBs forumWithBLOBs);
	
	/**
	 * 根据信息查询,返回符合信息的数据的条数
	 * @param forum
	 * @return
	 */
	int countByExample(Forum forum);
}
