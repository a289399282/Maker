package com.gdpi.maker.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gdpi.maker.dao.ForumDao;
import com.gdpi.maker.mapper.ForumMapper;
import com.gdpi.maker.pojo.Forum;
import com.gdpi.maker.pojo.ForumExample;
import com.gdpi.maker.pojo.ForumExample.Criteria;
import com.gdpi.maker.pojo.ForumWithBLOBs;

@Repository
public class ForumDaoImpl implements ForumDao {
	@Autowired
	private ForumMapper forumMapper;
	
	@Override
	public int addForum(ForumWithBLOBs forumWithBLOBs) {
		return forumMapper.insertSelective(forumWithBLOBs);
		
	}

	@Override
	public int deleteForum(String forumId) {
		return forumMapper.deleteByPrimaryKey(forumId);
		
	}

	@Override
	public int updateForum(ForumWithBLOBs forumWithBLOBs) {
		ForumExample forumExample=new ForumExample();
		Criteria criteria = forumExample.createCriteria();
		//根据作品id
		if(forumWithBLOBs.getForumId()!=null && forumWithBLOBs.getForumId().length()!=0){
			criteria.andForumIdEqualTo(forumWithBLOBs.getForumId());
		}
		//根据视频或是文字作品
		if(forumWithBLOBs.getForumWhat()!=null){
			criteria.andForumWhatEqualTo(forumWithBLOBs.getForumWhat());
		}
		//根据作者id
		if(forumWithBLOBs.getForummemId()!=null && forumWithBLOBs.getForummemId().length()!=0){
			criteria.andForummemIdEqualTo(forumWithBLOBs.getForummemId());
		}
		//根据作品类型
		if(forumWithBLOBs.getForumType()!=null && forumWithBLOBs.getForumType().length()!=0){
			criteria.andForumTypeEqualTo(forumWithBLOBs.getForumType());
		}

		return forumMapper.updateByExampleSelective(forumWithBLOBs, forumExample);

	}

	@Override
	public ForumWithBLOBs selectOneForum(Forum forum) {
		return forumMapper.selectOneForum(forum);
	}
	
	@Override
	public List<ForumWithBLOBs> selectForum(ForumWithBLOBs forumWithBLOBs) {
		ForumExample forumExample=new ForumExample();
		Criteria criteria = forumExample.createCriteria();
		//根据作品id查
		if(forumWithBLOBs.getForumId()!=null && forumWithBLOBs.getForumId().length()!=0){
			criteria.andForumIdEqualTo(forumWithBLOBs.getForumId());
		}
		//根据视频或是文字作品
		if(forumWithBLOBs.getForumWhat()!=null){
			criteria.andForumWhatEqualTo(forumWithBLOBs.getForumWhat());
		}
		//根据作者id查
		if(forumWithBLOBs.getForummemId()!=null && forumWithBLOBs.getForummemId().length()!=0){
			criteria.andForummemIdEqualTo(forumWithBLOBs.getForummemId());
		}
		//根据标题模糊搜
		if(forumWithBLOBs.getForumName()!=null && forumWithBLOBs.getForumName().length()!=0){
			criteria.andForumNameLike("%"+forumWithBLOBs.getForumName()+"%");
		}
		//根据作品类型搜
		if(forumWithBLOBs.getForumType()!=null){
			criteria.andForumTypeLike("%"+forumWithBLOBs.getForumType()+"%");
		}
		//转发Id查
		if (forumWithBLOBs.getForumForid() != null && forumWithBLOBs.getForumForid().length() != 0) {
			criteria.andForumForidEqualTo(forumWithBLOBs.getForumForid());
		}
		//根据作品状态搜
		if (forumWithBLOBs.getForumStart() != null) {
			criteria.andForumStartEqualTo(forumWithBLOBs.getForumStart());
		}else{
			criteria.andForumStartNotEqualTo(2);
		}

		if (forumWithBLOBs.getOrderByClause() != null) {
			Integer orderByClause = forumWithBLOBs.getOrderByClause();
			switch (orderByClause){
				//热度
				case 1:
					forumExample.setOrderByClause("forum_heat ASC");
					break;
				case 2:
					forumExample.setOrderByClause("forum_heat DESC");
					break;
					//上传时间
				case 3:
					forumExample.setOrderByClause("forum_reltime ASC");
					break;
				case 4:
					forumExample.setOrderByClause("forum_reltime DESC");
					break;
			}
		}

		List<ForumWithBLOBs> list = forumMapper.selectByExampleWithBLOBs(forumExample);
		return list;

	}

	@Override
	public ForumWithBLOBs selectByPrimaryKey(String forumId) {
		return forumMapper.selectByPrimaryKey(forumId);
	}

	@Override
	public int countByExample(Forum forum) {
		ForumExample forumExample=new ForumExample();
		Criteria criteria = forumExample.createCriteria();
		//根据作品id查
		if(forum.getForumId()!=null && forum.getForumId().length()!=0){
			criteria.andForumForidEqualTo(forum.getForumId());
		}
		//根据视频或是文字作品
		if(forum.getForumWhat()!=null){
			criteria.andForumWhatEqualTo(forum.getForumWhat());
		}
		//根据作者id查
		if(forum.getForummemId()!=null && forum.getForummemId().length()!=0){
			criteria.andForumForidEqualTo(forum.getForummemId());
		}
		//根据标题模糊搜
		if(forum.getForumName()!=null && forum.getForumName().length()!=0){
			criteria.andForumNameLike("%"+forum.getForumName()+"%");
		}
		//根据作品状态搜
		if(forum.getForumStart()!=null){
			criteria.andForumStartEqualTo(forum.getForumStart());
		}
		//根据作品类型搜
		if(forum.getForumType()!=null){
			criteria.andForumTypeLike("%"+forum.getForumType()+"%");
		}
		//转发Id查
		if (forum.getForumForid() != null && forum.getForumForid().length() != 0) {
			criteria.andForumForidEqualTo(forum.getForumForid());
		}
		return forumMapper.countByExample(forumExample);
	}
}
