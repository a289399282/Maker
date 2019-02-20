package com.gdpi.maker.service;

import com.gdpi.maker.pojo.Result;
import com.gdpi.maker.pojo.Type;


public interface TypeService{
	/**
	 * 添加类型
	 * @param type
	 * @return
	 */
	Result insertType(Type type);
	/**
	 * 删除类型
	 * @param typeId
	 * @return
	 */
	Result deleteType(String typeId);
	/**
	 * 修改
	 * @param type
	 * @return
	 */
	Result updateType(Type type);
	/**
	 * 查询
	 * @param type
	 * @return
	 */
	Result selectType(Type type,int fenye);
	/**
	 * 查询一个信息
	 * @param typeId
	 * @return
	 */
	Type selectTypeById(String typeId);
	
	/**
	 * 查询数目
	 * @param type
	 * @return
	 */
	Result countByExample(Type type);
}
