package com.gdpi.maker.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gdpi.maker.dao.ProdetamemDao;
import com.gdpi.maker.mapper.ProdetamemMapper;
import com.gdpi.maker.pojo.Prodetamem;
import com.gdpi.maker.pojo.ProdetamemExample;
import com.gdpi.maker.pojo.ProdetamemExample.Criteria;

@Repository
public class ProdetamemDaoImpl implements ProdetamemDao {
	@Autowired
	private ProdetamemMapper prodetamemMapper;

	@Override
	public int insertProdetamem(Prodetamem prodetamem) {
			return prodetamemMapper.insertSelective(prodetamem);
	}

	@Override
	public int deleteProdetamem(Prodetamem prodetamem) {
		//设置条件
		ProdetamemExample prodetamemExample=new ProdetamemExample();
		Criteria criteria = prodetamemExample.createCriteria();
		criteria.andPrdememIdEqualTo(prodetamem.getPrdememId());
		criteria.andProIdEqualTo(prodetamem.getProId());
		criteria.andPrdememStateEqualTo(prodetamem.getPrdememSum());

		return prodetamemMapper.deleteByExample(prodetamemExample);
	}

	@Override
	public int updateProdetamem(Prodetamem prodetamem) {
		if(prodetamem.getProId()!=null && prodetamem.getProId().length()!=0 && prodetamem.getPrdememId()!=null && prodetamem.getPrdememId().length()!=0){

			//设置条件
			ProdetamemExample prodetamemExample=new ProdetamemExample();
			Criteria criteria = prodetamemExample.createCriteria();

			criteria.andPrdememIdEqualTo(prodetamem.getPrdememId());
			criteria.andProIdEqualTo(prodetamem.getProId());
			if (prodetamem.getPrdememSum() != null && prodetamem.getPrdememSum()!=0) {
				criteria.andPrdememSumEqualTo(prodetamem.getPrdememSum());
			}else if (prodetamem.getPrdememSum() == 0) {
				criteria.andPrdememStateEqualTo(1);
			}

			return prodetamemMapper.updateByExampleSelective(prodetamem, prodetamemExample);

		}
		return 0;
	}

	@Override
	public List<Prodetamem> selectProdetamem(Prodetamem prodetamem) {
		
		ProdetamemExample prodetamemExample=new ProdetamemExample();
		Criteria criteria = prodetamemExample.createCriteria();
		
		//根据项目id查询
		if(prodetamem.getProId()!=null && prodetamem.getProId().length()!=0){
			criteria.andProIdEqualTo(prodetamem.getProId());
		}
		//根据参加竞选的id查询
		if(prodetamem.getPrdememId() !=null && prodetamem.getPrdememId().length()!=0){
			criteria.andPrdememIdEqualTo(prodetamem.getPrdememId());
		}
		//根据参加竞选的状态查询
		if(prodetamem.getPrdememState() !=null){
			criteria.andPrdememStateEqualTo(prodetamem.getPrdememState());
		}
		//根据标识码
		if(prodetamem.getPrdememSum() !=null){
			criteria.andPrdememSumEqualTo(prodetamem.getPrdememSum());
		}

		//升降排序
		if (prodetamem.getOrderByClause() != null) {
			Integer orderByClause = prodetamem.getOrderByClause();
			switch (orderByClause){
				//prdemem_time竞标时间
				case 1:
					prodetamemExample.setOrderByClause("prdemem_time ASC");
					break;
				case 2:
					prodetamemExample.setOrderByClause("prdemem_time DESC");
			}
		}

		return prodetamemMapper.selectByExample(prodetamemExample);
	}

	@Override
	public Prodetamem selectOneProdetamem(Prodetamem prodetamem) {
		if (prodetamem.getPrdememState()==null){
			prodetamem.setPrdememState(1);
		}
		return prodetamemMapper.selectOneProdetamem(prodetamem);
	}
	@Override
	public Prodetamem selectOneProdetamem2(Prodetamem prodetamem) {
		return prodetamemMapper.selectOneProdetamem(prodetamem);
	}
}
