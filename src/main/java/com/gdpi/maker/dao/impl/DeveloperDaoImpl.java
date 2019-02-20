package com.gdpi.maker.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gdpi.maker.dao.DeveloperDao;
import com.gdpi.maker.mapper.DeveloperMapper;
import com.gdpi.maker.pojo.Developer;
import com.gdpi.maker.pojo.DeveloperExample;
import com.gdpi.maker.pojo.DeveloperExample.Criteria;


/**
 * 开发人员的daoImpl
 * 
 * @author xu
 * 
 */
@Repository
public class DeveloperDaoImpl implements DeveloperDao {
	@Autowired
	private DeveloperMapper developerMapper;
	
	/**
	 * 添加Developer功能
	 */
	@Override
	public int insertDeveloper(Developer developer) {
		return developerMapper.insertSelective(developer);
	}
	
	/**
	 * 删除Developer功能
	 */
	@Override
	public int deleteDeveloper(String devId) {	
		return developerMapper.deleteByPrimaryKey(devId);
	}
	
	/**
	 * 更改信息功能
	 */
	@Override
	public int updateDeveloper(Developer developer) {
		return developerMapper.updateByPrimaryKeySelective(developer);
	}

	@Override
	public Developer selectDeveloperById(String devId) {
		return developerMapper.selectByPrimaryKey(devId);
	}
	
	@Override
	public Developer selectDevByIdExist(String devId) {
		return developerMapper.selectDevByIdExist(devId);
	}
	
	@Override
	public Developer selectOneDeveloper(Developer developer) {
		return developerMapper.selectOneDeveloper(developer);
	}

	@Override
	public List<Developer> selectDeveloper(Developer developer) {
			
			DeveloperExample developerExample = new DeveloperExample();
			Criteria createCriteria = developerExample.createCriteria();
			
			// 根据id查询
			if (developer.getDevId() != null && developer.getDevId().length()!=0) {
				createCriteria.andDevIdEqualTo(developer.getDevId());
			}
			// 根据真实姓名查询
			if (developer.getDevTruename() != null && developer.getDevTruename().length()!=0) {
				createCriteria.andDevTruenameEqualTo(developer.getDevTruename());
			}
			//根据所在地来查询
			if(developer.getDevLocation() != null && developer.getDevLocation().length()!=0){
				createCriteria.andDevLocationEqualTo(developer.getDevLocation());
			}
			//根据特长来查询
			if(developer.getDevSpeciality() != null && developer.getDevSpeciality().length()!=0){
				createCriteria.andDevSpecialityLike("%"+developer.getDevSpeciality()+"%");
			}
			//根据学号来查询
			if(developer.getDevNumber() !=null && developer.getDevNumber().length()!=0){
				createCriteria.andDevNumberEqualTo(developer.getDevNumber());
			}
			//根据学校来查询
			if(developer.getDevSchool() !=null && developer.getDevSchool().length()!=0){
				createCriteria.andDevSchoolEqualTo(developer.getDevSchool());
			}
			//根据电话来查找
			if(developer.getDevPhone() !=null && developer.getDevPhone().length()!=0){
				createCriteria.andDevPhoneEqualTo(developer.getDevPhone());
			}
			//根据是否实名认证查找
			if(developer.getDevTrue() !=null){
				createCriteria.andDevTrueEqualTo(developer.getDevTrue());
			}
			// 根据用户姓名查询
			if (developer.getDevName() != null && developer.getDevName().length()!=0) {
				createCriteria.andDevNameEqualTo(developer.getDevName());
			}
			// 根据用户是否已注销账户
			if (developer.getDevCancellation() != null) {
				createCriteria.andDevCancellationEqualTo(developer.getDevCancellation());
			}else{
				createCriteria.andDevCancellationEqualTo(0);
			}

			if (developer.getOrderByClause() != null) {
				Integer orderByClause = developer.getOrderByClause();
				switch (orderByClause){
					case 1:
						developerExample.setOrderByClause("dev_praise ASC");
						break;
					case 2:
						developerExample.setOrderByClause("dev_praise DESC");
						break;
					case 3:
						developerExample.setOrderByClause("dev_registime ASC");
						break;
					case 4:
						developerExample.setOrderByClause("dev_registime DESC");
						break;
					case 5:
						developerExample.setOrderByClause("dev_cancellationtime ASC");
						break;
					case 6:
						developerExample.setOrderByClause("dev_cancellationtime DESC");
						break;
				}
			}
			//如果前面developerExample里面的属性没有别赋值,则查询全部
			return developerMapper.selectByExampleWithBLOBs(developerExample);
	}
	
	@Override
	public int countDevelpor(Developer developer) {
		
		DeveloperExample developerExample = new DeveloperExample();
		Criteria createCriteria = developerExample.createCriteria();

		// 根据id查询
		if (developer.getDevId() != null && developer.getDevId().length()!=0) {
			createCriteria.andDevIdEqualTo(developer.getDevId());
		}
		// 根据真实姓名查询
		if (developer.getDevTruename() != null && developer.getDevTruename().length()!=0) {
			createCriteria.andDevTruenameEqualTo(developer.getDevTruename());
		}
		//根据所在地来查询
		if(developer.getDevLocation() != null && developer.getDevLocation().length()!=0){
			createCriteria.andDevLocationEqualTo(developer.getDevLocation());
		}
		//根据特长来查询
		if(developer.getDevSpeciality() != null && developer.getDevSpeciality().length()!=0){
			createCriteria.andDevSpecialityLike("%"+developer.getDevSpeciality()+"%");
		}
		//根据学号来查询
		if(developer.getDevNumber() !=null && developer.getDevNumber().length()!=0){
			createCriteria.andDevNumberEqualTo(developer.getDevNumber());
		}
		//根据学校来查询
		if(developer.getDevSchool() !=null && developer.getDevSchool().length()!=0){
			createCriteria.andDevSchoolEqualTo(developer.getDevSchool());
		}
		//根据电话来查找
		if(developer.getDevPhone() !=null && developer.getDevPhone().length()!=0){
			createCriteria.andDevPhoneEqualTo(developer.getDevPhone());
		}
		//根据是否实名认证查找
		if(developer.getDevTrue() !=null){
			createCriteria.andDevTrueEqualTo(developer.getDevTrue());
		}
		// 根据用户姓名查询
		if (developer.getDevName() != null && developer.getDevName().length()!=0) {
			createCriteria.andDevNameEqualTo(developer.getDevName());
		}
		// 根据用户是否已注销账户
		if (developer.getDevCancellation() != null) {
			createCriteria.andDevCancellationEqualTo(developer.getDevCancellation());
		}else{
			createCriteria.andDevCancellationEqualTo(0);
		}
		
		return developerMapper.countByExample(developerExample);
	}

	@Override
	public int updateByExampleSelective(Developer developer,String developerId) {
		DeveloperExample developerExample = new DeveloperExample();
		Criteria createCriteria = developerExample.createCriteria();

		// 根据id改信息
		if (developer.getDevId() != null && developer.getDevId().length()!=0) {
			createCriteria.andDevIdEqualTo(developerId);
		}
		
		return developerMapper.updateByExampleSelective(developer, developerExample);
	}

}
