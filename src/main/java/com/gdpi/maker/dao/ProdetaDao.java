package com.gdpi.maker.dao;

import java.util.List;

import com.gdpi.maker.pojo.Prodeta;

public interface ProdetaDao {
	/**
	 * 添加项目订单信息
	 * @param proId
	 * @param isWin
	 * @return
	 */
	int insertPrde(String proId,String prdeIswin);
	/**
	 * 删除项目订单信息
	 * @param proId
	 * @param isWin
	 * @return
	 */
	int deletePrde(String proId,String prdeIswin);
	/**
	 * 更改项目订单信息
	 * @param prodeta
	 * @return
	 */
	int updatePrde(Prodeta prodeta);
	/**
	 * 查询项目订单信息
	 * @param prodeta
	 * @return
	 */
	List<Prodeta> selectPrde(Prodeta prodeta);
	/**
	 * 查询一个信息
	 * @param prodeta
	 * @return
	 */
	Prodeta selectOneProdeta(Prodeta prodeta);
}
