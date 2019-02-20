package com.gdpi.maker.service;

import com.gdpi.maker.pojo.Position;
import com.gdpi.maker.pojo.Result;

public interface PositionService {
	/**
	 * 添加职位
	 * @param position
	 * @return
	 */
	Result insertPosition(Position position);
	/**
	 * 删除职位
	 * @param positionId
	 * @return
	 */
	Result deletePosition(String positionId);
	/**
	 * 修改
	 * @param position
	 * @return
	 */
	Result updatePosition(Position position);
	/**
	 * 查询职位信息
	 * @param position
	 * @param fenye
	 * @return
	 */
	Result selectPosition(Position position, Integer fenye,Integer pageSize);
	/**
	 * 查询一个职位信息
	 * @param position
	 * @return
	 */
	Result selectOnePosition(Position position);
	/**
	 * 根据Id查询
	 * @param positionId
	 * @return
	 */
	Result selectPositionById(String positionId);
	/**
	 * 根据Id查询
	 * @param positionId
	 * @return
	 */
	Position selectPositionById2(String positionId);
	/**
	 * 根据Id查询
	 * @param positionId
	 * @return
	 */
	//Position selectPositionById2(String positionId);
	/**
	 * 排行版
	 * @param position
	 * @param fenye
	 * @return
	 */
	Result rankingsPos(Position position, Integer fenye,Integer pageSize);

}
