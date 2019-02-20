package com.gdpi.maker.dao;

import com.gdpi.maker.pojo.Forumimg;
import com.gdpi.maker.pojo.Result;

import java.util.List;


public interface ForumImgDao {
	/**
	 * 添加图片
	 * @param forumimg
	 * @return
	 */
	int insertForumimg(Forumimg forumimg);
	/**
	 * 删除图片
	 * @param forumimgId
	 * @return
	 */
	int deleteForumimg(String forumimgId);
	/**
	 * 修改图片信息
	 * @param forumimg
	 * @return
	 */
	int updateForumimg(Forumimg forumimg);

    /**
     *
	 * @param forumimg
     * @return
     */
	List<Forumimg> selectForumimg(Forumimg forumimg);
	/**
	 * 查询一个信息
	 * @param forumimgId
	 * @return
	 */
	Forumimg selectForumimgById(String forumimgId);

}
