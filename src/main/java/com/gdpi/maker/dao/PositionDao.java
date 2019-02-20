package com.gdpi.maker.dao;

import java.util.List;

import com.gdpi.maker.pojo.Position;

public interface PositionDao {
	/**
	 * 算总数
	 * @param position
	 * @return
	 */
	int countByExample(Position position);
	/**
	 * 添加职位
	 * @param position
	 * @return
	 */
	int insertPosition(Position position);
	/**
	 * 删除职位
	 * @param positionId
	 * @return
	 */
	int deletePosition(String positionId);
	/**
	 * 
	 * @param position
	 * @return
	 */
	int updatePosition(Position position);
	/**
	 * 查询职位信息
	 * @param position
	 * @return
	 */
	List<Position> selectPosition(Position position);
	/**
	 * 查询一个职位信息
	 * @param position
	 * @return
	 */
	Position selectOnePosition(Position position);
	/**
	 * 根据Id查询
	 * @param positionId
	 * @return
	 */
	Position selectPositionById(String positionId);
	/**
	 * 根据Id查找未结束的职位信息
	 * @param positionId
	 * @return
	 */
	Position selectPosByIdExist(String positionId);
}
