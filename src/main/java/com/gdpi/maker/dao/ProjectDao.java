package com.gdpi.maker.dao;

import java.util.List;

import com.gdpi.maker.pojo.Project;

public interface ProjectDao {
	/**
	 * 添加project信息
	 * @param project
	 * @return
	 */
	int insertProject(Project project);
	/**
	 * 删除project信息
	 * @param
	 * @return
	 */
	int deleteProject(String proId);
	/**
	 * 修改project信息
	 * @param project
	 * @return
	 */
	int updateProject(Project project);
	/**
	 * 查询project信息
	 * @param project
	 * @return
	 */
	List<Project> selectProjectMe(Project project,Double money1,Double money2);
	/**
	 * 查询project信息
	 * @param project
	 * @return
	 */
	List<Project> selectProjectAll(Project project,Double money1,Double money2);
	/**
	 * 查找一个项目信息
	 * @param proId
	 * @return
	 */
	Project selectByPrimaryKey(String proId);
	/**
	 * 查找一个项目信息
	 * @param 
	 * @return
	 */
	//Project selectOneProject(Project project);
}
