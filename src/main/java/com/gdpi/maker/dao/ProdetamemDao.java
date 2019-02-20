package com.gdpi.maker.dao;

import java.util.List;

import com.gdpi.maker.pojo.Prodetamem;

public interface ProdetamemDao {
	/**
	 * 添加prodetamem 项目的参加竞标人员（工作室）
	 * @param prodetamem 添加信息
	 * @return
	 */
	int insertProdetamem(Prodetamem prodetamem);
	/**
	 * 删除prodetamem 项目的参加竞标人员（工作室）
	 * @param prodetamem 条件信息
	 * @return
	 */
	int deleteProdetamem(Prodetamem prodetamem);

	/**
	 * 修改prodetamem 项目的参加竞标人员（工作室）是否竞标成功(1只是表示参加,2成功,3退出竞标)
	 * @param prodetamem 修改信息
	 * @return
	 */
	int updateProdetamem(Prodetamem prodetamem);

	/**
	 * 查询prodetamem 项目的参加竞标人员（工作室）信息
	 * @param prodetamem 查询条件
	 * @return
	 */
	List<Prodetamem> selectProdetamem(Prodetamem prodetamem);
	/**
	 * 查询一条状态为1的记录
	 * @param prodetamem
	 * @return
	 */
	Prodetamem selectOneProdetamem(Prodetamem prodetamem);
	/**
	 * 查询一条记录
	 * @param prodetamem
	 * @return
	 */
	Prodetamem selectOneProdetamem2(Prodetamem prodetamem);
}
