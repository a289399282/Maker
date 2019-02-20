package com.gdpi.maker.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gdpi.maker.dao.PositionDao;
import com.gdpi.maker.mapper.PositionMapper;
import com.gdpi.maker.pojo.Position;
import com.gdpi.maker.pojo.PositionExample;
import com.gdpi.maker.pojo.PositionExample.Criteria;

@Repository
public class PositionDaoImpl implements PositionDao {
	@Autowired
	private PositionMapper positionMapper;
	
	@Override
	public int insertPosition(Position position) {
		return positionMapper.insertSelective(position);
	}

	@Override
	public int deletePosition(String positionId) {
		return positionMapper.deleteByPrimaryKey(positionId);
	}

	@Override
	public int updatePosition(Position position) {
		return positionMapper.updateByPrimaryKeySelective(position);
	}

	@Override
	public List<Position> selectPosition(Position position) {
		PositionExample positionExample=new PositionExample();
		Criteria criteria = positionExample.createCriteria();
		
		//职位Id
		if (position.getPositionId()!=null && position.getPositionId().length()!=0) {
			criteria.andPositionIdEqualTo(position.getPositionId());
		}
		//职位名称
		if (position.getPositionName()!=null && position.getPositionName().length()!=0) {
			criteria.andPositionNameLike("%"+position.getPositionName()+"%");
		}
		//发布人
		if (position.getPositionmemId()!=null && position.getPositionmemId().length()!=0) {
			criteria.andPositionmemIdEqualTo(position.getPositionmemId());
		}
		//职位状态码
		if (position.getPositionState()!=null) {
			criteria.andPositionStateEqualTo(position.getPositionState());
		}else{
			criteria.andPositionStateNotEqualTo(1);
		}
		//结束时间
		if (position.getPositionEndtime()!=null) {
			criteria.andPositionEndtimeLessThanOrEqualTo(position.getPositionEndtime());
		}
		//开始时间
		if (position.getPositionReltime()!=null) {
			criteria.andPositionReltimeGreaterThanOrEqualTo(position.getPositionReltime());
		}
		if (position.getPositionType() != null) {
			criteria.andPositionTypeLike("%"+position.getPositionType()+"%");
		}

		if (position.getOrderByClause() != null) {
			Integer orderByClause = position.getOrderByClause();
			switch (orderByClause){
				case 1:
					positionExample.setOrderByClause("position_heat ASC");
					break;
				case 2:
					positionExample.setOrderByClause("position_heat DESC");
					break;
				case 3:
					positionExample.setOrderByClause("position_endtime ASC");
					break;
				case 4:
					positionExample.setOrderByClause("position_endtime DESC");
					break;
				case 5:
					positionExample.setOrderByClause("position_reltime DESC");
					break;
				case 6:
					positionExample.setOrderByClause("position_reltime DESC");
					break;
			}
		}

		return positionMapper.selectByExampleWithBLOBs(positionExample);
	}

	@Override
	public Position selectOnePosition(Position position) {
		return positionMapper.selectOnePosition(position);
	}

	@Override
	public Position selectPositionById(String positionId) {
		return positionMapper.selectByPrimaryKey(positionId);
	}
	
	@Override
	public Position selectPosByIdExist(String positionId) {
		return positionMapper.selectPosByIdExist(positionId);
	}

	@Override
	public int countByExample(Position position) {
		PositionExample positionExample=new PositionExample();
		Criteria criteria = positionExample.createCriteria();
		
		//职位Id
		if (position.getPositionId()!=null && position.getPositionId().length()!=0) {
			criteria.andPositionIdEqualTo(position.getPositionId());
		}
		//职位名称
		if (position.getPositionName()!=null && position.getPositionName().length()!=0) {
			criteria.andPositionNameLike("%"+position.getPositionName()+"%");
		}
		//发布人
		if (position.getPositionmemId()!=null && position.getPositionmemId().length()!=0) {
			criteria.andPositionmemIdEqualTo(position.getPositionmemId());
		}
		//职位状态码
		if (position.getPositionState()!=null) {
			criteria.andPositionStateEqualTo(position.getPositionState());
		}
		//结束时间
		if (position.getPositionEndtime()!=null) {
			criteria.andPositionEndtimeLessThanOrEqualTo(position.getPositionEndtime());
		}
		//开始时间
		if (position.getPositionReltime()!=null) {
			criteria.andPositionReltimeGreaterThanOrEqualTo(position.getPositionReltime());
		}
		return positionMapper.countByExample(positionExample);
	}
}
