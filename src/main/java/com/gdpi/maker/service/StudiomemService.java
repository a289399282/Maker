package com.gdpi.maker.service;

import com.gdpi.maker.pojo.Result;
import com.gdpi.maker.pojo.Studiomem;
import org.apache.poi.util.LittleEndianOutputStream;

import java.util.List;

public interface StudiomemService {

	/**
	 * 申请加入工作室
	 * @param stuId 工作室Id
	 * @param devId 用户Id
	 * @return
	 */
	Result insertStudiomem(String stuId, String devId);

	/**
	 * 删除申请工作室记录
	 * @param stuId 工作室Id
	 * @param devId 用户Id
	 * @return
	 */
	Result deleteStudiomem(String stuId, String devId);

	/**
	 * 修改申请状态
	 * @param studiomem
	 * @return
	 */
	Result updateStudiomem(Studiomem studiomem);

	/**
	 * 公共查询工作室申请信息
	 * @param studiomem 查询条件
	 * @param fenye
	 * @param pageSize
	 * @return
	 */
	Result selectStudiomem(Studiomem studiomem,Integer fenye,Integer pageSize);

	/**
	 *私人查询工作室申请信息
	 * @param studiomem 查询条件
	 * @param fenye
	 * @param pageSize
	 * @return
	 */
	Result selectStudiomem2(Studiomem studiomem,Integer fenye,Integer pageSize);

	/**
	 * 根据工作室Id和申请人Id查询已经成为工作室成员的人员
	 * @param stuId 工作室Id
	 * @param devId 申请人Id
	 * @return
	 */
	Studiomem selectStudiomem2(String stuId, String devId);
	/**
	 * 根据工作室Id和申请人Id查询未成为工作室成员的人员
	 * @param stuId 工作室Id
	 * @param devId 申请人Id
	 * @return
	 */
	Studiomem selectStudiomem3(String stuId, String devId);
	/**
	 * 根据工作室Id和申请人Id,标志 查询已经成为工作室成员的人员
	 * @param studiomem 工作室Id
	 * @return
	 */
	Studiomem selectOneStudiomem(Studiomem studiomem);
	/**
	 * 查询工作室成员情况
	 * @param studiomem 工作室Id
	 * @return
	 */
	List<Studiomem> selectStudiomem(Studiomem studiomem);
}
