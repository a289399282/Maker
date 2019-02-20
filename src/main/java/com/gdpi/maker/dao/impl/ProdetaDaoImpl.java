package com.gdpi.maker.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gdpi.maker.dao.ProdetaDao;
import com.gdpi.maker.mapper.ProdetaMapper;
import com.gdpi.maker.pojo.Prodeta;
import com.gdpi.maker.pojo.ProdetaExample;
import com.gdpi.maker.pojo.ProdetaExample.Criteria;

@Repository
public class ProdetaDaoImpl implements ProdetaDao {
	@Autowired
	private ProdetaMapper prodetaMapper;

	@Override
	public int insertPrde(String proId, String prdeIswin) {
		if (proId.length() != 0 && proId != null && prdeIswin.length() != 0 && prdeIswin != null) {
			//设置属性
			Prodeta prodeta=new Prodeta();
			prodeta.setPrdeIswin(prdeIswin);
			prodeta.setProId(proId);
			//添加
			return prodetaMapper.insertSelective(prodeta);
		}
		return 0;
	}

	@Override
	public int deletePrde(String proId, String prdeIswin) {
		if (proId.length() != 0 && proId != null && prdeIswin.length() != 0 && prdeIswin != null) {
			//设置属性
			ProdetaExample prodetaExample=new ProdetaExample();
			Criteria create = prodetaExample.createCriteria();
			create.andPrdeIswinEqualTo(prdeIswin);
			create.andProIdEqualTo(proId);
			//删除
			return prodetaMapper.deleteByExample(prodetaExample);
		}
		return 0;
	}

	@Override
	public int updatePrde(Prodeta prodeta) {
		if (prodeta.getProId().length() != 0 && prodeta.getProId() != null && prodeta.getPrdeIswin().length() != 0 && prodeta.getPrdeIswin() != null) {
			
			ProdetaExample prodetaExample=new ProdetaExample();
			Criteria create = prodetaExample.createCriteria();
			create.andPrdeIswinEqualTo(prodeta.getPrdeIswin());
			create.andProIdEqualTo(prodeta.getProId());
			//这些属性必须要变设置为null
			prodeta.setPrdeIswin(null);
			prodeta.setProId(null);
			
			return prodetaMapper.updateByExampleSelective(prodeta, prodetaExample);
		}
		return 0;
	}

	@Override
	public List<Prodeta> selectPrde(Prodeta prodeta) {
		
		ProdetaExample prodetaExample=new ProdetaExample();
		Criteria create = prodetaExample.createCriteria();
		
		//按项目Id来查询
		if (prodeta.getProId() != null && prodeta.getProId().length() != 0 ){
			create.andProIdEqualTo(prodeta.getProId());
		}
		//按竞标成功者Id来查询
		if(prodeta.getPrdeIswin() != null&& prodeta.getPrdeIswin().length() != 0 ) {
			create.andPrdeIswinEqualTo(prodeta.getPrdeIswin());
		}
		//按项目状态来查询
		if(prodeta.getPrdeState()!=null){
			create.andPrdeStateEqualTo(prodeta.getPrdeState());
		}

		if (prodeta.getOrderByClause() != null) {
			Integer orderByClause = prodeta.getOrderByClause();
			switch (orderByClause){
				case 1:
					prodetaExample.setOrderByClause("prde_rectime ASC");
					break;
				case 2:
					prodetaExample.setOrderByClause("prde_rectime DESC");
					break;
				case 3:
					prodetaExample.setOrderByClause("prde_comtime ASC");
					break;
				case 4:
					prodetaExample.setOrderByClause("prde_comtime DESC");
					break;
			}
		}
		
		return prodetaMapper.selectByExample(prodetaExample);
	}

	@Override
	public Prodeta selectOneProdeta(Prodeta prodeta) {
		return prodetaMapper.selectOneProdeta(prodeta);
	}
}
