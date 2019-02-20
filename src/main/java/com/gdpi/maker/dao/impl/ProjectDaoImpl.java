package com.gdpi.maker.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gdpi.maker.dao.ProjectDao;
import com.gdpi.maker.mapper.ProjectMapper;
import com.gdpi.maker.pojo.Project;
import com.gdpi.maker.pojo.ProjectExample;
import com.gdpi.maker.pojo.ProjectExample.Criteria;

@SuppressWarnings("Duplicates")
@Repository
public class ProjectDaoImpl implements ProjectDao {
	@Autowired
	private ProjectMapper projectMapper;

	@Override
	public int insertProject(Project project) {
		return projectMapper.insertSelective(project);
	}

	@Override
	public int deleteProject(String proId) {
		return projectMapper.deleteByPrimaryKey(proId);
	}

	@Override
	public int updateProject(Project project) {
		return projectMapper.updateByPrimaryKeySelective(project);	
	}

	@Override
	public List<Project> selectProjectMe(Project project,Double money1,Double money2) {
			
			ProjectExample projectExample=new ProjectExample();
			Criteria criteria=projectExample.createCriteria();
			
			//如果钱1为空,钱2有值,则按 少于钱2查
			if((money1 == null || money1 ==0) && (money2 != null && money2!=0)){
				criteria.andProMoneyLessThanOrEqualTo(money2);
			}
			
			//如果钱2为空,钱1有值,则按 多于钱1查
			if((money2 == null || money2 ==0) && (money1 != null && money1!=0)){
				criteria.andProMoneyGreaterThanOrEqualTo(money1);
			}
			
			//如果钱2有值,钱1有值,则按 多于钱1,少于钱2查
			if((money2 != null && money2!=0) && (money1 != null && money1!=0)){
				criteria.andProMoneyBetween(money1,money2);
			}

			//按标题名来模糊查询
			if(project.getProName()!=null && project.getProName().length()!=0){
				criteria.andProNameLike("%"+project.getProName()+"%");
			}

			//根据项目发布人姓名查询
			if(project.getProPubname()!=null && project.getProPubname().length()!=0){
				criteria.andProPubnameLike("%"+project.getProPubname()+"%");
			}
			//根据项目类型查询
			if(project.getProType()!=null && project.getProType().length()!=0){
				criteria.andProTypeLike("%"+project.getProType()+"%");
			}
			//根据发布项目的城市查询
			if(project.getProCity() !=null && project.getProCity().length()!=0){
				criteria.andProCityLike("%"+project.getProCity()+"%");
			}

			//根据项目的状态查询
			if(project.getProState() != null){
				criteria.andProStateEqualTo(project.getProState());
			}else {
				criteria.andProStateNotEqualTo(6);
			}
			//升降排序
			if ( project.getOrderByClause()!= null) {
				Integer OrderByClause = project.getOrderByClause();
				switch (OrderByClause){
					case 1:
						projectExample.setOrderByClause("pro_money ASC");
						break;
					case 2:
						projectExample.setOrderByClause("pro_money DESC");
						break;
					case 3:
						projectExample.setOrderByClause("pro_heat ASC");
						break;
					case 4:
						projectExample.setOrderByClause("pro_heat DESC");
						break;
					case 5:
						projectExample.setOrderByClause("pro_endtime ASC");
						break;
					case 6:
						projectExample.setOrderByClause("pro_endtime DESC");
						break;
					case 7:
						projectExample.setOrderByClause("pro_reltime ASC");
						break;
					case 8:
						projectExample.setOrderByClause("pro_reltime DESC");
						break;
					case 9:
						projectExample.setOrderByClause("pro_foutime ASC");
						break;
					case 10:
						projectExample.setOrderByClause("pro_foutime DESC");
						break;
				}
			}

			return projectMapper.selectByExampleWithBLOBs(projectExample);		
	}
	@Override
	public List<Project> selectProjectAll(Project project,Double money1,Double money2) {

		ProjectExample projectExample=new ProjectExample();
		Criteria criteria=projectExample.createCriteria();

		//如果钱1为空,钱2有值,则按 少于钱2查
		if((money1 == null || money1 ==0) && (money2 != null && money2!=0)){
			criteria.andProMoneyLessThanOrEqualTo(money2);
		}

		//如果钱2为空,钱1有值,则按 多于钱1查
		if((money2 == null || money2 ==0) && (money1 != null && money1!=0)){
			criteria.andProMoneyGreaterThanOrEqualTo(money1);
		}

		//如果钱2有值,钱1有值,则按 多于钱1,少于钱2查
		if((money2 != null && money2!=0) && (money1 != null && money1!=0)){
			criteria.andProMoneyBetween(money1,money2);
		}

		//按标题名来模糊查询
		if(project.getProName()!=null && project.getProName().length()!=0){
			criteria.andProNameLike("%"+project.getProName()+"%");
		}

		//根据项目发布人姓名查询
		if(project.getProPubname()!=null && project.getProPubname().length()!=0){
			criteria.andProPubnameLike("%"+project.getProPubname()+"%");
		}

		//根据项目类型查询
		if(project.getProType()!=null && project.getProType().length()!=0){
			criteria.andProTypeLike("%"+project.getProType()+"%");
		}
		//根据发布项目的城市查询
		if(project.getProCity() !=null && project.getProCity().length()!=0){
			criteria.andProCityLike("%"+project.getProCity()+"%");
		}
		//升降排序
		if ( project.getOrderByClause()!= null) {
			Integer OrderByClause = project.getOrderByClause();

			switch (OrderByClause){
				//钱
				case 1:
					projectExample.setOrderByClause("pro_money ASC");
					break;
				case 2:
					projectExample.setOrderByClause("pro_money DESC");
					break;
					//热度
				case 3:
					projectExample.setOrderByClause("pro_heat ASC");
					break;
				case 4:
					projectExample.setOrderByClause("pro_heat DESC");
					break;
					//结束时间
				case 5:
					projectExample.setOrderByClause("pro_endtime ASC");
					break;
				case 6:
					projectExample.setOrderByClause("pro_endtime DESC");
					break;
					//发布时间
				case 7:
					projectExample.setOrderByClause("pro_reltime ASC");
					break;
				case 8:
					projectExample.setOrderByClause("pro_reltime DESC");
					break;
					//创建时间
				case 9:
					projectExample.setOrderByClause("pro_foutime ASC");
					break;
				case 10:
					projectExample.setOrderByClause("pro_foutime DESC");
					break;
			}
		}
		//根据项目的状态查询
		criteria.andProStateBetween(1,5);

		return projectMapper.selectByExampleWithBLOBs(projectExample);
	}
	@Override
	public Project selectByPrimaryKey(String proId) {
		return projectMapper.selectByPrimaryKey(proId);
	}

	/*@Override
	public Project selectOneProject(Project project) {
		return projectMapper.selectOneProject(project);
	}*/

}
