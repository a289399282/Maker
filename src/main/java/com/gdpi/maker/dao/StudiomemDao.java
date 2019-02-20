package com.gdpi.maker.dao;

import java.util.List;

import com.gdpi.maker.pojo.Studiomem;

public interface StudiomemDao {
	/**
	 * 添加工作室成员
	 * @param studiomem
	 * @return
	 */
	int insertStudiomem(Studiomem studiomem);
	/**
	 * 删除工作室成员
	 * @param
	 * @return
	 */
	int deleteStudiomem(String stuId,String devId);
	/**
	 * 修改工作室成员的权限
	 * @param studiomem
	 * @return
	 */
	int updateStudiomem(Studiomem studiomem);
	Studiomem selectOneStudiomem(Studiomem studiomem);
	/**
	 * 查询全部工作室成员情况
	 * @param studiomem 工作室Id
	 * @return
	 */
	List<Studiomem> selectStudiomemAll(Studiomem studiomem);
	/**
	 * 查询工作室成员
	 * @param studiomem
	 * @return
	 */
	//List<Studiomem> selectStudiomem(Studiomem studiomem);
	/**
	 * 查询工作室成员
	 * @param studiomem
	 * @return
	 */
	List<Studiomem> selectStudiomemMe(Studiomem studiomem);
	/**
	 * 根据工作室Id和申请人Id,标志 查询已经成为工作室成员的人员
	 * @param studiomem 工作室Id
	 * @return
	 */

}
