package com.gdpi.maker.service;

import com.gdpi.maker.pojo.Result;
import com.gdpi.maker.pojo.Studio;

import java.text.ParseException;

public interface StudioService {
	/**
	 * 添加工作室
	 * @param studio 工作室信息
	 * @return
	 * @throws ParseException
	 */
	Result insertStudio(Studio studio) throws ParseException;

	/**
	 * 删除工作室
	 * @param stuId 工作室Id
	 * @return
	 */
	Result deleteStudio(String stuId);

	/**
	 * 修改工作室信息
	 * @param studio
	 * @return
	 */
	Result updateStudio(Studio studio);

	/**
	 * 条件查询工作室
	 * @param studio 工作室条件
	 * @param fenye 页码数
	 * @param pageSize
	 * @return
	 */
	Result selectStudio(Studio studio,Integer fenye,Integer pageSize);

	/**
	 * 排行版
	 * @param studio
	 * @return
	 */
	Result RankingsStu(Studio studio,Integer fenye,Integer pageSize);
	/**
	 * 根据Id查找未注销的工作室
	 * @param
	 * @return
	 */
	Studio selectStudioByIdExist(String stuId);

	/**
	 * 根据Id查找工作室
	 * @param
	 * @return
	 */
	Studio selectStudioById(String stuId);
}
