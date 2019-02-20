package com.gdpi.maker.service;

import com.gdpi.maker.pojo.Forumimg;
import com.gdpi.maker.pojo.Result;
import com.gdpi.maker.pojo.Type;


public interface ForumImgService {
	/**
	 * 添加图片
	 * @param forumimg
	 * @return
	 */
	Result insertForumimg(Forumimg forumimg);
	/**
	 * 删除图片
	 * @param forumimgId
	 * @return
	 */
	Result deleteForumimg(String forumimgId);
	/**
	 * 修改图片信息
	 * @param forumimg
	 * @return
	 */
	Result updateForumimg(Forumimg forumimg);

	/**
	 *
	 * @param forumimg
	 * @return
	 */
	Result selectForumimg(Forumimg forumimg);
	/**
	 * 查询一个信息
	 * @param forumimgId
	 * @return
	 */
	//Type selectTypeById(String forumimgId);

}
