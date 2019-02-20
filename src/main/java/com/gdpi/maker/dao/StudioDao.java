package com.gdpi.maker.dao;

import java.util.List;

import com.gdpi.maker.pojo.Studio;

public interface StudioDao {

	/**
	 * 添加工作室信息
	 * @param studio
	 * @return
	 */
	int insertStudio(Studio studio);
	
	/**
	 * 删除工作室信息
	 * @param stuId
	 * @return
	 */
	int deleteStudio(String stuId);
	
	/**
	 * 修改工作室信息
	 * @param studio
	 * @return
	 */
	int updateStudio(Studio studio);
	
	/**
	 * 查询工作室信息
	 * @param studio
	 * @return
	 */
	List<Studio> selectStudio(Studio studio);
	/**
	 * 查询一个工作室信息
	 * @param studio
	 * @return
	 */
	//Studio selectOneStudio(Studio studio);
	/**
	 * 根据Id查询
	 * @param stuId
	 * @return
	 */
	Studio selectStudioById(String stuId);
	/**
	 * 查找未注销的工作室
	 * @param stuId
	 * @return
	 */
	Studio selectStuByIdExist(String stuId);

}
