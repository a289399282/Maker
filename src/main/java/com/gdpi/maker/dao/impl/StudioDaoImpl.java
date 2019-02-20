package com.gdpi.maker.dao.impl;

import java.net.CacheRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gdpi.maker.dao.StudioDao;
import com.gdpi.maker.mapper.StudioMapper;
import com.gdpi.maker.pojo.Studio;
import com.gdpi.maker.pojo.StudioExample;
import com.gdpi.maker.pojo.StudioExample.Criteria;

@Repository
public class StudioDaoImpl implements StudioDao {
	@Autowired
	private StudioMapper studioMapper;

	@Override
	public int insertStudio(Studio studio) {
		return studioMapper.insertSelective(studio);
	}

	@Override
	public int deleteStudio(String stuId) {	
		return studioMapper.deleteByPrimaryKey(stuId);
	}

	@Override
	public int updateStudio(Studio studio) {
		return studioMapper.updateByPrimaryKeySelective(studio);
	}
	
	@Override
	public List<Studio> selectStudio(Studio studio) {
		StudioExample studioExample=new StudioExample();
		Criteria criteria = studioExample.createCriteria();
		//根据工作室Id
		if (studio.getStuId() != null) {
			criteria.andStuIdEqualTo(studio.getStuId());
		}

		//根据负责人id查询
		if(studio.getDevId()!=null && studio.getDevId().length()!=0){
			criteria.andDevIdEqualTo(studio.getDevId());
		}
		//根据工作室名字查询
		if(studio.getStuName()!=null && studio.getStuName().length()!=0){
			criteria.andStuNameLike("%"+studio.getStuName()+"%");
		}
		//根据工作室特长查询
		if(studio.getStuSpeciality()!=null&& studio.getStuSpeciality().length()!=0){
			criteria.andStuSpecialityLike("%"+studio.getStuSpeciality()+"%");
		}
		//根据工作室所在地查询
		if(studio.getStuLocation()!=null && studio.getStuLocation().length()!=0){
			criteria.andStuLocationLike("%"+studio.getStuLocation()+"%");
		}
		//电话
		if (studio.getStuPhone() != null) {
			criteria.andStuPhoneEqualTo(studio.getStuPhone());
		}
		//邮箱
		if (studio.getStuEmail() != null) {
			criteria.andStuEmailEqualTo(studio.getStuEmail());
		}
		//状态
		if (studio.getStuStart()!=null){
			criteria.andStuStartEqualTo(studio.getStuStart());
		}else{
			criteria.andStuStartEqualTo(1);
		}
		//排序升降
		if (studio.getOrderByClause() != null) {
			Integer orderByClause = studio.getOrderByClause();
			switch (orderByClause){
				//好评数
				case 1:
					studioExample.setOrderByClause("stu_praise ASC");
					break;
				case 2:
					studioExample.setOrderByClause("stu_praise DESC");
					break;
					//创建时间
				case 3:
					studioExample.setOrderByClause("stu_registime ASC");
					break;
				case 4:
					studioExample.setOrderByClause("stu_registime DESC");
					break;
			}
		}
		return studioMapper.selectByExampleWithBLOBs(studioExample);
		
	}

	/*@Override
	public Studio selectOneStudio(Studio studio) {
		return studioMapper.selectOneStudio(studio);
	}
	*/

	@Override
	public Studio selectStuByIdExist(String stuId) {
		return studioMapper.selectStuByIdExist(stuId);
	}
	
	@Override
	public Studio selectStudioById(String stuId) {
		return studioMapper.selectByPrimaryKey(stuId);
	}
	
}
