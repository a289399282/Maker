package com.gdpi.maker.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gdpi.maker.dao.StudiomemDao;
import com.gdpi.maker.mapper.StudiomemMapper;
import com.gdpi.maker.pojo.Studiomem;
import com.gdpi.maker.pojo.StudiomemExample;
import com.gdpi.maker.pojo.StudiomemExample.Criteria;

@SuppressWarnings("Duplicates")
@Repository
public class StudiomemDaoImpl implements StudiomemDao {
	@Autowired
	private StudiomemMapper studiomemMapper;
	
	@Override
	public int insertStudiomem(Studiomem studiomem) {
		return studiomemMapper.insertSelective(studiomem);
	}

	@Override
	public int deleteStudiomem(String stuId,String devId) {
		
		if(stuId!=null&&stuId.length()!=0&&devId!=null&&devId.length()!=0){
			StudiomemExample studiomemExample=new StudiomemExample();
			Criteria criteria = studiomemExample.createCriteria();
			criteria.andDevIdEqualTo(devId);
			criteria.andStuIdEqualTo(stuId);
			//criteria.andStumemSumEqualTo(studiomem.getStumemSum());
			return studiomemMapper.deleteByExample(studiomemExample);
		}
		return 0;
	}

	@Override
	public int updateStudiomem(Studiomem studiomem) {
		if(studiomem.getDevId()!=null && studiomem.getDevId().length()!=0 && studiomem.getStuId()!=null && studiomem.getStuId().length()!=0){
			//studiomem.setDevId(null);
			//studiomem.setStuId(null);

			//条件(是相当于SQL语句的where后面的条件)
			StudiomemExample studiomemExample=new StudiomemExample();
			Criteria criteria = studiomemExample.createCriteria();
			criteria.andDevIdEqualTo(studiomem.getDevId());
			criteria.andStuIdEqualTo(studiomem.getStuId());
			criteria.andStumemSumEqualTo(studiomem.getStumemSum());
			
			return studiomemMapper.updateByExampleSelective(studiomem, studiomemExample);
		}
		return 0;
	}

	@Override
	public Studiomem selectOneStudiomem(Studiomem studiomem) {
		return studiomemMapper.selectOneStudiomem(studiomem);
	}

	/*@Override
	public List<Studiomem> selectStudiomem(Studiomem studiomem) {

		StudiomemExample studiomemExample=new StudiomemExample();
		Criteria criteria = studiomemExample.createCriteria();
		//用户ID
		if(studiomem.getDevId()!=null && studiomem.getDevId().length()!=0){
			criteria.andDevIdEqualTo(studiomem.getDevId());
		}
		//工作室Id
		if(studiomem.getStuId()!=null && studiomem.getStuId().length()!=0){
			criteria.andStuIdEqualTo(studiomem.getStuId());
		}
		//根据是否是已成为工作室成员查询
		if(studiomem.getStumemIs()!=null){
			criteria.andStumemIsEqualTo(studiomem.getStumemIs());
		}
		//根据权限来查询
		if(studiomem.getStumemPower()!=null){
			criteria.andStumemPowerEqualTo(studiomem.getStumemPower());
		}
		//标识码
		if (studiomem.getStumemSum() != null) {
			criteria.andStumemSumEqualTo(studiomem.getStumemSum());
		}

		//升降
		if (studiomem.getOrderByClause() != null) {
			Integer orderByClause = studiomem.getOrderByClause();
			switch (orderByClause){
				case 1:
					studiomemExample.setOrderByClause("stumem_power ASC");
					break;
				case 2:
					studiomemExample.setOrderByClause("stumem_power DESC");
					break;
				case 3:
					studiomemExample.setOrderByClause("stumem_time ASC");
					break;
				case 4:
					studiomemExample.setOrderByClause("stumem_time DESC");
					break;
				case 5:
					studiomemExample.setOrderByClause("stumem_registime ASC");
					break;
				case 6:
					studiomemExample.setOrderByClause("stumem_registime DESC");
					break;
			}
		}
		return studiomemMapper.selectByExample(studiomemExample);	
	}*/

