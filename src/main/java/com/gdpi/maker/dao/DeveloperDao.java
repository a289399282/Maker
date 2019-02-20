package com.gdpi.maker.dao;

import java.util.List;

import com.gdpi.maker.pojo.Developer;

public interface DeveloperDao{
	
	/**
	 * 添加Developer开发人员信息
	 * @param developer 开发人员信息
	 * @return
	 */
	int insertDeveloper(Developer developer);
	
	/**
	 * 根据主键id删除开发人员
	 * @param devId 主键id
	 * @return
	 */
	int deleteDeveloper(String devId);

	/**
	 * 根据主键id更改开发人员信息
	 * @param developer 开发人员信息
	 * @return
	 */
	int updateDeveloper(Developer developer);

	/**
	 *
	 * @param developer
	 * @return
	 */
	int updateByExampleSelective(Developer developer,String developerId);

	/**
	 * 根据开发人员各种条件来查询
	 * @param developer 开发人员信息
	 * @return
	 */
	List<Developer> selectDeveloper(Developer developer);

	/**
	 * 根据开发人员Id查询
	 * @param devId 开发人员Id
	 * @return
	 */
	Developer selectDeveloperById(String devId);

	/**
	 * 查询一个开发人员信息
	 * @param developer 开发人员信息
	 * @return 
	 */
	Developer selectOneDeveloper(Developer developer);

	/**
	 * 根据Id查找不注销的用户
	 * @param devId
	 * @return
	 */
	Developer selectDevByIdExist(String devId);
	/**
	 * 根据信息查询,返回符合信息的总数
	 * @param developer 要查询的信息
	 * @return 信息的总数
	 */
	int countDevelpor(Developer developer);
}
