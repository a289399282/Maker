package com.gdpi.maker.mapper;

import com.gdpi.maker.pojo.Forumimg;
import com.gdpi.maker.pojo.ForumimgExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ForumimgMapper {
    int countByExample(ForumimgExample example);

    int deleteByExample(ForumimgExample example);

    int deleteByPrimaryKey(String imgId);

    int insert(Forumimg record);

    int insertSelective(Forumimg record);

    List<Forumimg> selectByExample(ForumimgExample example);

    Forumimg selectByPrimaryKey(String imgId);

    int updateByExampleSelective(@Param("record") Forumimg record, @Param("example") ForumimgExample example);

    int updateByExample(@Param("record") Forumimg record, @Param("example") ForumimgExample example);

    int updateByPrimaryKeySelective(Forumimg record);

    int updateByPrimaryKey(Forumimg record);
}