	@Override
	public List<Studiomem> selectStudiomemMe(Studiomem studiomem) {

		StudiomemExample studiomemExample=new StudiomemExample();
		Criteria criteria = studiomemExample.createCriteria();
		//用户申请Id
		if(studiomem.getDevId()!=null && studiomem.getDevId().length()!=0){
			criteria.andDevIdEqualTo(studiomem.getDevId());
		}
		//工作室Id
		if(studiomem.getStuId()!=null && studiomem.getStuId().length()!=0){
			criteria.andStuIdEqualTo(studiomem.getStuId());
		}

		//根据是否是已成为工作室成员查询
		//criteria.andStumemIsBetween(0,2);
		if(studiomem.getStumemIs()!=null){
			criteria.andStumemIsEqualTo(studiomem.getStumemIs());
		}

		//根据权限来查询
		if(studiomem.getStumemPower()!=null){
			criteria.andStumemPowerEqualTo(studiomem.getStumemPower());
		}
		//标识码
		if (studiomem.getStumemSum() != null) {
			criteria.andStumemSumEqualTo(studiomem.getStumemSum());
		}

		//升降
		if (studiomem.getOrderByClause() != null) {
			Integer orderByClause = studiomem.getOrderByClause();
			switch (orderByClause){
				case 1:
					studiomemExample.setOrderByClause("stumem_power ASC");
					break;
				case 2:
					studiomemExample.setOrderByClause("stumem_power DESC");
					break;
				case 3:
					studiomemExample.setOrderByClause("stumem_time ASC");
					break;
				case 4:
					studiomemExample.setOrderByClause("stumem_time DESC");
					break;
				case 5:
					studiomemExample.setOrderByClause("stumem_registime ASC");
					break;
				case 6:
					studiomemExample.setOrderByClause("stumem_registime DESC");
					break;
			}
		}

		return studiomemMapper.selectByExample(studiomemExample);
	}

	@Override
	public List<Studiomem> selectStudiomemAll(Studiomem studiomem) {
		StudiomemExample studiomemExample=new StudiomemExample();
		Criteria criteria = studiomemExample.createCriteria();
		//用户ID
		if(studiomem.getDevId()!=null && studiomem.getDevId().length()!=0){
			criteria.andDevIdEqualTo(studiomem.getDevId());
		}
		//工作室Id
		if(studiomem.getStuId()!=null && studiomem.getStuId().length()!=0){
			criteria.andStuIdEqualTo(studiomem.getStuId());
		}
		//根据是否是已成为工作室成员查询
		if(studiomem.getStumemIs()!=null){
			criteria.andStumemIsEqualTo(studiomem.getStumemIs());
		}
		//根据权限来查询
		if(studiomem.getStumemPower()!=null){
			criteria.andStumemPowerEqualTo(studiomem.getStumemPower());
		}
		//标识码
		if (studiomem.getStumemSum() != null) {
			criteria.andStumemSumEqualTo(studiomem.getStumemSum());
		}

		//升降
		if (studiomem.getOrderByClause() != null) {
			Integer orderByClause = studiomem.getOrderByClause();
			switch (orderByClause){
				case 1:
					studiomemExample.setOrderByClause("stumem_power ASC");
					break;
				case 2:
					studiomemExample.setOrderByClause("stumem_power DESC");
					break;
				case 3:
					studiomemExample.setOrderByClause("stumem_time ASC");
					break;
				case 4:
					studiomemExample.setOrderByClause("stumem_time DESC");
					break;
				case 5:
					studiomemExample.setOrderByClause("stumem_registime ASC");
					break;
				case 6:
					studiomemExample.setOrderByClause("stumem_registime DESC");
					break;
			}
		}

		return studiomemMapper.selectByExample(studiomemExample);
	}



}
