package com.gdpi.maker.dao;

import java.util.List;
import com.gdpi.maker.pojo.Positionmem;

public interface PositionmemDao {
	/**
	 * 添加职位
	 * @param positionmem
	 * @return
	 */
	int insertPositionmem(Positionmem positionmem);
	/**
	 * 删除职位
	 * @param positionId
	 * @return
	 */
	int deletePositionmem(String positionId,String positionmenId);
	/**
	 * 修改申请职位信息
	 * @param positionmem
	 * @return
	 */
	int updatePositionnem(Positionmem positionmem);
	/**
	 * 查询职位信息
	 * @param positionmem
	 * @return
	 */
	List<Positionmem> selectPositionmem(Positionmem positionmem);
	/**
	 * 查询一个职位信息
	 * @param positionmem
	 * @return
	 */
	Positionmem selectOnePositionmem(Positionmem positionmem);
	/**
	 * 查询一个职位信息
	 * @param positionmemId 用户Id
	 * @param positionId 职位Id
	 * @return
	 */
	Positionmem selectPositionmemById(String positionId, String positionmemId);

}
