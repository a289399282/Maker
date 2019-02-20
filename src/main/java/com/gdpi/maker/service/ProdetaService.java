package com.gdpi.maker.service;

import com.gdpi.maker.pojo.Prodeta;
import com.gdpi.maker.pojo.Result;

public interface ProdetaService {
	/**
	 * 添加项目订单信息
	 * @param proId 项目Id
	 * @param prdeIswin 成功人Id
	 * @return
	 */
	Result insertPrde(String proId,String prdeIswin);
	/**
	 * 删除项目订单信息
	 * @param proId 项目Id
	 * @param prdeIswin 成功人Id
	 * @return
	 */
	Result deletePrde(String proId,String prdeIswin);
	/**
	 * 更改项目订单信息
	 * @param prodeta 修改项目订单的信息
	 * @return
	 */
	Result updatePrde(Prodeta prodeta);
	/**
	 * 查询项目订单信息
	 * @param prodeta 查询条件
	 * @param fenye 页码数
	 * @param pageSize
	 * @return
	 */
	Result selectPrde(Prodeta prodeta, Integer fenye, Integer pageSize);
}
