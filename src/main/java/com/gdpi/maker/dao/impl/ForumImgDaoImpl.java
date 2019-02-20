package com.gdpi.maker.dao.impl;

import com.gdpi.maker.dao.ForumImgDao;
import com.gdpi.maker.mapper.ForumimgMapper;
import com.gdpi.maker.pojo.Forumimg;
import com.gdpi.maker.pojo.ForumimgExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ForumImgDaoImpl implements ForumImgDao {
    @Autowired
    private ForumimgMapper forumimgMapper;

    @Override
    public int insertForumimg(Forumimg forumimg) {
        return forumimgMapper.insertSelective(forumimg);
    }

    @Override
    public int deleteForumimg(String forumimgId) {
        return forumimgMapper.deleteByPrimaryKey(forumimgId);
    }

    @Override
    public int updateForumimg(Forumimg forumimg) {
        return forumimgMapper.updateByPrimaryKeySelective(forumimg);
    }

    @Override
    public List<Forumimg> selectForumimg(Forumimg forumimg) {
        ForumimgExample forumimgExample=new ForumimgExample();
        ForumimgExample.Criteria criteria = forumimgExample.createCriteria();

        //发布人
        if (forumimg.getImgAuthorid() != null) {
            criteria.andImgAuthoridEqualTo(forumimg.getImgAuthorid());
        }
        //图片Id
        if (forumimg.getImgId() != null) {
            criteria.andImgIdEqualTo(forumimg.getImgId());
        }
        //图片状态
        if (forumimg.getImgStart() != null) {
            criteria.andImgStartEqualTo(forumimg.getImgStart());
        }
        return forumimgMapper.selectByExample(forumimgExample);
    }

    @Override
    public Forumimg selectForumimgById(String forumimgId) {
        return forumimgMapper.selectByPrimaryKey(forumimgId);
    }
}
