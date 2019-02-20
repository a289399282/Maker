package com.gdpi.maker.service;

import com.gdpi.maker.pojo.Project;
import com.gdpi.maker.pojo.Result;

public interface ProjectService {
	/**
	 * 添加project信息
	 * @param project
	 * @return
	 */
	Result insertProject(Project project);
	/**
	 * 删除project信息
	 * @param proId 项目Id
	 * @return
	 */
	Result deleteProject(String proId);
	/**
	 * 修改project信息
	 * @param project 修改的项目信息
	 * @return
	 */
	Result updateProject(Project project);

    /**
     * 批量删除project信息
     * @param proIdList 项目Id集合
	 * @param proPublisher 项目的发布人
     * @return
     */
    Result updateProjectListStart(String[] proIdList,String proPublisher);
	/**
	 * 查询私人project信息
	 * @param project 项目查询条件
	 * @param money1 钱的范围1
	 * @param money2 钱的范围2
	 * @param fenye 页码数
	 * @return pageSize
	 */
	Result selectProjectMe(Project project,Double money1,Double money2,Integer fenye,Integer pageSize);
	/**
	 * 公共查询project信息
	 * @param project 项目查询条件
	 * @param money1 钱的范围1
	 * @param money2 钱的范围2
	 * @param fenye 页码数
	 * @return pageSize
	 */
	Result selectProjectAll(Project project, Double money1, Double money2, Integer fenye, Integer pageSize);
	/**
	 * 根据Id查询project信息
	 * @param
	 * @return
	 */
	Project selectProjectById(String proId);

	/**
	 * 更新热度
	 * @param proId
	 * @param heat
	 * @return
	 */
	int updateProjectHeat(String proId,Integer heat);
}
