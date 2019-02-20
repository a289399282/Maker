package com.gdpi.maker.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gdpi.maker.dao.PositionmemDao;
import com.gdpi.maker.mapper.PositionmemMapper;
import com.gdpi.maker.pojo.Positionmem;
import com.gdpi.maker.pojo.PositionmemExample;
import com.gdpi.maker.pojo.PositionmemExample.Criteria;

@Repository
public class PositionmemDaoImpl implements PositionmemDao {
	@Autowired
	private PositionmemMapper positionmemMapper;
	
	@Override
	public int insertPositionmem(Positionmem positionmem) {
		return positionmemMapper.insertSelective(positionmem);
	}

	@Override
	public int deletePositionmem(String positionId,String positionmemId) {
		PositionmemExample example=new PositionmemExample();
		Criteria criteria = example.createCriteria();
		criteria.andPositionIdEqualTo(positionId);
		criteria.andPositionmemIdEqualTo(positionmemId);
		return positionmemMapper.deleteByExample(example);
	}

	@Override
	public int updatePositionnem(Positionmem positionmem) {
		PositionmemExample example=new PositionmemExample();
		Criteria criteria = example.createCriteria();
		criteria.andPositionIdEqualTo(positionmem.getPositionId());
		criteria.andPositionmemIdEqualTo(positionmem.getPositionmemId());
		criteria.andPositionmenSumEqualTo(positionmem.getPositionmenSum());
		return positionmemMapper.updateByExampleSelective(positionmem, example);
	}

	@Override
	public List<Positionmem> selectPositionmem(Positionmem positionmem) {
		PositionmemExample positionmemExample=new PositionmemExample();
		Criteria criteria = positionmemExample.createCriteria();
		
		//职位Id
		if (positionmem.getPositionmemId()!=null && positionmem.getPositionmemId().length()!=0) {
			criteria.andPositionmemIdEqualTo(positionmem.getPositionmemId());
		}
		//职位名称
		if (positionmem.getPositionId()!=null && positionmem.getPositionId().length()!=0) {
			criteria.andPositionIdEqualTo(positionmem.getPositionId());
		}
		//发布人
		if (positionmem.getPositionmemId()!=null && positionmem.getPositionmemId().length()!=0) {
			criteria.andPositionmemIdEqualTo(positionmem.getPositionmemId());
		}
		//职位状态码
		if (positionmem.getPositionmemState()!=null) {
			criteria.andPositionmemStateEqualTo(positionmem.getPositionmemState());
		}else{
			criteria.andPositionmemStateNotEqualTo(0);
		}

		if (positionmem.getOrderByClause() != null) {
			Integer orderByClause = positionmem.getOrderByClause();
			switch (orderByClause){
				case 1:
					positionmemExample.setOrderByClause("positionmen_time ASC");
					break;
				case 2:
					positionmemExample.setOrderByClause("positionmen_time DESC");
					break;
				case 3:
					positionmemExample.setOrderByClause("positionmen_reltime ASC");
					break;
				case 4:
					positionmemExample.setOrderByClause("positionmen_reltime DESC");
					break;
				case 5:
					positionmemExample.setOrderByClause("positionmen_endime ASC");
					break;
				case 6:
					positionmemExample.setOrderByClause("positionmen_endime DESC");
					break;
			}
		}

		return positionmemMapper.selectByExample(positionmemExample);
	}

	@Override
	public Positionmem selectOnePositionmem(Positionmem positionmem) {
		return positionmemMapper.selectOnePositionmem(positionmem);
	}

	@Override
	public Positionmem selectPositionmemById(String positionId, String positionmemId) {
		Positionmem positionmem=new Positionmem();
		positionmem.setPositionId(positionId);
		positionmem.setPositionmemId(positionmemId);
		return positionmemMapper.selectOnePositionmem(positionmem);
	}

}
