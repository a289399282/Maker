package com.gdpi.maker.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gdpi.maker.dao.TypeDao;
import com.gdpi.maker.mapper.TypeMapper;
import com.gdpi.maker.pojo.Type;
import com.gdpi.maker.pojo.TypeExample;
import com.gdpi.maker.pojo.TypeExample.Criteria;

@Repository
public class TypeDaoImpl implements TypeDao {
	@Autowired
	private TypeMapper typeMapper;
	
	@Override
	public int insertType(Type type) {
		return typeMapper.insertSelective(type);
	}

	@Override
	public int deleteType(String typeId) {
		return typeMapper.deleteByPrimaryKey(typeId);
	}

	@Override
	public int updateType(Type type) {
		return typeMapper.updateByPrimaryKey(type);
	}

	@Override
	public List<Type> selectType(Type type) {
		TypeExample typeExample=new TypeExample();
		Criteria criteria = typeExample.createCriteria();
		//类型Id
		if (type.getTpId()!=null) {
			criteria.andTpIdEqualTo(type.getTpId());
		}
		//类型名字
		if (type.getTpName()!=null) {
			criteria.andTpNameEqualTo(type.getTpName());
		}
		//职业名称
		if (type.getTpCareer()!=null) {
			criteria.andTpCareerEqualTo(type.getTpCareer());
		}
		
		if (type.getTpStyle()!=null) {
			criteria.andTpStyleEqualTo(type.getTpStyle());
		}
		
		List<Type> list = typeMapper.selectByExample(typeExample);
		return list;
	}

	@Override
	public int countByExample(Type type) {
		TypeExample typeExample=new TypeExample();
		Criteria criteria = typeExample.createCriteria();
		//类型Id
		if (type.getTpId()!=null) {
			criteria.andTpIdEqualTo(type.getTpId());
		}
		//类型名字
		if (type.getTpName()!=null) {
			criteria.andTpNameEqualTo(type.getTpName());
		}
		//职业名称
		if (type.getTpCareer()!=null) {
			criteria.andTpCareerEqualTo(type.getTpCareer());
		}
		
		if (type.getTpStyle()!=null) {
			criteria.andTpStyleEqualTo(type.getTpStyle());
		}
		
		return typeMapper.countByExample(typeExample);
	}

	@Override
	public Type selectTypeById(String typeId) {
		return typeMapper.selectByPrimaryKey(typeId);
	}

}
