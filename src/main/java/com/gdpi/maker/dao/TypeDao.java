package com.gdpi.maker.dao;

import java.util.List;

import com.gdpi.maker.pojo.Type;


public interface TypeDao{
	/**
	 * 添加类型
	 * @param type
	 * @return
	 */
	int insertType(Type type);
	/**
	 * 删除类型
	 * @param typeId
	 * @return
	 */
	int deleteType(String typeId);
	/**
	 * 修改
	 * @param type
	 * @return
	 */
	int updateType(Type type);
	/**
	 * 查询
	 * @param type
	 * @return
	 */
	List<Type> selectType(Type type);
	/**
	 * 查询一个信息
	 * @param type
	 * @return
	 */
	Type selectTypeById(String typeId);
	
	/**
	 * 查询数目
	 * @param type
	 * @return
	 */
	int countByExample(Type type);
}
