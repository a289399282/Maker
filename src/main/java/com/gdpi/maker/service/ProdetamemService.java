package com.gdpi.maker.service;

import com.gdpi.maker.pojo.Prodetamem;
import com.gdpi.maker.pojo.Result;

public interface ProdetamemService {
	/**
	 * 添加prodetamem 项目的参加竞标人员（工作室）
	 * @param proId 项目Id
	 * @param prdememId 参加竞选的开发人员或工作室Id
	 * @return
	 */
	Result insertProdetamem(String proId,String prdememId);
	/**
	 * 删除prodetamem 项目的参加竞标人员（工作室）
	 * @param prodetamem 条件
	 * @return
	 */
	Result deleteProdetamem(Prodetamem prodetamem);

	/**
	 * 修改prodetamem 项目的参加竞标人员（工作室）是否竞标成功(1只是表示参加,2成功,3退出竞标)
	 * @param prodetamem 修改信息
	 * @return
	 */
	Result updateProdetamem(Prodetamem prodetamem);

	/**
	 * 查询prodetamem 项目的参加竞标人员（工作室）信息
	 * @param prodetamem 查询条件
	 * @param fenye
	 * @param pageSize
	 * @return
	 */
	Result selectProdetamem(Prodetamem prodetamem, Integer fenye, Integer pageSize);

	/**
	 * 查询一条状态为1的记录
	 * @param proId
	 * @param prdememId
	 * @return
	 */
    Prodetamem selectProdetamem2(String proId, String prdememId);

}
