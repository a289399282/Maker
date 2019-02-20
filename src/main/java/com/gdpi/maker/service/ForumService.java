package com.gdpi.maker.service;

import com.gdpi.maker.pojo.Forum;
import com.gdpi.maker.pojo.ForumWithBLOBs;
import com.gdpi.maker.pojo.Result;

public interface ForumService {
	/**
	 * 添加文字作品
	 * @param forumWithBLOBs 作品文字信息
	 * @return
	 */
	Result addForum(ForumWithBLOBs forumWithBLOBs);
	/**
	 * 添加视频作品
	 * @param forumWithBLOBs 视频作品信息
	 * @return
	 */
	//Result addForumVideo(MultipartFile[] video,ForumWithBLOBs forumWithBLOBs);
	Result addForumVideo(ForumWithBLOBs forumWithBLOBs);
	/**
	 * 删除作品
	 * @param forumId 作品Id
	 * @return
	 */
	Result deleteForum(String forumId);

	/**
	 * 查询信息
	 * @param forumWithBLOBs 需要查询的条件信息
	 * @param fenye 页码数
	 * @param pageSize 一页显示几条数据
	 * @return
	 */
	Result selectForum(ForumWithBLOBs  forumWithBLOBs,Integer fenye,Integer pageSize);
	
	/**
	 * 查询一个作品
	 * @param forum
	 * @return
	 */
	//Result selectOneForum(Forum forum);
	
	/**
	 * 根据Id查询作品
	 * @param forumId 作品Id
	 * @return
	 */
	Result selectByPrimaryKey(String forumId);
	
	/**
	 * 修改作品信息
	 * @param forumWithBLOBs 需要修改的作品信息
	 * @return
	 */
	Result updateForum(ForumWithBLOBs forumWithBLOBs);
	/**
	 * 修改作品状态
	 * @param forumWithBLOBs
	 * @return
	 */
	Result updateForumStart(ForumWithBLOBs forumWithBLOBs);

	/**
	 * 批量修改作品状态
	 * @param forumIdList 作品Id的List
	 * @param devId 作者
	 * @return
	 */
	Result updateForumListStart(String[] forumIdList, String devId);
	/**
	 * 根据作品Id查询
	 * @param forumId
	 * @return
	 */
	//Result countByExample(Forum forum);
	ForumWithBLOBs selectForumById(String forumId);

	/**
	 * 查询Forum排行版
	 * @param forumWithBLOBs
	 * @return
	 */
	Result ranKingsForum(ForumWithBLOBs forumWithBLOBs,Integer fenye,Integer pageSize);
	
}
