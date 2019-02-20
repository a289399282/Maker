package com.gdpi.maker.service;

import com.gdpi.maker.pojo.Developer;
import com.gdpi.maker.pojo.Result;


public interface DeveloperService {
	/**
	 * 添加Developer开发人员信息
	 * @param developer 开发人员信息
	 * @return
	 */
	Result insertDeveloper(Developer developer);

	/**
	 * 根据主键id删除开发人员
	 * @param devId 主键id
	 * @return
	 */
	Result deleteDeveloper(String devId);

	/**
	 * 根据主键id更改开发人员信息
	 * @param developer 需要改的用户信息
	 * @return
	 */
	Result updateDeveloper(Developer developer);

	/**
	 * 注销账户
	 * @param devId 需要注销的开发人员id
	 * @param devPassword 密码
	 * @return
	 */
	Result cantDev(String devId,String devPassword);

	/**
	 * 修改用户ID
	 * @param developer 需要验证身份的信息
	 * @param developerId 更改后的Id
	 * @return
	 */
	Result updateDeveloperId(Developer developer,String developerId);

	/**
	 * 可以根据前端传来的开发人员各种条件来查询开发人员
	 * @param developer 需要查询的用户信息
	 * @param fenye 页码数
	 * @param pageSize 一页几条数据
	 * @return
	 */
	Result selectDeveloper(Developer developer, Integer fenye,Integer pageSize);
	
	/**
	 * 查询一个开发人员信息
	 * @param developer 开发人员信息
	 * @return 
	 */
	//Result selectOneDeveloper(Developer developer);

	/**
	 * 根据用户Id查询信息
	 * @param devId 用户ID
	 * @return
	 */
	Result selectDeveloperById(String devId);

	/**
	 * 登录
	 * @param developer 需要验证身份的信息
	 * @return
	 */
	Result loginDev(Developer developer);

	/**
	 * 排行版
	 * @param developer
	 * @return
	 */
	Result rankingsDev(Developer developer);
	/**
	 * 排行版
	 * @param developer
	 * @return
	 */
	Result rankingsDev2(Developer developer, Integer fenye,Integer pageSize);


	/**
	 * 根据Id查找用户信息
	 * @param devId 用户Id
	 * @return Developer
	 */
	Developer selectDevById(String devId);

	/**
	 * 查询一个用户信息
	 * @param developer
	 * @return
	 */
	Developer selectOneDeveloper(Developer developer);

}
