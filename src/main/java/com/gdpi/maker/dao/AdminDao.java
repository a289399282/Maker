package com.gdpi.maker.dao;

import com.gdpi.maker.pojo.Admin;
import com.gdpi.maker.pojo.Developer;

import java.util.List;

public interface AdminDao {

	/**
	 * 添加管理人员信息
	 * @param admin 开发人员信息
	 * @return
	 */
	int insertDeveloper(Admin admin);

	/**
	 * 根据主键id删除管理人员
	 * @param adminId 主键id
	 * @return
	 */
	int deleteAdmin(String adminId);

	/**
	 * 根据主键id更改管理人员信息
	 * @param admin 管理人员信息
	 * @return
	 */
	int updateAdmin(Admin admin);

	/**
	 *
	 * @param developer
	 * @return
	 */
	int updateByExampleSelective(Developer developer, String developerId);

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
